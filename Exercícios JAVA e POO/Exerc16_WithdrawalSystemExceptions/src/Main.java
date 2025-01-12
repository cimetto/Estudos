import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBaseBankAccounts db;
        db = new DataBaseBankAccounts();
        /**
         * Menu de opções usando do while:
         * - Criar conta
         * - Acessar conta
         * - Sair
         * */

        boolean exit = false;
        int opcao;
        do {
            System.out.println("\nMenu de opções:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Acessar conta");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite seu nome completo: ");
                    String userName = scanner.nextLine();

                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    try {
                        if (cpf.length() != 11) {
                            throw new CpfInvalidException("Erro: CPF deve ter 11 dígitos");
                        }
                    } catch (CpfInvalidException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.print("Digite a senha da conta (8 dígitos): ");
                    String accountPassword = scanner.nextLine();
                    try {
                        if (accountPassword.length() != 8) {
                            throw new InvalidPasswordException("Erro: Senha deve ter 8 dígitos");
                        }
                    } catch (InvalidPasswordException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    BankAccount bankAccount = new BankAccount(userName, accountPassword);
                    db.addBankAccount(bankAccount);
                    break;

                case 2:
                    System.out.print("Digite o número da conta: ");
                    int accountNumber = scanner.nextInt();

                    System.out.print("Digite a senha da conta: ");
                    String password = scanner.nextLine();

                    try {
                        db.balanceCheck(accountNumber, password);
                    } catch (InvalidAccountException e) {
                        System.out.println(e.getMessage());
                        break;
                    } catch (InvalidPasswordException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    boolean exitSubMenu = false;
                    do {
                        System.out.println("Menu de opções:");
                        System.out.println("1 - Sacar");
                        System.out.println("2 - Depositar");
                        System.out.println("0 - Sair");
                        System.out.print("Digite a opção desejada: ");
                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.print("Digite o valor do saque: ");
                                double value = scanner.nextDouble();
                                try {
                                    db.withdraw(accountNumber, password, value);
                                } catch (InvalidAccountException e) {
                                    System.out.println(e.getMessage());
                                } catch (InvalidPasswordException e) {
                                    System.out.println(e.getMessage());
                                } catch (InsufficientBalanceException e) {
                                    System.out.println(e.getMessage());
                                } catch (NegativeValueException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;

                            case 2:
                                System.out.print("Digite o valor do depósito: ");
                                double value2 = scanner.nextDouble();
                                try {
                                    db.deposit(accountNumber, password, value2);
                                } catch (InvalidAccountException e) {
                                    System.out.println(e.getMessage());
                                } catch (InvalidPasswordException e) {
                                    System.out.println(e.getMessage());
                                } catch (NegativeValueException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;

                            case 0:
                                exitSubMenu = true;
                                System.out.println("Saindo...");
                                break;
                        }
                    } while (!exitSubMenu);
                    break;

                case 0:
                    exit = true;
                    System.out.println("Saindo...");
                    break;
            }
        } while (!exit);
        scanner.close();
    }
}