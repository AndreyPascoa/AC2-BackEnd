package com.example.ac2.controller;

import com.example.ac2.models.Funcionario;
import com.example.ac2.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public Funcionario adicionar(@RequestBody Funcionario funcionario) {
        return service.adicionar(funcionario);
    }

    @GetMapping("/todos")
    public List<Funcionario> listarTodos() {
        return service.listarTodos();
    }
}
