package org.estatio.capex.dom.task.policy;

/**
 * A view model that wraps an underlying (entity) domain object.
 */
public interface ViewModelWrapper<T> {

    T getDomainObject();

}
