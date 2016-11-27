package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.web.dto.RaceCardDTO;
import org.springframework.stereotype.Controller;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Controller
public class RaceCardConverter extends AbstractConverter<RaceCard,RaceCardDTO>{

    @Override
    public RaceCard updateEntity(RaceCard entity, RaceCardDTO dto) {
        return null;
    }
}
