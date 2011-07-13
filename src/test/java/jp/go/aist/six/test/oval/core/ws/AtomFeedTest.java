package jp.go.aist.six.test.oval.core.ws;

import java.util.Arrays;
import java.util.Date;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.ws.AtomFeed;
import jp.go.aist.six.oval.core.ws.AtomLink;
import jp.go.aist.six.util.xml.XmlMapper;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



public class AtomFeedTest
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
                    groups={ "oval.core.ws.atom" },
                    alwaysRun=true
                    )
    public void testLinks()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );


        AtomFeed  feed = new AtomFeed();
        feed.setId( "urn:guid:550e8400-e29b-41d4-a716-446655440000" );
        feed.setTitle( "oval_results" );
        feed.setUpdated( new Date() );

        String  rel = "http://six.org/rels/oval_results";
        String  baseUri = "http://six.org/oval/oval_results/";
        AtomLink[]  links = new AtomLink[] {
                        _buildLink( rel, baseUri + "01234" ),
                        _buildLink( rel, baseUri + "12345" ),
                        _buildLink( rel, baseUri + "23456" )
        };
        feed.setLink( Arrays.asList( links ) );

        Reporter.log( "Atom feed object: " + feed, true );

        Reporter.log( ">>> marshalling...", true );
        String  xml = _xmlmapper.marshalToString( feed );
        Reporter.log( "<<< marshalling done.", true );
        Reporter.log( "Atom feed XML: \n" + xml, true );

        Reporter.log( ">>> unmarshalling...", true );
        AtomFeed  feed2 = (AtomFeed)_xmlmapper.unmarshalFromString( xml );
        Reporter.log( "<<< unmarshalling done.", true );
        Reporter.log( "Atom feed object: " + feed2, true );

        //TODO: throws SAXException!!!
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


    private AtomLink _buildLink(
                    final String rel,
                    final String href
                    )
    {
        AtomLink  link = new AtomLink();
        link.setRel( rel );
        link.setHref( href );

        return link;
    }

}
// AtomFeedTest
