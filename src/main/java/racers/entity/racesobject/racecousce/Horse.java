package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.Owner;
import racers.entity.racesobject.Running;
import racers.entity.racesobject.Trainer;

public class Horse implements Running {
    private int idHorse;
    private String name;
    private int weight;
    private int age;
    private String form;
    private boolean sex;
    private String breed;
    private String color;
    private Jockey jockey;
    private Trainer trainer;
    private StatisticsHorse statistics;
    private Owner owner;
    private String rating;
}
