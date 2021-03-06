/**
 * or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.estatio.module.lease.dom;

import java.math.BigInteger;

import org.apache.isis.core.unittestsupport.bidir.Instantiator;

import org.estatio.module.lease.dom.LeaseTerm;
import org.estatio.module.lease.dom.LeaseTermForTesting;

public class InstantiatorForLeaseTerm implements Instantiator {

    private long sequence;
    
    @Override
    public Object instantiate() {
        final LeaseTerm lt = new LeaseTermForTesting();
        lt.setSequence(BigInteger.valueOf(sequence++));
        return lt;
    }

}
