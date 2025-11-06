import java.util.Scanner;

interface Discountable {
    void applyDiscount(double percentage);
    void finalprice();
}

abstract class Device {
    int deviceid;
    String brand;
    double price;

    Device(int deviceid, String brand, double price) {
        this.deviceid = deviceid;
        this.brand = brand;
        this.price = price;
    }

    abstract void displayDetails();
}

class Smartphone extends Device implements Discountable {
    private double discountedPrice;

    Smartphone(int deviceid, String brand, double price) {
        super(deviceid, brand, price);
        this.discountedPrice = price; // initially same as price
    }

    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = this.price * (percentage / 100.0);
        discountedPrice = this.price - discountAmount;
        System.out.println("Applied discount of " + percentage + "% successfully!");
        System.out.println("Discount amount: Rs " + discountAmount);
        System.out.println("Final price after discount: Rs " + discountedPrice);
    }

    @Override
    public void finalprice() {
        System.out.println("The final price after discount is Rs " + discountedPrice);
    }

    @Override
    void displayDetails() {
        System.out.println("\n--- Device Details ---");
        System.out.println("Device ID: " + deviceid);
        System.out.println("Brand: " + brand);
        System.out.println("Original Price: Rs " + price);
        System.out.println("Current Price: Rs " + discountedPrice);
    }
}

public class SmartDeviceStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Device ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter the Brand Name: ");
        String brand = sc.nextLine();

        System.out.print("Enter the Price: ");
        double price = sc.nextDouble();

        Smartphone device = new Smartphone(id, brand, price);

        int choice;
        do {
            System.out.println("\n--- Device Store Menu ---");
            System.out.println("1. Apply Discount");
            System.out.println("2. View Final Price");
            System.out.println("3. View Device Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter discount percentage: ");
                    double percent = sc.nextDouble();
                    device.applyDiscount(percent);
                    break;

                case 2:
                    device.finalprice();
                    break;

                case 3:
                    device.displayDetails();
                    break;

                case 4:
                    System.out.println("Thank you for using our store!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
