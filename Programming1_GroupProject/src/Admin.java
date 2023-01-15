/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Pham Minh Hoa,Chau The Kien
  ID: s3929256, s3790421
  Acknowledgement: Tom huynh https://github.com/TomHuynhSG/COSC2081-Lab-Solutions
                   My old project https://github.com/Devtorious/Programming-1
*/
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.*;

import static java.lang.String.format;

public class Admin implements Serializable {

    public void addMembership() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        //Using do while loop to make that user enter the right name and username
        do {
            System.out.println("Enter customer name: ");
            String name = sc.nextLine();
            System.out.println("Enter customer username: ");
            String username = sc.nextLine();
            User account = null;
            //for loop to scan through the userlist for if condition to check the inputs
            for (User u : UserLogin.userList) {
                if (u.getFullname().equals(name) && u.getUsername().equals(username)) {
                    account = u;
                }
            }
            if (account == null) {
                loop = true;
                System.out.println("Wrong customer name or username!!!");
                break;
            } else if (account != null) {
                loop = false;
            }
            //Print out the customer info that you have search
            System.out.println("Customer Information");
            System.out.println("Username: " + account.getUsername() +","+ "Password: " + account.getPassword() +","+ "Fullname: " + account.getFullname() +","+ "Email: " + account.getEmail() + "\n"
                    + "Address: " + account.getAddress() +","+ "Membership: " + account.getMembership() +","+ "Phonenumber: " + account.getPhoneNumber());
            //Checking for username and name by using for loop
            for (int i = 0; i < UserLogin.userList.size(); i++) {
                if (username.equals(UserLogin.userList.get(i).getUsername()) && name.equals(UserLogin.userList.get(i).getFullname())) {

                    sc.nextLine();
                    //Admin can set membership of customer
                    System.out.println("Set customer membership: ");
                    String membership = sc.nextLine();
                    //Add new membership to its object
                    UserLogin.userList.get(i).setMembership(membership);
                }
            }
            System.out.println(account);
        } while (loop == true);
    }

    public void customerShow() {
        //Showing customer list in table format
        System.out.println("Customer List");
        //Creating column
        String column = format("%s%25s%20s%15s%15s%15s", "Name", "Email", "Address", "Phone", "Membership", "Username");
        System.out.println(column);
        //Creating row
        for (User u : UserLogin.userList) {
            String row = format("%s%25s%20s%15s%15s%15s", u.getFullname(), u.getEmail(), u.getAddress(), u.getPhoneNumber(),
            u.getMembership(), u.getUsername());
            System.out.println(row);
        }
    }

    public void countMembership() {
        //Creating a list to store membership count
        int count[] = new int[4];
        //For loop to scan through the user arraylist
        for(int i = 0; i < UserLogin.userList.size(); i++) {
            //Checking if membership is Regular,Silver,Gold or Platinum
            if(UserLogin.userList.get(i).getMembership().equals("Regular")) {
                count[0]++;
            } else if (UserLogin.userList.get(i).getMembership().equals("Silver")) {
                count[1]++;
            } else if (UserLogin.userList.get(i).getMembership().equals("Gold")) {
                count[2]++;
            } else {
                count[3]++;
            }
        }
        //Printing membership list
        System.out.println("--------MEMBERSHIP LIST--------");
        System.out.println("Regular membership: " + count[0]);
        System.out.println("Silver membership: " + count[1]);
        System.out.println("Gold membership: " + count[2]);
        System.out.println("Platinum membership: " + count[3]);
    }

    public void removeCustomer() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Enter customer name: ");
            String name = sc.nextLine();
            System.out.println("Enter customer username: ");
            String username = sc.nextLine();
            User user = null;
            for (User u : UserLogin.userList) {
                if (u.getUsername().equals(username) && u.getFullname().equals(name)) {
                    user = u;
                }
            }
            if (user == null) {
                loop = true;
                System.out.println("Wrong ID or Name");
                break;
            } else if (user != null) {
                loop = false;
            }

            System.out.println("Customer Information");
            System.out.println("Username: " + user.getUsername() +","+ "Password: " + user.getPassword() +","+ "Fullname: " + user.getFullname() +","+ "Email: " + user.getEmail() + "\n"
                    + "Address: " + user.getAddress() +","+ "Membership: " + user.getMembership() +","+ "Phonenumber: " + user.getPhoneNumber());
            //Scan the product List to find the product you want to delete
            for (int i = 0; i < UserLogin.userList.size(); i++) {
                if (username.equals(UserLogin.userList.get(i).getUsername()) && name.equals(UserLogin.userList.get(i).getFullname())) {
                    //Delete the product
                    UserLogin.userList.remove(i);

                }
            }
        } while (loop == true);
    }
}

