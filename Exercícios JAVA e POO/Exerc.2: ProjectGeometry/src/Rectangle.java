public class Rectangle implements GeometryForm{
    private double base, height;
    
    public Retangle(double base, double height){
        this.base = base;
        this.height = height;
    }    

    @Override
    public void tipoFormaGeometrica() {
        
    }

    @Override
    public void areaFormaGeometrica() {
        
        System.out.println("Base: " + this.base);
        System.out.println("Height: " + this.height);
        double areaRetangle = this.base * this.height;
        System.out.println("The area of the retangle is: " + areaRetangle);
    }
    
}
