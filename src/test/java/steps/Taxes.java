package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


import io.cucumber.java.en.*;

public class Taxes {

	private ConfigReader configReader = new ConfigReader();
    private WebDriver driver;
	
    public Taxes(Menu menu) {
        this.driver = menu.getDriver();

    }
	
	@When("user create taxes")
	public void user_create_taxes() throws InterruptedException {

		Thread.sleep(1000);
		String environment = "dev"; 
        String baseUrl = configReader.getBaseUrl(environment);
        
		String randomText = RandomStringUtils.randomAlphabetic(3);
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		driver.get(baseUrl+"system/taxes/add");
		Thread.sleep(1000);
		
		driver.findElement(By.id("input_name")).sendKeys("Test "+randomText);
		driver.findElement(By.id("input_rate")).sendKeys("10");
		
		driver.findElement(By.id("input_min_taxable")).sendKeys("10");
		
		LocalDate currentDate = LocalDate.now();
        // Format the date as per your requirement
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        
        driver.findElement(By.id("input_valid_to")).sendKeys(formattedDate);
		

		
		WebElement TaxRules = driver.findElement(By.id("input_tax_rules"));	
        // Buat objek Select
        Select dropdown = new Select(TaxRules);
        // Pilih opsi berdasarkan indeks
        dropdown.selectByIndex(0);
        
		driver.findElement(By.id("input")).sendKeys("10");
        driver.findElement(By.id("button_submit")).click();
	}

	@Then("^System showed alert in page taxes (.*)")
	public void system_showed_alert_in_page_taxes(String message) throws InterruptedException {

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
	
////////////////UPDATE
	@When("user update taxes")
	public void user_update_taxes() throws InterruptedException {

		String randomText = RandomStringUtils.randomAlphabetic(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[7]/div/ul/li[1]/a")).click();
		
		driver.findElement(By.id("input_name")).clear();
		driver.findElement(By.id("input_name")).sendKeys("Modify "+randomText);
		driver.findElement(By.id("input_rate")).clear();
		driver.findElement(By.id("input_rate")).sendKeys("10");
		driver.findElement(By.id("input_min_taxable")).clear();
		driver.findElement(By.id("input_min_taxable")).sendKeys("10");
		

        driver.findElement(By.id("button_submit")).click();
	}
	
//////DELETE
	@When("user delete taxes")
	public void user_delete_taxes() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[7]/div/ul/li[2]/a")).click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
		
	}

}
