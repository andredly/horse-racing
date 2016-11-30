package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;
import com.charniauski.training.horsesrace.web.security.Security;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by ivc4 on 30.11.2016.
 */
public interface IRacecourseController extends IGenericController<RacecourseDTO> {

    @GetMapping(value = "/search/racecourse/{name}")
    @Security(role = "ROLE_ADMIN")
    ResponseEntity<RacecourseDTO> getByName(String name);

    @GetMapping(value = "/search/all/currentDate")
    ResponseEntity<List<RacecourseDTO>> getAllAfterCurrentDate();
}
