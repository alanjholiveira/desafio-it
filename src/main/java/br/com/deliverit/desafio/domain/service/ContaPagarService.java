package br.com.deliverit.desafio.domain.service;

import br.com.deliverit.desafio.domain.dto.ContaPagarDTO;
import br.com.deliverit.desafio.domain.dto.ContaPagarListagemDTO;
import br.com.deliverit.desafio.infrastructure.exception.NotFoundException;

import javax.validation.Valid;
import java.util.List;

/**
 * Interface responsavel pela camanda Service Conta a Pagar
 */
public interface ContaPagarService {

    /**
     * Método listagem de conta a pagar
     * @return
     * @throws NotFoundException
     */
    List<ContaPagarListagemDTO> getAll() throws NotFoundException;

    /**
     * Método para salvar conta a pagar
     * @param dto
     * @return
     * @throws Exception
     */
    ContaPagarDTO save(@Valid ContaPagarDTO dto) throws Exception;

}
