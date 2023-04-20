package config;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception{
        authBuilder.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return null;
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return false;
            }
        });
    }
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/login")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/users/login")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/users/add")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("users/edit/**")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/users/delete/**")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/products/**")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/products/add")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("products/edit/**")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/products/delete/**")).permitAll()
                .anyRequest().permitAll();
    }
}


