import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductIO extends Product {
    public boolean save(List<Product> list) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("dic.dat"));
            for (int i = 0, n = list.size(); i < n; i++) {
                Product p = list.get(i);
                ps.println(p.getId() + "," + p.getName() + "," + p.getPrice());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ps.close();
        }
        return false;
    }

    public List<Product> load() {
        List<Product> list = new ArrayList<>();
        File file = new File("dic.dat");
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] attributes = line.split(",");
                    int id = Integer.parseInt(attributes[0]);
                    float price = Float.parseFloat(attributes[2]);
                    Product p = new Product(id, attributes[1], price);
                    list.add(p);
                }
                reader.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
