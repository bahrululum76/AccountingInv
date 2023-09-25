package steps;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

public class MasterUnit {

    private WebDriver driver;
	
    public MasterUnit(Menu menu) {
        this.driver = menu.getDriver();
	}



	@When("user create unit")
	public void user_create_unit() throws InterruptedException {


		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		Thread.sleep(1000);
		String randomText = RandomStringUtils.randomAlphabetic(2);
		driver.findElement(By.id("input_name")).sendKeys("Unit "+randomText);
		driver.findElement(By.id("input_short_name")).sendKeys("U "+randomText);

		driver.findElement(By.id("button_submit")).click();

	}

	@Then("^System showed alert in page unit (.*)")
	public void system_showed_alert_in_page_unit(String message) throws InterruptedException {

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
	//////////UPDATE STATUS
	@When("user update status unit")
	public void user_update_status_unit() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/div/div/button")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}



	/////////////UPDATE
	@When("user update unit")
	public void user_update_unit() throws InterruptedException {

		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/div/ul/li[1]/a")).click();
		Thread.sleep(1000);
		String randomText = RandomStringUtils.randomAlphabetic(2);

		driver.findElement(By.id("input_name")).clear();
		driver.findElement(By.id("input_short_name")).clear();

		driver.findElement(By.id("input_name")).sendKeys("Unit "+randomText);
		driver.findElement(By.id("input_short_name")).sendKeys("U "+randomText);

		driver.findElement(By.id("button_submit")).click();
	}

	/////////DELETE
	@When("user delete unit")
	public void user_delete_unit() throws InterruptedException {

		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();

	}

}
