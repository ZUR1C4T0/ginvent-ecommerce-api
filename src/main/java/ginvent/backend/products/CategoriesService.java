package ginvent.backend.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ginvent.backend.products.entities.CategoriesRepository;
import ginvent.backend.products.entities.Category;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    Category create(Category category) {
        boolean exists = categoriesRepository.existsByTitle(category.getTitle());
        if (exists) {
            return null;
        }
        return categoriesRepository.save(category);
    }

    Iterable<Category> findAll() {
        return categoriesRepository.findAll();
    }

    Category findById(String id) {
        return categoriesRepository.findById(id).orElse(null);
    }

    Category findByTitle(String title) {
        return categoriesRepository.findByTitle(title).orElse(null);
    }

    Category update(String id, Category category) {
        Category categoryToUpdate = categoriesRepository.findById(id).orElse(null);
        if (categoryToUpdate == null) {
            return null;
        }
        if (category.getTitle() != null) {
            categoryToUpdate.setTitle(category.getTitle());
        }
        if (category.getDescription() != null) {
            categoryToUpdate.setDescription(category.getDescription());
        }
        return categoriesRepository.save(categoryToUpdate);
    }

    Category delete(String id) {
        Category categoryToDelete = categoriesRepository.findById(id).orElse(null);
        if (categoryToDelete == null) {
            return null;
        }
        categoriesRepository.delete(categoryToDelete);
        return categoryToDelete;
    }

}
