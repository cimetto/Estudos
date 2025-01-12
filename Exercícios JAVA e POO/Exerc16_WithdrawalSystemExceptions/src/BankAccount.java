import java.util.Random;

public class BankAccount {
    /**
     * Elementos de uma conta bancária:
     *  - Número da conta começa por 000001 e vai adicionando conforme as contas criadas
     *  - Senha da conta
     *  - Saldo disponível
     *
     *  Métodos:
     *  - Construtor que recebe o número da conta que deve ser 6 digitos e a senha 8 digitos
     *  - Getters e Setters para os atributos
     *  - método para verificar o saldo da conta
     *  */

    private static int nextAccountNumber = 1;
    private int accountNumber;
    private String userName;
    private String accountPassword;
    private double balance;

    public BankAccount(String userName, String accountPassword) {
        /**
         * Quero que o accountNumber sege aleatório
         * entre 100000 e 999999, porém não sege igual.
         * */

        Random random = new Random();
        this.userName = userName;
        this.accountPassword = accountPassword;
        this.accountNumber = random.nextInt(900000) + 100000;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getAccountPassword() {
        return this.accountPassword;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}