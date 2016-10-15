package datamodelmax;

import java.util.Date;
import java.util.List;

public class RaceDetail extends AbstractModel {
    private int numberStartBox;
    private Date dateFinish;
    private int result;
    private List<Horse> horses;
    private RaceCard raceCard;

    public RaceDetail() {
    }

    public RaceCard getRaceCard() {
        return raceCard;
    }

    public void setRaceCard(RaceCard raceCard) {
        this.raceCard = raceCard;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public int getNumberStartBox() {
        return numberStartBox;
    }

    public void setNumberStartBox(int numberStartBox) {
        this.numberStartBox = numberStartBox;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
