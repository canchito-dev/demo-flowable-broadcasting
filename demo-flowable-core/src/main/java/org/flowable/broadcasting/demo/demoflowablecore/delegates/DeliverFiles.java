package org.flowable.broadcasting.demo.demoflowablecore.delegates;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.delegate.TriggerableActivityBehavior;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("deliverFiles")
@Scope("prototype")
public class DeliverFiles implements JavaDelegate, TriggerableActivityBehavior, Serializable {

    @Override
    public void execute(DelegateExecution delegateExecution) {

    }

    @Override
    public void trigger(DelegateExecution delegateExecution, String signalName, Object signalData) {

    }
}