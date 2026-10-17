# Spring Playground

This repository contains a collection of Spring / Spring Boot projects to learn and experiment with various aspects of the framework. 

## Beans

This module covers the creation of Beans, their lifecycle, autowiring and retrieval.

* Creation of Beans with `@Bean` and stereotype annotations
* Autowiring of Beans
  * `@Primary`
  * `@Qualifier`
  * `@Fallback`
  * List/Map/Array injection
  * Optional injection with `Optional`, `@Autowired(required = false)`, `ObjectProvider`
* Retrieval of Beans
  * `ctx.getBean(String)`
  * `ctx.getBean(Class)`
* Component scanning
  * `@ComponentScan`
  * `includeFilters` & `excludeFilters`
  * `@ComponentScan.Filter`
  * `FilterType`
* Properties
  * `@PropertySource` and `PropertySourcesPlaceholderConfigurer` bean
  * `@Value("${key:default}")` - for properties
  * `Resource` and `@Value("classpath:file.txt")` for resources
  * `ClassPathResource` and `PropertiesLoaderUtils` for programmatic access
* Lifecycle
  * `@PostConstruct` and `@PreDestroy`
  * `@Bean(destroyMethod = "destroy", initMethod = "init")`
  * `@Lazy`
  * `@DependsOn`
* Processing
  * `BeanPostProcessor`
  * `AbstractFactoryBean<T>`
* Profiles
  * `@Profile`
  * `ctx.getEnvironment().setActiveProfiles(..)`
* Interaction with IoC
  * through `*Aware` interfaces
  * `Environment`, `ApplicationContext`, `ResourceLoader` injection

## Aspect Oriented Programming

