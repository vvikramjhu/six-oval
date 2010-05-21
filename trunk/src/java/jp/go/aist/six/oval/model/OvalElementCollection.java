/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: States.java 421 2010-03-18 10:17:37Z akihito $
 */
public class OvalElementCollection<E extends OvalElement>
{


    //TODO: Find more fast implementation.
//    private Map<String,E>  _elements = new TreeMap<String,E>();

    private Collection<E>  _elements = new ArrayList<E>();
    //DefinitionsType{1..*}
    //TestsType{1..*}
    //ObjectsType{1..*}
    //StatesType{1..*}



    /**
     * Constructor.
     */
    public OvalElementCollection()
    {
    }



    /**
     */
    public void setElements(
                    final Collection<E> elements
                    )
    {
        _elements.clear();
        if (elements == null  ||  elements.size() == 0) {
            return;
        }

        for (E e : elements) {
            addElement( e );
        }
    }


    /**
     */
    public void addElement(
                    final E element
                    )
    {
        if (element == null) {
            return;
        }

        final String  id = element.getOvalID();
        if (id == null) {
            throw new IllegalArgumentException(
                            "null OVAL ID element: " + element );
        }

        _elements.add( element );
    }


    /**
     */
    public Collection<E> getElements()
    {
        return _elements;
    }


    /**
     */
    public E findElement(
                    final String id
                    )
    {
        if (id == null) {
            throw new IllegalArgumentException(
                            "null OVAL ID" );
        }

        for (E  element : getElements()) {
            if (id.equals( element.getOvalID() )) {
                return element;
            }
        }
        return null;
    }



    /**
     */
    public int size()
    {
        return _elements.size();
    }



    //==============================================================
    //  digest
    //==============================================================

    /**
     * The default digest algorithm.
     */
    public static final String  DIGEST_ALGORITHM = "MD5";


    private static final OvalElementComparator  _ELEMENT_COMPARATOR_ =
        new OvalElementComparator();


    private String  _digest;

    private int  _hashOnDigest = 0;



    /**
     */
    public String getDigest()
    {
        final int  currentHash = hashCode();
        if (currentHash != _hashOnDigest) {
            _digest = _computeDigest( getElements() );
            _hashOnDigest = currentHash;
        }

        return _digest;
    }


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
            Collections.sort( list, _ELEMENT_COMPARATOR_ );

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
// OvalEntityCollection
