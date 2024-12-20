public class Main {
    public static void main(String[] args) {
        DictionaryManager dictionaryManager = new DictionaryManager();
        dictionaryManager.addEntry("HashMap", "Uma estrutura de dados que armazena pares de chave e valor.");

        dictionaryManager.listAllEntries();

        dictionaryManager.getDefinition("C++");

        dictionaryManager.addEntry("Java", "Uma linguagem de programação orientada a objetos.");
        dictionaryManager.addEntry("Python", "É uma linguagem de programação amplamente usada em aplicações da Web, desenvolvimento de software, ciência de dados e machine learning (ML).");
        dictionaryManager.addEntry("JavaScript", "Uma linguagem de programação usada para desenvolvimento web.");

        dictionaryManager.removeEntry("Python");

        dictionaryManager.listAllEntries();

        dictionaryManager.findWordsByPrefix("Java");
    }
}