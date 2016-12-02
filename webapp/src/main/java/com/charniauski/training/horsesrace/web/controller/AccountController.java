package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.web.converter.AccountConverter;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.charniauski.training.horsesrace.web.dto.AccountDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAll() {
        List<Account> all = accountService.getAll();
        return new ResponseEntity<>(getConverter().toListDTO(all), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER', 'ROLE_USER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> getById(
            @PathVariable Long id) {
        Account account = accountService.get(id);
        if (isNotAuthorization(account.getLogin())) {
            return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        checkNull(account, id);
        return new ResponseEntity<>(converter.toDTO(account), HttpStatus.OK);
    }

    @PostMapping(value = "/create",produces = "application/json")
    public ResponseEntity<AccountDTO> createAccount(
            @RequestBody @Valid AccountDTO dto) {
        accountService.save(converter.toEntity(dto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Void> updateAccount(
            @RequestBody AccountDTO dto,
            @PathVariable Long id) {
        Account account = converter.toEntity(dto);
        if (isNotAuthorization(account.getLogin())) {
            return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        account.setId(id);
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/{login}")
    public ResponseEntity<AccountDTO> getByLogin(
            @PathVariable @NotBlank String login) {
        if (isNotAuthorization(login)) {
            return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        Account account = accountService.getByLogin(login);
        checkNull(account, login);
        return new ResponseEntity<>(converter.toDTO(account), HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/status/account/{login}")
    public ResponseEntity<Status> getStatusByLogin(
            @PathVariable @NotBlank String login) {
        Status status = accountService.getStatusByLogin(login);
        checkNull(status, login);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_BOOKMAKER')")
    @GetMapping(value = "/search/status/{status}")
    public ResponseEntity<List<AccountDTO>> getAllByStatus(
            @PathVariable Status status) {
        List<Account> allByStatus = accountService.getAllByStatus(status);
        return new ResponseEntity<>(converter.toListDTO(allByStatus), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> fakeDelete(@PathVariable Long id) {
        accountService.fakeDelete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
