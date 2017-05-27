package org.estatio.capex.dom.documents;

import org.apache.isis.applib.annotation.Mixin;

import org.estatio.dom.asset.Property;
import org.estatio.dom.invoice.DocumentTypeData;

@Mixin(method = "act")
public class HasDocument_categoriseAsInvoice
        extends HasDocument_categoriseAbstract {

    // workaround for https://issues.apache.org/jira/browse/ISIS-1628
    private final HasDocument hasDocument;

    public HasDocument_categoriseAsInvoice(final HasDocumentAbstract hasDocument) {
        super(hasDocument, DocumentTypeData.INCOMING_INVOICE);
        this.hasDocument = hasDocument;
    }

    // workaround for https://issues.apache.org/jira/browse/ISIS-1628
    @Override
    public HasDocument act(final Property property, final boolean goToNext) {
        return super.act(property, goToNext);
    }

}