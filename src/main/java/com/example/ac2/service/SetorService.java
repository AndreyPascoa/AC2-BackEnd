package com.example.ac2.service;

import com.example.ac2.models.Setor;
import com.example.ac2.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository setorRepository;

    public Setor adicionar(Setor setor) {
        return setorRepository.save(setor);
    }

    public List<Setor> listarTodos() {
        return setorRepository.findAll();
    }
}
