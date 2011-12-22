package jp.go.aist.six.test.oval.core.xml;

import java.io.File;
import java.io.FilenameFilter;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalTestContentXmlTest
    extends CoreTestBase
{

    /**
     */
    public OvalTestContentXmlTest()
    {
    }



    /**
     */
    protected <T> void _testXml(
                    final Class<T> type,
                    final String sourceFilepath,
                    final T expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        T  actual = null;
        try {
            actual = _unmarshalWithValidation( type, sourceFilepath, expected );
            if (actual instanceof OvalDefinitions) {
                OvalDefinitions  oval_defs = OvalDefinitions.class.cast( actual );
                for (DefinitionType  def : oval_defs.getDefinitions().getDefinition()) {
                    Reporter.log( "  @ definition: id=" + def.getOvalID(), true );
                    Reporter.log( "                title=" + def.getMetadata().getTitle(), true );
                }
            }
        } catch (Exception ex) {
            Reporter.log( "  !!! Unsupported XML element(s) found.", true );
            throw ex;
        }

        if (actual != null) {
            _marshal( actual, resultFilepath );
            _unmarshalWithValidation( type, resultFilepath, /* xpath, */ expected );
        }
    }


    //**************************************************************
    //  OVAL Test Content
    //**************************************************************

    @DataProvider( name="oval.test-content" )
    public Object[][] provideOvalTestContentXml()
    {
        return new Object[][] {
                        //Java class
                        //directory that contains OVAL definitions XML files
                        //target OVAL Definitions file. If it is null, all the XML files are targets.

//                        //linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/OvalTestContent/5.10/linux",
//                            null
//                        }
//                        ,
//                        //windows
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "test/resources/OvalTestContent/5.10/windows",
                            null
                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/OvalTestContent/5.10/windows",
//                            "oval-def_time_difference_function.xml"
//                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval.test-content"},
                    dataProvider="oval.test-content",
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitions(
                    final Class<OvalDefinitions> type,
                    final String dirpath,
                    final String filename
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        Reporter.log( "// OVAL Test Content", true );

        File  dir = new File( dirpath );

        if (filename == null) {
            FilenameFilter  filter = new XmlFilenameFilter();
            File[]  files = dir.listFiles( filter );
            for (File  file : files) {
                Reporter.log( "  * file= " + file, true );
//                try {
                    _testXml( type, file.getCanonicalPath(), null, "unmarshalled_" + file.getName() );
//                } catch (Exception ex) {
//                    Reporter.log( "  !!! exception= " + ex, true );
//                }
            }
        } else {
            File  file = new File( dir, filename );
            Reporter.log( "  * file= " + file, true );
            _testXml( type, file.getCanonicalPath(), null, "unmarshalled_" + file.getName() );
        }
//        _testXml( type, filename, /* xpath, */ expected, resultFilepath );
    }



    private static class XmlFilenameFilter
    implements FilenameFilter
    {

        public XmlFilenameFilter()
        {
        }


        @Override
        public boolean accept(
                        final File dir,
                        final String name
                        )
        {
            return name.endsWith( ".xml" );
        }

    }

}
// OvalTestContentXmlTest
