package com.example.ac2.repository;

import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f.projetos FROM Funcionario f WHERE f.id = :id")
    List<Projeto> buscarProjetosPorFuncionario(@Param("id") Integer id);
}

