public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addLivro(new Livro("Pai Rico Pai Pobre", "sla", 2002));
        
        biblioteca.listLivros();
    }
}
