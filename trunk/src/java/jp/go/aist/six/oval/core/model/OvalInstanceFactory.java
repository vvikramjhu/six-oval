/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jp.go.aist.six.oval.core.model;

import jp.go.aist.six.oval.core.model.definition.OvalDefinitionsDefinitionAssociation;
import jp.go.aist.six.oval.core.model.definition.OvalDefinitionsTestAssociation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.persist.spi.InstanceFactory;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalInstanceFactory.java 440 2010-03-23 05:11:44Z akihito $
 */
public class OvalInstanceFactory
    implements InstanceFactory
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalInstanceFactory.class );



    private Map<String, String>  _types = new HashMap<String, String>();



    /**
     * Constructor.
     */
    public
    OvalInstanceFactory()
    {
//        _init();
    }



    private
    void _init()
    {
        // commons //

        // definitions //
        _types.put( OvalDefinitionsDefinitionAssociation.class.getName(), OvalDefinitionsDefinitionAssociation.class.getName() );
        _types.put( OvalDefinitionsTestAssociation.class.getName(), OvalDefinitionsTestAssociation.class.getName() );

        // system characteristics //
        // results //
    }



    private static final String  _FQCN_PREFIX_ = "jp.go.aist.six.oval.model.";
    private static final String  _IMPL_FQCN_PREFIX_ = "jp.go.aist.six.oval.core.model.";
    private static final String  _IMPL_FQCN_POSTFIX_ = "Impl";


    private
    String _toImplClassName( final String className )
    {
        if (className == null) {
            throw new NullPointerException( "no class name specified" );
        }

        if (! className.startsWith( _FQCN_PREFIX_ )) {
            throw new IllegalArgumentException( "unknown class name: " + className );
        }

        Class<?>  clazz = null;
        try {
            clazz = Class.forName( className );
        } catch (Exception ex) {
            throw new IllegalArgumentException( "unknown class name: " + className );
        }

        if (clazz.isInterface()  ||  Modifier.isAbstract( clazz.getModifiers() )) {
            String  postfix = className.substring( _FQCN_PREFIX_.length() );
            String  implClassName = _IMPL_FQCN_PREFIX_ + postfix + _IMPL_FQCN_POSTFIX_;
            try {
                clazz = Class.forName( implClassName );
            } catch (Exception ex) {
                throw new IllegalArgumentException( "no implementing class found: " + className );
            }

        }

        return clazz.getName();
    }



    public
    Object newInstance( final String className )
    {
        return newInstance( className, null );
    }



    //**************************************************************
    // InstanceFactory
    //**************************************************************

    public
    Object newInstance( final String className, final ClassLoader loader )
    {
        String  implClassName = _toImplClassName( className );

        Object  obj = null;
        try {
            obj = Class.forName( implClassName ).newInstance();
        } catch (Exception ex) {
            // TODO: An appropriate Exception should be thrown.
            throw new RuntimeException( ex );
        }

        return obj;
    }

//    public
//    Object newInstance( final String className, final ClassLoader loader )
//    {
//        String  implClassName = _types.get( className );
//        if (implClassName == null) {
//            implClassName = className;
//        }
//
//      Object  obj = null;
//      try {
//          obj = Class.forName( implClassName ).newInstance();
//      } catch (Exception ex) {
//          // TODO: An appropriate Exception should be thrown.
//          throw new RuntimeException( ex );
//      }
//
//      return obj;
//    }

}
// OvalInstanceFactory
