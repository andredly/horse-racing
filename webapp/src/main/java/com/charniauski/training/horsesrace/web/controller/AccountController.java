package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.web.converter.AccountConverter;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.dto.AccountDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController extends AbstractController<Account, AccountDTO> {

    @Inject
    private AccountService accountService;

    @Inject
    private AccountConverter converter;

    @Override
    public GenericConverter<Account, AccountDTO> getConverter() {
        return converter;
    }

    @Override
    public GenericService getGenericService() {
        return accountService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/search/{login}")
    public ResponseEntity<AccountDTO> getByLogin(
            @PathVariable @NotBlank String login) {
        Account account = accountService.getByLogin(login);
        checkNull(account,login);
        return new ResponseEntity<>(converter.toDTO(account), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/search/status/account/{login}")
    public ResponseEntity<Status> getStatusByLogin(
            @PathVariable @NotBlank String login) {
        Status status = accountService.getStatusByLogin(login);
        checkNull(status, login);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/search/status/{status}")
    public ResponseEntity<List<AccountDTO>> getAllByStatus(
            @PathVariable Status status) {
        List<Account> allByStatus = accountService.getAllByStatus(status);
        return new ResponseEntity<>(converter.toListDTO(allByStatus), HttpStatus.OK);
    }


}
