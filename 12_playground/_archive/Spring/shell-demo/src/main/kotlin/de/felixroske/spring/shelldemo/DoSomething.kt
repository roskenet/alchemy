package de.felixroske.spring.shelldemo

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
public class TranslationCommands {
    @ShellMethod("Translate text from one language to another.")
    fun translate(
    @ShellOption  text: String,
    @ShellOption(defaultValue = "en_US") from: String,
    @ShellOption to: String
    ) : String {
        return "Cool! You entered: ${from} and ${to} for ${text}"
    }
}