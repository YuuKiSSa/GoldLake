package sg.edu.nus.goldlake.interfacemethods;

import sg.edu.nus.goldlake.model.Product;
import java.util.List;

public interface ProductInterface {
    public void saveProduct(Product product);
    public List<Product> findProductByName(String name);
    public List<Product> findProductByCategory(String category);
    public Product findProductById(Integer id);
    public void deleteProduct(Product product);
}
