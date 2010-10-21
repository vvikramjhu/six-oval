package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.DefinitionClass;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.common.Operation;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.ExtendDefinition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.results.Content;
import jp.go.aist.six.oval.model.results.CriteriaResult;
import jp.go.aist.six.oval.model.results.CriterionResult;
import jp.go.aist.six.oval.model.results.DefaultDirectives;
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.Directive;
import jp.go.aist.six.oval.model.results.ExtendDefinitionResult;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.Result;
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.results.SystemResults;
import jp.go.aist.six.oval.model.results.TestResult;
import jp.go.aist.six.oval.model.results.TestedItem;
import jp.go.aist.six.oval.model.results.TestedVariable;
import jp.go.aist.six.oval.model.sc.CollectedSystemObject;
import jp.go.aist.six.oval.model.sc.Flag;
import jp.go.aist.six.oval.model.sc.ItemReference;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.oval.model.sc.VariableValue;
import jp.go.aist.six.oval.model.windows.EntityObjectRegistryHive;
import jp.go.aist.six.oval.model.windows.FileObject;
import jp.go.aist.six.oval.model.windows.FileTest;
import jp.go.aist.six.oval.model.windows.RegistryObject;
import jp.go.aist.six.oval.model.windows.RegistryState;
import jp.go.aist.six.oval.model.windows.RegistryTest;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSample
{

    //==============================================================
    //  def:test
    //==============================================================


    //**************************************************************
    // oval:org.mitre.oval:def:8500 related test
    //**************************************************************

    public static final Test  TEST_WINDOWS_REGISTRY_21087 =
        new RegistryTest( "oval:org.mitre.oval:tst:21087", 1,
                        "MySQL 5.1 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:911" )
    .state( "oval:org.mitre.oval:ste:6216" );


    public static final Test  TEST_WINDOWS_FILE_21031 =
        new FileTest( "oval:org.mitre.oval:tst:21031", 1,
                        "mysqld.exe or mysqld-nt.exe exists",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .stateOperator( Operator.OR )
    .object( "oval:org.mitre.oval:obj:11786" );


    public static final Test  TEST_WINDOWS_REGISTRY_20481 =
        new RegistryTest( "oval:org.mitre.oval:tst:20481", 1,
                        "MySQL 5.0 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:911" )
    .state( "oval:org.mitre.oval:ste:6475" );


    public static final Test  TEST_WINDOWS_REGISTRY_20859 =
        new RegistryTest( "oval:org.mitre.oval:tst:20859", 1,
                        "MySQL Server 5.1 version is less than 5.1.41",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:11866" )
    .state( "oval:org.mitre.oval:ste:6693" );


    public static final Test  TEST_WINDOWS_REGISTRY_20192 =
        new RegistryTest( "oval:org.mitre.oval:tst:20192", 1,
                        "MySQL Server 5.0 version is less than 5.0.88",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:11871" )
    .state( "oval:org.mitre.oval:ste:6359" );



    //==============================================================
    //  def:object
    //==============================================================

    //**************************************************************
    // oval:org.mitre.oval:def:8500 related object
    //**************************************************************

    public static final FileObject  OBJECT_WINDOWS_FILE_11786 =
        new FileObject( "oval:org.mitre.oval:obj:11786", 1,
                        "Full path to MySQL executable"
        )
    .path( new EntityObjectString( "oval:org.mitre.oval:var:349", Check.ALL ) )
    .filename( new EntityObjectString( "^mysqld(|-nt)\\.exe$", Operation.PATTERN_MATCH ) );


    public static final RegistryObject  OBJECT_WINDOWS_REGISTRY_11992 =
        new RegistryObject( "oval:org.mitre.oval:obj:11992", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "^SOFTWARE\\\\MySQL AB\\\\MySQL Server [0-9]\\.[0-9]$", Operation.PATTERN_MATCH ) )
    .name( new EntityObjectString( "Location" ) );


    public static final RegistryObject  OBJECT_WINDOWS_REGISTRY_911 =
        new RegistryObject( "oval:org.mitre.oval:obj:911", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "^Software\\\\Microsoft\\\\Windows\\\\CurrentVersion\\\\Uninstall\\\\.*", Operation.PATTERN_MATCH ) )
    .name( new EntityObjectString( "DisplayName" ) );


    public static final RegistryObject  OBJECT_WINDOWS_REGISTRY_11866 =
        new RegistryObject( "oval:org.mitre.oval:obj:11866", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\MySQL AB\\MySQL Server 5.1" ) )
    .name( new EntityObjectString( "Version" ) );


    public static final RegistryObject  OBJECT_WINDOWS_REGISTRY_11871 =
        new RegistryObject( "oval:org.mitre.oval:obj:11871", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\MySQL AB\\MySQL Server 5.0" ) )
    .name( new EntityObjectString( "Version" ) );




    //**************************************************************
    // oval:org.mitre.oval:def:8500 related state
    //**************************************************************

    public static final RegistryState  STATE_WINDOWS_REGISTRY_6216 =
        new RegistryState( "oval:org.mitre.oval:ste:6216", 1,
                        "MySQL 5.1 check"
        )
    .value( new EntityStateAnySimple( "MySQL Server 5.1" )
    );


    public static final RegistryState  STATE_WINDOWS_REGISTRY_6475 =
        new RegistryState( "oval:org.mitre.oval:ste:6475", 1,
                        "MySQL 5.0 check"
        )
    .value( new EntityStateAnySimple( "MySQL Server 5.0" )
    );


    public static final RegistryState  STATE_WINDOWS_REGISTRY_6693 =
        new RegistryState( "oval:org.mitre.oval:ste:6693", 1,
                        "MySQL Server 5.1 version is less than 5.1.41"
        )
    .value( new EntityStateAnySimple( "^5\\.1\\.(([0-9]|[1-3][0-9]|40)?(|[a-z\\_\\-]+))$",
                    Operation.PATTERN_MATCH )
    );


    public static final RegistryState  STATE_WINDOWS_REGISTRY_6359 =
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
                        "2010-08-05T03:28:32.987-04:00",
                        "The OVAL Repository",
                        null
                        );


    public static final OvalDefinitions  OVAL_DEFINITIONS_8500 =
        new OvalDefinitions( _GENERATOR_8500_ )
    .definition( DEFINITION_8297 )
    .definition( DEFINITION_8500 )
    .definition( DEFINITION_8282 )
    .test( TEST_WINDOWS_REGISTRY_21087 )
    .test( TEST_WINDOWS_FILE_21031 )
    .test( TEST_WINDOWS_REGISTRY_20481 )
    .test( TEST_WINDOWS_REGISTRY_20859 )
    .test( TEST_WINDOWS_REGISTRY_20192 )
    .object( OBJECT_WINDOWS_FILE_11786 )
    .object( OBJECT_WINDOWS_REGISTRY_11992 )
    .object( OBJECT_WINDOWS_REGISTRY_911 )
    .object( OBJECT_WINDOWS_REGISTRY_11866 )
    .object( OBJECT_WINDOWS_REGISTRY_11871 )
    .state( STATE_WINDOWS_REGISTRY_6216 )
    .state( STATE_WINDOWS_REGISTRY_6475 )
    .state( STATE_WINDOWS_REGISTRY_6693 )
    .state( STATE_WINDOWS_REGISTRY_6359 )
    .variable( DefinitionsSample.VARIABLE_LOCAL_349 )
    ;



    //==============================================================
    //  sc
    //==============================================================

    private static final SystemInfo  _SYSTEM_INFO_1_ =
        new SystemInfo(
                        "Microsoft Windows XP Professional Service Pack 3",
                        "5.1.2600",
                        "INTEL32",
                        "foo.example.org",
                        NetInterfacesSample.NET_INTERFACES_1
                        //native2ascii
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



    public static final OvalSystemCharacteristics  OVAL_SC_8500 =
        new OvalSystemCharacteristics(
                        new Generator( "5.7",
                                        "2010-08-09T18:41:27",
                                        "OVAL Definition Interpreter",
                                        "5.7 Build: 2"
                        ),
                        _SYSTEM_INFO_1_,
                        _COLLECTED_OBJECTS_1_,
                        ItemsSample.ITEMS_1
        );



    //==============================================================
    //  results
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



    // results:test
    private static TestResult _createTestResult21087()
    {
        TestResult  test =
            new TestResult( "oval:org.mitre.oval:tst:21087", 1, Result.TRUE )
        .check( Check.AT_LEAST_ONE )
        .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
        .stateOperator( Operator.AND );
        for (int  id = 3; id <= 196; id++) {
            if (id == 157) {
                test.addTestedItem( new TestedItem( id, Result.TRUE ) );
            } else {
                test.addTestedItem( new TestedItem( id, Result.FALSE ) );
            }
        }

        return test;
    }

    private static final TestResult  _TEST_RESULT_21087_ =
        _createTestResult21087();
//        new TestResult( "oval:org.mitre.oval:tst:21087", 1, Result.TRUE )
//    .check( Check.AT_LEAST_ONE )
//    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
//    .stateOperator( Operator.AND );
//    {
//        for (int  id = 3; id <= 196; id++) {
//            _TEST_RESULT_21087_.addTestedItem( new TestedItem( id, Result.FALSE ) );
//        }
//    }


    // results:test
    private static final TestResult  _TEST_RESULT_21031_ =
        new TestResult( "oval:org.mitre.oval:tst:21031", 1, Result.TRUE )
    .check( Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .stateOperator( Operator.AND )
    .testedItem( new TestedItem( 2, Result.NOT_EVALUATED ) )
    .testedVariable( new TestedVariable( "oval:org.mitre.oval:var:349", "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\" ) );


    // results:test
    private static TestResult _createTestResult20481()
    {
        TestResult  test =
            new TestResult( "oval:org.mitre.oval:tst:20481", 1, Result.FALSE )
        .check( Check.AT_LEAST_ONE )
        .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
        .stateOperator( Operator.AND );
        for (int  id = 3; id <= 196; id++) {
            test.addTestedItem( new TestedItem( id, Result.FALSE ) );
        }

        return test;
    }

    private static final TestResult  _TEST_RESULT_20481_ =
        _createTestResult20481();
//        new TestResult( "oval:org.mitre.oval:tst:20481", 1, Result.FALSE )
//    .check( Check.AT_LEAST_ONE )
//    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
//    .stateOperator( Operator.AND );


    // results:test
    private static final TestResult  _TEST_RESULT_20192_ =
        new TestResult( "oval:org.mitre.oval:tst:20192", 1, Result.FALSE )
    .check( Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .stateOperator( Operator.AND )
    .testedItem( new TestedItem( 198, Result.NOT_EVALUATED ) );


    // results:test
    private static final TestResult  _TEST_RESULT_20859_ =
        new TestResult( "oval:org.mitre.oval:tst:20859", 1, Result.TRUE )
    .check( Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .stateOperator( Operator.AND )
    .testedItem( new TestedItem( 197, Result.TRUE ) );


    private static final SystemResult  _SYSTEM_RESULT_8500_ =
        new SystemResult( OVAL_SC_8500 )
    .definition( DEFINITION_RESULT_8297 )
    .definition( DEFINITION_RESULT_8500 )
    .definition( DEFINITION_RESULT_8282 )
    .test( _TEST_RESULT_21087_ )
    .test( _TEST_RESULT_21031_ )
    .test( _TEST_RESULT_20481_ )
    .test( _TEST_RESULT_20192_ )
    .test( _TEST_RESULT_20859_ )
    ;



    public static final OvalResults  OVAL_RESULTS_8500 =
        new OvalResults(
                        new Generator( "5.7",
                                        "2010-08-09T18:41:27",
                                        "OVAL Definition Interpreter",
                                        "5.7 Build: 2"
                        ),
                        new DefaultDirectives(
                                        true,
                                        new Directive( true, Content.FULL ),
                                        new Directive( true, Content.FULL ),
                                        new Directive( true, Content.FULL ),
                                        new Directive( true, Content.FULL ),
                                        new Directive( true, Content.FULL ),
                                        new Directive( true, Content.FULL )
                                        ),
                        new SystemResults( new SystemResult[] { _SYSTEM_RESULT_8500_ } )
                        )
    .definitions( OVAL_DEFINITIONS_8500 );

}
// OvalSample

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

