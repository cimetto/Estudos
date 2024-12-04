public class Customer {
    private String customerType;
    private double purchaseValue;
    
    public Customer(String customerType, double purchaseValue){
	this.customerType = customerType;
	this.purchaseValue = purchaseValue;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }
}
