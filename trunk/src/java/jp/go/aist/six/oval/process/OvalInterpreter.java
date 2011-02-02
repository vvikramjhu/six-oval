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

import java.io.IOException;
import java.util.List;
import jp.go.aist.six.oval.OvalException;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreter
{
    //TODO:
    //
    // Options:
    // -o filename  = path to the oval-definitions xml file.
    //                DEFAULT="definitions.xml"
    // -r filename  = save oval-results to the specified XML file.
    //                DEFAULT="oval-results.xml"
    // -a dir name  = path to the directory that contains the OVAL schema and other xml resources.
    //                On Windows platforms, DEFAULT="xml".
    //                On *nix platforms, DEFAULT="/usr/share/ovaldi".



    /**
     * A factory method.
     */
    public static OvalInterpreter newInstance(
                    final List<String> args
                    )
    {
        return (new OvalInterpreter( args ));
    }


    public static OvalInterpreter newInstance(
                    final String[] args
                    )
    {
        return (new OvalInterpreter());
    }



//    // Definition Evaluation Options:
//    public static final String  OPT_INPUT_DEFINITIONS = "-o";
//
//    // Input Validation Options:
//    public static final String  OPT_RESOURCE_DIR = "-a";
//    public static final String  OPT_SKIP_INPUT_VERIFICATION = "-m";
//
//    //Data Collection Options:
//    public static final String  OPT_INPUT_SYSTEM_CHARACTERISTICS = "-i";
//
//    // Result Output Options:
//    public static final String  OPT_OUTPUT_SYSTEM_CHARACTERISTICS = "-d";
//    public static final String  OPT_OUTPUT_RESULTS = "-r";
//    public static final String  OPT_SKIP_OUTPUT_XSL = "-s";
//    public static final String  OPT_OUTPUT_RESULTS_HTML = "-x";



    private ProcessBuilder  _builder;



    /**
     *
     */
    protected OvalInterpreter()
    {
    }


    protected OvalInterpreter(
                    final List<String> command
                    )
    {
        _builder = new ProcessBuilder( command );
    }


    protected OvalInterpreter(
                    final String[] command
                    )
    {
        _builder = new ProcessBuilder( command );
    }



//    /**
//     */
//    private Map<String, String> _buildOptions(
//                    final String[] args
//                    )
//    {
//        Map<String, String>  map = new HashMap<String, String>();
//
//        for (int  i = 0; i < args.length; i++) {
//            if (args[i].startsWith( "-" )) {
//
//            }
//        }
//
//        return map;
//    }



    /**
     * Starts a new OVAL interpreter process.
     */
    public Process start()
    {
        Process  proc = null;
        try {
            proc = _builder.start();
        } catch (IOException ex) {
            throw new OvalException( ex );
        }

        return proc;
    }


//    /**
//     * Returns the status of this processor.
//     *
//     * @return
//     *  the status.
//     */
//    public OvalProcessStatus getStatus();

}
// OvalInterpreter

