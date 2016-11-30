package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ivc4 on 30.11.2016.
 */
public interface IGenericController<D> {

    ResponseEntity<List<D>> getAll();

    ResponseEntity<D> getById(Long id);

    ResponseEntity<D> create(D dto);

    ResponseEntity<List<D>> createAll(List<D> dtos);

    ResponseEntity<Void> update(D dto,Long id);

    ResponseEntity<Void> delete(Long id);
}
