package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/racecourses")
public class RacecourseController {

    @Inject
    private RacecourseService racecourseService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RacecourseDTO>> getAll() {
        List<Racecourse> all = racecourseService.getAll();

        List<RacecourseDTO> converted = new ArrayList<>();
        for (Racecourse racecourse : all) {
            converted.add(entity2model(racecourse));
        }

        return new ResponseEntity<List<RacecourseDTO>>(converted,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{authorId}", method = RequestMethod.GET)
    public ResponseEntity<RacecourseDTO> getById(
            @PathVariable Long authorId) {
        Racecourse racecourse = racecourseService.get(authorId);
        return new ResponseEntity<RacecourseDTO>(entity2model(racecourse),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<RacecourseDTO> createRacecourse(
            @RequestBody @Valid RacecourseDTO racecourseDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<RacecourseDTO>(HttpStatus.BAD_REQUEST);
        }
        racecourseService.save(model2entity(racecourseDTO));
        return new ResponseEntity<RacecourseDTO>(HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{authorId}", method = RequestMethod.POST)
    public ResponseEntity<Void> updateAuthor(
            @RequestBody RacecourseDTO racecourseDTO,
            @PathVariable Long authorId) {
        Racecourse racecourse = model2entity(racecourseDTO);
        racecourse.setId(authorId);
        racecourseService.save(racecourse);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @RequestMapping(value = "/{authorId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long authorId) {
        racecourseService.delete(authorId);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    private RacecourseDTO entity2model(Racecourse racecourse) {
        RacecourseDTO e = new RacecourseDTO();
        e.setCountry(racecourse.getCountry());
        e.setId(racecourse.getId());
        e.setName(racecourse.getName());
        return e;
    }

    private Racecourse model2entity(RacecourseDTO racecourseDTO) {
        Racecourse e = new Racecourse();
        e.setCountry(racecourseDTO.getCountry());
        e.setId(racecourseDTO.getId());
        e.setName(racecourseDTO.getName());
        return e;
    }

}
