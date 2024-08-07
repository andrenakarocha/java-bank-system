package BankSystem;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String agency;
    private List<Account> accounts;
    private int lastAccount = 1;

    public Bank(String agency) {
        this.agency = agency;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts () {
        return accounts;
    }

    public void insertAccount(Account account){
        accounts.add(account);
    }

    public Account generateAccount(String name) {
        Account account = new Account(agency, "" + lastAccount, name);
        lastAccount++;
        return account;
    }
}
