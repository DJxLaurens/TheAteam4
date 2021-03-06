package TestBetalingFacturatieSelenium;

import java.io.*;
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

public class PrijsAanpassenTest {
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
	public void testPrijsAanpassen() throws Exception, FileNotFoundException {
		File f = new File("C:/Users/Jacky/Dropbox/Themaopdracht 4/CSVTestdata/PrijsAanpassenTest.csv");
		if (f.exists() && f.isFile()) {
			String literprijs;
			String manurenprijs;
			String dagprijs;
			String weekprijs;
			String maandprijs;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner sc = new Scanner(line);
				sc.useDelimiter(";");
				while (sc.hasNext()) {
					literprijs = sc.next();
					manurenprijs = sc.next();
					dagprijs = sc.next();
					weekprijs = sc.next();
					maandprijs = sc.next();

					driver.get(baseUrl + "/ATD-Windows/index.jsp");
					driver.findElement(By.name("naam")).clear();
					driver.findElement(By.name("naam")).sendKeys("admin@ikbendeadmin.nl");
					driver.findElement(By.name("wachtwoord")).clear();
					driver.findElement(By.name("wachtwoord")).sendKeys("admin");
					Thread.sleep(4000L);
					driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
					Thread.sleep(4000L);

					WebElement mnuElement;
					mnuElement = driver.findElement(By.id("betalingen/facturatie"));
					mnuElement.click();

					Actions builder = new Actions(driver);
					builder.moveToElement(mnuElement).perform();
					Thread.sleep(4000L);
					driver.findElement(By.id("prijs aanpassen")).click();
					driver.get("http://localhost:8080/ATD-Windows/prijsaanpassen.jsp");
					Thread.sleep(4000L);

					driver.findElement(By.name("literprijs")).clear();
					driver.findElement(By.name("literprijs")).sendKeys(literprijs);
					Thread.sleep(2000L);
					driver.findElement(By.name("manurenprijs")).clear();
					driver.findElement(By.name("manurenprijs")).sendKeys(manurenprijs);
					Thread.sleep(2000L);
					driver.findElement(By.name("dagprijs")).clear();
					driver.findElement(By.name("dagprijs")).sendKeys(dagprijs);
					Thread.sleep(2000L);
					driver.findElement(By.name("weekprijs")).clear();
					driver.findElement(By.name("weekprijs")).sendKeys(weekprijs);
					Thread.sleep(2000L);
					driver.findElement(By.name("maandprijs")).clear();
					driver.findElement(By.name("maandprijs")).sendKeys(maandprijs);
					Thread.sleep(2000L);
					driver.findElement(By.name("press")).click();
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
