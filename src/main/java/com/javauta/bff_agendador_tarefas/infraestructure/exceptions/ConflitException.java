package com.javauta.bff_agendador_tarefas.infraestructure.exceptions;

public class ConflitException extends RuntimeException{

    public ConflitException(String mensagem){
        super (mensagem);
    }

    public ConflitException(String mensagem, Throwable throwable){
        super (mensagem);
    }
}
