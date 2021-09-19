package com.entra21.controller.dto;

import com.entra21.model.Resposta;
import com.entra21.model.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RespostaDTO {

    private String mensagem;
    private Topico topico;
    private LocalDateTime dataCriacao;

    public RespostaDTO(Resposta resposta){
        this.mensagem = resposta.getMensagem();
        this.topico = resposta.getTopico();
        this.dataCriacao = resposta.getDataCriacao();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public static List<RespostaDTO> converter(List<Resposta> respostas){
        return respostas.stream().map(RespostaDTO::new).collect(Collectors.toList());
    }
}
