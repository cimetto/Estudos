import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    
    public Biblioteca(){
        this.livros = new ArrayList<>();
    }
    
    public void addLivro(Livro livro){
        livros.add(livro);
    }
    
    public void listLivros(){
        for(Livro l : livros){
            System.out.println("Livros:");
            System.out.format("- Título: %s | Autor: %s | Ano de Publicação: %d\n", l.getTitulo(), l.getAutor(), l.getAnoPubli());
        }
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }
    
}
