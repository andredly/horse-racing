package racers.entity.racesobject.racecousce;


import racers.entity.racesobject.Trainer;

public class HorseTrainer implements Trainer{
    private int idTrainer;
    private String name;

    public HorseTrainer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTrainer() {

        return idTrainer;
    }

    public void setIdTrainer(int idTrainer) {
        this.idTrainer = idTrainer;
    }
}
