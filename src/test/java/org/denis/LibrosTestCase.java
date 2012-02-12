package org.denis;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class LibrosTestCase extends junit.framework.TestCase{
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		// driver = new HtmlUnitDriver();
		
		baseUrl = "https://www.google.cl/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testLibrosTestCase() throws Exception {
		driver.get(baseUrl + "/?oei=uuE3T_PJONCItwfr5ZDHAg");
		driver.findElement(By.linkText("Soluciones Empresariales")).click();
		driver.findElement(By.linkText("Libros")).click();
		
		// WebElement element = driver.findElement(By.className("title"));
		// System.out.println("ELEMENT: " + element.getText());
		
		List<WebElement> elements = driver.findElements(By.className("title"));
		String text = elements.get(2).getText();
		// System.out.println("ELEMENT: " + text);
		
		assertEquals("Texto no encontrado!", text, "Potencie las ventas de sus libros!");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
