package sg.edu.nus.goldlake.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sg.edu.nus.goldlake.interfacemethods.ProductInterface;
import sg.edu.nus.goldlake.model.Product;
import sg.edu.nus.goldlake.repository.ProductRepository;

@Service
@Transactional
public class ProductImplementation implements ProductInterface {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public List<Product> findProductByName(String name){
        return productRepository.findProductsByName(name);
    }

    @Override
    @Transactional
    public List<Product> findProductByCategory(String category){
        return productRepository.findProductsByCategory(category);
    }

    @Override
    @Transactional
    public Product findProductById(Integer id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        productRepository.delete(product);
        productRepository.flush();
    }
}
