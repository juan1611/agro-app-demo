package back.ing.procesos.app.automated.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class formUsuarioTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080");
		//Login
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12345");
		WebElement btnSignIn = driver.findElement(By.name("signIn"));
		btnSignIn.click();
	}
	
	@Test
	public void comprobarFlujoCorrectoTransferencia() {
		driver.get("http://localhost:8080/usuario/usuarioListar");
		// List
		int idMayor = 1;
		
		while (true) {
			int i = 0;
			try {
				WebElement idUsuario = driver.findElement(By.name(String.valueOf(idMayor+i)));
				if (idUsuario != null) {
					if (Integer.parseInt(idUsuario.getText()) > idMayor) {
						idMayor = Integer.parseInt(idUsuario.getText());
						i++;
					} else if (Integer.parseInt(idUsuario.getText()) == idMayor) {
						idMayor = Integer.parseInt(idUsuario.getText())+1 ;
						i++;
					}
				}
			} catch (Exception e) {
				break;
			}
		}
		WebElement btnCrearProductoListar = driver.findElement(By.name("crearUsuario"));
		btnCrearProductoListar.click();

		// Form
		WebElement nombres = driver.findElement(By.id("nombres"));
		nombres.sendKeys("Nombre Auto");

		WebElement apellidos = driver.findElement(By.id("apellidos"));
		apellidos.sendKeys("Matized");

		WebElement edad = driver.findElement(By.id("edad"));
		edad.sendKeys("66");

		WebElement sexo = driver.findElement(By.id("sexo"));
		sexo.sendKeys("M");

		WebElement correoElectronico = driver.findElement(By.id("correoElectronico"));
		correoElectronico.sendKeys("auto@matized.com");

		WebElement departamento = driver.findElement(By.id("departamento"));
		departamento.sendKeys("Antioquia");

		WebElement ciudad = driver.findElement(By.id("ciudad"));
		ciudad.sendKeys("Medellin");

		WebElement direccion = driver.findElement(By.id("direccion"));
		direccion.sendKeys("Direccion Virtual");
		
		WebElement telefono = driver.findElement(By.id("telefono"));
		telefono.sendKeys("666 77 88");
		
		WebElement rol = driver.findElement(By.id("rol"));
		rol.sendKeys("Admin");

		WebElement cmdAceptar = driver.findElement(By.name("crearUsuario"));
		cmdAceptar.click();

		// Assert
		
		boolean testExitoso = false;
		try {
			WebElement idProducto = driver.findElement(By.name(String.valueOf(idMayor)));
			if (idProducto != null) {
				testExitoso = true;
			}
		} catch (Exception e) {
		}
		
		Assert.assertTrue(testExitoso);
		
	}
}
