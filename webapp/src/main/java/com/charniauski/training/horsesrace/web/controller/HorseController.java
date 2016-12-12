package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.HorseService;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.converter.HorseConverter;
import com.charniauski.training.horsesrace.web.dto.HorseDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/horses")
public class HorseController extends AbstractController<Horse,HorseDTO>{

    @Inject
    private HorseService horseService;

    @Inject
    private HorseConverter converter;

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/{nickName}")
    public ResponseEntity<HorseDTO> getByNickName(
            @PathVariable @NotBlank String nickName, HttpServletRequest request) {
        String language = request.getHeader("Language");
        Horse horse = horseService.getByNickName(nickName);
        checkNull(horse,nickName);
        return new ResponseEntity<>(converter.toDTO(horse, language), HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @GetMapping(value = "/search/race-detail/{raceDetailId}")
    public ResponseEntity<HorseDTO> getByRaceDetail(@PathVariable Long raceDetailId, HttpServletRequest request) {
        String language = request.getHeader("Language");
        Horse horse = horseService.getByRaceDetail(raceDetailId);
        checkNull(horse,raceDetailId);
        return new ResponseEntity<>(converter.toDTO(horse, language), HttpStatus.OK);
    }

    @Override
    public GenericConverter<Horse,HorseDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return horseService;
    }
}
