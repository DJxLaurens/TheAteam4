package TestOnderhoudsbeurtSelenium;

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

public class KlusToevoegen {
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
	public void testKlusToevoegen() throws Exception {
		File f = new File("C:/Users/Jacky/Dropbox/Themaopdracht 4/CSVTestdata/KlusToevoegenTest.csv");
		if (f.exists() && f.isFile()) {
			String klusnaam;
			String klusomschrijving;
			String datumdag;
			String datummaand;
			String datumjaar;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner sc = new Scanner(line);
				sc.useDelimiter(";");
				while (sc.hasNext()) {
					klusnaam = sc.next();
					klusomschrijving = sc.next();
					datumdag = sc.next();
					datummaand = sc.next();
					datumjaar = sc.next();
					driver.get(baseUrl + "/ATD-Windows/index.jsp");
					driver.findElement(By.name("naam")).clear();
					driver.findElement(By.name("naam")).sendKeys("admin@ikbendeadmin.nl");
					driver.findElement(By.name("wachtwoord")).clear();
					driver.findElement(By.name("wachtwoord")).sendKeys("admin");
					Thread.sleep(2000L);
					driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
					Thread.sleep(2000L);

					WebElement mnuElement;
					mnuElement = driver.findElement(By.id("onderhoudsbeurt"));
					mnuElement.click();

					Actions builder = new Actions(driver);
					builder.moveToElement(mnuElement).perform();
					Thread.sleep(2000L);
					driver.findElement(By.id("klus toevoegen")).click();
					driver.get("http://localhost:8080/ATD-Windows/klus_toevoegen.jsp");
					Thread.sleep(2000L);

					driver.findElement(By.name("klusNaam")).clear();
					driver.findElement(By.name("klusNaam")).sendKeys(klusnaam);
					Thread.sleep(2000L);
					driver.findElement(By.name("klusOmschrijving")).clear();
					driver.findElement(By.name("klusOmschrijving")).sendKeys(klusomschrijving);
					Thread.sleep(2000L);
					driver.findElement(By.name("dag")).clear();
					driver.findElement(By.name("dag")).sendKeys(datumdag);
					Thread.sleep(2000L);
					driver.findElement(By.name("maand")).clear();
					driver.findElement(By.name("maand")).sendKeys(datummaand);
					Thread.sleep(2000L);
					driver.findElement(By.name("jaar")).clear();
					driver.findElement(By.name("jaar")).sendKeys(datumjaar);
					Thread.sleep(2000L);
					driver.findElement(By.cssSelector("div.content > form > input[type=\"submit\"]")).click();
					Thread.sleep(2000L);

					WebElement mnuElement1;
					mnuElement1 = driver.findElement(By.id("onderhoudsbeurt"));
					mnuElement1.click();
					Thread.sleep(2000L);

					Actions builder1 = new Actions(driver);
					builder1.moveToElement(mnuElement1).perform();
					Thread.sleep(2000L);
					driver.findElement(By.id("weekplanning")).click();
					driver.get("http://localhost:8080/ATD-Windows/weekplanning.jsp");
					Thread.sleep(4000L);

					driver.findElement(By.cssSelector("div.content > form > input[type=\"submit\"]")).click();
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
