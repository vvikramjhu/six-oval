/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

package jp.go.aist.six.oval.core.store.v5;

import java.util.HashMap;
import java.util.Map;
import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.v5.definitions.ComponentGroup;
import jp.go.aist.six.oval.model.v5.definitions.CriteriaType;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.LocalVariable;
import jp.go.aist.six.util.persist.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class JdoCallbackHandler<K, T extends Persistable<K>>
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( JdoCallbackHandler.class );



    /**
     * Concrete handlers.
     */
    private static Map<Class<? extends Persistable<?>>, JdoCallbackHandler<?, ?>> _createHandlers()
    {
        Map<Class<? extends Persistable<?>>, JdoCallbackHandler<?, ?>>  handlers =
            new HashMap<Class<? extends Persistable<?>>, JdoCallbackHandler<?, ?>>();

        JdoCallbackHandler<String, DefinitionType>  definitionHandler = new DefinitionCallbackHandler();
        handlers.put( DefinitionType.class, definitionHandler );

        JdoCallbackHandler<String, LocalVariable>  localVariableHandler = new LocalVariableCallbackHandler();
        handlers.put( LocalVariable.class, localVariableHandler );

        return handlers;
    }


    private static Map<Class<? extends Persistable<?>>, JdoCallbackHandler<?, ?>>  _handlers =
        _createHandlers();


    private static <K, T extends Persistable<K>> JdoCallbackHandler<K, T> _getHandler(
                    final Class<T> type
                    )
    {
        @SuppressWarnings( "unchecked" )
        JdoCallbackHandler<K, T>  handler = (JdoCallbackHandler<K, T>)_handlers.get( type );
        return handler;
    }



    private static OvalXml  _mapper = null;

    protected static OvalXml _getMapper()
    {
        if (_mapper == null) {
            _mapper = OvalContext.INSTANCE.getXml();
        }

        return _mapper;
    }




//    private Class<T>  _type;



    /**
     * Constructor.
     */
    protected JdoCallbackHandler()
    {
    }


//    /**
//     * Constructor.
//     */
//    protected JdoCallbackHandler(
//                    final Class<T> type
//                    )
//    {
//        setType( type );
//    }
//
//
//
//    /**
//     */
//    public void setType( final Class<T> type )
//    {
//        _type = type;
//    }


    public static <K, T extends Persistable<K>> Class<T> jdoLoad(
                    final Class<T> type,
                    final T object
                    )
    {
        if (_LOG_.isTraceEnabled()) {
            _LOG_.trace( "***** jdoLoad *****" );
        }

        JdoCallbackHandler<K, T>  handler = _getHandler( type );
        if (handler == null) {
            if (_LOG_.isErrorEnabled()) {
                _LOG_.error( "INTERNAL ERROR: handler NOT found, type="
                                + type.getName()  );
            }
            return type;
        }

        handler.jdoLoad( object );

        return type;
    }



    public static <K, T extends Persistable<K>> void jdoBeforeCreate(
                    final Class<T> type,
                    final T object
                    )
    {
        if (_LOG_.isTraceEnabled()) {
            _LOG_.trace( "***** jdoBeforeCreate *****" );
        }

        JdoCallbackHandler<K, T>  handler = _getHandler( type );
        if (handler == null) {
            if (_LOG_.isErrorEnabled()) {
                _LOG_.error( "INTERNAL ERROR: handler NOT found, type="
                                + type.getName()  );
            }
            return;
        }

        handler.jdoBeforeCreate( object );
    }



    //**************************************************************
    //  Persistent
    //**************************************************************

//    public void jdoPersistent( final Database db ) { }
//
//    public void jdoTransient() { }
//
//    public Class<?> jdoLoad( final AccessMode accessMode ) { return null; }
//
//    public void jdoBeforeCreate( final Database db ) { }
//
//    public void jdoAfterCreate() { }
//
//    public void jdoStore( final boolean modified ) { }
//
//    public void jdoBeforeRemove() { }
//
//    public void jdoAfterRemove() { }
//
//    public void jdoUpdate() { }


    public Class<T> jdoLoad( final T object ) { return null; }

    public void jdoBeforeCreate( final T object ) { }



    //**************************************************************
    //  Handlers
    //**************************************************************

    private static class DefinitionCallbackHandler
    extends JdoCallbackHandler<String, DefinitionType>
    {

        @Override
        public Class<DefinitionType> jdoLoad(
                        final DefinitionType object
                        )
        {
            String  xml = object.xmlGetCriteria();
            if (xml != null) {
//                if (_LOG.isTraceEnabled()) {
//                    _LOG.trace( "criteria (XML)=" + xml );
//                }

                try {
                    CriteriaType  criteria = (CriteriaType)_getMapper().unmarshalFromString( xml );
                    object.setCriteria( criteria );
//                    if (_LOG.isTraceEnabled()) {
//                        _LOG.trace( "criteria (Object)=" + criteria );
//                    }
                } catch (Exception ex) {
                    if (_LOG_.isErrorEnabled()) {
                        _LOG_.error( ex.getMessage() );
                    }
                }
            }

            return DefinitionType.class;
        }


        @Override
        public void jdoBeforeCreate(
                        final DefinitionType object
                        )
        {
            CriteriaType  criteria = object.getCriteria();
            if (criteria != null) {
//                if (_LOG.isTraceEnabled()) {
//                    _LOG.trace( "criteria (Object)=" + criteria );
//                }

                try {
                    String  xml = _getMapper().marshalToString( criteria );
                    object.xmlSetCriteria( xml );
//                    if (_LOG.isTraceEnabled()) {
//                        _LOG.trace( "criteria (XML)=" + xml );
//                    }
                } catch (Exception ex) {
                    if (_LOG_.isErrorEnabled()) {
                        _LOG_.error( ex.getMessage() );
                    }
                }
            }
        }
    }



    private static class LocalVariableCallbackHandler
    extends JdoCallbackHandler<String, LocalVariable>
    {

        @Override
        public Class<LocalVariable> jdoLoad(
                        final LocalVariable object
                        )
        {
            if (! LocalVariable.class.isInstance( object )) {
                return LocalVariable.class;
            }

            String  xml = object.xmlGetComponent();
            if (xml != null) {
//                if (_LOG.isTraceEnabled()) {
//                    _LOG.trace( "component (XML)=" + xml );
//                }

                try {
                    ComponentGroup  component =
                        (ComponentGroup)_getMapper().unmarshalFromString( xml );
                    object.setComponent( component );
//                    if (_LOG.isTraceEnabled()) {
//                        _LOG.trace( "component (Object)=" + component );
//                    }
                } catch (Exception ex) {
                    if (_LOG_.isErrorEnabled()) {
                        _LOG_.error( ex.getMessage() );
                    }
                }
            }

            return LocalVariable.class;
        }


        @Override
        public void jdoBeforeCreate(
                        final LocalVariable object
                        )
        {
            if (! LocalVariable.class.isInstance( object )) {
                return;
            }

            ComponentGroup  component = object.getComponent();
            if (component != null) {
//                if (_LOG.isTraceEnabled()) {
//                    _LOG.trace( "component (Object)=" + component );
//                }

                try {
                    String  xml = _getMapper().marshalToString( component );
                    object.xmlSetComponent( xml );
//                    if (_LOG.isTraceEnabled()) {
//                        _LOG.trace( "component (XML)=" + xml );
//                    }
                } catch (Exception ex) {
                    if (_LOG_.isErrorEnabled()) {
                        _LOG_.error( ex.getMessage() );
                    }
                }
            }
        }
    }

}
// JdoCallbackHandler