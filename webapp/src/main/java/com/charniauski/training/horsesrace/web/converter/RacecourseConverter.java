package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorRacecourseDTO;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class RacecourseConverter extends AbstractConverter<Racecourse,RacecourseDTO>{

    @Inject
    private CorrectorRacecourseDTO correctorRacecourseDTO;
    @Override
    CorrectorDTOForRole getCorrectorDTOForRole() {
        return correctorRacecourseDTO;
    }
}
