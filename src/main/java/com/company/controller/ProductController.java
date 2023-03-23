package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import com.company.model.Product;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/products")
public class ProductController {

    WebClient client = WebClient.create("http://localhost:8080");
    @GetMapping("")
    Flux<Product> getProducts() {

        return client.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class);

    }

}
