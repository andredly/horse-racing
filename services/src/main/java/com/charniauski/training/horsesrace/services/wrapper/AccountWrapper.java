package com.charniauski.training.horsesrace.services.wrapper;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class AccountWrapper {
    private Account account;
    private List<Bet> bets;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "AccountWrapper{" +
                "account=" + account +
                ", bets=" + bets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountWrapper that = (AccountWrapper) o;

        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        return bets != null ? bets.equals(that.bets) : that.bets == null;

    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + (bets != null ? bets.hashCode() : 0);
        return result;
    }
}
