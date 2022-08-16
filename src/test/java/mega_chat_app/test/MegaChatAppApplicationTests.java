package mega_chat_app.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MegaChatAppApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private PageObjectLogin loginPage;
	private PageObjectSignup signupPage;
	private PageObjectChat chatPage;

	private String firstName = "Harry";
	private String lastName = "Potter";
	private String user = "Harry";
	private String password = "Nimbus";
	private String message1 = "Du bist der, der schwach ist. Du wirst nie wissen, was Liebe ist. Oder Freundschaft. Und deswegen kannst du mir nur leidtun";
	private String message2 = "Es verlangt sehr viel Tapferkeit, sich seinen Feinden in den Weg zu stellen, aber wesentlich mehr noch, sich seinen Freunden in den Weg zu stellen";
	private String message3 = "Neugier ist keine Sünde, Harry, solange man sie mit Vorsicht walten lässt";

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {

		driver.quit();

	}

	@BeforeEach
	public void beforeEach() {
	}

	@Test
	public void test1_loginFail() {
		driver.get("http://localhost:" + port + "/login");
		loginPage = new PageObjectLogin(driver);
		loginPage.login(user, password);
		assertEquals("Invalid username or password", loginPage.getErrorMessage());
	}

	@Test
	public void test2_signupSuccess() {
		driver.get("http://localhost:" + port + "/signup");
		signupPage = new PageObjectSignup(driver);
		signupPage.signup(firstName, lastName, user, password);
		assertEquals("You successfully signed up! Please continue to the login page.", signupPage.getSuccessMessage());
	}

	@Test
	public void test3_loginSuccess() {
		driver.get("http://localhost:" + port + "/login");
		loginPage = new PageObjectLogin(driver);
		loginPage.login(user, password);

		driver.get("http://localhost:" + port + "/chat");
		chatPage = new PageObjectChat(driver);
		assertEquals("Hello "+ user +", please type your messages below:", chatPage.getGreeting());

	}

	@Test
	public void test4_sendFirstMessageSuccess() {
		driver.get("http://localhost:" + port + "/chat"); // redirect to login page in case of missing login
		chatPage = new PageObjectChat(driver);
		chatPage.sendMessage(message1);
		System.out.println(chatPage.getMessageHistory());
		assertEquals(user +": " + message1, chatPage.getMessageHistory());
	}






}
