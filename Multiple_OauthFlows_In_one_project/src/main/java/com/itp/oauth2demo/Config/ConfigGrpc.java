package com.itp.oauth2demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ConfigGrpc {

    @Bean
    public SecurityFilterChain securityFilterChainGrcp(HttpSecurity http) throws Exception {

        return http.securityMatcher("/api/grpc/**")
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(r->r.requestMatchers("/hello/get_secured_data/**").permitAll().anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.authenticationManagerResolver(authenticationManagerResolver))
                .build();

    }

    JwtIssuerAuthenticationManagerResolver authenticationManagerResolver = JwtIssuerAuthenticationManagerResolver
            .fromTrustedIssuers("http://0.0.0.0:8080/realms/grpc_relam");


}
