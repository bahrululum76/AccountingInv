package steps;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.JavascriptExecutor;


import io.cucumber.java.en.*;

public class SearchCompanyContact {

	private WebDriver driver;

	public SearchCompanyContact(Menu menu) {
		this.driver = menu.getDriver();
	}



	@When("User Create Contack Company")
	public void user_create_contack_company() throws InterruptedException {
	
		String randomNumber = RandomStringUtils.randomNumeric(3);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/div/div/div/div[2]/div/div[1]/button")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("input_control_code")).sendKeys("Kode"+randomNumber);
		driver.findElement(By.id("input_name")).sendKeys("Name A");
		driver.findElement(By.id("input_tax_number")).sendKeys("Tax"+randomNumber);
		driver.findElement(By.id("input_license_number")).sendKeys(randomNumber);

		WebElement Classh = driver.findElement(By.id("input_class"));
		Select select = new Select(Classh);
		// Pilih option pertama
		select.selectByIndex(0);

		WebElement country = driver.findElement(By.id("input_country"));
		Select select1 = new Select(country);
		// Pilih option pertama
		select1.selectByIndex(0);

		driver.findElement(By.id("input_sales_tax_id")).sendKeys("tax023");

		driver.findElement(By.id("submit_company")).click();



	}

	@Then("^System showed alert in page search (.*)")
	public void system_showed_alert_in_page_search(String message) throws InterruptedException {
	
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

	//////////update
	@When("User Update Contack Company")
	public void user_update_contack_company() throws InterruptedException {
	
		Thread.sleep(1000);
		String randomNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/div/ul/li[1]/a")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("input_control_code")).clear();
		driver.findElement(By.id("input_control_code")).sendKeys("Kode"+randomNumber);
		driver.findElement(By.id("input_name")).clear();
		driver.findElement(By.id("input_name")).sendKeys("Name A");
		driver.findElement(By.id("input_tax_number")).clear();
		driver.findElement(By.id("input_tax_number")).sendKeys("Tax"+randomNumber);
		driver.findElement(By.id("input_license_number")).clear();
		driver.findElement(By.id("input_license_number")).sendKeys(randomNumber);
		driver.findElement(By.id("input_sales_tax_id")).clear();		
		driver.findElement(By.id("input_sales_tax_id")).sendKeys("TAX45");

		Thread.sleep(1000);
		driver.findElement(By.id("submit_company")).click();

		Thread.sleep(1000);

	}


	@When("User Delete Contack Company")
	public void user_delete_contack_company() throws InterruptedException {

		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();	

	}

	////////// contact search
	@When("I enter a entity class")
	public void i_enter_a_entity_class() throws InterruptedException {
	
		WebElement country = driver.findElement(By.id("input_class"));
		Select select1 = new Select(country);

		for (int i = 1; i < 6; i++) {
			select1.selectByIndex(i);
			// Tambahkan kode lain yang ingin Anda jalankan di dalam loop di sini
			Thread.sleep(2000);
		}
	}

	@Then("I should see the result search entity class")
	public void i_should_see_the_result_search_entity_class() {
	
		driver.quit();
	}





	

	
}
