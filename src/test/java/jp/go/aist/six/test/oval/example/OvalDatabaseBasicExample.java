package jp.go.aist.six.test.oval.example;

import java.net.URL;
import jp.go.aist.six.oval.core.DeprecatedOvalContext;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.util.xml.XmlMapper;



public class OvalDatabaseBasicExample
{

    public static void main( final String[] args )
    throws Exception
    {
        // Unmarshal XML document
        XmlMapper  xml_mapper = DeprecatedOvalContext.getXmlMapper();
        String  network_src = "http://oval.mitre.org/repository/data/DownloadDefinition?id=oval%3aorg.mitre.oval%3adef%3a12541&type=save";
        URL  src_url = new URL( network_src );
        OvalDefinitions  oval_defs = xml_mapper.unmarshal( src_url.openStream(), OvalDefinitions.class );

//        String  local_src = "src/test/resources/oval_test-content/oval-5.9/def/windows/ind-def_family_test.xml";
//        File  src_file = new File( local_src );
//        OvalDefinitions  oval_defs = (OvalDefinitions)xml_mapper.unmarshal( new FileInputStream( src_file ) );

        // Save OVAL Definition document
        OvalDatabase  db = DeprecatedOvalContext.getDatabase();
        String  id = db.save( OvalDefinitions.class, oval_defs );
        System.out.println( "whole OVAL Definitions document is saved: id=" + id );

        // Load the Definitions
        for (DefinitionType  def : oval_defs.getDefinitions().getDefinition()) {
            String  def_id = def.getOvalId();
            System.out.println( "finding Definition: id=" + def_id );
            DefinitionType  p_def = db.findById( DefinitionType.class, def_id );
            System.out.println( p_def );
        }
    }

}
//
