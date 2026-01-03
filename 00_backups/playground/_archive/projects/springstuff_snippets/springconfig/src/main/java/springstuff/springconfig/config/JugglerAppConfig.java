package springstuff.springconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springstuff.jugglers.ChainsawJuggler;
import springstuff.jugglers.Juggler;
import springstuff.springconfig.JugglerApp;
import springstuff.springconfig.TheApp;

@Configuration
public class JugglerAppConfig {

    @Bean
    public Juggler juggler() {
        return new ChainsawJuggler();
    }

    @Bean
    public TheApp theApp(Juggler juggler) {
        return new JugglerApp(juggler);
    }
}
