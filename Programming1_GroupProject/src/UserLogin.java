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
import java.io.*;
import java.util.*;

public class UserLogin {
    public static List<User> userList = new ArrayList<User>();

    public void register() {
        //Create new user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String fullname = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your address: ");
        String address = sc.nextLine();
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Enter your phone number: ");
        String membership = "Regular";
        String phoneNumber = sc.nextLine();
        //Create new User objects by using all inputs above
        User ur = new User(username,password,fullname,email,address,membership,phoneNumber);
        //Add object to array list
        userList.add(ur);
    }

    public void insertArray() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src/customerinfo.txt",true));

        for (int i = 0; i < userList.size(); i++) {
            pw.println(userList.get(i) + " ");
        }

        pw.flush();
        pw.close();
    }

    public void readtxtFile() throws Exception {
        File file = new File("src/customerinfo.txt");
        Scanner inputfile;
        String username,password,fullname,email,address,membership,phoneNumber,line;

        if (file.exists()) {
            inputfile = new Scanner(file);
            while (inputfile.hasNext()) {
                line = inputfile.nextLine();
                StringTokenizer inReader = new StringTokenizer(line,",");
                if (inReader.countTokens() != 7) {
                    throw new Exception("Invalid Input Format");
                } else {
                    username = inReader.nextToken();
                    password = inReader.nextToken();
                    fullname = inReader.nextToken();
                    email = inReader.nextToken();
                    address = inReader.nextToken();
                    membership = inReader.nextToken();
                    phoneNumber = inReader.nextToken();
                    userList.add(new User(username,password,fullname,email,address,membership,phoneNumber));
                }
            }
        }
    }

    public void Login() {
        //Login form
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Enter username: ");
            String username = sc.nextLine();
            System.out.println("Enter password: ");
            String password = sc.nextLine();
            User account = null;
            for (User u : userList) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    account = u;
                    System.out.println("Login successful!");
                }
            }
            if (account == null) {
                loop = true;
            } else if (account != null) {
                loop = false;
            }
        } while (loop == true);
    }

    public void showArray() {
        System.out.println(userList);
    }
}
