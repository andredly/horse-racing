package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.converter.RacecourseConverter;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;
import com.charniauski.training.horsesrace.web.security.Security;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/racecourses")
public class RacecourseController extends AbstractController<Racecourse,RacecourseDTO> implements IRacecourseController{

    @Inject
    private RacecourseService racecourseService;

    @Inject
    private RacecourseConverter converter;

    @GetMapping(value = "/search/racecourse/{name}")
    @Security(role = "ROLE_ADMIN")
    @Override
    public ResponseEntity<RacecourseDTO> getByName(
            @PathVariable String name) {
        Racecourse racecourse = racecourseService.getByName(name);
        checkNull(racecourse,name);
        return new ResponseEntity<>(converter.toDTO(racecourse), HttpStatus.OK);
    }

    @GetMapping(value = "/search/all/currentDate")
    @Override
    public ResponseEntity<List<RacecourseDTO>> getAllAfterCurrentDate() {
        List<Racecourse> racecourses = racecourseService.getAllAfterCurrentDate();
        return new ResponseEntity<>(converter.toListDTO(racecourses), HttpStatus.OK);
    }

    @Override
    public GenericConverter<Racecourse,RacecourseDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return racecourseService;
    }
}
