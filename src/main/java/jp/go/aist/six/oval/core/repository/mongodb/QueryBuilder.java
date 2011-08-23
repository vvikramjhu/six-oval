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

package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.List;
import java.util.regex.Pattern;
import jp.go.aist.six.util.search.AndBinding;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.InBinding;
import jp.go.aist.six.util.search.LikeBinding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.LogicalBinding;
import jp.go.aist.six.util.search.NotBinding;
import jp.go.aist.six.util.search.NullBinding;
import jp.go.aist.six.util.search.Order;
import jp.go.aist.six.util.search.PropertyBinding;
import jp.go.aist.six.util.search.RelationalBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.query.Criteria;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MorphiaQueryBuilder<T>
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( MorphiaQueryBuilder.class );



//    private final Class<T>  _type;
    private final Binding  _filter;

    private final Query<T>  _query;


    private boolean  _compiled = false;



    /**
     * Usage:
     * MorphiaQueryBuilder  b = new MorphiaQueryBuilder( dao.createQuery(), filter );
     * Query<T>  q = b.build();
     * Limit  limit = new Limit( 10, 0 );
     * QueryResults<T>  results = dao.find( q, orders, limit );
     * limit.next();
     * results = dao.find( q, orders, limit );
     * ...
     */


    /**
     * Constructor.
     */
    public MorphiaQueryBuilder(
                    final Query<T> query,
                    final Binding filter
                    )
    {
        _query = query;
        _filter = filter;
    }



    private synchronized Query<T> _compile()
    {
        if (_compiled) {
            // do nothing.
        } else {
            _LOG_.debug( "compiling filter..." );
            build( _query, _filter );
            _compiled = true;
            _LOG_.debug( "filter compiled." );
        }

        return _query;
    }



    public Query<T> build()
    {
        return _compile();
    }


    public Query<T> build(
                    final List<? extends Order> orders,
                    final Limit limit
                    )
    {
        Query<T>  q = _compile();

        // Keep the original!!!
        q = build( q.clone(), null, orders, limit );

        return q;
    }


    /**
     *
     */
    public static <S> Query<S> build(
                    final Query<S> query,
                    final Binding filter
                    )
    {
        _buildBinding( query, filter );

        return query;
    }


    public static <S> Query<S> build(
                    final Query<S> query,
                    final Binding filter,
                    final List<? extends Order> orders,
                    final Limit limit
                    )
    {
        _buildBinding( query, filter );
        _buildOrder( query, orders );
        _buildLimit( query, limit );

        return query;
    }



    /**
     */
    private static void _buildOrder(
                    final Query<?> query,
                    final List<? extends Order> orders
                    )
    {
        if (orders == null) {
            return;
        }

        _LOG_.debug( "building orders: " + orders );
        boolean  empty = true;
        StringBuilder  s = new StringBuilder();
        for (Order  order : orders) {
            if (empty) {
                empty = false;
            } else {
                s.append( "," );
            }
            if (order.isDescending()) {
                s.append( "-" );
            }
            s.append( order.getProperty() );
        }
    }



    private static void _buildLimit(
                    final Query<?> query,
                    final Limit limit
                    )
    {
        if (limit == null) {
            return;
        }

        _LOG_.debug( "building limit: " + limit );
        query.offset( limit.getOffset() );
        query.limit( limit.getCount() );
    }



    private static void _buildBinding(
                    final Query<?> query,
                    final Binding binding
                    )
    {
        if (binding == null) {
            return;
        }

        if (binding instanceof PropertyBinding) {
            _buildPropertyBinding( query, (PropertyBinding)binding );

        } else if (binding instanceof LogicalBinding) {
            _buildLogicalBinding( query, (LogicalBinding)binding );

//        } else if (binding instanceof NotBinding) {
            // TODO:

        } else {
            throw new IllegalArgumentException( "unsupported Binding: "
                            + String.valueOf( binding ) );
        }
    }



    /**
     * PropertyBinding
     */
    private static void _buildPropertyBinding(
                    final Query<?> query,
                    final PropertyBinding binding
                    )
    {
        if (binding instanceof RelationalBinding) {
            RelationalBinding  rel = (RelationalBinding)binding;
            query.filter( rel.getProperty() + " " + rel.getRelation().operator(), rel.getValue() );

        } else if (binding instanceof InBinding) {
            InBinding  in = (InBinding)binding;
            query.filter( in.getProperty() + " in", in.getValues() );

        } else if (binding instanceof LikeBinding) {
            LikeBinding  rel = (LikeBinding)binding;
            String  string = rel.getPattern();
            Pattern  pattern = Pattern.compile( ".*" + string + ".*", Pattern.CASE_INSENSITIVE );
            query.filter( rel.getProperty(), pattern );

//        } else if (binding instanceof TextMatchBinding) {
            //TODO:

//        } else if (binding instanceof NullBinding) {
            //TODO:

        } else {
            throw new IllegalArgumentException( "unsupported PropertyBinding: "
                            + String.valueOf( binding ) );
        }
    }



    /**
     * LogicalBinding
     *      (b_1 AND b_2 AND ... AND b_n)
     *      (b_1 OR  b_2 OR  ... OR  b_n)
     */
    private static void _buildLogicalBinding(
                    final Query<?> query,
                    final LogicalBinding binding
                    )
    {
        final int  size = binding.size();

        if (size < 2) {
            throw new IllegalArgumentException(
                            "LogicalBinding with less than two element bindings" );
        }

        Criteria[]  elements = new Criteria[size];
        for (int  i = 0; i < size ; i++) {
            elements[i] = _createCriteria( query, binding.getElementAt( i ) );
        }

        if (binding instanceof AndBinding) {
            query.and( elements );
        } else {
            query.or( elements );
        }
    }



    private static Criteria _createCriteria(
                    final Query<?> query,
                    final Binding binding
                    )
    {
        Criteria  criteria = null;
        if (binding instanceof PropertyBinding) {
            if (binding instanceof RelationalBinding) {
                criteria = _createRelationalCriteria( query, (RelationalBinding)binding );
            } else if (binding instanceof InBinding) {
                criteria = _createInCriteria( query, (InBinding)binding );
            } else if (binding instanceof LikeBinding) {
                criteria = _createLikeCriteria( query, (LikeBinding)binding );
            } else if (binding instanceof NullBinding) {
                criteria = _createNullCriteria( query, (NullBinding)binding );
            }
        } else if (binding instanceof LogicalBinding) {
            criteria = _createLogicalCriteria( query, (LogicalBinding)binding );
        } else if (binding instanceof NotBinding) {
            // TODO: Unsupported???
        }

        if (criteria == null) {
            throw new IllegalArgumentException(
                            "unknown Binding to create Morphia Criteria: "
                            + String.valueOf( binding ) );
        }

        return criteria;
    }



    private static Criteria _createLogicalCriteria(
                    final Query<?> query,
                    final LogicalBinding binding
                    )
    {
        final int  size = binding.size();

        if (size < 2) {
            throw new IllegalArgumentException(
                            "LogicalBinding contains less than two element bindings" );
        }

        Criteria  criteria = null;
        Criteria[]  elements = new Criteria[size];
        for (int  i = 0; i < size ; i++) {
            elements[i] = _createCriteria( query, binding.getElementAt( i ) );
        }

        if (binding instanceof AndBinding) {
            criteria = query.and( elements );
        } else {
            criteria = query.or( elements );
        }

        return criteria;
    }



    private static Criteria _createRelationalCriteria(
                    final Query<?> query,
                    final RelationalBinding binding
                    )
    {
        Criteria  criteria = null;
        String  property = binding.getProperty();
        Object  value = binding.getValue();

        switch (binding.getRelation()) {
        case EQUAL:
            criteria = query.criteria( property ).equal( value );
        case NOT_EQUAL:
            criteria = query.criteria( property ).notEqual( value );
        case LESS_THAN:
            criteria = query.criteria( property ).lessThan( value );
        case LESS_EQUAL:
            criteria = query.criteria( property ).lessThanOrEq( value );
        case GREATER_THAN:
            criteria = query.criteria( property ).greaterThan( value );
        case GREATER_EQUAL:
            criteria = query.criteria( property ).greaterThanOrEq( value );
        }

        if (criteria == null) {
            throw new IllegalArgumentException(
                            "unknown RelationalBinding: " + String.valueOf( binding ) );
        }

        return criteria;
    }



    private static Criteria _createInCriteria(
                    final Query<?> query,
                    final InBinding binding
                    )
    {
        return query.criteria( binding.getProperty() ).in( binding.getValues() );
    }



    private static Criteria _createLikeCriteria(
                    final Query<?> query,
                    final LikeBinding binding
                    )
    {
        return query.criteria( binding.getProperty() ).containsIgnoreCase( binding.getPattern() );
    }



    private static Criteria _createNullCriteria(
                    final Query<?> query,
                    final NullBinding binding
                    )
    {
        return query.criteria( binding.getProperty() ).equal( null );
    }

}
// MorphiaQueryBuilder

