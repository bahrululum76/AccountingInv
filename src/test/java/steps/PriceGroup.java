package steps;


import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.*;

public class PriceGroup {
    private WebDriver driver;
	
    public PriceGroup(Menu menu) {
        this.driver = menu.getDriver();
	}


	

	@When("user create price group")
	public void user_create_price_group() {

		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();

		driver.findElement(By.id("input_pricegroup")).sendKeys("Price"+randomText);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("^System showed alert in page price group (.*)")
	public void system_showed_alert_in_page_price_group_data_berhasil(String message) throws InterruptedException {
	
		Thread.sleep(500);
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

	///////Update
	@When("user update price group")
	public void user_update_price_group() throws InterruptedException {

		Thread.sleep(1000);
		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/ul/li[1]/a")).click();

		driver.findElement(By.id("input_pricegroup")).clear();
		driver.findElement(By.id("input_pricegroup")).sendKeys("Price"+randomText);

		driver.findElement(By.xpath("//button[@type='submit']")).click();



	}


	////////DELETE	
	@When("user delete price group")
	public void user_delete_group() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/ul/li[2]/a")).click();

		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}
}
