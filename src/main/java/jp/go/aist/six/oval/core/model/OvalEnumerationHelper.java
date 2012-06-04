package jp.go.aist.six.oval.core.model;

import java.lang.reflect.Method;
import java.util.HashMap;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.model.OvalEnumeration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * This is a helper functions for the OvalEnumeration.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public final class OvalEnumerationHelper
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalEnumerationHelper.class );


    private static final HashMap<Class<? extends OvalEnumeration>, Method>
    _FROM_VALUE_METHODS_ = new HashMap<Class<? extends OvalEnumeration>, Method>();



    /**
     * Invokes the static fromValue(String) method of the given OvalEnumeration class.
     *
     * @param   type
     *  the concrete OvalEnumeration type.
     * @param   value
     *  the value of the enumeration.
     * @return
     *  the OvalEnumeration instance of the given type and value.
     */
    public static <T extends OvalEnumeration>
    T fromValue(
                    final Class<T> type,
                    final String value
                    )
    throws OvalException
    {
        Object  obj = null;

        Method  method = _FROM_VALUE_METHODS_.get( type );
        try {
            if (method == null) {
                method = type.getMethod( "fromValue", String.class );
                              //throws NoSuchMethodexception
                _FROM_VALUE_METHODS_.put( type, method );
            }
            obj = method.invoke( null, value );
                         //throws IllegalAccessException, InvocationTargetException
        } catch (Exception ex) {
            _LOG_.error( ex.getMessage() );
            throw new OvalException( ex );
        }

        return type.cast( obj );
    }



    /**
     * Invokes the value() method of the given OvalEnumeration instance.
     *
     * @param   obj
     *  the OvalEnumeration instance.
     * @return
     *  the return value of the value() method.
     */
    public static String value(
                    final Object obj
                    )
    throws OvalException
    {
        if (obj == null) {
            return null;
        }

        Class<?>  type = obj.getClass();
        _LOG_.trace( String.valueOf( type ) );
        if (OvalEnumeration.class.isInstance( obj )) {
            OvalEnumeration  e = OvalEnumeration.class.cast( obj );
            return e.value();
        }

        throw new OvalException( "Invalid type: " + type );
//        throw new IllegalArgumentException( "Invalid type: " + type );
    }

}
//

