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

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreter
{

    /**
     *
     */
    public static OvalInterpreter newInstance(
                    final List<String> args
                    )
    {
        return newInstance( args.toArray( new String[0] ) );
    }


    public static OvalInterpreter newInstance(
                    final String[] args
                    )
    {
        OvalInterpreter  interpreter = new OvalInterpreter();


        return interpreter;
    }



    /**
     *
     */
    protected OvalInterpreter()
    {
    }


    /**
     */
    private Map<String, String> _buildOptions(
                    final String[] args
                    )
    {
        Map<String, String>  map = new HashMap<String, String>();

        for (int  i = 0; i < args.length; i++) {
            if (args[i].startsWith( "-" )) {

            }
        }

        return map;
    }



    /**
     * Executes this processor.
     */
    public Process start()
    {
        Process  proc = null;

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

