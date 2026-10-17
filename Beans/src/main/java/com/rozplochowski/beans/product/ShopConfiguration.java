package com.rozplochowski.beans.product;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfiguration {

    @Bean
    public Product book() {
        return new Product("Book", 10.0);
    }

    @Bean
    public DiscountFactoryBean discountFactoryBean(Product book) {
        return new DiscountFactoryBean(0.1, book);
    }
}
