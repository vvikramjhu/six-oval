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

package jp.go.aist.six.oval.model.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalGenerator;
import jp.go.aist.six.oval.model.v5.Oval5Object;



/**
 * The Generator type defines an element that is used to hold
 * information about when a particular OVAL document was compiled,
 * what version of the schema was used,
 * what tool compiled the document, and
 * what version of that tools was used.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class GeneratorType
    extends OvalGenerator
    implements Oval5Object
{

//    private String  product_name;
//    //{xsd:string, 0..1}
//
//    private String  product_version;
//    //{xsd:string, 0..1}
//
//    private String  schema_version;
//    //{xsd:decimal, 1..1}
//
//    /**
//     * The required timestamp specifies when the particular
//     * OVAL document was compiled.
//     * The format for the timestamp is yyyy-mm-ddThh:mm:ss.
//     */
//    private String  timestamp;
////    private Date  _timestamp;
//    //{xsd:dateTime, 1..1}


    private final Collection<GeneratorInformation>  additional_information =
        new ArrayList<GeneratorInformation>();
    //{0..*}



    /**
     * Constructor.
     */
    public GeneratorType()
    {
    }


    public GeneratorType(
                    final String schema_version,
                    final String timestamp
                    )
    {
        this( schema_version, timestamp, null, null );
    }


    public GeneratorType(
                    final String schema_version,
                    final String timestamp,
                    final String prod_name,
                    final String prod_version
                    )
    {
        setSchemaVersion( schema_version );
        setTimestamp( timestamp );
        setProductName( prod_name );
        setProductVersion( prod_version );
    }



//    /**
//     */
//    public void setProductName(
//                    final String product_name
//                    )
//    {
//        this.product_name = product_name;
//    }
//
//
//    public String getProductName()
//    {
//        return this.product_name;
//    }
//
//
//
//    /**
//     */
//    public void setProductVersion(
//                    final String product_version
//                    )
//    {
//        this.product_version = product_version;
//    }
//
//
//    public String getProductVersion()
//    {
//        return this.product_version;
//    }
//
//
//
//    /**
//     */
//    public void setSchemaVersion(
//                    final String schema_version
//                    )
//    {
//        this.schema_version = schema_version;
//    }
//
//
//    public String getSchemaVersion()
//    {
//        return this.schema_version;
//    }
//
//
//
//    public void setTimestamp(
//                    final String timestamp
//                    )
//    {
//        this.timestamp = timestamp;
//    }
//
//
//    public String getTimestamp()
//    {
//        return this.timestamp;
//    }



    /**
     */
    public void setAdditionalInformation(
                    final Collection<? extends GeneratorInformation> info
                    )
    {
        if (info != this.additional_information) {
            this.additional_information.clear();
            if (info != null  &&  info.size() > 0) {
                this.additional_information.addAll( info );
            }
        }
    }


    public Collection<GeneratorInformation> getAdditionalInformation()
    {
        return this.additional_information;
    }


    public Iterator<GeneratorInformation> iterateAdditionalInformation()
    {
        return this.additional_information.iterator();
    }


    public GeneratorType additionalInformation(
                    final GeneratorInformation info
                    )
    {
        this.additional_information.add( info );
        return this;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public int hashCode()
//    {
//        final int  prime = 37;
//        int  result = 17;
//
//        String  productName = getProductName();
//        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
//
//        String  productVersion = getProductVersion();
//        result = prime * result + ((productVersion == null) ? 0 : productVersion.hashCode());
//
//        String  schemaVersion = getSchemaVersion();
//        result = prime * result + ((schemaVersion == null) ? 0 : schemaVersion.hashCode());
//
//        String  timestamp = getTimestamp();
//        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
//
//        return result;
//    }
//
//
//
//    @Override
//    public boolean equals(
//                    final Object obj
//                    )
//    {
//        if (this == obj) {
//            return true;
//        }
//
//        if (!(obj instanceof GeneratorType)) {
//            return false;
//        }
//
//        GeneratorType  other = (GeneratorType)obj;
//        String  other_ts = other.getTimestamp();
//        String   this_ts =  this.getTimestamp();
//        if (this_ts == other_ts
//                        ||  (this_ts != null  &&  this_ts.equals( other_ts ))) {
//            String  other_sv = other.getSchemaVersion();
//            String   this_sv =  this.getSchemaVersion();
//            if (this_sv == other_sv
//                            ||  (this_sv != null  &&  this_sv.equals( other_sv ))) {
//                String  other_pn = other.getProductName();
//                String   this_pn =  this.getProductName();
//                if (this_pn == other_pn
//                                ||  (this_pn != null  &&  this_pn.equals( other_pn ))) {
//                    String  other_pv = other.getProductVersion();
//                    String   this_pv =  this.getProductVersion();
//                    if (this_pv == other_pv
//                                    ||  (this_pv != null  &&  this_pv.equals( other_pv ))) {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        return false;
//    }



//    @Override
//    public String toString()
//    {
//        return "[product_name=" + getProductName()
//                        + ", product_version=" + getProductVersion()
//                        + ", schema_version=" + getSchemaVersion()
//                        + ", timestamp=" + getTimestamp()
//                        + ", additional_information=" + getAdditionalInformation()
//                        + "]";
//    }

}
// GeneratorType
