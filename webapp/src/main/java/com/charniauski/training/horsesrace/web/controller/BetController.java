package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import com.charniauski.training.horsesrace.services.BetService;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.web.converter.BetConverter;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.dto.BetDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/bets")
public class BetController extends AbstractController<Bet,BetDTO>{

    @Inject
    private BetService betService;

    @Inject
    private BetConverter converter;

    @GetMapping(value = "/search/all/account/{login}")
    public ResponseEntity<List<BetDTO>> getAllByStatus(
            @PathVariable @NotBlank String login) {
        List<Bet> bets = betService.getAllByLogin(login);
        return new ResponseEntity<>(converter.toListDTO(bets), HttpStatus.OK);
    }

    @GetMapping(value = "/search/all/account/{login}/status/{status}")
    public ResponseEntity<List<BetDTO>> getAllByLoginAndStatusBet(
            @PathVariable @NotBlank String login, StatusBet statusBet) {
        List<Bet> bets = betService.getAllByLoginAndStatusBet(login,statusBet);
        return new ResponseEntity<>(converter.toListDTO(bets), HttpStatus.OK);
    }

    @GetMapping(value = "/search/all/status/{status}")
    public ResponseEntity<List<BetDTO>> getAllByStatusBet(
            @PathVariable StatusBet statusBet) {
        List<Bet> bets = betService.getAllByStatusBet(statusBet);
        return new ResponseEntity<>(converter.toListDTO(bets), HttpStatus.OK);
    }

    @GetMapping(value = "/search/account/{login}/event/{eventId}")
    public ResponseEntity<BetDTO> getByAccountAndEvent(
            @PathVariable @NotBlank String login,Long eventId) {
        Bet bet = betService.getByAccountAndEvent(login,eventId);
        checkNull(bet, login,eventId);
        return new ResponseEntity<>(converter.toDTO(bet), HttpStatus.OK);
    }

    @Override
    public GenericConverter<Bet,BetDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return betService;
    }
}
