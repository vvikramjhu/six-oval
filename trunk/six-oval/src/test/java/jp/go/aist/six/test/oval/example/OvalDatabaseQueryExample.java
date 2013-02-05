package jp.go.aist.six.test.oval.example;

import java.util.List;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.OvalDatabase;



public class OvalDatabaseQueryExample
{

    public static void main( final String[] args )
    throws Exception
    {
        // keyword in the title or description
        DefinitionQueryParams  params04 = new DefinitionQueryParams();
        params04.setSearchTerms( "XSS" );

        // Definition IDs
        DefinitionQueryParams  params13 = new DefinitionQueryParams();
        params13.setId( "oval:org.mitre.oval.test:def:889,oval:org.mitre.oval.test:def:121,oval:org.mitre.oval.test:def:140" );

        // definition class
        DefinitionQueryParams  params20 = new DefinitionQueryParams();
        params20.setDefinitionClass( "compliance" );

        // affected platforms
        DefinitionQueryParams  params32 = new DefinitionQueryParams();
        params32.setPlatform( "Microsoft Windows XP*,Microsoft Windows 7*" );

        // CVE IDs
        DefinitionQueryParams  params62 = new DefinitionQueryParams();
        params62.setCve( "CVE-2011-*,CVE-2010-0176" );

        DefinitionQueryParams[]  params_list = new DefinitionQueryParams[] {
                        params04, params13, params20, params32, params62
        };

        // Execute Queries
        OvalDatabase  db = OvalContext.getServerInstance().getDatabase();
        for (DefinitionQueryParams  params : params_list) {
            System.out.println( "searches Definitions: query params=" + params );
            List<DefinitionType>  p_def_list = db.find( DefinitionType.class, params );
            System.out.println( "#Definitions found: " + p_def_list.size() );
            for (DefinitionType  p_def : p_def_list) {
                System.out.println( "result Definition: " + p_def );
            }
        }
    }

}
//
