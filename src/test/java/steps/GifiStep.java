package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.apache.commons.lang3.RandomStringUtils;


import io.cucumber.java.en.*;

public class GifiStep {
    private WebDriver driver;

    public GifiStep(Menu menu) {
        this.driver = menu.getDriver();
    }
	

	@When("^user create gifi (.*) and (.*)")
	public void user_create_gifi(String desc, String gifi) {

		String randomNumber = RandomStringUtils.randomNumeric(5);
		 String randomText = RandomStringUtils.randomAlphabetic(3);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[1]/button")).click();
		driver.findElement(By.id("input_gifi")).sendKeys(randomNumber);
		driver.findElement(By.id("input_desc")).sendKeys(desc+randomText);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^System showed alert in page gifi (.*)")
	public void system_showed_alert_in_page_gifi(String message) throws InterruptedException {
	
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

	@When("^user update gifi (.*)")
	public void user_update_gifi(String desc) {

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/ul/li[1]/a")).click();
		
//		driver.findElement(By.id("input_gifi")).sendKeys(randomNumber);
		driver.findElement(By.id("input_desc")).clear();
		driver.findElement(By.id("input_desc")).sendKeys(desc);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}

	@When("user delete gifi")
	public void user_delete_gifi() {

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();

	}

}
