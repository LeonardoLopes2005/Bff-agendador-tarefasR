package com.javauta.bff_agendador_tarefas.infraestructure.client.config;

import com.javauta.bff_agendador_tarefas.infraestructure.exceptions.BusinessException;
import com.javauta.bff_agendador_tarefas.infraestructure.exceptions.ConflitException;
import com.javauta.bff_agendador_tarefas.infraestructure.exceptions.ResourceNotFoundException;
import com.javauta.bff_agendador_tarefas.infraestructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeingnError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response){

        switch (response.status()){
            case 409:
                return new ConflitException("Erro atributo ja existente ");
            case 403:
                return new ResourceNotFoundException("Erro atributo nao encontrado ");
            case 401:
                return new UnauthorizedException("Erro usuario nao autorizado ");
            default:
                return new BusinessException("Erro de servidor ");
        }
    }
}
