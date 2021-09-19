package com.entra21.controller;

import com.entra21.controller.dto.RespostaDTO;
import com.entra21.model.*;
import com.entra21.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    RespostaRepository respostaRepository;


    @GetMapping
    public List<RespostaDTO> listar(){
        List<Resposta> respostaList = respostaRepository.findAll();
        return RespostaDTO.converter(respostaList);
    }
}
