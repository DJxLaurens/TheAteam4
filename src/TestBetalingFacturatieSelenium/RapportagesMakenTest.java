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

public class RapportagesMakenTest {
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
  public void testRapportagesMaken() throws Exception {
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
    driver.findElement(By.id("rapportages aanmaken")).click();  
    driver.get("http://localhost:8080/ATD-Windows/rapportagesaanmaken.jsp");
    Thread.sleep(4000L);
    
    driver.findElement(By.name("hoogsteBTWPerProduct")).clear();
    driver.findElement(By.name("hoogsteBTWPerProduct")).sendKeys("21");
    Thread.sleep(2000L);  
    driver.findElement(By.name("gemiddeldeBTWPerProduct")).clear();
    driver.findElement(By.name("gemiddeldeBTWPerProduct")).sendKeys("21");
    Thread.sleep(2000L);  
    driver.findElement(By.name("hoogsteBTWPerTransactie")).clear();
    driver.findElement(By.name("hoogsteBTWPerTransactie")).sendKeys("21");
    Thread.sleep(2000L);  
    driver.findElement(By.name("gemiddeldeBTWPerTransactie")).clear();
    driver.findElement(By.name("gemiddeldeBTWPerTransactie")).sendKeys("21");
    Thread.sleep(2000L);  
    driver.findElement(By.name("omzet")).clear();
    driver.findElement(By.name("omzet")).sendKeys("100000");
    Thread.sleep(2000L);  
    driver.findElement(By.name("winst")).clear();
    driver.findElement(By.name("winst")).sendKeys("70000");
    Thread.sleep(2000L);  
    driver.findElement(By.name("press")).click();
    Thread.sleep(2000L);
    driver.switchTo().alert().accept();
    Thread.sleep(4000L);
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    Thread.sleep(2000L);  
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
