package com.itp.oauth2demo.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class Config {

    @Bean
    public SecurityFilterChain securityFilterChainRest(HttpSecurity http) throws Exception {

        return http
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(r->r.requestMatchers("/hello/get_secured_data/**").permitAll().anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()))
                .build();

    }

}
