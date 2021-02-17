package br.com.deliverit.desafio.domain.service;

import br.com.deliverit.desafio.domain.entity.ContaPagar;
import br.com.deliverit.desafio.domain.entity.Regra;

/**
 * Interface Regra Service
 */
public interface RegraService {

    /**
     * Método para calcular Multa e Juros
     * @param contaPagar
     * @return
     */
    Double calcularMultaJuros(ContaPagar contaPagar);

    /**
     * Método para calcular quntidade de dias vencido
     * @param contaPagar
     * @return
     */
    Integer calcularDiasAtraso(ContaPagar contaPagar);

    /**
     * Método para obter regra
     * @return
     */
    Regra obterRegra(ContaPagar contaPagar);
}
