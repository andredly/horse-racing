package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.web.dto.EventDTO;
import org.springframework.stereotype.Controller;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Controller
public class EventConverter extends AbstractConverter<Event,EventDTO>{

    @Override
    public Event updateEntity(Event entity, EventDTO dto) {
        return null;
    }
}
