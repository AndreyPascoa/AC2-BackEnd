package com.example.ac2.controller;

import com.example.ac2.models.Setor;
import com.example.ac2.service.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService service;

    @PostMapping
    public Setor adicionar(@RequestBody Setor setor) {
        return service.adicionar(setor);
    }

    @GetMapping("/todos")
    public List<Setor> listarTodos() {
        return service.listarTodos();
    }
}
