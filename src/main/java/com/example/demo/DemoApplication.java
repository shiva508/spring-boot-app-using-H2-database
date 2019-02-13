package com.example.demo;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.dependancyInjection.BinarySearchImpl;
import com.example.demo.dependancyInjection.BubbleSortAlgorithm;
import com.example.demo.dependancyInjection.QuickSortAlgorithm;
import com.example.demo.dependancyInjectionBeansAutoWiring.ServiceBeanByName;
import com.example.demo.dependancyInjectionBeansAutoWiring.ServiceBeanByType;
import com.example.demo.dependancyInjectionBeansAutoWiring.ServiceBeanNo;
import com.example.demo.dependancyInjectionCONFIGURATION.Client;
import com.example.demo.dependancyInjectionCONFIGURATION.DiConfig;
import com.example.demo.dependancyInjectionIMPORT.DiConfigImport;
import com.example.demo.dependancyInjectionRESOURCE.ProductService;
import com.example.demo.dependancyInjectionbean.OrderService;
import com.example.demo.findById.PersonFindByIdService;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Person;
import com.example.demo.model.PersonFindById;
import com.example.demo.model.Phone;
import com.example.demo.model.Professor;
import com.example.demo.model.Role;
import com.example.demo.model.RoleJdbc;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.model.UserJdbc;
import com.example.demo.model.onetomany.RoleR;
import com.example.demo.model.onetomany.UserR;
import com.example.demo.modelElementCollection.Customer;
import com.example.demo.modelElementCollection.CustomerRepository;
import com.example.demo.modelElementCollectionEmbeddable.CustomerOne;
import com.example.demo.modelElementCollectionEmbeddable.CustomerOneRepository;
import com.example.demo.modelElementCollectionEmbeddable.PhoneNumberOne;
import com.example.demo.modelElementCollectionEmbeddable.PhoneType;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.ProfessorPhoneAccessType;
import com.example.demo.repository.ProfessorPhoneAccessTypeRepository;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.repository.RoleJdbcRepository;
import com.example.demo.repository.RoleRRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserJdbcRepository;
import com.example.demo.repository.UserRRepository;
import com.example.demo.repository.UserRepository;
import com.jfilter.EnableJsonFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = { "com.example" })
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com" })
@EnableJsonFilter
public class DemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired//uyhsadfasydfyA
	ProfessorPhoneAccessTypeRepository professorPhoneAccessTypeRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	UserJdbcRepository userJdbcRepository;
	@Autowired
	RoleJdbcRepository roleJdbcRepository;
	@Autowired
	PersonFindByIdService findByIdService;
	@Autowired
	PersonRepository personRepository;
	/*
	 * @Autowired EmployeeDeptRepository employeeDeptRepository;
	 */
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	@Qualifier("OrderServiceB")
	OrderService orderService;

	@Autowired
	ServiceBeanNo serviceBeanNo;

	@Autowired
	ServiceBeanByType serviceBeanByType;

	public void setServiceBeanByType(ServiceBeanByType serviceBeanByType) {
		this.serviceBeanByType = serviceBeanByType;
	}

	@Autowired
	ServiceBeanByName serviceBeanByName;

	@Resource(name = "product2")
	ProductService productService;

	@Autowired
	DiConfig diConfig;
	@Autowired
	DiConfigImport diConfigImport;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerOneRepository customerOneRepository;
	@Autowired
	UserRRepository userRRepository;
	@Autowired
	RoleRRepository roleRRepository;

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		BinarySearchImpl searchImpl = applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl searchImpl1 = applicationContext.getBean(BinarySearchImpl.class);
		Client client = applicationContext.getBean(Client.class);
		client.showData();
		System.out.println(searchImpl);
		System.out.println(searchImpl1);
		// dependancy problem
		// for bubble
		// BinarySearchImpl searchImpl=new BinarySearchImpl(new BubbleSortAlgorithm());
		// for quick sort
		// BinarySearchImpl searchImpl=new BinarySearchImpl(new QuickSortAlgorithm());
		System.out.println(searchImpl.binarySearch(new int[] { 12, 3, 4, 8 }, 8));
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(orderService.getOrderDetails("1"));
		serviceBeanNo.setMessage("I am from Autowire.NO");
		System.out.println(serviceBeanNo.getMessage());

		serviceBeanByType.setMessage("I am from Autowire.ByType");
		System.out.println(serviceBeanByType.getMessage());

		serviceBeanByName.setMessage("I am from Autowire.ByName");
		System.out.println(serviceBeanByName.getMessage());

		System.out.println(productService.getProductDetails("408"));
		diConfig.client().showData();

		diConfigImport.clientImport().showData();

		logger.info("Student id 10001 -> {}", studentRepository.findById(10001L));
		logger.info("Inserting -> {}", studentRepository.save(new Student("John", "A1234657")));
		logger.info("Update 10003 -> {}", studentRepository.save(new Student(10001L, "Name-Updated", "New-Passport")));

		logger.info("All users -> {}", studentRepository.findAll());
		logger.info("Inserting -> {}", professorRepository.save(new Professor("Shiva", 1234657)));
		logger.info("Update 10003 -> {}", professorRepository.save(new Professor("Satish", 1234657)));
		logger.info("Inserting -> {}",
				professorPhoneAccessTypeRepository.save(new ProfessorPhoneAccessType("1234657")));
		logger.info("Update 10003 -> {}",
				professorPhoneAccessTypeRepository.save(new ProfessorPhoneAccessType("1234657")));
		Role role = new Role(7, "ADMIN");
		Set<Role> roles = new HashSet<>();

		roles.add(role);
		User user = new User("admin@gmail.com", "s", "Sam", "sam", 1, roles);
		logger.info("Update 10003 -> {}", userRepository.save(user));
		List<Phone> PhoneList = new ArrayList<>();
		Phone phone = new Phone();
		phone.setMobileType("AIRTEL");
		phone.setPhoneNumber("9032590325");
		Phone phone1 = new Phone();
		phone1.setMobileType("BSNL");
		phone1.setPhoneNumber("9493366706");
		PhoneList.add(phone);
		PhoneList.add(phone1);
		Employee emp = new Employee();
		emp.setName("SHIVA");
		emp.setSalary(1000L);
		emp.setPhones(PhoneList);
		logger.info("EMPLOYEE SAVE 10003 -> {}", employeeRepository.save(emp));
		RoleJdbc roleJdbc = new RoleJdbc();
		roleJdbc.setRole("ADMIN");
		roleJdbc.setUserId(1);
		roleJdbc.setRoleId(2);
		roleJdbc.setUserName("shiva");
		logger.info("ROLEJDBC SAVE 10003 -> {}", roleJdbcRepository.save(roleJdbc));
		UserJdbc userjdbc = new UserJdbc();
		userjdbc.setUserId(1);
		userjdbc.setPassWord("$2a$04$j3JpPUp6CTAe.kMWmdRNC.Wie58xDNPfcYz0DBJxWkucJ6ekJuiJm");
		userjdbc.setEmail("dasarishiva1@gmail.com");
		userjdbc.setEnabled(1);
		userjdbc.setUserName("shiva");
		logger.info("USERJDBC SAVE 10003 -> {}", userJdbcRepository.save(userjdbc));
		PersonFindById findById = new PersonFindById();
		findById.setId(1);
		findById.setName("Satish");
		findById.setSurname("Dasari");
		findById.setPictures("Dasari".getBytes());
		findById.setSqlDate(new Date(System.currentTimeMillis()));
		findById.setCalDate(Calendar.getInstance());
		findById.setDateToTimeMAp(Calendar.getInstance().getTime());
		findById.setDataToTimestamp(Calendar.getInstance().getTime());
		findByIdService.savePerson(findById);
		PersonFindById per = findByIdService.findPersonByID(1);
		logger.info("GET PERSION BY ID:->", per);
		Person p1 = new Person("Tom");
		p1.setName("Tom");

		Department d = new Department();
		d.setName("Developer");
		p1.setDepartment(d);
		departmentRepository.save(d);
		personRepository.save(p1);
		Person p2 = new Person("Tom");
		p2.setName("Tom");
		personRepository.save(p2);
		logger.info("ONE TO ONE SAVE 10003 -> {}", personRepository.findAll());

		Customer customer = new Customer();
		customer.setName("DASARI SHIVA");
		customer.setPhoneNumbers(Arrays.asList("9493366706", "8247621473"));
		customerRepository.save(customer);
		Customer customer1 = new Customer();
		customer1.setName("DASARI SATHISH");
		customer1.setPhoneNumbers(Arrays.asList("9493366708", "8247621478"));
		customerRepository.save(customer1);
		System.out.println(customerRepository.getAllCustomers());

		PhoneNumberOne one = new PhoneNumberOne();
		one.setPhoneNumber("9493366706");
		one.setType(PhoneType.Cell);

		PhoneNumberOne one2 = new PhoneNumberOne();
		one2.setPhoneNumber("8247621473");
		one2.setType(PhoneType.Work);
		CustomerOne customerOne = new CustomerOne();
		customerOne.setName("Shiva Dasari");
		customerOne.setPhoneNumbers(Arrays.asList(one, one2));
		customerOneRepository.save(customerOne);
		logger.info("{}", customerOneRepository.findAll());
		RoleR r=null;
		Optional<RoleR> optional =roleRRepository.findById(2);
		System.out.println(optional.isPresent());
		/*
		 * if(optional.isPresent()) { r=optional.get(); UserR userR=new UserR();
		 * userR.setLogin("dasarishiva1@gmail.com"); userR.setPassword("sniper508");
		 * userR.setRoler(r); logger.info("USERR SAVED", userRRepository.save(userR)); }
		 */
	}

}
