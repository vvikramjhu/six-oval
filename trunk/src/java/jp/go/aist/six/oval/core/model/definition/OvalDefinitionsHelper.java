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

package jp.go.aist.six.oval.core.model.definition;

import jp.go.aist.six.oval.model.definition.Criteria;
import jp.go.aist.six.oval.model.definition.CriteriaElement;
import jp.go.aist.six.oval.model.definition.Criterion;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.ExtendDefinition;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: OvalDefinitionsHelper.java 635 2010-04-20 09:29:15Z akihito $
 */
public class OvalDefinitionsHelper
{

    /**
     * A static factory method.
     */
    public static OvalDefinitionsHelper newInstance(
                    final OvalDefinitions defs
                    )
    {
        return (new OvalDefinitionsHelper( defs ));
    }



    private final OvalDefinitions  _defs;


    private Map<String,Collection<String>>  _testsOfDefinition =
        new HashMap<String,Collection<String>>();



    /**
     *
     */
    private OvalDefinitionsHelper(
                    final OvalDefinitions defs
                    )
    {
        if (defs == null) {
            throw new NullPointerException( "no OvalDefinitions specified" );
        }

        _defs = defs;
    }



    /**
     *
     */
    public Collection<String> getTestsOfDefinition(
                    final String defID
                    )
    {
        if (defID == null) {
            throw new NullPointerException( "no definition id specified" );
        }

        Definition  def = _defs.getDefinition( defID );
        if (def == null) {
            throw new IllegalArgumentException( "unknown definition: id=" + defID );
        }

        Collection<String>  tests = _testsOfDefinition.get( defID );
        if (tests == null) {
            tests = _collectTests( def );
            _testsOfDefinition.put( defID, tests );
        }

        return tests;
    }



    /**
     *
     */
    private Collection<String> _collectTests(
                    final Definition def
                    )
    {
        Set<String>  tests = new HashSet<String>();
        Criteria  criteria = def.getCriteria();
        _collectTests( tests, criteria );

        return tests;
    }



    /**
     */
    private void _collectTests(
                    final Set<String> tests,
                    final Criteria criteria
                    )
    {
        if (criteria != null) {
            for (CriteriaElement  e : criteria.getElements()) {
                if (e instanceof Criterion) {
                    _collectTests( tests, Criterion.class.cast( e ) );
                } else if (e instanceof Criteria) {
                        _collectTests( tests, Criteria.class.cast( e ) );
                } else if (e instanceof ExtendDefinition) {
                    _collectTests( tests, ExtendDefinition.class.cast( e ) );
                }
            }
        }
    }



    /**
     *
     */
    private void _collectTests(
                    final Set<String> tests,
                    final ExtendDefinition ext
                    )
    {
        final String  defID = ext.getDefinitionReference();
        tests.addAll( getTestsOfDefinition( defID ) );
    }



    /**
     *
     */
    private void _collectTests(
                    final Set<String> tests,
                    final Criterion criterion
                    )
    {
        tests.add( criterion.getTestReference() );
    }

}
// OvalDefinitionsHelper
