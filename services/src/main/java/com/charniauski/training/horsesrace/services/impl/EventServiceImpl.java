package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.EventDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.services.EventService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class EventServiceImpl extends AbstractService<Event,Long> implements EventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

    @Inject
    private EventDao eventDao;


    @Override
    public GenericDao getGenericDao() {
        return eventDao;
    }

    @Override
    public Long save(Event event) throws NullPointerException, IllegalArgumentException, NoSuchEntityException {
        if (event.getRaceDetailId() == null || event.getEventType() == null || event.getDateRegister() == null
                || event.getCoefficientEvent()==null || event.getBookmaker()==null || event.getResultEvent()==null)
            throw new NullPointerException(String.format("Arguments may not by null: RaceDetailId=%d, EventType=%s" +" DateRegister=%tB," +
                            " CoefficientEvent=%d,  Bookmaker=%s, ResultEvent=%s",
                    event.getRaceDetailId(), event.getEventType(), event.getDateRegister(), event.getCoefficientEvent(),
                    event.getBookmaker(), event.getResultEvent()));

//        RaceDetail raceCardAndHorse =getByRaceCardAndHorse(raceDetail.getRaceCardId(),raceDetail.getHorseId());
//        if(raceCardAndHorse!=null) throw  new IllegalArgumentException("Combination RaceCard and Horse there");
//        RaceDetail raceCardAndCommand =getByRaceCardAndCommand(raceDetail.getRaceCardId(),raceDetail.getCommandId());
//        if(raceCardAndCommand!=null) throw  new IllegalArgumentException("Combination RaceCard and Command there");
//        RaceDetail raceCardAndNumberStartBox =getByRaceCardAndNumberStartBox(raceDetail.getRaceCardId(),raceDetail.getNumberStartBox());
//        if(raceCardAndNumberStartBox!=null) throw  new IllegalArgumentException("Combination RaceCard and NumberStartBox there");

//        RaceCard raceCard = raceCardService.get(raceDetail.getRaceCardId());
//        Horse horse =horseService.get(raceDetail.getHorseId());
//        Command command =commandService.get(raceDetail.getCommandId());
//        if (raceCard == null||horse==null||command==null)
//            throw new NoSuchEntityException("RaceCardId or HorseId and CommandId not found. Enter valid id!");
//        Long raceDetailId = null;
//        if (raceDetail.getId() == null) {
//            if (raceDetail.getHorseResult() != null)
//                throw new IllegalArgumentException("Horse result must not be if insert");
//            raceDetailId = raceDetailDao.insert(raceDetail);
//        } else {
//            raceDetailDao.update(raceDetail);
//            raceDetailId=raceDetail.getId();
//        }
//        return raceDetailId;
        //// TODO: 03.11.2016
        return null;
    }
}
