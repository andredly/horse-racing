package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.RaceCardService;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.converter.RaceCardConverter;
import com.charniauski.training.horsesrace.web.dto.RaceCardDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/raceCards")
public class RaceCardController extends AbstractController<RaceCard,RaceCardDTO>{

    @Inject
    private RaceCardService raceCardService;

    @Inject
    private RaceCardConverter converter;

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/all/{racecourseId}/currentDate")
    public ResponseEntity<List<RaceCardDTO>> getAllAfterCurrentDate(@PathVariable Long racecourseId) {
        List<RaceCard> raceCards = raceCardService.getAllByRacecourseAfterCurrentDate(racecourseId);
        return new ResponseEntity<>(converter.toListDTO(raceCards), HttpStatus.OK);
    }

//    @GetMapping(value = "/search/all/{racecourseId}/currentDate/three")
//    public ResponseEntity<List<RaceCardDTO>> getThreeNextAfterCurrentDate(@PathVariable Long racecourseId) {
//        List<RaceCard> raceCards = raceCardService.getThreeNextAfterCurrentDate(racecourseId);
//        return new ResponseEntity<>(converter.toListDTO(raceCards), HttpStatus.OK);
//    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/date/event/{eventId}")
    public ResponseEntity<Date> getByEventId(
            @PathVariable Long eventId) {
        Date date = raceCardService.getDateStartByEvent(eventId);
        checkNull(date,eventId);
        return new ResponseEntity<>(date, HttpStatus.OK);
    }

    @Override
    public GenericConverter<RaceCard,RaceCardDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return raceCardService;
    }
}
