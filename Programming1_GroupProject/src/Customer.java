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
import java.util.Scanner;

public class Customer {
    public void updateCustomer() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        //Using do while loop to make that user enter the right password and username
        do {
            System.out.println("Enter username: ");
            String username = sc.nextLine();
            System.out.println("Enter password: ");
            String password = sc.nextLine();
            User account = null;
            //for loop to scan through the userlist for if condition to check the inputs
            for (User u : UserLogin.userList) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    account = u;
                }
            }
            if (account == null) {
                loop = true;
                System.out.println("Wrong password or username");
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
                if (username.equals(UserLogin.userList.get(i).getUsername()) && password.equals(UserLogin.userList.get(i).getPassword())) {

                    sc.nextLine();
                    //Update customer info
                    System.out.println("Username: ");
                    String usern = sc.nextLine();
                    System.out.println("Password: ");
                    String pass = sc.nextLine();
                    System.out.println("Full name: ");
                    String name = sc.nextLine();
                    System.out.println("Email: ");
                    String mail = sc.nextLine();
                    System.out.println("Address: ");
                    String adds = sc.nextLine();
                    System.out.println("Phone number: ");
                    String phone = sc.nextLine();

                    //Add new inputs to User objects
                    UserLogin.userList.get(i).setUsername(usern);
                    UserLogin.userList.get(i).setPassword(pass);
                    UserLogin.userList.get(i).setFullname(name);
                    UserLogin.userList.get(i).setEmail(mail);
                    UserLogin.userList.get(i).setAddress(adds);
                    UserLogin.userList.get(i).setPhoneNumber(phone);
                }
            }
            System.out.println(account);
        } while (loop == true);
    }

    public void showCustomerInfo() {
        Scanner sc =new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Enter username: ");
            String username = sc.nextLine();
            System.out.println("Enter password: ");
            String password = sc.nextLine();
            User account = null;
            for (User u : UserLogin.userList) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    account = u;
                }
            }
            if (account == null) {
                loop = true;
                System.out.println("Wrong password or username");
                break;
            } else if (account != null) {
                loop = false;
            }

            System.out.println("Customer Information");
            System.out.println("Username: " + account.getUsername() +","+ "Password: " + account.getPassword() +","+ "Fullname: " + account.getFullname() +","+ "Email: " + account.getEmail() + "\n"
                    + "Address: " + account.getAddress() +","+ "Membership: " + account.getMembership() +","+ "Phonenumber: " + account.getPhoneNumber());
        } while (loop == true);
    }
}
