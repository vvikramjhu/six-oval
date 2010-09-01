package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.OvalElement;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.independent.TextFileContentObject;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.HashMap;
import java.util.Map;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Validators
{



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



    /**
     */
    public static abstract class Validator<T>
    {
        public void equals(
                        final T actual,
                        final T expected
                        )
        {
            Assert.assertEquals( actual, expected );
        }
    }



    /**
     */
    public static abstract class OvalElementValidator<T extends OvalElement>
    extends Validator<T>
    {
        @Override
        public void equals(
                        final T actual,
                        final T expected
                        )
        {
            Reporter.log( " - OVAL ID", true );
            Assert.assertEquals( actual.getOvalID(), expected.getOvalID() );
            Reporter.log( " - OVAL version", true );
            Assert.assertEquals( actual.getOvalVersion(), expected.getOvalVersion() );
        }
    }



    /**
     */
    public static abstract class OvalEntityValidator<T extends OvalEntity>
    extends OvalElementValidator<T>
    {
        @Override
        public void equals(
                        final T actual,
                        final T expected
                        )
        {
            super.equals( actual, expected );
            Reporter.log( " - deprecated", true );
            Assert.assertEquals( actual.isDeprecated(), expected.isDeprecated() );
        }
    }



    /**
     */
    public static abstract class CommentedOvalEntityValidator<T extends CommentedOvalEntity>
    extends OvalEntityValidator<T>
    {
        @Override
        public void equals(
                        final T actual,
                        final T expected
                        )
        {
            super.equals( actual, expected );
            Reporter.log( " - comment", true );
            Assert.assertEquals( actual.getComment(), expected.getComment() );
        }
    }



    /**
     */
    public static class StateValidator
    extends CommentedOvalEntityValidator<State>
    {
        @Override
        public void equals(
                        final State actual,
                        final State expected
                        )
        {
            super.equals( actual, expected );
            Reporter.log( " - operator", true );
            Assert.assertEquals( actual.getOperator(), expected.getOperator() );
        }
    }



    /**
     */
    public static class TestValidator
    extends CommentedOvalEntityValidator<Test>
    {
        @Override
        public void equals(
                        final Test actual,
                        final Test expected
                        )
        {
            super.equals( actual, expected );
            Reporter.log( " - checkExistence", true );
            Assert.assertEquals( actual.getCheckExistence(), expected.getCheckExistence() );
            Reporter.log( " - check", true );
            Assert.assertEquals( actual.getCheck(), expected.getCheck() );
            Reporter.log( " - stateOperator", true );
            Assert.assertEquals( actual.getStateOperator(), expected.getStateOperator() );
            Reporter.log( " - object", true );
            Assert.assertEquals( actual.getObject(), expected.getObject() );

            //TODO: state
        }
    }



    private static Map<Class<?>, Validator<?>>  _validators
    = new HashMap<Class<?>, Validator<?>>();


    @SuppressWarnings( "unchecked" )
    public static <T> Validator<T> validator(
                    final Class<T> type
                    )
    {
        Validator<T>  v = (Validator<T>)_validators.get( type );
        if (v == null) {
            if (Test.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new TestValidator());
                _validators.put( Test.class, v );
            } else if (State.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new StateValidator());
                _validators.put( State.class, v );
            }
        }

        Assert.assertNotNull( v );
        return v;
    }

}
// Validators

