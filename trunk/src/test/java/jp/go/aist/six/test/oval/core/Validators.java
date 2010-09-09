package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.OvalElement;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.StateRef;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Validators
{

    public static <T> void assertEquals(
                    final Collection<T> actual,
                    final Collection<T> expected
                    )
    {
        if (actual == null) {
            Assert.assertTrue( expected == null  ||  expected.size() == 0 );
        } else {
            Assert.assertEquals( actual.size(), expected.size() );
            Assert.assertTrue( actual.containsAll( expected ) );
        }
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
    public static class SystemObjectValidator
    extends CommentedOvalEntityValidator<SystemObject>
    {
        @Override
        public void equals(
                        final SystemObject actual,
                        final SystemObject expected
                        )
        {
            super.equals( actual, expected );
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

            Reporter.log( " - state", true );
            Collection<StateRef>  expectedStates = expected.getState();
            Collection<StateRef>  actualStates = actual.getState();
            if (expectedStates == null  ||  expectedStates.size() == 0) {
                Assert.assertTrue( (actualStates == null  ||  actualStates.size() == 0) );
            } else {
                Assert.assertEquals( actualStates.size(), expectedStates.size() );
                Assert.assertTrue( actualStates.containsAll( expectedStates ));
            }
        }
    }



    /**
     * Definition
     */
    public static class DefinitionValidator
    extends OvalEntityValidator<Definition>
    {
        @Override
        public void equals(
                        final Definition actual,
                        final Definition expected
                        )
        {
            super.equals( actual, expected );

            Reporter.log( " - class", true );
            Assert.assertEquals( actual.getDefinitionClass(), expected.getDefinitionClass() );

            Reporter.log( " - metadata", true );
            _assertEquals( actual.getMetadata(), expected.getMetadata() );

            if (actual.getCriteria() == null) {
                Reporter.log( " - criteria (SKIP)", true );
            } else {
                Reporter.log( " - criteria", true );
                Assert.assertEquals( actual.getCriteria(), expected.getCriteria() );
            }
        }


        private void _assertEquals(
                        final Metadata actual,
                        final Metadata expected
                        )
        {
            if (actual == null) {
                Assert.assertNull( expected );
                return;
            }

            Reporter.log( " - metadata.title", true );
            Assert.assertEquals( actual.getTitle(), expected.getTitle() );
            Reporter.log( " - metadata.affected", true );
            Assert.assertEquals( actual.getAffected(), expected.getAffected() );
            Reporter.log( " - metadata.description", true );
            Assert.assertEquals( actual.getDescription(), expected.getDescription() );
            Reporter.log( " - metadata.reference", true );
            assertEquals( actual.getReference(), expected.getReference() );
        }
    }


    /**
     * OvalDefinitions
     */
    public static class OvalDefinitionsValidator
    extends Validator<OvalDefinitions>
    {
        @Override
        public void equals(
                        final OvalDefinitions actual,
                        final OvalDefinitions expected
                        )
        {
//            Reporter.log( " - generator", true );
//            Assert.assertEquals( actual.getGenerator(), expected.getGenerator() );

            Reporter.log( " - definitions", true );
            Assert.assertEquals( actual.getDefinitions(), expected.getDefinitions() );
            Definitions  expectedDefinitions = expected.getDefinitions();
            if (expectedDefinitions != null) {
                Definitions  actualDefinitions = actual.getDefinitions();
                for (Definition  expectedDefinition : expectedDefinitions) {
                    Definition  actualDefinition = actualDefinitions.find( expectedDefinition.getOvalID() );
                    validator( Definition.class ).equals( actualDefinition, expectedDefinition );
                }
            }

            Reporter.log( " - tests", true );
            Assert.assertEquals( actual.getTests(), expected.getTests() );

            Reporter.log( " - objects", true );
            Assert.assertEquals( actual.getObjects(), expected.getObjects() );

            Reporter.log( " - states", true );
            Assert.assertEquals( actual.getStates(), expected.getStates() );

            Reporter.log( " - variables", true );
            Assert.assertEquals( actual.getVariables(), expected.getVariables() );
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
            if (OvalDefinitions.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new OvalDefinitionsValidator());
                _validators.put( OvalDefinitions.class, v );
            } else if (Definition.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new DefinitionValidator());
                _validators.put( Definition.class, v );
            } else if (Test.class.isAssignableFrom( type )) {
                    v = (Validator<T>)(new TestValidator());
                    _validators.put( Test.class, v );
            } else if (State.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new StateValidator());
                _validators.put( State.class, v );
            } else if (SystemObject.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new SystemObjectValidator());
                _validators.put( SystemObject.class, v );
            }
        }

        Assert.assertNotNull( v );
        return v;
    }

}
// Validators

