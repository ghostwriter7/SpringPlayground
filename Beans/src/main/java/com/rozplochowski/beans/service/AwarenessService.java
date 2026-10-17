package com.rozplochowski.beans.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AwarenessService implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, ApplicationEventPublisherAware, ResourceLoaderAware, EnvironmentAware, ApplicationStartupAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        IO.println("Received BeanFactor " + beanFactory.getClass().getName());
    }

    @Override
    public void setBeanName(String name) {
        IO.println("Received BeanName " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        IO.println("Received ApplicationContext " + applicationContext.getClass().getName());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        IO.println("Received ApplicationEventPublisher " + applicationEventPublisher.getClass().getName());
    }

    @Override
    public void setApplicationStartup(ApplicationStartup applicationStartup) {
        IO.println("Received ApplicationStartup " + applicationStartup.getClass().getName());
    }

    @Override
    public void setEnvironment(Environment environment) {
        IO.println("Received Environment " + Arrays.toString(environment.getActiveProfiles()));
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        IO.println("Received ResourceLoader " + resourceLoader.getClass().getName());
    }
}
