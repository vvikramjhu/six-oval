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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.OvalObject;



/**
 * The RpmVerifyPackageBehaviors complex type defines a set of behaviors
 * that for controlling how installed rpms are verified.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmVerifyPackageBehaviors
    implements OvalObject
{

    public static final Boolean  DEFAULT_NODEPS = Boolean.FALSE;
    private Boolean  nodeps;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NODIGEST = Boolean.FALSE;
    private Boolean  nodigest;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOSCRIPTS = Boolean.FALSE;
    private Boolean  noscripts;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOSIGNATURE = Boolean.FALSE;
    private Boolean  nosignature;
    //{optional, default="false"}



    /**
     * Constructor.
     */
    public RpmVerifyPackageBehaviors()
    {
    }



    /**
     */
    public void setNoDeps(
                    final Boolean nodeps
                    )
    {
        this.nodeps = nodeps;
    }


    public Boolean isNoDeps()
    {
        return nodeps;
    }


    public boolean canonicalIsNoDeps()
    {
        final Boolean  nodeps = isNoDeps();
        return (nodeps == null ? DEFAULT_NODEPS : nodeps);
    }



    /**
     */
    public void setNoDigest(
                    final Boolean nodigest
                    )
    {
        this.nodigest = nodigest;
    }


    public Boolean isNoDigest()
    {
        return nodigest;
    }


    public boolean canonicalIsNoDigest()
    {
        final Boolean  nodigest = isNoDigest();
        return (nodigest == null ? DEFAULT_NODIGEST : nodigest);
    }



    /**
     */
    public void setNoScripts(
                    final Boolean noscripts
                    )
    {
        this.noscripts = noscripts;
    }


    public Boolean isNoScripts()
    {
        return noscripts;
    }


    public boolean canonicalIsNoScripts()
    {
        final Boolean  noscripts = isNoScripts();
        return (noscripts == null ? DEFAULT_NOSCRIPTS : noscripts);
    }



    /**
     */
    public void setNoSignature(
                    final Boolean nosignature
                    )
    {
        this.nosignature = nosignature;
    }


    public Boolean isNoSignature()
    {
        return nosignature;
    }


    public boolean canonicalIsNoSignature()
    {
        final Boolean  nosignature = isNoSignature();
        return (nosignature == null ? DEFAULT_NOSIGNATURE : nosignature);
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (canonicalIsNoDeps() ? 0 : 1);
        result = prime * result + (canonicalIsNoDigest() ? 0 : 1);
        result = prime * result + (canonicalIsNoScripts() ? 0 : 1);
        result = prime * result + (canonicalIsNoSignature() ? 0 : 1);

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

        if (!(obj instanceof RpmVerifyPackageBehaviors)) {
            return false;
        }

        RpmVerifyPackageBehaviors  other = (RpmVerifyPackageBehaviors)obj;
        if (this.canonicalIsNoDeps() == other.canonicalIsNoDeps()
                        &&  (this.canonicalIsNoDigest() == other.canonicalIsNoDigest())
                        &&  (this.canonicalIsNoScripts() == other.canonicalIsNoScripts())
                        &&  (this.canonicalIsNoSignature() == other.canonicalIsNoSignature())
                        ) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[nodeps=" + isNoDeps()
                        + ", nodigest="     + isNoDigest()
                        + ", noscript="     + isNoScripts()
                        + ", nosignature="  + isNoSignature()
                        + "]";
    }

}
//
