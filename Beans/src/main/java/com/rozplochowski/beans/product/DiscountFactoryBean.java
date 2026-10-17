package com.rozplochowski.beans.product;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class DiscountFactoryBean extends AbstractFactoryBean<Product> {

    private final Double discount;
    private final Product product;

    public DiscountFactoryBean(Double discount, Product product) {
        this.discount = discount;
        this.product = product;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public @Nullable Class<?> getObjectType() {
        return Product.class;
    }

    @Override
    protected @NonNull Product createInstance() {
        var discountPrice = product.price() * (1 - discount);
        return new Product(product.name(), discountPrice);
    }
}
