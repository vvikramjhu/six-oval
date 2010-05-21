package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.DefinitionClass;
import jp.go.aist.six.oval.model.definition.SimpleTest;
import jp.go.aist.six.oval.model.definition.State;
import jp.go.aist.six.oval.model.definition.StateReference;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.result.Result;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXml2StoreTest.java 763 2010-05-10 08:30:29Z akihito $
 */
public class OvalXml2StoreTest
extends OvalServiceTestBase
{

    /**
     */
    public OvalXml2StoreTest()
    {
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  OVAL Results
    //
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_results
    //==============================================================

    /**
     * @testng.test groups="oval.result oval_results"
     *              dataProvider="oval-result-results"
     *              dependsOnGroups="oval-def"
     *              alwaysRun="true"
     */
    public void processResultResults(
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - XML and store //", true );
        Reporter.log( "  * object type: oval-res:oval_results", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof OvalResults );

        OvalResults  results = OvalResults.class.cast( obj );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( results );
        Reporter.log( "  @ marshalled XML (1024): " + xml.substring( 0, 1024 ), true );

        Reporter.log( "  * creating object...", true );
        String  pid = _store.createOvalResults( results );
        Reporter.log( "  @ created: pid=" + pid, true );

        Reporter.log( "  * finding object...: pid=" + pid, true );
        OvalResults  p_results = _store.findResults( pid );
        Reporter.log( "  @ found: " + p_results, true );
    }



    //==============================================================
    //  oval-res : definition
    //==============================================================

    /**
     * @testng.test groups="oval.service oval-res"
     *              dataProvider="oval-result-definition"
     *              dependsOnGroups="oval-def"
     *              alwaysRun="true"
     */
    public void processResultDefinition(
                    final String filepath,
                    final String id,
                    final int version,
                    final Result result
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - XML and store //", true );
        Reporter.log( "  * object type: oval-res:definition", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof DefinitionResult );

        DefinitionResult  def = DefinitionResult.class.cast( obj );
        Assert.assertEquals( id, def.getOvalID() );
        Assert.assertEquals( version, def.getOvalVersion() );
        Assert.assertEquals( result, def.getResult() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( def );
        Reporter.log( "  @ marshalled XML: " + xml, true );

//        Reporter.log( "  * syncing object...", true );
//        Definition  p_def = _store.sync( def );
//        Reporter.log( "  @ synced: pid=" + p_def.getPersistentID(), true );
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  OVAL System Characteristics
    //
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    /**
     * @testng.test groups="oval.system sc"
     *              dataProvider="oval-system-sc"
     *              alwaysRun="true"
     */
    public void processSystemSC(
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - XML and store //", true );
        Reporter.log( "  * object type: oval-sc:oval_system_characteristics", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof OvalSystemCharacteristics );

        OvalSystemCharacteristics  sc = OvalSystemCharacteristics.class.cast( obj );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( sc );
        Reporter.log( "  @ marshalled XML (1024): " + xml.substring( 0, 1024 ), true );

        Reporter.log( "  * creating object...", true );
        String  pid = _store.createSystemCharacteristics( sc );
        Reporter.log( "  @ created: pid=" + pid, true );

        Reporter.log( "  * finding object...: pid=" + pid, true );
        OvalSystemCharacteristics  p_sc = _store.findSystemCharacteristics( pid );
        Reporter.log( "  @ found: " + p_sc, true );
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  OVAL Definition
    //
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  definition
    //==============================================================

    /**
     * @testng.test groups="oval.definition definition"
     *              dataProvider="oval-definition"
     *              dependsOnGroups="object"
     *              alwaysRun="true"
     */
    public void processDefinition(
                    final String filepath,
                    final String id,
                    final int version,
                    final DefinitionClass clazz
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling XML and syncing with store //", true );
        Reporter.log( "  * object type: oval-def:definition", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Definition );

        Definition  def = Definition.class.cast( obj );
        Assert.assertEquals( id, def.getOvalID() );
        Assert.assertEquals( version, def.getOvalVersion() );
        Assert.assertEquals( clazz, def.getDefinitionClass() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( def );
        Reporter.log( "  @ marshalled XML: " + xml, true );

        Reporter.log( "  * syncing object...", true );
        Definition  p_def = _store.sync( def );
        Reporter.log( "  @ synced: pid=" + p_def.getPersistentID(), true );
    }



    //==============================================================
    //  state
    //==============================================================

    /**
     * @testng.test groups="oval.service oval-def state"
     *              dataProvider="oval-state"
     *              dependsOnGroups="object"
     *              alwaysRun="true"
     */
    public void processState(
                    final ComponentType type,
                    final String filepath,
                    final String id,
                    final int version
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling XML and syncing with store //", true );
        Reporter.log( "  * object type: oval-def:state", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof State );

        State  state = State.class.cast( obj );
        Assert.assertEquals( id, state.getOvalID() );
        Assert.assertEquals( version, state.getOvalVersion() );
        Assert.assertEquals( type, state.getStateType() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( state );
        Reporter.log( "  @ marshalled XML: " + xml, true );

        Reporter.log( "  * syncing object...", true );
        State  p_state = _store.sync( state );
        Reporter.log( "  @ synced: pid=" + p_state.getPersistentID(), true );
    }



    //==============================================================
    //  object
    //==============================================================

    /**
     * @testng.test groups="oval.service oval-def object"
     *              dataProvider="oval-object"
     *              dependsOnGroups="test"
     *              alwaysRun="true"
     */
    public void processObject(
                    final String filepath,
                    final String id,
                    final int version,
                    final String comment
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling XML and syncing with store //", true );
        Reporter.log( "  * object type: oval-def:object", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof SystemObject );

        SystemObject  object = SystemObject.class.cast( obj );
        Assert.assertEquals( id, object.getOvalID() );
        Assert.assertEquals( version, object.getOvalVersion() );
        Assert.assertEquals( comment, object.getComment() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( object );
        Reporter.log( "  @ marshalled XML: " + xml, true );

        Reporter.log( "  * syncing object...", true );
        SystemObject  p_object = _store.sync( object );
        Reporter.log( "  @ synced: pid=" + p_object.getPersistentID(), true );
    }



    //==============================================================
    //  test
    //==============================================================

    /**
     * @testng.test groups="oval.service oval-def test"
     *              dataProvider="oval-test"
     *              alwaysRun="true"
     */
    public void processTest(
                    final String filepath,
                    final String id,
                    final int version,
                    final String comment,
                    final Existence existence,
                    final Check check,
                    final ComponentType type,
                    final String objectID,
                    final String stateID
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling XML and syncing with store //", true );
        Reporter.log( "  * object type: oval-def:test", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Test );
        Test  test = Test.class.cast( obj );
        Assert.assertEquals( id, test.getOvalID() );
        Assert.assertEquals( version, test.getOvalVersion() );
        Assert.assertEquals( comment, test.getComment() );
        Assert.assertEquals( existence, test.getCheckExistence() );
        Assert.assertEquals( check, test.getCheck() );
        Assert.assertEquals( type, test.getTestType() );
        if (test instanceof SimpleTest) {
            SimpleTest  simpleTest = SimpleTest.class.cast( test );
            Assert.assertEquals( objectID, simpleTest.getObject().getOvalID() );
            StateReference  stateRef = simpleTest.getState();
            if (stateRef != null) {
                Assert.assertEquals( stateID, stateRef.getOvalID() );
            }
        }

        Reporter.log( "  * syncing object...", true );
        Test  p_test = _store.sync( test );
        Reporter.log( "  @ synced: pid=" + p_test.getPersistentID(), true );
    }



//    /**
//     * @testng.test groups="oval.service oval-def variable"
//     *              dataProvider="oval-variable"
//     *              dependsOnGroups="definition"
//     *              alwaysRun="true"
//     */
//    public void processVariable(
//                    final String filepath,
//                    final String id,
//                    final int version
//                    )
//    throws Exception
//    {
//        Reporter.log( "\n// TEST: OVAL - unmarshalling XML and syncing with store //", true );
//        Reporter.log( "  * object type: oval-def:variable", true );
//
//        File  file = new File( filepath );
//        Reporter.log( "  * unmarshalling XML...", true );
//        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
//        Reporter.log( "  @ unmarshalled object: " + obj, true );
//
//        Assert.assertNotNull( obj );
//        Assert.assertTrue( obj instanceof Variable );
//
//        Variable  variable = Variable.class.cast( obj );
//        Assert.assertEquals( id, variable.getOvalID() );
//        Assert.assertEquals( version, variable.getOvalVersion() );
//        Reporter.log( "  @ comment: " + variable.getComment(), true );
//        Reporter.log( "  @ Java type: " + variable.getClass(), true );
//
//        if (variable instanceof LocalVariable) {
//            LocalVariable  lvariable = LocalVariable.class.cast( variable );
//            String  contentXml = lvariable.getContentXml();
//            Reporter.log( "  @ content XML: " + contentXml, true );
//        }
//
//
////        Reporter.log( "  * marshalling XML...", true );
////        String  xml = _xml.marshalToString( state );
////        Reporter.log( "  @ marshalled XML: " + xml, true );
////
////        Reporter.log( "  * syncing object...", true );
////        Variable  p_state = _store.sync( state );
////        Reporter.log( "  @ synced: pid=" + p_state.getPersistentID(), true );
//    }

}
// OvalXml2StoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

