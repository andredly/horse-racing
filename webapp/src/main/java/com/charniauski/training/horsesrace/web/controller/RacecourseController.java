package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.services.wrapper.RacecourseWrapper;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.converter.RacecourseConverter;
import com.charniauski.training.horsesrace.web.converter.RacecourseWrapperConverter;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;
import com.charniauski.training.horsesrace.web.dto.wrapper.RacecourseWrapperDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/racecourses")
public class RacecourseController extends AbstractController<Racecourse, RacecourseDTO> {

    @Inject
    private RacecourseService racecourseService;

    @Inject
    private RacecourseConverter converter;
    @Inject
    private RacecourseWrapperConverter wrapperConverter;

    @GetMapping(value = "/search/racecourse/{name}")
    @PreAuthorize("isAnonymous() or isAuthenticated()")
    public ResponseEntity<RacecourseDTO> getByName(
            @PathVariable String name) {
        Racecourse racecourse = racecourseService.getByName(name);
        checkNull(racecourse, name);
        return new ResponseEntity<>(converter.toDTO(racecourse), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/all/current-date")
    public ResponseEntity<List<RacecourseDTO>> getAllAfterCurrentDate() {
        List<Racecourse> racecourses = racecourseService.getAllAfterCurrentDate();
        return new ResponseEntity<>(converter.toListDTO(racecourses), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/all-data/current-data")
    public ResponseEntity<List<RacecourseWrapperDTO>> getAllDataForAllRacecourseWithRaceCardsAfterCurrentDate() {
        List<RacecourseWrapper> racecourses = racecourseService.getAllRacecourseWithRaceCardsAfterCurrentDate();
        return new ResponseEntity<>(wrapperConverter.toListDTO(racecourses), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/all-data/current-data/{racecourseId}")
    public ResponseEntity<RacecourseWrapperDTO> getAllDataRacecourseWithRaceCardsAfterCurrentDate(@PathVariable Long racecourseId) {
        RacecourseWrapper racecourseWrapper = racecourseService.getAllDataForRacecourseWithRaceCardsAfterCurrentDate(racecourseId);
        checkNull(racecourseWrapper, racecourseId);
        return new ResponseEntity<>(wrapperConverter.toDTO(racecourseWrapper), HttpStatus.OK);
    }

    @Override
    public GenericConverter<Racecourse, RacecourseDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return racecourseService;
    }
}
