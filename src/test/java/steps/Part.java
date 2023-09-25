package steps;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class Part {
    private WebDriver driver;
	
    public Part(Menu menu) {
        this.driver = menu.getDriver();
	}
	


	@When("user create part")
	public void user_create_part() throws InterruptedException {
	
		Thread.sleep(1000);
		String randomNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("input_number")).sendKeys("NM-"+randomNumber);
		
		driver.findElement(By.xpath("(//textarea[@id='input_description'])[1]")).sendKeys("Desc");
		
		WebElement groupElement = driver.findElement(By.id("input_group"));
		Select select = new Select(groupElement);
		select.selectByIndex(1);
		
		//Link Account
		WebElement inventElement = driver.findElement(By.id("input_inventory"));
		Select select1 = new Select(inventElement);
		select1.selectByIndex(1);
				
		WebElement incomeElement = driver.findElement(By.id("input_income"));
		Select select2 = new Select(incomeElement);
		select2.selectByIndex(1);
		
		WebElement cogsElement = driver.findElement(By.id("input_cogs"));
		Select select3 = new Select(cogsElement);
		select3.selectByIndex(1);
		
		WebElement returnElement = driver.findElement(By.id("input_return"));
		Select select4 = new Select(returnElement);
		select4.selectByIndex(1);
		
		WebElement taxElement = driver.findElement(By.id("input_tax"));
		Select select5 = new Select(taxElement);
		select5.selectByIndex(1);
		
		//Additional Information
		driver.findElement(By.id("input_markup")).sendKeys("10");		
		driver.findElement(By.id("input_last_cost")).sendKeys("10");
		driver.findElement(By.id("input_list_price")).sendKeys("10");
		driver.findElement(By.id("input_sell_price")).sendKeys("10");
		driver.findElement(By.id("input_average_cost")).sendKeys("10");

		// Input ke File
		File driverFile = new File("src/test/resources/file/image.png");
		String absolutePath = driverFile.getAbsolutePath();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(absolutePath);
		
		driver.findElement(By.id("input_on_hand")).sendKeys("1");
		driver.findElement(By.xpath("(//textarea[@id='input_description'])[2]")).sendKeys("Desc");
		
		//UNIT 
		WebElement unit1Element = driver.findElement(By.id("input_main_unit"));
		Select select6 = new Select(unit1Element);
		select6.selectByIndex(1);
		
		driver.findElement(By.id("input_part_quantity")).sendKeys("1");
		
		WebElement unit2Element = driver.findElement(By.id("input_unit_unit"));
		Select select7 = new Select(unit2Element);
		select7.selectByIndex(1);

		driver.findElement(By.id("input_quantity")).sendKeys("1");
		
		//Bar Code
		
		driver.findElement(By.id("input_make")).sendKeys("1");
		driver.findElement(By.id("input_model")).sendKeys("1");
		driver.findElement(By.id("input_code")).sendKeys("1");
		
		//submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^System showed alert on part page (.*)")
	public void system_showed_alert_on_part_page(String message) throws InterruptedException {
		
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
	
////update
	@When("user update part")
	public void user_update_part() throws InterruptedException {

		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("(//textarea[@id='input_description'])[1]")).clear();		
		driver.findElement(By.xpath("(//textarea[@id='input_description'])[1]")).sendKeys("Desc Modify");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
//////DELETE
	@When("user delete part")
	public void user_delete_part() throws InterruptedException {

		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li[2]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
		
		
	}

}
