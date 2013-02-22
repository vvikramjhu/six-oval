/**
 * SIX VULN - http://code.google.com/p/six-vuln/
 * Copyright (C) 2006
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H18PRO-538
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
package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.DefinitionType;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface DefinitionRepository
    extends QueryDslPredicateExecutor<DefinitionType>,
    PagingAndSortingRepository<DefinitionType, String>   //findAll():Iterable
//    MongoRepository<VulnerabilityType, String>            //findAll():List
{

//    public DefinitionType findByOvalId( String id );

}
//

