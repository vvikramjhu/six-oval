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
 * A command line interface for OvalProcessor.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: NetOvalInterpreterCli.java 529 2010-04-07 07:22:59Z akihito $
 */
public class NetOvalInterpreterCli
extends OvalProcessorCli<NetOvalInterpreter>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( CentOSOvalGeneratorCli.class );


    public static final String  OPT_HTTP_POST_RESULTS = "-post";




    public static void main( final String[] args )
    {
        NetOvalInterpreterCli  proc = new NetOvalInterpreterCli();
        proc.execute( args );
    }



    /**
     * Constructor.
     */
    protected NetOvalInterpreterCli()
    {
        super( NetOvalInterpreter.class );
    }



    //**************************************************************
    //  OvalProcessorCli
    //**************************************************************

    protected void _configure(
                    final NetOvalInterpreter processor,
                    final String[] options
                    )
    {
        final int  length = options.length;
        for (int  i = 0; i < length; i++) {
            if (OPT_HTTP_POST_RESULTS.equals( options[i] )) {
                processor.setHttpPostResults( options[++i] );
                _printMessage( "  - OVAL Results POST URL: "
                                + processor.getHttpPostResults() );
            }
        }

        processor._setOvaldiCommand( new OvaldiCommand( options ) );
    }

}
// NetOvalInterpreterCli

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

