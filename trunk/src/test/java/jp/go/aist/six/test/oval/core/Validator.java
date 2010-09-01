package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.OvalElement;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.independent.TextFileContentObject;
import org.testng.Assert;
import org.testng.Reporter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Validator
{

    /**
     * Constructor.
     */
    public Validator()
    {
    }



    /**
     *
     */
    public void equals(
                    final Object actual,
                    final Object expected
                    )
    {
        Assert.assertEquals( actual, expected );
    }




//    /**
//     * Object
//     */
//    public void equals(
//                    final Object actual,
//                    final Object expected
//                    )
//    {
//        Reporter.log( " - as Object", true );
//        Assert.assertEquals( actual, expected );
//
//        if (OvalEntity.class.isInstance( actual )
//                        &&  OvalEntity.class.isInstance( expected )) {
//            _assertEquals( OvalEntity.class.cast( actual ),
//                            OvalEntity.class.cast( expected ) );
//        }
//    }



    /**
     * OvalElement
     */
    protected void _assertEquals(
                    final OvalElement actual,
                    final OvalElement expected
                    )
    {
        Reporter.log( " - OVAL ID", true );
        Assert.assertEquals( actual.getOvalID(), expected.getOvalID() );
        Reporter.log( " - OVAL version", true );
        Assert.assertEquals( actual.getOvalVersion(), expected.getOvalVersion() );

        if (OvalEntity.class.isInstance( actual )
                        &&  OvalEntity.class.isInstance( expected )) {
            _assertEquals( OvalEntity.class.cast( actual ),
                            OvalEntity.class.cast( expected ) );
        }
    }


    /**
     * OvalEntity
     */
    protected void _assertEquals(
                    final OvalEntity actual,
                    final OvalEntity expected
                    )
    {
        Reporter.log( " - deprecated", true );
        Assert.assertEquals( actual.isDeprecated(), expected.isDeprecated() );

        if (CommentedOvalEntity.class.isInstance( actual )
                        &&  CommentedOvalEntity.class.isInstance( expected )) {
            _assertEquals( CommentedOvalEntity.class.cast( actual ),
                            CommentedOvalEntity.class.cast( expected ) );
        }
    }


    /**
     * CommentedOvalEntity
     */
    protected void _assertEquals(
                    final CommentedOvalEntity actual,
                    final CommentedOvalEntity expected
                    )
    {
        Reporter.log( " - comment", true );
        Assert.assertEquals( actual.getComment(), expected.getComment() );

        if (SystemObject.class.isInstance( actual )) {
            if (SystemObject.class.isInstance( expected )) {
                _assertEquals( SystemObject.class.cast( actual ),
                                SystemObject.class.cast( expected ) );
            }
        }
    }



    /**
     * CommentedOvalEntity
     */
    protected void _assertEquals(
                    final SystemObject actual,
                    final SystemObject expected
                    )
    {
        if (TextFileContentObject.class.isInstance( actual )) {
            if (TextFileContentObject.class.isInstance( expected )) {
                _assertEquals( TextFileContentObject.class.cast( actual ),
                                TextFileContentObject.class.cast( expected ) );
            }
        }
    }


    /**
     * TextFileContentObject
     */
    protected void _assertEquals(
                    final TextFileContentObject actual,
                    final TextFileContentObject expected
                    )
    {
        Reporter.log( " - path", true );
        Assert.assertEquals( actual.getPath(), expected.getPath() );
        Reporter.log( " - filename", true );
        Assert.assertEquals( actual.getFilename(), expected.getFilename() );
        Reporter.log( " - line", true );
        Assert.assertEquals( actual.getLine(), expected.getLine() );
    }

}
//

