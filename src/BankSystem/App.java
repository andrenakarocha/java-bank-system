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
            System.out.println("O que deseja fazer? \nD = Depósito, S = Saque, E = Editar Conta, X = Sair");
            String op = input.nextLine();

            switch (op) {
                case "D": {
                    double number = 0.0;
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.println("Qual valor deseja depositar? ");
                        String value = input.nextLine();

                        try {
                            number = Double.parseDouble(value);
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Resposta inválida, digite um número!");
                        }
                    }
                    account.deposit(number);
                    break;
                }

                case "E": {
                    System.out.println("Errou seu nome? Por favor, digite o nome correto abaixo: ");
                    String newName = input.nextLine();
                    account.setName(newName);
                    System.out.println("Seu nome está correto? -> " + account.getName() + "(Sim, Não)");
                    String answer = input.nextLine();

                    while (!answer.equals("Sim")){
                        System.out.println("Digite o seu nome correto: ");
                        newName = input.nextLine();
                        account.setName(newName);
                        System.out.println("Seu nome está correto? -> " + account.getName() + "(Sim, Não)");
                        answer = input.nextLine();
                    }

                    System.out.println("Perfeito!");
                    break;
                }

                case "S": {
                    double number = 0.0;
                    boolean validInput = false;

                    while (!validInput) {
                        System.out.println("Qual o valor deseja sacar? ");
                        String value = input.nextLine();

                        try {
                            number = Double.parseDouble(value);
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Resposta inválida, digite um número!");
                        }
                    }

                    // Variável para testar saque
                    boolean withdrawSucceed = account.withdraw(number);
                    if (!withdrawSucceed) {
                        System.out.println("Você não possui saldo o suficiente!");
                    }
                    break;
                }

                case "X":
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
