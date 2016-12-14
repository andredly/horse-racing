package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.RaceCardService;
import com.charniauski.training.horsesrace.services.wrapper.RaceCardWrapper;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.converter.RaceCardConverter;
import com.charniauski.training.horsesrace.web.converter.RaceCardWrapperConverter;
import com.charniauski.training.horsesrace.web.dto.RaceCardDTO;
import com.charniauski.training.horsesrace.web.dto.wrapper.RaceCardWrapperDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/race-cards")
public class RaceCardController extends AbstractController<RaceCard, RaceCardDTO> {

    @Inject
    private RaceCardService raceCardService;

    @Inject
    private RaceCardConverter converter;

    @Inject
    private RaceCardWrapperConverter wrapperConverter;

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/all/{racecourseId}/current-date")
    public ResponseEntity<List<RaceCardDTO>> getAllAfterCurrentDate(@PathVariable Long racecourseId) {
        List<RaceCard> raceCards = raceCardService.getAllByRacecourseAfterCurrentDate(racecourseId);
        return new ResponseEntity<>(converter.toListDTO(raceCards), HttpStatus.OK);
    }

    @GetMapping(value = "/all-data/{racecourseId}/current-date/three")
    public ResponseEntity<List<RaceCardWrapperDTO>> getAllDataThreeNextRaceCardsAfterCurrentDate(@PathVariable Long racecourseId) {
        List<RaceCardWrapper> raceCards = raceCardService.getAllDataForTreeRaceCardAfterCurrentDate(racecourseId);
        return new ResponseEntity<>(wrapperConverter.toListDTO(raceCards), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/all-data/{racecourseId}/current-date")
    public ResponseEntity<List<RaceCardWrapperDTO>> getAllDataRaceCardsAfterCurrentDate(@PathVariable Long racecourseId) {
        List<RaceCardWrapper> raceCards = raceCardService.getAllDataForAllRaceCardAfterCurrentDate(racecourseId);
        return new ResponseEntity<>(wrapperConverter.toListDTO(raceCards), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/all-data/interval")
    public ResponseEntity<List<RaceCardWrapperDTO>> getAllDataRaceCardsForIntervalTime(
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date firstDate,
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")Date lastDate) {
        List<RaceCardWrapper> raceCards = raceCardService.getAllDataForIntervalTime(firstDate, lastDate);
        return new ResponseEntity<>(wrapperConverter.toListDTO(raceCards), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/all-data/race-card/{raceCardId}")
    public ResponseEntity<RaceCardWrapperDTO> getAllDataRaceCard(@PathVariable Long raceCardId) {
        RaceCardWrapper raceCardWrapper = raceCardService.getAllDataForRaceCard(raceCardId);
        return new ResponseEntity<>(wrapperConverter.toDTO(raceCardWrapper), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/date/event/{eventId}")
    public ResponseEntity<Date> getByEventId(
            @PathVariable Long eventId) {
        Date date = raceCardService.getDateStartByEvent(eventId);
        checkNull(date, eventId);
        return new ResponseEntity<>(date, HttpStatus.OK);
    }

    @Override
    public GenericConverter<RaceCard, RaceCardDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return raceCardService;
    }
}
