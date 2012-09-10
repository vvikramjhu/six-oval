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

package jp.go.aist.six.oval.model.unix;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemIPAddressStringType;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The dnscache_item stores information retrieved from the DNS cache about a domain name,
 * its time to live, and its corresponding IP addresses.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DnsCacheItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType            domain_name;
    private EntityItemIntType               ttl;
    private EntityItemIPAddressStringType   ip_address;



    /**
     * Constructor.
     */
    public DnsCacheItem()
    {
        this( 0 );
    }


    public DnsCacheItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public DnsCacheItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

        _oval_family = Family.UNIX;
        _oval_component = ComponentType.DNSCACHE;
    }



    /**
     */
    public void setDomainName(
                    final EntityItemStringType domain_name
                    )
    {
        this.domain_name = domain_name;
    }


    public EntityItemStringType getDomainName()
    {
        return domain_name;
    }



    /**
     */
    public void setTTL(
                    final EntityItemIntType ttl
                    )
    {
        this.ttl = ttl;
    }


    public EntityItemIntType getTTL()
    {
        return ttl;
    }



    /**
     */
    public void setIPAddress(
                    final EntityItemIPAddressStringType ip_address
                    )
    {
        this.ip_address = ip_address;
    }


    public EntityItemIPAddressStringType getIPAddress()
    {
        return ip_address;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof DnsCacheItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "dnscache_item[" + super.toString()
                        + ", domain_name="  + getDomainName()
                        + ", ttl="          + getTTL()
                        + ", ip_address="   + getIPAddress()
             + "]";
    }

}
//
