package de.roskenet.gallium;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands {

	@ShellMethod
	public String helloWorld(
			@ShellOption(help = "The name you want to greet!", defaultValue = "spring") String name,
			@ShellOption(help = "The age of this person", defaultValue = "42") int age
	) {
		return "Hello " + name + "!\nYou are " + age + " years old.";
	}

	@ShellMethod
	public String callCatFacts(
			@ShellOption(help = "The number of cat facts you want to get", defaultValue = "1") int count
	) {
		var builder = new RestTemplateBuilder().rootUri("https://catfact.ninja")
				.messageConverters(new MappingJackson2HttpMessageConverter());

		var catFactPage = builder.build().getForObject("/facts?limit=" + count, CatFactPage.class);

		return catFactPage.data().stream()
				.map(CatFact::fact)
				.reduce((a, b) -> a + "\n" + b)
				.orElse("");
	}
}