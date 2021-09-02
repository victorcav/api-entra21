package com.entra21.controller;

import com.entra21.model.Categoria;
import com.entra21.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    @ResponseBody
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    public void cadastrar(@RequestBody Categoria categoria){
        categoriaRepository.save(categoria);
    }
}