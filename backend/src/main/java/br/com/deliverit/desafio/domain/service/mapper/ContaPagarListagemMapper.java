package br.com.deliverit.desafio.domain.service.mapper;

import br.com.deliverit.desafio.domain.dto.ContaPagarListagemDTO;
import br.com.deliverit.desafio.domain.entity.ContaPagar;
import org.mapstruct.Mapper;

/**
 * Interface responsável pela mappeamento dto/entidades
 * Codigo gerado automaticamente durante a compilação do projeto
 */
@Mapper(componentModel = "spring")
public interface ContaPagarListagemMapper extends EntityMapper<ContaPagarListagemDTO, ContaPagar> {
}
