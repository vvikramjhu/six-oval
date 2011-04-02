package jp.go.aist.six.oval.model.v5.common;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
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



    private static final Class<?>[]  _SUPPORTED_CLASSES_ = new Class[] {
        OperationEnumeration.class,
        DefinitionClassEnumeration.class,
        FamilyEnumeration.class
        };

    public static final Collection<Class<?>>  SUPPORTED_CLASSES = Arrays.asList( _SUPPORTED_CLASSES_ );


    private static final HashMap<Class<?>, Method>  _VALUE_OF_METHODS_ = new HashMap<Class<?>, Method>();

    private static final HashMap<Class<?>, Method>  _VALUE_METHODS_ = new HashMap<Class<?>, Method>();



    /**
     */
    public static Object fromValue(
                    final Class<?> targetClass,
                    final String value
                    )
    {
//        if (OvalEnumeration.class.isAssignableFrom( targetClass )) {
            Object  obj = null;

            Method  method = _VALUE_OF_METHODS_.get( targetClass );
            try {
                if (method == null) {
                    //reflection
                    method = targetClass.getMethod( "fromValue", String.class );
                    _VALUE_OF_METHODS_.put( targetClass, method );
                }
                obj = method.invoke( null, value );
            } catch (Exception ex) {
                _LOG_.error( ex.getMessage() );
                throw new MappingException( ex.getMessage() );
            }

            return obj;
//        }

//        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
    }



    public static Object value(
                    final Object object
                    )
    {
        if (object == null)
            return null;

        Class<?>  targetClass = object.getClass();
        if (SUPPORTED_CLASSES.contains( targetClass )) {
            Method  method = _VALUE_METHODS_.get( targetClass );
            Object  value = null;
            try {
                if (method == null) {
                    //reflection
                    method = targetClass.getMethod( "value", new Class<?>[] {} );
                    _VALUE_METHODS_.put( targetClass, method );
                }
                value = method.invoke( object, new Object[] {} );
            } catch (Exception ex) {
                throw new MappingException( ex.getMessage() );
            }

            return value;
        }

        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
    }



    /**
     */
    public EnumerationConverter()
    {
        super( _SUPPORTED_CLASSES_ );
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
        if (fromDBObject == null) {
            return null;
        }

        if (SUPPORTED_CLASSES.contains( targetClass )) {
            Object  obj = fromValue( targetClass, fromDBObject.toString() );

            return obj;
        }

        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
    }
//    {
//        _LOG_.info( "target class: " + targetClass );
//        if (fromDBObject == null) return null;
//
//        if (targetClass == FamilyEnumeration.class) {
//            Object  obj = null;
//
//            //reflection
//            try {
//                @SuppressWarnings( "unchecked" )
//                Method  method = targetClass.getMethod( "fromValue", String.class );
//                obj = method.invoke( null, fromDBObject.toString() );
//            } catch (Exception ex) {
//                throw new MappingException( ex.getMessage() );
//            }
//
//            return obj;
//        }
//
//        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
//
//
////        return FamilyEnumeration.valueOf( fromDBObject.toString() );
//    }



    @Override
    public Object encode(
                    final Object object,
                    final MappedField optionalExtraInfo
                    )
    {
        if (object == null)
            return null;

        return value( object );
    }

}
//

