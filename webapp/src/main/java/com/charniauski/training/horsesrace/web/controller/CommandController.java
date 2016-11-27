package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.services.CommandService;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.web.converter.CommandConverter;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.converter.RacecourseConverter;
import com.charniauski.training.horsesrace.web.dto.CommandDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/commands")
public class CommandController extends AbstractController<Command,CommandDTO>{

    @Inject
    private CommandService commandService;

    @Inject
    private CommandConverter converter;

    @GetMapping(value = "/search")
    public ResponseEntity<CommandDTO> getByTrainerAndJockeyAndUrl(@RequestParam @NotBlank String trainer,
                                                                  @NotBlank String jockey, @NotBlank String urlImage) {
        Command command = commandService.getByTrainerAndJockeyAndUrl(trainer,jockey,urlImage);
        checkNull(command, trainer,jockey,urlImage);
        return new ResponseEntity<>(converter.toDTO(command), HttpStatus.OK);
    }

    @Override
    public GenericConverter<Command,CommandDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return commandService;
    }
}
