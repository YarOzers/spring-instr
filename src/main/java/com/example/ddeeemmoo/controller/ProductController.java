package com.example.ddeeemmoo.controller;

import com.example.ddeeemmoo.dto.ProductDto;
import com.example.ddeeemmoo.entity.Product;
import com.example.ddeeemmoo.service.ProductService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    // В контроллер добавляем сервис в котором реализованы меторы CRUD
    private final ProductService productService;

    // Реализуем методы запросов к сервису
    // Create
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDto dto){
        return new ResponseEntity<>(productService.create(dto), HttpStatus.OK);
    }

    // Read
    // Получаем список продуктов
    @GetMapping
    public ResponseEntity<List<Product>> readAll(){
        return new ResponseEntity<>(productService.readAll(),HttpStatus.OK);
    }

    // Update
    // Обновляем продукт
    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product){
        return new ResponseEntity<>(productService.update(product),HttpStatus.OK);
    }

    // Delete
    // Удаляем продукт по id, возвращаем статус 200
    @DeleteMapping("/{id}") // значение из {} будет подставлено в параметр помеченный @PathVariable
    public HttpStatus delete(@PathVariable Long id){
        productService.delete(id);
        return HttpStatus.OK;
    }
}
