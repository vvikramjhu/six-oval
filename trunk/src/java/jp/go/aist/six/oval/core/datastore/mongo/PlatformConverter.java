package jp.go.aist.six.oval.core.datastore.mongo;

import java.util.Arrays;
import java.util.Collection;
import jp.go.aist.six.oval.model.v5.definitions.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class PlatformConverter
    extends TypeConverter
//    implements SimpleValueConverter
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( PlatformConverter.class );



    private static final Class<?>[]  _SUPPORTED_CLASSES_ = new Class[] {
        Platform.class
        };

    public static final Collection<Class<?>>  SUPPORTED_CLASSES = Arrays.asList( _SUPPORTED_CLASSES_ );



    /**
     */
    public PlatformConverter()
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
            Object  obj = new Platform( fromDBObject.toString() );

            return obj;
        }

        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
    }



    @Override
    public Object encode(
                    final Object object,
                    final MappedField optionalExtraInfo
                    )
    {
        if (object == null)
            return null;

        return Platform.class.cast( object ).getName();
    }

}
// PlatformConverter

