package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.Product;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.util.xml.XmlMapper;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXmlMarshallingTest.java 697 2010-04-26 10:25:37Z akihito $
 */
public class OvalXmlMarshallingTest
{

    private XmlMapper  _xmlMapper = null;



    /**
     */
    public OvalXmlMarshallingTest()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        OvalContext  service = new OvalContext();
        _xmlMapper = service.getXml();
    }



    //==============================================================
    //  test
    //==============================================================

    /**
     * @testng.data-provider name="oval-test"
     */
    @DataProvider( name="oval-test" )
    public Object[][] ovalTestProvider()
    {
        return new Object[][] {
                        // Unknown test
                        {
                            "test/data/sample_oval-test-unknown.xml",
                            "oval:org.mitre.oval:tst:2531",
                            1,
                            "Word 97 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            EntityType.INDEPENDENT_UNKNOWN
                        },
                        // Registry test
                        {
                            "test/data/sample_oval-test-registry.xml",
                            "oval:org.mitre.oval:tst:3019",
                            2,
                            "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.AT_LEAST_ONE,
                            EntityType.WINDOWS_REGISTRY
                        }
        };
    }



    /**
     * @testng.test groups="oval.xml test"
     *              dataProvider="oval-test"
     *              alwaysRun="true"
     */
    @org.testng.annotations.Test( groups={"oval.xml", "test"},
                    dataProvider="oval-test",
                    alwaysRun=true
                    )
    public void marshalTest(
                    final String filepath,
                    final String id,
                    final int version,
                    final String comment,
                    final Existence existence,
                    final Check check,
                    final EntityType type
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling/marshalling from/to XML //", true );
        Reporter.log( "  * xpath: test", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Test );
        Test  test = Test.class.cast( obj );
        Assert.assertEquals( id, test.getOvalID() );
        Assert.assertEquals( version, test.getOvalVersion() );
        Assert.assertEquals( comment, test.getComment() );
        Assert.assertEquals( existence, test.getCheckExistence() );
        Assert.assertEquals( check, test.getCheck() );
        Assert.assertEquals( type, test.getEntityType() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xmlMapper.marshalToString( test );
        Reporter.log( "  @ marshalled XML: " + xml, true );
    }



    //==============================================================
    //  object
    //==============================================================

    /**
     * @testng.data-provider name="oval-object"
     */
    @DataProvider( name="oval-object" )
    public Object[][] ovalSystemObjectProvider()
    {
        return new Object[][] {
                        {
                            "test/data/sample_oval-object-family.xml",
                            "oval:org.mitre.oval:obj:99",
                            1,
                            "This is the default family object. Only one family object should exist.",
                            EntityType.INDEPENDENT_FAMILY
                        },
                        {
                            "test/data/sample_oval-object-rpminfo.xml",
                            "oval:com.redhat.rhsa:obj:20100061001",
                            301,
                            null,
                            EntityType.LINUX_RPMINFO
                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test( groups={"oval.xml", "object"},
                    dataProvider="oval-object",
                    alwaysRun=true
                    )
    public void marshalSystemObject(
                    final String filepath,
                    final String id,
                    final int version,
                    final String comment,
                    final EntityType type
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling/marshalling from/to XML //", true );
        Reporter.log( "  * xpath: object", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof SystemObject );
        SystemObject  object = SystemObject.class.cast( obj );
        Assert.assertEquals( id, object.getOvalID() );
        Assert.assertEquals( version, object.getOvalVersion() );
        Assert.assertEquals( comment, object.getComment() );
        Assert.assertEquals( type, object.getEntityType() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xmlMapper.marshalToString( object );
        Reporter.log( "  @ marshalled XML: " + xml, true );
    }



    //==============================================================
    //  definition
    //==============================================================

    /**
     */
    @DataProvider( name="oval-definition" )
    public Object[][] ovalDefinitionProvider()
    {
        return new Object[][] {
                        {
                            "test/data/definition/oval-2010-06-15.05.04.34.xml",
                            "oval:org.mitre.oval:def:1020",
                            2,
                            DefinitionClass.VULNERABILITY
                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.xml", "Definition"},
                    dataProvider="oval-definition",
                    dependsOnGroups="definition.metadata",
                    alwaysRun=true
                    )
    public void marshalDefinition(
                    final String filepath,
                    final String id,
                    final int version,
                    final DefinitionClass clazz
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: oval.core.xml //", true );
        Reporter.log( "  * oval-def:definition", true );

        File  file = new File( filepath );
        Reporter.log( "unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  ...done", true );
        Reporter.log( "@ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof OvalDefinitions );
        OvalDefinitions  defs = OvalDefinitions.class.cast( obj );
        Definition  def = defs.getDefinitions().find( id );
        Assert.assertNotNull( def );
        Reporter.log( "@ definition: " + def, true );
        Assert.assertEquals( id, def.getOvalID() );
        Assert.assertEquals( version, def.getOvalVersion() );
        Assert.assertEquals( clazz, def.getDefinitionClass() );

//        Reporter.log( "  * marshalling XML...", true );
//        String  xml = _xmlMapper.marshalToString( def );
//        Reporter.log( "  @ marshalled XML: " + xml, true );
    }



    //==============================================================
    //  definition/metadata
    //==============================================================

    /**
     */
    @DataProvider( name="oval-definition-metadata" )
    public Object[][] ovalDefinitionMetadataProvider()
    {
        return new Object[][] {
                        {
                            "test/data/sample_oval-definition_metadata-1.xml",
                            "IE6 Double Byte Character Parsing Memory Corruption (WinXP)",
                            Family.WINDOWS,
                            new Reference[] {
                                            new Reference( "CVE",
                                                            "CVE-2006-1189",
                                                            "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2006-1189"
                                                            )
                            },
                            "Buffer overflow in URLMON.DLL"
                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test( groups={"oval.xml", "definition.metadata"},
                    dataProvider="oval-definition-matadata",
                    dependsOnGroups="definition.metadata.affected",
                    alwaysRun=true
                    )
    public void marshalDefinitionMetadata(
                    final String filepath,
                    final String title,
                    final Family family,
                    final Reference[] referenceList,
                    final String descriptionPrefix
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling/marshalling from/to XML //", true );
        Reporter.log( "  * xpath: definition/metadata", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Metadata );
        Metadata  metadata = Metadata.class.cast( obj );
        Assert.assertEquals( title, metadata.getTitle() );
        Assert.assertEquals( family, metadata.getAffected().getFamily() );
        Assert.assertEquals( referenceList.length, metadata.getReference().size() );
        Assert.assertTrue( metadata.getDescription().startsWith( descriptionPrefix ) );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xmlMapper.marshalToString( metadata );
        Reporter.log( "  @ marshalled XML: " + xml, true );
    }



    //==============================================================
    //  definition/metadata/affected
    //==============================================================

    /**
     */
    @DataProvider( name="oval-definition-metadata-affected" )
    public Object[][] ovalDefinitionMetadataAffectedProvider()
    {
        return new Object[][] {
                        {
                            "test/data/sample_oval-definition_metadata-affected-1.xml",
                            new Platform[] {
                                            new Platform( "Red Hat Enterprise Linux 3" ),
                                            new Platform( "Red Hat Enterprise Linux 4" ),
                                            new Platform( "Red Hat Enterprise Linux 5" )
                            },
                            new Product[0],
                            Family.UNIX
                        },
                        {
                            "test/data/sample_oval-definition_metadata-affected-2.xml",
                            new Platform[] {
                                            new Platform( "Microsoft Windows XP" )
                            },
                            new Product[] {
                                            new Product( "Microsoft Internet Explorer" )
                            },
                            Family.WINDOWS
            }
        };
    }



    /**
     * @testng.test groups="oval.xml definition.metadata.affected"
     *              dataProvider="oval-definition-metadata-affected"
     *              alwaysRun="true"
     */
    @org.testng.annotations.Test( groups={"oval.xml", "definition.metadata.affected"},
                    dataProvider="oval-definition-matadata-affected",
                    alwaysRun=true
                    )
    public void marshalDefinitionMetadataAffected(
                    final String filepath,
                    final Platform[] platformList,
                    final Product[] productList,
                    final Family family
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling/marshalling from/to XML //", true );
        Reporter.log( "  * xpath: definition/metadata/affected", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Affected );
        Affected  affected = Affected.class.cast( obj );
        Assert.assertEquals( family, affected.getFamily() );
        Assert.assertEquals( platformList.length, affected.getPlatform().size() );
        Assert.assertEquals( productList.length, affected.getProduct().size() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xmlMapper.marshalToString( affected );
        Reporter.log( "  @ marshalled XML: " + xml, true );
    }



    ////////////////////////////////////////////////////////////////
    //  deprecated
    ////////////////////////////////////////////////////////////////

//    /**
//     */
//    private Marshaller _createCastorMarshaller()
//    throws Exception
//    {
//        String  url = getClass().getResource(
//                        "/six-oval_castor-xml-mapping.xml" ).toString();
//        Mapping  mapping = new Mapping();
//        mapping.loadMapping( url );
//        Marshaller  marshaller = new Marshaller();
//        marshaller.setMapping( mapping );
//
//        return marshaller;
//    }

}
// XmlMarshllingTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */
