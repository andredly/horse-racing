package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Horse;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface HorseDao {

    Horse get(Long id);

    void insert(Horse entity);

    void update(Horse entity);

    void delete(Long id);

    List<Horse> getAll();
}
