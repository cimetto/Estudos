public class Circle implements GeometryForm{
    private double ray;
    
    public Circle(double ray){
        this.ray = ray;
    }

    @Override
    public void tipoFormaGeometrica() {
        
    }

    @Override
    public void areaFormaGeometrica() {
        
        System.out.println("Ray: " + this.ray);
        double areaCircle = Math.PI*Math.pow(ray, ray);
        System.out.println("The are of the circle is: " + areaCircle);
    }
    
}
