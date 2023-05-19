package org.obisidiana.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.obisidiana.app.entity.Material;
import org.obisidiana.app.entity.Product;
import org.obisidiana.app.entity.Type;
import org.obisidiana.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    public void whenfindbyMaterial(){
        Product product = Product.builder().name("agata").dire("http")
                .cost(Double.parseDouble("120.12"))
                .material(Material.builder().id(1L).build())
                .type(Type.builder().id(1L).build())
                .build();
        productRepository.save(product);
        List<Product> productos =productRepository.findByMaterial(product.getMaterial());
        Assertions.assertThat(productos.size()).isEqualTo(10);

    }
}
