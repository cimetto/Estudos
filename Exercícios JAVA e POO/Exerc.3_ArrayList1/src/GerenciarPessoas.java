import java.util.ArrayList;

public class GerenciarPessoas {
    private ArrayList<Pessoa> pessoas;
    
    public GerenciarPessoas(){
        this.pessoas = new ArrayList<>();
    }
    
    public void addPessoas(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    
    public void listarPessoas(){
        for(Pessoa p : pessoas){
            System.out.format("Nome: %s | Sexo: %s | Idade: %d\n", p.getNome(), p.getSexo(), p.getIdade());
        }
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
