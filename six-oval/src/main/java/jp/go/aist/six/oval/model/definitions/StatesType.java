/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.go.aist.six.oval.model.definitions;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import jp.go.aist.six.oval.model.ElementContainer;
import com.google.code.morphia.annotations.Reference;



/**
 * A container for one or more State instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class StatesType
    extends ElementContainer<StateType> //{1..*}
//extends Container<State> //{1..*}
{

    @Reference
    private final Set<StateType>  state = new HashSet<StateType>();



    /**
     * Constructor.
     */
    public StatesType()
    {
    }


    public StatesType(
                    final Collection<? extends StateType> state_list
                    )
    {
//        super( states );

//        state.addAll( state_list );
        _copy( state, state_list );
    }


    public StatesType(
                    final StateType[] state_list
                    )
    {
//        super( states );

        this( Arrays.asList( state_list ) );
    }



    public void setState(
                    final Collection<? extends StateType> state_list
                    )
    {
        reset( state_list );
//        _setElement( state_list );
    }


    public void setState(
                    final StateType[] state_list
                    )
    {
        reset( state_list );
    }


    public Collection<StateType> getState()
    {
        return _getCollection();
    }


//    public boolean addState(
//                    final StateType state
//                    )
//    {
//        return add( state );
//    }
//
//
//    public Iterator<StateType> iterateState()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<StateType> _getCollection()
    {
        return state;
    }

}
//
