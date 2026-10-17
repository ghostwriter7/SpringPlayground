# Aspect Oriented Programming

* `@EnableAspectJAutoProxy`
  * `proxyTargetClass=true` - to use CGLIB when necessary, by default it uses JDK dynamic proxy
* `@Aspect` - mark a class, add `@Component`, as it is not discoverable by default
* Advice
  * `@Before`
  * `@After`
  * `@AfterReturning`
  * `@AfterThrowing`
  * `@Around`
* Join Point
  * `JointPoint`
  * `ProceedingJoinPoint`
* Pointcut
  * `@Pointcut` - reusability
  * `execution(..)`
  * `within(..)`
  * `@annotation(..)`
  * can combine with `&&`, `||`, or `!`
* Introduction - to add new behaviour to existing classes, multiple-inheritance like
  * `@DeclareParents(..)`
  * `value` - the type to be amended
  * `defaultImpl` - the implementation class to be used
  * the return type of the method defines the type of the introduced behaviour