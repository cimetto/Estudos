import java.util.Scanner;

public class AppGeometry {
    public static void main(String[] args) {
        // Scanner para capturar a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        // Menu principal para escolha da forma geométrica
        do {
            System.out.println("\nEscolha uma forma geométrica:");
            System.out.println("1. Triângulo");
            System.out.println("2. Quadrado");
            System.out.println("3. Círculo");
            System.out.println("4. Retângulo");
            System.out.println("0. Sair");
            
            System.out.print("Escolha uma opção (0-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    Triangle triangle = new Triangle();
                    triangle.infoTriangle(12, 8, 10, 9);
                    triangle.eFormaGeometrica();
                    triangle.tipoFormaGeometrica();
                    triangle.areaFormaGeometrica();
                    break;
                    
                case 2:
                    
                    Square square = new Square();
                    square.infoSquare(4);
                    square.areaFormaGeometrica();
                    break;
                    
                case 3:
                    
                    Circle circle = new Circle();
                    circle.infoCircle(6);
                    circle.areaFormaGeometrica();
                    break;
                    
                case 4:
                    
                    Retangle retangle = new Retangle();
                    retangle.infoRetangle(12, 6);
                    retangle.areaFormaGeometrica();
                    break;
                    
                case 0:
                    
                    System.out.println("Saindo do programa...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (choice != 0); 

        scanner.close();
    }
}
