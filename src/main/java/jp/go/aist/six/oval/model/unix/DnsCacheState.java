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

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateIPAddressStringType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The dnscache_state contains three entities that are used to check the domain name,
 * time to live, and IP addresses associated with the DNS cache entry.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DnsCacheState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           domain_name;
    private EntityStateIntType              ttl;
    private EntityStateIPAddressStringType  ip_address;



    /**
     * Constructor.
     */
    public DnsCacheState()
    {
        this( null, 0 );
    }


    public DnsCacheState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public DnsCacheState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_family = Family.UNIX;
        _oval_component = ComponentType.DNSCACHE;
    }



    /**
     */
    public void setDomainName(
                    final EntityStateStringType domain_name
                    )
    {
        this.domain_name = domain_name;
    }


    public EntityStateStringType getDomainName()
    {
        return domain_name;
    }



    /**
     */
    public void setTTL(
                    final EntityStateIntType ttl
                    )
    {
        this.ttl = ttl;
    }


    public EntityStateIntType getTTL()
    {
        return ttl;
    }



    /**
     */
    public void setIPAddress(
                    final EntityStateIPAddressStringType ip_address
                    )
    {
        this.ip_address = ip_address;
    }


    public EntityStateIPAddressStringType getIPAddress()
    {
        return ip_address;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getDomainName() );
        ref_list.add( getTTL() );
        ref_list.add( getIPAddress() );

        return ref_list;
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
        if (!(obj instanceof DnsCacheState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "dnscache_state[" + super.toString()
                        + ", domain_name="  + getDomainName()
                        + ", ttl="          + getTTL()
                        + ", ip_address="   + getIPAddress()
             + "]";
    }

}
//
