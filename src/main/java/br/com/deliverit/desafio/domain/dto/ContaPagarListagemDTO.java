package br.com.deliverit.desafio.domain.dto;

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
    private LocalDate dtVencimento;
    private LocalDate dtPagamento;
    
}
