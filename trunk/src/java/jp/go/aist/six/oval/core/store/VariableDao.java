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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.model.definitions.Variable;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class VariableDao
    extends OvalEntityDao<Variable>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( VariableDao.class );



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

//    @Override
//    public String create(
//                    final Variable variable
//                    )
//    {
//        if (_xmlMapper != null) {
//            try {
//                String  xml = _xmlMapper.marshalToString( variable );
//                VariableXml  vx = new VariableXml( variable, xml );
//                getForwardingDao( VariableXml.class ).sync( vx );
//            } catch (OxmException ex) {
//                // TODO:
//                _LOG.warn(  "'variable' XML NOT persisted" );
//            }
//        }
//
//        return super.create( variable );
//    }

}
// VariableDao
