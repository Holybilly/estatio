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
package org.estatio.app.menus.invoice;

import org.junit.Before;
import org.junit.Test;

import org.estatio.dom.asset.Property;
import org.estatio.dom.lease.Lease;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceMenuTest {

    InvoiceMenu invoiceMenu;

    @Before
    public void setUp() throws Exception {
        invoiceMenu = new InvoiceMenu();
    }

    public static class NewInvoiceForLease extends InvoiceMenuTest {

        @Test
        public void when_lease_has_an_occupancy() throws Exception {

            // given
            final Lease lease = new Lease() {
                @Override public Property getProperty() {
                    return new Property();
                }
            };

            // when
            final String reason = invoiceMenu.validate0NewInvoiceForLease(lease);

            // then
            assertThat(reason).isNull();
        }

        @Test
        public void when_lease_does_not_have_an_occupancy() throws Exception {

            // given
            final Lease lease = new Lease() {
                @Override public Property getProperty() {
                    return null;
                }
            };

            // when
            final String reason = invoiceMenu.validate0NewInvoiceForLease(lease);

            // then
            assertThat(reason).isNotNull();
        }
    }

}