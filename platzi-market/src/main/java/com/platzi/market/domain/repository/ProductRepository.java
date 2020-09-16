package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    List<Product> findByIdCategoryOrderByNameAsc(Integer idCategory);

    List<Product> findByIdCategory(Integer idCategory);

    Optional<List<Product>> findByQuantityStockLessThanAndEstado(Integer quantity, boolean active);

    Optional<Product> getProduct(Integer idProduct);

    Product save(Product product);

    void delete(Integer idProduct);
}
