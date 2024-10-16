Dependencies
The following dependencies are needed:

Cucumber Java: For defining step definitions.
Selenium WebDriver: For interacting with web pages.
TestNG: For assertions in tests.
These can be added to your pom.xml if using Maven:
<dependencies>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

Step Definitions Overview
The following scenarios are automated in this project:

Navigate to Sauce Demo website: Opens the Sauce Demo website and verifies the title.
Login with username and password: Simulates user login by inputting credentials.
Verify login success: Ensures the "Products" text is visible upon successful login.
Verify error message: Ensures the correct error message appears for invalid login.
Add items to cart: Simulates adding two specified items to the cart.
Navigate to the checkout page: Clicks on the shopping cart icon to view cart contents.
Verify items in the cart: Confirms that items added to the cart match the expected items.

