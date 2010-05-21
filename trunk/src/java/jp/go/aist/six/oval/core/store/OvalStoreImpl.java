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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.State;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalStore;
import jp.go.aist.six.util.castor.CastorDataStore;
import jp.go.aist.six.util.orm.Persistable;
import jp.go.aist.six.util.search.Order;
import jp.go.aist.six.util.search.RelationalBinding;
import jp.go.aist.six.util.search.SearchCriteria;
import jp.go.aist.six.util.search.SearchResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;



/**
 * An OVAL data store service implementation.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalStoreImpl.java 754 2010-05-10 05:26:45Z akihito $
 */
public class OvalStoreImpl
extends CastorDataStore
implements OvalStore
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalStoreImpl.class );



    /**
     * Constructor.
     */
    public OvalStoreImpl()
    {
    }



    private <T extends Persistable> T _findOvalObject(
                    final Class<T> type,
                    final String pid
                    )
    {
        final String  typeName = type.getName();

        long  elapsed_time = 0L;
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "TX begin: find - " + typeName );
            elapsed_time = System.currentTimeMillis();
        }

        TransactionTemplate  tx_template = new TransactionTemplate( getTransactionManager() );
        tx_template.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );

        @SuppressWarnings( "unchecked" )
        T  obj =
        (T)tx_template.execute( new TransactionCallback() {
                public Object doInTransaction( TransactionStatus status )
                {
                    return find( type, pid );
                }
            });

        if (_LOG.isDebugEnabled()) {
            elapsed_time = System.currentTimeMillis() - elapsed_time;
            _LOG.debug( "TX end: find - " + typeName + ": elapsed time=" + elapsed_time );
        }

        return obj;
    }



    private <T extends Persistable> String _createOvalObject(
                    final Class<T> type,
                    final T obj
                    )
    {
        final String  typeName = type.getName();

        long  elapsed_time = 0L;
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "TX begin: create - " + typeName );
            elapsed_time = System.currentTimeMillis();
        }

        TransactionTemplate  tx_template = new TransactionTemplate( getTransactionManager() );
        tx_template.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );

        @SuppressWarnings( "unchecked" )
        String  pid =
        (String)tx_template.execute( new TransactionCallback() {
                public Object doInTransaction( TransactionStatus status )
                {
                    return create( type, obj );
                }
            });

        if (_LOG.isDebugEnabled()) {
            elapsed_time = System.currentTimeMillis() - elapsed_time;
            _LOG.debug( "TX end: create - " + typeName + ": elapsed time=" + elapsed_time );
        }

        return pid;
    }



    private <T extends OvalEntity> T _sync(
                    final Class<T> type,
                    final T object
                    )
    {
        final String  typeName = type.getName();

        long  elapsed_time = 0L;
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "TX begin: sync - " + typeName );
            elapsed_time = System.currentTimeMillis();
        }

        TransactionTemplate  tx_template = new TransactionTemplate( getTransactionManager() );
        tx_template.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );

        @SuppressWarnings( "unchecked" )
        T  p_object =
        (T)tx_template.execute( new TransactionCallback() {
                public Object doInTransaction( TransactionStatus status )
                {
                    return sync( type, object );
                }
            });

        if (_LOG.isDebugEnabled()) {
            elapsed_time = System.currentTimeMillis() - elapsed_time;
            _LOG.debug( "TX end: sync - " + typeName + ": elapsed time=" + elapsed_time );
        }

        return p_object;
    }



    @SuppressWarnings( "unchecked" )
    private <T extends OvalEntity> Class<T> _getType(
                    final T object
                    )
    {
        if (object == null) {
            throw new IllegalArgumentException( "null object" );
        }

        if (Definition.class.isInstance( object )) {
            return (Class<T>)Definition.class;
        } else if (Test.class.isInstance( object )) {
            return (Class<T>)Test.class;
        } else if (SystemObject.class.isInstance( object )) {
            return (Class<T>)SystemObject.class;
        } else if (State.class.isInstance( object )) {
            return (Class<T>)State.class;
        }

        throw new IllegalArgumentException(
                        "unsupported object type: " + object.getClass().getName() );
    }

//    private Class<? extends OvalEntity> _getType1(
//                    final OvalEntity object
//                    )
//    {
//        if (object == null) {
//            throw new IllegalArgumentException( "null object" );
//        }
//
//        Class<? extends OvalEntity>  type = object.getClass();
//        if (Test.class.isAssignableFrom( type )) {
//            return Test.class;
//        }
//
//        throw new IllegalArgumentException(
//                        "unsupported object type: " + type.getName() );
//    }



    //**************************************************************
    // OvalStore
    //**************************************************************

    public <T extends OvalEntity> T sync(
                    final T object
                    )
    {
        Class<T>  type = _getType( object );
        return _sync( type, object );
//        return _sync( _getType1( object ), object );
    }



    //==============================================================
    //  OvalResults
    //==============================================================

    public OvalResults findResults(
                    final String pid
                    )
    {
        return _findOvalObject( OvalResults.class, pid );
    }



    public String createOvalResults(
                    final OvalResults results
                    )
    {
        return _createOvalObject( OvalResults.class, results );

//        long  elapsed_time = 0L;
//        if (_LOG.isDebugEnabled()) {
//            _LOG.debug( "TX begin: create OVAL Results" );
//            elapsed_time = System.currentTimeMillis();
//        }
//
//        TransactionTemplate  tx_template = new TransactionTemplate( _txManager );
//        tx_template.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );
//
//
//        @SuppressWarnings( "unchecked" )
//        String  pid =
//        (String)tx_template.execute( new TransactionCallback() {
//                public Object doInTransaction( TransactionStatus status )
//                {
//                    return create( OvalResults.class, results );
//                }
//            });
//
//        if (_LOG.isDebugEnabled()) {
//            elapsed_time = System.currentTimeMillis() - elapsed_time;
//            _LOG.debug( "TX end: create OVAL Results: elapsed time=" + elapsed_time );
//        }
//
//        return pid;
    }



    //==============================================================
    //  OvalSystemCharacteristics
    //==============================================================

    public OvalSystemCharacteristics findSystemCharacteristics(
                    final String pid
                    )
    {
        return _findOvalObject( OvalSystemCharacteristics.class, pid );
    }



    public String createSystemCharacteristics(
                    final OvalSystemCharacteristics sc
                    )
    {
        return _createOvalObject( OvalSystemCharacteristics.class, sc );
    }




    //==============================================================
    //  OvalDefinitions
    //==============================================================

    public String createOvalDefinitions(
                    final OvalDefinitions defs
                    )
    {
        return _createOvalObject( OvalDefinitions.class, defs );
    }



    public Definition findDefinition(
                    final String id
                    )
    {
        final Class<? extends Persistable>  type = Definition.class;
        final SearchCriteria  criteria = new SearchCriteria();
        criteria.setBinding( RelationalBinding.equalBinding( "ovalID", id )
                        ).addOrder( new Order( "ovalVersion", true ) );

        TransactionTemplate  tx_template = new TransactionTemplate( getTransactionManager() );
        tx_template.setPropagationBehavior( TransactionDefinition.PROPAGATION_REQUIRED );

        @SuppressWarnings( "unchecked" )
        SearchResult<Definition> result =
        (SearchResult<Definition>)tx_template.execute( new TransactionCallback() {
                public Object doInTransaction( TransactionStatus status )
                {
                    return search( type, criteria );
                }
            });

        Definition  obj = null;
        if (result.size() > 0) {
            obj = (Definition)result.getElementAt( 0 );
        }
        return obj;
    }

}
// OvalStoreImpl
