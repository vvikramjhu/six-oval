package jp.go.aist.six.test.oval.core.web;

import java.util.Arrays;
import java.util.Date;
import org.testng.Reporter;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.atom.Link;
import com.sun.syndication.io.WireFeedOutput;



public class AtomTest
{

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


        Feed  feed = new Feed( "atom_1.0" );
        feed.setId( "urn:guid:550e8400-e29b-41d4-a716-446655440000" );
        feed.setTitle( "oval_results" );
        feed.setUpdated( new Date() );

        String  rel = "http://six.org/rels/oval_results";
        String  baseUri = "http://six.org/oval/oval_results/";
        Link[]  links = new Link[] {
                        _buildLink( rel, baseUri + "01234" ),
                        _buildLink( rel, baseUri + "12345" ),
                        _buildLink( rel, baseUri + "23456" )
        };
        feed.setOtherLinks( Arrays.asList( links ) );

        Reporter.log( "Atom feed: " + feed, true );

        WireFeedOutput  output = new WireFeedOutput();
        String  xml = output.outputString( feed, true );
        Reporter.log( "Atom feed: \n" + xml, true );
    }


    private Link _buildLink(
                    final String rel,
                    final String href
                    )
    {
        Link  link = new Link();
        link.setRel( rel );
        link.setHref( href );

        return link;
    }

}
// AtomTest
