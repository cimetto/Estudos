public class Missao {
    private String name;
    private int dificulty;

    public Missao(String name, int dificulty) {
        this.name = name;
        this.dificulty = dificulty;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDificulty() {
        return dificulty;
    }

    public void setDificulty(int dificulty) {
        this.dificulty = dificulty;
    }
    
}
