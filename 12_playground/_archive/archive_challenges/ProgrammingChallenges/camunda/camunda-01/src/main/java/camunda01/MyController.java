package camunda01;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private RuntimeService runtimeService;

    public MyController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public static class Process {
        public String name;
        public String id;
    }

    @GetMapping("/start")
    public Process startSomething() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Process_1");

        Process process = new Process();
        process.name = processInstance.getCaseInstanceId();

        return process;
    }
}
