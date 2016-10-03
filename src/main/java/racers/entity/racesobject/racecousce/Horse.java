package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.Owner;
import racers.entity.racesobject.Running;
import racers.entity.racesobject.Trainer;

class Horse implements Running {
    private int idHorse;
    private String name;
    private int weight;
    private int age;
    private String form;
    private boolean sex;
    private String additionalInformation;
    private Jockey jockey;
    private Trainer trainer;
    private StatisticsHorse statistics;
    private Owner owner;
    private String rating;

    public Horse() {
    }

    public int getIdHorse() {
        return idHorse;
    }

    public void setIdHorse(int idHorse) {
        this.idHorse = idHorse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
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

    public StatisticsHorse getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsHorse statistics) {
        this.statistics = statistics;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
