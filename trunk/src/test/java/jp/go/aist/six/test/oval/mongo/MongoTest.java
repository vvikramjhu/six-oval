package jp.go.aist.six.test.oval.mongo;

import jp.go.aist.six.oval.model.v5.common.DefinitionClassEnumeration;
import jp.go.aist.six.oval.model.v5.common.EnumerationConverter;
import jp.go.aist.six.oval.model.v5.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.v5.definitions.AffectedType;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.MetadataType;
import jp.go.aist.six.oval.model.v5.definitions.Platform;
import jp.go.aist.six.oval.model.v5.definitions.Product;
import jp.go.aist.six.oval.model.v5.definitions.ReferenceType;
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

        DefinitionType  def = new DefinitionType( "oval:org.mitre.oval:def:8500", 1 );
        def.setDefinitionClass( DefinitionClassEnumeration.VULNERABILITY );
//        def.setFamily( FamilyEnumeration.WINDOWS );
        MetadataType  metadata = new MetadataType();
        def.setMetadata( metadata );
        metadata.setTitle( "MySQL 5.0 and 5.1 SELECT Statement DOS Vulnerability" );
        metadata.reference( new ReferenceType( "CVE", "CVE-2009-4019", "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2009-4019") );
        metadata.reference( new ReferenceType( "foo", "bar", "http://foo.bar/baz") );
        AffectedType  affected = new AffectedType();
        metadata.setAffected( affected );
        affected.setFamily( FamilyEnumeration.WINDOWS );
        affected.platform( new Platform( "Microsoft Windows 2000" ) );
        affected.platform( new Platform( "Microsoft Windows XP" ) );
        affected.platform( new Platform( "Microsoft Windows Server 2003" ) );
        affected.product( new Product( "MySQL Server 5.0" ) );
        affected.product( new Product( "MySQL Server 5.1" ) );

        Key<DefinitionType>  defKey = db.save( def );
        Reporter.log( "  @definition _id=" + defKey, true );

        DefinitionType  p_def = db.find( DefinitionType.class ).get();
        Reporter.log( "  @definition=" + p_def, true );
    }



}
// OvalStoreTest

