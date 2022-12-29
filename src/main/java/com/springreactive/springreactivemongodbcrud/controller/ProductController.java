package com.springreactive.springreactivemongodbcrud.controller;

import com.springreactive.springreactivemongodbcrud.dto.ProductDTO;
import com.springreactive.springreactivemongodbcrud.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductDTO> getAllProducts() {
        return productService.getProducts().delayElements(Duration.ofSeconds(1));
    }

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @GetMapping(value = "/{productId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ProductDTO> getAllProducts(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @PutMapping(value = "/{productId}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO, @PathVariable String productId) {
        return productService.updateProduct(productDTO, productId);
    }

    @DeleteMapping(value = "/{productId}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Void> saveProduct(@PathVariable String productId) {
        return productService.deleteProduct(productId);
    }

    @GetMapping(value = "/product-range",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductDTO> getAllProductsByPrice(@RequestParam(required = false) String min, @RequestParam(required = false) String max) {
        return productService.getProductsByPriceRange(Double.parseDouble(min),Double.parseDouble(max));
    }
}