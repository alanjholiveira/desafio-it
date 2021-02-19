package br.com.deliverit.desafio.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Classe responsável pela Entidade Regras
 */
@Entity
@Table(name = "tb_regra")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Regra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dias_max")
    private int diasMax;

    @Column(name = "dias_min")
    private int diasMin;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "multa")
    private Double multa;

    @Column(name = "juros")
    private Double juros;

}
