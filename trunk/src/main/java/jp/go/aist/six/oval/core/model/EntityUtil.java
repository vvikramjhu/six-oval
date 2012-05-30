package jp.go.aist.six.oval.core.model;

import java.lang.reflect.Method;
import java.util.HashMap;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.model.OvalEnumeration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
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
     */
    public static <T extends OvalEnumeration> T fromValue(
                    final Class<T> type,
                    final String value
                    )
    {
        T  obj = null;

        Method  method = _FROM_VALUE_METHODS_.get( type );
        try {
            if (method == null) {
                method = type.getMethod( "fromValue", String.class );
                              //throws NoSuchMethodexception
                _FROM_VALUE_METHODS_.put( type, method );
            }
            obj = type.cast( method.invoke( null, value ) );
                                    //throws IllegalAccessException, InvocationTargetException
        } catch (Exception ex) {
            _LOG_.error( ex.getMessage() );
            throw new OvalException( ex );
        }

        return obj;
    }



    /**
     */
    public static String value(
                    final Object object
                    )
    {
        if (object == null) {
            return null;
        }

        Class<?>  type = object.getClass();
        _LOG_.trace( String.valueOf( type ) );
        if (OvalEnumeration.class.isAssignableFrom( type )) {
            OvalEnumeration  e = OvalEnumeration.class.cast( object );
            return e.value();
        }

        throw new IllegalArgumentException( "Invalid type: " + String.valueOf( type ) );
    }

}
//

