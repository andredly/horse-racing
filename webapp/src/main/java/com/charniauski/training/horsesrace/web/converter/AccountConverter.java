package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.web.dto.AccountDTO;
import com.charniauski.training.horsesrace.web.dto.CommandDTO;
import org.springframework.stereotype.Controller;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Controller
public class AccountConverter extends AbstractConverter<Account,AccountDTO>{

    @Override
    public Account updateEntity(Account entity, AccountDTO dto) {
        return null;
    }
}
