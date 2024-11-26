public class Ninja {
    private String name;
    private String rank;
    private int habilit;
    
    public Ninja(String name, String rank, int habilit){
        this.name = name;
        this.rank = rank;
        this.habilit = habilit;
    }
    
    public boolean participarMissao(Missao participarMissao){
        if (habilit >= participarMissao.getDificulty()){
            System.out.format("%s está apto para participar da missão!: \n", name);
            return true;
        } else{
            System.out.format("%s não atende o requisito da missão!: \n", name);
            return false;
        }
    }
    
    public String toString(){
        String infoNinja = String.format("Nome: %s | Rank: %s | Habilidade: %d\n", name, rank, habilit);
        return infoNinja;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getHabilit() {
        return habilit;
    }

    public void setHabilit(int habilit) {
        this.habilit = habilit;
    }
}
