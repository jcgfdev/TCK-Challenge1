package co.com.jcgfdev.challenge1.controller;

import co.com.jcgfdev.challenge1.model.Product;
import co.com.jcgfdev.challenge1.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(ProductController.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private final WebTestClient webTestClient = WebTestClient.bindToController(productController).build();

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setPrice(100.0);

        when(productService.getProductById(1L)).thenReturn(Mono.just(product));

        webTestClient.get().uri("/products/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.name").isEqualTo("Test Product")
                .jsonPath("$.price").isEqualTo(100.0);
    }
}