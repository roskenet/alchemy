package de.roskenet.gallium;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands {

	@ShellMethod(value = "Prints a greeting to the user")
	public String helloWorld(
			@ShellOption(help = "The name you want to greet!", defaultValue = "spring") String name,
			@ShellOption(help = "The age of this person", defaultValue = "42") int age
	) {
		return "Hello " + name + "!\nYou are " + age + " years old.";
	}

	@ShellMethod(value = "Prints a cat fact")
	public String callCatFacts(
			@ShellOption(help = "The max length of the fact you accept", defaultValue = "255") int maxlength
	) {
		var builder = new RestTemplateBuilder().rootUri("https://catfact.ninja")
				.messageConverters(new MappingJackson2HttpMessageConverter());

		var catFactPage = builder.build().getForObject("/fact?max_length=" + maxlength, CatFact.class);

		return catFactPage.fact();
	}
}