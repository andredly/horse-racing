package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.Owner;
import racers.entity.racesobject.Running;
import racers.entity.racesobject.Trainer;

class Horse implements Running {
    private int idHorse;
    private String nickName;
    private int age;
    private int equipmentWeight;
    private String form;
    private enum Sex{
        MAIL(1),FEMALE(0);
        private int sex;
        Sex(int sex) {
            this.sex=sex;
        }
        static public Sex getType(int sex) {
            for (Sex type : Sex.values()) {
                if (type.getTypeValue()==sex) {
                    return type;
                }
            }
            return null;
        }

        public int getTypeValue() {
            return sex;
        }
    };
    private int rating;
    private String discription;
//    private Jockey jockey;
//    private Trainer trainer;
    private Owner owner;


    public Horse() {
    }

    public int getIdHorse() {
        return idHorse;
    }

    public void setIdHorse(int idHorse) {
        this.idHorse = idHorse;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getEquipmentWeight() {
        return equipmentWeight;
    }

    public void setEquipmentWeight(int equipmentWeight) {
        this.equipmentWeight = equipmentWeight;
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

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

//    public Jockey getJockey() {
//        return jockey;
//    }
//
//    public void setJockey(Jockey jockey) {
//        this.jockey = jockey;
//    }
//
//    public Trainer getTrainer() {
//        return trainer;
//    }
//
//    public void setTrainer(Trainer trainer) {
//        this.trainer = trainer;
//    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
