package jp.go.aist.six.test.oval.example;

import java.io.File;
import java.io.FileInputStream;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.util.xml.XmlMapper;



public class OvalXmlMappingExample
{

    public static void main( final String[] args )
    throws Exception
    {
        XmlMapper  xml_mapper = OvalContext.INSTANCE.getXmlMapper();
        File  file = new File( args[0] );
        Object  oval_obj = xml_mapper.unmarshal( new FileInputStream( file ) );
        System.out.println( oval_obj );
    }

}
//
