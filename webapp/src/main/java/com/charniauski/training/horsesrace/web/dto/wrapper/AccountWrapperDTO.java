package com.charniauski.training.horsesrace.web.dto.wrapper;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.web.dto.AccountDTO;
import com.charniauski.training.horsesrace.web.dto.BetDTO;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class AccountWrapperDTO {
    private AccountDTO account;
    private List<BetDTO> bets;

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public void setBets(List<BetDTO> bets) {
        this.bets = bets;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public List<BetDTO> getBets() {
        return bets;
    }

    @Override
    public String toString() {
        return "AccountWrapperDTO{" +
                "account=" + account +
                ", bets=" + bets +
                '}';
    }
}
