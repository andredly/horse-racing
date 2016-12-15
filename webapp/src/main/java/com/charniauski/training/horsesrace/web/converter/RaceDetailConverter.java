package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorRaceDetailDTO;
import com.charniauski.training.horsesrace.web.dto.RaceDetailDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class RaceDetailConverter extends AbstractConverter<RaceDetail,RaceDetailDTO>{

    @Inject
    private CorrectorRaceDetailDTO correctorRaceDetailDTO;
    @Override
    CorrectorDTOForRole getCorrectorDTOForRole() {
        return correctorRaceDetailDTO;
    }
}
