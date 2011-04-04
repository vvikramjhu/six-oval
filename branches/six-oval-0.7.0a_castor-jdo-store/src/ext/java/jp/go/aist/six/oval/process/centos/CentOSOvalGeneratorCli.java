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

package jp.go.aist.six.oval.process.centos;

import jp.go.aist.six.oval.process.OvalProcessorCli;




/**
 * A command line interface for OvalProcessor.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class CentOSOvalGeneratorCli
extends OvalProcessorCli<CentOSOvalGenerator>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( CentOSOvalGeneratorCli.class );


    public static final String  OPT_SOURCE_DEFINITION_LOCATION = "-rho";
    public static final String  OPT_OUTPUT_DEFINITION_LOCATION = "-o";





    public static void main( final String[] args )
    {
        CentOSOvalGeneratorCli  proc = new CentOSOvalGeneratorCli();
        proc.execute( args );
    }



    /**
     * Constructor.
     */
    protected CentOSOvalGeneratorCli()
    {
        super( CentOSOvalGenerator.class );
    }



    //**************************************************************
    //  OvalProcessorCli
    //**************************************************************

    protected void _configure(
                    final CentOSOvalGenerator processor,
                    final String[] options
                    )
    {
        final int  length = options.length;
        for (int  i = 0; i < length; i++) {
            if (OPT_SOURCE_DEFINITION_LOCATION.equals( options[i] )) {
                processor.setSourceRedhatDefinitionLocation( options[++i] );
                _printMessage( "  - source RedHat Definition document: "
                                + processor.getSourceRedhatDefinitionLocation() );
            } else if (OPT_OUTPUT_DEFINITION_LOCATION.equals( options[i] )) {
                processor.setOutputDefinitionLocation( options[++i] );
                _printMessage( "  - output CentOS Definition document: "
                                + processor.getOutputDefinitionLocation() );
            }
        }
    }

}
// CentOSOvalGeneratorCli

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

