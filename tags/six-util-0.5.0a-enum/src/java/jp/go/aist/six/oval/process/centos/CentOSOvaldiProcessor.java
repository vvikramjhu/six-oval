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

import jp.go.aist.six.oval.process.NetOvalInterpreter;
import jp.go.aist.six.oval.process.OvalProcessStatus;
import jp.go.aist.six.oval.process.OvaldiCommand;
import java.io.File;
import java.util.Map;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: CentOSOvaldiProcessor.java 524 2010-04-07 06:11:11Z akihito $
 */
public class CentOSOvaldiProcessor
extends NetOvalInterpreter
{

    public static void main(
                    final String[] args
                    )
    {
        CentOSOvaldiProcessor  proc = new CentOSOvaldiProcessor( args );
        OvalProcessStatus  status = proc.execute();
        if (status.isError()) {
            System.err.println( status.getErrorMessage() );
            System.exit( 1 );
        } else {
            System.exit( 0 );
        }
    }



//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( CentOSOvaldiProcessor.class );



    public static final String  OPT_RH_DEFINITIONS = "-rho";
    public static final String  OPT_CENTOS_DEFINITIONS = "-co";



    private String  _rhSourceDefinitions;



    /**
     * Constructor.
     */
    public CentOSOvaldiProcessor()
    {
    }



    /**
     * Constructor.
     */
    public CentOSOvaldiProcessor(
                    final String executable,
                    final Map<String,String> options,
                    final String md5
                    )
    {
        super( executable, options, md5 );
        if (options != null) {
            _rhSourceDefinitions = options.get( OPT_RH_DEFINITIONS );
        }
    }



    /**
     * Constructor.
     */
    public CentOSOvaldiProcessor(
                    final String[] cmdarray
                    )
    {
        super( cmdarray );
        _configure( cmdarray );
    }



    /**
     */
    private void _configure(
                    final String[] cmdarray
                    )
    {
        final int  size = cmdarray.length;
        try {
            // cmdarray[0] is ovaldi executable
            for (int  i = 1; i < size; i++) {
                if (cmdarray[i].equals( OPT_RH_DEFINITIONS )) {
                    setRhSourceDefinitions( cmdarray[ ++i ] );
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException(
                            "invalid command argument specified" );
        }
    }



    /**
     */
    public String getRhSourceDefinitions()
    {
        return _rhSourceDefinitions;
    }


    public void setRhSourceDefinitions(
                    final String location
                    )
    {
        _rhSourceDefinitions = location;
    }



    //==============================================================
    //  OvaldiCommand
    //==============================================================

    // -rho rhel.xml -o centos.xml ==> generator(rhel.xml, centos.xml),     ovaldi -o centos.xml
    // -rho rhel.xml               ==> generator(rhel.xml, tmp-centos.xml), ovaldi -o tmp-centos.xml
    //               -o centos.xml ==>                                      ovaldi -o centos.xml

    public OvalProcessStatus execute()
    {
        // RH-defs.xml  ==> CentOS-defs.xml
        OvalProcessStatus  generatorStatus = null;
        String  rhDefinitions = getRhSourceDefinitions();
        if (rhDefinitions != null) {
            CentOSOvalGenerator  generator =
                new CentOSOvalGenerator( rhDefinitions );

            File  ovalDefinitionsFile = null;
            if (_getOvaldiCommand().isOptionSet( OvaldiCommand.OPT_INPUT_DEFINITIONS )) {
                String  inputDefinitions = _getOvaldiCommand().getInputDefinitions();
                if (inputDefinitions.startsWith( "http:" )
                		||  inputDefinitions.startsWith( "https:" )) {
                    // TODO: HTTO POST oval_definitions
//                    OvalProcessStatus  httpPostStatus = _httpPost();
                    OvalProcessStatus  status = new OvalProcessStatus();
                    status.setError( true );
                    status.setErrorMessage(
                                    "generated CentOS defnitions can't be stored in remote location: "
                                    + inputDefinitions
                                    );
                }

                ovalDefinitionsFile = new File( inputDefinitions );
            }

            try {
                if (ovalDefinitionsFile == null) {
                    ovalDefinitionsFile = File.createTempFile( "oval-d_", ".xml" );
                                               //@throws IOException
                }
                generator.setOutputDefinitionLocation( ovalDefinitionsFile.getAbsolutePath() );
                generatorStatus = generator.execute();
            } catch (Exception ex) {
                return (new OvalProcessStatus( ex ));
            }

            if (generatorStatus != null  &&  generatorStatus.isError()) {
                return generatorStatus;
            }

            _getOvaldiCommand().setInputDefinitions(
                            ovalDefinitionsFile.getAbsolutePath() );
        }

        OvalProcessStatus  status = super.execute();

        return status;
    }

}
// CentOSOvaldiProcessor

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

