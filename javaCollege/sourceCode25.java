import java.util.Scanner;

public class Product{
    private String productName;
    private int price;
    private int stock;

    public Product(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert Product Name: " + "String Value (" + productName + ")");
        this.productName = scanner.nextLine();

        System.out.println("Insert Product Price: " + "Integer Value (" + price + ")");
        this.price = scanner.nextInt();

        System.out.println("Insert Product Stock: " + "Integer Value (" + stock + ")");
        this.stock = scanner.nextInt();
    }

    protected void finalizer () throws Throwable{
        try {
            System.out.println("Deleting On Process...");
        } catch (Throwable e){
            throw e;
        } finally {
            System.out.println("Deleting Done.");
        }
    }

    public String getProductName(){
        return productName;
    }

    public int getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }
}

public class Inventory{

    private Product[] products;
    private int capacity;
    private int size;

    public Inventory(int capacity){
        this.products = new Product[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void addProduct(){
        if (size < capacity){
            Product product = new Product();
            products[size] = product;
            size++;
            System.out.println("Product Has Been Added.");
        }
        else{
            System.out.println("The Storage Are Full, Can't Add Another Product.");
        }
    }

    public void displayAllProducts(){
        System.out.println("Product List");

        for (int i = 0; i < size; i++){
            System.out.println("Product's Name: " + products[i].getProductName());
            System.out.println("Product's Price: " + products[i].getPrice());
            System.out.println("Product's Stock: " + products[i].getStock());
        }
    }

    public void deleteProductByName(String productName){
        for (int i = 0; i < size; i++){
            if (products[i].getProductName().equals(productName)){
                System.out.println("Deleting Product -> (" + productName + ")");
                products[i] = null;
                System.arraycopy(products, i + 1, products, i, size - i - 1);
                size--;
                System.out.println("The Product Has Been Deleted.");
                return;
            }
        }
        System.out.println("Product " + productName + " Not Found, Please Insert A Valid Product's Keyword");
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int capacity;

        System.out.println("Insert The Capacity Of The Product Database Menu's Inventory");
        while (true) {
            try {
                capacity = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input, Please Insert A Valid Keyword (Integer).");
                System.out.println("Please Insert The Capacity Of The Product Database Menu's Inventory");
                scanner.nextLine();
            }
        }

        int choice;

        Inventory inventory = new Inventory(capacity);

        do {
            System.out.println("\nPRODUCT DATABASE's MENU");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Delete Product By Name");
            System.out.println("4. Exit");
            choice = scanner.nextInt();

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e){
                scanner.nextLine();
                choice = 0;
            }

            switch (choice){
                case 1:
                    inventory.addProduct();
                    break;

                case 2:
                    inventory.displayAllProducts();
                    break;

                case 3:
                    System.out.println("Insert Product Name To Delete: ");
                    scanner.nextLine();
                    String deleteProductByName = scanner.nextLine();
                    inventory.deleteProductByName(deleteProductByName);
                    break;
                case 4:
                    System.out.println("Exiting Program.");
                    break;

                default:
                    if (choice != 4){
                        System.out.println("Invalid Choice. Please Enter A Valid Option.");
                    }
            }
        }
        while (choice != 4);
    }
}
