public class Triangle implements GeometryForm{
    private double base, side1, side2, height;
    
    public Triangle(double base, double side1, double side2, double height){
        this.base = base;
        this.side1 = side1;
        this.side2 = side2;
        this.height = height;
    }

    @Override
    public void tipoFormaGeometrica() {
        if (side1 == side2 && side2 == base) {
            System.out.println("Equilateral Triangle");
        } else if (side1 == side2 || side1 == base || side2 == base) {
            System.out.println("Isosceles Triangle");
        } else {
            System.out.println("Scalene Triangle");
        }
    }

    @Override
    public void areaFormaGeometrica() {
        
        System.out.println("Base: " + this.base);
        System.out.println("Height: " + this.height);
        double triangleArea = (this.base * this.height)/2;
        System.out.println("The area of the triangle is: " + triangleArea);
    }

}
