
/*
 * Projeto: Gerenciador de Notas
 * Descrição: Aplicativo simples para criar e gerenciar notas em arquivos de texto.
 *
 * Como usar:
 * 1 - Criar nota: Digite o nome e conteúdo da nota. A nota será salva como um arquivo .txt na pasta Notas.
 * 2 - Ler nota: Busca a anotação no diretório Notas e exibe o conteúdo.
 * 3 - Excluir nota: Exclui a nota do diretório Notas.
 *
 * Requisitos:
 * - Java 17
 *
 * Para rodar:
 * Compile e execute o código diretamente no seu IDE.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        do {
            System.out.println("Menu de opções:");
            System.out.println("1 - Criar nota");
            System.out.println("2 - Ler nota");
            System.out.println("3 - Excluir nota");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            option = scanner.nextInt();
            scanner.nextLine();

            // Define o caminho para o diretório "Notas" na pasta "Documents"
            Path path = Paths.get(System.getProperty("user.home"), "Documents", "Notas");

            // Verifica se o diretório "Notas" existe na pasta "Documents"
            if (!path.toFile().exists()) {
                // Se não existir, redefine o caminho para o diretório "Notas" na pasta "Documentos"
                path = Paths.get(System.getProperty("user.home"), "Documentos", "Notas");
            }

            switch (option) {
                case 1 -> {
                    // Cria a pasta "Notas" se ela não existir
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

                case 2 -> {
                    displayNotesFolderContents(path);

                    System.out.print("Digite o nome da nota que deseja ler (não escreva '.txt'): ");
                    String name = scanner.nextLine();

                    System.out.println("Conteúdo da nota:");
                    // Lê o conteúdo do arquivo da nota e imprime na tela
                    System.out.println(Files.readString(Paths.get(path.toString(), name + ".txt")));
                }

                case 3 -> {
                    displayNotesFolderContents(path);

                    System.out.print("Digite o nome da nota que deseja excluir (não escreva '.txt'): ");
                    String name = scanner.nextLine();
                    Files.delete(Paths.get(path.toString(), name + ".txt"));
                    System.out.println("Nota excluída com sucesso.");
                }
            }
        } while (option != 0);
    }

    public static void displayNotesFolderContents(Path pathToNotes){
        if (pathToNotes.toFile().exists() && pathToNotes.toFile().isDirectory()) {
            Files.list(pathToNotes).forEach(p -> System.out.println(p.getFileName().toString()));
        } else {
            System.out.println("A pasta 'Notas' não existe ou foi excluido.");
        }
    }
}