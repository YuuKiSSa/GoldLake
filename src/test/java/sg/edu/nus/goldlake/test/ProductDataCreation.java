package sg.edu.nus.goldlake.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import sg.edu.nus.goldlake.model.Product;
import sg.edu.nus.goldlake.repository.ProductRepository;

@SpringBootTest
public class ProductDataCreation {
    @Autowired
    private ProductRepository prepo;
    @Test
    void conTextLoad() {
//Product
        Product p11 = new Product("Express Antique", 4000, "Elegant Antique ", "Antique", "NUS");
        Product p12 = new Product("Aspire Antique", 5000, " ", "Antique", "NUS");
        Product p13 = new Product("Loyal Antique", 6000, " ", "Antique","ISS");
        Product p14 = new Product("Polo", 3000, "Delicious taste", "Sweet", "SOC");
// Save
        prepo.save(p11);
        prepo.save(p12);
        prepo.save(p13);
        prepo.save(p14);
    }
}
