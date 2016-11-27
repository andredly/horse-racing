package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


public abstract class AbstractController<T extends AbstractModel,D> {

    @GetMapping
    public ResponseEntity<List<D>> getAll() {
        List<T> all = getGenericService().getAll();
        return new ResponseEntity<>(getConverter().toListDTO(all), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<D> getById(
            @PathVariable Long id) {
        T entity = (T) getGenericService().get(id);
       checkNull(entity, id);
        return new ResponseEntity<>(getConverter().toDTO(entity), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<D> create(
            @RequestBody @Valid D dto) {
        getGenericService().save(getConverter().toEntity(dto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/all",produces = "application/json")
    public ResponseEntity<List<D>> createAll(
            @RequestBody @Valid List<D> dtos) {
        getGenericService().saveAll(getConverter().toListEntity(dtos));
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Void> update(
            @RequestBody D dto,
            @PathVariable Long id) {
        T entity = getConverter().toEntity(dto);
        entity.setId(id);
        getGenericService().save(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        getGenericService().delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public abstract GenericConverter<T, D> getConverter();

    public abstract GenericService getGenericService();

    void checkNull(Object checkObject, Object ... arg) {
        if (checkObject == null) {
            throw new NoSuchEntityException("Do not found entity for arg: "+ Arrays.toString(arg));
        }
    }

}
