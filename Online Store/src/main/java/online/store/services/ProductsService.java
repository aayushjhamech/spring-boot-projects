package online.store.services;

import online.store.model.Product;
import online.store.repositories.ProductCategoryRepository;
import online.store.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * Integrates with the database API and handles products and categories business logic
 */
@Service
public class ProductsService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductCategoryRepository productCategoryRepository;

    public ProductsService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<String> getAllCategories(){
        return productCategoryRepository.findAll()
            .stream()
            .map(productCategory -> productCategory.getCategory())
            .collect(Collectors.toList());
    }

    public List<Product> getDealsOfTheDay(int maxProducts){
        return productRepository.findAtMostNumberOfProducts(maxProducts);
    }

    public List<Product> getProductsByCategory(String productCategory){
        return productRepository.findByCategory(productCategory);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        return productRepository.findById(id)
            .orElseThrow(()-> new IllegalStateException(String.format("Prdouct with id %s does not exist.", id)));
    }

}
