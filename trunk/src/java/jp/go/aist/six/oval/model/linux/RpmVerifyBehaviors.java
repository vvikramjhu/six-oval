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

import jp.go.aist.six.oval.model.AbstractOvalObject;
import java.util.EnumMap;
import java.util.Map;



/**
 * The RpmVerifyBehaviors defines a set of behaviors
 * that for controlling how installed rpms are verified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmVerifyBehaviors
    extends AbstractOvalObject
{
    protected static enum Property
    {
        NO_DEPS,
        NO_DIGEST,
        NO_FILES,
        NO_SCRIPTS,
        NO_SIGNATURE,
        NO_LINK_TO,
        NO_MD5,
        NO_SIZE,
        NO_USER,
        NO_GROUP,
        NO_MTIME,
        NO_MODE,
        NO_RDEV,
        NO_CONFIG_FILES,
        NO_GHOST_FILES;
    }

    private Map<Property, Boolean>  _properties =
        new EnumMap<Property, Boolean>( Property.class );


    public static final boolean  DEFAULT_BEHAVIOR = false;



    /**
     * Constructor.
     */
    public RpmVerifyBehaviors()
    {
    }



    /**
     */
    public void setNoDpes(
                    final boolean nodeps
                    )
    {
        _properties.put( Property.NO_DEPS, Boolean.valueOf( nodeps ) );
    }


    public boolean getNoDeps()
    {
        Boolean  nodeps = _properties.get( Property.NO_DEPS );
        return (nodeps == null ? DEFAULT_BEHAVIOR : nodeps.booleanValue());
    }



    /**
     */
    public void setNoDigest(
                    final boolean nodigest
                    )
    {
        _properties.put( Property.NO_DIGEST, Boolean.valueOf( nodigest ) );
    }


    public boolean getNoDigest()
    {
        Boolean  nodigest = _properties.get( Property.NO_DIGEST );
        return (nodigest == null ? DEFAULT_BEHAVIOR : nodigest.booleanValue());
    }



    /**
     */
    public void setNoFiles(
                    final boolean nofiles
                    )
    {
        _properties.put( Property.NO_FILES, Boolean.valueOf( nofiles ) );
    }


    public boolean getNoFiles()
    {
        Boolean  nofiles = _properties.get( Property.NO_FILES );
        return (nofiles == null ? DEFAULT_BEHAVIOR : nofiles.booleanValue());
    }



    /**
     */
    public void setNoScripts(
                    final boolean noscripts
                    )
    {
        _properties.put( Property.NO_SCRIPTS, Boolean.valueOf( noscripts ) );
    }


    public boolean getNoScripts()
    {
        Boolean  noscripts = _properties.get( Property.NO_SCRIPTS );
        return (noscripts == null ? DEFAULT_BEHAVIOR : noscripts.booleanValue());
    }



    /**
     */
    public void setNoSignature(
                    final boolean nosignature
                    )
    {
        _properties.put( Property.NO_SIGNATURE, Boolean.valueOf( nosignature ) );
    }


    public boolean getNoSignature()
    {
        Boolean  nosignature = _properties.get( Property.NO_SIGNATURE );
        return (nosignature == null ? DEFAULT_BEHAVIOR : nosignature.booleanValue());
    }



    /**
     */
    public void setNoLinkTo(
                    final boolean nolinkto
                    )
    {
        _properties.put( Property.NO_LINK_TO, Boolean.valueOf( nolinkto ) );
    }


    public boolean getNoLinkTo()
    {
        Boolean  nolinkto = _properties.get( Property.NO_LINK_TO );
        return (nolinkto == null ? DEFAULT_BEHAVIOR : nolinkto.booleanValue());
    }



    /**
     */
    public void setNoMd5(
                    final boolean nomd5
                    )
    {
        _properties.put( Property.NO_MD5, Boolean.valueOf( nomd5 ) );
    }


    public boolean getNoMd5()
    {
        Boolean  nomd5 = _properties.get( Property.NO_MD5 );
        return (nomd5 == null ? DEFAULT_BEHAVIOR : nomd5.booleanValue());
    }



    /**
     */
    public void setNoSize(
                    final boolean nosize
                    )
    {
        _properties.put( Property.NO_SIZE, Boolean.valueOf( nosize ) );
    }


    public boolean getNoSize()
    {
        Boolean  nosize = _properties.get( Property.NO_SIZE );
        return (nosize == null ? DEFAULT_BEHAVIOR : nosize.booleanValue());
    }



    /**
     */
    public void setNoUser(
                    final boolean nouser
                    )
    {
        _properties.put( Property.NO_USER, Boolean.valueOf( nouser ) );
    }


    public boolean getNoUser()
    {
        Boolean  nouser = _properties.get( Property.NO_USER );
        return (nouser == null ? DEFAULT_BEHAVIOR : nouser.booleanValue());
    }



    /**
     */
    public void setNoGroup(
                    final boolean nogroup
                    )
    {
        _properties.put( Property.NO_GROUP, Boolean.valueOf( nogroup ) );
    }


    public boolean getNoGroup()
    {
        Boolean  nogroup = _properties.get( Property.NO_GROUP );
        return (nogroup == null ? DEFAULT_BEHAVIOR : nogroup.booleanValue());
    }



    /**
     */
    public void setNoMtime(
                    final boolean nomtime
                    )
    {
        _properties.put( Property.NO_MTIME, Boolean.valueOf( nomtime ) );
    }


    public boolean getNoMtime()
    {
        Boolean  nomtime = _properties.get( Property.NO_MTIME );
        return (nomtime == null ? DEFAULT_BEHAVIOR : nomtime.booleanValue());
    }



    /**
     */
    public void setNoMode(
                    final boolean nomode
                    )
    {
        _properties.put( Property.NO_MODE, Boolean.valueOf( nomode ) );
    }


    public boolean getNoMode()
    {
        Boolean  nomode = _properties.get( Property.NO_MODE );
        return (nomode == null ? DEFAULT_BEHAVIOR : nomode.booleanValue());
    }



    /**
     */
    public void setNoRdev(
                    final boolean nordev
                    )
    {
        _properties.put( Property.NO_RDEV, Boolean.valueOf( nordev ) );
    }


    public boolean getNoRdev()
    {
        Boolean  nordev = _properties.get( Property.NO_RDEV );
        return (nordev == null ? DEFAULT_BEHAVIOR : nordev.booleanValue());
    }



    /**
     */
    public void setNoConfigFiles(
                    final boolean noconfigfiles
                    )
    {
        _properties.put( Property.NO_CONFIG_FILES, Boolean.valueOf( noconfigfiles ) );
    }


    public boolean getNoConfigFiles()
    {
        Boolean  noconfigfiles = _properties.get( Property.NO_CONFIG_FILES );
        return (noconfigfiles == null ? DEFAULT_BEHAVIOR : noconfigfiles.booleanValue());
    }



    /**
     */
    public void setNoGhostFiles(
                    final boolean noghostfiles
                    )
    {
        _properties.put( Property.NO_GHOST_FILES, Boolean.valueOf( noghostfiles ) );
    }


    public boolean getNoGhostFiles()
    {
        Boolean  noghostfiles = _properties.get( Property.NO_GHOST_FILES );
        return (noghostfiles == null ? DEFAULT_BEHAVIOR : noghostfiles.booleanValue());
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return _properties.toString();
    }


}
// RpmVerifyBehaviors
