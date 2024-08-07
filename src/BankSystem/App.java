package BankSystem;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Bank santander = new Bank("0001");
        Scanner input = new Scanner(System.in);

        // Loop para criação de contas
        label:
        while (true) {
            System.out.println("O que deseja fazer? \nC = Criar conta, E = Sair");
            String op = input.nextLine();

            switch (op) {
                case "C": {
                    System.out.println("Digite o seu nome: ");
                    String name = input.nextLine();
                    Account account = santander.generateAccount(name);
                    santander.insertAccount(account);
                    operateAccount(account);
                }

                case "E": {
                    break label;
                }

                default: {
                    System.out.println("Comando inválido! Tente novamente!");
                }
            }
        }

        // Printar as contas e saldo no final do programa
        List<Account> accountList = santander.getAccounts();
        for (Account cc : accountList) {
            System.out.println(cc);
        }
    }

    static void operateAccount(Account account) {
        Scanner input = new Scanner(System.in);

        label:
        while (true) {
            System.out.println("O que deseja fazer? \nD = Depósito, S = Saque, E = Sair");
            String op = input.nextLine();

            switch (op) {
                case "D": {
                    System.out.println("Qual valor deseja depositar? ");
                    double value = input.nextDouble();
                    account.deposit(value);
                    break;
                }

                case "S": {
                    System.out.println("Qual o valor deseja sacar? ");
                    double value = input.nextDouble();
                    // Variável para testar saque
                    boolean withdrawSucceed = account.withdraw(value);
                    if (!withdrawSucceed) {
                        System.out.println("Você não possui saldo o suficiente!");
                    }
                    break;
                }

                case "E":
                    main(null);
                    break label;

                default:
                    System.out.println("Comando inválido! Tente novamente!");
                    break;
            }

            // Evita que usamos o mesmo scanner em todos os loops.
            input = new Scanner(System.in);
        }
    }

}
