import java.util.Scanner;

public class AppGeometry {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int choice;       
        
        do {
            System.out.println("\nChoice a geometry form:");
            System.out.println("1. Triangle");
            System.out.println("2. Square");
            System.out.println("3. Circle");
            System.out.println("4. Rectangle");
            System.out.println("0. Exit");
            
            System.out.print("Choice an option (0-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                     
                    GeometryForm triangle = new Triangle(12, 13, 14, 9);
                    triangle.tipoFormaGeometrica();
                    triangle.areaFormaGeometrica();
                    break;
                    
                case 2:
                    
                    GeometryForm square = new Square(4);
                    square.areaFormaGeometrica();
                    break;
                    
                case 3:
                    
                    GeometryForm circle = new Circle(4);
                    circle.areaFormaGeometrica();
                    break;
                    
                case 4:
                    
                    GeometryForm rectangle = new Rectangle(2, 4);
                    rectangle.areaFormaGeometrica();
                    break;
                    
                case 0:
                    
                    System.out.println("Thanks for using my program...");
                    break;
                    
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (choice != 0); 

        scanner.close();
    }
}
