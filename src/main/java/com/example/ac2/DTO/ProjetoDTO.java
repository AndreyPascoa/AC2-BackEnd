package com.example.ac2.DTO;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ProjetoDTO {
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}

