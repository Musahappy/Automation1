package StepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class End_To_End_Stepdefinations {

    WebDriver driver;

    @Given("you are on the sourced demo website")
    public void you_are_on_the_sourced_demo_website() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

    @Then("tittle must be {string}")
    public void tittle_must_be(String title) {
        Assert.assertEquals(driver.getTitle(), title);

    }

    @When("user log in with username: {string} and Password: {string}")
    public void user_log_in_with_username_and_password(String username, String password) {

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user must see {string}")
    public void user_must_see_products(String item) {

        String text = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(item, text);
    }

    @Then("user must see error message {string}")
    public void user_must_see_error_message(String errorMessage) {
        String error = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(error, errorMessage);
    }

    @When("they add two items to cart: {string} and {string}")
    public void they_add_two_items_to_cart(String item1, String item2) {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_description']"));
        List<WebElement> add_to_cart = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getText().contains(item1)) {
                add_to_cart.get(i).click();
            } else if (items.get(i).getText().contains(item2)) {
                add_to_cart.get(i).click();
            }
        }
    }

    @When("navigate to the checkout page")
    public void navigate_to_the_checkout_page() {
       driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("items added should match items on cart: {string} and {string}")
    public void items_added_should_match_items_on_cart(String item1, String item2) {
        List <WebElement> items_on_cart = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
Assert.assertTrue(items_on_cart.getFirst().getText().contains(item1), item1);
        Assert.assertTrue(items_on_cart.getLast().getText().contains(item2), item2);
    }

    @After
    public void after() {

        driver.quit();
    }
}



