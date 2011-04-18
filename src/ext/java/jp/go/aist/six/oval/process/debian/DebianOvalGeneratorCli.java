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

package jp.go.aist.six.oval.process.debian;

import jp.go.aist.six.oval.process.OvalProcessorCli;




/**
 * A command line interface for OvalProcessor.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DebianOvalGeneratorCli
extends OvalProcessorCli<DebianOvalGenerator>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( CentOSOvalGeneratorCli.class );


    public static final String  OPT_DSA = "-dsa";
    public static final String  OPT_OVAL = "-o";




    public static void main( final String[] args )
    {
        DebianOvalGeneratorCli  proc = new DebianOvalGeneratorCli();
        proc.execute( args );
    }



    /**
     * Constructor.
     */
    protected DebianOvalGeneratorCli()
    {
        super( DebianOvalGenerator.class );
    }



    //**************************************************************
    //  OvalProcessorCli
    //**************************************************************

    // -dsa http://...    -o definitions.xml
    // -dsa /.../def.xml
    protected void _configure(
                    final DebianOvalGenerator processor,
                    final String[] options
                    )
    {
        final int  length = options.length;
        for (int  i = 0; i < length; i++) {
            if (OPT_DSA.equals( options[i] )) {
                processor.setSourceDsaLocation( options[++i] );
                _printMessage( "  - source DSA: "
                                + processor.getSourceDsaLocation() );
            } else if (OPT_OVAL.equals( options[i] )) {
                processor.setOutputDefinitionLocation( options[++i] );
                _printMessage( "  - output Debian Definition document: "
                                + processor.getOutputDefinitionLocation() );
            }
        }
    }

}
// DebianOvalGeneratorCli

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

