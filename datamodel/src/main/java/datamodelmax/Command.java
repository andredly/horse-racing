package datamodelmax;

public class Command {
    private Integer idCommand;
    private String jockey;
    private String trainer;
    private String urlImageColor;
    private Horse horse;

    public Command() {
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Integer getIdCommand() {
        return idCommand;
    }

    public void setIdCommand(Integer idCommand) {
        this.idCommand = idCommand;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getUrlImageColor() {
        return urlImageColor;
    }

    public void setUrlImageColor(String urlImageColor) {
        this.urlImageColor = urlImageColor;
    }
}
