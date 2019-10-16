package back.ing.procesos.app.automated.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class formProductoTest {

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
		driver.get("http://localhost:8080/producto/productoListar");
		// List
		int idMayor = 1;
		
		while (true) {
			int i = 0;
			try {
				WebElement idProducto = driver.findElement(By.name(String.valueOf(idMayor+i)));
				if (idProducto != null) {
					if (Integer.parseInt(idProducto.getText()) > idMayor) {
						idMayor = Integer.parseInt(idProducto.getText());
						i++;
					} else if (Integer.parseInt(idProducto.getText()) == idMayor) {
						idMayor = Integer.parseInt(idProducto.getText())+1 ;
						i++;
					}
				}
			} catch (Exception e) {
				break;
			}
		}
		WebElement btnCrearProductoListar = driver.findElement(By.name("crearProducto"));
		btnCrearProductoListar.click();

		// Form
		WebElement nombreProducto = driver.findElement(By.id("nombreProducto"));
		nombreProducto.sendKeys("Platano Automático");

		WebElement descripcion = driver.findElement(By.id("descripcion"));
		descripcion.sendKeys("Es un platano de pruebas");

		WebElement tipo = driver.findElement(By.id("tipo"));
		tipo.sendKeys("Platanus automaticus");

		WebElement precioKilo = driver.findElement(By.id("precioKilo"));
		precioKilo.sendKeys("2500");

		WebElement precioUnidad = driver.findElement(By.id("precioUnidad"));
		precioUnidad.sendKeys("500");

		WebElement ubicacion = driver.findElement(By.id("ubicacion"));
		ubicacion.sendKeys("Tests del Proyecto");

		WebElement vendedor = driver.findElement(By.id("vendedor"));
		vendedor.sendKeys("BananaSeleniumStore");

		WebElement estado = driver.findElement(By.id("estado"));
		estado.sendKeys("Virtualizado-Automatizado");

		WebElement cmdAceptar = driver.findElement(By.name("crearProducto"));
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
