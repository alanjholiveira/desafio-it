package br.com.deliverit.desafio.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Classe contento DTO Conta a Pagar
 */
@Getter
@Setter
@NoArgsConstructor
public class ContaPagarDTO {

    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Valor original não pode ser nulo")
    private Double valor;

    @NotNull(message = "Data de Vencimento não pode ser nula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dtVencimento;

    @NotNull(message = "Data de Pagamento não pode ser nula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dtPagamento;
    
}
