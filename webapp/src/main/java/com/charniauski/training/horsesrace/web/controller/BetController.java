package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.BetService;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.web.converter.BetConverter;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.dto.AccountDTO;
import com.charniauski.training.horsesrace.web.dto.BetDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/bets")
public class BetController extends AbstractController<Bet, BetDTO> {

    @Inject
    private BetService betService;

    @Inject
    private BetConverter converter;

    @Inject
    private AccountService accountService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping
    public ResponseEntity<List<BetDTO>> getAll() {
        List<Bet> all = betService.getAll();
        return new ResponseEntity<>(converter.toListDTO(all), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER', 'ROLE_USER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<BetDTO> getById(
            @PathVariable Long id) {
        Bet bet = betService.get(id);
        Account account = accountService.get(bet.getAccountId());
        checkNull(account, id);
        if (isNotAuthorization(account.getLogin())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(converter.toDTO(bet), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER','ROLE_USER')")
    @GetMapping(value = "/search/all/account/{login}")
    public ResponseEntity<List<BetDTO>> getAllByLogin(
            @PathVariable @NotBlank String login) {
        if(isNotAuthorization(login)) { return new ResponseEntity<>(HttpStatus.FORBIDDEN);}
        List<Bet> bets = betService.getAllByLogin(login);
        return new ResponseEntity<>(converter.toListDTO(bets), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/create",produces = "application/json")
    public ResponseEntity<BetDTO> createBet(
            @RequestBody @Valid BetDTO dto) {
        betService.save(converter.toEntity(dto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/all/account/{login}/status/{status}")
    public ResponseEntity<List<BetDTO>> getAllByLoginAndStatusBet(
            @PathVariable @NotBlank String login, StatusBet statusBet) {
        List<Bet> bets = betService.getAllByLoginAndStatusBet(login, statusBet);
        return new ResponseEntity<>(converter.toListDTO(bets), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/all/status/{status}")
    public ResponseEntity<List<BetDTO>> getAllByStatusBet(
            @PathVariable StatusBet statusBet) {
        List<Bet> bets = betService.getAllByStatusBet(statusBet);
        return new ResponseEntity<>(converter.toListDTO(bets), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/account/{login}/event/{eventId}")
    public ResponseEntity<BetDTO> getByAccountAndEvent(
            @PathVariable @NotBlank String login, Long eventId) {
        Bet bet = betService.getByAccountAndEvent(login, eventId);
        checkNull(bet, login, eventId);
        return new ResponseEntity<>(converter.toDTO(bet), HttpStatus.OK);
    }

    @Override
    public GenericConverter<Bet, BetDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return betService;
    }
}
