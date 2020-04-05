# 644
## Spring
- 흔히 스프링이라 부르지만 **스프링 프레임워크**라고 하는 것이 정확한 표현이다.  
- 자바(JAVA) 엔터프라이즈 개발을 위한 **오픈소스(Open Source)** 애플리케이션 프레임워크(Framework)  
- 동적인 웹 사이트를 개발하기 위한 여러 가지 서비스를 제공한다.

- 스프링 특징
	* **경량 컨테이너**(크기와 부하의 측면)로서 자바 객체를 직접 관리
		-  각각의 객체 생성, 소멸과 같은 라이프 사이클을 관리하며 스프링으로부터 필요한 객체를 얻어올 수 있다.
		- Spring 컨테이너가 관리하는 객체를 빈(bean)이라고 합니다.
		- new로 생성해서 사용하는 객체는 빈이라고하지 않습니다.
		- Spring은 빈을 생성할 때 싱글톤(singleton)객체로 생성합니다.
		
	*  **제어 역행**(**IoC** : Inversion of Control)
		- 애플리케이션의 느슨한 결합을 도모.
		- 컨트롤의 제어권이 사용자가 아니라 프레임워크에 있어 필요에 따라 스프링에서 사용자의 코드를 호출한다.
		-  프로그램의 흐름을 제어하는 코드를 작성하는데, 이 흐름의 제어를 개발자가 아닌, 다른 프포그램이 하는 것을 IoC라고 합니다.
		
	* **의존성 주입**(**DI**  : Dependency Injection)
		- 각각의 계층이나 서비스들 간에 의존성이 존재할 경우 프레임워크가 서로 연결시켜준다.
		- DI는 클래스 사이의 의존관계를 빈(Bean) 설정 정보를 바탕으로 컨테이너가 자동으로 연결해주는 것을 말합니다.
		- DI가 적용되지 않으면, 개발자가 직접 인스턴스를 생성합니다. DI가 적용되면, 약속된 annotation을 이용해서 선언만 해주면 됩니다.
		- **Spring에서 제공하는 IoC/DI 컨테이너**
			-   **BeanFactory** : IoC/DI에 대한 기본기능을 가집니다.
			-   **ApplicationContext** : BeanFactory의 모든 기능을 포함하고, BeanFactory보다 이를 쓰는 것을 권장합니다. 트랜잭션, AOP 처리등을 할 수 있습니다. BeanPostProcessor, BeanFactoryPostProcessor 등을 자동으로 등록하고, 국제화 처리, app 이벤트 등을 처리할 수 있습니다.
		
	*  **관점지향 프로그래밍**(**AOP** : Aspect-Oriented Programming)
		- 트랜잭션이나 로깅, 보안과 같이 여러 모듈에서  **공통적으로 사용하는 기능의 경우 해당 기능을 분리**하여 관리할 수 있다.
		
	* **일종의 "컨테이너"**(Container)
		* 애플리케이션 객체의 생명 주기와 설정을 포함하고 관리한다는 점에서 일종의 **"컨테이너"**(Container)라고 할 수 있다. 
		 
	* **트랜잭션 관리** 
		- 추상화된 트랜잭션 관리를 지원하며 설정파일(xml, java, property 등)을 이용한 선언적인 방식 및 프로그래밍을 통한 방식을 모두 지원한다.

> **DI 가 업는 경우**
```
@RestController
public class MyController {
    private MyService service = new MyService();
    
    @RequestMapping("/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }
}
```
> **DI 있는 경우**
```
@Component
public class MyService {
    public String retrieveWelcomeMessage(){
       return "Welcome to InnovationM";
    }
}
@RestController
public class MyController {
    @Autowired
    private MyService service;

    @RequestMapping("/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }
}
```
	스프링 프레임워크는 MyService에 대한 bean을 생성하고 MyController에 있는 service 변수에 주입해줍니다.
> **@Component**  : 스프링의 BeanFactory라는 팩토리 패턴의 구현체에서 bean이라는 스프링프레임워크가 관리하는 객체가 있는데 해당 클래스를 그러한 bean 객체로 두어 스프링 관리하에 두겠다는 어노테이션.

> **@Autowired**  : 스프링 프레임워크에서 관리하는 Bean 객체와 같은 타입의 객체를 찾아서 자동으로 주입해주는 것. 해당 객체를 Bean으로 등록하지 않으면 주입해줄 수 없다.

>출처: 
[Spring 특징](https://goddaehee.tistory.com/1dd56) 
[Spring 구현](https://wordbe.tistory.com/entry/Spring-Java-Spring-%EA%B8%B0%EB%B3%B8)
[AOP](https://goddaehee.tistory.com/154) 
  
## Spring Boot
- Spring Framework 문제점
	- Spring으로 프로그램을 구현할 때 Transaction Manager, Hibernate Datasource, Entity Manager, Session Factory와 같은 설정을 하는데에 어려움이 많다.
	- 스프링 프레임워크의 가장 대표적인 단점은 모든 설정을 xml 로 사용 하고 applicationContext.xml 이외에 mybatis, log4j , 프로필별 xml 등 설정을 위한 작업이 많다.
	
- Spring Boot 의 특징
	- 내장 된 WAS
	- 부트는 기본이 jar 이다. java 개발자라면 아주 익숙한 자바 실행 파일이다. 단순한 데몬형태로 실행이 가능하기때문에 딱히 was 사용법과 명령어를 알필요가 없다.
	- 스프링부트는 자동설정(AutoConfiguration)을 이용하였고 어플리케이션 개발에 필요한 모든 내부 디펜던시를 관리합니다.  개발자가 해야하는건 단지 어플리케이션을 실행할 뿐입니다. 
	- 스프링의 jar파일이 클래스 패스에 있는 경우 Spring Boot는 Dispatcher Servlet으로 자동 구성합니다. 
	- 마찬가지로 만약 Hibernate의 jar파일이 클래스 패스내에 존재한다면 이를 datasource로 자동설정하게 됩니다. 스프링부트는 미리설정된 스타터 프로젝트를 제공합니다.
	- 사용하려는 jar, 사용할 jar 버전, 함께 연결하는 방법이 필요합니다. Spring 에서는 이러한 jar들의 서로 호환되는 버전들을 따로 선택을 해주어야 했습니다. 이런 복잡도를 줄이기 위해서 스프링 부트는 SpringBoot Starter라고 불리는 것을 도입했습니다.
- SpringBoot Starter
	* spring-boot-starter-web-services : SOAP 웹 서비스
	* spring-boot-starter-web : Web, RESTful 응용프로그램
	* spring-boot-starter-test : Unit testing, Integration Testing
	* spring-boot-starter-jdbc : 기본적인 JDBC
	* spring-boot-starter-hateoas : HATEOAS 기능을 서비스에 추가
	* spring-boot-starter-security : 스프링 시큐리티를 이용한 인증과 권한
	* spring-boot-starter-data-jpa : Spring Data JPA with Hibernate	
	* spring-boot-starter-cache : 스프링 프레임워크에 캐싱 지원 가능
	* spring-boot-starter-data-rest : Spring Data REST를 사용하여 간단한 REST 서비스 노출
>출처:
[Spring과 Spring boot 차이](https://sas-study.tistory.com/274)
[Spring boot 장정](https://ellune.tistory.com/38)

#### 제작
[stackedit](https://stackedit.io/app#)
