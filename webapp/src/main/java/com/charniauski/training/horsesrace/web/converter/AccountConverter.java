package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorAccountDTO;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import com.charniauski.training.horsesrace.web.dto.AccountDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class AccountConverter extends AbstractConverter<Account, AccountDTO> {

    @Inject
    private CorrectorAccountDTO correctorAccountDTO;

    @Override
    CorrectorDTOForRole getCorrectorDTOForRole() {
        return correctorAccountDTO;
    }
}
