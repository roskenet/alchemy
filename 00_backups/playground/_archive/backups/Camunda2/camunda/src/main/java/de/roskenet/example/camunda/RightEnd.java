package de.roskenet.example.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class RightEnd implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        System.out.println("I am in the right end!");
    }
}
