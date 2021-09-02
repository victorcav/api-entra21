package com.entra21.controller;

import com.entra21.model.Curso;
import com.entra21.model.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;


@Controller
public class TopicoController {

    @RequestMapping("/topicos")
    @ResponseBody
    public List<Topico> listarTudo(){

        Curso c = new Curso();
        c.setId(19L);
        c.setNome("Spring Boot");

        Topico t = new Topico("Duvida sobre Controller", "Oi, estou iniciando os estudos em Spring", c);

        return Arrays.asList(t);

    }
}
