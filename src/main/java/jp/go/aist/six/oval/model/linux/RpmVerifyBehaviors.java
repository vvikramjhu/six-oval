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

import jp.go.aist.six.oval.model.OvalObject;



/**
 * The RpmVerifyBehaviors defines a set of behaviors 
 * that for controlling how installed rpms are verified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.10:
 *             Replaced by the RpmVerifyFileBehaviors and the RpmVerifyPackageBehaviors
 *             and will be removed in version 6.0 of the language.
 */
public class RpmVerifyBehaviors
    implements OvalObject
{

    public static final Boolean  DEFAULT_NODEPS         = Boolean.FALSE;
    public static final Boolean  DEFAULT_NODIGEST       = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOFILES        = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOSCRIPTS      = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOSIGNATURE    = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOLINKTO       = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOMD5          = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOSIZE         = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOUSER         = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOGROUP        = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOMTIME        = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOMODE         = Boolean.FALSE;
    public static final Boolean  DEFAULT_NORDEV         = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOCONFIGFILES  = Boolean.FALSE;
    public static final Boolean  DEFAULT_NOGHOSTFILES   = Boolean.FALSE;

    //{optional, default='false'}
    private Boolean  nodeps;
    private Boolean  nodigest;
    private Boolean  nofiles;
    private Boolean  noscripts;
    private Boolean  nosignature;
    private Boolean  nolinkto;
    private Boolean  nomd5;
    private Boolean  nosize;
    private Boolean  nouser;
    private Boolean  nogroup;
    private Boolean  nomtime;
    private Boolean  nomode;
    private Boolean  nordev;
    private Boolean  noconfigfiles;
    private Boolean  noghostfiles;




    /**
     * Constructor.
     */
    public RpmVerifyBehaviors()
    {
    }



    /**
     */
    public void setNodeps(
                    final Boolean nodeps
                    )
    {
        this.nodeps = nodeps;
    }


    public Boolean getNodeps()
    {
        return this.nodeps;
    }


    public static boolean nodeps( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nodeps = behaviors.getNodeps();
        
        return (nodeps == null ? DEFAULT_NODEPS.booleanValue() : nodeps.booleanValue());
    }



    /**
     */
    public void setNodigest(
                    final Boolean nodigest
                    )
    {
        this.nodigest = nodigest;
    }


    public Boolean getNodigest()
    {
        return this.nodigest;
    }


    public static boolean nodigest( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nodigest = behaviors.getNodigest();
        
        return (nodigest == null ? DEFAULT_NODIGEST.booleanValue() : nodigest.booleanValue());
    }



    /**
     */
    public void setNofiles(
                    final Boolean nofiles
                    )
    {
        this.nofiles = nofiles;
    }


    public Boolean getNofiles()
    {
        return this.nofiles;
    }


    public static boolean nofiles( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nofiles = behaviors.getNofiles();

        return (nofiles == null ? DEFAULT_NOFILES.booleanValue() : nofiles.booleanValue());
    }



    /**
     */
    public void setNoscripts(
                    final Boolean noscripts
                    )
    {
        this.noscripts = noscripts;
    }


    public Boolean getNoscripts()
    {
        return this.noscripts;
    }


    public static boolean noscripts( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  noscripts = behaviors.getNoscripts();

        return (noscripts == null ? DEFAULT_NOSCRIPTS.booleanValue() : noscripts.booleanValue());
    }



    /**
     */
    public void setNosignature(
                    final Boolean nosignature
                    )
    {
        this.nosignature = nosignature;
    }


    public Boolean getNosignature()
    {
        return this.nosignature;
    }


    public static boolean nosignature( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nosignature = behaviors.getNosignature();

        return (nosignature == null ? DEFAULT_NOSIGNATURE.booleanValue() : nosignature.booleanValue());
    }



    /**
     */
    public void setNolinkto(
                    final Boolean nolinkto
                    )
    {
        this.nolinkto = nolinkto;
    }


    public Boolean getNolinkto()
    {
        return this.nolinkto;
    }


    public static boolean nolinkto( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nolinkto = behaviors.getNolinkto();

        return (nolinkto == null ? DEFAULT_NOLINKTO.booleanValue() : nolinkto.booleanValue());
    }

    
    
    /**
     */
    public void setNomd5(
                    final Boolean nomd5
                    )
    {
        this.nomd5 = nomd5;
    }


    public Boolean getNomd5()
    {
        return this.nomd5;
    }


    public static boolean nomd5( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nomd5 = behaviors.getNomd5();

        return (nomd5 == null ? DEFAULT_NOMD5.booleanValue() : nomd5.booleanValue());
    }

    
    
    /**
     */
    public void setNosize(
                    final Boolean nosize
                    )
    {
        this.nosize = nosize;
    }


    public Boolean getNosize()
    {
        return this.nosize;
    }


    public static boolean nosize( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nosize = behaviors.getNosize();

        return (nosize == null ? DEFAULT_NOSIZE.booleanValue() : nosize.booleanValue());
    }

    
    
    /**
     */
    public void setNouser(
                    final Boolean nouser
                    )
    {
        this.nouser = nouser;
    }


    public Boolean getNouser()
    {
        return this.nouser;
    }


    public static boolean nouser( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nouser = behaviors.getNouser();

        return (nouser == null ? DEFAULT_NOUSER.booleanValue() : nouser.booleanValue());
    }

    
    
    /**
     */
    public void setNogroup(
                    final Boolean nogroup
                    )
    {
        this.nogroup = nogroup;
    }


    public Boolean getNogroup()
    {
        return this.nogroup;
    }


    public static boolean nogroup( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nogroup = behaviors.getNogroup();

        return (nogroup == null ? DEFAULT_NOGROUP.booleanValue() : nogroup.booleanValue());
    }

    
    
    /**
     */
    public void setNomtime(
                    final Boolean nomtime
                    )
    {
        this.nomtime = nomtime;
    }


    public Boolean getNomtime()
    {
        return this.nomtime;
    }


    public static boolean nomtime( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nomtime = behaviors.getNomtime();

        return (nomtime == null ? DEFAULT_NOMTIME.booleanValue() : nomtime.booleanValue());
    }

    
    
    /**
     */
    public void setNomode(
                    final Boolean nomode
                    )
    {
        this.nomode = nomode;
    }


    public Boolean getNomode()
    {
        return this.nomode;
    }


    public static boolean nomode( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nomode = behaviors.getNomtime();

        return (nomode == null ? DEFAULT_NOMODE.booleanValue() : nomode.booleanValue());
    }

    
    
    /**
     */
    public void setNordev(
                    final Boolean nordev
                    )
    {
        this.nordev = nordev;
    }


    public Boolean getNordev()
    {
        return this.nordev;
    }


    public static boolean nordev( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  nordev = behaviors.getNordev();

        return (nordev == null ? DEFAULT_NORDEV.booleanValue() : nordev.booleanValue());
    }

    
    
    /**
     */
    public void setNoconfigfiles(
                    final Boolean noconfigfiles
                    )
    {
        this.noconfigfiles = noconfigfiles;
    }


    public Boolean getNoconfigfiles()
    {
        return this.noconfigfiles;
    }


    public static boolean noconfigfiles( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  noconfigfiles = behaviors.getNordev();

        return (noconfigfiles == null ? DEFAULT_NOCONFIGFILES.booleanValue() : noconfigfiles.booleanValue());
    }

    
    
    /**
     */
    public void setNoghostfiles(
                    final Boolean noghostfiles
                    )
    {
        this.noghostfiles = noghostfiles;
    }


    public Boolean getNoghostfiles()
    {
        return this.noghostfiles;
    }


    public static boolean noghostfiles( 
                    final RpmVerifyBehaviors behaviors
                    )
    {
        Boolean  noghostfiles = behaviors.getNordev();

        return (noghostfiles == null ? DEFAULT_NOGHOSTFILES.booleanValue() : noghostfiles.booleanValue());
    }

    
    
    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (nodeps( this ) ? 0 : 1);
        result = prime * result + (nodigest( this )  ? 0 : 1);
        result = prime * result + (nofiles( this )  ? 0 : 1);
        result = prime * result + (noscripts( this )  ? 0 : 1);
        result = prime * result + (nosignature( this )  ? 0 : 1);
        result = prime * result + (nolinkto( this )  ? 0 : 1);
        result = prime * result + (nomd5( this )  ? 0 : 1);
        result = prime * result + (nosize( this )  ? 0 : 1);
        result = prime * result + (nouser( this )  ? 0 : 1);
        result = prime * result + (nogroup( this )  ? 0 : 1);
        result = prime * result + (nomtime( this )  ? 0 : 1);
        result = prime * result + (nomode( this )  ? 0 : 1);
        result = prime * result + (nordev( this )  ? 0 : 1);
        result = prime * result + (noconfigfiles( this )  ? 0 : 1);
        result = prime * result + (noghostfiles( this )  ? 0 : 1);

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RpmVerifyBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            RpmVerifyBehaviors  other = (RpmVerifyBehaviors)obj;
            if (nodeps( this ) == nodeps( other )
                            && nodigest( this ) == nodigest( other ) 
                            && nofiles( this ) == nofiles( other ) 
                            && noscripts( this ) == noscripts( other ) 
                            && nosignature( this ) == nosignature( other ) 
                            && nolinkto( this ) == nolinkto( other ) 
                            && nomd5( this ) == nomd5( other ) 
                            && nosize( this ) == nosize( other ) 
                            && nouser( this ) == nouser( other ) 
                            && nogroup( this ) == nogroup( other ) 
                            && nomtime( this ) == nomtime( other ) 
                            && nomode( this ) == nomode( other ) 
                            && nordev( this ) == nordev( other ) 
                            && noconfigfiles( this ) == noconfigfiles( other ) 
                            && noghostfiles( this ) == noghostfiles( other )
                            ) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", nodeps="           + getNodeps()
                        + ", nodigest="         + getNodigest()
                        + ", nofiles="          + getNofiles()
                        + ", noscripts="        + getNoscripts()
                        + ", nosignature="      + getNosignature()
                        + ", nolinkto="         + getNolinkto()
                        + ", nomd5="            + getNomd5()
                        + ", nosize="           + getNosize()
                        + ", nouser="           + getNouser()
                        + ", nogroup="          + getNogroup()
                        + ", nomtime="          + getNomtime()
                        + ", nomode="           + getNomode()
                        + ", nordev="           + getNordev()
                        + ", noconfigfiles="    + getNoconfigfiles()
                        + ", noghostfiles="     + getNoghostfiles()
                        ;
    }

}
//RpmVerifyBehaviors
