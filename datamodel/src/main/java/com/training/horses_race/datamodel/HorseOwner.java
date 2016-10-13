package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.Owner;

public class HorseOwner implements Owner{
    private int IdOwner;
    private String nameOwner;

    public HorseOwner() {
    }

    public int getIdOwner() {
        return IdOwner;
    }

    public void setIdOwner(int idOwner) {
        IdOwner = idOwner;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }
}
