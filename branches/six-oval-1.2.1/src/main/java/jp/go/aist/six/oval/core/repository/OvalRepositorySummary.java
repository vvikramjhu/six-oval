package jp.go.aist.six.oval.core.repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalRepository;
import jp.go.aist.six.oval.model.common.GeneratorType;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.SystemType;
import jp.go.aist.six.oval.model.sc.InterfaceType;
import jp.go.aist.six.oval.model.sc.SystemInfoType;
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.QueryResults;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalRepositorySummary
{

    public static void main(
                    final String[] args
                    )
    throws Exception
    {
        final OvalRepositorySummary  ovaldi = new OvalRepositorySummary();
        ovaldi.report();
    }



    private final MongoOvalRepository  _oval_repository;



    /**
     */
    public OvalRepositorySummary()
    throws Exception
    {
        _oval_repository = OvalContext.getServerInstance().getBean( MongoOvalRepository.class );
    }



    /**
     *
     * @throws Exception
     */
    public void report()
    throws Exception
    {
        System.out.println( "\n//////////////////////////////////////////////////////////" );
        Date  datetime = new Date();
        System.out.println( "Oval Results Report, " + datetime );

        QueryResults<OvalResults>  query_results = _oval_repository.findOvalResults();
        List<OvalResults>  oval_results_list = query_results.getElements();

        /* [count] */
        System.out.println( "\n[count]" );
        long  count = oval_results_list.size();
        System.out.println( count );

        /* [history] in the date/time order */
        Collections.sort( oval_results_list, new OvalResultsTimestampComparator() );
        System.out.println( "\n[history]" );
        for (OvalResults  res : oval_results_list) {
            String  id = res.getPersistentID();
            GeneratorType  generator = res.getGenerator();
            System.out.print( id + ", " + generator.getTimestamp() + "," );
            for (SystemType  sys : res.getResults().getSystem()) {
                System.out.print( " " + sys.getOvalSystemCharacteristics().getSystemInfo().getPrimaryHostName() );
            }
            System.out.print( "\n" );
        }

        /* [details] */
        System.out.println( "\n[details]" );
        for (OvalResults  res : oval_results_list) {
            System.out.println( "----------------------------------------------------------" );
            String  id = res.getPersistentID();
            GeneratorType  generator = res.getGenerator();
            System.out.println( "ID: " + id );
            System.out.println( "date/time: " + generator.getTimestamp() );
            for (SystemType  sys : res.getResults().getSystem()) {
                SystemInfoType  sys_info = sys.getOvalSystemCharacteristics().getSystemInfo();
                System.out.println( "hostname: " + sys_info.getPrimaryHostName() );
                System.out.println( "OS: " + sys_info.getOsName() + ", " + sys_info.getOsVersion() );
                for (InterfaceType  net : sys_info.getInterfaces().getInterface()) {
                    System.out.println( "IP/Mac addr: " + net.getIpAddress() + "/" + net.getMacAddress() );
                }
            }
            System.out.print( "\n" );
        }
    }



    public static class OvalResultsTimestampComparator
    implements Comparator<OvalResults>
    {
        @Override
        public int compare( final OvalResults o1, final OvalResults o2 )
        {
            GeneratorType  generator1 = o1.getGenerator();
            GeneratorType  generator2 = o2.getGenerator();

            return String.CASE_INSENSITIVE_ORDER.compare( generator1.getTimestamp(), generator2.getTimestamp() );
        }


        @Override
        public boolean equals( final Object obj )
        {
            return OvalResultsTimestampComparator.class.isInstance( obj );
        }
    }


    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    public Object[][] provideRepositoryQueryParamsOvalResults()
    {
        // sc: host
        OvalResultsQueryParams  params21 = new OvalResultsQueryParams();
        params21.setHost( "host66.foo.com" );

        // sc: host
        OvalResultsQueryParams  params22 = new OvalResultsQueryParams();
        params22.setHost( "*.bar.com" );

        // sc: IP
        OvalResultsQueryParams  params23 = new OvalResultsQueryParams();
        params23.setIp( "192.168.10.*" );

        // sc: MAC
        OvalResultsQueryParams  params24 = new OvalResultsQueryParams();
        params24.setMac( "00-50-56-C0-00-01" );

        // sc: OS
        OvalResultsQueryParams  params25 = new OvalResultsQueryParams();
        params25.setOs( "Windows*" );

        // sc: OS
        OvalResultsQueryParams  params26 = new OvalResultsQueryParams();
        params26.setOs( "Linux" );


        // res: definition
        OvalResultsQueryParams  params31 = new OvalResultsQueryParams();
        params31.setDefinition( "oval:org.mitre.oval:def:6210" );

        OvalResultsQueryParams  params32 = new OvalResultsQueryParams();
        params32.setDefinition( "oval:org.mitre.oval:def:6210,oval:org.mitre.oval:def:12514" );


        // res: definition true
        OvalResultsQueryParams  params33 = new OvalResultsQueryParams();
        params33.setDefinitionTrue( "oval:org.mitre.oval:def:6210" );

        OvalResultsQueryParams  params34 = new OvalResultsQueryParams();
        params34.setDefinitionTrue( "oval:org.mitre.oval:def:11985" );

        OvalResultsQueryParams  params35 = new OvalResultsQueryParams();
        params35.setDefinitionTrue( "oval:org.mitre.oval:def:11985,oval:org.mitre.oval:def:12514" );

        OvalResultsQueryParams  params36 = new OvalResultsQueryParams();
        params36.setOs( "Linux" );
        params36.setDefinitionTrue( "oval:com.redhat.rhsa:def:20100332" );



        return new Object[][] {
                        {
                            "21",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params21
                        }
                        ,
                        {
                            "22",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params22
                        }
                        ,
                        {
                            "23",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params23
                        }
                        ,
                        {
                            "24",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params24
                        }
                        ,
                        {
                            "25",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params25
                        }
                        ,
                        {
                            "26",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params26
                        }
                        ,
                        {
                            "31",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params31
                        }
                        ,
                        {
                            "32",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params32
                        }
                        ,
                        {
                            "33",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params33
                        }
                        ,
                        {
                            "34",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params34
                        }
                        ,
                        {
                            "35",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params35
                        }
                        ,
                        {
                            "36",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params36
                        }
        };
    }

}
//
