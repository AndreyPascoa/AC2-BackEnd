package com.example.ac2.repository;

import com.example.ac2.models.Setor;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

    @Query("SELECT s FROM Setor s LEFT JOIN FETCH s.funcionarios WHERE s.id = :id")
    Optional<Setor> buscarComFuncionarios(@Param("id") Integer id);
}

