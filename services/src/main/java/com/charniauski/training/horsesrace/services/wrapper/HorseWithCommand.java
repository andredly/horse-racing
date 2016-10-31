package com.charniauski.training.horsesrace.services.wrapper;

import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.Horse;

/**
 * Created by ivc4 on 31.10.2016.
 */
public class HorseWithCommand {
    private Horse horse;
    private Command command;

    public HorseWithCommand() {
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
