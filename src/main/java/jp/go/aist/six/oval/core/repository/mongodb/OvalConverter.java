package jp.go.aist.six.oval.core.repository.mongodb;

import java.lang.reflect.Method;
import java.util.HashMap;
import jp.go.aist.six.oval.model.Oval5Enumeration;
import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.common.ExistenceEnumeration;
import jp.go.aist.six.oval.model.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.common.MessageLevelEnumeration;
import jp.go.aist.six.oval.model.common.OperationEnumeration;
import jp.go.aist.six.oval.model.common.OperatorEnumeration;
import jp.go.aist.six.oval.model.v5.definitions.FilterActionEnumeration;
import jp.go.aist.six.oval.model.v5.mitre.DefinitionStatusEnumeration;
import jp.go.aist.six.oval.model.v5.results.ContentEnumeration;
import jp.go.aist.six.oval.model.v5.results.ResultEnumeration;
import jp.go.aist.six.oval.model.v5.sc.FlagEnumeration;
import jp.go.aist.six.oval.model.v5.sc.StatusEnumeration;
import jp.go.aist.six.oval.model.v5.windows.FileTypeEnumeration;
import jp.go.aist.six.oval.model.v5.windows.RegistryTypeEnumeration;
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
        //commons
        CheckEnumeration.class,
        ClassEnumeration.class,
        DatatypeEnumeration.class,
        ExistenceEnumeration.class,
        FamilyEnumeration.class,
        MessageLevelEnumeration.class,
        OperationEnumeration.class,
        OperatorEnumeration.class,

        //definitions
        FilterActionEnumeration.class,

        //mitre
        DefinitionStatusEnumeration.class,

        // results
        ContentEnumeration.class,
        ResultEnumeration.class,

        // sc
        FlagEnumeration.class,
        StatusEnumeration.class,

        //windows
        FileTypeEnumeration.class,
        RegistryTypeEnumeration.class

//        Platform.class,
//        Product.class
        };

//    public static final Collection<Class<?>>  SUPPORTED_CLASSES =
//    Arrays.asList( _SUPPORTED_CLASSES_ );



    //**************************************************************
    //  supporting OvalEnumeration
    //**************************************************************

    private static final HashMap<Class<? extends Oval5Enumeration>, Method>
    _VALUE_OF_METHODS_ = new HashMap<Class<? extends Oval5Enumeration>, Method>();

//    private static final HashMap<Class<? extends OvalEnumeration>, Method>
//    _VALUE_METHODS_ = new HashMap<Class<? extends OvalEnumeration>, Method>();

    /**
     */
    public static Object enumerationFromValue(
                    final Class<? extends Oval5Enumeration> targetClass,
                    final String value
                    )
    {
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
    }



    /**
     */
    public static Object enumerationValue(
                    final Object object
                    )
    {
        if (object == null)
            return null;

        Class<?>  targetClass = object.getClass();
        if (! Oval5Enumeration.class.isAssignableFrom( targetClass )) {
            throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
        }

        Object  value = null;
        try {
            Oval5Enumeration  e = Oval5Enumeration.class.cast( object );
            value = e.value();
        } catch (ClassCastException ex) {
            throw new MappingException( ex.getMessage() );
        }

        return value;
    }



//    //**************************************************************
//    //  supporting NameEntity
//    //**************************************************************
//
//    /**
//     */
//    public static Object nameFromValue(
//                    final Class<? extends NameEntity> targetClass,
//                    final String name
//                    )
//    {
//        NameEntity  obj = null;
//
//        try {
//            obj = targetClass.newInstance();
//        } catch (Exception ex) {
//            _LOG_.error( ex.getMessage() );
//            throw new MappingException( ex.getMessage() );
//        }
//
//        obj.setName( name );
//        return obj;
//    }



    /**
     * Constructor.
     */
    public OvalConverter()
    {
        super( _SUPPORTED_CLASSES_ );
    }



    // Object (Java) --> simple value (Mongo)
    @Override
    public Object encode(
                    final Object object,
                    final MappedField optionalExtraInfo
                    )
    throws MappingException
    {
        if (object == null) {
            return null;
        }

        if (object instanceof Oval5Enumeration) {
            return enumerationValue( object );
//        } else if (object instanceof NameEntity) {
//            return NameEntity.class.cast( object ).getName();
        }

        throw new MappingException( "unsupported type: "
                        + String.valueOf( object ) );
    }



    // simple value (Mongo) --> Object (Java)
    @SuppressWarnings( "rawtypes" )
    @Override
    public Object decode(
                    final Class targetClass,
                    final Object fromDBObject,
                    final MappedField optionalExtraInfo
                    )
    throws MappingException
    {
        _LOG_.trace( "target class: " + targetClass );
        if (fromDBObject == null) {
            return null;
        }

        if (Oval5Enumeration.class.isAssignableFrom( targetClass )) {
            @SuppressWarnings( "unchecked" )
            Class<? extends Oval5Enumeration>  enumClass =
                targetClass.asSubclass( Oval5Enumeration.class );
            return enumerationFromValue( enumClass, fromDBObject.toString() );

//        } else if (NameEntity.class.isAssignableFrom( targetClass )) {
//            @SuppressWarnings( "unchecked" )
//            Class<? extends NameEntity>  nameClass =
//                targetClass.asSubclass( NameEntity.class );
//            return nameFromValue( nameClass, fromDBObject.toString() );
        }

        throw new MappingException( "unsupported type: "
                        + String.valueOf( targetClass ) );
    }

}
// OvalConverter

