package back.ing.procesos.app.automated.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080");
		
	}
	
	@Test
	public void comprobarFlujoCorrectoTransferencia() {
		final String tituloProductos = "Listado de Productos";
		//Login
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12345");
		WebElement btnSignIn = driver.findElement(By.name("signIn"));
		btnSignIn.click();
		
		//Assert
		WebElement titulo = driver.findElement(By.name("titulo"));
		Assert.assertEquals(tituloProductos, titulo.getText());
	}
}
