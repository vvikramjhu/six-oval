package jp.go.aist.six.test.oval.core.ws;

import java.util.Date;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.repository.QueryResult;
import jp.go.aist.six.oval.repository.QueryResultElements;
import jp.go.aist.six.oval.repository.QueryResultMetadata;
import jp.go.aist.six.test.oval.core.DefinitionsSample;
import jp.go.aist.six.util.xml.XmlMapper;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



public class OvalQueryResultTest
{

    private XmlMapper  _xmlmapper = null;



    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        OvalContext  _context = new OvalContext();
        _xmlmapper = _context.getXml();
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.ws.query" },
                    alwaysRun=true
                    )
    public void testLinks()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        QueryResult<DefinitionType>  result = new QueryResult<DefinitionType>();
        result.setTimestamp( new Date() );

//        String  rel = "http://six.org/rels/oval_results";
//        String  baseUri = "http://six.org/oval/oval_results/";
//        AtomLink[]  links = new AtomLink[] {
//                        _buildLink( rel, baseUri + "01234" ),
//                        _buildLink( rel, baseUri + "12345" ),
//                        _buildLink( rel, baseUri + "23456" )
//        };
//        feed.setLink( Arrays.asList( links ) );

        Reporter.log( "object: " + result, true );

        Reporter.log( ">>> marshalling...", true );
        String  xml = _xmlmapper.marshalToString( result );
        Reporter.log( "<<< marshalling done.", true );
        Reporter.log( "XML: \n" + xml, true );

        Reporter.log( ">>> unmarshalling...", true );
        @SuppressWarnings( "unchecked" )
        QueryResult<DefinitionType>  result2 = (QueryResult<DefinitionType>)_xmlmapper.unmarshalFromString( xml );
        Reporter.log( "<<< unmarshalling done.", true );
        Reporter.log( "object: " + result2, true );

        QueryResultElements<DefinitionType>  elements = new QueryResultElements<DefinitionType>();
        elements.addElement( DefinitionsSample.DEF_7222 );
        result.setElements( elements );
        Reporter.log( "\nobject: " + result, true );
        Reporter.log( ">>> marshalling...", true );
        xml = _xmlmapper.marshalToString( result );
        Reporter.log( "<<< marshalling done.", true );
        Reporter.log( "XML: \n" + xml, true );

        Reporter.log( ">>> unmarshalling...", true );
        @SuppressWarnings( "unchecked" )
        QueryResult<DefinitionType>  result3 = (QueryResult<DefinitionType>)_xmlmapper.unmarshalFromString( xml );
        Reporter.log( "<<< unmarshalling done.", true );
        Reporter.log( "object: " + result3, true );


        QueryResultMetadata  os = new QueryResultMetadata();
        os.setTotalResults( 222 );
        os.setStartIndex( 55 );
        os.setItemsPerPage( 1 );
        result.setMetadata( os );

        Reporter.log( "\nobject: " + result, true );
        Reporter.log( ">>> marshalling...", true );
        xml = _xmlmapper.marshalToString( result );
        Reporter.log( "<<< marshalling done.", true );
        Reporter.log( "XML: \n" + xml, true );

        Reporter.log( ">>> unmarshalling...", true );
        @SuppressWarnings( "unchecked" )
        QueryResult<DefinitionType>  result4 = (QueryResult<DefinitionType>)_xmlmapper.unmarshalFromString( xml );
        Reporter.log( "<<< unmarshalling done.", true );
        Reporter.log( "object: " + result4, true );

//        //TODO: throws SAXException!!!
//        feed.addExtensionElement( DefinitionsSample.DEF_7222 );
//        Reporter.log( "\nAtom feed object: " + feed, true );
//        Reporter.log( ">>> marshalling...", true );
//        xml = _xmlmapper.marshalToString( feed );
//        Reporter.log( "<<< marshalling done.", true );
//        Reporter.log( "Atom feed XML: \n" + xml, true );
//
//        Reporter.log( ">>> unmarshalling...", true );
//        feed2 = (AtomFeed)_xmlmapper.unmarshalFromString( xml );
//        Reporter.log( "<<< unmarshalling done.", true );
//        Reporter.log( "Atom feed object: " + feed2, true );
    }


//    private AtomLink _buildLink(
//                    final String rel,
//                    final String href
//                    )
//    {
//        AtomLink  link = new AtomLink();
//        link.setRel( rel );
//        link.setHref( href );
//
//        return link;
//    }

}
// AtomFeedTest
