package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.services.wrapper.AccountWrapper;
import com.charniauski.training.horsesrace.web.dto.wrapper.AccountWrapperDTO;
import org.springframework.stereotype.Component;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class AccountWrapperConverter extends AbstractConverter<AccountWrapper, AccountWrapperDTO> {

    @SuppressWarnings("unchecked")
    @Override
    public AccountWrapper toEntity(AccountWrapperDTO dto) {
        //// TODO: 11.12.2016
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public AccountWrapperDTO toDTO(AccountWrapper entity) {
        return null;
    }
}



