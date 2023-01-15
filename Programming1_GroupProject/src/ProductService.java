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

public class ProductService {

    public static List<Product> productList = new ArrayList<Product>();

    public void createProduct() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter category: ");
        String category = sc.nextLine();
        String id = (category.substring(0, 3) + random.nextInt(1000));
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        //Create new Product objects by using all inputs above
        Product p = new Product(id, name, category, price);
        //add objects to array list
        productList.add(p);
    }

    public void productShow() {
        System.out.println("Product List");
        String column = format("%s%15s%15s%15s", "ID", "Name", "Category", "Price");
        System.out.println(column);
        for (Product p : productList) {
            String row = format("%s%15s%15s%15f", p.getId(), p.getName(), p.getCategory(), p.getPrice());
            System.out.println(row);
        }
    }

    public void insertProductArray() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src/Products.txt", true));

        for (int i = 0; i < productList.size(); i++) {
            pw.println(productList.get(i) + " ");
        }

        pw.flush();
        pw.close();
    }

    public void readProductFile() throws Exception {
        File file = new File("src/Products.txt");
        Scanner inputfile;
        String id, name, category, line;
        double price;

        if (file.exists()) {
            inputfile = new Scanner(file);
            while (inputfile.hasNext()) {
                line = inputfile.nextLine();
                StringTokenizer inReader = new StringTokenizer(line, ",");
                if (inReader.countTokens() != 4) {
                    throw new Exception("Invalid Input Format");
                } else {
                    id = inReader.nextToken();
                    name = inReader.nextToken();
                    category = inReader.nextToken();
                    price = Double.parseDouble(inReader.nextToken());

                    productList.add(new Product(id, name, category, price));
                }
            }
        }
    }

    public void productUpdate() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Enter product ID: ");
            String id = sc.nextLine();
            System.out.println("Enter product name: ");
            String name = sc.nextLine();
            Product item = null;
            for (Product p : productList) {
                if (p.getId().equals(id) && p.getName().equals(name)) {
                    item = p;
                }
            }
            if (item == null) {
                loop = true;
                System.out.println("Wrong ID or Name");
                break;
            } else if (item != null) {
                loop = false;
            }

            System.out.println("Product Information");
            System.out.println("ID: " + item.getId() + "Name: " + item.getName() + "Category: " + item.getCategory() + "Price" + item.getPrice());

            for (int i = 0; i < productList.size(); i++) {
                if (id.equals(productList.get(i).getId()) && name.equals(productList.get(i).getName())) {

                    sc.nextLine();

                    System.out.println("Name: ");
                    String pname = sc.nextLine();
                    System.out.println("Category: ");
                    String cate = sc.nextLine();
                    System.out.println("Full name: ");
                    double price = sc.nextDouble();


                    productList.get(i).setName(pname);
                    productList.get(i).setCategory(cate);
                    productList.get(i).setPrice(price);
                }
            }
        } while (loop == true);
    }

    public void removeProduct() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Enter product ID: ");
            String id = sc.nextLine();
            System.out.println("Enter product name: ");
            String name = sc.nextLine();
            Product item = null;
            for (Product p : productList) {
                if (p.getId().equals(id) && p.getName().equals(name)) {
                    item = p;
                }
            }
            if (item == null) {
                loop = true;
                System.out.println("Wrong ID or Name");
                break;
            } else if (item != null) {
                loop = false;
            }

            System.out.println("Product Information");
            System.out.println("ID: " + item.getId() + "Name: " + item.getName() + "Category: " + item.getCategory() + "Price" + item.getPrice());
            //Scan the product List to find the product you want to delete
            for (int i = 0; i < productList.size(); i++) {
                if (id.equals(productList.get(i).getId()) && name.equals(productList.get(i).getName())) {
                    //Delete the product
                    productList.remove(i);

                }
            }
            System.out.println(item);
        } while (loop == true);
    }

    public void searchCategory() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do {
            //Enter the category you want to list
            System.out.println("Enter Category: ");
            String category = sc.nextLine();
            Product item = null;
            for (Product p : productList) {
                if (p.getCategory().equals(category)) {
                    item = p;
                }
            }
            if (item == null) {
                loop = true;
                System.out.println("Wrong ID or Name");
                break;
            } else if (item != null) {
                loop = false;
            }

            System.out.println(category + " List");
            for (int i = 0; i < productList.size(); i++) {
                if (category.equals(productList.get(i).getCategory())){
                    System.out.println(productList.get(i));
                }
            }

        } while (loop == true);
    }

    public static Comparator<Product> priceAscend = new Comparator<Product>() {
        //Sorting price ascending
        @Override
        public int compare(Product p1, Product p2) {
            double price1 = p1.getPrice();
            double price2 = p2.getPrice();

            return (int) (price1 - price2);
        }
    };

    public static Comparator<Product> priceDescend = new Comparator<Product>() {
        //Sorting price descending
        @Override
        public int compare(Product p1, Product p2) {
            double price1 = p1.getPrice();
            double price2 = p2.getPrice();

            return (int) (price2 - price1);
        }
    };

    public void sortPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose: 1.Ascending   2.Descending");
        int choice = sc.nextInt();
        ArrayList<Product> productList_temp = (ArrayList<Product>) productList;
        if (choice == 1) {
            Collections.sort(productList_temp, priceAscend);
            System.out.println("Product List");
            String column = format("%s%15s%15s%15s", "ID", "Name", "Category", "Price");
            System.out.println(column);
            for (Product p : productList_temp) {
                String row = format("%s%15s%15s%15f", p.getId(), p.getName(), p.getCategory(), p.getPrice());
                System.out.println(row);
            }
        } else if (choice == 2) {
            Collections.sort(productList_temp, priceDescend);
            System.out.println("Product List");
            String column = format("%s%15s%15s%15s", "ID", "Name", "Category", "Price");
            System.out.println(column);
            for (Product p : productList_temp) {
                String row = format("%s%15s%15s%15f", p.getId(), p.getName(), p.getCategory(), p.getPrice());
                System.out.println(row);
            }
        }
    }
}
