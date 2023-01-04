import java.io.*;
import java.util.*;

public class UserLogin {
    public static List<User> userList = new ArrayList<User>();

    public void register() throws IOException {
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
        String membership = "none";
        String phoneNumber = sc.nextLine();

        User ur = new User(username,password,fullname,email,address,membership,phoneNumber);

        userList.add(ur);
    }

    public void insertArray() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src/test.txt",true));

        for (int i = 0; i < userList.size(); i++) {
            pw.println(userList.get(i) + " ");
        }

        pw.flush();
        pw.close();
    }

    public void readtxtFile() throws Exception {
        File file = new File("src/test.txt");
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
                System.out.println(account);
            } else if (account != null) {
                System.out.println(account);
                loop = false;
            }
        } while (loop == true);
    }

    public void showArray() {
        System.out.println(userList);
    }
}