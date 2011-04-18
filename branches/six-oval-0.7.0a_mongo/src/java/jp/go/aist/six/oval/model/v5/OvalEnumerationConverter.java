package jp.go.aist.six.oval.model.v5;

import jp.go.aist.six.oval.model.v5.common.FamilyEnumeration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalEnumerationConverter
    extends TypeConverter
    implements SimpleValueConverter
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalEnumerationConverter.class );



    /**
     */
    public OvalEnumerationConverter()
    {
        super( new Class[] {
//                        DefinitionClassEnumeration.class,
                        FamilyEnumeration.class
                        } );
    }



    @SuppressWarnings( "rawtypes" )
    @Override
    public Object decode(
                    final Class targetClass,
                    final Object fromDBObject,
                    final MappedField optionalExtraInfo
                    )
    throws MappingException
    {
        _LOG_.info( "target class: " + targetClass );
        if (fromDBObject == null) return null;

//        if (OvalEnumeration.class.isAssignableFrom( targetClass )) {
            Object  obj = OvalEnumeration.valueOf( targetClass, fromDBObject.toString() );
            return obj;
//        }

//        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
    }



    @Override
    public Object encode(
                    final Object value,
                    final MappedField optionalExtraInfo
                    )
    {
        if (value == null)
            return null;

        return ((OvalEnumeration)value).value();
    }

}
// OvalEnumerationConverter

