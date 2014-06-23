package TestBetalingFacturatieSelenium;

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
  public void testPrijsAanpassen() throws Exception {
    driver.get(baseUrl + "/ATD-Windows/LogoutServlet.do");
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
    driver.findElement(By.name("literprijs")).sendKeys("1.74");
    Thread.sleep(2000L);
    driver.findElement(By.name("manurenprijs")).clear();
    driver.findElement(By.name("manurenprijs")).sendKeys("30.38");
    Thread.sleep(2000L);
    driver.findElement(By.name("dagprijs")).clear();
    driver.findElement(By.name("dagprijs")).sendKeys("4.65");
    Thread.sleep(2000L);
    driver.findElement(By.name("weekprijs")).clear();
    driver.findElement(By.name("weekprijs")).sendKeys("20.72");
    Thread.sleep(2000L);
    driver.findElement(By.name("maandprijs")).clear();
    driver.findElement(By.name("maandprijs")).sendKeys("412.35");
    Thread.sleep(2000L);
    driver.findElement(By.name("press")).click();
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
