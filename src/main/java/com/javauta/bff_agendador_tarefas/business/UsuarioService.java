package com.javauta.bff_agendador_tarefas.business;


import com.javauta.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.javauta.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.javauta.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.javauta.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.javauta.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.javauta.bff_agendador_tarefas.infraestructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO usuarioDTO) {
        return client.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuariPorEmail(email, token);
    }

    // Deleta usuario pro email
    public void deletaUsuarioPorEmail(String email, String token) {
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token) {
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto) {
        return client.cadastraEndereco(dto, token);
    }


    public TelefoneDTOResponse cadastroTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastraTelefone(dto, token);
    }
}
