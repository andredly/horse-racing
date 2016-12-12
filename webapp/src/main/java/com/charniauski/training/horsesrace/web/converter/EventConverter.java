package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorEventDTO;
import com.charniauski.training.horsesrace.web.dto.EventDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class EventConverter extends AbstractConverter<Event,EventDTO>{

    @Inject
    private CorrectorEventDTO correctorEventDTO;
    @Override
    CorrectorDTOForRole getCorrectorDTOForRole() {
        return correctorEventDTO;
    }
}
