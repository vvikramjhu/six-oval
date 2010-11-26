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

import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;



/**
 * An OVAL repository API prescription.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalRepository
{

    //==============================================================
    // Definitions
    //==============================================================

    public String createOvalDefinitions( OvalDefinitions defs )
    throws OvalServiceException;


    public OvalDefinitions getOvalDefinitions( String pid )
    throws OvalServiceException;



    //==============================================================
    // System Characteristics
    //==============================================================

    public String createOvalSystemCharacteristics( OvalSystemCharacteristics definitions )
    throws OvalServiceException;


    public OvalSystemCharacteristics getOvalSystemCharacteristics( String pid )
    throws OvalServiceException;



    //==============================================================
    // Results
    //==============================================================

    public String createOvalResults( OvalResults resutls )
    throws OvalServiceException;


    public OvalResults getOvalResults( String pid )
    throws OvalServiceException;

}
// OvalRepository

