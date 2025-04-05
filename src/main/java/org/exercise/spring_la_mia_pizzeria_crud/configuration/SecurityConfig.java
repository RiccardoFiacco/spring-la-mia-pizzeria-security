package org.exercise.spring_la_mia_pizzeria_crud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    @SuppressWarnings("removal")
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/pizzas/create", "/pizzas/update/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pizzas/**").hasAuthority("ADMIN")
                .requestMatchers("/pizzas/create", "/pizzas/update/**").hasAuthority("ADMIN") // Permette l'accesso a
                                                                                              // utenti con ruolo ADMIN
                                                                                              // a queste rotte
                .requestMatchers("/pizzas", "/pizzas/**").hasAnyAuthority("ADMIN", "USER") // Permette l'accesso a
                                                                                           // utenti con ruolo ADMIN o
                                                                                           // USER
                .requestMatchers("/**").permitAll() // Permette l'accesso a tutti gli utenti per tutte le altre
                                                    // richieste
                .and().formLogin()
                .and().logout()
                .and().exceptionHandling();
        return http.build();
    }

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        // questo rpovider usera x come servizio per recuperare gli utenti via username
        authProvider.setUserDetailsService(userDetailsService());
        // e passwordEncoder per codificare le password
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    DatabaseUserDetailService userDetailsService() {
        return new DatabaseUserDetailService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // Utilizza un PasswordEncoder delegato al
    }
}
