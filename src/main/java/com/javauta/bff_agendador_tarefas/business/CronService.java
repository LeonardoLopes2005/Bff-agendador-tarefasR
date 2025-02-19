package com.javauta.bff_agendador_tarefas.business;

import com.javauta.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.javauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;


    @Value("${usuario.email}")
    private String email;
    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void BuscaTarefasProximaHora(){
        String token = login(converteParaRequestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);

        List<TarefasDTOResponse> listaTarefas = tarefasService.buscaTarefasAgendadasPorPeriodo(horaFutura, horaFuturaMaisCinco, token);

        log.info("Tarefas encontradas" + listaTarefas);
        listaTarefas.forEach(tarefa -> {emailService.enviaEmail(tarefa);
            log.info("Email enviado para o Usuario" + tarefa.getEmailUsuario());
            tarefasService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(),
                    token);});
        log.info("Finalizada a notificacao de tarefas");

    }

    public String login(LoginRequestDTO dto){
        return usuarioService.loginUsuario(dto);
    }


    public LoginRequestDTO converteParaRequestDTO(){
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }

}
