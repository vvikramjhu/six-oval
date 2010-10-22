package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.DefinitionClass;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.common.Operation;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Component;
import jp.go.aist.six.oval.model.definitions.ConcatFunction;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.EntityObjectInt;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateEVRString;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.EntityStateVersion;
import jp.go.aist.six.oval.model.definitions.EscapeRegexFunction;
import jp.go.aist.six.oval.model.definitions.ExtendDefinition;
import jp.go.aist.six.oval.model.definitions.LiteralComponent;
import jp.go.aist.six.oval.model.definitions.LocalVariable;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.ObjectComponent;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.definitions.RegexCaptureFunction;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.independent.EntityStateFamily;
import jp.go.aist.six.oval.model.independent.FamilyObject;
import jp.go.aist.six.oval.model.independent.FamilyState;
import jp.go.aist.six.oval.model.independent.FamilyTest;
import jp.go.aist.six.oval.model.independent.TextFileContent54Behaviors;
import jp.go.aist.six.oval.model.independent.TextFileContent54Object;
import jp.go.aist.six.oval.model.independent.TextFileContent54State;
import jp.go.aist.six.oval.model.independent.TextFileContent54Test;
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
import jp.go.aist.six.oval.model.mitre.Contributor;
import jp.go.aist.six.oval.model.mitre.DefinitionStatus;
import jp.go.aist.six.oval.model.mitre.Modified;
import jp.go.aist.six.oval.model.mitre.OvalRepository;
import jp.go.aist.six.oval.model.mitre.StatusChange;
import jp.go.aist.six.oval.model.mitre.Submitted;
import jp.go.aist.six.oval.model.unix.UnameObject;
import jp.go.aist.six.oval.model.unix.UnameState;
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



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionsSample
{

    //==============================================================
    //  def:definition
    //==============================================================


    //==============================================================
    //  test
    //==============================================================

    public static final Test  TEST_INDEPENDENT_FAMILY_99 =
        new FamilyTest( "oval:org.mitre.oval:tst:99", 1,
                        "the installed operating system is part of the Microsoft Windows family",
                        Check.ONLY_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:99" )
    .state( "oval:org.mitre.oval:ste:99" );


    public static final Test  TEST_INDEPENDENT_TEXTFILECONTENT_11150 =
        new TextFileContentTest( "oval:org.mitre.oval:tst:11150", 1,
                        "Debian GNU/Linux 5.0 is installed",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:7326" )
    .state( "oval:org.mitre.oval:ste:5739" );


    public static final Test  TEST_INDEPENDENT_TEXTFILECONTENT54_41853 =
        new TextFileContent54Test( "oval:org.mitre.oval:tst:41853", 1,
                        "Check if Google Chrome Invisible Hand Extension is enabled",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:15567" )
    .state( "oval:org.mitre.oval:ste:11440" );


    public static final Test  TEST_INDEPENDENT_UNKNOWN_2531 =
        new UnknownTest( "oval:org.mitre.oval:tst:2531", 1,
                        "Word 97 is installed",
                        Check.ALL );


    public static final Test  TEST_LINUX_DPKGINFO_19402 =
        new DpkgInfoTest( "oval:org.mitre.oval:tst:19402", 1,
                        "apache2-src is earlier than 2.2.9-10+lenny6",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:10286" )
    .state( "oval:org.mitre.oval:ste:6372" );


    public static final Test  TEST_LINUX_RPMINFO_20100061002 =
        new RpmInfoTest( "oval:com.redhat.rhsa:tst:20100061002", 301,
                        "gzip is earlier than 0:1.3.5-11.el5_4.1",
                        Check.AT_LEAST_ONE )
    .object( "oval:com.redhat.rhsa:obj:20100061002" )
    .state( "oval:com.redhat.rhsa:ste:20100061004" );



    public static final Test  TEST_UNIX_UNAME_11195 =
        new UnameTest( "oval:org.mitre.oval:tst:11195", 1,
                        "Installed architecture is mips",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:2759" )
    .state( "oval:org.mitre.oval:ste:5601" );


    public static final Test  TEST_WINDOWS_FILE_2339 =
        new FileTest( "oval:org.mitre.oval:tst:2339", 1,
                        "the version of mshtml.dll is less than 6.0.2900.2873",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:222" )
    .state( "oval:org.mitre.oval:ste:2190" );


    public static final Test  TEST_WINDOWS_FILE_10629 =
        new FileTest( "oval:org.mitre.oval:tst:10629", 1,
                        "Opera.exe version 9.x to 10.0.x",
                        Check.ALL )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .stateOperator( Operator.OR )
    .object( "oval:org.mitre.oval:obj:6638" )
    .state( "oval:org.mitre.oval:ste:4847" )
    .state( "oval:org.mitre.oval:ste:5298" );


    public static final Test  TEST_WINDOWS_METABASE_709 =
        new MetabaseTest( "oval:org.mitre.oval:tst:709", 2,
                        "Negotiate is enabled",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:556" );


    public static final Test  TEST_WINDOWS_REGISTRY_3019 =
        new RegistryTest( "oval:org.mitre.oval:tst:3019", 2,
                        "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:717" )
    .state( "oval:org.mitre.oval:ste:2827" );



    //==============================================================
    //  object
    //==============================================================

    public static final FamilyObject  OBJECT_INDEPENDENT_FAMILY_99 =
        new FamilyObject( "oval:org.mitre.oval:obj:99", 1,
                    "This is the default family object. Only one family object should exist."
                    );


    public static final TextFileContentObject  OBJECT_INDEPENDENT_TEXTFILECONTENT_7326 =
        new TextFileContentObject( "oval:org.mitre.oval:obj:7326", 1 )
    .path( new EntityObjectString( "/etc" ) )
    .filename( new EntityObjectString( "debian_version" ) )
    .line( new EntityObjectString( "\\d\\.\\d", Operation.PATTERN_MATCH ) );


    public static final TextFileContent54Object  OBJECT_INDEPENDENT_TEXTFILECONTENT54_15567 =
        new TextFileContent54Object( "oval:org.mitre.oval:obj:15567", 1,
                        "Object to check content of Google Chrome Preferences file"
                        )
    .behaviors( (new TextFileContent54Behaviors()).multiline( true ) )
    .path( new EntityObjectString( "oval:org.mitre.oval:var:1173", Check.ALL ) )
    .filename( new EntityObjectString( "Preferences" ) )
    .pattern( new EntityObjectString( "^\\s*\"name\": \"InvisibleHand\"[^}]+}[^p]+path\": \"lghjfnfolmcikomdjmoiemllfnlmmoko\\\\[^s]+state\": [01]$", Operation.PATTERN_MATCH ) )
    .instance( new EntityObjectInt( "1" ) );


    public static final DpkgInfoObject  OBJECT_LINUX_DPKGINFO_10648 =
        new DpkgInfoObject( "oval:org.mitre.oval:obj:10648", 1,
                        "apache2 package information"
        )
    .name( new EntityObjectString( "apache2" ) );


    public static final RpmInfoObject  OBJECT_LINUX_RPMINFO_20100061001 =
        new RpmInfoObject( "oval:com.redhat.rhsa:obj:20100061001", 301 )
    .name( new EntityObjectString( "redhat-release" ) );


    public static final UnameObject  OBJECT_UNAME_UNAME_2759 =
        new UnameObject( "oval:org.mitre.oval:obj:2759", 1,
                        "The single uname object."
        );


    public static final FileObject  OBJECT_WINDOWS_FILE_222 =
        new FileObject( "oval:org.mitre.oval:obj:222", 1,
                        "The path to the mshtml.dll file in the system root"
        )
    .path( new EntityObjectString( "oval:org.mitre.oval:var:200", Check.ALL ) )
    .filename( new EntityObjectString( "mshtml.dll" ) );


    public static final FileObject  OBJECT_WINDOWS_FILE_6982 =
        new FileObject( "oval:org.mitre.oval:obj:6982", 1,
                        "Object that holds filepath to Winamp.exe"
        )
    .filepath( new EntityObjectString( "oval:org.mitre.oval:var:518", Check.ALL ) )
    ;


    public static final MetabaseObject  OBJECT_WINDOWS_METABASE_556 =
        new MetabaseObject( "oval:org.mitre.oval:obj:556", 2 )
    .key( new EntityObjectString( "LM/W3SVC" ) )
    .ID( new EntityObjectInt( "6032" ) );


    public static final RegistryObject  OBJECT_WINDOWS_REGISTRY_717 =
        new RegistryObject( "oval:org.mitre.oval:obj:717", 1,
                        "This registry key holds the service pack installed on the host if one is present."
        )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion" ) )
    .name( new EntityObjectString( "CSDVersion" ) );



    //==============================================================
    //  state
    //==============================================================

    public static final FamilyState  STATE_INDEPENDENT_FAMILY_99 =
        new FamilyState( "oval:org.mitre.oval:ste:99", 2,
        "Microsoft Windows family" )
    .family( new EntityStateFamily( Family.WINDOWS,
                    Operation.CASE_INSENSITIVE_EQUALS )
    );


    public static final TextFileContentState  STATE_INDEPENDENT_TEXTFILECONTENT_5132 =
        new TextFileContentState( "oval:org.mitre.oval:ste:5132", 1 )
    .subexpression( new EntityStateAnySimple( "\\brw\\b",
                    Operation.PATTERN_MATCH )
    );


    public static final TextFileContent54State  STATE_INDEPENDENT_TEXTFILECONTENT54_11440 =
        new TextFileContent54State( "oval:org.mitre.oval:ste:11440", 1,
                        "State matches if Google Chrome Invisible Hand Extension is enabled" )
    .text( new EntityStateAnySimple( "^\\s*\"name\": \"InvisibleHand\"[^}]+}[^p]+path\": \"lghjfnfolmcikomdjmoiemllfnlmmoko\\\\[^s]+state\": 1$", Operation.PATTERN_MATCH )
    );


    public static final DpkgInfoState  STATE_LINUX_DPKGINFO_5797 =
        new DpkgInfoState( "oval:org.mitre.oval:ste:5797", 1 )
    .evr( new EntityStateEVRString( "0:2.2.6-02-1+lenny2+b2",
                    Operation.LESS_THAN )
    );


    public static final RpmInfoState  STATE_LINUX_RPMINFO_20100061004 =
        new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061004", 301 )
    .evr( new EntityStateEVRString( "0:1.3.5-11.el5_4.1",
                    Operation.LESS_THAN )
    );


    public static final RpmInfoState  STATE_LINUX_RPMINFO_20100061003 =
        new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061003", 301 )
    .version( new EntityStateAnySimple( "^5[^[:digit:]]",
                    Operation.PATTERN_MATCH )
    );


    public static final RpmInfoState  STATE_LINUX_RPMINFO_20100061002  =
        new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061002", 301 )
    .signatureKeyID( new EntityStateString( "5326810137017186",
                    Operation.EQUALS )
    );


    public static final UnameState  STATE_UNIX_UNAME_5377 =
        new UnameState( "oval:org.mitre.oval:ste:5377", 1,
                        "processor_type is i686" )
    .processorType( new EntityStateString( "i686" )
    )
    ;


    public static final FileState  STATE_WINDOWS_FILE_2190 =
        new FileState( "oval:org.mitre.oval:ste:2190", 1 )
    .version( new EntityStateVersion( "6.0.2900.2873",
                    Datatype.VERSION, Operation.LESS_THAN )
    );


    public static final MetabaseState  STATE_WINDOWS_METABASE_537 =
        new MetabaseState( "oval:org.mitre.oval:ste:537", 1 )
    .data( new EntityStateAnySimple( "^http:*,PERMANENT,*",
                    Operation.PATTERN_MATCH )
    );


    public static final RegistryState  STATE_WINDOWS_REGISTRY_1205 =
        new RegistryState( "oval:org.mitre.oval:ste:1205", 1 )
    .value( new EntityStateAnySimple( "1",
                    Datatype.INT,
                    Operation.EQUALS )
    );



    //==============================================================
    //  variable
    //==============================================================

    public static final LocalVariable  VARIABLE_LOCAL_349 =
        new LocalVariable( "oval:org.mitre.oval:var:349", 1,
                        "Path to MySQL bin directory",
                        Datatype.STRING
        )
    .component(
                    new ConcatFunction(
                                    new Component[] {
                                                    new ObjectComponent( "oval:org.mitre.oval:obj:11992", "value" ),
                                                    new LiteralComponent( "bin\\" )
                                    }
                    )
    );


    public static final LocalVariable  VARIABLE_LOCAL_246 =
        new LocalVariable( "oval:org.mitre.oval:var:246", 1,
                        "MSN Messenger directory",
                        Datatype.STRING
        )
    .component(
                    new ConcatFunction(
                                    new Component[] {
                                                    new ObjectComponent( "oval:org.mitre.oval:obj:309", "value" ),
                                                    new LiteralComponent( "\\MSN Messenger", Datatype.STRING )
                                    }
                    )
    );



    public static final LocalVariable  VARIABLE_LOCAL_105 =
        new LocalVariable( "oval:org.mitre.oval:var:105", 1,
                        "Path to folder containing Winamp.exe",
                        Datatype.STRING
        )
    .component(
                    new RegexCaptureFunction(
                                    new ObjectComponent( "oval:org.mitre.oval:obj:7560", "value" ),
                                    "^\\x22(.*)UninstWA\\.exe\\x22$"
                    )
    );


    public static final LocalVariable  VARIABLE_LOCAL_489 =
        new LocalVariable( "oval:org.mitre.oval:var:489", 2,
                        "VC90 ATL directory",
                        Datatype.STRING
        )
    .component(
                    new ConcatFunction(
                                    new Component[] {
                                                    new LiteralComponent( "^" ),
                                                    new EscapeRegexFunction(
                                                                    new ObjectComponent( "oval:org.mitre.oval:obj:219", "value" )
                                                    ),
                                                    new LiteralComponent( "\\\\winsxs\\\\(x86|amd64)_microsoft\\.vc90\\.atl_1fc8b3b9a1e18e3b_9\\.0\\.30729\\.4148.*$" )
                                    }
                    )
    );



    //==============================================================
    //  def:oval_definitions
    //==============================================================



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  def:8050 suite
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //**************************************************************
    //  def:definition 8050
    //**************************************************************

    private static final Affected  _AFFECTED_8050_ =
        new Affected( Family.WINDOWS )
    .platform( "Microsoft Windows 2000" )
    .platform( "Microsoft Windows XP" )
    .platform( "Microsoft Windows Server 2003" )
    .platform( "Microsoft Windows Vista" )
    .platform( "Microsoft Windows 7" )
    .product( "Microsoft Office PowerPoint 2002" )
    .product( "Microsoft Office PowerPoint 2003" )
    ;


    private static final Reference  _REFERENCE_CVE_2010_0030_ =
        new Reference( "CVE", "CVE-2010-0030", "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2010-0030" )
    ;


    private static final OvalRepository  _OVAL_REPOSITORY_8050_ =
        new OvalRepository()
    .event( new Submitted( "2010-02-08T13:00:00", new Contributor( "Dragos Prisaca", "Symantec, Inc." )) )
    .event( new StatusChange( "2010-02-10T13:38:39.224-05:00", DefinitionStatus.DRAFT ) )
    .event( new StatusChange( "2010-03-01T04:00:14.451-05:00", DefinitionStatus.INTERIM ) )
    .event( new StatusChange( "2010-03-22T04:00:06.424-04:00", DefinitionStatus.ACCEPTED ) )
    .status( DefinitionStatus.ACCEPTED )
    ;


    private static final Metadata  _METADATA_8050_ =
        new Metadata()
    .title( "PowerPoint LinkedSlideAtom Heap Overflow Vulnerability" )
    .description( "Heap-based buffer overflow in Microsoft Office PowerPoint 2002 SP3 and 2003 SP3 allows remote attackers to execute arbitrary code via a crafted PowerPoint document, aka \"PowerPoint LinkedSlideAtom Heap Overflow Vulnerability.\"" )
    .affected( _AFFECTED_8050_ )
    .reference( _REFERENCE_CVE_2010_0030_ )
    .additionalMetadata( _OVAL_REPOSITORY_8050_ )
    ;


    private static final Criteria  _CRITERIA_8050_ =
        new Criteria( Operator.OR )
    .element(
                    new Criteria( Operator.AND, "PowerPoint 2002" )
                    .element( new ExtendDefinition( "oval:org.mitre.oval:def:305",
                                    "Microsoft PowerPoint 2002 is installed" )
                    )
                    .element( new Criterion( "oval:org.mitre.oval:tst:21080",
                                    "Powerpnt.exe is less than version 10.0.6858.0" )
                    )
    )
    .element(
                    new Criteria( Operator.AND, "PowerPoint 2003" )
                    .element( new ExtendDefinition( "oval:org.mitre.oval:def:666",
                                    "Microsoft PowerPoint 2003 is installed" )
                    )
                    .element( new Criterion( "oval:org.mitre.oval:tst:20855",
                                    "Powerpnt.exe is less than version 11.0.8318.0" )
                    )
    );


    public static final Definition  DEFINITION_8050 =
        new Definition( "oval:org.mitre.oval:def:8050", 1,
                        DefinitionClass.VULNERABILITY,
                        _METADATA_8050_
                        )
    .criteria( _CRITERIA_8050_ )
    ;



    //**************************************************************
    //  def:definition 666
    //**************************************************************

    private static final Affected  _AFFECTED_666_ =
        new Affected( Family.WINDOWS )
    .platform( "Microsoft Windows 2000" )
    .platform( "Microsoft Windows XP" )
    .platform( "Microsoft Windows Server 2003" )
    .product( "Microsoft PowerPoint 2003" )
    ;


    private static final Reference  _REFERENCE_CPE_POWERPOINT_2003_ =
        new Reference( "CPE", "cpe:/a:microsoft:powerpoint:2003" )
    ;


    private static final OvalRepository  _OVAL_REPOSITORY_666_ =
        new OvalRepository()
    .event( new Submitted( "2006-08-11T12:53:40", new Contributor( "Robert L. Hollis", "ThreatGuard, Inc." ) ) )
    .event( new StatusChange( "2006-09-08T11:26:00.000-04:00", DefinitionStatus.DRAFT ) )
    .event( new StatusChange( "2006-09-27T12:29:33.948-04:00", DefinitionStatus.INTERIM ) )
    .event( new StatusChange( "2006-10-16T15:58:46.477-04:00", DefinitionStatus.ACCEPTED ) )
    .event( new Modified( "2009-06-01T16:05:28.035-04:00", "Added Microsoft PowerPoint 2003 product. Removed Microsoft reference",
                    new Contributor( "Brendan Miles", "The MITRE Corporation" ) )
    )
    .event( new StatusChange( "2009-06-08T04:01:05.508-04:00", DefinitionStatus.INTERIM ) )
    .event( new StatusChange( "2009-06-29T04:01:08.748-04:00", DefinitionStatus.ACCEPTED ) )
    .status( DefinitionStatus.ACCEPTED )
    ;


    private static final Metadata  _METADATA_666_ =
        new Metadata()
    .title( "Microsoft PowerPoint 2003 is installed" )
    .description( "The application Microsoft PowerPoint 2003 is installed." )
    .affected( _AFFECTED_666_ )
    .reference( _REFERENCE_CPE_POWERPOINT_2003_ )
    .additionalMetadata( _OVAL_REPOSITORY_666_ )
    ;


    private static final Criteria  _CRITERIA_666_ =
        new Criteria()
    .element(
                    new Criterion( "oval:org.mitre.oval:tst:1204",
                                    "Microsoft PowerPoint 2003 is installed"
                    )
    )
    ;


    public static final Definition  DEFINITION_666 =
        new Definition( "oval:org.mitre.oval:def:666", 3,
                        DefinitionClass.INVENTORY,
                        _METADATA_666_
                        )
    .criteria( _CRITERIA_666_ )
    ;



    //**************************************************************
    //  def:definition 305
    //**************************************************************

    private static final Affected  _AFFECTED_305_ =
        new Affected( Family.WINDOWS )
    .platform( "Microsoft Windows 2000" )
    .platform( "Microsoft Windows XP" )
    .platform( "Microsoft Windows Server 2003" )
    .product( "Microsoft PowerPoint 2002" )
    ;


    private static final Reference  _REFERENCE_CPE_POWERPOINT_2002_ =
        new Reference( "CPE", "cpe:/a:microsoft:powerpoint:2002" )
    ;


    private static final OvalRepository  _OVAL_REPOSITORY_305_ =
        new OvalRepository()
    .event( new Submitted( "2006-08-11T12:53:40", new Contributor( "Robert L. Hollis", "ThreatGuard, Inc." ) ) )
    .event( new StatusChange( "2006-09-08T11:26:00.000-04:00", DefinitionStatus.DRAFT ) )
    .event( new StatusChange( "2006-09-27T12:29:20.418-04:00", DefinitionStatus.INTERIM ) )
    .event( new StatusChange( "2006-10-16T15:58:37.787-04:00", DefinitionStatus.ACCEPTED ) )
    .event( new Modified( "2007-02-12T10:34:00.838-05:00", "Corrected tst:704. Removed reference to ste:631 and deprecated ste:631",
                    new Contributor( "Jonathan Baker", "The MITRE Corporation" ) )
    )
    .event( new StatusChange( "2007-02-12T10:37:25.230-05:00", DefinitionStatus.INTERIM ) )
    .event( new StatusChange( "2007-03-21T16:17:15.526-04:00", DefinitionStatus.ACCEPTED ) )
    .event( new Modified( "2009-06-01T16:05:28.035-04:00", "Added Microsoft PowerPoint 2003 product. Removed Microsoft reference",
                    new Contributor( "Brendan Miles", "The MITRE Corporation" ) )
    )
    .event( new StatusChange( "2009-06-08T04:00:38.590-04:00", DefinitionStatus.INTERIM ) )
    .event( new StatusChange( "2009-06-29T04:00:23.339-04:00", DefinitionStatus.ACCEPTED ) )
    .status( DefinitionStatus.ACCEPTED )
    ;


    private static final Metadata  _METADATA_305_ =
        new Metadata()
    .title( "Microsoft PowerPoint 2002 is installed" )
    .description( "The application Microsoft PowerPoint 2002 is installed." )
    .affected( _AFFECTED_305_ )
    .reference( _REFERENCE_CPE_POWERPOINT_2002_ )
    .additionalMetadata( _OVAL_REPOSITORY_305_ )
    ;


    private static final Criteria  _CRITERIA_305_ =
        new Criteria()
    .element(
                    new Criterion( "oval:org.mitre.oval:tst:704",
                                    "Microsoft PowerPoint 2002 is installed"
                    )
    )
    ;


    public static final Definition  DEFINITION_305 =
        new Definition( "oval:org.mitre.oval:def:305", 3,
                        DefinitionClass.INVENTORY,
                        _METADATA_305_
                        )
    .criteria( _CRITERIA_305_ )
    ;



    //**************************************************************
    //  def:test 1204, 704, 21080, 20855
    //**************************************************************

    public static final Test  TEST_WINDOWS_REGISTRY_1204 =
        new RegistryTest( "oval:org.mitre.oval:tst:1204", 2,
                        "Microsoft PowerPoint 2003 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:850" )
    ;


    public static final Test  TEST_WINDOWS_REGISTRY_704 =
        new RegistryTest( "oval:org.mitre.oval:tst:704", 2,
                        "Microsoft PowerPoint 2002 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:555" )
    ;


    public static final Test  TEST_WINDOWS_FILE_21080 =
        new FileTest( "oval:org.mitre.oval:tst:21080", 1,
                        "Powerpnt.exe is less than version 10.0.6858.0",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:553" )
    .state( "oval:org.mitre.oval:ste:6617" )
    ;


    public static final Test  TEST_WINDOWS_FILE_20855 =
        new FileTest( "oval:org.mitre.oval:tst:20855", 1,
                        "Powerpnt.exe is less than version 11.0.8318.0",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:553" )
    .state( "oval:org.mitre.oval:ste:6706" )
    ;



    //**************************************************************
    //  def:object 850, 555, 553, 554
    //**************************************************************

    public static final RegistryObject  OBJECT_WINDOWS_REGISTRY_850 =
        new RegistryObject( "oval:org.mitre.oval:obj:850", 2 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\Microsoft\\Office\\11.0\\PowerPoint\\InstallRoot" ) )
    .name( new EntityObjectString( "Path" ) )
    ;


    public static final RegistryObject  OBJECT_WINDOWS_REGISTRY_555 =
        new RegistryObject( "oval:org.mitre.oval:obj:555", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\Microsoft\\Office\\10.0\\PowerPoint\\InstallRoot" ) )
    .name( new EntityObjectString( "Path" ) )
    ;


    public static final FileObject  OBJECT_WINDOWS_FILE_553 =
        new FileObject( "oval:org.mitre.oval:obj:553", 2 )
    .path( new EntityObjectString( "oval:org.mitre.oval:var:225", Check.ALL ) )
    .filename( new EntityObjectString( "powerpnt.exe" ) )
    ;


    public static final RegistryObject  OBJECT_WINDOWS_REGISTRY_554 =
        new RegistryObject( "oval:org.mitre.oval:obj:554", 1 )
    .hive( new EntityObjectRegistryHive( "HKEY_LOCAL_MACHINE" ) )
    .key( new EntityObjectString( "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\App Paths\\powerpnt.exe" ) )
    .name( new EntityObjectString( "Path" ) )
    ;



    //**************************************************************
    //  def:state 6617, 6706
    //**************************************************************

    public static final FileState  STATE_WINDOWS_FILE_6617 =
        new FileState( "oval:org.mitre.oval:ste:6617", 1 )
    .version( new EntityStateVersion( "10.0.6858.0",
                    Datatype.VERSION, Operation.LESS_THAN ) )
    ;


    public static final FileState  STATE_WINDOWS_FILE_6706 =
        new FileState( "oval:org.mitre.oval:ste:6706", 1 )
    .version( new EntityStateVersion( "11.0.8318.0",
                    Datatype.VERSION, Operation.LESS_THAN ) )
    ;



    //**************************************************************
    //  def:variable 225
    //**************************************************************

    public static final LocalVariable  VARIABLE_LOCAL_225 =
        new LocalVariable( "oval:org.mitre.oval:var:225", 1,
                        "...",
                        Datatype.STRING
        )
    .component(
                    new ObjectComponent( "oval:org.mitre.oval:obj:554",
                                    "value"
                    )
    );



    //**************************************************************
    //  def:test 1204, 704, 21080, 20855
    //**************************************************************


    private static final Generator  _GENERATOR_8050_ =
        new Generator( "5.8",
                        "2010-10-19T22:19:10.906-04:00",
                        "The OVAL Repository",
                        null
                        );


    public static final OvalDefinitions  OVAL_DEFINITIONS_8050 =
        new OvalDefinitions( _GENERATOR_8050_ )
    .definition( DEFINITION_8050 )
    .definition( DEFINITION_666 )
    .definition( DEFINITION_305 )
    .test( TEST_WINDOWS_REGISTRY_1204 )
    .test( TEST_WINDOWS_REGISTRY_704 )
    .test( TEST_WINDOWS_FILE_21080 )
    .test( TEST_WINDOWS_FILE_20855 )
    .object( OBJECT_WINDOWS_REGISTRY_850 )
    .object( OBJECT_WINDOWS_REGISTRY_555 )
    .object( OBJECT_WINDOWS_FILE_553 )
    .object( OBJECT_WINDOWS_REGISTRY_554 )
    .state( STATE_WINDOWS_FILE_6617 )
    .state( STATE_WINDOWS_FILE_6706 )
    .variable( VARIABLE_LOCAL_225 )
    ;

}
// DefinitionsSample

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

