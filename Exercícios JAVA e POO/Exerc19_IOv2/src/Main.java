
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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        NoteManager noteManager = new NoteManager();

        int option = 0;
        do {
            System.out.println("\n=====================");
            System.out.println("Menu de opções:");
            System.out.println("1 - Criar nota");
            System.out.println("2 - Ler nota");
            System.out.println("3 - Excluir nota");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> noteManager.createNote();

                case 2 -> noteManager.readNote();

                case 3 -> noteManager.deleteNote();
            }
        } while (option != 0);
    }

    public static void displayNotesFolderContents(Path pathToNotes) throws IOException {
        if (pathToNotes.toFile().exists() && pathToNotes.toFile().isDirectory()) {
            Files.list(pathToNotes).forEach(p -> System.out.println(p.getFileName().toString()));
        } else {
            System.out.println("A pasta 'Notas' não existe ou foi excluido.");
        }
    }
}