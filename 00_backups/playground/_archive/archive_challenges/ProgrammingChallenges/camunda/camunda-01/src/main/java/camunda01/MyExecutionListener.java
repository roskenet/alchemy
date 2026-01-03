package camunda01;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class MyExecutionListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.out.println("Hallo aus dem ExecutionListener!");
    }
}
