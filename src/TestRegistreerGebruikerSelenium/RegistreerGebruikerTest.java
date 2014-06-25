package TestRegistreerGebruikerSelenium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegistreerGebruikerTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testRegistreerGebruiker() throws Exception {
		File f = new File("C:/Users/Jacky/Dropbox/Themaopdracht 4/CSVTestdata/RegistreerGebruikerTest.csv");
		if (f.exists() && f.isFile()) {
			String naam;
			String wachtwoord;
			String wachtwoord2;
			String adres;
			String postcode;
			String woonplaats;
			String telefoonnummer;
			String emailadres;
			String emailadres2;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner sc = new Scanner(line);
				sc.useDelimiter(";");
				while (sc.hasNext()) {
					naam = sc.next();
					wachtwoord = sc.next();
					wachtwoord2 = sc.next();
					adres = sc.next();
					postcode = sc.next();
					woonplaats = sc.next();
					telefoonnummer = sc.next();
					emailadres = sc.next();
					emailadres2 = sc.next();
					driver.get(baseUrl + "/ATD-Windows/index.jsp");
					driver.findElement(By.name("naam")).clear();
					driver.findElement(By.name("naam")).sendKeys("admin@ikbendeadmin.nl");
					Thread.sleep(4000L);
					driver.findElement(By.name("wachtwoord")).clear();
					driver.findElement(By.name("wachtwoord")).sendKeys("admin");
					Thread.sleep(4000L);
					driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
					Thread.sleep(4000L);

					WebElement mnuElement;
					mnuElement = driver.findElement(By.id("registreren"));
					mnuElement.click();
					Thread.sleep(4000L);
					driver.get("http://localhost:8080/ATD-Windows/registreer.jsp");
					Thread.sleep(4000L);

					driver.get("http://localhost:8080/ATD-Windows/registreer.jsp");
					Thread.sleep(4000L);
					driver.findElement(By.name("naam")).clear();
					driver.findElement(By.name("naam")).sendKeys(naam);
					Thread.sleep(2000L);
					driver.findElement(By.name("wachtwoord")).clear();
					driver.findElement(By.name("wachtwoord")).sendKeys(wachtwoord);
					Thread.sleep(2000L);
					driver.findElement(By.name("wachtwoord2")).clear();
					driver.findElement(By.name("wachtwoord2")).sendKeys(wachtwoord2);
					Thread.sleep(2000L);
					driver.findElement(By.name("adres")).clear();
					driver.findElement(By.name("adres")).sendKeys(adres);
					Thread.sleep(2000L);
					driver.findElement(By.name("postcode")).clear();
					driver.findElement(By.name("postcode")).sendKeys(postcode);
					Thread.sleep(2000L);
					driver.findElement(By.name("woonplaats")).clear();
					driver.findElement(By.name("woonplaats")).sendKeys(woonplaats);
					Thread.sleep(2000L);
					driver.findElement(By.name("telefoonnummer")).clear();
					driver.findElement(By.name("telefoonnummer")).sendKeys(telefoonnummer);
					Thread.sleep(2000L);
					driver.findElement(By.name("emailadres")).clear();
					driver.findElement(By.name("emailadres")).sendKeys(emailadres);
					Thread.sleep(2000L);
					driver.findElement(By.name("emailadres2")).clear();
					driver.findElement(By.name("emailadres2")).sendKeys(emailadres2);
					Thread.sleep(2000L);
					new Select(driver.findElement(By.name("rol_id"))).selectByVisibleText("Garagemedewerker");
					Thread.sleep(4000L);
					driver.findElement(
					By.cssSelector("div > input[type=\"submit\"]")).click();
					Thread.sleep(4000L);
					driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
					Thread.sleep(4000L);
				}
				line = br.readLine();
				sc.close();
			}
			br.close();
		}
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

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
