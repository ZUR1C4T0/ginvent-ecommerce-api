package ginvent.backend.products.entities;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, String> {

    Optional<Product> findByTitle(String title);

    boolean existsByTitle(String title);

}
