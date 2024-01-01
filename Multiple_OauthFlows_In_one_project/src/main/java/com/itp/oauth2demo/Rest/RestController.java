package com.itp.oauth2demo.Rest;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/api/rest")
public class RestController {

    @GetMapping("/secureddata")
    public String Test(){

        return "secure_data";
    }

    @GetMapping("/get_secured_data")
    public Mono<Object> getTestString(@RegisteredOAuth2AuthorizedClient("client1") OAuth2AuthorizedClient authorizedClient){
         WebClient webClient = WebClient.create("http://localhost:8081");

      return  webClient.get().uri("/test/secureddata").headers(header->header.setBearerAuth(authorizedClient.getAccessToken().getTokenValue()))
                .retrieve().bodyToMono(String.class)
               .map(string -> "Retrieved using Client Credentials Grant Type: " + string);

    }

    @GetMapping("/get_secured_data/client2")
    public Mono<Object> getTestStringWithClient2(@RegisteredOAuth2AuthorizedClient("client2") OAuth2AuthorizedClient authorizedClient){
        WebClient webClient = WebClient.create("http://localhost:8081");

        return  webClient.get().uri("/test/secureddata").headers(header->header.setBearerAuth(authorizedClient.getAccessToken().getTokenValue()))
                .retrieve().bodyToMono(String.class)
                .map(string -> "Retrieved using Client Credentials Grant Type: " + string);

    }
}
