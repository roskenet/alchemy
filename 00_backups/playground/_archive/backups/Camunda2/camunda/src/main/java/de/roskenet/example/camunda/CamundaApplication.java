package de.roskenet.example.camunda;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class CamundaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private ProcessEngine processEngine;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started CamundaApplication");

		Set<String> deployments = processEngine.getManagementService().getRegisteredDeployments();
		ProcessInstance process001 = runtimeService.startProcessInstanceByKey("process_001");
//		System.out.println(process001.getProcessInstanceId());

	}
}
