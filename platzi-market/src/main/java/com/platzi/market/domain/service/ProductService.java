package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<Product>> findByQuantityStockLessThanAndEstado(Integer quantity, boolean active) {
        return productRepository.findByQuantityStockLessThanAndEstado(quantity, active);
    }

    public Optional<List<Product>> getByCategory(Integer idCategoria) {
        return productRepository.getByCategory(idCategoria);
    }


    public List<Product> findByIdCategoryOrderByNameAsc(Integer idCategory) {
        return productRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }


    public List<Product> findByIdCategory(Integer idCategory) {
        return productRepository.findByIdCategory(idCategory);
    }


    public Optional<Product> getProduct(int idProducto){
        return productRepository.getProduct(idProducto);
    }


    public Product save(Product product){
        return productRepository.save(product) ;
    }

    public boolean delete(Integer productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
