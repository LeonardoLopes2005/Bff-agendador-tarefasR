package com.javauta.bff_agendador_tarefas.infraestructure.client.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeingnConfig {

    @Bean
    public FeingnError feingnError(){
        return new FeingnError();
    }
}
