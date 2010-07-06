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

package jp.go.aist.six.oval.core.service.restlet;

import jp.go.aist.six.oval.core.service.StandardOvalService;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.Router;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalApplication.java 440 2010-03-23 05:11:44Z akihito $
 */
public class OvalApplication
    extends Application
{

    /**
     * Logger.
     */
//    private static Log _LOG = LogFactory.getLog( ManagerApplication.class );




    private StandardOvalService  _service;
    private OvalStore  _ovalStore;
    private OvalXml  _ovalXml;



    /**
     * Constructor.
     */
    public OvalApplication()
    {
    }



    /**
     * Constructor.
     */
    public OvalApplication(
                    final Context context
                    )
    {
        super( context );

        _service = new StandardOvalService();
    }



    /**
     *
     */
    protected synchronized OvalStore _getOvalStore()
    throws Exception
    {
        if (_ovalStore == null) {
            _ovalStore = _service.getStore();
        }

        return _ovalStore;
    }



    protected synchronized OvalXml _getOvalXml()
    throws Exception
    {
        if (_ovalXml == null) {
            _ovalXml = _service.getXml();
        }

        return _ovalXml;
    }




    //**************************************************************
    //  extends Application
    //**************************************************************

    public synchronized Restlet createRoot()
    {
        Router  router = new Router( getContext() );

        router.attach( "/results", OvalResultsResource.class );
//        router.attach( ManagementResource.INSTALLED_SOFTWARE_URI_PATH,
//        				InstalledSoftwareResource.class );

        return router;
    }

}
// OvalApplication

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

