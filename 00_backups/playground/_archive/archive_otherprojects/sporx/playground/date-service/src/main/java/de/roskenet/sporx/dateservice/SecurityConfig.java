package de.roskenet.sporx.dateservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

//@ComponentScan
//@EnableAutoConfiguration
@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.authorizeRequests().antMatchers("/openforall").permitAll();
        http.authorizeRequests().anyRequest().hasAuthority("SCOPE_email");
//                .and()
//                .csrf().disable()
//                .authorizeRequests().anyRequest().hasRole("USER").and()
//                .httpBasic();
    }
}