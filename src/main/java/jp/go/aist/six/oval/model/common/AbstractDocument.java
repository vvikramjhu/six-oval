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

package jp.go.aist.six.oval.model.common;

import jp.go.aist.six.oval.model.Document;



/**
 * A base class for all the OVAL Document types.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class AbstractDocument
    extends Document
{

    private GeneratorType  generator = new GeneratorType();
    //{1..1} // OvalDefinitions, OvalSystemCharacteristics, OvalResults, OvalVariables, OvalDirectives



    /**
     * Constructor.
     */
    public AbstractDocument()
    {
    }



    public AbstractDocument(
                    final GeneratorType generator
                    )
    {
        setGenerator( generator );
    }



    /**
     */
    public void setGenerator(
                    final GeneratorType generator
                    )
    {
        this.generator = generator;
    }


    public GeneratorType getGenerator()
    {
        return generator;
    }

}
//
