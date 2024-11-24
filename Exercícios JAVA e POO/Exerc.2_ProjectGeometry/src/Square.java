public class Square implements GeometryForm{
    private double side;
    
    public Square(double side){
        this.side = side;
    }

    @Override
    public void tipoFormaGeometrica() {
               
    }

    @Override
    public void areaFormaGeometrica() {
        
        System.out.println("Side: " + this.side);
        double squareArea = this.side * this.side;
        System.out.println("The area of the square is: " + squareArea);
    }
    
}
