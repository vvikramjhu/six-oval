/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jp.go.aist.six.oval.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;



/**
 * A set of OvalElement instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class OvalElementContainer<E extends OvalElement>
    extends Container<E>
{

    /**
     * Constructor.
     */
    public OvalElementContainer()
    {
    }


    /**
     * Constructor.
     */
    public OvalElementContainer(
                    final Collection<? extends E> elements
                    )
    {
        super( elements );
    }


    /**
     * Constructor.
     */
    public OvalElementContainer(
                    final E[] elements
                    )
    {
        super( elements );
    }


    public E find(
                    final String id
                    )
    {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        for (E  e : _getElement()) {
            if (id.equals( e.getOvalID() )) {
                return e;
            }
        }

        return null;
    }



    /**
     */
    private Set<String> _keySet()
    {
        Set<String>  set = new HashSet<String>();
        for (OvalElement  e : _getElement()) {
            set.add( e.getOvalID() );
        }

        return set;
    }



//    //**************************************************************
//    //  Container
//    //**************************************************************
//
//    protected String _getKey(
//                    final OvalElement element
//                    )
//    {
//        return element.getOvalID();
//    }



    //==============================================================
    //  digest computation
    //==============================================================

    /**
     * The default digest algorithm.
     */
    public static final String  DIGEST_ALGORITHM = "MD5";


//    private static final OvalElementComparator  _ELEMENT_COMPARATOR_ =
//        new OvalElementComparator();


    private String  _digest;

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
            Set<String>  keys = _keySet();
            int  keysHash = keys.hashCode();
            MessageDigest  digest = null;
            try {
                digest = MessageDigest.getInstance( DIGEST_ALGORITHM );
                                                  //@throws NoSuchAlgorithmException
            } catch (NoSuchAlgorithmException ex) {
                return null;
            }

            _update( digest, String.valueOf( keysHash ) );

            _digest = _byteArrayToHexString( digest.digest() );
            _hashOnDigest = thisHash;
        }

        return _digest;
    }
    // keyedContainer implementation
//    {
//        Set<String>  keys = _keySet();
//        final int  currentHash = (keys == null ? 0 : keys.hashCode());
//        if (currentHash != _hashOnDigest) {
//            MessageDigest  digest = null;
//            try {
//                digest = MessageDigest.getInstance( DIGEST_ALGORITHM );
//                                                  //@throws NoSuchAlgorithmException
//            } catch (NoSuchAlgorithmException ex) {
//                return null;
//            }
//
//            String  currentHashString = (currentHash == 0 ? "" : String.valueOf( currentHash ));
//            _update( digest, currentHashString );
//
//            _digest = _byteArrayToHexString( digest.digest() );
//            _hashOnDigest = currentHash;
//        }
//
//        return _digest;
//    }


    /**
     */
    protected String _computeDigest(
                    final Collection<E> elements
                    )
    {
        MessageDigest  digest = null;
        try {
            digest = MessageDigest.getInstance( DIGEST_ALGORITHM );
                                              //@throws NoSuchAlgorithmException
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }

        if (elements == null  ||  elements.size() == 0) {
            _update( digest, "" );
        } else {
            ArrayList<E>  list = new ArrayList<E>( elements );
            Collections.sort( list );
//            Collections.sort( list, _ELEMENT_COMPARATOR_ );

            for (OvalElement  element : list) {
                _update( digest, element );
            }
        }

        return _byteArrayToHexString( digest.digest() );
    }



    /**
     */
    private void _update(
                    final MessageDigest digest,
                    final OvalElement element
                    )
    {
        _update( digest, element.getOvalID() );
//        _update( digest, element.getOvalVersion() );
    }



    /**
     */
    private static void _update(
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
// OvalElementContainer
