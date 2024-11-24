public class App {
    public static void main(String[] args) {
        GerenciarPessoas pessoa = new GerenciarPessoas();
        
        pessoa.addPessoas(new Pessoa("Rodolfo", "Masculino", 69));
        pessoa.addPessoas(new Pessoa("Carlos", "Masculino", 16));
        pessoa.listarPessoas();
    }
}
