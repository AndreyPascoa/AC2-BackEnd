package com.example.ac2.controller;

import com.example.ac2.DTO.ProjetoDTO;
import com.example.ac2.models.Projeto;
import com.example.ac2.service.ProjetoService;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public Projeto adicionar(@RequestBody ProjetoDTO dto) {
        return service.adicionar(dto);
    }

    @GetMapping("/{id}")
    public Projeto buscarProjetoPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        service.vincularFuncionario(idProjeto, idFuncionario);
    }

    @GetMapping
    public List<Projeto> buscarPorPeriodo(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
        return service.buscarPorPeriodo(inicio, fim);
    }

    @GetMapping("/funcionario/{idFuncionario}")
    public List<Projeto> buscarPorFuncionario(@PathVariable Integer idFuncionario) {
        return service.buscarPorFuncionario(idFuncionario);
    }

    @GetMapping("/todos")
    public List<Projeto> listarTodos() {
        return service.listarTodos();
    }

}
