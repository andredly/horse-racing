package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.wrapper.AccountWrapper;
import com.charniauski.training.horsesrace.services.wrapper.RaceDetailWrapper;
import com.charniauski.training.horsesrace.web.dto.wrapper.AccountWrapperDTO;
import com.charniauski.training.horsesrace.web.dto.wrapper.RaceDetailWrapperDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

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
    private RaceCardConverter raceCardConverter;
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
        raceDetailWrapperDTO.setEvents(eventConverter.toListDTO(entity.getEvents(),language));
        raceDetailWrapperDTO.setHorse(horseConverter.toDTO(entity.getHorse(),language));
        raceDetailWrapperDTO.setRaceCard(raceCardConverter.toDTO(entity.getRaceCard(),language));
        raceDetailWrapperDTO.setRaceDetail(raceDetailConverter.toDTO(entity.getRaceDetail(),language));
        return raceDetailWrapperDTO;
    }
}
