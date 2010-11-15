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

package jp.go.aist.six.oval.core.model;

import jp.go.aist.six.oval.core.model.definitions.PersistentDefinition;
import jp.go.aist.six.oval.core.model.definitions.PersistentLocalVariable;
import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.definitions.Component;
import jp.go.aist.six.oval.model.definitions.Criteria;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.jdo.Persistent;
import java.util.HashMap;
import java.util.Map;



/**
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class JdoCallbackHandler<T extends Persistent>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( JdoCallbackHandler.class );



    /**
     * Concrete handlers.
     */
    private static Map<Class<? extends Persistent>, JdoCallbackHandler<?>> _createHandlers()
    {
        Map<Class<? extends Persistent>, JdoCallbackHandler<?>>  handlers =
            new HashMap<Class<? extends Persistent>, JdoCallbackHandler<?>>();

        handlers.put( PersistentDefinition.class, new DefinitionCallbackHandler() );
        handlers.put( PersistentLocalVariable.class, new LocalVariableCallbackHandler() );

        return handlers;
    }


    private static Map<Class<? extends Persistent>, JdoCallbackHandler<?>>  _handlers =
        _createHandlers();


    private static <T extends Persistent> JdoCallbackHandler<T> _getHandler(
                    final Class<T> type
                    )
    {
        @SuppressWarnings( "unchecked" )
        JdoCallbackHandler<T>  handler = (JdoCallbackHandler<T>)_handlers.get( type );
        return handler;
    }



    private static OvalXml  _mapper = null;

    protected static OvalXml _getMapper()
    throws Exception
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


    public static <T extends Persistent> Class<T> jdoLoad(
                    final Class<T> type,
                    final T object
                    )
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "***** jdoLoad *****" );
        }

        JdoCallbackHandler<T>  handler = _getHandler( type );
        if (handler == null) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( "INTERNAL ERROR: handler NOT found, type="
                                + type.getName()  );
            }
            return type;
        }

        handler.jdoLoad( object );

        return type;
    }



    public static <T extends Persistent> void jdoBeforeCreate(
                    final Class<T> type,
                    final T object
                    )
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "***** jdoBeforeCreate *****" );
        }

        JdoCallbackHandler<T>  handler = _getHandler( type );
        if (handler == null) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( "INTERNAL ERROR: handler NOT found, type="
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
    extends JdoCallbackHandler<PersistentDefinition>
    {

        @Override
        public Class<PersistentDefinition> jdoLoad(
                        final PersistentDefinition object
                        )
        {
            String  xml = object.xmlGetCriteria();
            if (xml != null) {
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "criteria (XML)=" + xml );
                }

                try {
                    Criteria  criteria = (Criteria)_getMapper().unmarshalFromString( xml );
                    object.setCriteria( criteria );
                    if (_LOG.isTraceEnabled()) {
                        _LOG.trace( "criteria (Object)=" + criteria );
                    }
                } catch (Exception ex) {
                    if (_LOG.isErrorEnabled()) {
                        _LOG.error( ex.getMessage() );
                    }
                }
            }

            return PersistentDefinition.class;
        }


        @Override
        public void jdoBeforeCreate(
                        final PersistentDefinition object
                        )
        {
            Criteria  criteria = object.getCriteria();
            if (criteria != null) {
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "criteria (Object)=" + criteria );
                }

                try {
                    String  xml = _getMapper().marshalToString( criteria );
                    object.xmlSetCriteria( xml );
                    if (_LOG.isTraceEnabled()) {
                        _LOG.trace( "criteria (XML)=" + xml );
                    }
                } catch (Exception ex) {
                    if (_LOG.isErrorEnabled()) {
                        _LOG.error( ex.getMessage() );
                    }
                }
            }
        }
    }



    private static class LocalVariableCallbackHandler
    extends JdoCallbackHandler<PersistentLocalVariable>
    {

        @Override
        public Class<PersistentLocalVariable> jdoLoad(
                        final PersistentLocalVariable object
                        )
        {
            String  xml = object.xmlGetComponent();
            if (xml != null) {
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "component (XML)=" + xml );
                }

                try {
                    Component  component = (Component)_getMapper().unmarshalFromString( xml );
                    object.setComponent( component );
                    if (_LOG.isTraceEnabled()) {
                        _LOG.trace( "component (Object)=" + component );
                    }
                } catch (Exception ex) {
                    if (_LOG.isErrorEnabled()) {
                        _LOG.error( ex.getMessage() );
                    }
                }
            }

            return PersistentLocalVariable.class;
        }


        @Override
        public void jdoBeforeCreate(
                        final PersistentLocalVariable object
                        )
        {
            Component  component = object.getComponent();
            if (component != null) {
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "component (Object)=" + component );
                }

                try {
                    String  xml = _getMapper().marshalToString( component );
                    object.xmlSetComponent( xml );
                    if (_LOG.isTraceEnabled()) {
                        _LOG.trace( "component (XML)=" + xml );
                    }
                } catch (Exception ex) {
                    if (_LOG.isErrorEnabled()) {
                        _LOG.error( ex.getMessage() );
                    }
                }
            }
        }
    }

}
// JdoCallbackHandler
