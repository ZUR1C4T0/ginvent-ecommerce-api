package ginvent.backend.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ginvent.backend.products.entities.Category;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    public Category create(Category category) {
        Category createdCategory = categoriesService.create(category);
        if (createdCategory == null) {
            return null;
        }
        return createdCategory;
    }

}
