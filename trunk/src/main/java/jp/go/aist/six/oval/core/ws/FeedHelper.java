/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

package jp.go.aist.six.oval.core.ws;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import jp.go.aist.six.oval.OvalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriTemplate;
import com.google.code.morphia.Key;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.atom.Link;



/**
 * A helper class for feeds.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FeedHelper
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( FeedHelper.class );



    private static final String  ATOM_FEED_TYPE = "atom_1.0";



    /**
     * Creates a skeleton Atom feed.
     */
    private static Feed _createAtomFeedSkeleton(
                    final String title
                    )
    {
        Feed  feed = new Feed( ATOM_FEED_TYPE );
        feed.setId( "urn:guid:" + UUID.randomUUID().toString() );
        feed.setTitle( title );
        feed.setUpdated( new Date() );

        return feed;
    }



    /**
     */
    public static <T> Feed buildAtomFeed(
                    final String title,
                    final String baseUri,
                    final String rel,
                    final List<Key<T>> ids
                    )
    throws OvalException
    {
        Feed  feed = _createAtomFeedSkeleton( title );

        if (ids != null  &&  ids.size() > 0) {
            List<Link>  links = new ArrayList<Link>();
          for (Key<T>  id : ids) {
                _LOG_.debug( "link: id=" + id );

                Link  link = buildLink( baseUri, rel, id.getId());

//                URI  uri = new UriTemplate( "{baseUri}/{id}" ).expand( baseUri, id.getId() );
//                Link  link = new Link();
//                link.setRel( rel );
//                link.setHref( uri.toASCIIString() );

                _LOG_.debug( "atom:link: " + link );
                links.add( link );
            }

            feed.setOtherLinks( links );
        };

        return feed;
    }



    /**
     */
    public static Feed buildAtomFeed(
                    final String title,
                    final String baseUri,
                    final String rel,
                    final Collection<?> ids
                    )
    throws OvalException
    {
        Feed  feed = _createAtomFeedSkeleton( title );

        if (ids != null  &&  ids.size() > 0) {
            List<Link>  links = new ArrayList<Link>();
          for (Object  id : ids) {
                _LOG_.debug( "link: id=" + id );

                Link  link = buildLink( baseUri, rel, id );

//                URI  uri = new UriTemplate( "{baseUri}/{id}" ).expand( baseUri, id.getId() );
//                Link  link = new Link();
//                link.setRel( rel );
//                link.setHref( uri.toASCIIString() );

                _LOG_.debug( "atom:link: " + link );
                links.add( link );
            }

            feed.setOtherLinks( links );
        };

        return feed;
    }



    /**
     */
    public static Link buildLink(
                    final String baseUri,
                    final String rel,
                    final Object id
                    )
    throws OvalException
    {
        if (id == null) {
            throw new OvalException( new IllegalArgumentException( "null id for Atom Link") );
        }

        URI  uri = new UriTemplate( "{baseUri}/{id}" ).expand( baseUri, id );
        Link  link = new Link();
        link.setRel( rel );
        link.setHref( uri.toASCIIString() );
        link.setTitle( String.valueOf( id ) );
        _LOG_.debug( "atom:link: " + link );

        return link;
    }

}
// FeedHelper

