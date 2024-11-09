public class Circle implements Interface{
    private double ray;
    
    public void infoCircle(double ray){
        this.ray = ray;
    }
    @Override
    public boolean eFormaGeometrica() {
        return true;
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
