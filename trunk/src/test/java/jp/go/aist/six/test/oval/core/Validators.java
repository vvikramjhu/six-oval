package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.OvalElement;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definitions.Component;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.LocalVariable;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.StateRef;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.independent.FamilyItem;
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.DefinitionResults;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.results.SystemResults;
import jp.go.aist.six.oval.model.results.TestResult;
import jp.go.aist.six.oval.model.results.TestResults;
import jp.go.aist.six.oval.model.results.TestedItem;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemData;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
     */
    public static class VariableValidator
    extends CommentedOvalEntityValidator<Variable>
    {
        @Override
        public void equals(
                        final Variable actual,
                        final Variable expected
                        )
        {
            super.equals( actual, expected );
            if (expected instanceof LocalVariable) {
                LocalVariable  eLocal = (LocalVariable)expected;
                LocalVariable  aLocal = (LocalVariable)actual;
                Component  eComponent = eLocal.getComponent();
                Component  aComponent = aLocal.getComponent();
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
            if (expected == null) {
                return;
            }

            Reporter.log( " - generator", true );
            Assert.assertEquals( actual.getGenerator(), expected.getGenerator() );

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



    //==============================================================
    //  oval-sc
    //==============================================================

    /**
     * SystemInfo
     */
    public static class SystemInfoValidator
    extends Validator<SystemInfo>
    {
        @Override
        public void equals(
                        final SystemInfo actual,
                        final SystemInfo expected
                        )
        {
            Assert.assertEquals( actual.getOsName(), expected.getOsName() );
            Assert.assertEquals( actual.getOsVersion(), expected.getOsVersion() );
            Assert.assertEquals( actual.getArchitecture(), expected.getArchitecture() );
            Assert.assertEquals( actual.getPrimaryHostName(), expected.getPrimaryHostName() );

            Assert.assertEquals( actual.getInterfaces(), expected.getInterfaces() );
        }
    }


    /**
     * SystemInfo
     */
    public static class ItemValidator
    extends Validator<Item>
    {
        @Override
        public void equals(
                        final Item actual,
                        final Item expected
                        )
        {
            Assert.assertEquals( actual.getID(), expected.getID() );
            if (expected instanceof FamilyItem) {
                FamilyItem  af = (FamilyItem)actual;
                FamilyItem  ef = (FamilyItem)actual;
                Assert.assertEquals( af.getFamily(), ef.getFamily() );
            }
        }
    }


    /**
     * OvalSystemCharacteristics
     */
    public static class OvalSystemCharacteristicsValidator
    extends Validator<OvalSystemCharacteristics>
    {
        @Override
        public void equals(
                        final OvalSystemCharacteristics actual,
                        final OvalSystemCharacteristics expected
                        )
        {
            Reporter.log( " - generator", true );
            Assert.assertEquals( actual.getGenerator(), expected.getGenerator() );

            Reporter.log( " - system_info", true );
            validator( SystemInfo.class ).equals( actual.getSystemInfo(), expected.getSystemInfo() );

            Reporter.log( " - system_data", true );
            SystemData  expectedItems = expected.getSystemData();
            SystemData  actualItems = actual.getSystemData();
            if (expectedItems == null  ||  expectedItems.size() == 0) {
                Assert.assertTrue( actualItems == null  || actualItems.size() == 0 );
            } else {
                Assert.assertEquals( actualItems.size(), expectedItems.size() );
                for (Item  expectedItem : expectedItems) {
                    boolean  contained = false;
                    for (Item  actualItem : actualItems) {
                        if (actualItem.getID() == expectedItem.getID()) {
//                            Assert.assertEquals( actualItem.getEntityType(), expectedItem.getEntityType() );
                            Assert.assertEquals( actualItem.getStatus(), expectedItem.getStatus() );
                            contained = true;
                            break;
                        }
                    }
                    Assert.assertTrue( contained );
                }
            }
        }
    }



    //==============================================================
    //  oval-results
    //==============================================================

    /**
     */
    public static class SystemResultValidator
    extends Validator<SystemResult>
    {
        @Override
        public void equals(
                        final SystemResult actual,
                        final SystemResult expected
                        )
        {
            Reporter.log( " - results/system", true );

            validator( OvalSystemCharacteristics.class )
            .equals( actual.getOvalSystemCharacteristics(), expected.getOvalSystemCharacteristics() );

            Reporter.log( " - results/system/definitions", true );
            DefinitionResults  expectedDefinitions = expected.getDefinitions();
            DefinitionResults    actualDefinitions =   actual.getDefinitions();
            Reporter.log( "  * expected definitions: " + expectedDefinitions, true );
            Reporter.log( "  *    actualdefinitions: " + actualDefinitions, true );
            if (expectedDefinitions == null  ||  expectedDefinitions.size() == 0) {
                Assert.assertTrue( actualDefinitions == null  || actualDefinitions.size() == 0 );
            } else {
                Assert.assertEquals( actualDefinitions.size(), expectedDefinitions.size() );
                for (DefinitionResult  expectedDef : expectedDefinitions) {
                    boolean  contained = false;
                    for (DefinitionResult  actualDef: actualDefinitions) {
                        if (actualDef.getOvalID().equals( expectedDef.getOvalID() )) {
                            Reporter.log( " - results/system/definitions/definition/@id", true );
                            Reporter.log( " - results/system/definitions/definition/@version", true );
                            Assert.assertEquals( actualDef.getOvalVersion(), expectedDef.getOvalVersion() );
                            Reporter.log( " - results/system/definitions/definition/@result", true );
                            Assert.assertEquals( actualDef.getResult(), expectedDef.getResult() );
                            contained = true;
                            break;
                        }
                    }
                    Assert.assertTrue( contained );
                }
            }

            Reporter.log( " - results/system/tests", true );
            TestResults  expectedTests = expected.getTests();
            TestResults    actualTests =   actual.getTests();
            if (expectedTests == null  ||  expectedTests.size() == 0) {
                Assert.assertTrue( actualTests == null  || actualTests.size() == 0 );
            } else {
                Assert.assertEquals( actualTests.size(), expectedTests.size() );
                for (TestResult  expectedTest : expectedTests) {
                    Reporter.log( " - results/system/tests/test: " + expectedTest.getOvalID(), true );
                    boolean  contained = false;
                    for (TestResult  actualTest: actualTests) {
                        if (actualTest.getOvalID().equals( expectedTest.getOvalID() )) {
                            Reporter.log( " - results/system/tests/test/@version", true );
                            Assert.assertEquals( actualTest.getOvalVersion(), expectedTest.getOvalVersion() );
                            Reporter.log( " - results/system/tests/test/@result", true );
                            Assert.assertEquals( actualTest.getResult(), expectedTest.getResult() );
                            Reporter.log( " - results/system/tests/test/tested_item", true );
                            Assert.assertEquals( new HashSet<TestedItem>( actualTest.getTestedItem() ),
                                            new HashSet<TestedItem>( expectedTest.getTestedItem() ) );
                            contained = true;
                            break;
                        }
                    }
                    Assert.assertTrue( contained );
                }
            }
        }
    }



    /**
     */
    public static class SystemResultsValidator
    extends Validator<SystemResults>
    {
        @Override
        public void equals(
                        final SystemResults actual,
                        final SystemResults expected
                        )
        {
            if (expected.size() == 1) {
                Assert.assertTrue( actual.size() == 1 );
                SystemResult  expectedResult = expected.iterator().next();
                SystemResult  actualResult = actual.iterator().next();
                validator( SystemResult.class ).equals( actualResult, expectedResult );
            }
        }
    }



    /**
     */
    public static class OvalResultsValidator
    extends Validator<OvalResults>
    {
        @Override
        public void equals(
                        final OvalResults actual,
                        final OvalResults expected
                        )
        {
            Reporter.log( " - generator", true );
            Assert.assertEquals( actual.getGenerator(), expected.getGenerator() );

            Reporter.log( " - directives", true );
            Assert.assertEquals( actual.getDirectives(), expected.getDirectives() );

            Reporter.log( " - oval_definitions", true );
            validator( OvalDefinitions.class ).equals( actual.getDefinitions(), expected.getDefinitions() );

            Reporter.log( " - results", true );
            validator( SystemResults.class ).equals( actual.getResults(), expected.getResults() );
        }
    }



    //==============================================================
    //  validator instances
    //==============================================================

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
            } else if (Variable.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new VariableValidator());
                _validators.put( Variable.class, v );

            } else if (OvalSystemCharacteristics.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new OvalSystemCharacteristicsValidator());
                _validators.put( OvalSystemCharacteristics.class, v );
            } else if (SystemInfo.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new SystemInfoValidator());
                _validators.put( SystemInfo.class, v );
            } else if (Item.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new ItemValidator());
                _validators.put( Item.class, v );

            } else if (OvalResults.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new OvalResultsValidator());
                _validators.put( OvalResults.class, v );
            } else if (SystemResults.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new SystemResultsValidator());
                _validators.put( SystemResults.class, v );
            } else if (SystemResult.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new SystemResultValidator());
                _validators.put( SystemResult.class, v );
            }
        }

        Assert.assertNotNull( v );
        return v;
    }

}
// Validators

