package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.OvalElement;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.StateRef;
import jp.go.aist.six.oval.model.definitions.States;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.SystemObjects;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Tests;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.independent.FamilyItem;
import jp.go.aist.six.oval.model.independent.FamilyState;
import jp.go.aist.six.oval.model.independent.TextFileContent54Object;
import jp.go.aist.six.oval.model.independent.TextFileContent54State;
import jp.go.aist.six.oval.model.independent.TextFileContentItem;
import jp.go.aist.six.oval.model.independent.TextFileContentObject;
import jp.go.aist.six.oval.model.independent.TextFileContentState;
import jp.go.aist.six.oval.model.linux.DpkgInfoObject;
import jp.go.aist.six.oval.model.linux.DpkgInfoState;
import jp.go.aist.six.oval.model.linux.LinuxEvrPkgInfoState;
import jp.go.aist.six.oval.model.linux.RpmInfoItem;
import jp.go.aist.six.oval.model.linux.RpmInfoObject;
import jp.go.aist.six.oval.model.linux.RpmInfoState;
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.DefinitionResults;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.results.SystemResults;
import jp.go.aist.six.oval.model.results.TestResult;
import jp.go.aist.six.oval.model.results.TestResults;
import jp.go.aist.six.oval.model.sc.CollectedSystemObject;
import jp.go.aist.six.oval.model.sc.CollectedSystemObjects;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.ItemReference;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemData;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.oval.model.sc.VariableValue;
import jp.go.aist.six.oval.model.unix.UnameState;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.FileObject;
import jp.go.aist.six.oval.model.windows.FileState;
import jp.go.aist.six.oval.model.windows.MetabaseObject;
import jp.go.aist.six.oval.model.windows.MetabaseState;
import jp.go.aist.six.oval.model.windows.RegistryItem;
import jp.go.aist.six.oval.model.windows.RegistryObject;
import jp.go.aist.six.oval.model.windows.RegistryState;
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
            if (expected == null) {
                return;
            }

            Reporter.log( " - @ovalID", true );
            Assert.assertEquals( actual.getOvalID(), expected.getOvalID() );
            Reporter.log( " - @ovalVersion", true );
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
            if (expected == null) {
                return;
            }

            super.equals( actual, expected );
            Reporter.log( " - @deprecated", true );
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
            if (expected == null) {
                return;
            }

            super.equals( actual, expected );
            Reporter.log( " - @comment", true );
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
            if (expected == null) {
                return;
            }

            Reporter.log( "*** expected: " + expected.getOvalID(), true );
            super.equals( actual, expected );

            Reporter.log( " - @operator", true );
            Assert.assertEquals( actual.getOperator(), expected.getOperator() );

            if ((expected instanceof DpkgInfoState)
                            ||  (expected instanceof RpmInfoState)) {
                Assert.assertTrue( actual instanceof LinuxEvrPkgInfoState);
                LinuxEvrPkgInfoState  apkg = (LinuxEvrPkgInfoState)actual;
                LinuxEvrPkgInfoState  epkg = (LinuxEvrPkgInfoState)expected;
                Reporter.log( " - [dpkg|rpm]info_state/name", true );
                Assert.assertEquals( apkg.getName(), epkg.getName() );
                Reporter.log( " - [dpkg|rpm]info_state/arch", true );
                Assert.assertEquals( apkg.getArch(), epkg.getArch() );
                Reporter.log( " - [dpkg|rpm]info_state/epoch", true );
                Assert.assertEquals( apkg.getEpoch(), epkg.getEpoch() );
                Reporter.log( " - [dpkg|rpm]info_state/release", true );
                Assert.assertEquals( apkg.getRelease(), epkg.getRelease() );
                Reporter.log( " - [dpkg|rpm]info_state/version", true );
                Assert.assertEquals( apkg.getVersion(), epkg.getVersion() );
                Reporter.log( " - [dpkg|rpm]info_state/evr", true );
                Assert.assertEquals( apkg.getEvr(), epkg.getEvr() );
                if (expected instanceof RpmInfoState) {
                    Assert.assertTrue( actual instanceof RpmInfoState);
                    RpmInfoState  arpm = (RpmInfoState)actual;
                    RpmInfoState  erpm = (RpmInfoState)expected;
                    Reporter.log( " - rpminfo_state/signature_keyid", true );
                    Assert.assertEquals( arpm.getSignatureKeyID(), erpm.getSignatureKeyID() );
                }
            } else if (expected instanceof FamilyState) {
                Assert.assertTrue( actual instanceof FamilyState);
                FamilyState  afamily = (FamilyState)actual;
                FamilyState  efamily = (FamilyState)expected;
                Reporter.log( " - family_state/family", true );
                Assert.assertEquals( afamily.getFamily(), efamily.getFamily() );
            } else if (expected instanceof TextFileContentState) {
                Assert.assertTrue( actual instanceof TextFileContentState);
                TextFileContentState  atext = (TextFileContentState)actual;
                TextFileContentState  etext = (TextFileContentState)expected;
                Reporter.log( " - textfilecontent_state/path", true );
                Assert.assertEquals( atext.getPath(), etext.getPath() );
                Reporter.log( " - textfilecontent_state/filename", true );
                Assert.assertEquals( atext.getFilename(), etext.getFilename() );
                Reporter.log( " - textfilecontent_state/line", true );
                Assert.assertEquals( atext.getLine(), etext.getLine() );
                Reporter.log( " - textfilecontent_state/subexpression", true );
                Assert.assertEquals( atext.getSubexpression(), etext.getSubexpression() );
            } else if (expected instanceof TextFileContent54State) {
                Assert.assertTrue( actual instanceof TextFileContent54State);
                TextFileContent54State  atext = (TextFileContent54State)actual;
                TextFileContent54State  etext = (TextFileContent54State)expected;
                Reporter.log( " - textfilecontent54_state/filepath", true );
                Assert.assertEquals( atext.getFilepath(), etext.getFilepath() );
                Reporter.log( " - textfilecontent54_state/path", true );
                Assert.assertEquals( atext.getPath(), etext.getPath() );
                Reporter.log( " - textfilecontent54_state/filename", true );
                Assert.assertEquals( atext.getFilename(), etext.getFilename() );
                Reporter.log( " - textfilecontent54_state/pattern", true );
                Assert.assertEquals( atext.getPattern(), etext.getPattern() );
                Reporter.log( " - textfilecontent54_state/instance", true );
                Assert.assertEquals( atext.getInstance(), etext.getInstance() );
                Reporter.log( " - textfilecontent54_state/text", true );
                Assert.assertEquals( atext.getText(), etext.getText() );
                Reporter.log( " - textfilecontent54_state/subexpression", true );
                Assert.assertEquals( atext.getSubexpression(), etext.getSubexpression() );

            } else if (expected instanceof UnameState) {
                Assert.assertTrue( actual instanceof UnameState );
                UnameState  auname = (UnameState)actual;
                UnameState  euname = (UnameState)expected;
                Reporter.log( " - uname_state/machine_class", true );
                Assert.assertEquals( auname.getMachineClass(), euname.getMachineClass() );
                Reporter.log( " - uname_state/node_name", true );
                Assert.assertEquals( auname.getNodeName(), euname.getNodeName() );
                Reporter.log( " - uname_state/osName", true );
                Assert.assertEquals( auname.getOsName(), euname.getOsName() );
                Reporter.log( " - uname_state/os_release", true );
                Assert.assertEquals( auname.getOsRelease(), euname.getOsRelease() );
                Reporter.log( " - uname_state/os_version", true );
                Assert.assertEquals( auname.getOsVersion(), euname.getOsVersion() );
                Reporter.log( " - uname_state/processor_type", true );
                Assert.assertEquals( auname.getProcessorType(), euname.getProcessorType() );

            } else if (expected instanceof FileState) {
                Assert.assertTrue( actual instanceof FileState );
                FileState  afile = (FileState)actual;
                FileState  efile = (FileState)expected;
                Reporter.log( " - file_state/filepath", true );
                Assert.assertEquals( afile.getFilepath(), efile.getFilepath() );
                Reporter.log( " - file_state/path", true );
                Assert.assertEquals( afile.getPath(), efile.getPath() );
                Reporter.log( " - file_state/filename", true );
                Assert.assertEquals( afile.getFilename(), efile.getFilename() );
                Reporter.log( " - file_state/owner", true );
                Assert.assertEquals( afile.getOwner(), efile.getOwner() );
                Reporter.log( " - file_state/size", true );
                Assert.assertEquals( afile.getSize(), efile.getSize() );
                Reporter.log( " - file_state/a_time", true );
                Assert.assertEquals( afile.getATime(), efile.getATime() );
                Reporter.log( " - file_state/c_time", true );
                Assert.assertEquals( afile.getCTime(), efile.getCTime() );
                Reporter.log( " - file_state/m_time", true );
                Assert.assertEquals( afile.getMTime(), efile.getMTime() );
                Reporter.log( " - file_state/ms_checksum", true );
                Assert.assertEquals( afile.getMSChecksum(), efile.getMSChecksum() );
                Reporter.log( " - file_state/version", true );
                Assert.assertEquals( afile.getVersion(), efile.getVersion() );
                Reporter.log( " - file_state/type", true );
                Assert.assertEquals( afile.getType(), efile.getType() );
                Reporter.log( " - file_state/development_class", true );
                Assert.assertEquals( afile.getDevelopmentClass(), efile.getDevelopmentClass() );
                Reporter.log( " - file_state/company", true );
                Assert.assertEquals( afile.getCompany(), efile.getCompany() );
                Reporter.log( " - file_state/internal_name", true );
                Assert.assertEquals( afile.getInternalName(), efile.getInternalName() );
                Reporter.log( " - file_state/language", true );
                Assert.assertEquals( afile.getLanguage(), efile.getLanguage() );
                Reporter.log( " - file_state/original_filename", true );
                Assert.assertEquals( afile.getOriginalFilename(), efile.getOriginalFilename() );
                Reporter.log( " - file_state/productName", true );
                Assert.assertEquals( afile.getProductName(), efile.getProductName() );
                Reporter.log( " - file_state/productVersion", true );
                Assert.assertEquals( afile.getProductVersion(), efile.getProductVersion() );
            } else if (expected instanceof MetabaseState) {
                Assert.assertTrue( actual instanceof MetabaseState );
                MetabaseState  amb = (MetabaseState)actual;
                MetabaseState  emb = (MetabaseState)expected;
                Reporter.log( " - metabase_state/key", true );
                Assert.assertEquals( amb.getKey(), emb.getKey() );
                Reporter.log( " - metabase_state/id", true );
                Assert.assertEquals( amb.getID(), emb.getID() );
                Reporter.log( " - metabase_state/name", true );
                Assert.assertEquals( amb.getName(), emb.getName() );
                Reporter.log( " - metabase_state/user_type", true );
                Assert.assertEquals( amb.getUserType(), emb.getUserType() );
                Reporter.log( " - metabase_state/data_type", true );
                Assert.assertEquals( amb.getDataType(), emb.getDataType() );
                Reporter.log( " - metabase_state/data", true );
                Assert.assertEquals( amb.getData(), emb.getData() );
            } else if (expected instanceof RegistryState) {
                Assert.assertTrue( actual instanceof RegistryState );
                RegistryState  areg = (RegistryState)actual;
                RegistryState  ereg = (RegistryState)expected;
                Reporter.log( " - registry_state/hive", true );
                Assert.assertEquals( areg.getHive(), ereg.getHive() );
                Reporter.log( " - registry_state/key", true );
                Assert.assertEquals( areg.getKey(), ereg.getKey() );
                Reporter.log( " - registry_state/name", true );
                Assert.assertEquals( areg.getName(), ereg.getName() );
                Reporter.log( " - registry_state/type", true );
                Assert.assertEquals( areg.getType(), ereg.getType() );
                Reporter.log( " - registry_state/value", true );
                Assert.assertEquals( areg.getValue(), ereg.getValue() );

            }
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
            if (expected == null) {
                return;
            }

            Reporter.log( "*** expected: " + expected.getOvalID(), true );
            super.equals( actual, expected );

            if (expected instanceof TextFileContentObject) {
                Assert.assertTrue( actual instanceof TextFileContentObject );
                TextFileContentObject  aobject = (TextFileContentObject)actual;
                TextFileContentObject  eobject = (TextFileContentObject)expected;
                Assert.assertEquals( aobject.getPath(), eobject.getPath() );
                Assert.assertEquals( aobject.getFilename(), eobject.getFilename() );
                Assert.assertEquals( aobject.getLine(), eobject.getLine() );
            } else if (expected instanceof TextFileContent54Object) {
                Assert.assertTrue( actual instanceof TextFileContent54Object );
                TextFileContent54Object  aobject = (TextFileContent54Object)actual;
                TextFileContent54Object  eobject = (TextFileContent54Object)expected;
                Assert.assertEquals( aobject.getBehaviors(), eobject.getBehaviors() );
                Assert.assertEquals( aobject.getPath(), eobject.getPath() );
                Assert.assertEquals( aobject.getFilename(), eobject.getFilename() );
                Assert.assertEquals( aobject.getPattern(), eobject.getPattern() );
                Assert.assertEquals( aobject.getInstance(), eobject.getInstance() );

            } else if (expected instanceof DpkgInfoObject) {
                Assert.assertTrue( actual instanceof DpkgInfoObject );
                DpkgInfoObject  aobject = (DpkgInfoObject)actual;
                DpkgInfoObject  eobject = (DpkgInfoObject)expected;
                Assert.assertEquals( aobject.getName(), eobject.getName() );
            } else if (expected instanceof RpmInfoObject) {
                Assert.assertTrue( actual instanceof RpmInfoObject );
                RpmInfoObject  aobject = (RpmInfoObject)actual;
                RpmInfoObject  eobject = (RpmInfoObject)expected;
                Assert.assertEquals( aobject.getName(), eobject.getName() );

            } else if (expected instanceof FileObject) {
                Assert.assertTrue( actual instanceof FileObject );
                FileObject  aobject = (FileObject)actual;
                FileObject  eobject = (FileObject)expected;
                Reporter.log( " - file_object/filepath", true );
                Assert.assertEquals( aobject.getFilepath(), eobject.getFilepath() );
                Reporter.log( " - file_object/path", true );
                Assert.assertEquals( aobject.getPath(), eobject.getPath() );
                Reporter.log( " - file_object/filename", true );
                Assert.assertEquals( aobject.getFilename(), eobject.getFilename() );
            } else if (expected instanceof MetabaseObject) {
                Assert.assertTrue( actual instanceof MetabaseObject );
                MetabaseObject  aobject = (MetabaseObject)actual;
                MetabaseObject  eobject = (MetabaseObject)expected;
                Assert.assertEquals( aobject.getKey(), eobject.getKey() );
                Assert.assertEquals( aobject.getID(), eobject.getID() );
            } else if (expected instanceof RegistryObject) {
                Assert.assertTrue( actual instanceof RegistryObject );
                RegistryObject  aobject = (RegistryObject)actual;
                RegistryObject  eobject = (RegistryObject)expected;
                Reporter.log( " - registry_object/hive", true );
                Assert.assertEquals( aobject.getHive(), eobject.getHive() );
                Reporter.log( " - registry_object/key", true );
                Assert.assertEquals( aobject.getKey(), eobject.getKey() );
                Reporter.log( " - registry_object/name", true );
                Assert.assertEquals( aobject.getName(), eobject.getName() );
            }
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
            if (expected == null) {
                return;
            }

            Reporter.log( "*** expected: " + expected.getOvalID(), true );
            super.equals( actual, expected );

            Reporter.log( " - @checkExistence", true );
            Assert.assertEquals( actual.getCheckExistence(), expected.getCheckExistence() );
            Reporter.log( " - @check", true );
            Assert.assertEquals( actual.getCheck(), expected.getCheck() );
            Reporter.log( " - @stateOperator", true );
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
//            if (expected instanceof LocalVariable) {
//                LocalVariable  eLocal = (LocalVariable)expected;
//                LocalVariable  aLocal = (LocalVariable)actual;
//                Component  eComponent = eLocal.getComponent();
//                Component  aComponent = aLocal.getComponent();
//            }
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
            if (expected == null) {
                return;
            }

            Reporter.log( "*** expected: " + expected.getOvalID(), true );
            super.equals( actual, expected );

            Reporter.log( " - definition/@class", true );
            Assert.assertEquals( actual.getDefinitionClass(), expected.getDefinitionClass() );

            Reporter.log( " - definition/metadata", true );
            _assertEquals( actual.getMetadata(), expected.getMetadata() );

            if (actual.getCriteria() == null) {
                Reporter.log( " - definition/criteria (SKIP)", true );
            } else {
                Reporter.log( " - definition/criteria", true );
                Assert.assertEquals( actual.getCriteria(), expected.getCriteria() );
            }
        }


        private void _assertEquals(
                        final Metadata actual,
                        final Metadata expected
                        )
        {
            if (expected == null) {
                Assert.assertNull( actual );
                return;
            }

            Reporter.log( " - definition/metadata/title", true );
            Assert.assertEquals( actual.getTitle(), expected.getTitle() );
            Reporter.log( " - definition/metadata/affected", true );
            Assert.assertEquals( actual.getAffected(), expected.getAffected() );
            Reporter.log( " - definition/metadata/description", true );
            Assert.assertEquals( actual.getDescription(), expected.getDescription() );

            Reporter.log( " - definition/metadata/reference", true );
            Collection<Reference>  eref = expected.getReference();
            if (eref != null) {
                Collection<Reference>  aref = actual.getReference();
                Assert.assertEquals( aref.size(), eref.size() );
                Assert.assertTrue( actual.getReference().containsAll( eref ) );
            }
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

            Reporter.log( " - oval_definitions/generator", true );
            Assert.assertEquals( actual.getGenerator(), expected.getGenerator() );

            Reporter.log( " - oval_definitions/definitions", true );
            Assert.assertEquals( actual.getDefinitions(), expected.getDefinitions() );
            Definitions  expectedDefinitions = expected.getDefinitions();
            if (expectedDefinitions != null) {
                Definitions  actualDefinitions = actual.getDefinitions();
                for (Definition  expectedDefinition : expectedDefinitions) {
                    Definition  actualDefinition = actualDefinitions.find( expectedDefinition.getOvalID() );
                    Assert.assertNotNull( actualDefinition );
                    validator( Definition.class ).equals( actualDefinition, expectedDefinition );
                }
            }

            Reporter.log( " - oval_definitions/tests", true );
            Tests  etests = expected.getTests();
            if (etests != null) {
                Tests  atests = actual.getTests();
                for (Test  etest : etests) {
                    Test  atest = atests.find( etest.getOvalID() );
                    Assert.assertNotNull( atest );
                    validator( Test.class ).equals( atest, etest );
                }
            }

            Reporter.log( " - oval_definitions/objects", true );
            SystemObjects  eobjects = expected.getObjects();
            if (eobjects != null) {
                SystemObjects  aobjects = actual.getObjects();
                for (SystemObject  eobject : eobjects) {
                    SystemObject  aobject = aobjects.find( eobject.getOvalID() );
                    Assert.assertNotNull( aobject );
                    validator( SystemObject.class ).equals( aobject, eobject );
                }
            }

            Reporter.log( " - oval_definitions/states", true );
            States  estates = expected.getStates();
            if (estates != null) {
                States  astates = actual.getStates();
                for (State  estate : estates) {
                    State  astate = astates.find( estate.getOvalID() );
                    Assert.assertNotNull( astate );
                    validator( State.class ).equals( astate, estate );
                }
            }

            Reporter.log( " - oval_definitions/variables", true );
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
     * CollectedSystemObject
     */
    public static class CollectedSystemObjectValidator
    extends Validator<CollectedSystemObject>
    {
        @Override
        public void equals(
                        final CollectedSystemObject actual,
                        final CollectedSystemObject expected
                        )
        {
            if (expected == null) {
                return;
            }

            Collection<ItemReference>  aReference = actual.getReference();
            Collection<ItemReference>  eReference = expected.getReference();
            if (eReference == null  ||  eReference.size() == 0) {
                Assert.assertTrue( aReference == null  || aReference.size() == 0 );
            } else {
                Assert.assertEquals( aReference.size(), eReference.size() );
                for (ItemReference  er : eReference) {
                    boolean  contained = false;
                    for (ItemReference  ar : aReference) {
                        if (ar.getItemRef() == er.getItemRef()) {
                            contained = true;
                            break;
                        }
                    }
                    Assert.assertTrue( contained );
                }
            }

            Collection<VariableValue>  aVariableValue = actual.getVariableValue();
            Collection<VariableValue>  eVariableValue = expected.getVariableValue();
            if (eVariableValue == null  ||  eVariableValue.size() == 0) {
                Assert.assertTrue( aVariableValue == null  || aVariableValue.size() == 0 );
            } else {
                Assert.assertEquals( aVariableValue.size(), eVariableValue.size() );
                for (VariableValue  ev : eVariableValue) {
                    boolean  contained = false;
                    for (VariableValue  av : aVariableValue) {
                        if (av.getVariableID().equals( ev.getVariableID() )) {
                            Assert.assertEquals( av.getValue(), ev.getValue() );
                            contained = true;
                            break;
                        }
                    }
                    Assert.assertTrue( contained );
                }
            }

            Assert.assertEquals( actual.getVariableInstance(), expected.getVariableInstance() );
            Assert.assertEquals( actual.getComment(), expected.getComment() );
            Assert.assertEquals( actual.getFlag(), expected.getFlag() );
        }
    }


    /**
     * Item
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
            if (expected == null) {
                return;
            }

            Assert.assertEquals( actual.getID(), expected.getID() );
            if (expected instanceof FamilyItem) {
                FamilyItem  aitem = (FamilyItem)actual;
                FamilyItem  eitem = (FamilyItem)expected;
                Assert.assertEquals( aitem.getFamily(), eitem.getFamily() );
            } else if (expected instanceof TextFileContentItem) {
                TextFileContentItem  aitem = (TextFileContentItem)actual;
                TextFileContentItem  eitem = (TextFileContentItem)expected;
                Assert.assertEquals( aitem.getPath(), eitem.getPath() );
                Assert.assertEquals( aitem.getFilename(), eitem.getFilename() );
                Assert.assertEquals( aitem.getLine(), eitem.getLine() );
            } else if (expected instanceof RpmInfoItem) {
                RpmInfoItem  aitem = (RpmInfoItem)actual;
                RpmInfoItem  eitem = (RpmInfoItem)expected;
                Assert.assertEquals( aitem.getName(), eitem.getName() );
                Assert.assertEquals( aitem.getArch(), eitem.getArch() );
                Assert.assertEquals( aitem.getEpoch(), eitem.getEpoch() );
                Assert.assertEquals( aitem.getRelease(), eitem.getRelease() );
                Assert.assertEquals( aitem.getVersion(), eitem.getVersion() );
                Assert.assertEquals( aitem.getEvr(), eitem.getEvr() );
                Assert.assertEquals( aitem.getSignatureKeyID(), eitem.getSignatureKeyID() );
            } else if (expected instanceof FileItem) {
                FileItem  aitem = (FileItem)actual;
                FileItem  eitem = (FileItem)expected;
                Assert.assertEquals( aitem.getFilepath(), eitem.getFilepath() );
                Assert.assertEquals( aitem.getPath(), eitem.getPath() );
                Assert.assertEquals( aitem.getFilename(), eitem.getFilename() );
                Assert.assertEquals( aitem.getOwner(), eitem.getOwner() );
                Assert.assertEquals( aitem.getSize(), eitem.getSize() );
                Assert.assertEquals( aitem.getATime(), eitem.getATime() );
                Assert.assertEquals( aitem.getCTime(), eitem.getCTime() );
                Assert.assertEquals( aitem.getMTime(), eitem.getMTime() );
                Assert.assertEquals( aitem.getMsChecksum(), eitem.getMsChecksum() );
                Assert.assertEquals( aitem.getVersion(), eitem.getVersion() );
                Assert.assertEquals( aitem.getType(), eitem.getType() );
                Assert.assertEquals( aitem.getDevelopmentClass(), eitem.getDevelopmentClass() );
                Assert.assertEquals( aitem.getCompany(), eitem.getCompany() );
                Assert.assertEquals( aitem.getInternalName(), eitem.getInternalName() );
                Assert.assertEquals( aitem.getLanguage(), eitem.getLanguage() );
                Assert.assertEquals( aitem.getOriginalFilename(), eitem.getOriginalFilename() );
                Assert.assertEquals( aitem.getProductName(), eitem.getProductName() );
                Assert.assertEquals( aitem.getProductVersion(), eitem.getProductVersion() );
            } else if (expected instanceof RegistryItem) {
                Reporter.log( "  * actual item: " + actual.getClass().getName(), true );
                Assert.assertTrue( actual instanceof RegistryItem );
                RegistryItem  aitem = (RegistryItem)actual;
                RegistryItem  eitem = (RegistryItem)expected;
                Assert.assertEquals( aitem.getHive(), eitem.getHive() );
                Assert.assertEquals( aitem.getKey(), eitem.getKey() );
                Assert.assertEquals( aitem.getName(), eitem.getName() );
                Assert.assertEquals( aitem.getType(), eitem.getType() );
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
            if (expected == null) {
                return;
            }

            Reporter.log( " - generator", true );
            Assert.assertEquals( actual.getGenerator(), expected.getGenerator() );

            Reporter.log( " - system_info", true );
            validator( SystemInfo.class ).equals( actual.getSystemInfo(), expected.getSystemInfo() );

            Reporter.log( " - system_data", true );
            SystemData  expectedItems = expected.getSystemData();
            SystemData    actualItems =   actual.getSystemData();
            if (expectedItems == null  ||  expectedItems.size() == 0) {
                Assert.assertTrue( actualItems == null  || actualItems.size() == 0 );
            } else {
                Assert.assertEquals( actualItems.size(), expectedItems.size() );
                for (Item  expectedItem : expectedItems) {
                    Reporter.log( " - system_data/item: " + expectedItem.getID()
                                    + ", " + expectedItem.getEntityType(), true );
                    boolean  contained = false;
                    for (Item  actualItem : actualItems) {
                        if (actualItem.getID() == expectedItem.getID()) {
                            validator( Item.class ).equals( actualItem, expectedItem );
//                            Assert.assertEquals( actualItem.getStatus(), expectedItem.getStatus() );
                            contained = true;
                            break;
                        }
                    }
                    Assert.assertTrue( contained );
                }
            }

            Reporter.log( " - collected_objects", true );
            CollectedSystemObjects  eObjects = expected.getCollectedObjects();
            CollectedSystemObjects  aObjects = actual.getCollectedObjects();
            if (eObjects == null  ||  eObjects.size() == 0) {
                Assert.assertTrue( aObjects == null  || aObjects.size() == 0 );
            } else {
                Assert.assertEquals( aObjects.size(), eObjects.size() );
                for (CollectedSystemObject  eo : eObjects) {
                    boolean  contained = false;
                    for (CollectedSystemObject  ao : aObjects) {
                        if (ao.getOvalID().equals( eo.getOvalID() )) {
                            validator( CollectedSystemObject.class ).equals( ao, eo );
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
            if (expected == null) {
                return;
            }

            Reporter.log( " - results/system", true );

            validator( OvalSystemCharacteristics.class ).equals(
                            actual.getOvalSystemCharacteristics(),
                            expected.getOvalSystemCharacteristics()
            );

            Reporter.log( " - results/system/definitions", true );
            DefinitionResults  expectedDefinitions = expected.getDefinitions();
            DefinitionResults    actualDefinitions =   actual.getDefinitions();
            if (expectedDefinitions == null  ||  expectedDefinitions.size() == 0) {
                Assert.assertTrue( actualDefinitions == null  || actualDefinitions.size() == 0 );
            } else {
                Assert.assertEquals( actualDefinitions.size(), expectedDefinitions.size() );
                for (DefinitionResult  expectedDef : expectedDefinitions) {
                    Reporter.log( " - results/system/definitions/definition: "
                                    + expectedDef.getOvalID(), true );
                    boolean  contained = false;
                    for (DefinitionResult  actualDef: actualDefinitions) {
                        if (actualDef.getOvalID().equals( expectedDef.getOvalID() )
                                        &&  (actualDef.getOvalVersion() == expectedDef.getOvalVersion())
                                        &&  (actualDef.getVariableInstance() == expectedDef.getVariableInstance())
                                        ) {
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
                    Reporter.log( " - results/system/tests/test: "
                                    + expectedTest.getOvalID(), true );
                    boolean  contained = false;
                    for (TestResult  actualTest: actualTests) {
                        if (actualTest.getOvalID().equals( expectedTest.getOvalID() )
                                        &&  (actualTest.getOvalVersion() == expectedTest.getOvalVersion())
                                        &&  (actualTest.getVariableInstance() == expectedTest.getVariableInstance())
                                        ) {
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
            if (expected == null) {
                return;
            }

            if (expected.size() == 1) {
                Assert.assertTrue( actual.size() == 1 );
                SystemResult  expectedResult = expected.iterator().next();
                SystemResult    actualResult = actual.iterator().next();
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
            if (expected == null) {
                return;
            }

            Reporter.log( " - generator", true );
            Assert.assertEquals( actual.getGenerator(), expected.getGenerator() );

            Reporter.log( " - directives", true );
            Assert.assertEquals( actual.getDirectives(), expected.getDirectives() );

            Reporter.log( " - oval_definitions", true );
            validator( OvalDefinitions.class ).equals( actual.getOvalDefinitions(), expected.getOvalDefinitions() );

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
            } else if (CollectedSystemObject.class.isAssignableFrom( type )) {
                v = (Validator<T>)(new CollectedSystemObjectValidator());
                _validators.put( CollectedSystemObject.class, v );
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
