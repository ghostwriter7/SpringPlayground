package com.rozplochowski.beans;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanAuditPostProcessor implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        IO.println("Before initialization: " + beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        IO.println("After initialization (@PostConstruct/initMethod) of " + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
