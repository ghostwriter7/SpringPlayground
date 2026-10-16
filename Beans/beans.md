# Spring Inversion of Control (IoC) container

* manage and configure POJOs

## Types of IoC containers

* bean factory (`BeanFactory`)
* application context (`ApplicationContext`)
  * `AnnotationConfigApplicationContext` - instantiate with `@Configuration` classes
  
## Bean retrieval

* `ctx.getBean(..)` - by class, name, class + name

## Component scanning

* `@ComponentScan`
  * `includeFilters` and `excludeFilters`
  * `@ComponentScan.Filter`
  * `FilterType` supports `ANNOTATION`, `ASSIGNABLE_TYPE`, `CUSTOM`, `REGEX`, `ASPECTJ`

## Autowiring

* constructor injection
* `@Autowired` - tests
  * can be placed over an arbitrary method
* setter injection

## Optional Beans

* `@Autowired(required = false)`
* `Optional<Bean>` - makes the injection lazy
* `ObjectProvider`
