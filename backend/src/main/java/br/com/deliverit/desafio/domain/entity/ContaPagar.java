package br.com.deliverit.desafio.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Classe reponsável pela entidade Conta a Pagar
 */
@Entity
@Table(name = "tb_conta_pagar")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ContaPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "valor_original", nullable = false)
    private Double valorOriginal;

    @Column(name = "valor_corrigido")
    private Double valorCorrigido;

    @Column(name = "dt_vencimento", nullable = false)
    private LocalDate dtVencimento;

    @Column(name = "dt_pagamento", nullable = false)
    private LocalDate dtPagamento;

    @Column(name = "descricao_regra")
    private String descricaoRegra;

    @Column(name = "dias_atraso")
    private int diasAtraso;

    @Column(name = "multa")
    private Double multa;

    @Column(name = "juros")
    private Double juros;

}
