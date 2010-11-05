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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.definitions.Component;
import jp.go.aist.six.oval.model.definitions.LocalVariable;
import jp.go.aist.six.oval.model.definitions.Variable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class VariableDao
    extends OvalEntityDao<Variable>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( VariableDao.class );



//    private OvalXml  _xmlMapper;



    public VariableDao()
    {
        super( Variable.class );

//        try {
//            _xmlMapper = OvalContext.INSTANCE.getXml();
//        } catch (Exception ex) {
//            // TODO:
//            _LOG.error(  "XmlMapper instantiation failed: " + ex.getMessage() );
//        }
    }


    //TODO: Store the content model as an XML document,
    //like as Definition's Criteria.


    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public String create(
                    final Variable variable
                    )
    {
        if (LocalVariable.class.isInstance( variable )) {
            LocalVariable  lv = LocalVariable.class.cast( variable );
            Component  component = lv.getComponent();
            if (component != null) {
                try {
                    OvalXml  mapper = OvalContext.INSTANCE.getXml();
                    String  xml = mapper.marshalToString( component );
                    lv.setComponentXml( xml );
                } catch (Exception ex) {
                    // TODO:
                    _LOG.warn(  "'component' property NOT persisted" );
                }
            }
        }

        return super.create( variable );
    }

}
// VariableDao
