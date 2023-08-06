package com.example.youtube.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.youtube.models.Product;
import com.example.youtube.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product insert(Product obj) {
        obj = repository.save(obj);
        return obj;
    }

    public Product updateById(Product obj, Long id) {
        Product entity = repository.getReferenceById(id);
        updateData(obj, entity);
        entity = repository.save(entity);
        return entity;
    }

    private void updateData(Product obj, Product entity) {
        entity.setName(obj.getName());
        entity.setValue(obj.getValue());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
