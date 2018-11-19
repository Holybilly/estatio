package org.estatio.module.capex.dom.invoice.approval;

import org.estatio.module.capex.dom.state.State;

import lombok.Getter;

public enum IncomingInvoiceApprovalState implements State<IncomingInvoiceApprovalState> {
    NEW                          (false, false),
    COMPLETED                    (false, false),
    DISCARDED                    (false, true ),
    APPROVED                     (true,  false),
    APPROVED_BY_COUNTRY_DIRECTOR (true,  false),
    APPROVED_BY_CORPORATE_MANAGER(true,  false),
    PENDING_BANK_ACCOUNT_CHECK   (false, false),
    PAYABLE                      (false, false),
    PAID                         (false, true ),
    PENDING_IN_CODA_BOOKS        (false, false);

    @Getter
    private final boolean approval;
    @Getter
    private final boolean finalState;

    private IncomingInvoiceApprovalState(
            final boolean approval,
            final boolean finalState) {
        this.approval = approval;
        this.finalState = finalState;
    }

    public boolean isNotFinal() { return ! isFinalState(); }

}
