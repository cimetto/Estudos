import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class NoteSearch {
    Scanner scanner = new Scanner(System.in);
    Path path;

    public NoteSearch() {
        path = Paths.get(System.getProperty("user.home"), "Documents", "Notes");
        if (!path.toFile().exists()) {
            path = Paths.get(System.getProperty("user.home"), "Documentos", "Notas");
        }
    }

    public void searchNote() throws IOException {
        System.out.println("\nArquivos de texto disponíveis:");
        displayNotesFolderContents(path);

        System.out.print("\nDigite o nome do arquivo: ");
        String name = scanner.nextLine();
        Path filePath = Paths.get(path.toString(), name);
        if (!Files.exists(filePath)) {
            throw new IOException("O arquivo não existe!");
        }
        System.out.print("Digite a palavra que deseja buscar: ");
        String content = scanner.nextLine();

        Files.lines(filePath)
                .filter(line -> line.contains(content))
                .forEach(line -> System.out.println("Encontrado: " + line));

    }

    public static void displayNotesFolderContents(Path pathToNotes) throws IOException {
        if (pathToNotes.toFile().exists() && pathToNotes.toFile().isDirectory()) {
            Files.list(pathToNotes).forEach(p -> System.out.println(p.getFileName().toString()));
        } else {
            System.out.println("A pasta 'Notas' não existe ou foi excluido.");
        }
    }
}
