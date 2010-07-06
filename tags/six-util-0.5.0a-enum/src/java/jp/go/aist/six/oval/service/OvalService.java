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

package jp.go.aist.six.oval.service;

import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.State;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.result.Result;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.util.search.SearchCriteria;
import java.util.Collection;
import java.util.List;


/**
 * The OVAL data store interface.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalStore.java 754 2010-05-10 05:26:45Z akihito $
 */
public interface OvalService
{

    //==============================================================
    //  Results
    //==============================================================

    public OvalResults findResults( String pid );
    public String createOvalResults( OvalResults results );
    public List<SystemResult> searchSystemResult( SearchCriteria criteria );
    public Collection<SystemResult> findSyetemByDefinitionResult( String defID, Result result );

    public Collection<DefinitionResult> findDefinitionResult( Result result );


    //==============================================================
    //  System Characteristics
    //==============================================================

    public OvalSystemCharacteristics findSystemCharacteristics( String pid );
    public String createSystemCharacteristics( OvalSystemCharacteristics sc );



    //==============================================================
    //  Definition
    //==============================================================

    public String createOvalDefinitions( OvalDefinitions defs );
    public Definition syncDefinition( Definition def );
    public List<Definition> searchDefinition( SearchCriteria criteria );

    public Test syncTest( Test state );
    public SystemObject syncObject( SystemObject state );
    public State syncState( State state );




    //==============================================================
    //  definition.Definition
    //==============================================================

//    public void createDefinition( Definition def );
//    public List<Definition> getDefinitions();
//    public Definition findLatestDefinition( String id );
//    public Definition findDefinition( String id, int version );
//    public List<Definition> findDefinitionsByPlatform( Platform platform );
//    public List<Definition> findDefinitionsByProduct( Product product );
//    public void removeDefinition( Definition def );



    //==============================================================
    //  definition.Platform/Product
    //==============================================================

//    public List<Platform> getPlatforms();
//    public List<Product> getProducts();


    //==============================================================
    //  definition.SystemObject
    //==============================================================

//    public List<SystemObject> getObjects();
//    public SystemObject findObject( String id, int version );
//    public void createObject( SystemObject object );



    //==============================================================
    //  definition.Reference
    //==============================================================

//    public List<Reference> getReferences();
//    public Reference syncReference( Reference ref );

}
// OvalStore
