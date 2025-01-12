import java.util.ArrayList;

public class DataBaseBankAccounts {
    /**
     * Quero adicionar a conta no banco de dados, quando a pessoa criar a
     * conta ela ganha 1000 de saldo, depois teremos que acessar essa conta
     * para sacar e verificar se ela é uma conta válida.
     *
     * Métodos:
     * - Adicionar conta no banco de dados, com saldo inicial de 1000 e numero de conta 000001 e adicionando conforme as contas criadas
     * - Método para realizar saques na conta (verificação de número da conta e senha)
     * - Método para realizar depósitos na conta (verificação de número da conta e senha)
     * */

    private ArrayList<BankAccount> bankAccounts;

    public DataBaseBankAccounts() {
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
        bankAccount.setBalance(1000);
        System.out.println("Conta criada com sucesso!\n - Saldo inicial: " + bankAccount.getBalance() + "\n - Número da conta: " + bankAccount.getAccountNumber());
    }

    public void balanceCheck(int accountNumber, String accountPassword) throws InvalidAccountException, InvalidPasswordException {
        BankAccount matchedAccount = null;

        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                matchedAccount = bankAccount;
                break;
            }
        }

        if (matchedAccount == null) throw new InvalidAccountException("Erro: Conta inválida");

        if (!matchedAccount.getAccountPassword().equals(accountPassword)) throw new InvalidPasswordException("Erro: Senha inválida");

        System.out.println("Saldo atual: " + matchedAccount.getBalance());
    }

    public void withdraw(int accountNumber, String accountPassword, double value) throws InvalidAccountException, InvalidPasswordException, InsufficientBalanceException, NegativeValueException {
        /**
         * Verificações:
         * - Se a conta existe no data base
         * - Se a senha está certa
         * - Se o saldo solicitado de saque é negativo
         * - Se tem saldo suficiente para o saque solicitado
         * */

        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                if (!bankAccount.getAccountPassword().equals(accountPassword)) {
                    throw new InvalidPasswordException("Erro: Senha inválida");
                }
                if (value < 0) {
                    throw new NegativeValueException("Erro: Valor de saque negativo");
                }
                if (bankAccount.getBalance() < value) {
                    throw new InsufficientBalanceException("Erro: Saldo insuficiente");
                }
                bankAccount.setBalance(bankAccount.getBalance() - value);
                System.out.println("Saque realizado com sucesso! Saldo atual: " + bankAccount.getBalance());
            } else {
                throw new InvalidAccountException("Erro: Conta inválida");
            }
        }
    }

    public void deposit(int accountNumber, String accountPassword, double value) throws InvalidAccountException, InvalidPasswordException, NegativeValueException {
        /**
         * Verificações:
         * - Se a conta existe no data base
         * - Se a senha está certa
         * - Se o saldo solicitado de depósito é negativo
         * */

        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                if (!bankAccount.getAccountPassword().equals(accountPassword)) {
                    throw new InvalidPasswordException("Erro: Senha inválida");
                }
                if (value < 0) {
                    throw new NegativeValueException("Erro: Valor de depósito negativo");
                }
                bankAccount.setBalance(bankAccount.getBalance() + value);
                System.out.println("Depósito realizado com sucesso! Saldo atual: " + bankAccount.getBalance());
            } else {
                throw new InvalidAccountException("Erro: Conta inválida");
            }
        }
    }
}