package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.definitions.DefinitionClass;
import jp.go.aist.six.oval.model.results.Result;
import jp.go.aist.six.util.search.LikeBinding;
import jp.go.aist.six.util.search.RelationalBinding;
import jp.go.aist.six.util.search.SearchCriteria;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalServiceTestBase.java 778 2010-05-11 06:26:16Z akihito $
 */
public abstract class OvalServiceTestBase
{

    protected OvalXml  _xml = null;
    protected OvalStore  _store = null;



    /**
     */
    public OvalServiceTestBase()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        OvalContext  service = new OvalContext();
        _xml = service.getXml();
        _store = service.getStore();
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  OVAL Resutls
    //
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    /**
     */
    @DataProvider( name="oval-definition-result-result" )
    public Object[][] ovalDefinitionResultResultProvider()
    {
        return new Object[][] {
                        {
                            Result.TRUE
                        }
        };
    }


    /**
     */
    @DataProvider( name="oval-system-result-criteria" )
    public Object[][] ovalSystemResultCriteriaProvider()
    {
        return new Object[][] {
                        {
                            (new SearchCriteria(
                                            RelationalBinding.equalBinding(
                                                            "ovalSystemCharacteristics.systemInfo.primaryHostName",
                                                            "x60" )))
                        }
                        ,
                        {
                            (new SearchCriteria(
                                            RelationalBinding.equalBinding(
                                                            "ovalSystemCharacteristics.systemInfo.interfaces.ipAddress",
                                                            "192.168.158.1" )))
                        }
                        ,
                        {
                            (new SearchCriteria(
                                            new LikeBinding(
                                                            "ovalSystemCharacteristics.systemInfo.interfaces.interfaceName",
                                                            "VMware%" )))
                        }
        };
    }



    //==============================================================
    //  oval_results
    //==============================================================

    /**
     */
    @DataProvider( name="oval-result-results" )
    public Object[][] ovalResultsProvider()
    {
        return new Object[][] {
//                        {
//                            "test/data/result/sample_oval-results_1.xml"
//                        }
//                        ,
//                        {
//                            "test/data/result/sample_oval-results_2.xml"
//                        }
//                        ,
                        {
                            "test/data/result/sample_oval-results_debian5.xml"
                        }
                        ,
                        {
                            "test/data/result/sample_oval-results_inventory_windows-xp.xml"
                        }
        };
    }



    //==============================================================
    //  definition
    //==============================================================

    /**
     */
    @DataProvider( name="oval-result-definition" )
    public Object[][] ovalResultDefinitionProvider()
    {
        return new Object[][] {
                        {
                            "test/data/sample_oval-result_definition-false.xml",
                            "oval:org.mitre.oval:def:100085",
                            1,
                            Result.FALSE
                        }
                        ,
                        {
                            "test/data/sample_oval-result_definition-true.xml",
                            "oval:org.mitre.oval:def:6193",
                            0,
                            Result.TRUE
                        }
        };
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  OVAL System Characteristics
    //
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    /**
     */
    @DataProvider( name="oval-system-sc" )
    public Object[][] ovalSystemSCProvider()
    {
        return new Object[][] {
                        {
                            "test/data/system/sample_oval-sc_debian5.xml"
                        }
                        ,
                        {
                            "test/data/system/sample_oval-sc_windows.xml"
                        }
                        ,
                        {
                            "test/data/system/sample_oval-sc_linux-centos.xml"
                        }
        };
    }



    //==============================================================
    //  definition
    //==============================================================

    /**
     */
    @DataProvider( name="oval-definition" )
    public Object[][] ovalDefinitionProvider()
    {
        return new Object[][] {
                        // windows, from Mitre
                        {
                            "test/data/sample_oval-definition-2-windows.xml",
                            "oval:org.mitre.oval:def:1020",
                            2,
                            DefinitionClass.VULNERABILITY
                        },

                        // linux, from Mitre
                        {
                            "test/data/sample_oval-definition-1-debian.xml",
                            "oval:org.mitre.oval:def:8201",
                            1,
                            DefinitionClass.PATCH
                        },

                        // linux, from Mitre
                        {
                            "test/data/sample_oval-definition-4-debian-inventory.xml",
                            "oval:org.mitre.oval:def:6513",
                            1,
                            DefinitionClass.INVENTORY
                        },

                        // linux, from Red Hat
                        {
                            "test/data/sample_oval-definition-3-redhat.xml",
                            "oval:com.redhat.rhsa:def:20100061",
                            301,
                            DefinitionClass.PATCH
                        }
        };
    }



    //==============================================================
    //  object
    //==============================================================

    /**
     */
    @DataProvider( name="oval-object" )
    public Object[][] ovalObjectProvider()
    {
        return new Object[][] {
                        // independent : family
                        {
                            "test/data/definition/sample_oval-object-family.xml",
                            "oval:org.mitre.oval:obj:99",
                            1,
                            "This is the default family object. Only one family object should exist."
                        },

                        // independent : textfilecontent
                        {
                            "test/data/definition/sample_oval-object-textfilecontent.xml",
                            "oval:org.mitre.oval:obj:7326",
                            1,
                            null
                        },

                        // linux : dpkginfo
                        {
                            "test/data/definition/sample_oval-object-dpkginfo.xml",
                            "oval:org.mitre.oval:obj:10648",
                            1,
                            "apache2 package information"
                        },

                        // linux : rpminfo
                        {
                            "test/data/definition/sample_oval-object-rpminfo.xml",
                            "oval:com.redhat.rhsa:obj:20100061001",
                            301,
                            null
                        },

                        // unux : uname
                        {
                            "test/data/definition/sample_oval-object-uname.xml",
                            "oval:org.mitre.oval:obj:2759",
                            1,
                            "The single uname object."
                        },

                        // windows : file
                        {
                            "test/data/definition/sample_oval-object-file.xml",
                            "oval:org.mitre.oval:obj:222",
                            1,
                            "The path to the mshtml.dll file in the system root"
                        },

                        // windows : metabase
                        {
                            "test/data/definition/sample_oval-object-metabase.xml",
                            "oval:org.mitre.oval:obj:556",
                            2,
                            null
                        },

                        // windows : registry
                        {
                            "test/data/definition/sample_oval-object-registry.xml",
                            "oval:org.mitre.oval:obj:717",
                            1,
                            "This registry key holds the service pack installed on the host if one is present."
                        }
        };
    }



    //==============================================================
    //  variable
    //==============================================================

    /**
     */
    @DataProvider( name="oval-variable" )
    public Object[][] ovalVariableProvider()
    {
        return new Object[][] {
                        {
                            "test/data/sample_oval-variable-local-object_component.xml",
                            "oval:org.mitre.oval:var:244",
                            1
                        }
        };

    }

}
// OvalServiceTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

