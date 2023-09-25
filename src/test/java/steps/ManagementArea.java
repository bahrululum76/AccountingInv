package steps;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

public class ManagementArea {
    private WebDriver driver;
	
    public ManagementArea(Menu menu) {
        this.driver = menu.getDriver();
	}
	
	@When("the user enters name Area")
	public void the_user_enters_name_area() throws InterruptedException {
		Thread.sleep(1000);
		String randomNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		driver.findElement(By.id("input_name")).sendKeys("Area "+randomNumber);
		

	}

	@And("the user selects Outlet")
	public void the_user_selects_outlet() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/span/form/div[2]/div/span/div/div/div[1]/fieldset/div/div[2]/div/div/div[1]/label")).click();
		
		driver.findElement(By.id("button_submit")).click();
	}

	@Then("^System showed alert in page management-area (.*)")
	public void system_showed_alert_in_page_management_area(String message) throws InterruptedException {
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
	
	//update
	@When("User update management area")
	public void user_update_management_area() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[4]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[4]/div/ul/li[1]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.id("input_name")).sendKeys(" Modify");
		
		driver.findElement(By.id("button_submit")).click();
	}

////delete	
	@When("User delete management area")
	public void user_delete_management_area() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[4]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[4]/div/ul/li[2]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}
}
