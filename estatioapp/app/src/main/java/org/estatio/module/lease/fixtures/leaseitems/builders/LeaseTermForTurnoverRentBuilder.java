/*
 *
 *  Copyright 2012-2014 Eurocommercial Properties NV
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.estatio.module.lease.fixtures.leaseitems.builders;

import org.joda.time.LocalDate;

import org.apache.isis.applib.fixturescripts.BuilderScriptAbstract;

import org.estatio.module.lease.dom.LeaseItem;
import org.estatio.module.lease.dom.LeaseTermForTurnoverRent;
import org.estatio.module.lease.dom.LeaseTermFrequency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(of={"leaseItem","startDate"}, callSuper = false)
@ToString(of={"leaseItem","startDate"})
@Accessors(chain = true)
public class LeaseTermForTurnoverRentBuilder
        extends BuilderScriptAbstract<LeaseTermForTurnoverRent, LeaseTermForTurnoverRentBuilder> {

    @Getter @Setter LeaseItem leaseItem;
    @Getter @Setter LocalDate startDate;

    @Getter @Setter LocalDate endDate;

    @Getter @Setter String turnoverRentRule;

    @Getter @Setter LeaseTermFrequency leaseTermFrequency;

    @Getter LeaseTermForTurnoverRent object;

    @AllArgsConstructor
    @Data
    public static class TermSpec {
        LocalDate startDate;
        LocalDate endDate;
        LeaseTermFrequency leaseTermFrequency;
        String turnoverRentRule;
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        checkParam("leaseItem", ec, LeaseItem.class);
        defaultParam("startDate", ec, leaseItem.getStartDate());

        defaultParam("leaseTermFrequency", ec, LeaseTermFrequency.YEARLY);

        final Class<?> expectedClass = LeaseTermForTurnoverRent.class;
        if(!leaseItem.getType().isCreate(expectedClass)) {
            throw new IllegalArgumentException(
                    String.format("LeaseItem type must instantiate %s (is %s)", expectedClass, leaseItem.getType()));
        }

        final LeaseTermForTurnoverRent leaseTerm = (LeaseTermForTurnoverRent) leaseItem.newTerm(startDate, endDate);

        leaseTerm.setFrequency(LeaseTermFrequency.YEARLY);
        leaseTerm.setTurnoverRentRule(turnoverRentRule);

        ec.addResult(this, leaseTerm);

        object = leaseTerm;
    }
}
