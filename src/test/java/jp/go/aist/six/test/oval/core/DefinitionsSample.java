package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.common.ExistenceEnumeration;
import jp.go.aist.six.oval.model.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.common.OperationEnumeration;
import jp.go.aist.six.oval.model.common.OperatorEnumeration;
import jp.go.aist.six.oval.model.definitions.AffectedType;
import jp.go.aist.six.oval.model.definitions.ConcatFunctionType;
import jp.go.aist.six.oval.model.definitions.CriteriaElement;
import jp.go.aist.six.oval.model.definitions.CriteriaType;
import jp.go.aist.six.oval.model.definitions.CriterionType;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.ExtendDefinitionType;
import jp.go.aist.six.oval.model.definitions.LiteralComponentType;
import jp.go.aist.six.oval.model.definitions.LocalVariable;
import jp.go.aist.six.oval.model.definitions.MetadataType;
import jp.go.aist.six.oval.model.definitions.ObjectComponentType;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.Product;
import jp.go.aist.six.oval.model.definitions.ReferenceType;
import jp.go.aist.six.oval.model.definitions.StateRefType;
import jp.go.aist.six.oval.model.definitions.SystemObjectRefType;
import jp.go.aist.six.oval.model.mitre.Contributor;
import jp.go.aist.six.oval.model.mitre.DefinitionStatusEnumeration;
import jp.go.aist.six.oval.model.mitre.Modified;
import jp.go.aist.six.oval.model.mitre.OvalRepository;
import jp.go.aist.six.oval.model.mitre.StatusChange;
import jp.go.aist.six.oval.model.mitre.Submitted;
import jp.go.aist.six.oval.model.v5.windows.RegistryHiveEnumeration;
import jp.go.aist.six.oval.model.v5.windows.RegistryObject;
import jp.go.aist.six.oval.model.v5.windows.RegistryState;
import jp.go.aist.six.oval.model.v5.windows.RegistryTest;



public class DefinitionsSample
{

    //**************************************************************
    // oval-definitions-5
    //**************************************************************

    /**
     * var:200
     */
    public static final LocalVariable  VAR_200 = _createVariable200();

    private static LocalVariable _createVariable200()
    {
        LocalVariable  var200 =
            new LocalVariable(
                            "oval:org.mitre.oval:var:200", 1,
                            "Windows System32 directory",
                            DatatypeEnumeration.STRING

            );

        ConcatFunctionType  concat = new ConcatFunctionType();
        concat.addComponent(
                        new ObjectComponentType(
                                        "oval:org.mitre.oval:obj:219",
                                        "value"
                        )
        );
        concat.addComponent(
                        new LiteralComponentType(
                                        "\\System32"
                        )
        );

        var200.setComponent( concat );

        return var200;
    }



    /**
     * ste:5310
     */
    public static final RegistryState  STE_5310 = _createState5310();

    private static RegistryState _createState5310()
    {
        RegistryState  ste5310 =
            new RegistryState(
                            "oval:org.mitre.oval:ste:5310", 1,
                            "The registry key matches with Mozilla Firefox, Mozilla SeaMonkey and Mozilla Thunderbird installed"
            );

        EntityStateAnySimpleType  value = new EntityStateAnySimpleType( "^[0-9]\\..*" );
        value.setOperation( OperationEnumeration.PATTERN_MATCH );

        ste5310.setValue( value );

        return ste5310;
    }



    /**
     * obj:6886
     */
    public static final RegistryObject  OBJ_6886 = _createObject6886();

    private static RegistryObject _createObject6886()
    {
        RegistryObject  obj6886 =
            new RegistryObject(
                            "oval:org.mitre.oval:obj:6886", 1,
                            "The registry key that holds the version of the Firefox",
                            RegistryHiveEnumeration.HKEY_LOCAL_MACHINE,
                            "SOFTWARE\\Mozilla\\Mozilla Firefox",
                            "CurrentVersion"
            );

        return obj6886;
    }




    /**
     * tst:11127
     */
    public static final RegistryTest  TST_11127 = _createTest11127();

    private static RegistryTest _createTest11127()
    {
        RegistryTest  tst11127 =
            new RegistryTest(
                            "oval:org.mitre.oval:tst:11127", 1,
                            "Mozilla Firefox is installed",
                            CheckEnumeration.ALL,
                            new SystemObjectRefType( "oval:org.mitre.oval:obj:6886" ),
                            new StateRefType[] {
                                new StateRefType( "oval:org.mitre.oval:ste:5310" )
                            }
            );

        tst11127.setCheckExistence( ExistenceEnumeration.AT_LEAST_ONE_EXISTS );

        return tst11127;
    }



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

        ReferenceType  ref = new ReferenceType( "CVE", "CVE-2010-0176",
                        "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2010-0176" );

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
        meta.addAdditionalMetadata( ovalRepo );
        meta.addReference( ref );

        DefinitionType  def = new DefinitionType(
                        "oval:org.mitre.oval:def:7222", 5,
                        ClassEnumeration.VULNERABILITY
        );
        def.setMetadata( meta );
        def.setCriteria( criteria );

        return def;
    }

}
