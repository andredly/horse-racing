package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorHorseDTO;
import com.charniauski.training.horsesrace.web.dto.HorseDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class HorseConverter extends AbstractConverter<Horse,HorseDTO>{

    @Inject
    private CorrectorHorseDTO correctorHorseDTO;
    @Override
    CorrectorDTOForRole getCorrectorDTOForRole() {
        return correctorHorseDTO;
    }
}
