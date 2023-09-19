package ginvent.backend.products.entities;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Category, String> {

    Optional<Category> findByTitle(String title);

    boolean existsByTitle(String title);

}
