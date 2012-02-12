package jp.go.aist.six.test.oval.core.interpreter;

import java.io.File;
import java.io.FilenameFilter;
import jp.go.aist.six.oval.core.interpreter.OvaldiOption;
import jp.go.aist.six.oval.core.interpreter.OvaldiOptions;
import jp.go.aist.six.oval.core.interpreter.OvaldiProxy;
import jp.go.aist.six.oval.interpreter.Options;
import jp.go.aist.six.oval.interpreter.OvalInterpreter;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.XmlFilenameFilter;
import org.testng.Reporter;



/**
 * OvalInterpreter
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreterTestContentTest
    extends CoreTestBase
{

    private static final String  _OVALDI_DIR_ = "C:\\app\\ovaldi-5.10.1.1-x64";

    private static final String  _OVALDI_EXECUTABLE_ = _OVALDI_DIR_ + "\\ovaldi.exe";
    private static final String  _OVALDI_XML_ = _OVALDI_DIR_ + "\\xml";




    /**
     */
    private OvalInterpreter _createOvalInterpreter()
    throws Exception
    {
        String  executable = _getContext().getProperty( "six.oval.interpreter.executable" );
        Reporter.log( "* executable: " + executable, true );
        OvaldiProxy  ovaldi = new OvaldiProxy();
        if (executable != null) {
            ovaldi.setExecutable( executable );
        }

        return ovaldi;
    }



    /**
     */
    protected void _executeOvalInterpreter(
                    final OvalInterpreter ovaldi,
                    final Options options
                    )
    throws Exception
    {
        Reporter.log( "* options: " + options, true );
        ovaldi.setOptions( options );
        int  exitValue = ovaldi.execute();
        Reporter.log( "@ exit value: " + exitValue, true );
    }




//    @DataProvider( name="oval.interpreter.options" )
//    public Object[][] provideOvalInterpreterOptions()
//    {
//        //minimum options
//        Options  options1 = new Options();
//        options1.set( OvaldiOption.NO_VERIFY )
////                .set( OvaldiOption.OVAL_XML_DIR, _OVALDI_XML_ )
//                .set( OvaldiOption.OVAL_DEFINITIONS,
//                                "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml" );
//
//        return new Object[][] {
//                        {
//                            _OVALDI_EXECUTABLE_,
//                            options1
//                        }
//        };
//
//    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.interpreter" },
                    dataProvider="oval.test_content",
                    alwaysRun=true
                    )
    public <T> void testOvaldiProxy(
                    final Class<T>            model_type,
                    final String              oval_schema_version,
                    final OvalPlatformType    platform,
                    final String              dirpath,
                    final String              filename
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        OvalInterpreter  ovaldi = _createOvalInterpreter();

        File  dir = new File( dirpath );

        if (filename == null) {
            FilenameFilter  filter = new XmlFilenameFilter();
            File[]  files = dir.listFiles( filter );
            for (File  file : files) {
                Reporter.log( "  * file= " + file, true );
                Options  options = _createOptions( file );
                _executeOvalInterpreter( ovaldi, options );
            }
        } else {
            File  file = new File( dir, filename );
            Reporter.log( "  * file= " + file, true );
            Options  options = _createOptions( file );
            _executeOvalInterpreter( ovaldi, options );
        }
    }



    /**
     */
    private Options _createOptions(
                    final File oval_def_file
                    )
    {
        String  out_dirpath = System.getProperty( "java.io.tmpdir" );

        String  oval_def_filename = oval_def_file.getName();
        File  oval_sc_file =      new File( out_dirpath, oval_def_filename + ".sc.xml" );
        File  oval_results_file = new File( out_dirpath, oval_def_filename + ".results.xml" );
        File  oval_trans_file =   new File( out_dirpath, oval_def_filename + ".results.html") ;

        Options  options = new OvaldiOptions();
        options.set( OvaldiOption.NO_VERIFY );
        options.set( OvaldiOption.OVAL_DEFINITIONS, oval_def_file.getAbsolutePath() );
        options.set( OvaldiOption.OVAL_SC,          oval_sc_file.getAbsolutePath() );
        options.set( OvaldiOption.OVAL_RESULTS,     oval_results_file.getAbsolutePath() );
        options.set( OvaldiOption.OVAL_TRANSFORMED_RESULTS, oval_trans_file.getAbsolutePath() );

        return options;
    }

}
//OvalInterpreterTestContentTest
