package de.roskenet.example.kotlin.camunda

import org.camunda.bpm.engine.ProcessEngine
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.runtime.ProcessInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CamundaKotlinApplication: CommandLineRunner {

	@Autowired
	private lateinit var runtimeService: RuntimeService

	@Autowired
	private lateinit var defaultEngine: ProcessEngine

	override fun run(vararg args: String?) {

		println("Started CamundaApplication")

		val deployments: Set<String> = defaultEngine.getManagementService().getRegisteredDeployments()
		val process001: ProcessInstance = runtimeService.startProcessInstanceByKey("process_001")
	}

}

fun main(args: Array<String>) {
	runApplication<CamundaKotlinApplication>(*args)
}
