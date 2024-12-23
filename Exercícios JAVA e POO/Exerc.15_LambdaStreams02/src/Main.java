import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Alex" );

        System.out.print("Lista de nomes que começam com a letra 'A': [ ");
        list.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.print(s + ", "));
        System.out.println("]");

        System.out.print("Lista dos nomes transformados em maiúsculo: [ ");
        list.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.print(s.toUpperCase() + ", "));
        System.out.println("]");

        System.out.println("Lista com o número de caracteres de cada nome:");
        list.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(" - " + s.length() + " (" + (s) + ")"));
    }
}