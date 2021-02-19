package br.com.deliverit.desafio.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Classe DTO para Listagem de Contas a Pagar
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ContaPagarListagemDTO {

    private Long id;
    private String nome;
    private Double valorOriginal;
    private Double valorCorrigido;
    private int diasAtraso;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dtVencimento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dtPagamento;
    
}
