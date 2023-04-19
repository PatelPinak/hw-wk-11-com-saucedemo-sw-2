package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the Username Field Element
        WebElement usernameField = driver.findElement(By.id("user-name"));
        // Type the Username to username field element
        usernameField.sendKeys("standard_user");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[text()='Products']")); //xpath for locating dashboard
        String actualMessage = actualTextElement.getText();

        //Assert.assertEquals(expectedMessage, actualMessage);
        Assert.assertEquals("Not redirected to dashboard", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Find the Username Field Element
        WebElement usernameField = driver.findElement(By.id("user-name"));
        // Type the Username to username field element
        usernameField.sendKeys("standard_user");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        System.out.println("Total products displayed per page: " + productList.size());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
