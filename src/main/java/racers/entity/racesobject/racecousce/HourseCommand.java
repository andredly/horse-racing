package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.Trainer;

public class HourseCommand {
    private int idCommand;
    private Jockey jockey;
    private Trainer trainer;
    private String irlColorFormImage;

    public HourseCommand() {
    }

    public int getIdCommand() {
        return idCommand;
    }

    public void setIdCommand(int idCommand) {
        this.idCommand = idCommand;
    }

    public Jockey getJockey() {
        return jockey;
    }

    public void setJockey(Jockey jockey) {
        this.jockey = jockey;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getIrlColorFormImage() {
        return irlColorFormImage;
    }

    public void setIrlColorFormImage(String irlColorFormImage) {
        this.irlColorFormImage = irlColorFormImage;
    }
}
