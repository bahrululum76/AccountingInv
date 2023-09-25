package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class Menu {

    private ConfigReader configReader = new ConfigReader();
    private LoginHelper loginHelper;
    private WebDriver driver;

    public Menu(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
        this.driver = this.loginHelper.getDriver();
        if (this.driver == null) {
            System.out.println("Driver is null in Menu constructor");
        }
    }

    @Given("^user is already on page (.*)")
    public void user_is_already_on_page(String menu) throws InterruptedException {
        Thread.sleep(2000);

        String environment = "dev";
        String baseUrl = configReader.getBaseUrl(environment);

        driver.get(baseUrl+menu);
    }
    public WebDriver getDriver() {
        return driver;
    }
}
