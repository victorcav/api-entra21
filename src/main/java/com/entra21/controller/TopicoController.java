package com.entra21.controller;

import com.entra21.controller.dto.AtualizarDadoDTO;
import com.entra21.controller.dto.DetalhesDoTopicoDTO;
import com.entra21.controller.dto.TopicoDTO;

import com.entra21.controller.dto.TopicoFORM;
import com.entra21.model.Topico;
import com.entra21.repositories.CursoRepository;
import com.entra21.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    /*
        @GetMapping
    public List<TopicoDTO> listar(){
        List<Topico> topicoList = topicoRepository.findAll();
        return TopicoDTO.converter(topicoList);
    }
     */


    @GetMapping
    public List<TopicoDTO> listar(String nomeCurso){
        List<Topico> topicoList;

        if (nomeCurso == null){
            topicoList = topicoRepository.findAll();
        }else {
            topicoList = topicoRepository.carregarPorNomeDoCurso(nomeCurso);
        }

        return TopicoDTO.converter(topicoList);
    }

    /*
        @PostMapping
    public void cadastrar(@RequestBody @Valid TopicoFORM topicoForm, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoForm.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
    }
     */

    @PostMapping
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoFORM topicoForm, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoForm.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarDadoDTO form){
        Optional<Topico> topicoPesquidado = topicoRepository.findById(id);

        if(topicoPesquidado.isPresent()){
            Topico topico = form.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDTO(topico));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);

        if(topico.isPresent()){
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /*
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        topicoRepository.deleteById(id);
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);

        if(topico.isPresent()){
            return ResponseEntity.ok(new DetalhesDoTopicoDTO(topico.get()));
        }
        return ResponseEntity.notFound().build();

    }


}
