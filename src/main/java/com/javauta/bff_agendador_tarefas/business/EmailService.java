package com.javauta.bff_agendador_tarefas.business;


import com.javauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javauta.bff_agendador_tarefas.infraestructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto){
         emailClient.enviarEmail(dto);
    }


}