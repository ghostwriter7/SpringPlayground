# Spring Inversion of Control (IoC) container

* manage and configure POJOs

## Types of IoC containers

* bean factory (`BeanFactory`)
* application context (`ApplicationContext`)
  * `AnnotationConfigApplicationContext` - instantiate with `@Configuration` classes

## Bean retrieval

* `ctx.getBean(..)` - by class, name, class + name

## Creation

* `@Bean`
* `@Component/Service/Repository/Controller`
* Programmatic with `ctx.registerBean(...)`

## Component scanning

* `@ComponentScan`
  * `includeFilters` and `excludeFilters`
  * `@ComponentScan.Filter`
  * `FilterType` supports `ANNOTATION`, `ASSIGNABLE_TYPE`, `CUSTOM`, `REGEX`, `ASPECTJ`
* `@Import` - for importing other configuration classes, if they are not discovered automatically

## Autowiring

* constructor injection
* `@Autowired` - tests
  * can be placed over an arbitrary method
* setter injection
* `@Resource` and `@Inject` can be used (Java standards) alternatively

## Optional Beans

* `@Autowired(required = false)`
* `Optional<Bean>` - makes the injection lazy
* `ObjectProvider`

## Scope

* `@Scope`
* singleton - default
* prototype - new instance every time it is requested
* request - per HTTP request; only for web apps
* session - per HTTP session; only for web apps
* websocket - per WebSocket session
* application - similar to singleton, registered in `ServletContext`

## Loading Properties

* `@PropertySource("classpath:file.properties")`
* `@Value("${something:default}")`
* `PropertySourcesPlaceholderConfigurer` must be defined in the container
* `@Value("classpath:file.txt")` - for loading `Resource`

To access programmatically, check:
* `ClassPathResource`
* `PropertiesLoaderUtils`
* `FileSystemResource` or `URLResource` are additional options

## Lifecycle

* `@PostConstruct` and `@PreDestroy` methods
* `@Bean(destroyMethod = "destroy", initMethod = "init")`
* `@Lazy` - to delay bean initialization until it is requested
* `@DependsOn` - to control bean initialization order
* impl `Lifecycle` or `SmartLifecycle`

## Processing

* `BeanFactoryPostProcessor` - to modify the bean factory before bean creation
* implement `BeanPostProcessor`
  * allows for intercepting bean creation before initialization and after (`@PostConstruct`/`initMethod`)
* `AbstractFactoryBean<T>` - to define custom bean creation logic

## Interaction with the IoC container

* various *Aware interfaces exist, e.g. `EnvironmentAware` or `ApplicationStartupAware`