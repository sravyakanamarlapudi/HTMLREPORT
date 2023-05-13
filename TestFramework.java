package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;
public class TestFramework {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SravyaKanamarlapudi\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Duration duration = Duration.ofSeconds(30);
    }

    @AfterSuite



    @Test
    public void test1() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("TestNG");
        searchBox.submit();
        WebElement testngLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("TestNG")));
        Assert.assertEquals(testngLink.getText(), "TestNG", "Title not matching");
    }

    @Test
    public void test2() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        WebElement seleniumLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("SeleniumHQ")));
        Assert.assertEquals(seleniumLink.getText(), "SeleniumHQ Browser Automation", "Title not matching");
    }

    @Test
    public void test4() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("TestNG");
        searchBox.submit();
        WebElement testngLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("TestNG")));
        Assert.assertEquals(testngLink.getText(), "TestNG Framework Tutorial: Annotations, Test", "Title not matching");
    }

    @Test
    public void test5() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        WebElement seleniumLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("SeleniumHQ")));
        Assert.assertEquals(seleniumLink.getText(), "SeleniumHQ Browser Automation", "Title not matching");
    }

    @Test
    public void test6() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("WebDriverWait");
        searchBox.submit();
        wait.withTimeout(Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("WebDriverWait")));
    }

    @Test
    public void test7() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("TestNG");
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(), "TestNG Framework Tutorial: Annotations, Test", "Title not matching");
    }

    @Test
    public void test8() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation", "Title not matching");
    }

    @Test
    public void test9() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("WebDriverWait");
        searchBox.submit();

    }

    @Test
    public void test10() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("TestNG");
        searchBox.submit();
        WebElement testngLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("TestNG")));
        Assert.assertEquals(testngLink.getText(), "TestNG Framework Tutorial: Annotations, Test", "Title not matching");
    }

    @Test
    public void test11() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Automation Testing");
        searchBox.submit();
        WebElement testngLink =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("TestNG")));
        Assert.assertEquals(
                testngLink.getText(), "Automation Framework Tutorial: Annotations, Test", "Title not matching");
    }

    @Test
    public void Test12() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Chromewebdriver");
        searchBox.submit();
    }

    @Test
    public void verifyRcptStatusPendingApprovalAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the timeout");
    }

    @Test
    public void verifyRcptStatusApprovedAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyRcptStatusDeleteAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyStatusRcptChangedApprovedAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyStatusRcptChangedUpdatedAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyStatusRcptChangedDeletedAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyContactInfoUpdateAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyAccountBalanceOverAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyAccountBalanceUnderAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifypasswordResetAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyTemplateChangeSecurityAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }

    @Test
    public void verifyCheckDepositPackageTxnAlertTest() throws Exception {
        WebElement el = driver.findElement(By.id("test"));
        assertTrue(el.isDisplayed(), "the error is about the RUNTIME ERROR");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}