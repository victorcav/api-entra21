package com.entra21.controller;

import com.entra21.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class RespostaController {

    @RequestMapping("/resposta")
    @ResponseBody
    public List<Resposta> listaTudo(){

        /*
        Resposta r1 = new Resposta(10L,"Utilizar o comando class do Java",
        new Topico(10L, "Funcoes do Css", "Duvida simples de colors",
                      new Curso(4L, "HTML e Css", new Categoria(5L, "Front-End"))),
                      new Usuario(1L, "Victor", "victor@gmail.com", "12345678"));
         */


        return Arrays.asList();

    }
}
