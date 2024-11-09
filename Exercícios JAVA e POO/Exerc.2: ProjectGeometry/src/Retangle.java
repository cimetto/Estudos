public class Retangle implements Interface{
    private double base, height;
    
    public void infoRetangle(double base, double height){
        this.base = base;
        this.height = height;
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
        
        System.out.println("Base: " + this.base);
        System.out.println("Height: " + this.height);
        double areaRetangle = this.base * this.height;
        System.out.println("The area of the retangle is: " + areaRetangle);
    }
    
}
