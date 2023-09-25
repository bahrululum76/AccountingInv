package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class ContactPerson {
	private ConfigReader configReader = new ConfigReader();	
	private WebDriver driver;

	public ContactPerson(Menu menu) {
		this.driver = menu.getDriver();
	}

	@When("I enter a entity class person")
	public void i_enter_a_entity_class_person() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("brcumb_person")).click();
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/div/div[1]/div/fieldset/div/div/select"));
		Select select1 = new Select(country);

		for (int i = 1; i < 6; i++) {
			select1.selectByIndex(i);
			// Tambahkan kode lain yang ingin Anda jalankan di dalam loop di sini
			Thread.sleep(2000);
		}

	}

	@Then("I should see the result search entity personal")
	public void i_should_see_the_result_search_entity_class() {

		driver.quit();
	}

	////////////person
	////////create

	@When("User Create Contack Person")
	public void user_create_contack_person() throws InterruptedException {

		String environment = "dev"; 
		String baseUrl = configReader.getBaseUrl(environment);
		Thread.sleep(1000);
		//		driver.findElement(By.id("brcumb_person")).click();
		driver.get(baseUrl+"contact/search/add?type=person");
		Thread.sleep(2000);
		//		driver.findElement(By.id("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/div/div[2]/div/div[1]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/span/form/div[1]/div/span[1]/fieldset/div/div/input")).sendKeys("123");
		WebElement Classh = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/span/form/div[1]/div/span[2]/fieldset/div/div/select"));
		Select select = new Select(Classh);
		// Pilih option pertama
		select.selectByIndex(1);
		WebElement salutation = driver.findElement(By.id("input_salutation"));
		Select select1 = new Select(salutation);
		// Pilih option pertama
		select1.selectByIndex(2);

		driver.findElement(By.id("input_given_name")).sendKeys("Ronald");
		driver.findElement(By.id("input_middle_name")).sendKeys("sant");
		driver.findElement(By.id("input_surname")).sendKeys("Ron");

		WebElement country = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/span/form/div[1]/div/span[7]/fieldset/div/div/select"));
		Select select2 = new Select(country);
		// Pilih option pertama
		select2.selectByIndex(0);

		driver.findElement(By.id("input_personal_id")).sendKeys("P0978");


		driver.findElement(By.id("input_birthdate")).sendKeys("02/02/1990");

		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/span/form/div[2]/div[2]/button[2]")).click();
		Thread.sleep(500);

	}	

	@Then("^System showed alert in page search_contact (.*)")
	public void system_showed_alert_in_page_search_contact (String message) throws InterruptedException {

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

	///////////edit
	@When("User Update Contack person")
	public void user_update_contack_person() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.id("brcumb_person")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li[1]/a")).click();





		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/span/form/div[1]/div/span[1]/fieldset/div/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/span/form/div[1]/div/span[1]/fieldset/div/div/input")).sendKeys("123");
		driver.findElement(By.id("input_given_name")).clear();
		driver.findElement(By.id("input_given_name")).sendKeys("Ronald Modify");
		driver.findElement(By.id("input_middle_name")).clear();
		driver.findElement(By.id("input_middle_name")).sendKeys("sant Modify");
		driver.findElement(By.id("input_surname")).clear();
		driver.findElement(By.id("input_surname")).sendKeys("Ron Modify");

		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/span/form/div[2]/div[2]/button[2]")).click();
		//	driver.findElement(By.id("submit_person")).click();

	}
	//////////DELETE
	@When("User Delete Contack person")
	public void user_delete_contack_person() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("brcumb_person")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/div/div/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li[2]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();

	}
}
