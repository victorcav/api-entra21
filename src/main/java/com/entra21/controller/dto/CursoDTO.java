package com.entra21.controller.dto;

import com.entra21.model.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoDTO {

    private String nome;

    public  CursoDTO(Curso curso){
        this.nome = curso.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<CursoDTO> converter(List<Curso> cursos){
        return cursos.stream().map(CursoDTO::new).collect(Collectors.toList());
    }
}
