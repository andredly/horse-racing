package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "race_detail", autoincrementColumn = "id")
public class RaceDetail extends AbstractModel{

    @Column(columnName = "race_card_id")
    private Long raceCardId;
    @Column(columnName = "horse_id")
    private Long horseId;
    @Column(columnName = "number_start_box")
    private Integer numberStartBox;
    @Column(columnName = "horse_result")
    private Integer horseResult;

//    private List<Horse> horses;
//    private RaceCard raceCard;

    public RaceDetail() {
    }

    public Long getRaceCardId() {
        return raceCardId;
    }

    public void setRaceCardId(Long raceCardId) {
        this.raceCardId = raceCardId;
    }

    public Long getHorseId() {
        return horseId;
    }

    public void setHorseId(Long horseId) {
        this.horseId = horseId;
    }

    public Integer getNumberStartBox() {
        return numberStartBox;
    }

    public void setNumberStartBox(Integer numberStartBox) {
        this.numberStartBox = numberStartBox;
    }

    public Integer getHorseResult() {
        return horseResult;
    }

    public void setHorseResult(Integer horseResult) {
        this.horseResult = horseResult;
    }

    @Override
    public String toString() {
        return "RaceDetail{" +
                "id='" + getId() + '\'' +
                ", raceCardId=" + raceCardId +
                ", horseId=" + horseId +
                ", numberStartBox=" + numberStartBox +
                ", horseResult=" + horseResult +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceDetail that = (RaceDetail) o;

        if (raceCardId != null ? !raceCardId.equals(that.raceCardId) : that.raceCardId != null) return false;
        if (horseId != null ? !horseId.equals(that.horseId) : that.horseId != null) return false;
        if (numberStartBox != null ? !numberStartBox.equals(that.numberStartBox) : that.numberStartBox != null)
            return false;
        return horseResult != null ? horseResult.equals(that.horseResult) : that.horseResult == null;

    }

    @Override
    public int hashCode() {
        int result = raceCardId != null ? raceCardId.hashCode() : 0;
        result = 31 * result + (horseId != null ? horseId.hashCode() : 0);
        result = 31 * result + (numberStartBox != null ? numberStartBox.hashCode() : 0);
        result = 31 * result + (horseResult != null ? horseResult.hashCode() : 0);
        return result;
    }
}
