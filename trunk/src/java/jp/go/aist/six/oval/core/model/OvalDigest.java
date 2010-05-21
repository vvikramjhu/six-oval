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

package jp.go.aist.six.oval.core.model;

import jp.go.aist.six.oval.model.OvalElement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class OvalDigest
{

    /**
     * The default digest algorithm.
     */
    public static final String  DEFAULT_ALGORITHM = "MD5";


    public static final OvalDigest  DEFAULT_INSTANCE = new OvalDigest();


//    /**
//     */
//    public static <T extends OvalElement> String digest(
//                    final Collection<T> elements
//                    )
//    throws Exception
//    {
//        return DEFAULT_INSTANCE.compute( elements );
//    }


    private static final OvalElementComparator  _ELEMENT_COMPARATOR_ =
        new OvalElementComparator();



    /**
     * The default algorithm.
     */
    private String  _algorithm = DEFAULT_ALGORITHM;



    /**
     * Constructor.
     */
    public OvalDigest()
    {
        this( DEFAULT_ALGORITHM );
    }


    /**
     * Constructor.
     */
    public OvalDigest(
                    final String algorithm
                    )
    {
        _algorithm = algorithm;
    }



    /**
     */
    public <T extends OvalElement> String compute(
                    final Collection<T> elements
                    )
    throws NoSuchAlgorithmException
    {
        MessageDigest  digest = MessageDigest.getInstance( _algorithm );
                                              //@throws NoSuchAlgorithmException

        if (elements == null  ||  elements.size() == 0) {
            _update( digest, "" );
        } else {
            ArrayList<T>  list = new ArrayList<T>( elements );
            Collections.sort( list, _ELEMENT_COMPARATOR_ );

            for (OvalElement  element : list) {
                _update( digest, element );
            }
        }

        return _byteArrayToHexString( digest.digest() );
    }



    /**
     */
    protected void _update(
                    final MessageDigest digest,
                    final OvalElement element
                    )
    {
        _update( digest, element.getOvalID() );
//        _update( digest, element.getOvalVersion() );
    }



    /**
     */
    private void _update( final MessageDigest digest, final String s )
    {
        final String  ss = (s == null ? "" : s);
        digest.update( ss.getBytes() );
    }



//    /**
//     */
//    private void _update(
//                    final MessageDigest digest,
//                    final int num
//                    )
//    {
//        digest.update( String.valueOf( num ).getBytes() );
//    }



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



    /**
     */
    private static class OvalElementComparator
        implements Comparator<OvalElement>
    {

        public int compare(
                        final OvalElement e1,
                        final OvalElement e2
                        )
        {
            String  id1 = e1.getOvalID();
            String  id2 = e2.getOvalID();
            int  order = id1.compareTo( id2 );
            if (order != 0) {
                return order;
            }

            int  version1 = e1.getOvalVersion();
            int  version2 = e2.getOvalVersion();
            return (version1 - version2);
        }


        @Override
        public boolean equals(
                        final Object obj
                        )
        {
            return (obj instanceof OvalElementComparator);
        }

    }
    // OvalElementComparator

}
// OvalDigest
