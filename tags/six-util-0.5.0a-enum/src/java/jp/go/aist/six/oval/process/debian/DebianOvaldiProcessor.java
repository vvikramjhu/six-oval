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

import jp.go.aist.six.oval.process.NetOvalInterpreter;
import jp.go.aist.six.oval.process.OvalProcessStatus;
import jp.go.aist.six.oval.process.OvaldiCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Map;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: DebianOvaldiProcessor.java 524 2010-04-07 06:11:11Z akihito $
 */
public class DebianOvaldiProcessor
extends NetOvalInterpreter
{

    public static void main(
                    final String[] args
                    )
    {
        DebianOvaldiProcessor  proc = new DebianOvaldiProcessor( args );
        OvalProcessStatus  status = proc.execute();
        if (status.isError()) {
            System.err.println( status.getErrorMessage() );
            System.exit( 1 );
        } else {
            System.exit( 0 );
        }
    }



    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( DebianOvaldiProcessor.class );



    public static final String  OPT_DSA = "-dsa";



    private String  _dsa;



    /**
     * Constructor.
     */
    public DebianOvaldiProcessor()
    {
    }



    /**
     * Constructor.
     */
    public DebianOvaldiProcessor(
                    final String executable,
                    final Map<String,String> options,
                    final String md5
                    )
    {
        super( executable, options, md5 );
        if (options != null) {
            _dsa = options.get( OPT_DSA );
        }
    }



    /**
     * Constructor.
     */
    public DebianOvaldiProcessor(
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
                if (cmdarray[i].equals( OPT_DSA )) {
                    setDsa( cmdarray[ ++i ] );
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException(
                            "invalid command argument specified" );
        }
    }



    /**
     */
    public String getDsa()
    {
        return _dsa;
    }


    public void setDsa(
                    final String location
                    )
    {
        _dsa = location;
    }



    private static void _copyFile(
                    final String src,
                    final String dst
                    )
    throws IOException
    {
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "copy file: from=" + src + ", to=" + dst );
        }

        FileChannel srcChannel = new FileInputStream(  src ).getChannel();
        FileChannel dstChannel = new FileOutputStream( dst ).getChannel();
        try {
            srcChannel.transferTo(0, srcChannel.size(), dstChannel);
        } finally {
            srcChannel.close();
            dstChannel.close();
        }
    }




    //==============================================================
    //  OvaldiCommand
    //==============================================================

    // -dsa dsa.html -o oval-defs.xml ==> generator(dsa.html, oval-defs.xml),     ovaldi -o oval-defs.xml
    // -dsa dsa.html                  ==> generator(dsa.html, tmp-oval-defs.xml), ovaldi -o tmp-oval-defs.xml
    //               -o oval-defs.xml ==>                                         ovaldi -o oval-defs.xml

    public OvalProcessStatus execute()
    {
        // dsa.html ==> oval--defs.xml
        OvalProcessStatus  generatorStatus = null;
        String  dsa = getDsa();

        if (dsa != null) {
            String  inputDefinitions = null;
            if (_getOvaldiCommand().isOptionSet( OvaldiCommand.OPT_INPUT_DEFINITIONS )) {
                // Copies the oval_definitions file to the specified location.
                inputDefinitions = _getOvaldiCommand().getInputDefinitions();
                if (inputDefinitions.startsWith( "http:" )
                        ||  inputDefinitions.startsWith( "https:" )) {
                    // TODO: HTTO POST oval_definitions
//                    OvalProcessStatus  httpPostStatus = _httpPost();
                    OvalProcessStatus  status = new OvalProcessStatus();
                    status.setError( true );
                    status.setErrorMessage(
                                    "generated Debian defnitions can't be stored in remote location: "
                                    + inputDefinitions
                                    );
                    return status;
                }
            }

            DebianOvalGenerator  generator =
                new DebianOvalGenerator( dsa );
            generatorStatus = generator.execute();
            if (generatorStatus.isError()) {
                return generatorStatus;
            }

            final String  generatedDefinitions =
                (String)generatorStatus.getAttribute(
                                DebianOvalGenerator.Attribute.OVAL_DEFINITIONS_FILEPATH );
            File  inputDefinitionsFile = null;
            if (inputDefinitions == null) {
                inputDefinitionsFile = new File( generatedDefinitions );
            } else {
                // Copies the generated oval_definitions file to the specified location.
                try {
                    _copyFile( generatedDefinitions, inputDefinitions );
                } catch (IOException ex) {
                    OvalProcessStatus  status = new OvalProcessStatus( ex );
                    status.mergeAttributes( generatorStatus );
                    return status;
                }

                inputDefinitionsFile = new File( inputDefinitions );
            }

            _getOvaldiCommand().setInputDefinitions(
                            inputDefinitionsFile.getAbsolutePath() );
        }

        OvalProcessStatus  status = super.execute();

        return status;
    }

}
// DebianOvaldiProcessor

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

