package com.casecep.bff.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfiguracaoRest {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
