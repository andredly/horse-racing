package com.charniauski.training.horsesrace.web.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericConverter<T, D> {

    T toEntity(D dto);

    D toDTO(T entity);

    D toDTO(T entity, String language);

    default List<D> toListDTO(final Collection<T> entities, String lang) {
        return entities.stream()
                .map(entity -> toDTO(entity, lang))
                .collect(Collectors.toList());
    }

    default List<D> toListDTO(final Collection<T> entities) {
        return toListDTO(entities,null);
    }


    default List<T> toListEntity(final Collection<D> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}