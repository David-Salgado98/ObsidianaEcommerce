package org.obisidiana.app.service;

import lombok.RequiredArgsConstructor;
import org.obisidiana.app.entity.Material;
import org.obisidiana.app.entity.Product;
import org.obisidiana.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> findByMaterial(Material material) {
        return productRepository.findByMaterial(material);
    }

    @Override
    public List<Product> findByMateriales(List<Long> materialesId) {
        return productRepository.findByMat(materialesId);
    }

    @Override
    public List<Product> findByTipos(List<Long> tiposId) {
        return productRepository.findByTyp(tiposId);
    }

    @Override
    public List<Product> findByTiposAndMateriales(List<Long> materialesId, List<Long> tiposId) {
        return productRepository.findByMatAndTyp(materialesId,tiposId);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
