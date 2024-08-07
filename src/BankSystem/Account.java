package BankSystem;

import java.util.Scanner;

public class Account {
    // Propriedades do objeto da conta
    private static final int MAX_NAME_LENGTH = 12;
    private String agency;
    private String account;
    private String name;
    private double balance;
    private Log logger;

    // Construtor
    public Account(String agency, String account, String name) {
        this.agency = agency;
        this.account = account;
        this.logger = new Log();
        setName(name);
    }

    public void setName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            this.name = name.substring(0, MAX_NAME_LENGTH);
        } else {
            this.name = name;
        }
    }

    public void deposit(double value) {
        balance += value;
        logger.out("Sua conta agora tem R$ " + balance);
    }

    public boolean withdraw(double value) {
        if (balance < value) {
            return false;
        }
        balance -= value;
        logger.out("Sua conta agora tem R$ " + balance);
        return true;
    }

    @Override
    public String toString() {
        return "A conta do usuário " + this.name + " Possui R$: " + balance;
    }
}
