package com.nicolas.avaliacao.service;

import com.nicolas.avaliacao.dto.ProductDTO;
import com.nicolas.avaliacao.form.ProductForm;
import com.nicolas.avaliacao.form.UpdateProductForm;
import com.nicolas.avaliacao.model.Product;
import com.nicolas.avaliacao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductForm product) {
        Product newTask = product.converter();
        return productRepository.save(newTask);
    }

    public Product updateProduct(Long id, UpdateProductForm updateProductForm) {
        return productRepository.save(updateProductForm.converter(id, productRepository));
    }


    public Page<ProductDTO> getAllProduct(Pageable pagination) {
        Page<Product> product = productRepository.findAll(pagination);
        Page<ProductDTO> productDTO = ProductDTO.converter(product);
        return productDTO;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteTask(Long id) {
        productRepository.deleteById(id);
    }
}
