package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.services.wrapper.RaceDetailWrapper;
import com.charniauski.training.horsesrace.web.dto.EventDTO;
import com.charniauski.training.horsesrace.web.dto.RaceDetailDTO;
import com.charniauski.training.horsesrace.web.dto.wrapper.RaceDetailWrapperDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class RaceDetailWrapperConverter implements GenericConverter<RaceDetailWrapper, RaceDetailWrapperDTO> {

    @Inject
    private HorseConverter horseConverter;
    @Inject
    private RaceDetailConverter raceDetailConverter;
    @Inject
    private CommandConverter commandConverter;
    @Inject
    private EventConverter eventConverter;

    @Override
    public RaceDetailWrapper toEntity(RaceDetailWrapperDTO dto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RaceDetailWrapperDTO toDTO(RaceDetailWrapper entity) {
        return toDTO(entity,null);
    }

    @Override
    public RaceDetailWrapperDTO toDTO(RaceDetailWrapper entity, String language) {
        RaceDetailWrapperDTO raceDetailWrapperDTO =new RaceDetailWrapperDTO();
        raceDetailWrapperDTO.setCommand(commandConverter.toDTO(entity.getCommand(),language));
        List<EventDTO> eventDTOs = eventConverter.toListDTO(entity.getEvents(), language);
        eventDTOs.forEach(eventDTO -> eventDTO.setRaceDetailId(null));
        raceDetailWrapperDTO.setEvents(eventDTOs);
        raceDetailWrapperDTO.setHorse(horseConverter.toDTO(entity.getHorse(),language));
        RaceDetailDTO raceDetailDTO = raceDetailConverter.toDTO(entity.getRaceDetail(), language);
        raceDetailDTO.setCommandId(null);
        raceDetailDTO.setHorseId(null);
        raceDetailDTO.setRaceCardId(null);
        raceDetailWrapperDTO.setRaceDetail(raceDetailDTO);
        return raceDetailWrapperDTO;
    }
}
