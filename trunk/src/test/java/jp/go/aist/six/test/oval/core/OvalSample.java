package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Operation;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.EntityObjectInt;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.independent.EntityStateFamily;
import jp.go.aist.six.oval.model.independent.FamilyObject;
import jp.go.aist.six.oval.model.independent.FamilyState;
import jp.go.aist.six.oval.model.independent.FamilyTest;
import jp.go.aist.six.oval.model.independent.TextFileContentObject;
import jp.go.aist.six.oval.model.independent.TextFileContentState;
import jp.go.aist.six.oval.model.independent.TextFileContentTest;
import jp.go.aist.six.oval.model.independent.UnknownTest;
import jp.go.aist.six.oval.model.linux.DpkgInfoObject;
import jp.go.aist.six.oval.model.linux.DpkgInfoState;
import jp.go.aist.six.oval.model.linux.DpkgInfoTest;
import jp.go.aist.six.oval.model.linux.RpmInfoObject;
import jp.go.aist.six.oval.model.linux.RpmInfoState;
import jp.go.aist.six.oval.model.linux.RpmInfoTest;
import jp.go.aist.six.oval.model.unix.UnameObject;
import jp.go.aist.six.oval.model.unix.UnameTest;
import jp.go.aist.six.oval.model.windows.EntityObjectRegistryHive;
import jp.go.aist.six.oval.model.windows.FileObject;
import jp.go.aist.six.oval.model.windows.FileState;
import jp.go.aist.six.oval.model.windows.FileTest;
import jp.go.aist.six.oval.model.windows.MetabaseObject;
import jp.go.aist.six.oval.model.windows.MetabaseState;
import jp.go.aist.six.oval.model.windows.MetabaseTest;
import jp.go.aist.six.oval.model.windows.RegistryObject;
import jp.go.aist.six.oval.model.windows.RegistryState;
import jp.go.aist.six.oval.model.windows.RegistryTest;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSample
{

    //==============================================================
    //  def:definition
    //==============================================================

    public static final Affected  affected8500 = new Affected( Family.WINDOWS )
    .platform( "Microsoft Windows 2000" )
    .platform( "Microsoft Windows XP" )
    .platform( "Microsoft Windows Server 2003" )
    .platform( "Microsoft Windows Vista" )
    .platform( "Microsoft Windows 7" )
    .platform( "Microsoft Windows Server 2008" )
    .product( "MySQL Server 5.0" )
    .product( "MySQL Server 5.1" );


    public static final Metadata  meta8500 =
        new Metadata( "MySQL 5.0 and 5.1 SELECT Statement DOS Vulnerability",
                        "mysqld in MySQL 5.0.x before 5.0.88 and 5.1.x before 5.1.41"
                        + " does not (1) properly handle errors during execution of certain SELECT statements with subqueries, and does not"
                        + " (2) preserve certain null_value flags during execution of statements"
                        + " that use the GeomFromWKB function, which allows remote authenticated users"
                        + " to cause a denial of service (daemon crash) via a crafted statement."
        )
    .affected( affected8500 )
    .reference( new Reference( "CVE", "CVE-2009-4019", "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2009-4019") );


    public static final Definition  def8500 =
        new Definition( "oval:org.mitre.oval:def:8500", 1,
                        DefinitionClass.VULNERABILITY,
                        meta8500
                        );


    public static final Affected  affected8297 = new Affected( Family.WINDOWS )
    .platform( "Microsoft Windows 2000" )
    .platform( "Microsoft Windows XP" )
    .platform( "Microsoft Windows Server 2003" )
    .platform( "Microsoft Windows Vista" )
    .platform( "Microsoft Windows 7" )
    .platform( "Microsoft Windows Server 2008" )
    .product( "MySQL Server 5.1" );


    public static final Metadata  meta8297 =
        new Metadata( "MySQL 5.1 is installed",
                        "MySQL Server 5.1 is installed"
        )
    .affected( affected8297 )
    .reference( new Reference( "CPE", "cpe:/a:mysql:mysql:5.1", null ) );


    public static final Definition  def8297 =
        new Definition( "oval:org.mitre.oval:def:8297", 1,
                        DefinitionClass.INVENTORY,
                        meta8297
                        );


    public static final Affected  affected20100332 =
        new Affected( Family.UNIX )
    .platform( "Red Hat Enterprise Linux 5" )
    .platform( "Red Hat Enterprise Linux 4" );


    public static final Metadata  meta20100332 =
        new Metadata( "RHSA-2010:0332: firefox security update (Critical)",
                        "Mozilla Firefox is an open source Web browser. XULRunner provides the XUL\n"
                        + "Runtime environment for Mozilla Firefox. Several use-after-free flaws were found in Firefox. Visiting a web page\n"
                        + "containing malicious content could result in Firefox executing arbitrary code with the privileges of the user running Firefox. (CVE-2010-0175,\n"
                        + "CVE-2010-0176, CVE-2010-0177) A flaw was found in Firefox that could allow an applet to generate a drag\n"
                        + "and drop action from a mouse click. Such an action could be used to execute arbitrary JavaScript with the privileges of the user running Firefox.\n"
                        + "(CVE-2010-0178) A privilege escalation flaw was found in Firefox when the Firebug add-on is\n"
                        + "in use. The XMLHttpRequestSpy module in the Firebug add-on exposes a Chrome privilege escalation flaw that could be used to execute arbitrary\n"
                        + "JavaScript with the privileges of the user running Firefox. (CVE-2010-0179) Several flaws were found in the processing of malformed web content. A web\n"
                        + "page containing malicious content could cause Firefox to crash or, potentially, execute arbitrary code with the privileges of the user running\n"
                        + "Firefox. (CVE-2010-0174) For technical details regarding these flaws, refer to the Mozilla security\n"
                        + "advisories for Firefox 3.0.19. You can find a link to the Mozilla advisories in the References section of this erratum.\n\n"
                        + "All Firefox users should upgrade to these updated packages, which contain Firefox version 3.0.19, which corrects these issues. After installing the\n"
                        + "update, Firefox must be restarted for the changes to take effect."
        )
    .affected( affected20100332 )
    .reference( new Reference( "RHSA", "RHSA-2010:0332-00", "https://rhn.redhat.com/errata/RHSA-2010-0332.html" ) );


    public static final Definition  def20100332 =
        new Definition( "oval:com.redhat.rhsa:def:20100332", 301,
                        DefinitionClass.PATCH,
                        meta20100332
                        );



    //==============================================================
    //  def:test
    //==============================================================

    public static final Test  TEST_FAMILY_99 =
        new FamilyTest( "oval:org.mitre.oval:tst:99", 1,
                        "the installed operating system is part of the Microsoft Windows family",
                        Check.ONLY_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:99" )
    .state( "oval:org.mitre.oval:ste:99" );


    public static final Test  TEST_TEXTFILECONTENT_11150 =
        new TextFileContentTest( "oval:org.mitre.oval:tst:11150", 1,
                        "Debian GNU/Linux 5.0 is installed",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:7326" )
    .state( "oval:org.mitre.oval:ste:5739" );


    public static final Test  TEST_UNKNOWN_2531 =
        new UnknownTest( "oval:org.mitre.oval:tst:2531", 1,
                        "Word 97 is installed",
                        Check.ALL );


    public static final Test  TEST_DPKGINFO_19402 =
        new DpkgInfoTest( "oval:org.mitre.oval:tst:19402", 1,
                        "apache2-src is earlier than 2.2.9-10+lenny6",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:10286" )
    .state( "oval:org.mitre.oval:ste:6372" );


    public static final Test  TEST_RPMINFO_20100061002 =
        new RpmInfoTest( "oval:com.redhat.rhsa:tst:20100061002", 301,
                        "gzip is earlier than 0:1.3.5-11.el5_4.1",
                        Check.AT_LEAST_ONE )
    .object( "oval:com.redhat.rhsa:obj:20100061002" )
    .state( "oval:com.redhat.rhsa:ste:20100061004" );



    public static final Test  TEST_UNAME_11195 =
        new UnameTest( "oval:org.mitre.oval:tst:11195", 1,
                        "Installed architecture is mips",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:2759" )
    .state( "oval:org.mitre.oval:ste:5601" );


    public static final Test  TEST_FILE_2339 =
        new FileTest( "oval:org.mitre.oval:tst:2339", 1,
                        "the version of mshtml.dll is less than 6.0.2900.2873",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:222" )
    .state( "oval:org.mitre.oval:ste:2190" );


    public static final Test  TEST_FILE_10629 =
        new FileTest( "oval:org.mitre.oval:tst:10629", 1,
                        "Opera.exe version 9.x to 10.0.x",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .stateOperator( Operator.OR )
    .object( "oval:org.mitre.oval:obj:6638" )
    .state( "oval:org.mitre.oval:ste:4847" )
    .state( "oval:org.mitre.oval:ste:5298" );


    public static final Test  TEST_METABASE_709 =
        new MetabaseTest( "oval:org.mitre.oval:tst:709", 2,
                        "Negotiate is enabled",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:556" );


    public static final Test  TEST_REGISTRY_3019 =
        new RegistryTest( "oval:org.mitre.oval:tst:3019", 2,
                        "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:717" )
    .state( "oval:org.mitre.oval:ste:2827" );



    //==============================================================
    //  def:state
    //==============================================================


    @DataProvider( name="definitions.state" )
    public Object[][] provideDefinitionsState()
    {
        EntityStateFamily  stateFamily =
            new EntityStateFamily( Family.WINDOWS, Operation.CASE_INSENSITIVE_EQUALS );

        EntityStateAnySimple  subexpression =
            new EntityStateAnySimple( "\\brw\\b",
                            Operation.PATTERN_MATCH );

        EntityStateString  fileVersion =
            new EntityStateString( "6.0.2900.2873",
                            Datatype.VERSION,
                            Operation.LESS_THAN );

        EntityStateAnySimple  metabaseData =
            new EntityStateAnySimple( "^http:*,PERMANENT,*",
                            Operation.PATTERN_MATCH );

        EntityStateAnySimple  registryValue =
            new EntityStateAnySimple( "1",
                            Datatype.INT,
                            Operation.EQUALS );

        EntityStateString  dpkginfoEvr =
            new EntityStateString( "0:2.2.6-02-1+lenny2+b2",
                            Datatype.EVR_STRING,
                            Operation.LESS_THAN );

        EntityStateString  rpminfoEvr =
            new EntityStateString( "0:1.3.5-11.el5_4.1",
                            Datatype.EVR_STRING,
                            Operation.LESS_THAN );

        EntityStateString  rpminfoVersion =
            new EntityStateString( "^5[^[:digit:]]",
                            Operation.PATTERN_MATCH );

        EntityStateString  rpminfoSignatureKeyID =
            new EntityStateString( "5326810137017186",
                            Operation.EQUALS );

        return new Object[][] {
                        // independent : family
                        {
                            State.class,
                            "test/data/definitions/state-family_oval-ste-99_2.xml",
                            "oval_definitions/states/independent:family_state",
                            new FamilyState( "oval:org.mitre.oval:ste:99",
                                            2 )
                                .family( stateFamily )
                                .comment( "the installed operating system is part of the Microsoft Windows family")
                        }
                        ,
                        // independent : textfilecontent
                        {
                            State.class,
                            "test/data/definitions/state-textfilecontent_oval-ste-5132_1.xml",
                            "oval_definitions/states/independent:textfilecontent_state",
                            new TextFileContentState( "oval:org.mitre.oval:ste:5132",
                                            1 )
                                .subExpression( subexpression )
                        }
                        ,
                        // windows : file
                        {
                            State.class,
                            "test/data/definitions/state-file_oval-ste-2190_1.xml",
                            "oval_definitions/states/windows:file_state",
                            new FileState( "oval:org.mitre.oval:ste:2190",
                                            1 )
                                .version( fileVersion )
                        }
                        ,
                        // windows : metabase
                        {
                            State.class,
                            "test/data/definitions/state-metabase_oval-ste-537_1.xml",
                            "oval_definitions/states/windows:metabase_state",
                            new MetabaseState( "oval:org.mitre.oval:ste:537",
                                            1 )
                                .data( metabaseData )
                        }
                        ,
                        // windows : registry
                        {
                            State.class,
                            "test/data/definitions/state-registry_oval-ste-1205_1.xml",
                            "oval_definitions/states/windows:registry_state",
                            new RegistryState( "oval:org.mitre.oval:ste:1205",
                                            1 )
                                .value( registryValue )
                        }
                        ,
                        // linux : dpkginfo
                        {
                            State.class,
                            "test/data/definitions/state-dpkginfo_oval-ste-5797_1.xml",
                            "oval_definitions/states/linux:dpkginfo_state",
                            new DpkgInfoState( "oval:org.mitre.oval:ste:5797",
                                            1 )
                                .evr( dpkginfoEvr )
                        }
                        ,
                        // linux : rpminfo/evr
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061004_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061004",
                                            301 )
                                .evr( rpminfoEvr )
                        }
                        ,
                        // linux : rpminfo/version
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061003_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061003",
                                            301 )
                                .version( rpminfoVersion )
                        }
                        ,
                        // linux : rpminfo/signature_keyid
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061002_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061002",
                                            301 )
                                .signatureKeyID( rpminfoSignatureKeyID )
                        }
        };

    }



    //==============================================================
    //  def:object
    //==============================================================

    @DataProvider( name="definitions.object" )
    public Object[][] provideDefinitionsObject()
    {
        EntityObjectString  textfilecontentLine = new EntityObjectString( "\\d\\.\\d" );
        textfilecontentLine.setOperation( Operation.PATTERN_MATCH );

        EntityObjectString  filePath = new EntityObjectString();
        filePath.setVarRef( "oval:org.mitre.oval:var:200" );
        filePath.setVarCheck( Check.ALL );

        EntityObjectInt  metabaseID = new EntityObjectInt( "6032" );
        metabaseID.setDatatype( Datatype.INT );

        return new Object[][] {
                        // independent : family
                        {
                            SystemObject.class,
                            "test/data/definitions/object-family_oval-obj-99_1.xml",
                            "oval_definitions/objects/independent:family_object",
                            new FamilyObject( "oval:org.mitre.oval:obj:99",
                                            1,
                                            "This is the default family object. Only one family object should exist."
                                            )
                        }
                        ,
                        // independent : textfilecontent
                        {
                            SystemObject.class,
                            "test/data/definitions/object-textfilecontent_oval-obj-7326_1.xml",
                            "oval_definitions/objects/independent:textfilecontent_object",
                            new TextFileContentObject( "oval:org.mitre.oval:obj:7326",
                                            1
                                            )
                                .path( new EntityObjectString( "/etc" ) )
                                .filename( new EntityObjectString( "debian_version" ) )
                                .line( textfilecontentLine )
                        }
                        ,
                        // linux : dpkginfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-dpkginfo_oval-obj-10648_1.xml",
                            "oval_definitions/objects/linux:dpkginfo_object",
                            new DpkgInfoObject( "oval:org.mitre.oval:obj:10648",
                                            1,
                                            "apache2 package information"
                                            )
                                .name( new EntityObjectString( "apache2" ) )
                        }
                        ,
                        // linux : rpminfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-rpminfo_rhsa-obj-20100061001_301.xml",
                            "oval_definitions/objects/linux:rpminfo_object",
                            new RpmInfoObject( "oval:com.redhat.rhsa:obj:20100061001",
                                            301
                                            )
                                .name( new EntityObjectString( "redhat-release" ) )
                        }
                        ,
                        // unux : uname
                        {
                            SystemObject.class,
                            "test/data/definitions/object-uname_oval-obj-2759_1.xml",
                            "oval_definitions/objects/unix:uname_object",
                            new UnameObject( "oval:org.mitre.oval:obj:2759",
                                            1,
                                            "The single uname object."
                                            )
                        }
                        ,
//                        // windows : file
                        {
                            SystemObject.class,
                            "test/data/definitions/object-file_oval-obj-222_1.xml",
                            "oval_definitions/objects/windows:file_object",
                            new FileObject( "oval:org.mitre.oval:obj:222",
                                            1,
                                            "The path to the mshtml.dll file in the system root"
                                            )
                                .path( filePath )
                                .filename( new EntityObjectString( "mshtml.dll" ) )
                        }
                        ,
                        // windows : metabase
                        {
                            SystemObject.class,
                            "test/data/definitions/object-metabase_oval-obj-556_2.xml",
                            "oval_definitions/objects/windows:metabase_object",
                            new MetabaseObject( "oval:org.mitre.oval:obj:556",
                                            2
                                            )
                                .key( new EntityObjectString( "LM/W3SVC" ) )
                                .ID( metabaseID )
                        }
                        ,
                        // windows : registry
                        {
                            SystemObject.class,
                            "test/data/definitions/object-registry_oval-obj-717_1.xml",
                            "oval_definitions/objects/windows:registry_object",
                            new RegistryObject( "oval:org.mitre.oval:obj:717",
                                            1,
                                            "This registry key holds the service pack installed on the host if one is present."
                                            )
                                .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
                                .key( new EntityObjectString( "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion" ) )
                                .name( new EntityObjectString( "CSDVersion" ) )
                        }
        };
    }

}
// OvalSample

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

