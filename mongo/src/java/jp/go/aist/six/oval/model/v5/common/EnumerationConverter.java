package jp.go.aist.six.oval.model.v5.common;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class EnumerationConverter
    extends TypeConverter
//    implements SimpleValueConverter
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( EnumerationConverter.class );



    /**
     */
    public EnumerationConverter()
    {
        super( new Class[] { FamilyEnumeration.class } );
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

        if (targetClass == FamilyEnumeration.class) {
            Object  obj = null;

            //reflection
            try {
                @SuppressWarnings( "unchecked" )
                Method  method = targetClass.getMethod( "fromValue", String.class );
                obj = method.invoke( null, fromDBObject.toString() );
            } catch (Exception ex) {
                throw new MappingException( ex.getMessage() );
            }

            return obj;
        }

        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );


//        return FamilyEnumeration.valueOf( fromDBObject.toString() );
    }



    @Override
    public Object encode(
                    final Object value,
                    final MappedField optionalExtraInfo
                    )
    {
        if (value == null)
            return null;

        return ((FamilyEnumeration)value).value();
    }

}
//

