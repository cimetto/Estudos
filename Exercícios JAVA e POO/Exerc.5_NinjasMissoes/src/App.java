public class App {
    public static void main(String[] args) {
        Missao m1 = new Missao("x1 dos crias", 80);
        Ninja n1 = new Ninja("Sasuke", "Beta", 80);
        Ninja n2 = new Ninja("Saitama", "Sigma", 1000000);
        Ninja n3 = new Ninja("Sakura", "Muié", 1);
        
        Equipe equipe7 = new Equipe("Equipe 7");
        equipe7.addNinjas(n1);
        equipe7.addNinjas(n2);
        equipe7.addNinjas(n3);
        equipe7.addMissoes(m1);
        
        equipe7.exibirItens();
        System.out.println("\nResultados:");
        System.out.println(n1.participarMissao(m1));
        System.out.println(n2.participarMissao(m1));
        System.out.println(n3.participarMissao(m1));
    }
}
