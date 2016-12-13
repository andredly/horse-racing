package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.services.wrapper.BetWrapper;
import com.charniauski.training.horsesrace.web.dto.BetDTO;
import com.charniauski.training.horsesrace.web.dto.EventDTO;
import com.charniauski.training.horsesrace.web.dto.RaceCardDTO;
import com.charniauski.training.horsesrace.web.dto.RaceDetailDTO;
import com.charniauski.training.horsesrace.web.dto.wrapper.BetWrapperDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class BetWrapperConverter implements GenericConverter<BetWrapper, BetWrapperDTO> {

    @Inject
    private RaceCardConverter raceCardConverter;
    @Inject
    private RaceDetailConverter raceDetailConverter;
    @Inject
    private RacecourseConverter racecourseConverter;
    @Inject
    private EventConverter eventConverter;
    @Inject
    private HorseConverter horseConverter;
    @Inject
    private BetConverter betConverter;


    @Override
    public BetWrapper toEntity(BetWrapperDTO dto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BetWrapperDTO toDTO(BetWrapper entity) {
        return toDTO(entity,null);
    }

    @Override
    public BetWrapperDTO toDTO(BetWrapper entity, String language) {
        BetWrapperDTO betWrapperDTO =new BetWrapperDTO();
        BetDTO betDTO = betConverter.toDTO(entity.getBet(), language);
        betDTO.setAccountId(null);
        betDTO.setEventId(null);
        betWrapperDTO.setBet(betDTO);
        betWrapperDTO.setHorse(horseConverter.toDTO(entity.getHorse(),language));
        betWrapperDTO.setRacecourse(racecourseConverter.toDTO(entity.getRacecourse(),language));
        RaceCardDTO raceCardDTO = raceCardConverter.toDTO(entity.getRaceCard(), language);
        raceCardDTO.setRacecourseId(null);
        betWrapperDTO.setRaceCard(raceCardDTO);
        RaceDetailDTO raceDetailDTO = raceDetailConverter.toDTO(entity.getRaceDetail(), language);
        raceDetailDTO.setCommandId(null);
        raceDetailDTO.setHorseId(null);
        raceDetailDTO.setRaceCardId(null);
        betWrapperDTO.setRaceDetail(raceDetailDTO);
        EventDTO eventDTO = eventConverter.toDTO(entity.getEvent(), language);
        eventDTO.setCoefficientEvent(null);
        eventDTO.setRaceDetailId(null);
        betWrapperDTO.setEvent(eventDTO);
        return betWrapperDTO;
    }
}
