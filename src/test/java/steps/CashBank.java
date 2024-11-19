package steps;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class CashBank {

    private WebDriver driver;

    public CashBank(Menu menu) {
        this.driver = menu.getDriver();
    }

//	@Given("user already on the cash & bank page")
//	public void user_already_on_the_cash_bank_page() throws InterruptedException {
////		WebDriver driver = this.loginHelper.getDriver();
//		Thread.sleep(1000);
//		String environment = "dev"; 
//		String baseUrl = configReader.getBaseUrl(environment);
//		driver.get(baseUrl+"cash-bank");
//		Thread.sleep(1000);
//
//	}

	@When("I ready on page add bank")
	public void i_ready_on_page_add_bank() {


		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
	}

	@When("I enter Bank Account Name")
	public void i_enter_bank_account_name() {

		String randomNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(By.id("input_bank_account_name")).sendKeys("Bank "+randomNumber);
	}

	@When("I enter Bank Description")
	public void i_enter_bank_description() {

		driver.findElement(By.id("input_bank_description")).sendKeys("Bank Description");
	}

	@When("I enter Bank Account Number")
	123
	public void i_enter_bank_account_number() {

		String randomNumber = RandomStringUtils.randomNumeric(8);
		driver.findElement(By.id("input_bank_account_number")).sendKeys(randomNumber);

	}

	@When("i selected COA")
	public void i_selected_coa() {

		WebElement coaElement = driver.findElement(By.id("input_id_coa"));
		Select select = new Select(coaElement);
		select.selectByIndex(1);
		String randomNumber = RandomStringUtils.randomNumeric(2);
		driver.findElement(By.id("input_holding")).sendKeys("Kokarmina "+ randomNumber);
		driver.findElement(By.id("button_submit")).click();
	}

	@Then("^The system should show a success alert on the cash & bank page (.*)")
	public void the_system_should_show_a_success_alert_on_the_cash_bank_page(String message ) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElements(By.id("swal2-title"));

		List<WebElement> swalElements = driver.findElements(By.id("swal2-title"));

		boolean textExists = false;
		for (WebElement element : swalElements) {
			if (element.getText().contains(message)) {
				textExists = true;
				break;
			}
		}

		if (textExists) {
			System.out.println("Teks ditemukan.");
		} else {
			throw new AssertionError("Teks tidak ditemukan");

		}

		driver.quit();
	}

	@When("User edit bank")
	public void user_edit_bank() {


		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[8]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[8]/div/ul/li[1]/a")).click();

		String randomNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(By.id("input_bank_account_name")).clear();
		driver.findElement(By.id("input_bank_account_name")).sendKeys("Bank "+randomNumber);

		String randomNumber1 = RandomStringUtils.randomNumeric(8);
		driver.findElement(By.id("input_bank_account_number")).clear();
		driver.findElement(By.id("input_bank_account_number")).sendKeys(randomNumber1);

		driver.findElement(By.id("button_submit")).click();
	}


	@When("User delete bank")
	public void user_delete_bank() throws InterruptedException {


		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[8]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[8]/div/ul/li[2]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}


}
