package services;

import models.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ECommerceApp {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Product> cart = new ArrayList<>();
    private static User currentUser;
    private static PaymentService paymentService = new PaymentProcessor();
    
    public static void main(String[] args) {
        initializeProducts();
        currentUser = new User("U1001", "Admin User");
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n===== E-Commerce System =====");
            System.out.println("1. View All Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Add New Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addToCart(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout(scanner);
                    break;
                case 5:
                    ProductManager.addNewProduct(products, scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
    
    private static void initializeProducts() {
        products.clear();
        products.add(new ElectronicProduct("E101", "Laptop", 999.99, 10, "Dell", 12));
        products.add(new ElectronicProduct("E102", "Smartphone", 699.99, 15, "Samsung", 24));
        products.add(new ClothingProduct("C101", "T-Shirt", 19.99, 50, "M", "Blue"));
        products.add(new ClothingProduct("C102", "Jeans", 49.99, 30, "32", "Black"));
    }
    
    private static void displayProducts() {
        System.out.println("\n=== Available Products ===");
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                product.displayDetails();
            }
        }
    }
    
    private static void addToCart(Scanner scanner) {
        displayProducts();
        if (products.isEmpty()) {
            return;
        }
        
        System.out.print("Enter product ID to add to cart: ");
        String productId = scanner.nextLine();
        
        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(productId)) {
                selectedProduct = product;
                break;
            }
        }
        
        if (selectedProduct != null) {
            if (selectedProduct.getStock() > 0) {
                // Create a copy of the product for the cart
                Product cartProduct = createProductCopy(selectedProduct);
                cart.add(cartProduct);
                selectedProduct.setStock(selectedProduct.getStock() - 1);
                System.out.println(selectedProduct.getName() + " added to cart.");
            } else {
                System.out.println("Product is out of stock.");
            }
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }
    
    private static Product createProductCopy(Product original) {
        if (original instanceof ElectronicProduct) {
            ElectronicProduct ep = (ElectronicProduct) original;
            return new ElectronicProduct(ep.getId(), ep.getName(), ep.getPrice(), 1, 
                                      ep.getBrand(), ep.getWarranty());
        } else {
            ClothingProduct cp = (ClothingProduct) original;
            return new ClothingProduct(cp.getId(), cp.getName(), cp.getPrice(), 1,
                                    cp.getSize(), cp.getColor());
        }
    }
    
    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }
        
        System.out.println("\n=== Your Shopping Cart ===");
        double total = 0;
        for (Product product : cart) {
            product.displayDetails();
            total += product.getPrice();
        }
        System.out.println("-----------------------");
        System.out.printf("Total: $%.2f\n", total);
    }
    
    private static void checkout(Scanner scanner) {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty. Nothing to checkout.");
            return;
        }
        
        System.out.println("\n=== Checkout ===");
        currentUser.displayInfo();
        viewCart();
        
        double total = calculateTotal();
        System.out.print("\nProceed to payment? (Y/N): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("Y")) {
            paymentService.processPayment(total);
            paymentService.displayPaymentDetails();
            cart.clear();
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Checkout cancelled.");
        }
    }
    
    private static double calculateTotal() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }
}