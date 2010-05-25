package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.definition.DefinitionClass;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.model.result.Result;
import jp.go.aist.six.oval.service.Oval;
import jp.go.aist.six.oval.service.OvalStore;
import jp.go.aist.six.oval.service.OvalXml;
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
        _xml = Oval.getXml();
        _store = Oval.getStore();
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
    //  state
    //==============================================================

    /**
     */
    @DataProvider( name="oval-state" )
    public Object[][] ovalStateProvider()
    {
        return new Object[][] {
                        {
                            ComponentType.INDEPENDENT_FAMILY,
                            "test/data/definition/sample_oval-state-family.xml",
                            "oval:org.mitre.oval:ste:99",
                            2
                        }
                        ,
                        {
                            ComponentType.INDEPENDENT_TEXTFILECONTENT,
                            "test/data/definition/sample_oval-state-textfilecontent.xml",
                            "oval:org.mitre.oval:ste:5132",
                            1
                        }
                        ,
                        {
                            ComponentType.WINDOWS_FILE,
                            "test/data/definition/sample_oval-state-file.xml",
                            "oval:org.mitre.oval:ste:2190",
                            1
                        }
                        ,
                        {
                            ComponentType.WINDOWS_METABASE,
                            "test/data/definition/sample_oval-state-metabase.xml",
                            "oval:org.mitre.oval:ste:537",
                            1
                        }
                        ,
                        {
                            ComponentType.WINDOWS_REGISTRY,
                            "test/data/definition/sample_oval-state-registry.xml",
                            "oval:org.mitre.oval:ste:1205",
                            1
                        }
                        ,
                        {
                            ComponentType.LINUX_DPKGINFO,
                            "test/data/definition/sample_oval-state-dpkginfo.xml",
                            "oval:org.mitre.oval:ste:5797",
                            1
                        }
                        ,
                        {
                            ComponentType.LINUX_RPMINFO,
                            "test/data/definition/sample_oval-state-rpminfo-evr.xml",
                            "oval:com.redhat.rhsa:ste:20100061004",
                            301
                        }
                        ,
                        {
                            ComponentType.LINUX_RPMINFO,
                            "test/data/definition/sample_oval-state-rpminfo-version.xml",
                            "oval:com.redhat.rhsa:ste:20100061003",
                            301
                        }
                        ,
                        {
                            ComponentType.LINUX_RPMINFO,
                            "test/data/definition/sample_oval-state-rpminfo-signature_keyid.xml",
                            "oval:com.redhat.rhsa:ste:20100061002",
                            301
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
    //  test
    //==============================================================

    /**
     */
    @DataProvider( name="oval-test" )
    public Object[][] ovalTestProvider()
    {
        return new Object[][] {
                        // independent : family test
                        {
                            "test/data/definition/sample_oval-test-family.xml",
                            "oval:org.mitre.oval:tst:99",
                            1,
                            "the installed operating system is part of the Microsoft Windows family",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ONLY_ONE,
                            ComponentType.INDEPENDENT_FAMILY,
                            "oval:org.mitre.oval:obj:99",
                            "oval:org.mitre.oval:ste:99"
                        },

                        // independent : textfilecontent test
                        {
                            "test/data/definition/sample_oval-test-textfilecontent.xml",
                            "oval:org.mitre.oval:tst:11150",
                            1,
                            "Debian GNU/Linux 5.0 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            ComponentType.INDEPENDENT_TEXTFILECONTENT,
                            "oval:org.mitre.oval:obj:7326",
                            "oval:org.mitre.oval:ste:5739"
                        },

                        // independent : unknown test
                        {
                            "test/data/definition/sample_oval-test-unknown.xml",
                            "oval:org.mitre.oval:tst:2531",
                            1,
                            "Word 97 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            ComponentType.INDEPENDENT_UNKNOWN,
                            null,
                            null
                        },

                        // unix : uname test
                        {
                            "test/data/definition/sample_oval-test-uname.xml",
                            "oval:org.mitre.oval:tst:11195",
                            1,
                            "Installed architecture is mips",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            ComponentType.UNIX_UNAME,
                            "oval:org.mitre.oval:obj:2759",
                            "oval:org.mitre.oval:ste:5601"
                        },

                        // windows : Registry test
                        {
                            "test/data/definition/sample_oval-test-registry.xml",
                            "oval:org.mitre.oval:tst:3019",
                            2,
                            "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.AT_LEAST_ONE,
                            ComponentType.WINDOWS_REGISTRY,
                            "oval:org.mitre.oval:obj:717",
                            "oval:org.mitre.oval:ste:2827"
                        },

                        // windows : Metabase test
                        {
                            "test/data/definition/sample_oval-test-metabase.xml",
                            "oval:org.mitre.oval:tst:709",
                            2,
                            "Negotiate is enabled",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.AT_LEAST_ONE,
                            ComponentType.WINDOWS_METABASE,
                            "oval:org.mitre.oval:obj:556",
                            null
                        },

                        // windows : File test
                        {
                            "test/data/definition/sample_oval-test-file.xml",
                            "oval:org.mitre.oval:tst:2339",
                            1,
                            "the version of mshtml.dll is less than 6.0.2900.2873",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.AT_LEAST_ONE,
                            ComponentType.WINDOWS_FILE,
                            "oval:org.mitre.oval:obj:222",
                            "oval:org.mitre.oval:ste:2190"
                        },

                        // linux : RpmInfo test
                        {
                            "test/data/definition/sample_oval-test-rpminfo.xml",
                            "oval:com.redhat.rhsa:tst:20100061002",
                            301,
                            "gzip is earlier than 0:1.3.5-11.el5_4.1",
                            Test.DEFAULT_CHECK_EXISTENCE,
                            Check.AT_LEAST_ONE,
                            ComponentType.LINUX_RPMINFO,
                            "oval:com.redhat.rhsa:obj:20100061002",
                            "oval:com.redhat.rhsa:ste:20100061004"
                        },

                        // linux : DpkgInfo test
                        {
                            "test/data/definition/sample_oval-test-dpkginfo.xml",
                            "oval:org.mitre.oval:tst:19402",
                            1,
                            "apache2-src is earlier than 2.2.9-10+lenny6",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            ComponentType.LINUX_DPKGINFO,
                            "oval:org.mitre.oval:obj:10286",
                            "oval:org.mitre.oval:ste:6372"
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

