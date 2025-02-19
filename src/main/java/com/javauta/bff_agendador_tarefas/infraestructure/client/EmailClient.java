package com.javauta.bff_agendador_tarefas.infraestructure.client;

import com.javauta.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.javauta.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.javauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javauta.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.javauta.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    void enviarEmail(@RequestBody TarefasDTOResponse dto);


    }

