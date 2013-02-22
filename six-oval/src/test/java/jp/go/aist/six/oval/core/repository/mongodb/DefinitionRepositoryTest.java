package jp.go.aist.six.oval.core.repository.mongodb;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="classpath:jp/go/aist/six/oval/core/six-oval_context-server.xml" )
public class DefinitionRepositoryTest
{

    @Autowired
    private DefinitionRepository  _repository;


//    @Test
//    public void testFindOneID()
//    {
//        String  id = "oval:org.mitre.oval:def:12541";
//        System.out.println( "finding by ID=" + id );
//        DefinitionType  obj = _repository.findOne( id );
//        System.out.println( "definition=" + obj );
//    }

}
