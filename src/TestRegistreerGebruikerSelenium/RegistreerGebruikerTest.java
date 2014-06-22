package TestRegistreerGebruikerSelenium;

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
    driver.findElement(By.name("naam")).sendKeys("Jopie");
    Thread.sleep(2000L);
    driver.findElement(By.name("wachtwoord")).clear();
    driver.findElement(By.name("wachtwoord")).sendKeys("Jopie");
    Thread.sleep(2000L);
    driver.findElement(By.name("wachtwoord2")).clear();
    driver.findElement(By.name("wachtwoord2")).sendKeys("Jopie");
    Thread.sleep(2000L);
    driver.findElement(By.name("adres")).clear();
    driver.findElement(By.name("adres")).sendKeys("Kalverenstraat 20");
    Thread.sleep(2000L);
    driver.findElement(By.name("postcode")).clear();
    driver.findElement(By.name("postcode")).sendKeys("1234AA");
    Thread.sleep(2000L);
    driver.findElement(By.name("woonplaats")).clear();
    driver.findElement(By.name("woonplaats")).sendKeys("Amsterdam");
    Thread.sleep(2000L);
    driver.findElement(By.name("telefoonnummer")).clear();
    driver.findElement(By.name("telefoonnummer")).sendKeys("3124569870");
    Thread.sleep(2000L);
    driver.findElement(By.name("emailadres")).clear();
    driver.findElement(By.name("emailadres")).sendKeys("jopie@atd.nl");
    Thread.sleep(2000L);
    driver.findElement(By.name("emailadres2")).clear();
    driver.findElement(By.name("emailadres2")).sendKeys("jopie@atd.nl");
    Thread.sleep(2000L);
    new Select(driver.findElement(By.name("rol_id"))).selectByVisibleText("Garagemedewerker");
    Thread.sleep(4000L);
    driver.findElement(By.cssSelector("div > input[type=\"submit\"]")).click();
    Thread.sleep(4000L);
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    Thread.sleep(4000L);
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
