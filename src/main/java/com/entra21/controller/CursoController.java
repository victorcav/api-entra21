package com.entra21.controller;

import com.entra21.model.Categoria;
import com.entra21.model.Curso;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class CursoController {

    @RequestMapping("/cursos")
    @ResponseBody
    public List<Curso> listarTudo(){

        Curso springWeb = new Curso(1L,"Spring Web", new Categoria(10L,"Web"));
        Curso postgreeSQL = new Curso(2L,"Postgree SQL", new Categoria(11L,"Banco de Dados"));
        Curso css = new Curso(3L,"CSS", new Categoria(12L,"Design"));

        return Arrays.asList(springWeb,postgreeSQL,css);
    }

}
