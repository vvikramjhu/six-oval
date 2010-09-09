package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.common.Operation;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.EntityObjectInt;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.ExtendDefinition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Reference;
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
import jp.go.aist.six.oval.model.results.CriteriaResult;
import jp.go.aist.six.oval.model.results.CriterionResult;
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.ExtendDefinitionResult;
import jp.go.aist.six.oval.model.results.Result;
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.sc.CollectedSystemObject;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Flag;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.ItemReference;
import jp.go.aist.six.oval.model.sc.NetInterface;
import jp.go.aist.six.oval.model.sc.Status;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.oval.model.sc.VariableValue;
import jp.go.aist.six.oval.model.unix.UnameObject;
import jp.go.aist.six.oval.model.unix.UnameTest;
import jp.go.aist.six.oval.model.windows.EntityItemFileType;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryHive;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryType;
import jp.go.aist.six.oval.model.windows.EntityObjectRegistryHive;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.FileObject;
import jp.go.aist.six.oval.model.windows.FileState;
import jp.go.aist.six.oval.model.windows.FileTest;
import jp.go.aist.six.oval.model.windows.FileType;
import jp.go.aist.six.oval.model.windows.MetabaseObject;
import jp.go.aist.six.oval.model.windows.MetabaseState;
import jp.go.aist.six.oval.model.windows.MetabaseTest;
import jp.go.aist.six.oval.model.windows.RegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryItem;
import jp.go.aist.six.oval.model.windows.RegistryObject;
import jp.go.aist.six.oval.model.windows.RegistryState;
import jp.go.aist.six.oval.model.windows.RegistryTest;
import jp.go.aist.six.oval.model.windows.RegistryType;
import jp.go.aist.six.util.IsoDate;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSample
{

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


    //**************************************************************
    // oval:org.mitre.oval:def:8500 related test
    //**************************************************************

    public static final Test  TEST_REGISTRY_21087 =
        new RegistryTest( "oval:org.mitre.oval:tst:21087", 1,
                        "MySQL 5.1 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:911" )
    .state( "oval:org.mitre.oval:ste:6216" );


    public static final Test  TEST_FILE_21031 =
        new FileTest( "oval:org.mitre.oval:tst:21031", 1,
                        "mysqld.exe or mysqld-nt.exe exists",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .stateOperator( Operator.OR )
    .object( "oval:org.mitre.oval:obj:11786" );


    public static final Test  TEST_REGISTRY_20481 =
        new RegistryTest( "oval:org.mitre.oval:tst:20481", 1,
                        "MySQL 5.0 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:911" )
    .state( "oval:org.mitre.oval:ste:6475" );


    public static final Test  TEST_REGISTRY_20859 =
        new RegistryTest( "oval:org.mitre.oval:tst:20859", 1,
                        "MySQL Server 5.1 version is less than 5.1.41",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:11866" )
    .state( "oval:org.mitre.oval:ste:6693" );


    public static final Test  TEST_REGISTRY_20192 =
        new RegistryTest( "oval:org.mitre.oval:tst:20192", 1,
                        "MySQL Server 5.0 version is less than 5.0.88",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:11871" )
    .state( "oval:org.mitre.oval:ste:6359" );



    //==============================================================
    //  def:object
    //==============================================================

    public static final FamilyObject  OBJECT_FAMILY_99 =
        new FamilyObject( "oval:org.mitre.oval:obj:99", 1,
                    "This is the default family object. Only one family object should exist."
                    );


    public static final TextFileContentObject  OBJECT_TEXTFILECONTENT_7326 =
        new TextFileContentObject( "oval:org.mitre.oval:obj:7326", 1 )
    .path( new EntityObjectString( "/etc" ) )
    .filename( new EntityObjectString( "debian_version" ) )
    .line( new EntityObjectString( "\\d\\.\\d", Operation.PATTERN_MATCH ) );


    public static final DpkgInfoObject  OBJECT_DPKGINFO_10648 =
        new DpkgInfoObject( "oval:org.mitre.oval:obj:10648", 1,
                        "apache2 package information"
        )
    .name( new EntityObjectString( "apache2" ) );


    public static final RpmInfoObject  OBJECT_RPMINFO_20100061001 =
        new RpmInfoObject( "oval:com.redhat.rhsa:obj:20100061001", 301 )
    .name( new EntityObjectString( "redhat-release" ) );


    public static final UnameObject  OBJECT_UNAME_2759 =
        new UnameObject( "oval:org.mitre.oval:obj:2759", 1,
                        "The single uname object."
        );


    public static final FileObject  OBJECT_FILE_222 =
        new FileObject( "oval:org.mitre.oval:obj:222", 1,
                        "The path to the mshtml.dll file in the system root"
        )
    .path( new EntityObjectString( "oval:org.mitre.oval:var:200", Check.ALL ) )
    .filename( new EntityObjectString( "mshtml.dll" ) );


    public static final MetabaseObject  OBJECT_METABASE_556 =
        new MetabaseObject( "oval:org.mitre.oval:obj:556", 2 )
    .key( new EntityObjectString( "LM/W3SVC" ) )
    .ID( new EntityObjectInt( "6032", Datatype.INT, EntityObjectInt.DEFAULT_OPERATION ) );


    public static final RegistryObject  OBJECT_REGISTRY_717 =
        new RegistryObject( "oval:org.mitre.oval:obj:717", 1,
                        "This registry key holds the service pack installed on the host if one is present."
        )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion" ) )
    .name( new EntityObjectString( "CSDVersion" ) );


    //**************************************************************
    // oval:org.mitre.oval:def:8500 related object
    //**************************************************************

    public static final FileObject  OBJECT_FILE_11786 =
        new FileObject( "oval:org.mitre.oval:obj:11786", 1,
                        "Full path to MySQL executable"
        )
    .path( new EntityObjectString( "oval:org.mitre.oval:var:349", Check.ALL ) )
    .filename( new EntityObjectString( "^mysqld(|-nt)\\.exe$", Operation.PATTERN_MATCH ) );


    public static final RegistryObject  OBJECT_REGISTRY_11992 =
        new RegistryObject( "oval:org.mitre.oval:obj:11992", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "^SOFTWARE\\\\MySQL AB\\\\MySQL Server [0-9]\\.[0-9]$", Operation.PATTERN_MATCH ) )
    .name( new EntityObjectString( "Location" ) );


    public static final RegistryObject  OBJECT_REGISTRY_911 =
        new RegistryObject( "oval:org.mitre.oval:obj:911", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "^Software\\\\Microsoft\\\\Windows\\\\CurrentVersion\\\\Uninstall\\\\.*", Operation.PATTERN_MATCH ) )
    .name( new EntityObjectString( "DisplayName" ) );


    public static final RegistryObject  OBJECT_REGISTRY_11866 =
        new RegistryObject( "oval:org.mitre.oval:obj:11866", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\MySQL AB\\MySQL Server 5.1" ) )
    .name( new EntityObjectString( "Version" ) );


    public static final RegistryObject  OBJECT_REGISTRY_11871 =
        new RegistryObject( "oval:org.mitre.oval:obj:11871", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\MySQL AB\\MySQL Server 5.0" ) )
    .name( new EntityObjectString( "Version" ) );



    //==============================================================
    //  def:state
    //==============================================================

    public static final FamilyState  STATE_FAMILY_99 =
        new FamilyState( "oval:org.mitre.oval:ste:99", 2,
        "Microsoft Windows family" )
    .family( new EntityStateFamily( Family.WINDOWS,
                    Operation.CASE_INSENSITIVE_EQUALS )
    );


    public static final TextFileContentState  STATE_TEXTFILECONTENT_5132 =
        new TextFileContentState( "oval:org.mitre.oval:ste:5132", 1 )
    .subExpression( new EntityStateAnySimple( "\\brw\\b",
                    Operation.PATTERN_MATCH )
    );


    public static final FileState  STATE_FILE_2190 =
        new FileState( "oval:org.mitre.oval:ste:2190", 1 )
    .version( new EntityStateString( "6.0.2900.2873",
                    Datatype.VERSION, Operation.LESS_THAN )
    );


    public static final MetabaseState  STATE_METABASE_537 =
        new MetabaseState( "oval:org.mitre.oval:ste:537", 1 )
    .data( new EntityStateAnySimple( "^http:*,PERMANENT,*",
                    Operation.PATTERN_MATCH )
    );


    public static final RegistryState  STATE_REGISTRY_1205 =
        new RegistryState( "oval:org.mitre.oval:ste:1205", 1 )
    .value( new EntityStateAnySimple( "1",
                    Datatype.INT,
                    Operation.EQUALS )
    );


    public static final DpkgInfoState  STATE_DPKGINFO_5797 =
        new DpkgInfoState( "oval:org.mitre.oval:ste:5797", 1 )
    .evr( new EntityStateString( "0:2.2.6-02-1+lenny2+b2",
                    Datatype.EVR_STRING,
                    Operation.LESS_THAN )
    );


    public static final RpmInfoState  STATE_RPMINFO_20100061004 =
        new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061004", 301 )
    .evr( new EntityStateString( "0:1.3.5-11.el5_4.1",
                    Datatype.EVR_STRING,
                    Operation.LESS_THAN )
    );


    public static final RpmInfoState  STATE_RPMINFO_20100061003 =
        new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061003", 301 )
    .version( new EntityStateString( "^5[^[:digit:]]",
                    Operation.PATTERN_MATCH )
    );


    public static final RpmInfoState  STATE_RPMINFO_20100061002  =
        new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061002", 301 )
    .signatureKeyID( new EntityStateString( "5326810137017186",
                    Operation.EQUALS )
    );


    //**************************************************************
    // oval:org.mitre.oval:def:8500 related state
    //**************************************************************

    public static final RegistryState  STATE_REGISTRY_6216 =
        new RegistryState( "oval:org.mitre.oval:ste:6216", 1,
                        "MySQL 5.1 check"
        )
    .value( new EntityStateAnySimple( "MySQL Server 5.1" )
    );


    public static final RegistryState  STATE_REGISTRY_6475 =
        new RegistryState( "oval:org.mitre.oval:ste:6475", 1,
                        "MySQL 5.0 check"
        )
    .value( new EntityStateAnySimple( "MySQL Server 5.0" )
    );


    public static final RegistryState  STATE_REGISTRY_6693 =
        new RegistryState( "oval:org.mitre.oval:ste:6693", 1,
                        "MySQL Server 5.1 version is less than 5.1.41"
        )
    .value( new EntityStateAnySimple( "^5\\.1\\.(([0-9]|[1-3][0-9]|40)?(|[a-z\\_\\-]+))$",
                    Operation.PATTERN_MATCH )
    );


    public static final RegistryState  STATE_REGISTRY_6359 =
        new RegistryState( "oval:org.mitre.oval:ste:6359", 1,
                        "MySQL Server 5.0 version is less than 5.0.88"
        )
    .value( new EntityStateAnySimple( "5\\.0\\.([0-9]|[1-7][0-9]|8[0-7])?(|[a-z\\_\\-]+|\\..*)$",
                    Operation.PATTERN_MATCH )
    );



    //==============================================================
    //  def:definition
    //==============================================================

    //**************************************************************
    // oval:org.mitre.oval:def:8500, MySQL 5.0 and 5.1 SELECT Statement DOS Vulnerability
    //**************************************************************

    public static final Affected  AFFECTED_8500 = new Affected( Family.WINDOWS )
    .platform( "Microsoft Windows 2000" )
    .platform( "Microsoft Windows XP" )
    .platform( "Microsoft Windows Server 2003" )
    .platform( "Microsoft Windows Vista" )
    .platform( "Microsoft Windows 7" )
    .platform( "Microsoft Windows Server 2008" )
    .product( "MySQL Server 5.0" )
    .product( "MySQL Server 5.1" );


    public static final Metadata  METADATA_8500 =
        new Metadata( "MySQL 5.0 and 5.1 SELECT Statement DOS Vulnerability",
                        "mysqld in MySQL 5.0.x before 5.0.88 and 5.1.x before 5.1.41"
                        + " does not (1) properly handle errors during execution of certain SELECT statements with subqueries, and does not"
                        + " (2) preserve certain null_value flags during execution of statements"
                        + " that use the GeomFromWKB function, which allows remote authenticated users"
                        + " to cause a denial of service (daemon crash) via a crafted statement."
        )
    .affected( AFFECTED_8500 )
    .reference( new Reference( "CVE", "CVE-2009-4019", "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2009-4019") );


    private static final Criteria  _CRITERIA_8500_ =
        new Criteria( Operator.OR )
    .element(
                    new Criteria( Operator.AND )
                    .element( new ExtendDefinition( "oval:org.mitre.oval:def:8282",
                                    "MySQL 5.0 is installed" )
                    )
                    .element( new Criterion( "oval:org.mitre.oval:tst:20192",
                                    "MySQL Server 5.0 version is less than 5.0.88" )
                    )
    )
    .element(
                    new Criteria( Operator.AND )
                    .element( new ExtendDefinition( "oval:org.mitre.oval:def:8297",
                                    "MySQL 5.1 is installed" )
                    )
                    .element( new Criterion( "oval:org.mitre.oval:tst:20859",
                                    "MySQL Server 5.1 version is less than 5.1.41" )
                    )
    );


    public static final Definition  DEFINITION_8500 =
        new Definition( "oval:org.mitre.oval:def:8500", 1,
                        DefinitionClass.VULNERABILITY,
                        METADATA_8500
                        )
    .criteria( _CRITERIA_8500_ );


    //**************************************************************
    // oval:org.mitre.oval:def:8297, MySQL 5.1 is installed
    //**************************************************************

    public static final Affected  AFFECTED_8297 = new Affected( Family.WINDOWS )
    .platform( "Microsoft Windows 2000" )
    .platform( "Microsoft Windows XP" )
    .platform( "Microsoft Windows Server 2003" )
    .platform( "Microsoft Windows Vista" )
    .platform( "Microsoft Windows 7" )
    .platform( "Microsoft Windows Server 2008" )
    .product( "MySQL Server 5.1" );


    public static final Metadata  METADATA_8297 =
        new Metadata( "MySQL 5.1 is installed",
                        "MySQL Server 5.1 is installed"
        )
    .affected( AFFECTED_8297 )
    .reference( new Reference( "CPE", "cpe:/a:mysql:mysql:5.1", null ) );


    private static final Criteria  _CRITERIA_8297_ =
        new Criteria()
    .element( new Criterion( "oval:org.mitre.oval:tst:21031",
                    "mysqld.exe or mysqld-nt.exe exists" )
    )
    .element( new Criterion( "oval:org.mitre.oval:tst:21087",
                    "MySQL 5.1 is installed")
    );


    public static final Definition  DEFINITION_8297 =
        new Definition( "oval:org.mitre.oval:def:8297", 1,
                        DefinitionClass.INVENTORY,
                        METADATA_8297
                        )
    .criteria( _CRITERIA_8297_ );


    //**************************************************************
    // oval:org.mitre.oval:def:8282, MySQL 5.0 is installed
    //**************************************************************

    public static final Affected  AFFECTED_8282 = new Affected( Family.WINDOWS )
    .platform( "Microsoft Windows 2000" )
    .platform( "Microsoft Windows XP" )
    .platform( "Microsoft Windows Server 2003" )
    .platform( "Microsoft Windows Vista" )
    .platform( "Microsoft Windows 7" )
    .platform( "Microsoft Windows Server 2008" )
    .product( "MySQL Server 5.0" );


    public static final Metadata  METADATA_8282 =
        new Metadata( "MySQL 5.0 is installed",
                        "MySQL Server 5.0 is installed"
        )
    .affected( AFFECTED_8282 )
    .reference( new Reference( "CPE", "cpe:/a:mysql:mysql:5.0", null ) );


    private static final Criteria  _CRITERIA_8282_ =
        new Criteria()
    .element( new Criterion( "oval:org.mitre.oval:tst:20481",
                    "MySQL 5.0 is installed")
    )
    .element( new Criterion( "oval:org.mitre.oval:tst:21031",
                    "mysqld.exe or mysqld-nt.exe exists" )
    );


    public static final Definition  DEFINITION_8282 =
        new Definition( "oval:org.mitre.oval:def:8282", 1,
                        DefinitionClass.INVENTORY,
                        METADATA_8282
        )
    .criteria( _CRITERIA_8282_ );


    //**************************************************************
    // oval:com.redhat.rhsa:def:20100332, RHSA-2010:0332: firefox security update (Critical)
    //**************************************************************

    public static final Affected  AFFECTED_20100332 =
        new Affected( Family.UNIX )
    .platform( "Red Hat Enterprise Linux 5" )
    .platform( "Red Hat Enterprise Linux 4" );


    public static final Metadata  METADATA_20100332 =
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
    .affected( AFFECTED_20100332 )
    .reference( new Reference( "RHSA", "RHSA-2010:0332-00", "https://rhn.redhat.com/errata/RHSA-2010-0332.html" ) );


    private static final Criteria  _CRITERIA_20100332_ =
        new Criteria( Operator.OR )
    .element(
                    new Criteria( Operator.AND )
                    .element(
                                    new Criterion( "oval:com.redhat.rhsa:tst:20100332001",
                                    "Red Hat Enterprise Linux 5 is installed" )
                    )
                    .element(
                                    new Criteria( Operator.OR )
                                    .element(
                                                    new Criteria( Operator.AND )
                                                    .element( new Criterion( "oval:com.redhat.rhsa:tst:20100332006", "xulrunner-devel-unstable is earlier than 0:1.9.0.19-1.el5_5" ) )
                                                    .element( new Criterion( "oval:com.redhat.rhsa:tst:20100332007", "xulrunner-devel-unstable is signed with Red Hat redhatrelease key" ) )
                                    )
                                    .element(
                                                    new Criteria( Operator.AND )
                                                    .element( new Criterion( "oval:com.redhat.rhsa:tst:20100332002", "xulrunner is earlier than 0:1.9.0.19-1.el5_5" ) )
                                                    .element( new Criterion( "oval:com.redhat.rhsa:tst:20100332003", "xulrunner is signed with Red Hat redhatrelease key" ) )
                                    )
                                    .element(
                                                    new Criteria( Operator.AND )
                                                    .element( new Criterion( "oval:com.redhat.rhsa:tst:20100332004", "xulrunner-devel is earlier than 0:1.9.0.19-1.el5_5" ) )
                                                    .element( new Criterion( "oval:com.redhat.rhsa:tst:20100332005", "xulrunner-devel is signed with Red Hat redhatrelease key" ) )
                                    )
                                    .element(
                                                    new Criteria( Operator.AND )
                                                    .element( new Criterion( "oval:com.redhat.rhsa:tst:20100332008", "firefox is earlier than 0:3.0.19-1.el5_5" ) )
                                                    .element( new Criterion( "oval:com.redhat.rhsa:tst:20100332009", "firefox is signed with Red Hat redhatrelease key" ) )
                                    )
                    )
    )
    .element(
                    new Criteria( Operator.AND )
                    .element(
                                    new Criterion( "oval:com.redhat.rhsa:tst:20100332010", "Red Hat Enterprise Linux 4 is installed" )
                    )
                    .element(
                                    new Criterion( "oval:com.redhat.rhsa:tst:20100332011", "firefox is earlier than 0:3.0.19-1.el4" )
                    )
                    .element(
                                    new Criterion( "oval:com.redhat.rhsa:tst:20100332012", "firefox is signed with Red Hat master key" )
                    )
    );


    public static final Definition  DEFINITION_20100332 =
        new Definition( "oval:com.redhat.rhsa:def:20100332", 301,
                        DefinitionClass.PATCH,
                        METADATA_20100332
                        )
    .criteria( _CRITERIA_20100332_ );


    //==============================================================
    //  def:oval_definitions
    //==============================================================

    private static final Generator  _GENERATOR_8500_ =
        new Generator( "5.7",
                        IsoDate.valueOf( "2010-08-05T03:28:32.987" ),
                        "The OVAL Repository",
                        null
                        );


    public static final OvalDefinitions  OVAL_DEFINITIONS_8500 =
        new OvalDefinitions( _GENERATOR_8500_ )
    .definition( DEFINITION_8297 )
    .definition( DEFINITION_8500 )
    .definition( DEFINITION_8282 )
    .test( TEST_REGISTRY_21087 )
    .test( TEST_FILE_21031 )
    .test( TEST_REGISTRY_20481 )
    .test( TEST_REGISTRY_20859 )
    .test( TEST_REGISTRY_20192 )
    .object( OBJECT_FILE_11786 )
    .object( OBJECT_REGISTRY_11992 )
    .object( OBJECT_REGISTRY_911 )
    .object( OBJECT_REGISTRY_11866 )
    .object( OBJECT_REGISTRY_11871 )
    .state( STATE_REGISTRY_6216 )
    .state( STATE_REGISTRY_6475 )
    .state( STATE_REGISTRY_6693 )
    .state( STATE_REGISTRY_6359 )
    ;



    //==============================================================
    //  sc:system_info
    //==============================================================

    private static final NetInterface[]  _NET_INTERFACES_1_ =
        new NetInterface[] {
        new NetInterface( "Realtek RTL8168C(P)/8111C(P) Family PCI-E GBE NIC - パケット スケジューラ ミニポート",
                        "150.168.1.100",
                        "00-AA-BB-CC-11-22"
        ),
        new NetInterface( "VMware Virtual Ethernet Adapter for VMnet1",
                        "192.168.153.1",
                        "00-50-56-C0-00-01"
        ),
        new NetInterface( "VMware Virtual Ethernet Adapter for VMnet8",
                        "192.168.1.1",
                        "00-50-56-C0-00-08"
        )
    };


    private static final SystemInfo  _SYSTEM_INFO_1_ =
        new SystemInfo(
                        "Microsoft Windows XP Professional Service Pack 3",
                        "5.1.2600",
                        "INTEL32",
                        "foo.example.org",
                        _NET_INTERFACES_1_
        );


    private static final CollectedSystemObject _COLLECTED_OBJECT_911_ =
        new CollectedSystemObject( "oval:org.mitre.oval:obj:911", 1,
                        Flag.COMPLETE );
    //static initializer
    {
        for (int  item_ref = 3; item_ref < 197; item_ref++) {
            _COLLECTED_OBJECT_911_.addReference( new ItemReference( item_ref ) );
        }
    }


    private static final CollectedSystemObject[]  _COLLECTED_OBJECTS_1_ = new CollectedSystemObject[] {
        new CollectedSystemObject( "oval:org.mitre.oval:obj:11786", 1,
                        Flag.COMPLETE )
        .comment( "Full path to MySQL executable" )
        .reference( new ItemReference( 2 ) )
        .variableValue( new VariableValue( "oval:org.mitre.oval:var:349", "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\" ) )
        ,
        new CollectedSystemObject( "oval:org.mitre.oval:obj:11866", 1,
                        Flag.COMPLETE )
        .reference( new ItemReference( 197 ) )
        ,
        new CollectedSystemObject( "oval:org.mitre.oval:obj:11871", 1,
                        Flag.DOES_NOT_EXIST )
        .reference( new ItemReference( 198 ) )
        ,
        new CollectedSystemObject( "oval:org.mitre.oval:obj:11992", 1,
                        Flag.COMPLETE )
        .reference( new ItemReference( 1 ) )
        ,
        _COLLECTED_OBJECT_911_
    };


    private static final Item[]  _ITEMS_1_ = new Item[] {
        new FileItem(
                        2,
                        Item.DEFAULT_STATUS,
                        new EntityItemString( "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\mysqld.exe" ),
                        new EntityItemString( "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\" ),
                        new EntityItemString( "mysqld.exe" ),
                        new EntityItemString( "BUILTIN\\Administrators" ),
                        new EntityItemInt( 6591104, Datatype.INT ),
                        new EntityItemInt( 129258204872031250L, Datatype.INT ),
                        new EntityItemInt( 128919810880000000L, Datatype.INT ),
                        new EntityItemInt( 128919810880000000L, Datatype.INT ),
                        new EntityItemString( "6592576" ),
                        new EntityItemString( null, Datatype.VERSION, Status.ERROR ),
                        new EntityItemFileType( FileType.FILE_TYPE_DISK ),
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.ERROR ),
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.ERROR ),
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.ERROR ),
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.ERROR ),
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.ERROR ),
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.ERROR ),
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.ERROR )
        )
        ,
        new RegistryItem(
                        197,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\MySQL AB\\MySQL Server 5.1" ),
                        new EntityItemString( "Version" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "5.1.37" )
        )
        ,
        new RegistryItem(
                        198,
                        Status.DOES_NOT_EXIST,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\MySQL AB\\MySQL Server 5.0", EntityItemString.DEFAULT_DATATYPE, Status.DOES_NOT_EXIST )
        )
        ,
        new RegistryItem(
                        1,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\MySQL AB\\MySQL Server 5.1" ),
                        new EntityItemString( "Location" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "C:\\Program Files\\MySQL\\MySQL Server 5.1\\" )
        )
        ,
        new RegistryItem(
                        3,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Adobe Flash Player ActiveX" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Flash Player 10 ActiveX" )
        )
        ,
        new RegistryItem(
                        4,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Adobe Flex Builder 3 Plug-in" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Flex Builder 3 Plug-in" )
        )
        ,
        new RegistryItem(
                        5,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Adobe_6a3003001b9c4e53e6b3f44e0db85d4" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Update Manager CS3" )
        )
        ,
        new RegistryItem(
                        6,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EdMaxU" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "EdMax" )
        )
        ,
        new RegistryItem(
                        7,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\FFFTP" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "FFFTP" )
        )
        ,
        new RegistryItem(
                        8,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\GPL Ghostscript 8.71" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "GPL Ghostscript 8.71" )
        )
        ,
        new RegistryItem(
                        9,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\GSview 4.9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "GSview 4.9" )
        )
        ,
        new RegistryItem(
                        10,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\HDMI" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Intel(R) Graphics Media Accelerator Driver" )
        )
        ,
        new RegistryItem(
                        11,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\IDNMitigationAPIs" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Internationalized Domain Names Mitigation APIs" )
        )
        ,
        new RegistryItem(
                        12,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\InstallShield_{3A801B30-F3FD-42C2-B460-4A4117B572EE}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "au Music Port" )
        )
        ,
        new RegistryItem(
                        13,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\InstallShield_{457D7505-D665-4F95-91C3-ECB8C56E9ACA}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Easy Tune 6 B08.1030.1" )
        )
        ,
        new RegistryItem(
                        14,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB2229593" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB2229593)" )
        )
        ,
        new RegistryItem(
                        15,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB2286198" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB2286198)" )
        )
        ,
        new RegistryItem(
                        16,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB892130" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Genuine Advantage Validation Tool (KB892130)" )
        )
        ,
        new RegistryItem(
                        17,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB898461" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB898461)" )
        )
        ,
        new RegistryItem(
                        18,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB923561" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB923561)" )
        )
        ,
        new RegistryItem(
                        19,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB923789" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB923789)" )
        )
        ,
        new RegistryItem(
                        20,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB927489" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MS ゴシック ＆ MS 明朝 JIS2004 対応フォント (KB927489)" )
        )
        ,
        new RegistryItem(
                        21,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB929399" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Hotfix for Windows Media Format 11 SDK (KB929399)" )
        )
        ,
        new RegistryItem(
                        22,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB938127-v2-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 セキュリティ更新 (KB938127-v2)" )
        )
        ,
        new RegistryItem(
                        23,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB938464-v2" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB938464-v2)" )
        )
        ,
        new RegistryItem(
                        24,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB939683" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11 (KB939683) ホットフィックス" )
        )
        ,
        new RegistryItem(
                        25,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB941569" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP (KB941569) セキュリティ問題の修正プログラム" )
        )
        ,
        new RegistryItem(
                        26,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB941776_WM11" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11 (KB941776) ホットフィックス" )
        )
        ,
        new RegistryItem(
                        27,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB946648" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB946648)" )
        )
        ,
        new RegistryItem(
                        28,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB950762" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB950762)" )
        )
        ,
        new RegistryItem(
                        29,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB950974" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB950974)" )
        )
        ,
        new RegistryItem(
                        30,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB951066" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB951066)" )
        )
        ,
        new RegistryItem(
                        31,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB951376-v2" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB951376-v2)" )
        )
        ,
        new RegistryItem(
                        32,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB951748" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB951748)" )
        )
        ,
        new RegistryItem(
                        33,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB951978" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB951978)" )
        )
        ,
        new RegistryItem(
                        34,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB952004" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB952004)" )
        )
        ,
        new RegistryItem(
                        35,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB952069_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB952069) セキュリティ問題の修正プログラム" )
        )
        ,
        new RegistryItem(
                        36,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB952287" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP ホットフィックス (KB952287)" )
        )
        ,
        new RegistryItem(
                        37,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB952954" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB952954)" )
        )
        ,
        new RegistryItem(
                        38,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954154_WM11" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11 (KB954154) セキュリティ問題の修正プログラム" )
        )
        ,
        new RegistryItem(
                        39,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954155_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB954155) セキュリティ問題の修正プログラム" )
        )
        ,
        new RegistryItem(
                        40,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954459" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB954459)" )
        )
        ,
        new RegistryItem(
                        41,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954550-v5" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Hotfix for Windows XP (KB954550-v5)" )
        )
        ,
        new RegistryItem(
                        42,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954600" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB954600)" )
        )
        ,
        new RegistryItem(
                        43,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB955069" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB955069)" )
        )
        ,
        new RegistryItem(
                        44,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB955759" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB955759)" )
        )
        ,
        new RegistryItem(
                        45,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB955839" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB955839)" )
        )
        ,
        new RegistryItem(
                        46,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956572" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB956572)" )
        )
        ,
        new RegistryItem(
                        47,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956744" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB956744)" )
        )
        ,
        new RegistryItem(
                        48,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956802" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB956802)" )
        )
        ,
        new RegistryItem(
                        49,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956803" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB956803)" )
        )
        ,
        new RegistryItem(
                        50,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956844" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB956844)" )
        )
        ,
        new RegistryItem(
                        51,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB957097" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB957097)" )
        )
        ,
        new RegistryItem(
                        52,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB958644" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB958644)" )
        )
        ,
        new RegistryItem(
                        53,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB958687" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB958687)" )
        )
        ,
        new RegistryItem(
                        54,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB958869" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB958869)" )
        )
        ,
        new RegistryItem(
                        55,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB959426" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB959426)" )
        )
        ,
        new RegistryItem(
                        56,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB960225" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB960225)" )
        )
        ,
        new RegistryItem(
                        57,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB960803" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB960803)" )
        )
        ,
        new RegistryItem(
                        58,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB960859" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB960859)" )
        )
        ,
        new RegistryItem(
                        59,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB961118" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP ホットフィックス (KB961118)" )
        )
        ,
        new RegistryItem(
                        60,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB961371-v2" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB961371-v2)" )
        )
        ,
        new RegistryItem(
                        61,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB961501" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB961501)" )
        )
        ,
        new RegistryItem(
                        62,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB967715" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB967715)" )
        )
        ,
        new RegistryItem(
                        63,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB968389" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB968389)" )
        )
        ,
        new RegistryItem(
                        64,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB968537" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB968537)" )
        )
        ,
        new RegistryItem(
                        65,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB968816_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB968816) セキュリティ問題の修正プログラム" )
        )
        ,
        new RegistryItem(
                        66,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB969059" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB969059)" )
        )
        ,
        new RegistryItem(
                        67,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB969947" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB969947)" )
        )
        ,
        new RegistryItem(
                        68,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB970238" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB970238)" )
        )
        ,
        new RegistryItem(
                        69,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB970430" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB970430)" )
        )
        ,
        new RegistryItem(
                        70,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB970653-v3" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP ホットフィックス (KB970653-v3)" )
        )
        ,
        new RegistryItem(
                        71,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971468" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB971468)" )
        )
        ,
        new RegistryItem(
                        72,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971486" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB971486)" )
        )
        ,
        new RegistryItem(
                        73,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971557" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB971557)" )
        )
        ,
        new RegistryItem(
                        74,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971633" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB971633)" )
        )
        ,
        new RegistryItem(
                        75,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971657" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB971657)" )
        )
        ,
        new RegistryItem(
                        76,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971737" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB971737)" )
        )
        ,
        new RegistryItem(
                        77,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971961" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB971961)" )
        )
        ,
        new RegistryItem(
                        78,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971961-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 セキュリティ更新 (KB971961)" )
        )
        ,
        new RegistryItem(
                        79,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB972260" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB972260)" )
        )
        ,
        new RegistryItem(
                        80,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB972260-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 セキュリティ更新 (KB972260)" )
        )
        ,
        new RegistryItem(
                        81,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB972270" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB972270)" )
        )
        ,
        new RegistryItem(
                        82,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973346" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB973346)" )
        )
        ,
        new RegistryItem(
                        83,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973354" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB973354)" )
        )
        ,
        new RegistryItem(
                        84,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973507" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB973507)" )
        )
        ,
        new RegistryItem(
                        85,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973525" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB973525)" )
        )
        ,
        new RegistryItem(
                        86,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973540_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB973540) セキュリティ問題の修正プログラム" )
        )
        ,
        new RegistryItem(
                        87,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973687" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP 更新 (KB973687)" )
        )
        ,
        new RegistryItem(
                        88,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973815" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP 更新 (KB973815)" )
        )
        ,
        new RegistryItem(
                        89,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973869" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB973869)" )
        )
        ,
        new RegistryItem(
                        90,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973904" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB973904)" )
        )
        ,
        new RegistryItem(
                        91,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974112" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB974112)" )
        )
        ,
        new RegistryItem(
                        92,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974318" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB974318)" )
        )
        ,
        new RegistryItem(
                        93,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974392" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB974392)" )
        )
        ,
        new RegistryItem(
                        94,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974455-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 セキュリティ更新 (KB974455)" )
        )
        ,
        new RegistryItem(
                        95,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974571" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB974571)" )
        )
        ,
        new RegistryItem(
                        96,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975025" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB975025)" )
        )
        ,
        new RegistryItem(
                        97,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975467" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB975467)" )
        )
        ,
        new RegistryItem(
                        98,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975560" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB975560)" )
        )
        ,
        new RegistryItem(
                        99,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975561" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB975561)" )
        )
        ,
        new RegistryItem(
                        100,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975562" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB975562)" )
        )
        ,
        new RegistryItem(
                        101,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975713" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB975713)" )
        )
        ,
        new RegistryItem(
                        102,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976098-v2" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP ホットフィックス (KB976098-v2)" )
        )
        ,
        new RegistryItem(
                        103,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976325-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 セキュリティ更新 (KB976325)" )
        )
        ,
        new RegistryItem(
                        104,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976325-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 セキュリティ更新 (KB976325)" )
        )
        ,
        new RegistryItem(
                        105,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976662-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 更新 (KB976662)" )
        )
        ,
        new RegistryItem(
                        106,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976749-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 更新 (KB976749)" )
        )
        ,
        new RegistryItem(
                        107,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB977165" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB977165)" )
        )
        ,
        new RegistryItem(
                        108,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB977816" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB977816)" )
        )
        ,
        new RegistryItem(
                        109,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB977914" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB977914)" )
        )
        ,
        new RegistryItem(
                        110,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978037" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB978037)" )
        )
        ,
        new RegistryItem(
                        111,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978207-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 セキュリティ更新 (KB978207)" )
        )
        ,
        new RegistryItem(
                        112,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978207-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 セキュリティ更新 (KB978207)" )
        )
        ,
        new RegistryItem(
                        113,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978251" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB978251)" )
        )
        ,
        new RegistryItem(
                        114,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978262" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB978262)" )
        )
        ,
        new RegistryItem(
                        115,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978338" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB978338)" )
        )
        ,
        new RegistryItem(
                        116,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978506-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 更新 (KB978506)" )
        )
        ,
        new RegistryItem(
                        117,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978542" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB978542)" )
        )
        ,
        new RegistryItem(
                        118,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978601" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB978601)" )
        )
        ,
        new RegistryItem(
                        119,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978695_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB978695) セキュリティ問題の修正プログラム" )
        )
        ,
        new RegistryItem(
                        120,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978706" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB978706)" )
        )
        ,
        new RegistryItem(
                        121,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979306" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP ホットフィックス (KB979306)" )
        )
        ,
        new RegistryItem(
                        122,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979309" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB979309)" )
        )
        ,
        new RegistryItem(
                        123,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979482" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB979482)" )
        )
        ,
        new RegistryItem(
                        124,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979559" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB979559)" )
        )
        ,
        new RegistryItem(
                        125,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979683" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB979683)" )
        )
        ,
        new RegistryItem(
                        126,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB980182-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 更新 (KB980182)" )
        )
        ,
        new RegistryItem(
                        127,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB980195" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB980195)" )
        )
        ,
        new RegistryItem(
                        128,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB980218" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB980218)" )
        )
        ,
        new RegistryItem(
                        129,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB980232" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP セキュリティ更新 (KB980232)" )
        )
        ,
        new RegistryItem(
                        130,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB981332-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 セキュリティ更新 (KB981332)" )
        )
        ,
        new RegistryItem(
                        131,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB981793" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP ホットフィックス (KB981793)" )
        )
        ,
        new RegistryItem(
                        132,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB982381-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 セキュリティ更新 (KB982381)" )
        )
        ,
        new RegistryItem(
                        133,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\LHTTSJPJ" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "L&H TTS3000 Japanese" )
        )
        ,
        new RegistryItem(
                        134,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Lhaplus" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Lhaplus" )
        )
        ,
        new RegistryItem(
                        135,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\MSCompPackV1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Compression Client Pack 1.0 for Windows XP" )
        )
        ,
        new RegistryItem(
                        136,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Microsoft .NET Framework 3.5 Language Pack SP1 - jpn" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.5 Language Pack SP1 - 日本語" )
        )
        ,
        new RegistryItem(
                        137,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Microsoft .NET Framework 3.5 SP1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.5 SP1" )
        )
        ,
        new RegistryItem(
                        138,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\NLSDownlevelMapping" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft National Language Support Downlevel APIs" )
        )
        ,
        new RegistryItem(
                        139,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\OKI LPR Utility" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "OKI LPR ﾕｰﾃｨﾘﾃｨ" )
        )
        ,
        new RegistryItem(
                        140,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\ST6UNST #1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "プレゼンテーションタイマー<Pt> Ver.1.52" )
        )
        ,
        new RegistryItem(
                        141,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Shockwave" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Shockwave" )
        )
        ,
        new RegistryItem(
                        142,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Takeo'clock" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Takeo'clock" )
        )
        ,
        new RegistryItem(
                        143,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Tera Term_is1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Tera Term 4.63" )
        )
        ,
        new RegistryItem(
                        144,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\WGA" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Genuine Advantage Validation Tool (KB892130)" )
        )
        ,
        new RegistryItem(
                        145,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\WMFDist11" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Format 11 runtime" )
        )
        ,
        new RegistryItem(
                        146,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\WgaNotify" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Genuine Advantage Notifications (KB905474)" )
        )
        ,
        new RegistryItem(
                        147,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Windows Media Format Runtime" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Format 11 runtime" )
        )
        ,
        new RegistryItem(
                        148,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Windows Media Player" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11" )
        )
        ,
        new RegistryItem(
                        149,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Wudf01000" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft User-Mode Driver Framework Feature Pack 1.0" )
        )
        ,
        new RegistryItem(
                        150,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\XPSEPSCLP" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "XML Paper Specification Shared Components Language Pack 1.0" )
        )
        ,
        new RegistryItem(
                        151,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\astah professional_is1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "astah professional 6.2" )
        )
        ,
        new RegistryItem(
                        152,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\ie7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7" )
        )
        ,
        new RegistryItem(
                        153,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\ie8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8" )
        )
        ,
        new RegistryItem(
                        154,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\wmp11" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11" )
        )
        ,
        new RegistryItem(
                        155,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{00BA866C-F2A2-4BB9-A308-3DFA695B6F7C}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Java DB 10.5.3.0" )
        )
        ,
        new RegistryItem(
                        156,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{034A00E1-3975-4267-9F39-1DC4745090B7}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft エンカルタ 総合大百科 2003" )
        )
        ,
        new RegistryItem(
                        157,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{0E2EE98E-17AE-4798-8F8C-64E49CA86D20}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MySQL Server 5.1" )
        )
        ,
        new RegistryItem(
                        158,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{26A24AE4-039D-4CA4-87B4-2F83216021FF}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Java(TM) 6 Update 21" )
        )
        ,
        new RegistryItem(
                        159,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{2D33B338-EA1B-34EA-BD7F-BBD59487E03A}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.0 Service Pack 2 Language Pack - JPN" )
        )
        ,
        new RegistryItem(
                        160,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{32A3A4F4-B792-11D6-A78A-00B0D0160210}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Java(TM) SE Development Kit 6 Update 21" )
        )
        ,
        new RegistryItem(
                        161,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{34F3877C-6399-4A89-98FD-C3FE32EEE25C}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "FileMaker Pro 8.5" )
        )
        ,
        new RegistryItem(
                        162,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{350C97B1-3D7C-4EE8-BAA9-00BCB3D54227}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "WebFldrs XP" )
        )
        ,
        new RegistryItem(
                        163,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{38ADB9A6-798C-11D6-A855-00105A80791C}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "OKI Network Extension" )
        )
        ,
        new RegistryItem(
                        164,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{3A801B30-F3FD-42C2-B460-4A4117B572EE}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "au Music Port" )
        )
        ,
        new RegistryItem(
                        165,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{457D7505-D665-4F95-91C3-ECB8C56E9ACA}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Easy Tune 6 B08.1030.1" )
        )
        ,
        new RegistryItem(
                        166,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{4A03706F-666A-4037-7777-5F2748764D10}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Java Auto Updater" )
        )
        ,
        new RegistryItem(
                        167,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{4D235F63-5F7F-4EC4-AB09-63231A67CE4D}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "au W41CA Software" )
        )
        ,
        new RegistryItem(
                        168,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{71AD79C6-EB2F-4C62-9527-42E6B29E20F2}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Acronis True Image Home" )
        )
        ,
        new RegistryItem(
                        169,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{78E884B8-7DB5-4708-AFE5-DAECEA900EE4}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Diskeeper 2009 Professional" )
        )
        ,
        new RegistryItem(
                        170,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{86493ADD-824D-4B8E-BD72-8C5DCDC52A71}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MSXML 4.0 SP2 (KB954430)" )
        )
        ,
        new RegistryItem(
                        171,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{90110411-6000-11D3-8CFE-0150048383C9}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Office Professional Edition 2003" )
        )
        ,
        new RegistryItem(
                        172,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{902DAEAA-18CA-4068-99C4-0F1C7797A25A}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "au Music Port Supplemental Files" )
        )
        ,
        new RegistryItem(
                        173,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{90510411-6000-11D3-8CFE-0150048383C9}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Office Visio Professional 2003" )
        )
        ,
        new RegistryItem(
                        174,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{932245FB-2F3B-3E2E-B8AB-BDE96E434F21}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.5 Language Pack SP1 - jpn" )
        )
        ,
        new RegistryItem(
                        175,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{95120000-00AF-0411-0000-0000000FF1CE}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Office PowerPoint Viewer 2007 (Japanese)" )
        )
        ,
        new RegistryItem(
                        176,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{A3051CD0-2F64-3813-A88D-B8DCCDE8F8C7}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.0 Service Pack 2" )
        )
        ,
        new RegistryItem(
                        177,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{A35CAAAB-5977-400C-B355-AC0A51EE2352}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "B's Recorder GOLD 8.67 (Update)" )
        )
        ,
        new RegistryItem(
                        178,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{A3FF5CB2-FB35-4658-8751-9EDE1D65B3AA}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "VMware Workstation" )
        )
        ,
        new RegistryItem(
                        179,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{AC76BA86-1041-0000-7760-000000000004}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Acrobat 9 Pro - Japanese" )
        )
        ,
        new RegistryItem(
                        180,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{AC76BA86-1041-0000-7760-000000000004}_933" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Acrobat 9.3.3 - CPSID_83708" )
        )
        ,
        new RegistryItem(
                        181,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{AC76BA86-1041-0000-7760-000000000004}{AC76BA86-1041-0000-7760-000000000004}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Adobe Acrobat 9 Pro - Japanese" )
        )
        ,
        new RegistryItem(
                        182,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{AFDFBE99-FE9F-41B2-B96C-F1248F9E8ACE}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "ESET NOD32 Antivirus" )
        )
        ,
        new RegistryItem(
                        183,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{B6EC7388-E277-4A5B-8C8F-71067A41BA64}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "TextPad 5" )
        )
        ,
        new RegistryItem(
                        184,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{C09FB3CD-3D0C-3F2D-899A-6A1D67F2073F}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 2.0 Service Pack 2" )
        )
        ,
        new RegistryItem(
                        185,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.5 SP1" )
        )
        ,
        new RegistryItem(
                        186,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}.KB953595" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Hotfix for Microsoft .NET Framework 3.5 SP1 (KB953595)" )
        )
        ,
        new RegistryItem(
                        187,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}.KB958484" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Hotfix for Microsoft .NET Framework 3.5 SP1 (KB958484)" )
        )
        ,
        new RegistryItem(
                        188,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}.KB963707" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Update for Microsoft .NET Framework 3.5 SP1 (KB963707)" )
        )
        ,
        new RegistryItem(
                        189,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{D85BDA1A-983E-3C61-8F03-E5F9C394075C}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 2.0 Service Pack 2 Language Pack - JPN" )
        )
        ,
        new RegistryItem(
                        190,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{DEC2C123-3CE0-4669-B119-61519130CACD}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "TortoiseSVN 1.6.10.19898 (32 bit)" )
        )
        ,
        new RegistryItem(
                        191,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{E69AE897-9E0B-485C-8552-7841F48D42D8}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Update Manager CS3" )
        )
        ,
        new RegistryItem(
                        192,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{F132AF7F-7BCA-4EDE-8A7C-958108FE7DBC}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Realtek High Definition Audio Driver" )
        )
        ,
        new RegistryItem(
                        193,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{F662A8E6-F4DC-41A2-901E-8C11F044BDEC}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MSXML 4.0 SP2 (KB973688)" )
        )
        ,
        new RegistryItem(
                        194,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{F761359C-9CED-45AE-9A51-9D6605CD55C4}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Evernote" )
        )
        ,
        new RegistryItem(
                        195,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{FCB10DE3-E190-4A7E-B06A-FAC61567ABFC}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MySQL Tools for 5.0" )
        )
        ,
        new RegistryItem(
                        196,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{FDF9862D-2B3E-4648-9DD9-CEEDD4971686}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Setup" )
        )
    };



    //==============================================================
    //  results:definition
    //==============================================================

    public static final DefinitionResult  DEFINITION_RESULT_8297 =
        new DefinitionResult( "oval:org.mitre.oval:def:8297", 1, Result.TRUE )
    .criteria(
                    new CriteriaResult( Operator.AND, Result.TRUE )
                    .element(
                                    new CriterionResult( "oval:org.mitre.oval:tst:21087", 1, Result.TRUE )
                    )
                    .element(
                                    new CriterionResult( "oval:org.mitre.oval:tst:21031", 1, Result.TRUE )
                    )
    );


    public static final DefinitionResult  DEFINITION_RESULT_8500 =
        new DefinitionResult( "oval:org.mitre.oval:def:8500", 1, Result.TRUE )
    .criteria(
                    new CriteriaResult( Operator.OR, Result.TRUE )
                    .element(
                                    new CriteriaResult( Operator.AND, Result.FALSE )
                                    .element(
                                                    new ExtendDefinitionResult( "oval:org.mitre.oval:def:8282", 1, Result.FALSE )
                                    )
                                    .element(
                                                    new CriterionResult( "oval:org.mitre.oval:tst:20192", 1, Result.FALSE )
                                    )
                    )
                    .element(
                                    new CriteriaResult( Operator.AND, Result.TRUE )
                                    .element(
                                                    new ExtendDefinitionResult( "oval:org.mitre.oval:def:8297", 1, Result.TRUE )
                                    )
                                    .element(
                                                    new CriterionResult( "oval:org.mitre.oval:tst:20859", 1, Result.TRUE )
                                    )
                    )
    );


    public static final DefinitionResult  DEFINITION_RESULT_8282 =
        new DefinitionResult( "oval:org.mitre.oval:def:8282", 1, Result.FALSE )
    .criteria(
                    new CriteriaResult( Operator.AND, Result.FALSE )
                    .element(
                                    new CriterionResult( "oval:org.mitre.oval:tst:20481", 1, Result.FALSE )
                    )
                    .element(
                                    new CriterionResult( "oval:org.mitre.oval:tst:21031", 1, Result.TRUE )
                    )
    );


    private static final SystemResult  _SYSTEM_RESULT_8500_ =
        new SystemResult()
    .definition( DEFINITION_RESULT_8297 )
    .definition( DEFINITION_RESULT_8500 )
    .definition( DEFINITION_RESULT_8282 )
    ;

}
// OvalSample

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

