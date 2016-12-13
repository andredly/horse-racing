package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.services.wrapper.RaceCardWrapper;
import com.charniauski.training.horsesrace.services.wrapper.RacecourseWrapper;
import com.charniauski.training.horsesrace.web.dto.RaceCardDTO;
import com.charniauski.training.horsesrace.web.dto.wrapper.RaceCardWrapperDTO;
import com.charniauski.training.horsesrace.web.dto.wrapper.RacecourseWrapperDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public class RacecourseWrapperConverter implements GenericConverter<RacecourseWrapper, RacecourseWrapperDTO> {

    @Inject
    private RaceDetailWrapperConverter raceDetailWrapperConverter;
    @Inject
    private RaceCardConverter raceCardConverter;
    @Inject
    private RacecourseConverter racecourseConverter;


    @Override
    public RacecourseWrapper toEntity(RacecourseWrapperDTO dto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RacecourseWrapperDTO toDTO(RacecourseWrapper entity) {
        return toDTO(entity,null);
    }

    @Override
    public RacecourseWrapperDTO toDTO(RacecourseWrapper entity, String language) {
        RacecourseWrapperDTO racecourseWrapperDTO=new RacecourseWrapperDTO();
        racecourseWrapperDTO.setRacecourse(racecourseConverter.toDTO(entity.getRacecourse(),language));
        List<RaceCardDTO> raceCardDTOs = raceCardConverter.toListDTO(entity.getRaceCards(), language);
        raceCardDTOs.forEach(raceCardDTO -> raceCardDTO.setRacecourseId(null));
        racecourseWrapperDTO.setRaceCards(raceCardDTOs);
        return racecourseWrapperDTO;
    }
}
