package com.back.back.controller;


import com.back.back.entity.Servico;
import com.back.back.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/buscarTodos")
    @CrossOrigin("http://localhost:3000")
    public List<Servico> buscarTodos(){
        return servicoService.buscarTodos();
    }

    @GetMapping("/pagamentosPedentes")
    @CrossOrigin("http://localhost:3000")
    public List<Servico> buscarServicosPagamentoPedente(){
        return servicoService.buscarServicosPagamentoPedente();
    }

    @GetMapping("/cancelados")
    @CrossOrigin("http://localhost:3000")
    public List<Servico> buscarServicosCancelado(){
        return servicoService.buscarServicosCancelado();
    }

    @PostMapping("/")
    @CrossOrigin("http://localhost:3000")
    public Servico inserir(@RequestBody Servico servico){
        return servicoService.inserir(servico);
    }

    @PutMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> cancelar(@PathVariable("id")Long id){
        servicoService.cancelarServico(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    @CrossOrigin("http://localhost:3000")
    public Servico alterar(@RequestBody Servico servico){
        return servicoService.alterar(servico);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> excluir(@PathVariable("id")Long id){
        servicoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
