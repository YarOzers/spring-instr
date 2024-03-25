package com.example.ddeeemmoo.service;

import com.example.ddeeemmoo.dto.ProductDto;
import com.example.ddeeemmoo.entity.Product;
import com.example.ddeeemmoo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    // Все операции с репозиторием будут проходить через ProductService
    // методы будут использоваться в Контроллере
// 1. Инициализируем репозиторий
    private final ProductRepository productRepository;


    // Пишем методы CRUD
    // 1=CREATE     Создаем объект без ID, он не нужен для передачи по API
    public Product create(ProductDto dto){
        Product product = Product.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .build();
        return productRepository.save(product);
    }
    //2= READ
    public List<Product> readAll(){
        return productRepository.findAll();
    }

    //3= UPDATE
    public Product update(Product product){
        return productRepository.save(product);
    }

    //4= DELETE  здесь мы выбираем какое поле вводит пользователь для удаления
    public void delete(Long id){
        productRepository.deleteById(id);
    }






}
