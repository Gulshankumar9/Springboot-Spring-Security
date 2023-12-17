package com.eazybytes.springsecOAUTH2GitHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecOAUTH2GitHubConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain (HttpSecurity http) throws Exception {

        http.authorizeHttpRequests ().anyRequest ().authenticated ().and ().oauth2Login ();
        return http.build ();
    }

   /* @Bean
    public ClientRegistrationRepository clientRepository () {

        ClientRegistration clientReg = clientRegistration ();
        return new InMemoryClientRegistrationRepository (clientReg);
    }

    private ClientRegistration clientRegistration () {

        return CommonOAuth2Provider.GITHUB.getBuilder ("github").clientId ("1535787326094ddc4ce9")
                                          .clientSecret ("348f2cb7604952505ac161f45f9c1d240d399860").build ();
    }*/

}