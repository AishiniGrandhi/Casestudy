package models;


public class ElectronicProduct extends Product {
    private String brand;
    private int warranty;

    public ElectronicProduct(String id, String name, double price, int stock, String brand, int warranty) {
        super(id, name, price, stock);
        this.brand = brand;
        this.warranty = warranty;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Type: Electronic");
        System.out.println("Name: " + getName());
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + getPrice());
        System.out.println("Warranty: " + warranty + " months");
        System.out.println("Stock: " + getStock());
        System.out.println("------------------------");
    }
    public String getBrand() {
        return brand;
    }

	public int getWarranty() {
		// TODO Auto-generated method stub
		return  warranty;
	}
}
