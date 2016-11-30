package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ivc4 on 30.11.2016.
 */
public interface IRacecourseController extends IGenericController<RacecourseDTO> {

    ResponseEntity<RacecourseDTO> getByName(String name);

    ResponseEntity<List<RacecourseDTO>> getAllAfterCurrentDate();
}
