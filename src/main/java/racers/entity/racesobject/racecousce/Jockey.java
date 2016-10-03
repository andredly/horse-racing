package racers.entity.racesobject.racecousce;

import com.sun.org.glassfish.external.statistics.Statistic;

class Jockey {
    private int idJockey;
    private String nickName;
    private int age;
    private int weight;
    private String drawUrl;
    private StatisticJockey statistic;

    public Jockey() {
    }

    public int getIdJockey() {
        return idJockey;
    }

    public void setIdJockey(int idJockey) {
        this.idJockey = idJockey;
    }

    public String getName() {
        return nickName;
    }

    public void setName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDrawUrl() {
        return drawUrl;
    }

    public void setDrawUrl(String drawUrl) {
        this.drawUrl = drawUrl;
    }

    public StatisticJockey getStatistic() {
        return statistic;
    }

    public void setStatistic(StatisticJockey statistic) {
        this.statistic = statistic;
    }
}
