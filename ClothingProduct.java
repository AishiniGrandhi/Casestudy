package models;




public class ClothingProduct extends Product {
    private String size;
    private String color;

    public ClothingProduct(String id, String name, double price, int stock, String size, String color) {
        super(id, name, price, stock);
        this.size = size;
        this.color = color;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Type: Clothing");
        System.out.println("Name: " + getName());
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Price: $" + getPrice());
        System.out.println("Stock: " + getStock());
        System.out.println("------------------------");
    }

	public String getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
}
