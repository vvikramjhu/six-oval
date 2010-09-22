package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Cpe;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.Product;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.linux.BugzillaReference;
import jp.go.aist.six.oval.model.linux.CveReference;
import jp.go.aist.six.oval.model.linux.LinuxSecurityAdvisory;
import jp.go.aist.six.oval.model.linux.Severity;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import java.util.Arrays;
import java.util.Date;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefOvalDefinitionsTest
    extends CoreTestBase
{

    //==============================================================
    //  oval_definitions
    //==============================================================

    public static final Affected AFFECTED_20100061_301 =
        new Affected( Family.UNIX,
                        new Platform[] {
                                            new Platform( "Red Hat Enterprise Linux 3" ),
                                            new Platform( "Red Hat Enterprise Linux 4" ),
                                            new Platform( "Red Hat Enterprise Linux 5" )
                                       },
                        new Product[] { }
        );


    public static final Definition  DEFINITION_20100061_301 =
        new Definition( "oval:com.redhat.rhsa:def:20100061", 301 );
    {
        DEFINITION_20100061_301.setDefinitionClass( DefinitionClass.PATCH );

        Metadata  metadata = new Metadata(
                        "RHSA-2010:0061: gzip security update (Moderate)",
                        "The gzip package provides the GNU gzip data compression program. An integer underflow flaw, leading to an array index error, was found in the way gzip expanded archive files compressed with the Lempel-Ziv-Welch (LZW) compression algorithm. If a victim expanded a specially-crafted archive, it could cause gzip to crash or, potentially, execute arbitrary code with the privileges of the user running gzip. This flaw only affects 64-bit systems. (CVE-2010-0001) Red Hat would like to thank Aki Helin of the Oulu University Secure Programming Group for responsibly reporting this flaw. Users of gzip should upgrade to this updated package, which contains a backported patch to correct this issue."
                        );
        metadata.setAffected( AFFECTED_20100061_301 );
        metadata.addReference(
                        new Reference(
                                        "RHSA",
                                        "RHSA-2010:0061-00",
                                        "https://rhn.redhat.com/errata/RHSA-2010-0061.html"
                                        )
                        );

        CveReference[]  cveList = new CveReference[] {
                        new CveReference( "CVE-2010-0001", "https://www.redhat.com/security/data/cve/CVE-2010-0001.html" )
        };

        BugzillaReference[]  bugzillaList = new BugzillaReference[] {
                        new BugzillaReference( "554418", "http://bugzilla.redhat.com/554418", "CVE-2010-0001 gzip: (64 bit) Integer underflow by decompressing LZW format files" )
        };

        Cpe[]  cpeList = new Cpe[] {
                        new Cpe( "cpe:/o:redhat:enterprise_linux" )
        };

        LinuxSecurityAdvisory  advisory =
            new LinuxSecurityAdvisory(
                            "secalert@redhat.com",
                            "Copyright 2010 Red Hat, Inc.",
                            Severity.MODERATE,
                            "2010-01-20",
                            "2010-01-20",
                            Arrays.asList( cveList ),
                            Arrays.asList( bugzillaList ),
                            Arrays.asList( cpeList )
                            );
        metadata.addAdditionalMetadata( advisory );

        DEFINITION_20100061_301.setMetadata( metadata );
    }




    @DataProvider( name="oval-def-oval_definitions" )
    public Object[][] ovalDefOvalDefinitionsProvider()
    {
//        SimpleDateFormat  format = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" );
        Date  mitreTimestamp = null;
        try {
//            timestamp = format.parse( "2010-06-15T05:04:34.164-0400" );
            mitreTimestamp = (new org.exolab.castor.types.DateTime( "2010-06-15T05:04:34.164-04:00" )).toDate();
        } catch (Exception ex) {
            Reporter.log( "ERROR: timestamp parse: " + ex.getMessage(), true );
        }

        Date  redhatTimestamp = null;
        try {
            redhatTimestamp = (new org.exolab.castor.types.DateTime( "2010-01-20T09:40:09" )).toDate();
        } catch (Exception ex) {
            Reporter.log( "ERROR: timestamp parse: " + ex.getMessage(), true );
        }

        return new Object[][] {
//                        {
//                            "oval-def:oval_definitions",
//                            "test/data/definition/oval-def-oval_definitions.0.xml",
//                            new Generator(
//                                            "5.7",
//                                            mitreTimestamp,
//                                            "The OVAL Repository",
//                                            null
//                                            ),
//                            new Definitions(
//                                            new Definition[] {
//                                                            DEFINITION_1020_2
//                                            }
//                                            )
//                        }
//                        ,
                        {
                            "oval-def:oval_definitions",
                            "test/data/definition/oval-2010-06-15.05.04.34.xml",
                            new Generator(
                                            "5.7",
                                            mitreTimestamp,
                                            "The OVAL Repository",
                                            null
                                            ),
                            new Definitions(
                                            new Definition[] {
                                                            DEFINITION_1020_2
                                            }
                                            )
                        }
                        ,

                        // Red Hat
                        {
                            "oval-def:oval_definitions",
                            "test/data/definition/com.redhat.rhsa-20100061.xml",
                            new Generator(
                                            "5.3",
                                            redhatTimestamp,
                                            "Red Hat Errata System",
                                            null
                                            ),
                            new Definitions(
                                            new Definition[] {
                                                            DEFINITION_20100061_301
                                            }
                                            )
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.store", "oval-def.oval_definitions"},
                    dataProvider="oval-def-oval_definitions",
                    alwaysRun=true
                    )
    public void testOvalDefinitions(
                    final String testTarget,
                    final String filepath,
                    final Generator generator,
                    final Definitions definitions
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        OvalDefinitions  ovalDefs = _unmarshalFromFile( filepath, OvalDefinitions.class );

        Reporter.log( "validating...", true );
        _validate( ovalDefs.getGenerator(), generator );
        _validate( ovalDefs.getDefinitions(), definitions );
        Reporter.log( "...validation OK", true );

        Reporter.log( "syncing...", true );
        OvalDefinitions  p_ovalDefs = _getStore().sync( OvalDefinitions.class, ovalDefs );
        String  pid = p_ovalDefs.getPersistentID();
        Reporter.log( "...syncing done: pid=" + pid, true );
    }

}
// StoreDefOvalDefinitionsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

