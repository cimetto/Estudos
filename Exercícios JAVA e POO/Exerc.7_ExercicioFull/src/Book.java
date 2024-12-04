/**
 * Representa um livro com título, autor, ano de publicação e número fixo de páginas.
 */
public class Book {
    private String title;
    private String author;
    private int publicationYear;
    final int pageNumbers = 100;

    /**
     * Constrói um novo livro.
     *
     * @param title O título do livro.
     * @param author O autor do livro.
     * @param publicationYear O ano de publicação do livro.
     */
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    /**
     * Retorna uma representação textual do livro.
     *
     * @return Uma string contendo título, autor, ano de publicação e número de páginas.
     */
    @Override
    public String toString() {
        return String.format("Title: %s | Author: %s | Publication Year: %d | Page Numbers: %d", 
                title, author, publicationYear, pageNumbers);
    }

    /**
     * Exibe as informações do livro no console.
     */
    public void displayInformation() {
        System.out.println(toString());
    }

    /**
     * Verifica se o livro é antigo (20 anos ou mais desde sua publicação).
     *
     * @return {@code true} se o livro for antigo, {@code false} caso contrário.
     */
    public boolean isBookOld() {
        return 2024 - this.publicationYear >= 20;
    }

    /**
     * Obtém o título do livro.
     *
     * @return O título do livro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título do livro.
     *
     * @param title O novo título do livro.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtém o autor do livro.
     *
     * @return O autor do livro.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Define o autor do livro.
     *
     * @param author O novo autor do livro.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Obtém o ano de publicação do livro.
     *
     * @return O ano de publicação do livro.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Define o ano de publicação do livro.
     *
     * @param publicationYear O novo ano de publicação do livro.
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
