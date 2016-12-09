package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.RaceDetailService;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.converter.RaceDetailConverter;
import com.charniauski.training.horsesrace.web.dto.RaceDetailDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/raceDetails")
public class RaceDetailController extends AbstractController<RaceDetail,RaceDetailDTO>{

    @Inject
    private RaceDetailService raceDetailService;

    @Inject
    private RaceDetailConverter converter;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/raceCard/{raceCardId}/horse/{horseId}")
    public ResponseEntity<RaceDetailDTO> getByRaceCardAndHorse(
            @PathVariable Long raceCardId, Long horseId) {
        RaceDetail raceDetail = raceDetailService.getByRaceCardAndHorse(raceCardId,horseId);
        checkNull(raceDetail,raceCardId,horseId);
        return new ResponseEntity<>(converter.toDTO(raceDetail), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/raceCard/{raceCardId}/command/{commandId}")
    public ResponseEntity<RaceDetailDTO> getByRaceCardAndCommand(
            @PathVariable Long raceCardId, Long horseId) {
        RaceDetail raceDetail = raceDetailService.getByRaceCardAndHorse(raceCardId,horseId);
        checkNull(raceDetail,raceCardId,horseId);
        return new ResponseEntity<>(converter.toDTO(raceDetail), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/raceCard/{raceCardId}/numberStartBox/{numberStartBox}")
    public ResponseEntity<RaceDetailDTO> getByRaceCardAndNumberStartBox(
            @PathVariable Long raceCardId, Long numberStartBox) {
        RaceDetail raceDetail = raceDetailService.getByRaceCardAndHorse(raceCardId,numberStartBox);
        checkNull(raceDetail,raceCardId,numberStartBox);
        return new ResponseEntity<>(converter.toDTO(raceDetail), HttpStatus.OK);
    }


    @GetMapping(value = "/search/all/raceCard/{raceCardId}")
    public ResponseEntity<List<RaceDetailDTO>> getAllByRaceCard(@PathVariable Long raceCardId) {
        List<RaceDetail> raceDetail = raceDetailService.getAllByRaceCard(raceCardId);
        return new ResponseEntity<>(converter.toListDTO(raceDetail), HttpStatus.OK);
    }

    @Override
    public GenericConverter<RaceDetail,RaceDetailDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return raceDetailService;
    }
}
