package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.independent.FamilyItem;
import jp.go.aist.six.oval.model.independent.TextFileContentItem;



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


}
// ScSample
