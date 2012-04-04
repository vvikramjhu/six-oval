package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatastore;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.AffectedType;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.ReferenceType;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
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



    private <K, T extends Persistable<K>>
    List<T> _findObjectByQuery(
                    final Class<T>  object_type,
                    final QueryParams params,
                    final boolean   to_log
                    )
    throws Exception
    {
        if (to_log) {
            Reporter.log( "object type: " + object_type, true );
            Reporter.log( "find by query params..." , true );
            Reporter.log( "  * query params: " + params, true );
        }

        List<T>  objects = _datastore.find( object_type, params );
        if (to_log) {
            Reporter.log( "  >>> objects found: $objects=" + objects.size(), true );
        }

        return objects;
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
                    final Family            family,
                    final String            dirpath,
                    final String            xml_filepath,
                    final T                 expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "* OVAL schema version: " + oval_schema_version, true );
        Reporter.log( "* family: " + family, true );

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
                    final Family            family,
                    final String            dirpath,
                    final String            xml_filepath,
                    final OvalDefinitions   expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "* OVAL schema version: " + oval_schema_version, true );
        Reporter.log( "* family: " + family, true );

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

        if (_saved_cves != null) {
            _evaluateFindDefinitionByCve( _saved_cves );
            _saved_cves.clear();
        }

        if (_saved_platforms != null) {
            _evaluateFindDefinitionByPlatform( _saved_platforms );
            _saved_platforms.clear();
        }
    }



    private List<String>  _saved_cves = null;
    private Set<Platform>  _saved_platforms = null;


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
        _saved_cves = new ArrayList<String>();
//        final long[]  lap_times = new long[count];
        long  lap_times_sum = 0L;

        Reporter.log( "Saving OVAL Definitions #defs=" + count, true );
        Reporter.log( "OVAL ID,class,elapsed time (ms)", true );
//        int  index = 0;
        for (DefinitionType  def : defs.getDefinition()) {
            final String  def_id = def.getOvalID();
            def_ids.add( def_id );

            // What CVEs are saved?
            Collection<ReferenceType>  refs = def.getMetadata().getReference();
            if (refs != null  &&  refs.size() > 0) {
                for (ReferenceType  ref : refs) {
                    String  ref_source = ref.getSource();
                    if ("CVE".equals( ref_source )) {
                        String  ref_id = ref.getRefID();
                        if (_saved_cves == null) {
                            _saved_cves = new ArrayList<String>();
                        }
                        _saved_cves.add( ref_id );
                    }
                }
            }

            // What platforms are saved?
            Collection<AffectedType>  affected_list = def.getMetadata().getAffected();
            if (affected_list != null  &&  affected_list.size() > 0) {
                for (AffectedType  affected : affected_list) {
                    Collection<Platform>  platform_list = affected.getPlatform();
                    if (platform_list != null  &&  platform_list.size() > 0) {
                        if (_saved_platforms == null) {
                            _saved_platforms = new HashSet<Platform>();
                        }
                        _saved_platforms.addAll( platform_list );
                    }
                }
            }

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



    private void _evaluateFindDefinitionByCve(
                    final List<String> cve_ids
                    )
    throws Exception
    {
        final boolean  to_log = false;
        final int  count = cve_ids.size();
        long  lap_times_sum = 0L;

        Reporter.log( "*** Finding OVAL Definitions by CVE ID #cves=" + count, true );
        if (count == 0) {
            return;
        }

//        Reporter.log( "OVAL ID,#defs,elapsed time (ms)", true );
//        int  index = 0;
        for (String  cve_id : cve_ids) {
            DefinitionQueryParams  params = new DefinitionQueryParams();
            params.setRefId( cve_id );
            long  ts_start = System.currentTimeMillis();
            List<DefinitionType>  def_list = _findObjectByQuery( DefinitionType.class, params, to_log );
            long  lap_time = System.currentTimeMillis() - ts_start;
            lap_times_sum += lap_time;
//            index++;

//            Reporter.log( cve_id + "," + def_list.size() + "," + lap_time, true );
        }

        final float  lap_times_avg =  (float)lap_times_sum / count;
        Reporter.log( "Finding OVAL Definitions by CVE ID #cves=" + count, true );
        Reporter.log( "sum(lap_times)=" + lap_times_sum, true );
        Reporter.log( "avg(lap_times)=" + lap_times_avg, true );
    }


    private void _evaluateFindDefinitionByPlatform(
                    final Collection<? extends Platform> platform_list
                    )
    throws Exception
    {
        final boolean  to_log = false;
        final int  count = platform_list.size();
        long  lap_times_sum = 0L;

        Reporter.log( "*** Finding OVAL Definitions by platform #platforms=" + count, true );
        if (count == 0) {
            return;
        }

        Reporter.log( "platform,#defs,elapsed time (ms)", true );
//        int  index = 0;
        for (Platform  platform : platform_list) {
            DefinitionQueryParams  params = new DefinitionQueryParams();
            params.setPlatform( platform.getName() );
            long  ts_start = System.currentTimeMillis();
            List<DefinitionType>  def_list = _findObjectByQuery( DefinitionType.class, params, to_log );
            long  lap_time = System.currentTimeMillis() - ts_start;
            lap_times_sum += lap_time;
//            index++;

            Reporter.log( platform + "," + def_list.size() + "," + lap_time, true );
        }

        final float  lap_times_avg =  (float)lap_times_sum / count;
        Reporter.log( "Finding OVAL Definitions by platform #platforms=" + count, true );
        Reporter.log( "sum(lap_times)=" + lap_times_sum, true );
        Reporter.log( "avg(lap_times)=" + lap_times_avg, true );
    }

}
//
