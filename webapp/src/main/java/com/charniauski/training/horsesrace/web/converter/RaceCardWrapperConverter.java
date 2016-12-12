package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.services.wrapper.RaceCardWrapper;
import com.charniauski.training.horsesrace.web.dto.wrapper.RaceCardWrapperDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class RaceCardWrapperConverter implements GenericConverter<RaceCardWrapper, RaceCardWrapperDTO> {

    @Inject
    private RaceDetailWrapperConverter raceDetailWrapperConverter;
    @Inject
    private RaceCardConverter raceCardConverter;
    @Inject
    private RacecourseConverter racecourseConverter;

    @Override
    public RaceCardWrapper toEntity(RaceCardWrapperDTO dto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RaceCardWrapperDTO toDTO(RaceCardWrapper entity) {
        return toDTO(entity, null);
    }

    @Override
    public RaceCardWrapperDTO toDTO(RaceCardWrapper entity, String language) {
        RaceCardWrapperDTO raceCardWrapperDTO = new RaceCardWrapperDTO();
        raceCardWrapperDTO.setRaceCard(raceCardConverter.toDTO(entity.getRaceCard()));
        raceCardWrapperDTO.setRacecourse(racecourseConverter.toDTO(entity.getRacecourse()));
        raceCardWrapperDTO.setRaceDetailWrappers(raceDetailWrapperConverter.toListDTO(entity.getRaceDetailWrappers(), language));
        return raceCardWrapperDTO;
    }
}
