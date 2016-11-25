package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.web.dto.CommandDTO;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;
import org.springframework.stereotype.Controller;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Controller
public class CommandConverter extends AbstractConverter<Command,CommandDTO>{

    @Override
    public Command updateEntity(Command entity, CommandDTO dto) {
        return null;
    }
}
