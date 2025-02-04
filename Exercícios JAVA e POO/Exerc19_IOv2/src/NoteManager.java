/**
 * Class NoteManager -> Path verification, file manipulation
 * Constructor: Path to the notes folder in the user's home directory
 * Methods: createNote, readNote, deleteNote, searchNote, editNote, displayNotesFolderContents, openFileInEditor
 *
 * O NoteManager é responsável por gerenciar notas em arquivos de texto. Ele permite a criação, leitura, exclusão, edição e busca de notas.
 * A classe verifica se a pasta "Notas" existe no diretório "Documents" ou "Documentos" do usuário, e executa as operações
 * sobre os arquivos dentro dessa pasta.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class NoteManager {
    Scanner scanner = new Scanner(System.in);
    private Path path;

    /**
     * Construtor da classe NoteManager. Inicializa o caminho da pasta de notas,
     * verificando o diretório "Documents" ou "Documentos" no diretório home do usuário.
     */
    public NoteManager() {
        path = Paths.get(System.getProperty("user.home"), "Documents", "Notes");
        if (!path.toFile().exists()) {
            path = Paths.get(System.getProperty("user.home"), "Documentos", "Notas");
        }
    }

    /**
     * Cria uma nova nota, solicitando o nome e o conteúdo ao usuário.
     * A nota é salva na pasta de notas configurada no construtor.
     *
     * @throws IOException Caso ocorra algum erro durante a criação do arquivo ou escrita.
     */
    public void createNote() throws IOException {
        Files.createDirectories(path);
        System.out.print("Digite o nome da nota: ");
        String name = scanner.nextLine();
        System.out.print("Digite o conteúdo da nota: ");
        String content = scanner.nextLine();

        // Define o caminho para o arquivo da nota, toString converte o caminho para uma string
        Path filePath = Paths.get(path.toString(), name);

        // Cria o arquivo da nota
        Path file = Files.createFile(filePath);

        // Escreve o conteúdo no arquivo da nota
        Files.copy(file, filePath);
        Files.write(file, content.getBytes());
    }

    /**
     * Busca por uma palavra dentro de um arquivo de nota.
     * O usuário seleciona o arquivo e a palavra a ser buscada.
     * Exibe as linhas onde a palavra foi encontrada.
     *
     * @throws IOException Caso ocorra algum erro durante a leitura do arquivo ou busca.
     */
    public void searchNote() throws IOException {
        System.out.println("\nArquivos de texto disponíveis:");
        displayNotesFolderContents(path);

        System.out.print("\nDigite o nome do arquivo: ");
        String name = scanner.nextLine();
        Path filePath = Paths.get(path.toString(), name);

        // Verifica se o arquivo existe
        if (!Files.exists(filePath)) {
            throw new IOException("O arquivo não existe!");
        }

        System.out.print("Digite a palavra que deseja buscar: ");
        String content = scanner.nextLine().trim();

        List<String> lines = Files.readAllLines(filePath);
        boolean found = false;

        // Leitura das linhas do arquivo e busca da palavra
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains(content)) {
                System.out.println("Encontrado na linha " + (i + 1) + ": " + line);
                found = true;
            }
        }

        // Se não encontrou nada, informa o usuário
        if (!found) {
            System.out.println("Palavra não encontrada no arquivo.");
        }
    }

    /**
     * Lê o conteúdo de uma nota e o exibe no console.
     * O usuário deve informar o nome do arquivo da nota.
     *
     * @throws IOException Caso ocorra algum erro ao ler o arquivo da nota.
     */
    public void readNote() throws IOException {
        displayNotesFolderContents(path);

        System.out.print("Digite o nome da nota que deseja ler: ");
        String name = scanner.nextLine();

        System.out.println("Conteúdo da nota:");
        // Lê o conteúdo do arquivo da nota e imprime na tela
        System.out.println(Files.readString(Paths.get(path.toString(), name)));
    }

    /**
     * Exclui uma nota especificada pelo usuário.
     *
     * @throws IOException Caso ocorra algum erro ao excluir o arquivo.
     */
    public void deleteNote() throws IOException {
        displayNotesFolderContents(path);

        System.out.print("Digite o nome da nota que deseja excluir: ");
        String name = scanner.nextLine();
        Files.delete(Paths.get(path.toString(), name));
        System.out.println("Nota excluída com sucesso.");
    }

    /**
     * Edita o conteúdo de uma nota existente. O usuário pode visualizar o conteúdo
     * atual e editá-lo utilizando um editor gráfico.
     *
     * @throws IOException Caso ocorra algum erro durante a edição do arquivo.
     */
    public void editNote() throws IOException {
        // Exibe as notas disponíveis
        displayNotesFolderContents(path);

        System.out.print("Digite o nome da nota que deseja editar: ");
        String name = scanner.nextLine();
        Path filePath = Paths.get(path.toString(), name);

        // Verifica se o arquivo existe
        if (!Files.exists(filePath)) {
            System.out.println("Arquivo não encontrado!");
            return;
        }

        List<String> lines = Files.readAllLines(filePath);  // Corrigido o tipo da variável
        System.out.println("\nConteúdo atual do arquivo:");

        lines.forEach(line -> System.out.println(line));

        // 2. Iniciar o editor gráfico para edição
        System.out.println("\nAbrindo o arquivo no editor de texto...");
        openFileInEditor(filePath);
    }

    /**
     * Exibe os arquivos contidos na pasta de notas.
     *
     * @param pathToNotes O caminho da pasta onde as notas estão armazenadas.
     * @throws IOException Caso ocorra algum erro ao listar os arquivos.
     */
    public static void displayNotesFolderContents(Path pathToNotes) throws IOException {
        if (pathToNotes.toFile().exists() && pathToNotes.toFile().isDirectory()) {
            Files.list(pathToNotes).forEach(p -> System.out.println(p.getFileName().toString()));
        } else {
            System.out.println("A pasta 'Notas' não existe ou foi excluída.");
        }
    }

    /**
     * Abre um arquivo de nota em um editor gráfico de acordo com o sistema operacional.
     *
     * @param filePath O caminho do arquivo a ser aberto.
     * @throws IOException Caso ocorra algum erro ao tentar abrir o arquivo.
     */
    public void openFileInEditor(Path filePath) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();

        // Se for Linux, use o comando xdg-open
        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            try {
                // Verifica se o arquivo existe e tenta abrir com xdg-open
                if (Files.exists(filePath)) {
                    Runtime.getRuntime().exec("xdg-open " + filePath.toString());
                } else {
                    System.out.println("Arquivo não encontrado!");
                }
            } catch (IOException e) {
                System.out.println("Erro ao tentar abrir o arquivo com xdg-open.");
                e.printStackTrace();
            }
        } else if (os.contains("win")) {
            // No Windows, podemos usar o comando "notepad"
            try {
                if (Files.exists(filePath)) {
                    Runtime.getRuntime().exec("notepad " + filePath.toString());
                } else {
                    System.out.println("Arquivo não encontrado!");
                }
            } catch (IOException e) {
                System.out.println("Erro ao tentar abrir o arquivo com o notepad.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Sistema operacional não suportado para abrir o editor.");
        }
    }
}
