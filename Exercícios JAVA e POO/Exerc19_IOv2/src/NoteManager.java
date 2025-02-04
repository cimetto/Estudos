/**
 * Gerenciador de notas:
 *  - Métodos:
 *  -> constructor: a variável path recebe o método initializePath.
 *  -> initializePath: faz a verificação do idioma presente no sistema, se é PT_BR ou EN_US.
 *  -> createNote: cria a nota pedindo o nome e o conteúdo.
 *  -> searchNote: busca na nota uma palavra e imprime em qual linha ela está.
 *  -> readNote: imprime as notas disponíveis no sistema e pede ao usuário o nome da nota que deseja ler.
 *  -> deleteNote: imprime as notas disponíveis no sistema e pede ao usuário o nome da nota que deseja excluir.
 *  -> editNote: primeiro faz-se a verificação do tipo de sistema que o usuário está usando, se é linux ou
 *  windows, em seguida imprime as notas disponíveis no sistema e pede ao usuário o nome da nota que deseja editar,
 *  em seguida abrimos o editor de texto padrão do sistema. (FUTURAMENTE SERÁ EDITADO)
 *  -> getInput: uma simplificação do uso do Scanner
 *  */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class NoteManager {
    private static final String DOCUMENTS_DIR_EN = "Documents";
    private static final String DOCUMENTS_DIR_PT = "Documentos";
    private static final String NOTES_DIR_NAME = "Notes";
    private static final String NOTAS_DIR_NAME = "Notas";

    private final Scanner scanner = new Scanner(System.in);
    private final Path path;

    public NoteManager() {
        path = initializePath();
    }

    private Path initializePath() {
        Path notesPath = Paths.get(System.getProperty("user.home"), DOCUMENTS_DIR_EN, NOTES_DIR_NAME);
        if (!Files.exists(notesPath)) {
            notesPath = Paths.get(System.getProperty("user.home"), DOCUMENTS_DIR_PT, NOTAS_DIR_NAME);
        }
        return notesPath;
    }

    public void createNote() throws IOException {
        Files.createDirectories(path);
        String name = getInput("Digite o nome da nota: ");
        String content = getInput("Digite o conteúdo da nota: ");

        Path filePath = path.resolve(name);
        Files.write(filePath, content.getBytes());
        System.out.println("Nota criada com sucesso!");
    }

    public void searchNote() throws IOException {
        displayNotesFolderContents();
        String name = getInput("Digite o nome do arquivo: ");
        Path filePath = path.resolve(name);

        if (!Files.exists(filePath)) {
            throw new IOException("O arquivo não existe!");
        }

        String keyword = getInput("Digite a palavra que deseja buscar: ").trim();
        List<String> lines = Files.readAllLines(filePath);
        boolean found = false;

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(keyword)) {
                System.out.println("Encontrado na linha " + (i + 1) + ": " + lines.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Palavra não encontrada no arquivo.");
        }
    }

    public void readNote() throws IOException {
        displayNotesFolderContents();
        String name = getInput("Digite o nome da nota que deseja ler: ");
        Path filePath = path.resolve(name);

        if (Files.exists(filePath)) {
            System.out.println("Conteúdo da nota:");
            System.out.println(Files.readString(filePath));
        } else {
            System.out.println("Nota não encontrada.");
        }
    }

    public void deleteNote() throws IOException {
        displayNotesFolderContents();
        String name = getInput("Digite o nome da nota que deseja excluir: ");
        Path filePath = path.resolve(name);

        if (Files.exists(filePath)) {
            Files.delete(filePath);
            System.out.println("Nota excluída com sucesso.");
        } else {
            System.out.println("Nota não encontrada.");
        }
    }

    public void editNote() throws IOException {
        displayNotesFolderContents();
        String name = getInput("Digite o nome da nota que deseja editar: ");
        Path filePath = path.resolve(name);

        if (!Files.exists(filePath)) {
            System.out.println("Arquivo não encontrado!");
            return;
        }

        List<String> lines = Files.readAllLines(filePath);
        System.out.println("\nConteúdo atual do arquivo:");
        lines.forEach(System.out::println);

        System.out.println("\nAbrindo o arquivo no editor de texto...");
        openFileInEditor(filePath);
    }

    private void displayNotesFolderContents() throws IOException {
        if (Files.exists(path) && Files.isDirectory(path)) {
            Files.list(path).forEach(p -> System.out.println(p.getFileName()));
        } else {
            System.out.println("A pasta 'Notas' não existe ou foi excluída.");
        }
    }

    private void openFileInEditor(Path filePath) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();

        if (Files.exists(filePath)) {
            if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                Runtime.getRuntime().exec("xdg-open " + filePath);
            } else if (os.contains("win")) {
                Runtime.getRuntime().exec("notepad " + filePath);
            } else {
                System.out.println("Sistema operacional não suportado para abrir o editor.");
            }
        } else {
            System.out.println("Arquivo não encontrado!");
        }
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}