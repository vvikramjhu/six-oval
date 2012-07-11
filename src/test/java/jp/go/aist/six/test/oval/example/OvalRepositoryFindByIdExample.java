package jp.go.aist.six.test.oval.example;

import jp.go.aist.six.oval.core.OvalContext2;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.repository.OvalRepository;



public class OvalRepositoryFindByIdExample
{

    public static void main( final String[] args )
    throws Exception
    {
        // Find Definition by ID
        String  def_id = "oval:org.mitre.oval.test:def:165";
        System.out.println( "*** finding Definition: " + def_id );
        OvalRepository  repository = OvalContext2.REMOTE.getRepository();
        DefinitionType  def = repository.findDefinitionById( def_id );
        System.out.println( "*** found Definition: " + def );

        // Find the Tests and Definitions referred from the above Definition
        System.out.println( "*** finding referred elements" );
        for (ElementRef  ref : def.ovalGetElementRef()) {
            String  ref_id = ref.ovalGetRefId();
            System.out.println( "*** finding element: id=" + ref_id );
            DefinitionsElement  element = repository.findElementById( ref_id );
            System.out.println( "*** found element: " + element );
        }
    }

}
//
