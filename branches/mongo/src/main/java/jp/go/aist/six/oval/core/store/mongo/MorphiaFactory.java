package jp.go.aist.six.oval.core.store.mongo;

import java.util.Set;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.converters.DefaultConverters;
import com.google.code.morphia.converters.TypeConverter;



public class MorphiaFactory
{

    @SuppressWarnings( "rawtypes" )
    public static Morphia create(
                    final Set<Class> classesToMap
                    )
    {
        return create( classesToMap, null );
    }



	@SuppressWarnings( "rawtypes" )
    public static Morphia create(
	                final Set<Class> classesToMap,
	                final Set<Class<? extends TypeConverter>> converters
	                )
	{
        Morphia  morphia = new Morphia( classesToMap );

        if (converters != null  &&  converters.size() > 0) {
            DefaultConverters  defaultConverters = morphia.getMapper().getConverters();
            for (Class<? extends TypeConverter>  converter : converters) {
                defaultConverters.addConverter( converter );
            }
        }

        return morphia;
	}

}
// MorphiaFactory
