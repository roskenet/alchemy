package de.felixroske.spring.shelldemo

import org.jline.utils.AttributedString
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.shell.jline.PromptProvider

//	runApplication<ShellDemoApplication>(*args)
//fun main(args: Array<String>) {
@SpringBootApplication
class ShellDemoApplication

@Configuration
class ShellDemoApplicationConfig {
    @Bean
    fun myPromptProvider(): PromptProvider {
        return PromptProvider { AttributedString("my-shell: > ") }
    }
}

fun main(args: Array<String>) {
    runApplication<ShellDemoApplication>(*args)
}

//
//}

//@SpringBootApplication
//public class SpringShellSample {
//
//	public static void main(String[] args) throws Exception {
//		ConfigurableApplicationContext context = SpringApplication.run(SpringShellSample.class, args);
//	}
//
//	@Bean
//	public PromptProvider myPromptProvider() {
//		return () -> new AttributedString("my-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
//	}
//}
