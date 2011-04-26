package jp.go.aist.six.oval.core.store.mongo;

import jp.go.aist.six.oval.model.v5.NameEntity;
import jp.go.aist.six.oval.model.v5.common.DefinitionClassEnumeration;
import jp.go.aist.six.oval.model.v5.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.v5.definitions.Platform;
import jp.go.aist.six.oval.model.v5.definitions.Product;
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
public class OvalConverter
    extends TypeConverter
    implements SimpleValueConverter
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalConverter.class );



    private static final Class<?>[]  _SUPPORTED_CLASSES_ = new Class[] {
        DefinitionClassEnumeration.class,
        FamilyEnumeration.class,
        Platform.class,
        Product.class
        };

//    public static final Collection<Class<?>>  SUPPORTED_CLASSES = Arrays.asList( _SUPPORTED_CLASSES_ );



    /**
     */
    public OvalConverter()
    {
        super( _SUPPORTED_CLASSES_ );
    }



    @Override
    public Object encode(
                    final Object object,
                    final MappedField optionalExtraInfo
                    )
    throws MappingException
    {
        if (object == null)
            return null;

        if (object instanceof DefinitionClassEnumeration) {
            return DefinitionClassEnumeration.class.cast( object ).getName();
        } else if (object instanceof FamilyEnumeration) {
            return FamilyEnumeration.class.cast( object ).value();
        } else if (object instanceof NameEntity) {
            return NameEntity.class.cast( object ).getName();
        }

        throw new MappingException( "unsupported type: " + String.valueOf( object ) );
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

        if (DefinitionClassEnumeration.class == targetClass ) {
            return DefinitionClassEnumeration.valueOf( fromDBObject.toString() );
        } else if (FamilyEnumeration.class == targetClass ) {
            return FamilyEnumeration.fromValue( fromDBObject.toString() );
        } else if (Platform.class == targetClass ) {
            return new Platform( fromDBObject.toString() );
        } else if (Product.class == targetClass ) {
            return new Product( fromDBObject.toString() );
        }

        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
    }

}
// OvalConverter

