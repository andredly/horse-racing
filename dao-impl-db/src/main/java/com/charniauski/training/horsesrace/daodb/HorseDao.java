package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Horse;
import java.util.List;
import java.util.Locale;

/**
 * Created by Andre on 19.10.2016.
 */
public interface HorseDao extends GenericDao<Horse, Long> {

    List<Horse> getAll();
}
