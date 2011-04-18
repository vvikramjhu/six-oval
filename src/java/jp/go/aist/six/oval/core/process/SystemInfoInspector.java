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

package jp.go.aist.six.oval.core.process;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.Result;
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemInfoInspector
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( SystemInfoInspector.class );



    private String  _ovalPlatformDefinitions;



    /**
     * Constructor.
     */
    public SystemInfoInspector()
    {
    }




    /**
     */
    public void setOvalPlatformDefinitions(
                    final String location
                    )
    {
        _ovalPlatformDefinitions = location;
    }


    public String getOvalPlatformDefinitions()
    {
        return _ovalPlatformDefinitions;
    }



    /**
     */
    public SixSystemInfo execute()
    throws OvalException
    {
        String  platformDefinitions = getOvalPlatformDefinitions();
        if (platformDefinitions == null) {
            throw new OvalException( "no OVAL platform definitions specified" );
        }

        File  tmpFile = null;
        try {
            tmpFile = File.createTempFile( "platform-results", ".xml" );
        } catch (Exception ex) {
            _LOG_.error( "tmp file creation", ex );
            throw new OvalException( ex );
        }

        NetOvalInterpreter  interpreter = new NetOvalInterpreter();
        interpreter.setOvalDefinitions( platformDefinitions );
        interpreter.setOvalResults( tmpFile.getAbsolutePath() );

        int  exitValue = interpreter.execute();
        if (exitValue == 0) {
            SixSystemInfo  sysinfo = _buildSystemInfo( tmpFile );
            return sysinfo;
        } else {
            throw new OvalException( "OVAL interpreter execution failed" );
        }
    }



    private SixSystemInfo _buildSystemInfo(
                    final File file
                    )
    throws OvalException
    {
        OvalXml  xml = OvalContext.INSTANCE.getXml();
        OvalResults  ovalResults = null;
        try {
            ovalResults = (OvalResults)xml.unmarshal( new FileInputStream( file ) );
                                                  //throws FileNotFoundException
        } catch (Exception ex) {
            _LOG_.error( "XML unmarshal", ex );
            throw new OvalException( ex );
        }

        Collection<SystemResult>  systemResults = ovalResults.getResults().getSystem();
        if (systemResults == null  ||  systemResults.size() < 1) {
            throw new OvalException( "no system_info found in OVAL results");
        }

        SystemResult  systemResult = systemResults.iterator().next();
        SystemInfo  ovalSystemInfo = systemResult.getOvalSystemCharacteristics().getSystemInfo();

        String  defID = null;
        for (DefinitionResult  defResult : systemResult.getDefinitions()) {
            if (defResult.getResult() == Result.TRUE) {
                defID = defResult.getDefinitionID();
                break;
            }
        }
        if (defID == null) {
            throw new OvalException( "no valid platform found");
        }

        Definition  def = ovalResults.getOvalDefinitions().getDefinition( defID );
        Affected  affected = def.getMetadata().getAffected();
        Family  family = affected.getFamily();
        Platform  platform = affected.getPlatform().iterator().next();

        SixSystemInfo  sixSysInfo = new SixSystemInfo( family, platform, ovalSystemInfo );
        _LOG_.debug( "system info: " + sixSysInfo );

        return sixSysInfo;
    }

}
// SystemInfoInspector

