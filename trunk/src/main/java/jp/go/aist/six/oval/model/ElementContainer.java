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

package jp.go.aist.six.oval.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import com.google.code.morphia.annotations.Transient;



/**
 * A container which can contain Element objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class ElementContainer<E extends Element>
    extends Container<E>
{

    /**
     * Constructor.
     */
    public ElementContainer()
    {
    }


//    public ElementContainer(
//                    final Collection<? extends E> elements
//                    )
//    {
//        super( elements );
//    }
//
//
//    public ElementContainer(
//                    final E[] elements
//                    )
//    {
//        super( elements );
//    }



    /**
     */
    public E findByOvalId(
                    final String oval_id
                    )
    {
        if (oval_id == null) {
            throw new IllegalArgumentException( "null OVAL ID" );
        }

        Iterator<E>  itr = iterator();
        while (itr.hasNext()) {
            E  e = itr.next();
            if (oval_id.equals( e.getOvalId() )) {
                return e;
            }
        }

        return null;
    }



    /**
     */
    public boolean containsOvalId(
                    final String oval_id
                    )
    {
        return (findByOvalId( oval_id ) != null);
    }



    /**
     */
    public Set<String> ovalIdSet()
    {
        Set<String>  oval_id_list = new HashSet<String>();

        Iterator<E>  itr = iterator();
        while (itr.hasNext()) {
            E  e = itr.next();
            oval_id_list.add( e.getOvalId() );
        }

        return oval_id_list;
    }



    ///////////////////////////////////////////////////////////////////////
    //  digest computation
    ///////////////////////////////////////////////////////////////////////

    /**
     * The default digest algorithm.
     */
    public static final String  DIGEST_ALGORITHM = "MD5";

    @Transient
    private String  _digest;

    @Transient
    private transient int  _hashOnDigest = 0;



    /**
     */
    public void setDigest(
                    final String digest
                    )
    {
        _digest = digest;
    }


    public String getDigest()
    {
        int  thisHash = hashCode();
        if (_digest == null  ||  thisHash != _hashOnDigest) {
            Element[]  elements = toArray( new Element[0] );
            _digest = _computeDigest3( elements );
            _hashOnDigest = thisHash;
        }

        return _digest;
    }



    protected static String _computeDigest3(
                    final Element[] element_list
                    )
    {
        MessageDigest  digest = null;
        try {
            digest = MessageDigest.getInstance( DIGEST_ALGORITHM );
                                              //@throws NoSuchAlgorithmException
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }

        if (element_list == null  ||  element_list.length == 0) {
            _updateDigest( digest, "" );
        } else {
            SortedSet<String>  values = _digestValuesOf( element_list );
            for (String  v : values) {
                _updateDigest( digest, v );
            }
        }

        return _byteArrayToHexString( digest.digest() );
    }



    private static SortedSet<String> _digestValuesOf(
                    final Element[] element_list
                    )
    {
        SortedSet<String>  values = new TreeSet<String>();
        for (Element  e : element_list) {
            values.add( Element.globalRefOf( e ) );
        }

        return values;
    }




    ///////////////////////////////////////////////////////////////////////

    /**
     */
    private static void _updateDigest(
                    final MessageDigest digest,
                    final String s
                    )
    {
        final String  ss = (s == null ? "" : s);
        digest.update( ss.getBytes() );
    }



    /**
     */
    private static final String[]  _HEX_DIGITS_ = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
    };


    /**
     */
    private static String _byteToHexString(
                    final byte b
                    )
    {
        int  n = b;
        if (n < 0) {
            n += 256;
        }

        int  d1 = n / 16;
        int  d2 = n % 16;

        return _HEX_DIGITS_[d1] + _HEX_DIGITS_[d2];
    }



    /**
     */
    private static String _byteArrayToHexString(
                    final byte[] bytes
                    )
    {
        StringBuilder  s = new StringBuilder();
        final int  length = bytes.length;
        for (int  i = 0; i < length; i++) {
            s.append( _byteToHexString( bytes[i] ) );
        }

        return s.toString();
    }

}
//ElementContainer
