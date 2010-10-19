package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.independent.FamilyItem;
import jp.go.aist.six.oval.model.independent.TextFileContentItem;
import jp.go.aist.six.oval.model.linux.RpmInfoItem;



/**
 * OVAL System Characteristics sample objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class ScSample
{

    //==============================================================
    //  sc:item
    //==============================================================

    public static final FamilyItem  ITEM_INDEPENDENT_FAMILY_497 =
        new FamilyItem( 497, Family.WINDOWS );


    public static final TextFileContentItem  ITEM_INDEPENDENT_TEXTFILECONTENT_1 =
        new TextFileContentItem( 1 )
    .path( "/etc" )
    .filename( "debian_version" )
    .line( "5.0.4" );


    public static final RpmInfoItem  ITEM_LINUX_RPMINFO_2 =
        new RpmInfoItem( 2 )
    .name( "gzip" )
    .arch( "i386" )
    .epoch( "(none)" )
    .release( "10.el5" )
    .version( "1.3.5" )
    .evr( "0:1.3.5-10.el5" )
    .signatureKeyID( "5326810137017186" )
    ;


}
// ScSample
