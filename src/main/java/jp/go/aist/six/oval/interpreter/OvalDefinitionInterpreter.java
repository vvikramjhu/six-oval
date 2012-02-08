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

package jp.go.aist.six.oval.interpreter;



/**
 * A prescription of the OVAL Definition Interpreter basic interface.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalDefinitionInterpreter
{

    /**
     * Starts a new OVAL interpreter process.
     */
    public int execute()
    throws OvalInterpreterException;

    
    
    /**
     */
    public void setOptions( Options options );
//  public OvalDefinitionInterpreter setOptions( Options options );

    public Options getOptions();

}
//OvalDefinitionInterpreter

