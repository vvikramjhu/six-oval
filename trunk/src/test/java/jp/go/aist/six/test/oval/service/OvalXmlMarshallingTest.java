package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.definition.Affected;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.DefinitionClass;
import jp.go.aist.six.oval.model.definition.Metadata;
import jp.go.aist.six.oval.model.definition.Platform;
import jp.go.aist.six.oval.model.definition.Product;
import jp.go.aist.six.oval.model.definition.Reference;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.service.Oval;
import jp.go.aist.six.oval.service.OvalXml;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXmlMarshallingTest.java 697 2010-04-26 10:25:37Z akihito $
 */
public class OvalXmlMarshallingTest
{

    private OvalXml  _xmlMapper = null;



    /**
     */
    public OvalXmlMarshallingTest()
    {
    }



    /**
     * @testng.before-class alwaysRun="true"
     */
    public void setUp()
    throws Exception
    {
        _xmlMapper = Oval.getXml();
    }



    //==============================================================
    //  test
    //==============================================================

    /**
     * @testng.data-provider name="oval-test"
     */
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
                            ComponentType.INDEPENDENT_UNKNOWN
                        },
                        // Registry test
                        {
                            "test/data/sample_oval-test-registry.xml",
                            "oval:org.mitre.oval:tst:3019",
                            2,
                            "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.AT_LEAST_ONE,
                            ComponentType.WINDOWS_REGISTRY
                        }
        };
    }



    /**
     * @testng.test groups="oval.xml test"
     *              dataProvider="oval-test"
     *              alwaysRun="true"
     */
    public void marshalTest(
                    final String filepath,
                    final String id,
                    final int version,
                    final String comment,
                    final Existence existence,
                    final Check check,
                    final ComponentType type
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
        Assert.assertEquals( type, test.getTestType() );

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
    public Object[][] ovalSystemObjectProvider()
    {
        return new Object[][] {
                        {
                            "test/data/sample_oval-object-family.xml",
                            "oval:org.mitre.oval:obj:99",
                            1,
                            "This is the default family object. Only one family object should exist.",
                            ComponentType.INDEPENDENT_FAMILY
                        },
                        {
                            "test/data/sample_oval-object-rpminfo.xml",
                            "oval:com.redhat.rhsa:obj:20100061001",
                            301,
                            null,
                            ComponentType.LINUX_RPMINFO
                        }
        };
    }



    /**
     * @testng.test groups="oval.xml object"
     *              dataProvider="oval-object"
     *              alwaysRun="true"
     */
    public void marshalSystemObject(
                    final String filepath,
                    final String id,
                    final int version,
                    final String comment,
                    final ComponentType type
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
        Assert.assertEquals( type, object.getSystemObjectType() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xmlMapper.marshalToString( object );
        Reporter.log( "  @ marshalled XML: " + xml, true );
    }



    //==============================================================
    //  definition
    //==============================================================

    /**
     * @testng.data-provider name="oval-definition"
     */
    public Object[][] ovalDefinitionProvider()
    {
        return new Object[][] {
                        {
                            "test/data/sample_oval-definition-1.xml",
                            "oval:org.mitre.oval:def:1020",
                            2,
                            DefinitionClass.VULNERABILITY
                        }
        };
    }



    /**
     * @testng.test groups="oval.xml definition"
     *              dataProvider="oval-definition"
     *              alwaysRun="true"
     *              dependsOnGroups="definition.metadata"
     */
    public void marshalDefinition(
                    final String filepath,
                    final String id,
                    final int version,
                    final DefinitionClass clazz
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling/marshalling from/to XML //", true );
        Reporter.log( "  * xpath: definition", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Definition );
        Definition  def = Definition.class.cast( obj );
        Assert.assertEquals( id, def.getOvalID() );
        Assert.assertEquals( version, def.getOvalVersion() );
        Assert.assertEquals( clazz, def.getDefinitionClass() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xmlMapper.marshalToString( def );
        Reporter.log( "  @ marshalled XML: " + xml, true );
    }



    //==============================================================
    //  definition/metadata
    //==============================================================

    /**
     * @testng.data-provider name="oval-definition-metadata"
     */
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
     * @testng.test groups="oval.xml definition.metadata"
     *              dataProvider="oval-definition-metadata"
     *              alwaysRun="true"
     *              dependsOnGroups="definition.metadata.affected"
     */
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
     * @testng.data-provider name="oval-definition-metadata-affected"
     */
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

