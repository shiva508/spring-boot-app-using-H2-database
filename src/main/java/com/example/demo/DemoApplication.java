package com.example.demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;
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
import com.example.demo.model.BLOB.ProductBLOB;
import com.example.demo.model.CLOB.ProductCLOB;
import com.example.demo.model.EMBEDDEDandEMBEDDABLE.Address;
import com.example.demo.model.EMBEDDEDandEMBEDDABLE.UserName;
import com.example.demo.model.EMBEDDEDandEMBEDDABLE.UserPhoneNumber;
import com.example.demo.model.EMBEDDEDandEMBEDDABLE.UserProfile;
import com.example.demo.model.ENUM.Project;
import com.example.demo.model.ENUM.ProjectStatus;
import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Caption;
import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Gender;
import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.PersonENUM;
import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Photo;
import com.example.demo.model.EXTRALAZYCOLLECTIONS.ExtraLazyPostRepository;
import com.example.demo.model.HASHCODEANDEQUALS.Company;
import com.example.demo.model.HASHCODEANDEQUALS.EAGER.Image;
import com.example.demo.model.HASHCODEANDEQUALS.EAGER.ProductEager;
import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.ManyToMany.Tag;
import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.Post;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.PostComment;
import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToOne.PostDetails;
import com.example.demo.model.naturalid.Product;
import com.example.demo.model.onetomany.RoleR;
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
import com.example.demo.repository.BLOB.ProductBLOBRepository;
import com.example.demo.repository.CLOB.ProductCLOBRepository;
import com.example.demo.repository.HASHCODEANDEQUALS.CompanyRepository;
import com.example.demo.repository.HASHCODEANDEQUALS.EAGER.ProductEagerRepository;
import com.example.demo.repository.SYNCHRONIZEBIDIRECTIONALENTITY.PostRepository;
import com.example.demo.repository.naturalid.ProductRepository;
import com.example.demo.service.EMBEDDEDandEMBEDDABLE.UserProfileService;
import com.example.demo.service.ENUM.ProjectService;
import com.example.demo.service.ENUM.ATTRIBUTECONVERTER.PersonENUMService;
import com.example.demo.service.ENUM.ATTRIBUTECONVERTER.PhotoService;
import com.example.demo.service.HASHCODEANDEQUALS.ProductEagerService;
import com.example.demo.service.SYNCHRONIZEBIDIRECTIONALENTITY.PostService;
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
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	ProductEagerRepository productEagerRepository;
	@Autowired
	ProductEagerService productEagerService;
	@Autowired
	PostRepository postRepository;
	@Autowired
	PostService postService;
	@Autowired
	ExtraLazyPostRepository extraLazyPostRepository; 
	@Autowired
	ProjectService projectService;
	@Autowired
	UserProfileService userProfileService;
	@Autowired
	private PersonENUMService personENUMService;
	@Autowired
	private PhotoService photoService;
	@Autowired
	private ProductCLOBRepository productCLOBRepository;
	@Autowired
	private ProductBLOBRepository productBLOBRepository;
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
		Product product=new Product();
		product.setCode("A-1");
		product.setProductName("INFINITY LAP");
		productRepository.save(product);
		Product product1=new Product();
		product1.setCode("A-2");
		product1.setProductName("INFINITY LAP");
		productRepository.save(product1);
		logger.info("Product"+productRepository.getProductByCode("A-2"));
		Company company=new Company();
		company.setName("INFINITY");
		Company company1=new Company();
		company1.setName("INFINITY1");
		/*System.out.println(companyRepository.save(company));
		System.out.println(companyRepository.save(company1));*/
		ProductEager productEager=new ProductEager(); 
		Image images=new Image();
		images.setName("JPEG");
		images.setProductEager(productEager);
		Image images1=new Image();
		images1.setName("JPEG");
		images1.setProductEager(productEager);
		Set<Image> imageSet=new LinkedHashSet<Image>();
		imageSet.add(images);
		imageSet.add(images1);
		productEager.setCode("408");
		productEager.setImages(imageSet);
		productEager.setCompany(companyRepository.save(company));
		
		System.out.println(productEagerRepository.saveAndFlush(productEager));
		logger.info("++++++++++++++++++"+productEagerService.getAllProductEager());
		Post postY=new Post();
		postY.setTitle("WE WLL CHANGE THE WORLD");
		Post post=new Post();
		PostComment postComment=new PostComment();
		postComment.setPost(post);
		postComment.setReview("INFINITY SYSTEMS NEED TO IMPROVE ALOT");
		PostComment postComment1=new PostComment();
		postComment1.setPost(post);
		postComment1.setReview("INFINITY SYSTEMS YOU ARE AWESOME");
		post.setPostComments(Arrays.asList(postComment,postComment1));
		post.setTitle("UnknownUser");
		PostDetails postDetails=new PostDetails();
		postDetails.setCreatedBy("SHIVA");
		postDetails.setCreateddate(new java.util.Date());
		post.setPostDetails(postDetails);
		/* Set<Post> posts=new LinkedHashSet<Post>(); */
		Tag tag1=new Tag();
		tag1.setName("Shiva");
		/* tag1.setPosts(posts); */
		Tag tag=new Tag();
		tag.setName("SATISH");
		
		/*
		 * posts.add(post); posts.add(postY);
		 */
		/* tag.setPosts(posts); */
		/* Set<Tag> tags=new LinkedHashSet<Tag>(); */
		/*
		 * tags.add(tag); tags.add(tag1);
		 */
		/*
		 * post.setTags(tags); postY.setTags(tags);
		 */
		post.addTag(tag);
		post.addTag(tag1);
		postY.addTag(tag1);
		/*
		 * postService.savePost(post); postService.savePost(postY);
		 */
		
		  postRepository.save(post);
		  postRepository.save(postY);
		
		/*
		 * Optional<Post> optionalOut=postService.getPost(1L); Post
		 * post1=postService.getPostById(1L); if(post1 !=null) {
		 * System.out.println("==================================="); PostComment
		 * comment=post1.getPostComments().get(0); post1.removeComment(comment);
		 * System.out.println(post1.getPostComments().get(0)); }
		 * if(optionalOut.isPresent()) { Post savedPost=optionalOut.get(); PostComment
		 * comment=savedPost.getPostComments().get(0);
		 * System.out.println(":dfhshdahfas"); savedPost.removeComment(comment); }
		 */
		System.out.println(postService.getAllPosts());
		com.example.demo.model.EXTRALAZYCOLLECTIONS.Post ost;
		/*
		 * extraLazyPostRepository.save( new Post().setId(1L) .setTitle(
		 * "High-Performance Java Persistence" ) .addComment( new PostComment()
		 * .setId(1L) .setReview( "Excellent book to understand Java persistence") )
		 * .addComment( new PostComment() .setId(2L) .setReview(
		 * "The best JPA ORM book out there" ) ) .addComment( new PostComment()
		 * .setId(3L) .setReview( "Must-read for Java developers" ) ))
		 */
		
		Project project=new Project();
		project.setProjectName("DMI");
		project.setProjectStatus(ProjectStatus.INPROGRESS);
		
		System.out.println(projectService.saveProject(project));
		Address address=new Address();
		address.setAddressLine1("4-22");
		address.setAddressLine2("Church Street");
		address.setCity("Suryapet");
		address.setCountry("India");
		address.setState("Telangana");
		address.setZipCode("508408");
		
		UserName userName=new UserName();
		userName.setFirstName("Shiva");
		userName.setLastName("Dasari");
		
		UserPhoneNumber userPhoneNumber=new UserPhoneNumber();
		userPhoneNumber.setPrimaryPhoneNumber("9493366706");
		userPhoneNumber.setHomePhoneNumber("8977875546");
		UserProfile userProfile=new UserProfile();
		userProfile.setEmail("dasarishiva1@gmail.com");
		userProfile.setUserAddress(address);
		userProfile.setUserName(userName);
		userProfile.setUserPhoneNumber(userPhoneNumber);
		
		System.out.println(userProfileService.saveUserProfile(userProfile));
		
		PersonENUM personENUM=new PersonENUM();
		personENUM.setGender(Gender.MALE);
		personENUM.setName("Shiva");
		System.out.println(personENUMService.savePersonENUM(personENUM));
		Photo photo=new Photo();
		photo.setName("shiva.png");
		photo.setCaption(new Caption("Nicolae Grigorescu".toUpperCase()));
		System.out.println(photoService.savePhoto(photo));
		System.out.println(photoService.getPhotosByCaption("Nicolae Grigorescu"));
		ProductCLOB productCLOB=new ProductCLOB(); 
		productCLOB.setName("INFINITY");
		productCLOB.setWarrenty(ClobProxy.generateProxy("An embedded database is useful during the development phase of a project because of its lightweight nature. Benefits include ease of configuration, quick startup time, testability, and the ability to rapidly evolve SQL during development.\n" + 
				"\n" + 
				"12.8.2 Creating an embedded database instance using Spring XML\n" + 
				"If you want to expose an embedded database instance as a bean in a Spring ApplicationContext, use the embedded-database tag in the spring-jdbc namespace:\n" + 
				"\n" + 
				"    <jdbc:embedded-database id=\"dataSource\">\n" + 
				"        <jdbc:script location=\"classpath:schema.sql\"/>\n" + 
				"        <jdbc:script location=\"classpath:test-data.sql\"/>\n" + 
				"    </jdbc:embedded-database>\n" + 
				"The preceding configuration creates an embedded HSQL database populated with SQL from schema.sql and testdata.sql resources in the classpath. The database instance is made available to the Spring container as a bean of type javax.sql.DataSource. This bean can then be injected into data access objects as needed.\n" + 
				"\n" + 
				"12.8.3 Creating an embedded database instance programmatically\n" + 
				"The EmbeddedDatabaseBuilder class provides a fluent API for constructing an embedded database programmatically. Use this when you need to create an embedded database instance in a standalone environment, such as a data access object unit test:\n" + 
				"\n" + 
				"    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();\n" + 
				"    EmbeddedDatabase db = builder.setType(H2).addScript(\"my-schema.sql\").addScript(\"my-test-data.sql\").build();\n" + 
				"    // do stuff against the db (EmbeddedDatabase extends javax.sql.DataSource)\n" + 
				"    db.shutdown()\n" + 
				"12.8.4 Extending the embedded database support\n" + 
				"Spring JDBC embedded database support can be extended in two ways:\n" + 
				"\n" + 
				"Implement EmbeddedDatabaseConfigurer to support a new embedded database type, such as Apache Derby.\n" + 
				"\n" + 
				"Implement DataSourceFactory to support a new DataSource implementation, such as a connection pool, to manage embedded database connections.\n" + 
				"\n" + 
				"You are encouraged to contribute back extensions to the Spring community at jira.springframework.org.\n" + 
				"\n" + 
				"12.8.5 Using HSQL\n" + 
				"Spring supports HSQL 1.8.0 and above. HSQL is the default embedded database if no type is specified explicitly. To specify HSQL explicitly, set the type attribute of the embedded-database tag to HSQL. If you are using the builder API, call the setType(EmbeddedDatabaseType) method with EmbeddedDatabaseType.HSQL.\n" + 
				"\n" + 
				"12.8.6 Using H2\n" + 
				"Spring supports the H2 database as well. To enable H2, set the type attribute of the embedded-database tag to H2. If you are using the builder API, call the setType(EmbeddedDatabaseType) method with EmbeddedDatabaseType.H2.\n" + 
				"\n" + 
				"12.8.7 Using Derby\n" + 
				"Spring also supports Apache Derby 10.5 and above. To enable Derby, set the type attribute of the embedded-database tag to Derby. If using the builder API, call the setType(EmbeddedDatabaseType) method with EmbeddedDatabaseType.Derby.\n" + 
				"\n" + 
				"12.8.8 Testing data access logic with an embedded database\n" + 
				"Embedded databases provide a lightweight way to test data access code. The following is a data access unit test template that uses an embedded database:\n" + 
				"\n" + 
				"public class DataAccessUnitTestTemplate {\n" + 
				"    private EmbeddedDatabase db;\n" + 
				"    \n" + 
				"    @Before\n" + 
				"    public void setUp() {\n" + 
				"        // creates a HSQL in-memory db populated from default scripts classpath:schema.sql and classpath:test-data.sql\n" + 
				"        db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();		\n" + 
				"    }\n" + 
				"\n" + 
				"    @Test\n" + 
				"    public void testDataAccess() {\n" + 
				"        JdbcTemplate template = new JdbcTemplate(db);\n" + 
				"        template.query(...);\n" + 
				"    }\n" + 
				"\n" + 
				"    @After\n" + 
				"    public void tearDown() {\n" + 
				"        db.shutdown();\n" + 
				"    }\n" + 
				"}"));
		productCLOB.setGaurenty("An embedded database is useful during the development phase of a project because of its lightweight nature. Benefits include ease of configuration, quick startup time, testability, and the ability to rapidly evolve SQL during development.\n" + 
				"\n" + 
				"12.8.2 Creating an embedded database instance using Spring XML\n" + 
				"If you want to expose an embedded database instance as a bean in a Spring ApplicationContext, use the embedded-database tag in the spring-jdbc namespace:\n" + 
				"\n" + 
				"    <jdbc:embedded-database id=\"dataSource\">\n" + 
				"        <jdbc:script location=\"classpath:schema.sql\"/>\n" + 
				"        <jdbc:script location=\"classpath:test-data.sql\"/>\n" + 
				"    </jdbc:embedded-database>\n" + 
				"The preceding configuration creates an embedded HSQL database populated with SQL from schema.sql and testdata.sql resources in the classpath. The database instance is made available to the Spring container as a bean of type javax.sql.DataSource. This bean can then be injected into data access objects as needed.\n" + 
				"\n" + 
				"12.8.3 Creating an embedded database instance programmatically\n" + 
				"The EmbeddedDatabaseBuilder class provides a fluent API for constructing an embedded database programmatically. Use this when you need to create an embedded database instance in a standalone environment, such as a data access object unit test:\n" + 
				"\n" + 
				"    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();\n" + 
				"    EmbeddedDatabase db = builder.setType(H2).addScript(\"my-schema.sql\").addScript(\"my-test-data.sql\").build();\n" + 
				"    // do stuff against the db (EmbeddedDatabase extends javax.sql.DataSource)\n" + 
				"    db.shutdown()\n" + 
				"12.8.4 Extending the embedded database support\n" + 
				"Spring JDBC embedded database support can be extended in two ways:\n" + 
				"\n" + 
				"Implement EmbeddedDatabaseConfigurer to support a new embedded database type, such as Apache Derby.\n" + 
				"\n" + 
				"Implement DataSourceFactory to support a new DataSource implementation, such as a connection pool, to manage embedded database connections.\n" + 
				"\n" + 
				"You are encouraged to contribute back extensions to the Spring community at jira.springframework.org.\n" + 
				"\n" + 
				"12.8.5 Using HSQL\n" + 
				"Spring supports HSQL 1.8.0 and above. HSQL is the default embedded database if no type is specified explicitly. To specify HSQL explicitly, set the type attribute of the embedded-database tag to HSQL. If you are using the builder API, call the setType(EmbeddedDatabaseType) method with EmbeddedDatabaseType.HSQL.\n" + 
				"\n" + 
				"12.8.6 Using H2\n" + 
				"Spring supports the H2 database as well. To enable H2, set the type attribute of the embedded-database tag to H2. If you are using the builder API, call the setType(EmbeddedDatabaseType) method with EmbeddedDatabaseType.H2.\n" + 
				"\n" + 
				"12.8.7 Using Derby\n" + 
				"Spring also supports Apache Derby 10.5 and above. To enable Derby, set the type attribute of the embedded-database tag to Derby. If using the builder API, call the setType(EmbeddedDatabaseType) method with EmbeddedDatabaseType.Derby.\n" + 
				"\n" + 
				"12.8.8 Testing data access logic with an embedded database\n" + 
				"Embedded databases provide a lightweight way to test data access code. The following is a data access unit test template that uses an embedded database:\n" + 
				"\n" + 
				"public class DataAccessUnitTestTemplate {\n" + 
				"    private EmbeddedDatabase db;\n" + 
				"    \n" + 
				"    @Before\n" + 
				"    public void setUp() {\n" + 
				"        // creates a HSQL in-memory db populated from default scripts classpath:schema.sql and classpath:test-data.sql\n" + 
				"        db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();		\n" + 
				"    }\n" + 
				"\n" + 
				"    @Test\n" + 
				"    public void testDataAccess() {\n" + 
				"        JdbcTemplate template = new JdbcTemplate(db);\n" + 
				"        template.query(...);\n" + 
				"    }\n" + 
				"\n" + 
				"    @After\n" + 
				"    public void tearDown() {\n" + 
				"        db.shutdown();\n" + 
				"    }\n" + 
				"}");
		System.out.println(productCLOBRepository.save(productCLOB));
		System.out.println(productCLOBRepository.findAll());
		Optional<ProductCLOB> clobs=productCLOBRepository.findById(new Integer(19));
		if(clobs.isPresent()) {
			ProductCLOB productCLOB2=clobs.get();
			StringBuffer str = new StringBuffer();
		    String strng;
			Reader  reader=productCLOB2.getWarrenty().getCharacterStream();
			BufferedReader bufferedReader=new BufferedReader(reader);
			while ((strng=bufferedReader.readLine())!=null) {
				 str.append(strng);
			}      
			System.out.println(str.toString());
		}
		ProductBLOB blob=new ProductBLOB();
		byte[] image = new byte[] {1, 2, 3};
		blob.setImage(BlobProxy.generateProxy(image));
		blob.setImage1(image);
		blob.setName("RAFFELOW");
		System.out.println(productBLOBRepository.save(blob));
		Optional<ProductBLOB> productBLOB=productBLOBRepository.findById(new Integer(20));
		if (productBLOB.isPresent()) {
		ProductBLOB productBLOB2=productBLOB.get();
			InputStream stream=productBLOB2.getImage().getBinaryStream();
			BufferedInputStream bufferedReader=new BufferedInputStream(stream);
			int data;
			StringBuffer str = new StringBuffer();
			while ((bufferedReader.read())!=-1) {
				str.append(bufferedReader.read());
				
			}
			System.out.println(str);
		}
	
	}

}
