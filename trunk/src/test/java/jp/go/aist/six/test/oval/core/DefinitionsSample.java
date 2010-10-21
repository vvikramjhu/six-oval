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
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityStateVersion;
import jp.go.aist.six.oval.model.definitions.ExtendDefinition;
import jp.go.aist.six.oval.model.definitions.LocalVariable;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.ObjectComponent;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.mitre.Contributor;
import jp.go.aist.six.oval.model.mitre.DefinitionStatus;
import jp.go.aist.six.oval.model.mitre.Modified;
import jp.go.aist.six.oval.model.mitre.OvalRepository;
import jp.go.aist.six.oval.model.mitre.StatusChange;
import jp.go.aist.six.oval.model.mitre.Submitted;
import jp.go.aist.six.oval.model.windows.EntityObjectRegistryHive;
import jp.go.aist.six.oval.model.windows.FileObject;
import jp.go.aist.six.oval.model.windows.FileState;
import jp.go.aist.six.oval.model.windows.FileTest;
import jp.go.aist.six.oval.model.windows.RegistryObject;
import jp.go.aist.six.oval.model.windows.RegistryTest;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionsSample
{

    //==============================================================
    //  def:definition 8050
    //==============================================================

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



    //==============================================================
    //  def:definition 666
    //==============================================================

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



    //==============================================================
    //  def:definition 305
    //==============================================================

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



    //==============================================================
    //  def:test
    //==============================================================

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


    //==============================================================
    //  def:object
    //==============================================================

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


    //==============================================================
    //  def:state
    //==============================================================

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



    //==============================================================
    //  def:variable
    //==============================================================

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



    //==============================================================
    //  def:oval_definitions
    //==============================================================

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

