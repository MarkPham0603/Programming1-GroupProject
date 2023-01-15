/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Pham Minh Hoa,Chau The Kien, Phan Tran Minh Toan
  ID: s3929256, s3790421, s3963231
  Acknowledgement: Tom huynh https://github.com/TomHuynhSG/COSC2081-Lab-Solutions
                   My old project https://github.com/Devtorious/Programming-1
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMangeSys {



    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //Create UserLogin, Customer, Admin, ProductService and OrderService
        UserLogin userLogin = new UserLogin();
        Customer customer = new Customer();
        Admin admin = new Admin();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        System.out.println("COSC2081 GROUP ASSIGNMENT\n" +
                "STORE ORDER MANAGEMENT SYSTEM\n" +
                "Instructor: Mr. Tom Huynh & Dr. Phong Ngo\n" +
                "Group: Random 5\n" +
                "s3929256, Pham Minh Hoa\n" +
                "ss3790421, Chau The Kien\n" +
                "s3963231, Phan Tran Minh Toan");
        System.out.println("------------------------------------------");
        System.out.println("ORDER MANAGEMENT SYSTEM");
        System.out.println("\n1. Create an account       2. Sign in\n" +
                "3. Load user data");

        int choice = 0;
        do {
            System.out.println("User can choose 1, 2 or 3: ");
            choice = sc.nextInt();
            if (choice == 1) {
                userLogin.register();
                choice = 4;
            } else if (choice == 2) {
                userLogin.Login();
                choice = 4;
            } else if (choice == 3) {
                userLogin.readtxtFile();
            } else {
                System.out.println("Wrong input value");
            }
        } while (choice == 1 || choice == 2 || choice == 3);

        System.out.println("------------------------------");
        System.out.println("You can choose:");
        System.out.println("1. Start shopping \n2. Starting selling");
        int choice1 = sc.nextInt();

        do {
            if (choice1 == 1) {

                int choice2 = 0;
                do {
                    System.out.println("------------------------------");
                    System.out.println("WELCOME CUSTOMER");
                    System.out.println("\nHere is your feature:");
                    System.out.println("1. Show your information\n" +
                            "2. Update your information\n" +
                            "3. Shopping\n" +
                            "4. Show all products\n" +
                            "5. Searching product by category\n" +
                            "6. Price sorting\n" +
                            "7. Search order\n" +
                            "8. Paying\n" +
                            "9. Load Product\n" +
                            "10. Save user information\n" +
                            "11. Save Order\n" +
                            "12. Load order" +
                            "13. Exit");
                    System.out.println("Choose one feature to continue:");
                    choice2 = sc.nextInt();
                    //Use switch case to call all methods
                    switch (choice2) {
                        case 1:
                            customer.showCustomerInfo();
                            break;
                        case 2:
                            customer.updateCustomer();
                            break;
                        case 3:
                            orderService.createOrder();
                            break;
                        case 4:
                            productService.productShow();
                            break;
                        case 5:
                            productService.searchCategory();
                            break;
                        case 6:
                            productService.sortPrice();
                            break;
                        case 7:
                            orderService.searchOrder();
                            break;
                        case 8:
                            orderService.calculateOrder();
                            break;
                        case 9:
                            productService.readProductFile();
                            break;
                        case 10:
                            userLogin.insertArray();
                            break;
                        case 11:
                            orderService.insertOrderArray();
                            break;
                        case 12:
                            orderService.readOrderfile();
                    }
                } while (choice2 < 13);
            } else if (choice1 == 2) {

                int choice3 = 0;
                do {
                    System.out.println("------------------------------");
                    System.out.println("WELCOME ADMIN");
                    System.out.println("\nHere is your feature:");
                    System.out.println("1. Show all customers\n" +
                            "2. Show admin information\n" +
                            "3. Show all products\n" +
                            "4. Show all Order\n" +
                            "5. Add new product\n" +
                            "6. Remove product\n" +
                            "7. Set membership\n" +
                            "8. Remove customer\n" +
                            "9. Membership list\n" +
                            "10. Revenue day\n" +
                            "11. Save Product\n" +
                            "12. Load Products\n" +
                            "13. Load Orders\n" +
                            "14. Set order status\n" +
                            "15. Exit");
                    System.out.println("Choose one feature to continue:");
                    choice3 = sc.nextInt();
                    switch (choice3) {
                        case 1:
                            admin.customerShow();
                            break;
                        case 2:
                            customer.showCustomerInfo();
                            break;
                        case 3:
                            productService.productShow();
                            break;
                        case 4:
                            orderService.showOrderList();
                            break;
                        case 5:
                            productService.createProduct();
                            break;
                        case 6:
                            productService.removeProduct();
                            break;
                        case 7:
                            admin.addMembership();
                            break;
                        case 8:
                            admin.removeCustomer();
                            break;
                        case 9:
                            admin.countMembership();
                            break;
                        case 10:
                            orderService.storeRevenue();
                            break;
                        case 11:
                            productService.insertProductArray();
                            break;
                        case 12:
                            productService.readProductFile();
                            break;
                        case 13:
                            orderService.readOrderfile();
                            break;
                        case 14:
                            orderService.setOrderStatus();
                            break;
                    }
                } while (choice3 < 15);

            } else {
                System.out.println("Wrong input value");
            }
            System.out.println("Choose 3 to exit the system: ");
            choice1 = sc.nextInt();
        } while (choice1 >= 1 && choice1 <= 2);
        System.out.println("Thank you for using our services! See you again.");
    }
}
