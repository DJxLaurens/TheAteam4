package TestVoorraadbeheerSelenium;

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

public class BrandstofBestellenTest {
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
	public void testBrandstofBestellen() throws Exception {
		File f = new File("C:/Users/Jacky/Dropbox/Themaopdracht 4/CSVTestdata/BrandstofBestellenTest.csv");
		if (f.exists() && f.isFile()) {
			String voorraadnaam;
			String minimalevoorraad;
			String voorraad;
			String producten;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner sc = new Scanner(line);
				sc.useDelimiter(";");
				while (sc.hasNext()) {
					voorraadnaam = sc.next();
					minimalevoorraad = sc.next();
					voorraad = sc.next();
					producten = sc.next();
					driver.get(baseUrl + "/ATD-Windows/index.jsp");
					driver.findElement(By.name("naam")).clear();
					driver.findElement(By.name("naam")).sendKeys("admin@ikbendeadmin.nl");
					Thread.sleep(2000L);
					driver.findElement(By.name("wachtwoord")).clear();
					driver.findElement(By.name("wachtwoord")).sendKeys("admin");
					Thread.sleep(2000L);
					driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
					Thread.sleep(4000L);

					WebElement mnuElement;
					mnuElement = driver.findElement(By.id("voorraadbeheer"));
					mnuElement.click();

					Actions builder = new Actions(driver);
					builder.moveToElement(mnuElement).perform();
					Thread.sleep(4000L);
					driver.findElement(By.id("brandstof bestellen")).click();
					driver.get("http://localhost:8080/ATD-Windows/brandstof_bestellen.jsp");
					Thread.sleep(4000L);

					driver.findElement(By.linkText("Voeg een brandstof toe")).click();
					Thread.sleep(4000L);
					driver.findElement(By.name("voorraadNaam")).clear();
					driver.findElement(By.name("voorraadNaam")).sendKeys(voorraadnaam);
					Thread.sleep(2000L);
					driver.findElement(By.name("voorraadMin")).clear();
					driver.findElement(By.name("voorraadMin")).sendKeys(minimalevoorraad);
					Thread.sleep(2000L);
					driver.findElement(By.name("voorraad")).clear();
					driver.findElement(By.name("voorraad")).sendKeys(voorraad);
					Thread.sleep(2000L);
					driver.findElement(
					By.cssSelector("div.content > form > input[type=\"submit\"]")).click();
					Thread.sleep(4000L);
					driver.findElement(By.name("prod_14")).clear();
					driver.findElement(By.name("prod_14")).sendKeys(producten);
					Thread.sleep(2000L);
					driver.findElement(By.name("bestel")).click();
					Thread.sleep(4000L);
					driver.findElement(By.xpath("//tr[@id='headRow']/td[8]/a/img")).click();
					Thread.sleep(4000L);
					driver.findElement(
					By.cssSelector("div.content > form > input[type=\"submit\"]")).click();
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
