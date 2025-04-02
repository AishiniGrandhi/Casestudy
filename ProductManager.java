package services;

import models.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    public static void addNewProduct(ArrayList<Product> products, Scanner scanner) {
        System.out.println("\n=== Add New Product ===");
        System.out.println("1. Electronic Product");
        System.out.println("2. Clothing Product");
        System.out.print("Select product type: ");
        
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        
        System.out.print("Enter stock quantity: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (typeChoice) {
            case 1:
                System.out.print("Enter brand: ");
                String brand = scanner.nextLine();
                
                System.out.print("Enter warranty (months): ");
                int warranty = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                products.add(new ElectronicProduct(id, name, price, stock, brand, warranty));
                System.out.println("Electronic product added successfully!");
                break;
                
            case 2:
                System.out.print("Enter size: ");
                String size = scanner.nextLine();
                
                System.out.print("Enter color: ");
                String color = scanner.nextLine();
                
                products.add(new ClothingProduct(id, name, price, stock, size, color));
                System.out.println("Clothing product added successfully!");
                break;
                
            default:
                System.out.println("Invalid product type!");
        }
    }
}
