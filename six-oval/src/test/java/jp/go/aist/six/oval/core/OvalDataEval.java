/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.go.aist.six.oval.core;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.ReferenceType;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.OvalRepository;
import jp.go.aist.six.util.repository.QueryResults;
import org.junit.Test;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDataEval
{

    public static void main(
                    final String[] args
                    )
    throws Exception
    {
        final OvalDataEval  ovaldi = new OvalDataEval();
        ovaldi.reportMitreCveCoverage2012();
    }



    private final OvalRepository  _oval_repository;



    /**
     */
    public OvalDataEval()
    throws Exception
    {
        _oval_repository = OvalContext.getServerInstance().getRepository();
    }



    /**
     */
    @Test
    public void reportMitreCveCoverage()
    throws Exception
    {
        PrintStream  outfile = new PrintStream(
                        "oval_cve-coverage_" + System.currentTimeMillis() + ".txt" );

        System.out.println( "[[[Mitre OVAL CVE Coverage]]]" );

        Map<String,DefinitionType>  cve_map = new TreeMap<String,DefinitionType>();

        DefinitionQueryParams  params = new DefinitionQueryParams();
        for (int  year = 1999; year <= 2013; year++) {
            params.setDefinitionClass( ClassEnumeration.VULNERABILITY );
            params.setId( "oval:org.mitre.oval:def:*" );
            String  cve_pattern = "CVE-" + year + "-*";
            params.setRefId( cve_pattern );

            QueryResults<DefinitionType>  query_results = _oval_repository.findDefinition( params );
            List<DefinitionType>  def_list = query_results.getElements();

            Map<String,DefinitionType>  yearly_cve_map = new TreeMap<String,DefinitionType>();
            _buildCveMapping( yearly_cve_map, def_list );
            _printCveMapping( outfile,
                            "\n[[[Mitre OVAL CVE Coverage (" + year + ") ]]]",
                            yearly_cve_map
                            );

            _buildCveMapping( cve_map, def_list );
        }

        _printCveMapping( outfile,
                        "\n[[[Mitre OVAL CVE Coverage (1999-2013) ]]]",
                        cve_map
                        );
    }


    /**
     */
    private void _buildCveMapping(
                    final Map<String,DefinitionType> cve_map,
                    final Collection<DefinitionType> def_list
                    )
    {
        for (DefinitionType  def : def_list) {
            String  cve = _getCveFrom( def );
            if (cve != null) {
                cve_map.put( cve, def );
            }
        }
    }



    private void _printCveMapping(
                    final PrintStream output,
                    final String header,
                    final Map<String,DefinitionType> map
                    )
    {
        _println( output, header );

        for (String  cve : map.keySet()) {
            DefinitionType  def = map.get( cve );

            StringBuilder  line = new StringBuilder();
            line.append( cve );
            line.append( "," ).append( def.getOvalId() );
            line.append( "," ).append( def.getOvalVersion() );

            _println( output, line.toString() );
        }
    }


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////



    @Test
    public void reportRedHatCveCoverage2012()
    throws Exception
    {
        System.out.println( "\n//////////////////////////////////////////////////////////" );
        System.out.println( "[[[Red Hat OVAL CVE Coverage]]]" );

        DefinitionQueryParams  params = new DefinitionQueryParams();
        params.setId( "oval:com.redhat.rhsa:def:*" );
        params.setDefinitionClass( ClassEnumeration.PATCH );
        params.setRefId( "CVE-2012-*" );
//        params.setRefSource( "CVE" );
        QueryResults<DefinitionType>  query_results = _oval_repository.findDefinition( params );
        List<DefinitionType>  def_list = query_results.getElements();
        Map<String,String>  mapping = _createOvalCveMapping( def_list );

//        for (String  cve : mapping.keySet()) {
//            System.out.println( cve + "," + mapping.get( cve )  );
//        }

        int  i = 1;
        int  limit = 6535;
        for (String  cve : mapping.keySet()) {
            if (!cve.startsWith( "CVE-2012-" )) {
                continue;
            }
            int  num = _getCveNumberAsInt( cve );
            if (i < num) {
                while (i < num) {
                    System.out.println( "CVE-2012-" + _toCveNumber( i ) + "," );
                    i++;
                }
            }

            System.out.println( cve + "," + mapping.get( cve )  );
            i++;
        }

        while (i <= limit) {
            System.out.println( "CVE-2012-" + _toCveNumber( i ) + "," );
            i++;
        }
    }




    /**
     */
    @Test
    public void reportMitreCveCoverage2012()
    throws Exception
    {
        System.out.println( "\n//////////////////////////////////////////////////////////" );
        System.out.println( "[[[Mitre OVAL CVE Coverage]]]" );

        DefinitionQueryParams  params = new DefinitionQueryParams();
        params.setId( "oval:org.mitre.oval:def:*" );
        params.setDefinitionClass( ClassEnumeration.VULNERABILITY );
        params.setRefId( "CVE-2012-*" );
//        params.setRefSource( "CVE" );
        QueryResults<DefinitionType>  query_results = _oval_repository.findDefinition( params );
        List<DefinitionType>  def_list = query_results.getElements();
        Map<String,String>  mapping = _createOvalCveMapping( def_list );


        int  i = 1;
        int  limit = 6535;
        for (String  cve : mapping.keySet()) {
            if (!cve.startsWith( "CVE-2012-" )) {
                continue;
            }
            int  num = _getCveNumberAsInt( cve );
            if (i < num) {
                while (i < num) {
                    System.out.println( "CVE-2012-" + _toCveNumber( i ) + "," );
                    i++;
                }
            }

            System.out.println( cve + "," + mapping.get( cve )  );
            i++;
        }

        while (i <= limit) {
            System.out.println( "CVE-2012-" + _toCveNumber( i ) + "," );
            i++;
        }
    }



    /**
     */
    private String _getCveFrom(
                    final DefinitionType def
                    )
    {
        String  cve = null;
        for (ReferenceType  ref : def.getMetadata().getReference()) {
            if ("CVE".equalsIgnoreCase( ref.getSource() )) {
                if (cve != null) {
                    cve = cve + " ";
                }
                cve = ref.getRefId();
            }
        }

        return cve;
    }


    private Map<String,String>_createOvalCveMapping(
                    final List<DefinitionType> def_list
                    )
    {
        Map<String,String>  map = new TreeMap<String,String>();

        for (DefinitionType  def : def_list) {
            String  cve = _getCveFrom( def );
            if (cve != null) {
                map.put( cve, def.getOvalId() );
            }
        }

        return map;
    }



    private int _getCveNumberAsInt(
                    final String cve
                    )
    {
        String  n = cve.substring( 9 );
        for (int  i = 0; i < 4; i++) {
            if (n.startsWith( "0" )) {
                n = n.substring( 1 );
            }
        }

        return Integer.valueOf( n );
    }



    private static final String[]  _ZERO_PADDING_ = new String[] {
        "0000", "000", "00", "0", ""
    };

    private String _toCveNumber(
                    final int i
                    )
    {
        String  num = String.valueOf( i );
        int  len = num.length();
        num = _ZERO_PADDING_[len] + num;

        return num;
    }



    private void _println(
                    final PrintStream output,
                    final String txt
                    )
    {
        if (System.out != output) {
            System.out.println( txt );
            System.out.flush();
        }

        output.println( txt );
        output.flush();
    }




}
//
