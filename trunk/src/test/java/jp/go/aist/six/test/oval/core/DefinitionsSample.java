package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.DefinitionClass;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.ExtendDefinition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.mitre.Contributor;
import jp.go.aist.six.oval.model.mitre.DefinitionStatus;
import jp.go.aist.six.oval.model.mitre.OvalRepository;
import jp.go.aist.six.oval.model.mitre.StatusChange;
import jp.go.aist.six.oval.model.mitre.Submitted;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionsSample
{

    //==============================================================
    //  def:definition
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
        new Reference( "CVE", "CVE-2010-0030", "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2010-0030")
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


    public static final Definition  DEFINITION_8050 =
        new Definition( "oval:org.mitre.oval:def:8050", 1,
                        DefinitionClass.VULNERABILITY,
                        _METADATA_8050_
                        )
    .criteria( _CRITERIA_8500_ )
    ;



}
// DefinitionsSample

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

