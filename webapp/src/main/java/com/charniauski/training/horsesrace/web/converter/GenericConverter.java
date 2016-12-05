package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.web.anotation.Language;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericConverter<T, D> {

    T toEntity(D dto);

    D toDTO(T entity);

    D toDTO(T entity, String language);

    default List<D> toListDTO(final Collection<T> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    default List<T> toListEntity(final Collection<D> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}