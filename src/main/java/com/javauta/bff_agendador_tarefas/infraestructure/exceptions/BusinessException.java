package com.javauta.bff_agendador_tarefas.infraestructure.exceptions;


public class BusinessException extends RuntimeException {

    public BusinessException(String mensagem){super(mensagem);
    }
    public BusinessException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
