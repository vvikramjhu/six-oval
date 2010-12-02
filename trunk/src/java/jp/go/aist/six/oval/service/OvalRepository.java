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

package jp.go.aist.six.oval.service;

import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.persist.Persistable;
import java.util.List;



/**
 * An OVAL repository API prescription.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalRepository
{

    public <K, T extends Persistable<K> & OvalObject>
    K create( OvalObjectType type, T object )
    throws OvalRepositoryException;


    public <K, T extends Persistable<K> & OvalObject>
    T get( OvalObjectType type, K pid, ViewLevel view )
    throws OvalRepositoryException;



    //==============================================================
    // Definitions
    //==============================================================

    public String createOvalDefinitions( OvalDefinitions defs )
    throws OvalRepositoryException;


    public OvalDefinitions getOvalDefinitions( String pid )
    throws OvalRepositoryException;


    public List<Definition> findDefinitionByCve( String cveName )
    throws OvalRepositoryException;



    //==============================================================
    // System Characteristics
    //==============================================================

    public String createOvalSystemCharacteristics( OvalSystemCharacteristics sc )
    throws OvalRepositoryException;


    public OvalSystemCharacteristics getOvalSystemCharacteristics( String pid )
    throws OvalRepositoryException;



    //==============================================================
    // Results
    //==============================================================

    public String createOvalResults( OvalResults resutls )
    throws OvalRepositoryException;


    public OvalResults getOvalResults( String pid )
    throws OvalRepositoryException;

}
// OvalRepository

