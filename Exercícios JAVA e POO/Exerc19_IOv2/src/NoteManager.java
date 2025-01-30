/**
 * Class NoteManager -> Path verification, file manipulation
 * Constructor: Path to the notes folder in the user's home directory
 * Mathods: createNote, readNote and DdeleteNote
 * */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class NoteManager {
    Scanner scanner = new Scanner(System.in);
    private Path path;

    public NoteManager() {
        path = Paths.get(System.getProperty("user.home"), "Documents", "Notas");
        if (!path.toFile().exists()) {
            path = Paths.get(System.getProperty("user.home"), "Documentos", "Notas");
        }
    }

    public void createNote() throws IOException {
        Files.createDirectories(path);
        System.out.print("Digite o nome da nota: ");
        String name = scanner.nextLine();
        System.out.print("Digite o conteúdo da nota: ");
        String content = scanner.nextLine();

        // Define o caminho para o arquivo da nota, toString converte o caminho para uma string
        Path filePath = Paths.get(path.toString(), name + ".txt");

        // Cria o arquivo da nota
        Path file = Files.createFile(filePath);

        // Escreve o conteúdo no arquivo da nota
        Files.copy(file, filePath);
        Files.write(file, content.getBytes());
    }

    public void readNote() throws IOException {
        Main.displayNotesFolderContents(path);

        System.out.print("Digite o nome da nota que deseja ler (não escreva '.txt'): ");
        String name = scanner.nextLine();

        System.out.println("Conteúdo da nota:");
        // Lê o conteúdo do arquivo da nota e imprime na tela
        System.out.println(Files.readString(Paths.get(path.toString(), name + ".txt")));
    }

    public void deleteNote() throws IOException {
        Main.displayNotesFolderContents(path);

        System.out.print("Digite o nome da nota que deseja excluir (não escreva '.txt'): ");
        String name = scanner.nextLine();
        Files.delete(Paths.get(path.toString(), name + ".txt"));
        System.out.println("Nota excluída com sucesso.");
    }
}
