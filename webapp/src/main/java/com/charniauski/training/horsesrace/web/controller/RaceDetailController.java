package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.RaceDetailService;
import com.charniauski.training.horsesrace.services.wrapper.RaceDetailWrapper;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.converter.RaceDetailConverter;
import com.charniauski.training.horsesrace.web.converter.RaceDetailWrapperConverter;
import com.charniauski.training.horsesrace.web.dto.RaceDetailDTO;
import com.charniauski.training.horsesrace.web.dto.wrapper.RaceDetailWrapperDTO;
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
@RequestMapping("/race-details")
public class RaceDetailController extends AbstractController<RaceDetail,RaceDetailDTO>{

    @Inject
    private RaceDetailService raceDetailService;

    @Inject
    private RaceDetailConverter converter;

    @Inject
    private RaceDetailWrapperConverter wrapperConverter;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/race-card/{raceCardId}/horse/{horseId}")
    public ResponseEntity<RaceDetailDTO> getByRaceCardAndHorse(
            @PathVariable Long raceCardId, Long horseId) {
        RaceDetail raceDetail = raceDetailService.getByRaceCardAndHorse(raceCardId,horseId);
        checkNull(raceDetail,raceCardId,horseId);
        return new ResponseEntity<>(converter.toDTO(raceDetail), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/race-card/{raceCardId}/command/{commandId}")
    public ResponseEntity<RaceDetailDTO> getByRaceCardAndCommand(
            @PathVariable Long raceCardId, Long horseId) {
        RaceDetail raceDetail = raceDetailService.getByRaceCardAndHorse(raceCardId,horseId);
        checkNull(raceDetail,raceCardId,horseId);
        return new ResponseEntity<>(converter.toDTO(raceDetail), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/race-card/{raceCardId}/number-start-box/{numberStartBox}")
    public ResponseEntity<RaceDetailDTO> getByRaceCardAndNumberStartBox(
            @PathVariable Long raceCardId, Long numberStartBox) {
        RaceDetail raceDetail = raceDetailService.getByRaceCardAndHorse(raceCardId,numberStartBox);
        checkNull(raceDetail,raceCardId,numberStartBox);
        return new ResponseEntity<>(converter.toDTO(raceDetail), HttpStatus.OK);
    }


    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/all/race-card/{raceCardId}")
    public ResponseEntity<List<RaceDetailDTO>> getAllByRaceCard(@PathVariable Long raceCardId) {
        List<RaceDetail> raceDetail = raceDetailService.getAllByRaceCard(raceCardId);
        return new ResponseEntity<>(converter.toListDTO(raceDetail), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/all-data/{raceDetailId}")
    public ResponseEntity<RaceDetailWrapperDTO> getAllDataFromRaceDetail(
            @PathVariable Long raceDetailId) {
        RaceDetailWrapper raceDetailWrapper = raceDetailService.getAllDataForRaceDetail(raceDetailId);
        checkNull(raceDetailWrapper,raceDetailId);
        return new ResponseEntity<>(wrapperConverter.toDTO(raceDetailWrapper), HttpStatus.OK);
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
