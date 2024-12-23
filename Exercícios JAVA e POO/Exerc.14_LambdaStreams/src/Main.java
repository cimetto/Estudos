import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /**
         * Filtrando e imprimindo os números pares da lista:
         * - stream(): percorre os dados da lista
         * - filter(): filtra a lista de acordo com a condição estabelecida
         * - forEach(): imprime cada número filtrado
         */
        System.out.print("Uma lista com os números pares: [ ");
        list.stream().filter(integer -> integer % 2 == 0).forEach(integer -> System.out.print(integer + " "));
        System.out.println("]\n");

        System.out.print("Uma lista com os números maiores que 5: [ ");
        list.stream().filter(integer -> integer > 5).forEach(integer -> System.out.print(integer + " "));
        System.out.println("]\n");

        System.out.print("Uma lista com os números divisíveis por 3: [ ");
        list.stream().filter(integer -> integer % 3 == 0).forEach(integer -> System.out.print(integer + " "));
        System.out.println("]\n");
    }
}
