package com.charniauski.training.horsesrace.web.corrector_dto;

import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.web.dto.AccountDTO;
import com.charniauski.training.horsesrace.web.dto.EventDTO;
import org.springframework.stereotype.Component;

/**
 * Created by ivc4 on 12.12.2016.
 */
@Component
public class CorrectorEventDTO extends AbstractCorrector<EventDTO, Status>{
    @Override
    public EventDTO getDTOForRole(EventDTO entity, Status role) {
        System.out.println(role);
        if (role==null){
            entity.setBookmaker(null);
            entity.setDateRegister(null);
            entity.setResultEvent(null);
            return entity;
        }if (!role.equals(Status.ROLE_ADMIN)&&!role.equals(Status.ROLE_BOOKMAKER)) {
            entity.setBookmaker(null);
            entity.setDateRegister(null);
            return entity;
        }
        return entity;
    }
}
