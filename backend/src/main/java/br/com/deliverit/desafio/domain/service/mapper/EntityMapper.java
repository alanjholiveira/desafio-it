package br.com.deliverit.desafio.domain.service.mapper;

import java.util.List;

/**
 * Interface para mapear um dto ou entidade generico.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */
public interface EntityMapper<D, E> {

    E toEntity(D dto);
    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);
    List <D> toDto(List<E> entityList);

}
