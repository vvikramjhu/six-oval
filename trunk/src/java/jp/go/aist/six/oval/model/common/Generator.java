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

package jp.go.aist.six.oval.model.common;

import jp.go.aist.six.util.castor.AbstractPersistable;
import java.util.Date;


/**
 * The generator information.
 *
 * <p>Properties:
 * <ul>
 *   <li>productName: name of the tool used.
 *   </li>
 *   <li>productVersion: version of the tool used.
 *   </li>
 *   <li>schemaVersion {required}: version of the OVAL schema used.
 *   </li>
 *   <li>timestamp {required}: date/time when the document is generated.
 *   </li>
 * </ul>
 * </p>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class Generator
    extends AbstractPersistable
{

    private String  _productName;
    //{xsd:string, 0..1}

    private String  _productVersion;
    //{xsd:string, 0..1}

    private String  _schemaVersion;
    //{xsd:decimal, 1..1}

    private Date  _timestamp;
    //{xsd:dateTime, 1..1}



    /**
     * Constructor.
     */
    public Generator()
    {
    }


    /**
     * Constructor.
     */
    public Generator(
                    final String schemaVersion,
                    final Date timestamp
                    )
    {
        setSchemaVersion( schemaVersion );
        setTimestamp( timestamp );
    }


    /**
     * Constructor.
     */
    public Generator(
                    final String schemaVersion,
                    final Date timestamp,
                    final String prodName,
                    final String prodVersion
                    )
    {
        this( schemaVersion, timestamp );
        setProductName( prodName );
        setProductVersion( prodVersion );
    }



    public void setProductName(
                    final String name
                    )
    {
        _productName = name;
    }


    public String getProductName()
    {
        return _productName;
    }



    public void setProductVersion(
                    final String version
                    )
    {
        _productVersion = version;
    }


    public String getProductVersion()
    {
        return _productVersion;
    }



    public void setSchemaVersion(
                    final String version
                    )
    {
        _schemaVersion = version;
    }


    public String getSchemaVersion()
    {
        return _schemaVersion;
    }



    public void setTimestamp(
                    final Date timestamp
                    )
    {
        _timestamp = timestamp;
    }


    public Date getTimestamp()
    {
        return _timestamp;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  productName = getProductName();
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());

        String  productVersion = getProductVersion();
        result = prime * result + ((productVersion == null) ? 0 : productVersion.hashCode());

        String  schemaVersion = getSchemaVersion();
        result = prime * result + ((schemaVersion == null) ? 0 : schemaVersion.hashCode());

        Date  timestamp = getTimestamp();
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());

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

        if (!(obj instanceof Generator)) {
            return false;
        }

        Generator  other = (Generator)obj;
        Date  other_ts = other.getTimestamp();
        Date   this_ts =  this.getTimestamp();
        if (this_ts == other_ts
                        ||  (this_ts != null  &&  this_ts.equals( other_ts ))) {
            String  other_sv = other.getSchemaVersion();
            String   this_sv =  this.getSchemaVersion();
            if (this_sv == other_sv
                            ||  (this_sv != null  &&  this_sv.equals( other_sv ))) {
                String  other_pn = other.getProductName();
                String   this_pn =  this.getProductName();
                if (this_pn == other_pn
                                ||  (this_pn != null  &&  this_pn.equals( other_pn ))) {
                    String  other_pv = other.getProductVersion();
                    String   this_pv =  this.getProductVersion();
                    if (this_pv == other_pv
                                    ||  (this_pv != null  &&  this_pv.equals( other_pv ))) {
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
        return "Generator[product_name=" + getProductName()
                        + ", product_version=" + getProductVersion()
                        + ", schema_version=" + getSchemaVersion()
                        + ", timestamp=" + getTimestamp()
                        + "]";
    }

}
// Generator
