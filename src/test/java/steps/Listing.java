package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import  org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.*;

public class Listing {
    private WebDriver driver;
	
    public Listing(Menu menu) {
        this.driver = menu.getDriver();
	}

	@When("user create listing")
	public void user_create_listing() throws InterruptedException {
	
		Thread.sleep(1000);
		String randomNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button[2]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("input_name")).sendKeys("Test "+randomNumber);
		
        WebElement selectElement1 = driver.findElement(By.id("input_area"));
        Select select11 = new Select(selectElement1);
        select11.selectByIndex(1);
        
		LocalDate currentDate = LocalDate.now();
		LocalDate nextDate = currentDate.plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedNextDate = nextDate.format(formatter);
		driver.findElement(By.id("input_expired_date")).sendKeys(formattedNextDate);
		
		WebElement Element1 = driver.findElement(By.id("item_1"));
		Select select = new Select(Element1);
		select.selectByIndex(1);
		
		WebElement Element2 = driver.findElement(By.id("item_2"));
		Select select1 = new Select(Element2);
		select1.selectByIndex(1);
		
		WebElement Element3 = driver.findElement(By.id("item_3"));
		Select select2 = new Select(Element3);
		select2.selectByIndex(1);
		
		
		driver.findElement(By.id("item_4")).sendKeys("10000");
		

		//submit
		driver.findElement(By.id("button_submit")).click();

	}

	@Then("^System showed alert in page listing (.*)")
	public void system_showed_alert_in_page_listing(String message) throws InterruptedException {
	
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
	
/////////UPDATE
	@When("user update listing")
	public void user_update_listing() throws InterruptedException {

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li[1]/a")).click();
		String randomNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(By.id("input_name")).clear();
		driver.findElement(By.id("input_name")).sendKeys("Test Modify"+randomNumber);

		//submit
		Thread.sleep(1000);
		driver.findElement(By.id("button_submit")).click();
	}

//////delete
	@When("user delete listing")
	public void user_delete_listing() throws InterruptedException {
 
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li[2]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
		
	}
}
