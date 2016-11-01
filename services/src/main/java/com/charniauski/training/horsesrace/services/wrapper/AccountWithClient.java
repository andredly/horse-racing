package com.charniauski.training.horsesrace.services.wrapper;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;

/**
 * Created by ivc4 on 31.10.2016.
 */
public class AccountWithClient {
    private Account account;
    private Client client;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountWithClient that = (AccountWithClient) o;

        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        return client != null ? client.equals(that.client) : that.client == null;

    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }
}
