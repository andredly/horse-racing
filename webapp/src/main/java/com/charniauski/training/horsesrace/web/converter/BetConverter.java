package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorBetDTO;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import com.charniauski.training.horsesrace.web.dto.BetDTO;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Controller
public class BetConverter extends AbstractConverter<Bet, BetDTO> {
    @Inject
    CorrectorBetDTO correctorBetDTO;

    @Override
    CorrectorDTOForRole getCorrectorDTOForRole() {
        return correctorBetDTO;
    }
}
