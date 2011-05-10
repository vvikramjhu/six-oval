package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.v5.common.ClassEnumeration;
import jp.go.aist.six.oval.model.v5.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.v5.common.OperatorEnumeration;
import jp.go.aist.six.oval.model.v5.definitions.AffectedType;
import jp.go.aist.six.oval.model.v5.definitions.CriteriaElement;
import jp.go.aist.six.oval.model.v5.definitions.CriteriaType;
import jp.go.aist.six.oval.model.v5.definitions.CriterionType;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.ExtendDefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.MetadataType;
import jp.go.aist.six.oval.model.v5.definitions.Platform;
import jp.go.aist.six.oval.model.v5.definitions.Product;
import jp.go.aist.six.oval.model.v5.mitre.Contributor;
import jp.go.aist.six.oval.model.v5.mitre.DefinitionStatusEnumeration;
import jp.go.aist.six.oval.model.v5.mitre.Modified;
import jp.go.aist.six.oval.model.v5.mitre.OvalRepository;
import jp.go.aist.six.oval.model.v5.mitre.StatusChange;
import jp.go.aist.six.oval.model.v5.mitre.Submitted;



public class DefinitionsSample
{

    /**
     * def:7222
     */
    public static final DefinitionType  DEF_7222 = _createDefinition7222();

    private static DefinitionType _createDefinition7222()
    {
        CriteriaType  criteria = new CriteriaType( OperatorEnumeration.OR, new CriteriaElement[] {
                        new CriteriaType( OperatorEnumeration.AND, new CriteriaElement[] {
                                        new ExtendDefinitionType(
                                                        "oval:org.mitre.oval:def:6562",
                                                        "Mozilla Firefox is installed"
                                        ),
                                        new CriterionType(
                                                        "oval:org.mitre.oval:tst:11112",
                                                        "Mozilla Firefox before 3.0.19, 3.5.x before 3.5.9 and 3.6.x before 3.6.2"
                                        )
                        } ),
                        new CriteriaType( OperatorEnumeration.AND, new CriteriaElement[] {
                                        new ExtendDefinitionType(
                                                        "oval:org.mitre.oval:def:6372",
                                                        "Mozilla Seamonkey is installed"
                                        ),
                                        new CriteriaType( OperatorEnumeration.OR, new CriteriaElement[] {
                                                        new CriterionType(
                                                                        "oval:org.mitre.oval:tst:10688",
                                                                        "Mozilla Seamonkey version less than 2.0"
                                                        ),
                                                        new CriterionType(
                                                                        "oval:org.mitre.oval:tst:11460",
                                                                        "Mozilla Seamonkey version 2.x and less than 2.0.4"
                                                        )
                                        } )

                        } ),
                        new CriteriaType( OperatorEnumeration.AND, new CriteriaElement[] {
                                        new ExtendDefinitionType(
                                                        "oval:org.mitre.oval:def:6504",
                                                        "Mozilla Thunderbird is installed"
                                        ),
                                        new CriterionType(
                                                        "oval:org.mitre.oval:tst:11666",
                                                        "Mozilla Thunderbird version less than 3.0.4"
                                        )
                        } )
        } );


        AffectedType  affected = new AffectedType(
                        FamilyEnumeration.WINDOWS,
                        new Platform[] {
                                        new Platform( "Microsoft Windows 2000" ),
                                        new Platform( "Microsoft Windows XP" ),
                                        new Platform( "Microsoft Windows Server 2003" ),
                                        new Platform( "Microsoft Windows Server 2008" ),
                                        new Platform( "Microsoft Windows Vista" ),
                                        new Platform( "Microsoft Windows 7" )
                        },
                        new Product[] {
                                        new Product( "Mozilla Firefox" ),
                                        new Product( "Mozilla Thunderbird" ),
                                        new Product( "Mozilla SeaMonkey" )
                        }
        );

        OvalRepository  ovalRepo = new OvalRepository();
        ovalRepo.date( new Submitted(
                        "2010-04-05T10:30:00.000-05:00",
                        new Contributor( "J. Daniel Brown", "DTCC" )) );
        ovalRepo.date( new StatusChange(
                        "2010-04-07T15:53:02.494-04:00",
                        DefinitionStatusEnumeration.DRAFT ) );
        ovalRepo.date( new StatusChange(
                        "2010-05-17T04:00:48.082-04:00",
                        DefinitionStatusEnumeration.INTERIM ) );
        ovalRepo.date( new StatusChange(
                        "2010-06-07T04:00:33.800-04:00",
                        DefinitionStatusEnumeration.ACCEPTED ) );
        ovalRepo.date( new Modified(
                        "2010-08-11T13:18:00.931-04:00",
                        "Changed [03] to [0-3] in the regex pattern for oval:org.mitre.oval:ste:5296.",
                        new Contributor( "J. Daniel Brown", "DTCC" )) );
        ovalRepo.date( new StatusChange(
                        "2010-08-11T13:18:53.431-04:00",
                        DefinitionStatusEnumeration.INTERIM ) );
        ovalRepo.date( new StatusChange(
                        "2010-08-30T04:00:13.544-04:00",
                        DefinitionStatusEnumeration.ACCEPTED ) );
        ovalRepo.setStatus( DefinitionStatusEnumeration.ACCEPTED );

        MetadataType  meta = new MetadataType(
                        "Mozilla Firefox/Thunderbird/SeaMonkey XUL Tree Optgroup Dangling Pointer Vulnerability",
                        "Mozilla Firefox before 3.0.19, 3.5.x before 3.5.9, and 3.6.x before 3.6.2; "
                        + "Thunderbird before 3.0.4; and SeaMonkey before 2.0.4 do not properly manage "
                        + "reference counts for option elements in a XUL tree optgroup, "
                        + "which might allow remote attackers to execute arbitrary code "
                        + "via unspecified vectors that trigger access to deleted elements, "
                        + "related to a \"dangling pointer vulnerability.\""
        );
        meta.addAffected( affected );
        meta.additionalMetadata( ovalRepo );


        DefinitionType  def = new DefinitionType(
                        "oval:org.mitre.oval:def:7222", 5,
                        ClassEnumeration.VULNERABILITY
        );
        def.setMetadata( meta );
        def.setCriteria( criteria );

        return def;
    }

}
