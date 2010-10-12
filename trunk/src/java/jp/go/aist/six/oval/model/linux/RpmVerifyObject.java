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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityTypeHelper;
import jp.go.aist.six.oval.model.definitions.SystemObject;



/**
 * The RpmVerifyObject is used by a rpmverity test to define
 * a set of files within a set of RPMs to verify.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmVerifyObject
    extends SystemObject
{

    private RpmVerifyBehaviors  _behaviors;
    //{0..1}


    private EntityObjectString  _name;
    //{1..1}


    private EntityObjectString  _filepath;
    //{1..1}


//    private Filter  _filter;
    //{0..*}



    /**
     * Constructor.
     */
    public RpmVerifyObject()
    {
    }


    /**
     * Constructor.
     */
    public RpmVerifyObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public RpmVerifyObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     */
    public void setBehaviors(
                    final RpmVerifyBehaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }


    public RpmVerifyBehaviors getBehaviors()
    {
        return _behaviors;
    }



    /**
     */
    public void setName(
                    final EntityObjectString name
                    )
    {
        _name = name;
    }


    public EntityObjectString getName()
    {
        return _name;
    }



    /**
     */
    public void setFilepath(
                    final EntityObjectString filepath
                    )
    {
        _filepath = filepath;
    }


    public EntityObjectString getFilepath()
    {
        return _filepath;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.LINUX_RPMVERIFY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int prime = 37;
        int result = super.hashCode();

        RpmVerifyBehaviors  behaviors = getBehaviors();
        result = prime * result + ((behaviors == null) ? 0 : behaviors.hashCode());

        EntityObjectString  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        EntityObjectString  filepath = getFilepath();
        result = prime * result + ((filepath == null) ? 0 : filepath.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof RpmVerifyObject)) {
            return false;
        }

        if (super.equals( obj )) {
            RpmVerifyObject  other = (RpmVerifyObject)obj;
            EntityObjectString  otherName = other.getName();
            EntityObjectString   thisName =  this.getName();
            if (EntityTypeHelper.equals( thisName, otherName )) {
                EntityObjectString  otherFilepath = other.getFilepath();
                EntityObjectString   thisFilepath =  this.getFilepath();
                if (EntityTypeHelper.equals( thisFilepath, otherFilepath )) {
                    RpmVerifyBehaviors  otherBehaviors = other.getBehaviors();
                    RpmVerifyBehaviors   thisBehaviors =  this.getBehaviors();
                    if (thisBehaviors == otherBehaviors
                                    ||  (thisBehaviors != null  &&  thisBehaviors.equals( otherBehaviors ))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "rpmverify_object[" + super.toString() + "]";
    }

}
// RpmVerifyObject
