/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
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
 * The RpmVerifyFileBehaviors defines a set of behaviors
 * that for controlling how the individual files in installed rpms are verified.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmVerifyFileBehaviors
    implements OvalObject
{

    public static final Boolean  DEFAULT_NOLINKTO = Boolean.FALSE;
    private Boolean  nolinkto;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOMD5 = Boolean.FALSE;
    private Boolean  nomd5;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOSIZE = Boolean.FALSE;
    private Boolean  nosize;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOUSER = Boolean.FALSE;
    private Boolean  nouser;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOGROUP = Boolean.FALSE;
    private Boolean  nogroup;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOMTIME = Boolean.FALSE;
    private Boolean  nomtime;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOMODE = Boolean.FALSE;
    private Boolean  nomode;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NORDEV = Boolean.FALSE;
    private Boolean  nordev;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOCONFIGFILES = Boolean.FALSE;
    private Boolean  noconfigfiles;
    //{optional, default="false"}

    public static final Boolean  DEFAULT_NOGHOSTFILES = Boolean.FALSE;
    private Boolean  noghostfiles;
    //{optional, default="false"}



    /**
     * Constructor.
     */
    public RpmVerifyFileBehaviors()
    {
    }



    /**
     */
    public void setNoLinkto(
                    final Boolean nolinkto
                    )
    {
        this.nolinkto = nolinkto;
    }


    public Boolean isNoLinkto()
    {
        return nolinkto;
    }


    public boolean canonicalIsNoLinkto()
    {
        final Boolean  nolinkto = isNoLinkto();
        return (nolinkto == null ? DEFAULT_NOLINKTO : nolinkto);
    }



    /**
     */
    public void setNoMd5(
                    final Boolean nomd5
                    )
    {
        this.nomd5 = nomd5;
    }


    public Boolean isNoMd5()
    {
        return nomd5;
    }


    public boolean canonicalIsNoMd5()
    {
        final Boolean  nomd5 = isNoMd5();
        return (nomd5 == null ? DEFAULT_NOMD5 : nomd5);
    }



    /**
     */
    public void setNoSize(
                    final Boolean nosize
                    )
    {
        this.nosize = nosize;
    }


    public Boolean isNoSize()
    {
        return nosize;
    }


    public boolean canonicalIsNoSize()
    {
        final Boolean  nosize = isNoSize();
        return (nosize == null ? DEFAULT_NOSIZE : nosize);
    }



    /**
     */
    public void setNoUser(
                    final Boolean nouser
                    )
    {
        this.nouser = nouser;
    }


    public Boolean isNoUser()
    {
        return nouser;
    }


    public boolean canonicalIsNoUser()
    {
        final Boolean  nouser = isNoUser();
        return (nouser == null ? DEFAULT_NOUSER : nouser);
    }



    /**
     */
    public void setNoGroup(
                    final Boolean nogroup
                    )
    {
        this.nogroup = nogroup;
    }


    public Boolean isNoGroup()
    {
        return nogroup;
    }


    public boolean canonicalIsNoGroup()
    {
        final Boolean  nogroup = isNoGroup();
        return (nogroup == null ? DEFAULT_NOGROUP : nogroup);
    }



    /**
     */
    public void setNoMtime(
                    final Boolean nomtime
                    )
    {
        this.nomtime = nomtime;
    }


    public Boolean isNoMtime()
    {
        return nomtime;
    }


    public boolean canonicalIsNoMtime()
    {
        final Boolean  nomtime = isNoSize();
        return (nomtime == null ? DEFAULT_NOMTIME : nomtime);
    }



    /**
     */
    public void setNoMode(
                    final Boolean nomode
                    )
    {
        this.nomode = nomode;
    }


    public Boolean isNoMode()
    {
        return nomode;
    }


    public boolean canonicalIsNoMode()
    {
        final Boolean  nomode = isNoMode();
        return (nomode == null ? DEFAULT_NOMODE : nomode);
    }



    /**
     */
    public void setNoRdev(
                    final Boolean nordev
                    )
    {
        this.nordev = nordev;
    }


    public Boolean isNoRdev()
    {
        return nordev;
    }


    public boolean canonicalIsNoRdev()
    {
        final Boolean  nordev = isNoRdev();
        return (nordev == null ? DEFAULT_NORDEV : nordev);
    }



    /**
     */
    public void setNoConfigFiles(
                    final Boolean noconfigfiles
                    )
    {
        this.noconfigfiles = noconfigfiles;
    }


    public Boolean isNoConfigFiles()
    {
        return noconfigfiles;
    }


    public boolean canonicalIsNoConfigFiles()
    {
        final Boolean  noconfigfiles = isNoConfigFiles();
        return (noconfigfiles == null ? DEFAULT_NOCONFIGFILES : noconfigfiles);
    }



    /**
     */
    public void setNoGhostFiles(
                    final Boolean noghostfiles
                    )
    {
        this.noghostfiles = noghostfiles;
    }


    public Boolean isNoGhostFiles()
    {
        return noghostfiles;
    }


    public boolean canonicalIsNoGhostFiles()
    {
        final Boolean  noghostfiles = isNoGhostFiles();
        return (noghostfiles == null ? DEFAULT_NOGHOSTFILES : noghostfiles);
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (canonicalIsNoLinkto() ? 0 : 1);
        result = prime * result + (canonicalIsNoMd5() ? 0 : 1);
        result = prime * result + (canonicalIsNoSize() ? 0 : 1);
        result = prime * result + (canonicalIsNoUser() ? 0 : 1);
        result = prime * result + (canonicalIsNoGroup() ? 0 : 1);
        result = prime * result + (canonicalIsNoMtime() ? 0 : 1);
        result = prime * result + (canonicalIsNoMode() ? 0 : 1);
        result = prime * result + (canonicalIsNoRdev() ? 0 : 1);
        result = prime * result + (canonicalIsNoConfigFiles() ? 0 : 1);
        result = prime * result + (canonicalIsNoGhostFiles() ? 0 : 1);

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

        if (!(obj instanceof RpmVerifyFileBehaviors)) {
            return false;
        }

        RpmVerifyFileBehaviors  other = (RpmVerifyFileBehaviors)obj;
        if (this.canonicalIsNoLinkto() == other.canonicalIsNoLinkto()
                        &&  (this.canonicalIsNoMd5() == other.canonicalIsNoMd5())
                        &&  (this.canonicalIsNoSize() == other.canonicalIsNoSize())
                        &&  (this.canonicalIsNoUser() == other.canonicalIsNoUser())
                        &&  (this.canonicalIsNoGroup() == other.canonicalIsNoGroup())
                        &&  (this.canonicalIsNoMtime() == other.canonicalIsNoMtime())
                        &&  (this.canonicalIsNoMode() == other.canonicalIsNoMode())
                        &&  (this.canonicalIsNoRdev() == other.canonicalIsNoRdev())
                        &&  (this.canonicalIsNoConfigFiles() == other.canonicalIsNoConfigFiles())
                        &&  (this.canonicalIsNoGhostFiles() == other.canonicalIsNoGhostFiles())
                        ) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[nolinkto=" + isNoLinkto()
                        + ", nomd5="            + isNoMd5()
                        + ", nosize="           + isNoSize()
                        + ", nouser="           + isNoUser()
                        + ", nogroup="          + isNoGroup()
                        + ", nomtime="          + isNoMtime()
                        + ", nomode="           + isNoMode()
                        + ", nordev="           + isNoRdev()
                        + ", noconfigfiles="    + isNoConfigFiles()
                        + ", noghostfiles="     + isNoGhostFiles()
                        + "]";
    }

}
//
