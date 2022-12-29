package com.springreactive.springreactivemongodbcrud.service;

import com.springreactive.springreactivemongodbcrud.dto.ProductDTO;
import com.springreactive.springreactivemongodbcrud.entity.Product;
import com.springreactive.springreactivemongodbcrud.repository.ProductRepository;
import com.springreactive.springreactivemongodbcrud.util.AppUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Flux<ProductDTO> getProducts() {
        return productRepository.findAll().map(product -> AppUtils.convertProduct(product));
    }

    public Mono<ProductDTO> getProductById(String id) {
        return productRepository.findById(id).map(product -> AppUtils.convertProduct(product));
    }

    public Flux<ProductDTO> getProductsByPriceRange(Double lowPrice, Double highPrice) {
        return productRepository.findByPriceBetween(lowPrice, highPrice).map(product -> AppUtils.convertProduct(product));
    }

    public Mono<ProductDTO> saveProduct(ProductDTO productDTO) {
        Product product = AppUtils.convertProductDTO(productDTO);
        return productRepository.save(product).map(product1 -> AppUtils.convertProduct(product1));
    }

    public Mono<ProductDTO> updateProduct(ProductDTO productDTO, String id) {
        Product product = AppUtils.convertProductDTO(productDTO);
        Mono<Product> productMono = productRepository.findById(id);
        productMono = productMono.switchIfEmpty(Mono.just(null));
        if(productMono!=null) {
            product.setId(id);
            return productRepository.save(product).map(product1 ->  AppUtils.convertProduct(product1));
        }
        return null;
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}
