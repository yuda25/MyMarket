package com.mymarket.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymarket.dto.RequestProductDto;
import com.mymarket.dto.UpdateProductDto;
import com.mymarket.helpers.exception.NotFoundException;
import com.mymarket.models.entities.Product;
import com.mymarket.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity<Product> create(@RequestBody @Valid RequestProductDto requestProductDto) {
        return new ResponseEntity<>(productService.save(requestProductDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-product")
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("get-one-product/{id}")
    public ResponseEntity<Product> findOne(@PathVariable("id") UUID id) throws NotFoundException {
        return ResponseEntity.ok(productService.findOne(id));
    }

    @PutMapping("/update-product")
    public ResponseEntity<Product> update(@RequestBody @Valid UpdateProductDto updateProductDto) throws NotFoundException {
        return new ResponseEntity<Product>(productService.update(updateProductDto), HttpStatus.OK);
    }

    @DeleteMapping("delete-product/{id}")
    public void removeOne(@PathVariable("id") UUID id) throws NotFoundException {
        productService.removeOne(id);
    }
}
