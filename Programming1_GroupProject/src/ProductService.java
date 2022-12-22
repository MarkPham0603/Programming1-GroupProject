import java.util.ArrayList;
import java.util.List;

public class ProductService extends Product {

    //private array list
    private List<Product> listofProduct;

    public ProductService() {
        this.listofProduct = new ArrayList<>();
    }

    public ProductService(List<Product> listofProduct){
        this.listofProduct = listofProduct;
    }

    public List<Product> getListofProduct(){
        return listofProduct();
    }

    //function for add product
    public int addProduct(Product p){
        this.listofProduct.add(p);
        return count();
    }

    //update the array list
    public int count() {
        return this.listofProduct.size();
    }

    public Product getProduct(int index){
        if(index < 0 || index >= count()){
            return null;
        }
        return this.listofProduct.get(index);
    }

    //function to remove a product
    public boolean removeProduct(int id){
        int index = -1;
        for(int i = 0, n= count(); i<n; i++) {
            if(this.listofProduct.get(i).getId() == id){
                index = i;
                break;
            }
        }
        if (index != -1){
            this.listofProduct.remove(index);
            return true;
        }
        return false;
    }
}
