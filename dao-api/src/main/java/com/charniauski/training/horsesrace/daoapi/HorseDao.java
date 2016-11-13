package com.charniauski.training.horsesrace.daoapi;

import com.charniauski.training.horsesrace.datamodel.Horse;

/**
 * Created by Andre on 19.10.2016.
 */
public interface HorseDao extends GenericDao<Horse, Long> {

    Horse getByNickName(String nickName);

    Horse getByRaceDetail(Long raceDetail);

}
