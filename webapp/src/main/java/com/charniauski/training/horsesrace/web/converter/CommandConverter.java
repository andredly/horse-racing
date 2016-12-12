package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorCommandDTO;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import com.charniauski.training.horsesrace.web.dto.CommandDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class CommandConverter extends AbstractConverter<Command,CommandDTO>{

    @Inject
    private CorrectorCommandDTO correctorCommandDTO;

    @Override
    CorrectorDTOForRole getCorrectorDTOForRole() {
        return correctorCommandDTO;
    }
}
