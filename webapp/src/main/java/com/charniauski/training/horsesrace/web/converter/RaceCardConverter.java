package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorRaceCardDTO;
import com.charniauski.training.horsesrace.web.dto.RaceCardDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class RaceCardConverter extends AbstractConverter<RaceCard,RaceCardDTO>{

    @Inject
    private CorrectorRaceCardDTO correctorRaceCardDTO;
    @Override
    CorrectorDTOForRole getCorrectorDTOForRole() {
        return correctorRaceCardDTO;
    }
}
