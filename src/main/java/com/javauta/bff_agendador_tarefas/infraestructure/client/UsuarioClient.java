package com.javauta.bff_agendador_tarefas.infraestructure.client;

import com.javauta.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.javauta.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.javauta.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.javauta.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuariPorEmail(@RequestParam("email") String email,
                                           @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    // Spring security deixando mais seguro o login do usuario
    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);



    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization")String token);


    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization")String token);


    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam ("id") Long id,
                                         @RequestHeader("Authorization")String token);


    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam ("id") Long id,
                                         @RequestHeader("Authorization")String token);


    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader ("Authorization") String token);


    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);


    }

