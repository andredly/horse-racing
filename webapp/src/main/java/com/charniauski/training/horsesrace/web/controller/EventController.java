package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;
import com.charniauski.training.horsesrace.services.EventService;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.web.converter.EventConverter;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.dto.EventDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/events")
public class EventController extends AbstractController<Event,EventDTO>{

    @Inject
    private EventService eventService;

    @Inject
    private EventConverter converter;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping
    public ResponseEntity<List<EventDTO>> getAll(HttpServletRequest request) {
        String language = request.getHeader("Language");
        List<Event> all = eventService.getAll();
        return new ResponseEntity<>(converter.toListDTO(all,language), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/all/race-detail/{raceDetailId}")
    public ResponseEntity<List<EventDTO>> getAllByRaceDetail(@PathVariable Long raceDetailId) {
        List<Event> events = eventService.getAllByRaceDetail(raceDetailId);
        return new ResponseEntity<>(converter.toListDTO(events), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/all/result/{resultEvent}")
    public ResponseEntity<List<EventDTO>> getAllByResultEvent(@PathVariable ResultEvent resultEvent) {
        List<Event> events = eventService.getAllByResultEvent(resultEvent);
        return new ResponseEntity<>(converter.toListDTO(events), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/all/result/{resultEvent}/race-detail/{raceDetailId}")
    public ResponseEntity<List<EventDTO>> getAllByResultEventAndRaceDetail(@PathVariable ResultEvent resultEvent, Long raceDetailId) {
        List<Event> events = eventService.getAllByResultEventAndRaceDetail(resultEvent,raceDetailId);
        return new ResponseEntity<>(converter.toListDTO(events), HttpStatus.OK);
    }

    @Override
    public GenericConverter<Event,EventDTO > getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return eventService;
    }
}
