package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "race_detail")
public class RaceDetail extends AbstractModel{
    @Column(columnName = "id",isAutoIncrement = true)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id='" + id + '\'' +
                "numberStartBox=" + numberStartBox +
                ", horseResult=" + horseResult +
                '}';
    }
}
