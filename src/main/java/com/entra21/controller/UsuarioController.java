package com.entra21.controller;

import com.entra21.model.Usuario;
import com.entra21.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    @ResponseBody
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    public void cadastrar(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
