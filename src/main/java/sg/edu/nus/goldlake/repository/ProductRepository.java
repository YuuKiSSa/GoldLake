package sg.edu.nus.goldlake.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sg.edu.nus.goldlake.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("Select p from Product as p where p.name like concat('%', :k, '%')")
    public ArrayList<Product> findProductsByName(@Param("k") String k);

    @Query("Select p from Product as p where p.category like concat('%', :k, '%')")
    public ArrayList<Product> findProductsByCategory(@Param("k") String k);

}
