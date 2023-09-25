package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

public class ChangePassword {

	private WebDriver driver;

	public ChangePassword(Menu menu) {
		this.driver = menu.getDriver();
	}	

	@When("I enter password into old password")
	public void i_enter_password_into_old_password() {

		driver.findElement(By.id("input_old_password")).sendKeys("Kokarmina123");
	}

	@And("I enter a new password into New password")
	public void i_enter_a_new_password_into_new_password() {

		driver.findElement(By.id("input_new_password")).sendKeys("Kokarmina123");
	}

	@And("I enter a new password into Verify")
	public void i_enter_a_new_password_into_verify() {
		driver.findElement(By.id("input_confirm_password")).sendKeys("Kokarmina123");

		driver.findElement(By.id("button_submit_change_password")).click();
	}

	@Then("^I should see a message success changed password (.*)")
	public void i_should_see_a_message_success_changed_password(String message) throws InterruptedException {
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

}
