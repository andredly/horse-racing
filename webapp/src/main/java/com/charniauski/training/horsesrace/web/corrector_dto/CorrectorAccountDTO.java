package com.charniauski.training.horsesrace.web.corrector_dto;

import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.web.dto.AccountDTO;
import org.springframework.stereotype.Component;

/**
 * Created by ivc4 on 12.12.2016.
 */
@Component
public class CorrectorAccountDTO extends AbstractCorrector<AccountDTO, Status>{
    @Override
    public AccountDTO getDTOForRole(AccountDTO entity, Status role) {
        if (!role.equals(Status.ROLE_ADMIN)&&!role.equals(Status.ROLE_BOOKMAKER)) {
            entity.setDateRegisterAccount(null);
            entity.setStatus(null);
            entity.setIsDelete(null);
            return entity;
        }
        return entity;
    }
}
