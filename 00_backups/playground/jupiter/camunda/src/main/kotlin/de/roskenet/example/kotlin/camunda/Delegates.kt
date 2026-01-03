package de.roskenet.example.kotlin.camunda

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.ExecutionListener
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class MyBottomListener : ExecutionListener {
    @Throws(Exception::class)
    override fun notify(delegateExecution: DelegateExecution) {
        println("I ended in the BOTTOM!")
    }
}

@Component
class MyDelegate : JavaDelegate {
    @Throws(java.lang.Exception::class)
    override fun execute(delegateExecution: DelegateExecution) {
        delegateExecution.setVariable("end", "bottom")
        println("Ich bin tatsaechlich hier!")
    }
}

@Component
class RightEnd : ExecutionListener {
    @Throws(java.lang.Exception::class)
    override fun notify(delegateExecution: DelegateExecution) {
        println("I am in the right end!")
    }
}