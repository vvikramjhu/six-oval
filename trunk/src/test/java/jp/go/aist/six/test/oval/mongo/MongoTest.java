package jp.go.aist.six.test.oval.mongo;

import jp.go.aist.six.oval.model.v5.common.DefinitionClassEnumeration;
import jp.go.aist.six.oval.model.v5.common.EnumerationConverter;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.MetadataType;
import org.testng.Reporter;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoTest
{

    /**
     */
    public MongoTest()
    {
    }



    @org.testng.annotations.Test(
                    groups={"oval.mongo", "definitions.definition"},
                    alwaysRun=true
                    )
    public void testMongo()
    throws Exception
    {
        Morphia  morphia = new Morphia();
        morphia.map( DefinitionType.class );
//        morphia.map( DefinitionClassEnumeration.class );
//        morphia.map( FamilyEnumeration.class );
        morphia.getMapper().getConverters().addConverter( EnumerationConverter.class );
        Datastore  db = morphia.createDatastore( (new Mongo()), "oval" );

        DefinitionType  def = new DefinitionType( "oval:org.mitre.oval:def:7222", 5 );
        def.setDefinitionClass( DefinitionClassEnumeration.VULNERABILITY );
//        def.setFamily( FamilyEnumeration.WINDOWS );
        MetadataType  metadata = new MetadataType();
        metadata.setTitle( "this is a title" );
        def.setMetadata( metadata );
        Key<DefinitionType>  defKey = db.save( def );
        Reporter.log( "  @definition _id=" + defKey, true );

        DefinitionType  p_def = db.find( DefinitionType.class ).get();
        Reporter.log( "  @definition=" + p_def, true );
    }



}
// OvalStoreTest

