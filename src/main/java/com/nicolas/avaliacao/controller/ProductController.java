package com.nicolas.avaliacao.controller;

import com.nicolas.avaliacao.dto.ProductDTO;
import com.nicolas.avaliacao.form.ProductForm;
import com.nicolas.avaliacao.form.UpdateProductForm;
import com.nicolas.avaliacao.model.Product;
import com.nicolas.avaliacao.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
@Description("Product")
public class ProductController {
    @Autowired

    private ProductService productService;

    @PostMapping
    @Transactional
    @Operation(description = "Created new product")
    public ResponseEntity<ProductDTO> createTask(@RequestBody @Valid ProductForm productForm) {
        Product created = productService.createProduct(productForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(created));
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(description = "Updated product")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody @Valid UpdateProductForm product) {
        Optional<Product> optional = productService.findById(id);
        if (optional.isPresent()) {
            Product updated = productService.updateProduct(id, product);
            return ResponseEntity.ok(new ProductDTO(updated));
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping
    @Operation(description = "Find Product")
    public ResponseEntity<Page<ProductDTO>> getAllProducts(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pagination) {
        return ResponseEntity.ok(productService.getAllProduct(pagination));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(description = "Delete product")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> optional = productService.findById(id);
        if (optional.isPresent()) {
            productService.deleteTask(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}