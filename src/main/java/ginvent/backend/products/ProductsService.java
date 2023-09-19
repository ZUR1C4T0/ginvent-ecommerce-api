package ginvent.backend.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ginvent.backend.products.entities.Product;
import ginvent.backend.products.entities.ProductsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    Product create(Product product) {
        boolean exists = productsRepository.existsByTitle(product.getTitle());
        if (exists) {
            return null;
        }
        return productsRepository.save(product);
    }

    Iterable<Product> findAll() {
        return productsRepository.findAll();
    }

    Product findById(String id) {
        return productsRepository.findById(id).orElse(null);
    }

    Product findByTitle(String title) {
        return productsRepository.findByTitle(title).orElse(null);
    }

    Product update(String id, Product product) {
        Product productToUpdate = productsRepository.findById(id).orElse(null);
        if (productToUpdate == null) {
            return null;
        }
        if (product.getTitle() != null) {
            productToUpdate.setTitle(product.getTitle());
        }
        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }
        if (product.getPrice() != 0) {
            productToUpdate.setPrice(product.getPrice());
        }
        if (product.getCategory() != null) {
            productToUpdate.setCategory(product.getCategory());
        }
        if (product.getImages() != null) {
            productToUpdate.setImages(product.getImages());
        }
        if (product.getRate() != 0) {
            productToUpdate.setRate(product.getRate());
        }
        return productsRepository.save(productToUpdate);

    }

    Product delete(String id) {
        Product productToDelete = productsRepository.findById(id).orElse(null);
        if (productToDelete == null) {
            return null;
        }
        productsRepository.delete(productToDelete);
        return productToDelete;
    }

}
