package steps;


import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.*;

public class Group {
    private WebDriver driver;
	
    public Group(Menu menu) {
        this.driver = menu.getDriver();
	}
	


	@When("user create group")
	public void user_create_group() {

		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();

		driver.findElement(By.id("input_group")).sendKeys("Group "+randomText);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@When("user create group parent")
	public void user_create_group_parent()  {

		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();

		WebElement parentElement = driver.findElement(By.id("input_parent"));
		// Buat objek Select dari elemen select
		Select select = new Select(parentElement);
		// Pilih option pertama
		select.selectByIndex(0);

		driver.findElement(By.id("input_group")).sendKeys("Group "+randomText);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^System showed alert in page group (.*)")
	public void system_showed_alert_in_page_group_data_berhasil(String message) throws InterruptedException {

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
	////////UPDATE
	@When("user update group")
	public void user_update_group() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/div/ul/li[1]/a")).click();

		String randomText = RandomStringUtils.randomAlphabetic(3);
		driver.findElement(By.id("input_group")).clear();
		driver.findElement(By.id("input_group")).sendKeys("Group Modify "+randomText);

		driver.findElement(By.xpath("//button[@type='submit']")).click();


	}

	///////DELETE
	@When("user delete group")
	public void user_delete_group() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/div/ul/li[2]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();



	}

}
