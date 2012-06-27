package jp.go.aist.six.test.oval.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.util.xml.XmlMapper;



public class OvalXmlMappingExample
{

    public static void main( final String[] args )
    throws Exception
    {
        XmlMapper  xml_mapper = OvalContext.getXmlMapper();

        //local file
        String  local_src = "src/test/resources/oval_test-content/oval-5.9/def/windows/ind-def_unknown_test.xml";
        File  src_file = new File( local_src );
        OvalDefinitions  obj1 = xml_mapper.unmarshal( new FileInputStream( src_file ), OvalDefinitions.class );
//        Object  obj1 = xml_mapper.unmarshal( new FileInputStream( src_file ) );
        System.out.println( obj1 );
        xml_mapper.marshal( obj1, System.out );

        //URL
        String  network_src = "http://oval.mitre.org/repository/data/DownloadDefinition?id=oval%3aorg.mitre.oval%3adef%3a12541&type=save";
        URL  src_url = new URL( network_src );
        OvalDefinitions  obj2 = xml_mapper.unmarshal( src_url.openStream(), OvalDefinitions.class );
//        Object  obj2 = xml_mapper.unmarshal( src_url.openStream() );
        System.out.println( obj2 );
        File  dst_file = new File( "oval-def-example.xml" );
        xml_mapper.marshal( obj2, new FileOutputStream( dst_file ) );
    }

}
//
