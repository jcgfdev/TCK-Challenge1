package co.com.jcgfdev.challenge1.service;

import co.com.jcgfdev.challenge1.model.Product;
import co.com.jcgfdev.challenge1.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Mono<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
}
