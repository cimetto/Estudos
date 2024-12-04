import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criando uma lista de inteiros
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-2);
        list.add(3);
        list.add(-4);
        list.add(5);

        System.out.println("Before: " + list);

        ListModifier modificador = new Multiplier();
        modificador.listModifier(list);
        System.out.println("After Multiplier: " + list);

        ListModifier adicionador = new Adder();
        adicionador.listModifier(list);
        System.out.println("After Adder: " + list);

        ListModifier removerNegativos = new RemoveNegatives();
        removerNegativos.listModifier(list);
        System.out.println("After Remove Negatives: " + list);        
    }
}
