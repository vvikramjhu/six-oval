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

package jp.go.aist.six.oval.process;




/**
 * An OVAL Definition document generator.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalGenerator
implements OvalProcessor
{

    public static final String  DEFAULT_OUTPUT_DEFINITION_LOCATION = "definitions.xml";


    public static class Attribute
    {
        public static final String  OUTPUT_DEFINITION_LOCATION = "generator.definition";
    }
    //Attribute



    /**
     * The pathname of the file to which the generated
     * OVAL Definition document is to be saved.
     */
    private String  _outputDefinitionLocation = DEFAULT_OUTPUT_DEFINITION_LOCATION;



    /**
     * Constructor.
     */
    public OvalGenerator()
    {
    }



    /**
     * Specifies the pathname of the file to which the generated
     * OVAL Definition document is to be saved.
     *
     * @param location
     *  the pathname of the file.
     */
    public void setOutputDefinitionLocation(
                    final String location
                    )
    {
        _outputDefinitionLocation = location;
    }


    /**
     * Returns the pathname of the file to which the generated
     * OVAL Definition document is to be saved.
     *
     * @return
     *  the pathname of the file.
     */
    public String getOutputDefinitionLocation()
    {
        return _outputDefinitionLocation;
    }

}
// OvalGenerator

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

