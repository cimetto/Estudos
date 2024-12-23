import java.util.ArrayList;

public class Equipe {
    private String name;
    private ArrayList<Ninja> ninjas;
    private ArrayList<Missao> missoes;
    
    public Equipe(String name){
        this.name = name;
        this.ninjas = new ArrayList<>();
        this.missoes = new ArrayList<>();
    }
    
    public void addMissoes(Missao missao){      
        this.missoes.add(missao);
    }
    
    public void addNinjas(Ninja ninjas){      
        this.ninjas.add(ninjas);
    }
    
    public void exibirItens() {
        System.out.format("Equipe: %s\n", name);
        System.out.format("Ninjas:\n");
        for (Ninja n : ninjas) {
            System.out.format("\n- Nome: %s | Rank: %s | Habilidade: %s\n", n.getName(), n.getRank(), n.getHabilit());
        System.out.format("Missões:\n");
        for (Missao m : missoes) {
            System.out.format("- Nome: %s | Dificuldade: %d\n", m.getName(), m.getDificulty());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ninja> getNinjas() {
        return ninjas;
    }

    public void setNinjas(ArrayList<Ninja> ninjas) {
        this.ninjas = ninjas;
    }
    
}
