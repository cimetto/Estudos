import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DictionaryManager {
    private HashMap<String, String> dictionary = new HashMap<>();

    void addEntry(String word, String definition) {

        /*
        WORD É A CHAVE **(Key)**
        DEFINITION É O VALOR **(Value)**
        */

        if (dictionary.containsKey(word)) { // Verifica se a palavra já existe no dicionário
            String currentDefinition = dictionary.get(word); // dictionary.get() sempre retorna o valor associado à chave
            dictionary.put(word, currentDefinition + definition); // Atualiza a palavra com a definição atual + nova definição
        } else {
            dictionary.put(word, definition); // Se a palavra não existe, adiciona a nova palavra com sua definição
        }
    }

    String getDefinition(String word) {
        if (dictionary.containsKey(word)) {
            String currentDefinition = dictionary.get(word);
            return String.format("Word: %s\n - Meaning: %s\n", word, currentDefinition);
        } else {
            return "Word not found.";
        }
    }

    void removeEntry(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            System.out.format("Removing this word '%s'...\n", word);
            System.out.println(word + " removed.");
        } else {
            System.out.println("Could not remove word.");
        }
    }

    void listAllEntries(){
        System.out.println("Words:");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.format("Word: %s --> Meaning: %s\n", entry.getKey(), entry.getValue());
        }
    }

    void findWordsByPrefix(String prefix) {
        HashSet<String> hashSet = new HashSet<>(); // Cria um HashSet para armazenar as palavras que começam com o prefixo
        System.out.format("Words that start with '%s':", prefix);
        for (String word : dictionary.keySet()) { // Itera sobre cada palavra no conjunto de chaves do dicionário
            if (word.startsWith(prefix)) { // Verifica se a palavra começa com o prefixo fornecido
                hashSet.add(word);
                System.out.print(" - " + word);
            }
        }
    }
}
