/**
 * Classe principal para executar o programa de gerenciamento da biblioteca.
 */
public class Main {
    /**
     * Método principal que inicializa a biblioteca e adiciona livros.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Library library = new Library();

        // Cria e adiciona um livro à biblioteca
        Book book1 = new Book("Sigma", "Cara Tranquilo", 2022);
        library.addBook(book1);

        // Exibe os livros da biblioteca
        library.showAllBooks();

        // Exibe o número de livros e verifica se o livro é antigo
        System.out.println("Number of Books: " + Library.counter + ", " + book1.isBookOld());
    }
}
