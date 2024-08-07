package BankSystem;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account account = new Account("54038491811", "andrenakarocha@hotmail.com", "André Rocha");

        label:
        while (true) {
            System.out.println("O que deseja fazer? \nD = Depósito, S = Saque, E = Sair");
            String op = input.nextLine();
            // TODO Tratar o input

            switch (op) {
                case "D": {
                    System.out.println("Qual valor deseja depositar? ");
                    double value = input.nextDouble();
                    // TODO Tratar o input

                    account.deposit(value);
                    break;
                }

                case "S": {
                    System.out.println("Qual o valor deseja sacar? ");
                    double value = input.nextDouble();
                    // TODO Tratar o input

                    // Variável para testar saque
                    boolean withdrawSucceed = account.withdraw(value);
                    if (!withdrawSucceed) {
                        System.out.println("Você não possui saldo o suficiente!");
                    }
                    break;
                }

                case "E":
                    break label;

                default:
                    System.out.println("Comando inválido! Tente novamente!");
            }

            // Evita que usamos o mesmo scanner em todos os loops.
            input = new Scanner(System.in);
        }
    }

}
