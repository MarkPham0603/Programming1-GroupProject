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

import static java.lang.String.format;

public class OrderService {
    //Create an ArrayList to store orderList
    public static List<OrderForm>  orderList = new ArrayList<OrderForm>();

    public void createOrder() {
        //A method to create new order
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        //Making order id using random class
        String id = ("Odr" + random.nextInt(10) + "-" + random.nextInt(1000));
        System.out.println("Enter your name: ");
        String cname = sc.nextLine();
        System.out.println("Enter your phone number: ");
        String cphone = sc.nextLine();
        System.out.println("Enter product you want to buy: ");
        String pname = sc.nextLine();
        String pcategory = "";
        double pprice = 0;
        String status = "Confirming";

        boolean loop = true;
        Product item = null;
        //Use do while loop to scan for the product name, then set the pcategory and pprice equal to Product category and price
        do {
            for (Product p : ProductService.productList) {
                if (p.getName().equals(pname)){
                    item = p;
                    loop = false;
                }
            }
            pcategory = item.getCategory();
            pprice = item.getPrice();
        } while (loop == true);
        //Create new OrderForm and add to orderlist
        OrderForm odrF = new OrderForm(id,cname,cphone,pname,pcategory,status,pprice);
        orderList.add(odrF);
    }

    public void showOrderList() {
        //Show product list
        System.out.println("Order List");
        //Make columns
        String column = format("%s%15s%15s%15s%15s%15s", "ID", "Customer", "Phone", "Product", "Price", "Status");
        System.out.println(column);
        for (OrderForm or : orderList) {
            //Making rows
            String row = format("%s%15s%15s%15s%15f%15s",or.getID(),or.getCname(),or.getCphone(),
                    or.getPname(),or.getPprice(),or.getStatus());
            System.out.println(row);
        }
    }

    public void insertOrderArray() throws IOException {
        //Save all the OrderForm objects to a text file
        PrintWriter pw = new PrintWriter(new FileWriter("src/Orders.txt",true));

        for (int i = 0; i < orderList.size(); i++) {
            pw.println(orderList.get(i) + " ");
        }

        pw.flush();
        pw.close();
    }

    public void readOrderfile() throws Exception {
        File file = new File("src/Orders.txt");
        Scanner inputfile;
        String id, cname, cphone, pname, pcategory, status, line;
        double pprice;
        //Check if the file is existed
        if (file.exists()) {
            inputfile = new Scanner(file);
            //while loop to scan
            while (inputfile.hasNext()) {
                line = inputfile.nextLine();
                //Tokenize a line of text using the deliminator ", " by utilizing the StringTokenizer object
                StringTokenizer inReader = new StringTokenizer(line,",");
                //Check to make sure that each line has precisely three tokens.
                if (inReader.countTokens() != 7) {
                    throw new Exception("Invalid Input Format");
                } else {
                    //Tokens are always 7 per line, therefore id, cname, cphone, pname, pcategory, status and pprice should be assigned in turn.
                    id = inReader.nextToken();
                    cname = inReader.nextToken();
                    cphone = inReader.nextToken();
                    pname = inReader.nextToken();
                    pcategory = inReader.nextToken();
                    status = inReader.nextToken();
                    pprice = Double.parseDouble(inReader.nextToken());

                    orderList.add(new OrderForm(id,cname,cphone,pname,pcategory,status,pprice));
                }
            }
        }
    }

    public void searchOrder() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Enter ID order: ");
            String id = sc.nextLine();
            OrderForm order= null;
            for (OrderForm o : orderList) {
                if (o.getID().equals(id)) {
                    order = o;
                }
            }
            if (order == null) {
                loop = true;
                System.out.println("Wrong ID!!!");
                break;
            } else if (order != null) {
                loop = false;
            }

            System.out.println("Order Information");
            System.out.println("ID: " + order.getID() +  " CName: " + order.getCname() + " Cphone: " + order.getCphone()
                    + " Pname: "  + order.getPname() + " Pcategory: " + order.getPcategory() + " Status: " + order.getStatus() +  " Price: " + order.getPprice());

        } while (loop == true);
    }

    public void calculateOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer name: ");
        String name = sc.nextLine();
        double total = 0;
        //Scan through the orderList to all the orderForm of input name
        for (int i = 0; i < orderList.size(); i++) {
            if (name.equals(orderList.get(i).getCname())) {
                //Calculate the total of all order
                total = total + orderList.get(i).getPprice();
            }
        }
        System.out.println("Your total price: " + total);
        double finalTotal = 0;
        double discount;
        for (int i = 0; i < UserLogin.userList.size(); i++) {
            //Checking membership to get discount
            if (UserLogin.userList.get(i).getMembership().equals("Silver") && UserLogin.userList.get(i).getFullname().equals(name)) {
                System.out.println("You have 5% discount as Silver membership");
                discount = total * 5/100;
                finalTotal = total - discount;
                System.out.println("Discount: " + discount);
            } else if (UserLogin.userList.get(i).getMembership().equals("Gold") && UserLogin.userList.get(i).getFullname().equals(name)) {
                System.out.println("You have 10% discount as Gold membership");
                discount = total * 10/100;
                finalTotal = total - discount;
                System.out.println("Discount: " + discount);
            } else if (UserLogin.userList.get(i).getMembership().equals("Platinum") && UserLogin.userList.get(i).getFullname().equals(name)) {
                System.out.println("You have 15% discount as Platinum membership");
                discount = total * 15/100;
                finalTotal = total - discount;
                System.out.println("Discount: " + discount);
            }
        }
        System.out.println("Final total price: " + finalTotal);
    }

    public void storeRevenue() {
        double day_total = 0;
        //Scan all OrderList and calculate day total
        for (int i = 0; i < orderList.size(); i++) {
            day_total = day_total + orderList.get(i).getPprice();
        }
        System.out.println("Store revenue today is: " + day_total);
    }

    public void setOrderStatus() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Enter ID order: ");
            String id = sc.nextLine();
            OrderForm order= null;
            for (OrderForm o : orderList) {
                if (o.getID().equals(id)) {
                    order = o;
                }
            }
            if (order == null) {
                loop = true;
                System.out.println("Wrong ID!!!");
                break;
            } else if (order != null) {
                loop = false;
            }

            System.out.println("Order Information");
            System.out.println("ID: " + order.getID() +  " CName: " + order.getCname() + " Cphone: " + order.getCphone()
                    + " Pname: "  + order.getPname() + " Pcategory: " + order.getPcategory() + " Status: " + order.getStatus() +  " Price: " + order.getPprice());
            //Scan the orderList
            for (int i =0; i < orderList.size(); i++) {
                if (orderList.get(i).getID().equals(id)) {
                    //Set new order Status
                    System.out.println("Set Order Status: ");
                    String status = sc.nextLine();
                    orderList.get(i).setStatus(status);
                }
            }

        } while (loop == true);
    }
}
