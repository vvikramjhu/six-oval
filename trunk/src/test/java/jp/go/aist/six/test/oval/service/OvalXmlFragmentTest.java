package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.core.service.StandardOvalService;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.DefinitionClass;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.SimpleTest;
import jp.go.aist.six.oval.model.definition.State;
import jp.go.aist.six.oval.model.definition.StateRef;
import jp.go.aist.six.oval.model.definition.States;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.definition.SystemObjects;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.model.definition.Tests;
import jp.go.aist.six.oval.model.linux.LinuxEvrPkgInfoState;
import jp.go.aist.six.oval.model.linux.LinuxPkgInfoObject;
import jp.go.aist.six.oval.model.linux.LinuxPkgInfoState;
import jp.go.aist.six.oval.model.linux.RpmInfoState;
import jp.go.aist.six.util.xml.XmlMapper;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXmlFragmentTest.java 725 2010-05-07 02:27:17Z akihito $
 */
public class OvalXmlFragmentTest
{

    private XmlMapper  _xmlMapper = null;


    /**
     */
    public OvalXmlFragmentTest()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
        throws Exception
    {
        StandardOvalService  service = new StandardOvalService();
        _xmlMapper = service.getXml();
    }



    /**
     */
    public void run()
        throws Exception
    {
    }


//    private static final String  _PLATFORM_LINUX_REDHAT_ = "Linux RedHat";
//    private static final String  _PLATFORM_LINUX_CENTOS_ = "Linux CentOS";
//    private static final String  _PLATFORM_LINUX_DEBIAN_ = "Linux Debian";
//    private static final String  _PLATFORM_WINDOWS_      = "Windows";



    /**
     */
    private Object _unmarshal(
                    final String filepath
                    )
    throws Exception
    {
        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "@@@ unmarshalled object: " + obj, true );

        return obj;
    }



    //==============================================================
    //  oval_definitions
    //==============================================================

    /**
     * Sample definitions elements.
     */
    @DataProvider( name="oval-definitions-elements" )
    public Object[][] ovalDefinitionsElementsProvider()
    {
        return new Object[][] {
                        {
                            // definition //
                            "test/data/sample_oval-definitions-definition_linux-redhat-1.xml",
                            // tests //
                            new String[] {
                                            "test/data/sample_oval-definitions-test_linux-rpm-1.xml",
                                            "test/data/sample_oval-definitions-test_linux-rpm-2.xml",
                                            "test/data/sample_oval-definitions-test_linux-rpm-3.xml",
                                            "test/data/sample_oval-definitions-test_linux-rpm-4.xml",
                                            "test/data/sample_oval-definitions-test_linux-rpm-5.xml",
                                            "test/data/sample_oval-definitions-test_linux-rpm-6.xml",
                                            "test/data/sample_oval-definitions-test_linux-rpm-7.xml",
                                            "test/data/sample_oval-definitions-test_linux-rpm-8.xml"
                            },
                            // objects //
                            new String[] {
                                            "test/data/sample_oval-definitions-object_linux-rpm-1.xml",
                                            "test/data/sample_oval-definitions-object_linux-rpm-2.xml"
                            },
                            // states //
                            new String[] {
                                            "test/data/sample_oval-definitions-state_linux-rpm-1.xml",
                                            "test/data/sample_oval-definitions-state_linux-rpm-2.xml",
                                            "test/data/sample_oval-definitions-state_linux-rpm-3.xml",
                                            "test/data/sample_oval-definitions-state_linux-rpm-4.xml",
                                            "test/data/sample_oval-definitions-state_linux-rpm-5.xml",
                                            "test/data/sample_oval-definitions-state_linux-rpm-6.xml",
                                            "test/data/sample_oval-definitions-state_linux-rpm-7.xml",
                                            "test/data/sample_oval-definitions-state_linux-rpm-8.xml"
                            }
                        }
        };
    }



    /**
     * Unmarshal.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_definitions"},
                    dataProvider="oval-definitions-elements",
                    alwaysRun=true
                    )
    public void unmarshalOvalDefinitionsElements(
                    final String   defPath,
                    final String[] testPaths,
                    final String[] objectPaths,
                    final String[] statePaths
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL definitions: unmarshal XML and build oval_definitions //", true );

        OvalDefinitions  defs = new OvalDefinitions();

        Definition  def = (Definition)_unmarshal( defPath );
        Assert.assertNotNull( def );
        defs.getDefinitions().addElement( def );

        Tests  tests = new Tests();
        for (String  path : testPaths) {
            Test  test = (Test)_unmarshal( path );
            Assert.assertNotNull( test );
            tests.addElement( test );
        }
        defs.setTests( tests );

        SystemObjects  objects = new SystemObjects();
        for (String  path : objectPaths) {
            SystemObject  obj = (SystemObject)_unmarshal( path );
            Assert.assertNotNull( obj );
            objects.addElement( obj );
        }
        defs.setObjects( objects );

        States  states = new States();
        for (String  path : statePaths) {
            State  state= (State)_unmarshal( path );
            Assert.assertNotNull( state );
            states.addElement( state );
        }
        defs.setStates( states );

        // marshalling
        String  xml = _xmlMapper.marshalToString( defs );
        Reporter.log( "@@@ re-marshalled XML: ", true );
        Reporter.log( xml, true );
    }




    //==============================================================
    //  oval_definitions/definitions/definition
    //==============================================================

    /**
     * Sample definitions.
     */
    @DataProvider( name="oval-definitions-definition" )
    public Object[][] ovalDefinitionsDefinitionProvider()
    {
        return new Object[][] {
                        {
                            "test/data/sample_oval-definitions-definition_linux-redhat-1.xml",
                            "oval:com.redhat.rhsa:def:20100061",
                            DefinitionClass.PATCH,
                            "RHSA-2010:0061: gzip security update (Moderate)"
                        }
        };
    }



    /**
     * Unmarshal.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_definitions", "definition"},
                    dataProvider="oval-definitions-definition",
                    alwaysRun=true
                    )
    public void unmarshalOvalDefinitionsDefinition(
                    final String filepath,
                    final String id,
                    final DefinitionClass defClazz,
                    final String title
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL definitions: unmarshal definition XML //", true );
        Reporter.log( "### XML file path to unmarshal: " + filepath, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "@@@ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Definition );
        Definition  def = (Definition)obj;
        Assert.assertEquals( def.getOvalID(), id );
        Assert.assertEquals( def.getDefinitionClass(), defClazz );
        Assert.assertEquals( def.getMetadata().getTitle(), title );

        // marshalling
        String  xml = _xmlMapper.marshalToString( obj );
        Reporter.log( "@@@ re-marshalled XML: ", true );
        Reporter.log( xml, true );
    }



    //==============================================================
    //  oval_definitions/tests/test
    //==============================================================

    /**
     * Sample tests.
     */
    @DataProvider( name="oval-definitions-test" )
    public Object[][] ovalDefinitionsTestProvider()
    {
        return new Object[][] {
                        {
                            "oval:com.redhat.rhsa:obj:20100061002",
                            "oval:com.redhat.rhsa:ste:20100061004",
                            "test/data/sample_oval-definitions-test_linux-rpm-2.xml"
                        }
        };
    }



    /**
     * Unmarshal.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_definitions", "test"},
                    dataProvider="oval-definitions-test",
                    alwaysRun=true
                    )
    public void unmarshalOvalDefinitionsTest(
                    final String objectID,
                    final String stateID,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL definitions: unmarshal test XML //", true );
        Reporter.log( "### XML file path to unmarshal: " + filepath, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "@@@ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Test );
        if (obj instanceof SimpleTest) {
            SimpleTest  pkgobj = (SimpleTest)obj;
            Assert.assertEquals( pkgobj.getObject().getOvalID(), objectID );
            StateRef  stateRef = pkgobj.getState();
            if (stateRef == null) {
                Assert.assertEquals( null, stateID );
            } else {
                Assert.assertEquals( stateRef.getOvalID(), stateID );
            }
        }

        // marshalling
        String  xml = _xmlMapper.marshalToString( obj );
        Reporter.log( "@@@ re-marshalled XML: ", true );
        Reporter.log( xml, true );
    }



    //==============================================================
    //  oval_definitions/objects/object
    //==============================================================

    /**
     * Sample objects.
     */
    @DataProvider( name="oval-definitions-object" )
    public Object[][] ovalDefinitionsObjectProvider()
    {
        return new Object[][] {
                        {
                            "gzip",
                            "test/data/sample_oval-definitions-object_linux-rpm-2.xml"
                        }
        };
    }



    /**
     * Unmarshal.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_definitions", "object"},
                    dataProvider="oval-definitions-object",
                    alwaysRun=true
                    )
    public void unmarshalOvalDefinitionsObject(
                    final String name,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL definitions: unmarshal object XML //", true );
        Reporter.log( "### XML file path to unmarshal: " + filepath, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "@@@ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof SystemObject );
        if (obj instanceof LinuxPkgInfoObject) {
            LinuxPkgInfoObject  pkgobj = (LinuxPkgInfoObject)obj;
            Assert.assertEquals( pkgobj.getName(), name );
        }

        // marshalling
        String  xml = _xmlMapper.marshalToString( obj );
        Reporter.log( "@@@ re-marshalled XML: ", true );
        Reporter.log( xml, true );
    }



    //==============================================================
    //  oval_definitions/states/state
    //==============================================================

    /**
     * Sample OVAL Definitions.
     */
    @DataProvider( name="oval-definitions-state" )
    public Object[][] ovalDefinitionsStateProvider()
    {
        return new Object[][] {
                        {
                            "signature_keyid",
                            "219180cddb42a60e",
                            "test/data/sample_oval-definitions-state_linux-rpm-1.xml"
                        },
                        {
                            "version",
                            "^5[^[:digit:]]",
                            "test/data/sample_oval-definitions-state_linux-rpm-3.xml"
                        },
                        {
                            "evr",
                            "0:1.3.5-11.el5_4.1",
                            "test/data/sample_oval-definitions-state_linux-rpm-4.xml"
                        }
        };
    }



    /**
     * Unmarshal.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_definitions", "state"},
                    dataProvider="oval-definitions-state",
                    alwaysRun=true
                    )
    public void unmarshalOvalDefinitionsState(
                    final String type,
                    final String value,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL definitions: unmarshal state XML //", true );
        Reporter.log( "### xml file path to unmarshal: "
                        + filepath, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "@@@ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        if (obj instanceof LinuxPkgInfoState) {
            _assertLinuxPkgInfoState( (LinuxPkgInfoState)obj, type, value );
        }

        // marshalling
        String  xml = _xmlMapper.marshalToString( obj );
        Reporter.log( "@@@ re-marshalled XML: ", true );
        Reporter.log( xml, true );
    }



    /**
     */
    private void _assertLinuxPkgInfoState(
                    final LinuxPkgInfoState state,
                    final String type,
                    final String value
                    )
    {
        String  stateValue = null;
        if (type.equals( "evr" )) {
            LinuxEvrPkgInfoState  evrState = (LinuxEvrPkgInfoState)state;
            stateValue = evrState.getEvr().getData();
        } else if (type.equals( "version" )) {
            stateValue = state.getVersion().getData();
        } else if (type.equals( "signature_keyid" )) {
            RpmInfoState  rpmState = (RpmInfoState)state;
            stateValue = rpmState.getSignatureKeyID().getData();
        } else {
            Reporter.log( "%%% ERROR: unknown LinuxPkgInfoState type: " + type, true );
        }

        Assert.assertEquals( stateValue, value );
    }



    private static final String  _RPMINFO_STATE_XML_ =
        "<rpminfo_state xmlns=\"http://oval.mitre.org/XMLSchema/oval-definitions-5\" "
        + "xmlns:oval=\"http://oval.mitre.org/XMLSchema/oval-common-5\" "
        + "xmlns:oval-def=\"http://oval.mitre.org/XMLSchema/oval-definitions-5\" "
        + "xmlns:unix-def=\"http://oval.mitre.org/XMLSchema/oval-definitions-5#unix\" "
        + "xmlns:red-def=\"http://oval.mitre.org/XMLSchema/oval-definitions-5#linux\" "
        + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
        + "xsi:schemaLocation=\"http://oval.mitre.org/XMLSchema/oval-common-5 oval-common-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5 oval-definitions-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5#unix unix-definitions-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5#linux linux-definitions-schema.xsd\" "
        + " id=\"oval:com.redhat.rhsa:ste:20100061004\" "
        + "version=\"301\">"
        + "<evr datatype=\"evr_string\" operation=\"less than\">0:1.3.5-11.el5_4.1</evr></rpminfo_state>";

    /**
     * Sample OVAL Definitions.
     */
    @DataProvider( name="oval-definitions-state-string" )
    public Object[][] ovalDefinitionsStateStringProvider()
    {
        return new Object[][] {
                        {
                            _RPMINFO_STATE_XML_
                        }
        };
    }


    /**
     * Unmarshalls the OVAL definitions.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_definitions", "state"},
                    dataProvider="oval-definitions-state-string",
                    alwaysRun=true
                    )
    public void unmarshalOvalDefinitionsStateFromString(
                    final String xml
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL definitions: unmarshal state XML", true );
        Reporter.log( "### xml to unmarshal: " + xml, true );

        Reporter.log( "*** unmarshalling XML...", true );
        State  state = (State)_xmlMapper.unmarshalFromString( xml );
        Assert.assertNotNull( state );
        Reporter.log( "@@@ state: " + state, true );
    }


}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

