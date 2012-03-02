package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatastore;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.test.oval.core.TestBase;
import jp.go.aist.six.test.oval.core.XmlFilenameFilter;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



/**
 * Tests: MongoOvalDatastore.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalDatastoreTests
    extends TestBase
{

    private MongoOvalDatastore  _datastore;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _datastore = _getContext().getBean( MongoOvalDatastore.class );
	}


    protected MongoOvalDatastore _getDatastore()
    throws Exception
    {
        return _datastore;
    }



    /**
     */
    private <K, T extends Persistable<K>>
    void _saveObject(
                    final Class<T>  object_type,
                    final T         object,
                    final boolean   to_load
                    )
    throws Exception
    {
        _saveObject( object_type, object, to_load, true );
    }


    private <K, T extends Persistable<K>>
    void _saveObject(
                    final Class<T>  object_type,
                    final T         object,
                    final boolean   to_load,
                    final boolean   to_log
                    )
    throws Exception
    {
        if (to_log) {
            Reporter.log( "object type: " + object_type, true );
            Reporter.log( "save..." , true );
            Reporter.log( "  * object: " + object, true );
        }

        K  pid = _datastore.save( object_type, object );
        if (to_log) {
            Reporter.log( "  >>> object saved: PID=" + pid, true );
        }

        if (to_load) {
            if (to_log) {
                Reporter.log( "load object by PID...", true );
            }
            T  p_object = _datastore.findById( object_type, pid );
            if (to_log) {
                Reporter.log( "  @ object: " + p_object, true );
            }

            if (p_object instanceof OvalDefinitions) {
                OvalDefinitions  p_oval_defs = OvalDefinitions.class.cast( p_object );
                for (DefinitionType  p_def : p_oval_defs.getDefinitions().getDefinition()) {
                    if (to_log) {
                        Reporter.log( "  @ definition: " + p_def, true );
                    }
                }
            }
        }
    }


    private <K, T extends Persistable<K>>
    void _readFromFileAndSaveToDatastore(
                    final Class<T> object_type,
                    final String   xml_filepath,
                    final T        expected_object,
                    final boolean  to_load
                    )
    throws Exception
    {
        Reporter.log( "object type: " + object_type, true );

        T  object = _unmarshalObject( object_type, xml_filepath, expected_object );
        _saveObject( object_type, object, to_load );
    }



    private <K, T extends Persistable<K>>
    T _findObjectById(
                    final Class<T>  object_type,
                    final K         id,
                    final boolean   to_log
                    )
    throws Exception
    {
        if (to_log) {
            Reporter.log( "object type: " + object_type, true );
            Reporter.log( "find by ID..." , true );
            Reporter.log( "  * ID: " + id, true );
        }

        T  object = _datastore.findById( object_type, id );
        if (to_log) {
            Reporter.log( "  >>> object found: " + object, true );
        }

        return object;
    }



    //**************************************************************
    // Test Methods
    //**************************************************************

    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb" },
                    dataProvider="oval.test_content.def",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>> void testSaveAndLoad(
                    final Class<T>          object_type,
                    final String            oval_schema_version,
                    final OvalPlatformType  platform,
                    final String            dirpath,
                    final String            xml_filepath,
                    final T                 expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "* OVAL schema version: " + oval_schema_version, true );
        Reporter.log( "* platform: " + platform.name(), true );

        File  dir = new File( dirpath );

        if (xml_filepath == null) {
            FilenameFilter  filter = new XmlFilenameFilter();
            File[]  files = dir.listFiles( filter );
            for (File  file : files) {
                Reporter.log( "  * file= " + file, true );
                _readFromFileAndSaveToDatastore( object_type, file.getCanonicalPath(), expected_object, true );
            }
        } else {
            File  file = new File( dir, xml_filepath );
            Reporter.log( "  * file= " + file, true );
            _readFromFileAndSaveToDatastore( object_type, file.getCanonicalPath(), expected_object, true );
        }
    }



    //**************************************************************
    // Performance Evaluation Methods
    //**************************************************************

    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb.performance" },
                    dataProvider="oval.test_content.def",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
    void evaluateSaveDefinitions(
                    final Class<OvalDefinitions> object_type,
                    final String            oval_schema_version,
                    final OvalPlatformType  platform,
                    final String            dirpath,
                    final String            xml_filepath,
                    final OvalDefinitions   expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "* OVAL schema version: " + oval_schema_version, true );
        Reporter.log( "* platform: " + platform.name(), true );

        File  dir = new File( dirpath );
        final boolean  to_log = false;

        List<String>  def_ids = null;
        if (xml_filepath == null) {
            FilenameFilter  filter = new XmlFilenameFilter();
            File[]  files = dir.listFiles( filter );
            for (File  file : files) {
                Reporter.log( "  * file= " + file, true );
                OvalDefinitions  object = _unmarshalObject( object_type, file.getCanonicalPath(), expected_object, to_log );
                def_ids = _evaluateSaveDefinition( object );
                _evaluateFindDefinitionById( def_ids );
            }
        } else {
            File  file = new File( dir, xml_filepath );
            Reporter.log( "  * file= " + file, true );
            OvalDefinitions  object = _unmarshalObject( object_type, file.getCanonicalPath(), expected_object, to_log );
            def_ids = _evaluateSaveDefinition( object );
            _evaluateFindDefinitionById( def_ids );
        }
    }


    private List<String> _evaluateSaveDefinition(
                    final OvalDefinitions oval_defs
                    )
    throws Exception
    {
        DefinitionsType  defs = oval_defs.getDefinitions();
        if (defs == null) {
            defs = new DefinitionsType();
        }

        final boolean  to_log = false;
        final boolean  to_load = false;
        final int  count = defs.size();
        final List<String>  def_ids = new ArrayList<String>( count );
//        final long[]  lap_times = new long[count];
        long  lap_times_sum = 0L;

        Reporter.log( "Saving OVAL Definitions #defs=" + count, true );
        Reporter.log( "OVAL ID,class,elapsed time (ms)", true );
//        int  index = 0;
        for (DefinitionType  def : defs.getDefinition()) {
            def_ids.add( def.getOvalID() );
            long  ts_start = System.currentTimeMillis();
            _saveObject( DefinitionType.class, def, to_load, to_log );
            long  lap_time = System.currentTimeMillis() - ts_start;
            lap_times_sum += lap_time;
//            index++;

//            Reporter.log( def.getOvalID() + "," + def.getDefinitionClass() + "," + lap_time, true );
        }

        final float  lap_times_avg =  (float)lap_times_sum / count;
        Reporter.log( "*** Saving OVAL Definitions #defs=" + count, true );
        Reporter.log( "sum(lap_times)=" + lap_times_sum, true );
        Reporter.log( "avg(lap_times)=" + lap_times_avg, true );

//        Reporter.log( "Saving OVAL Definitions,#defs=" + count, true );
//        Reporter.log( "OVAL ID, elapsed time (ms): ", true );
//        for (int  i = 0; i < count; i++) {
//            Reporter.log( def_ids[i] + "," + lap_times[i], true );
//        }

        return def_ids;
    }



    private void _evaluateFindDefinitionById(
                    final List<String> def_ids
                    )
    throws Exception
    {
        final boolean  to_log = false;
        final int  count = def_ids.size();
        long  lap_times_sum = 0L;

        Reporter.log( "*** Finding OVAL Definitions by ID #defs=" + count, true );
        Reporter.log( "OVAL ID,class,elapsed time (ms)", true );
//        int  index = 0;
        for (String  def_id : def_ids) {
            long  ts_start = System.currentTimeMillis();
            DefinitionType  def = _findObjectById( DefinitionType.class, def_id, to_log );
            long  lap_time = System.currentTimeMillis() - ts_start;
            lap_times_sum += lap_time;
//            index++;

//            Reporter.log( def_id + "," + def.getDefinitionClass() + "," + lap_time, true );
        }

        final float  lap_times_avg =  (float)lap_times_sum / count;
        Reporter.log( "Finding OVAL Definitions by ID #defs=" + count, true );
        Reporter.log( "sum(lap_times)=" + lap_times_sum, true );
        Reporter.log( "avg(lap_times)=" + lap_times_avg, true );
    }

}
//
