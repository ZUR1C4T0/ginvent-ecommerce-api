package ginvent.backend.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ginvent.backend.products.entities.Product;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping
    public Product create(Product product) {
        Product createdProduct = productsService.create(product);
        if (createdProduct == null) {
            return null;
        }
        return createdProduct;
    }

}
