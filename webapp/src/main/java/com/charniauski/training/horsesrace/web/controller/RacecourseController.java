package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.web.converter.RacecourseConverter;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/racecourses")
public class RacecourseController {

    @Inject
    private RacecourseService racecourseService;

    @Inject
    private RacecourseConverter converter;

    @GetMapping
    public ResponseEntity<List<RacecourseDTO>> getAll() {
        List<Racecourse> all = racecourseService.getAll();
        return new ResponseEntity<>(converter.toListDTO(all), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RacecourseDTO> getById(
            @PathVariable Long id) {
        Racecourse racecourse = racecourseService.get(id);
        if (racecourse == null) {
            throw new NoSuchEntityException("Do not found entity");
        }
        return new ResponseEntity<>(converter.toDTO(racecourse), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<RacecourseDTO> create(
            @RequestBody @Valid RacecourseDTO racecourseDTO) {
        racecourseService.save(converter.toEntity(racecourseDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Void> update(
            @RequestBody RacecourseDTO racecourseDTO,
            @PathVariable Long id) {
        Racecourse racecourse = converter.toEntity(racecourseDTO);
        racecourse.setId(id);
        racecourseService.save(racecourse);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        racecourseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
