package com.example.ac2.service;

import com.example.ac2.models.Projeto;
import com.example.ac2.DTO.ProjetoDTO;
import com.example.ac2.models.Funcionario;
import com.example.ac2.repository.ProjetoRepository;
import com.example.ac2.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public Projeto adicionar(ProjetoDTO dto) {
        Projeto projeto = new Projeto();
        projeto.setDescricao(dto.getDescricao());
        projeto.setDataInicio(dto.getDataInicio());
        projeto.setDataFim(dto.getDataFim());
        return projetoRepository.save(projeto);
    }

    public Projeto buscarPorId(Integer id) {
        return projetoRepository.buscarProjetoComFuncionarios(id)
                .orElseThrow(() -> new RuntimeException("Projeto com ID " + id + " não encontrado"));
    }

    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    public List<Projeto> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return projetoRepository.findByDataInicioBetween(inicio, fim);
    }

    public List<Projeto> buscarPorFuncionario(Integer idFuncionario) {
        return funcionarioRepository.buscarProjetosPorFuncionario(idFuncionario);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }
}
