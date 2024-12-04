import java.util.ArrayList;

/**
 * Representa uma biblioteca que gerencia uma coleção de livros.
 */
public class Library {
    private ArrayList<Book> books;
    static int counter = 0;

    /**
     * Constrói uma nova biblioteca.
     * Inicializa a lista de livros.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adiciona um livro à coleção da biblioteca.
     *
     * @param book O livro a ser adicionado.
     */
    public void addBook(Book book) {
        books.add(book);
        counter++;
    }

    /**
     * Exibe todas as informações dos livros presentes na biblioteca.
     */
    public void showAllBooks() {
        System.out.println("- Books: ");
        for (Book book : books) {
            System.out.println(book); // Chama o método toString() do objeto Book
        }
    }
}
