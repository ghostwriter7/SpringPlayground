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