package jp.go.aist.six.oval.core.repository.mongodb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.util.xml.XmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="classpath:jp/go/aist/six/oval/core/six-oval_context-server.xml" )
public class DefinitionRepositoryTest
{

    @Autowired
    private XmlMapper  _xml_mapper;

    @Autowired
    private DefinitionRepository  _repository;


    @Test
    public void testFindOneID()
                    throws FileNotFoundException
    {
        String  filepath = "src/test/resources/data/oval5/mitre/oval-5.10-12541-3_i_Windows7.xml";
        OvalDefinitions  oval_definitions =
                        _xml_mapper.unmarshal( new FileInputStream( new File( filepath ) ), OvalDefinitions.class );

        for (DefinitionType  def : oval_definitions.getDefinitions().getDefinition()) {
            System.out.println( "saving OVAL Definition: " + def.getOvalId() );
            _repository.save( def );
        }
    }


//    @Test
//    public void testFindOneID()
//    {
//        String  id = "oval:org.mitre.oval:def:12541";
//        System.out.println( "finding by ID=" + id );
//        DefinitionType  obj = _repository.findOne( id );
//        System.out.println( "definition=" + obj );
//    }

}
