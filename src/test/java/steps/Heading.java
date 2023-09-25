package steps;

import java.util.List;
//import java.util.NoSuchElementException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.*;

public class Heading {

	
    private WebDriver driver;
	public Heading(Menu menu) {
        this.driver = menu.getDriver();
	}


	@When("^user create Heading (.*) and (.*)")
	public void user_create_heading(String name,String no) throws InterruptedException {
		
		Thread.sleep(1000);
		//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		String randomNumber = RandomStringUtils.randomNumeric(7);
		driver.findElement(By.id("input_account_number")).sendKeys(randomNumber);

		driver.findElement(By.id("input_desc")).sendKeys("Test 1");

		driver.findElement(By.id("button_submit")).click();

	}

	@When("user create Heading parent")
	public void user_create_heading_parent() {

		//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		String randomNumber = RandomStringUtils.randomNumeric(7);
		driver.findElement(By.id("input_account_number")).sendKeys(randomNumber);

		driver.findElement(By.id("input_desc")).sendKeys("Description");

		WebElement parentElement = driver.findElement(By.id("input_heading"));
		// Buat objek Select dari elemen select
		Select select = new Select(parentElement);
		// Pilih option pertama
		select.selectByIndex(0);
		driver.findElement(By.id("button_submit")).click();

	}


	@Then("^System showed alert in page Heading (.*)")
	public void system_showed_alert_in_page_heading (String message) throws InterruptedException {

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

	//////////////EDIT
	@When("user Edit Heading TypeModify")
	public void user_edit_heading_type_modify() throws InterruptedException {
	
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[1]/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/div/button"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element1);
		//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[1]/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[1]/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/div/ul/li[1]/a")).click();

		driver.findElement(By.id("input_account_number")).clear();
		String randomNumber = RandomStringUtils.randomNumeric(7);
		driver.findElement(By.id("input_desc")).clear();
		driver.findElement(By.id("input_account_number")).sendKeys(randomNumber);

		driver.findElement(By.id("input_desc")).sendKeys("Desc Modify");

		driver.findElement(By.id("button_submit")).click();

	}

	@When("user hapus data Heading")
	public void user_hapus_data_heading() {	



		WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[1]/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/div/button"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element1);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[1]/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[1]/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/div/ul/li[2]/a")).click();



		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();

	}
}
