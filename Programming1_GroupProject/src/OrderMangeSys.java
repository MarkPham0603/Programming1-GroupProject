import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMangeSys {



    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        UserLogin userLogin = new UserLogin();
        Customer customer = new Customer();

        System.out.println("ORDER MANAGEMENT SYSTEM");
        System.out.println("\n1. Create an account       2. Sign in\n");
        System.out.println("User can choose 1 or 2: ");
        int choice = sc.nextInt();
        do {
            if (choice == 1) {
                userLogin.register();
            } else if (choice == 2) {
                userLogin.Login();
            } else {
                System.out.println("Wrong input value");
            }
        } while (choice == 1 || choice == 2);

        System.out.println("------------------------------");
        System.out.println("You can choose:");
        System.out.println("1. Start shopping \n 2. Starting selling");
        int choice1 = sc.nextInt();

        do {
            if (choice1 == 1) {
                System.out.println("------------------------------");
                System.out.println("WELCOME CUSTOMER");
                System.out.println("\nHere is your feature:");
                System.out.println("1. Show your information");
                System.out.println("2. Update your information");
                System.out.println("Choose one feature to continue:");
                int choice2 = sc.nextInt();
                do {
                    switch (choice2) {
                        case 1:
                            customer.showCustomerInfo();
                            break;

                        case 2:
                            customer.update();
                            break;
                    }
                } while (choice2 != 3);
            } else if (choice1 == 2) {
                System.out.println("------------------------------");
                System.out.println("WELCOME ADIN");
                System.out.println("\nHere is your feature:");
                System.out.println("Choose one feature to continue:");
            } else {
                System.out.println("Wrong input value");
            }
        } while (choice1 != 1 || choice1 != 2);
    }
}
