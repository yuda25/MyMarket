package com.mymarket.services;

import java.util.List;
// import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymarket.dto.RequestProductDto;
import com.mymarket.dto.UpdateProductDto;
import com.mymarket.helpers.exception.NotFoundException;
import com.mymarket.models.entities.Product;
import com.mymarket.models.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(RequestProductDto requestProductDto) {
        Product product = Product.build(
            null, 
            requestProductDto.getName(), 
            requestProductDto.getDescription(), 
            requestProductDto.getStock(), 
            requestProductDto.getPrice(), 
            requestProductDto.getImage(), 
            null, 
            null);
        return productRepository.save(product);
    }

    public Product update(UpdateProductDto updateProductDto) throws NotFoundException {
        Product product = productRepository.findById(updateProductDto.getId())
        .orElseThrow(() -> new NotFoundException("Product with ID " + updateProductDto.getId() + " not found"));

        product.setName(updateProductDto.getName());
        product.setDescription(updateProductDto.getDescription());
        product.setStock(updateProductDto.getStock());
        product.setPrice(updateProductDto.getPrice());
        product.setImage(updateProductDto.getImage());

        return productRepository.save(product);
    }

    public Product findOne(UUID id) throws NotFoundException {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new NotFoundException("Product with ID " + id + " not found");
        }
        return product;
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void removeOne(UUID id) throws NotFoundException {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new NotFoundException("Product with ID " + id + " not found");
        }
        productRepository.delete(product);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
