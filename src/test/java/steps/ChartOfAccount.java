package steps;


import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class ChartOfAccount {

    private WebDriver driver;

    public ChartOfAccount(Menu menu) {
        this.driver = menu.getDriver();
    }
    
	

	@When("user create coa")
	public void user_create_coa() throws InterruptedException {
//		WebDriver driver = this.loginHelper.getDriver();
		
		String randomNumber = RandomStringUtils.randomNumeric(3);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		driver.findElement(By.id("button_account")).click();


		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/span/form/div[1]/div[2]/span/fieldset/div/input")).sendKeys("100.01."+randomNumber);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/span/form/div[2]/div[2]/span/fieldset/div/textarea")).sendKeys("Desc");

		WebElement heading = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/span/form/div[3]/div[2]/span/fieldset/div/select"));
		Select select = new Select(heading);
		// Pilih option pertama
		select.selectByIndex(0);

		WebElement gifi = driver.findElement(By.id("input_gifi"));
		Select select1 = new Select(gifi);
		// Pilih option pertama
		select1.selectByIndex(1);

		WebElement akun_type = driver.findElement(By.id("input_account_type"));
		Select select2 = new Select(akun_type);
		// Pilih option pertama
		select2.selectByIndex(1);

		List<WebElement> checkboxes0 = driver.findElements(By.name("input_options"));
		WebElement input_options = checkboxes0.get(0);
		JavascriptExecutor js0 = (JavascriptExecutor) driver;
		js0.executeScript("arguments[0].click();", input_options);


		WebElement summary = driver.findElement(By.id("input_summary"));
		Select select3 = new Select(summary);
		// Pilih option pertama
		select3.selectByIndex(2);
		
		
		WebElement organization = driver.findElement(By.id("input_organization"));
		Select select4 = new Select(organization);
		// Pilih option pertama
		select4.selectByIndex(2);
		

		//		List<WebElement> checkboxes = driver.findElements(By.name("input_receivables"));
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		for (WebElement checkbox : checkboxes) {
		//		    js.executeScript("arguments[0].click();", checkbox);
		//		}

		//		List<WebElement> checkboxes = driver.findElements(By.name("input_receivables"));
		//		WebElement input_receivables = checkboxes.get(1);
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		js.executeScript("arguments[0].click();", input_receivables);
		//
		//		List<WebElement> checkboxes1 = driver.findElements(By.name("input_payables"));
		//		WebElement input_payables = checkboxes1.get(2);
		//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//		js1.executeScript("arguments[0].click();", input_payables);
		//
		//		List<WebElement> checkboxes2 = driver.findElements(By.name("input_tracking"));
		//		WebElement input_tracking = checkboxes2.get(2);
		//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		//		js2.executeScript("arguments[0].click();", input_tracking);
		//
		//		List<WebElement> checkboxes3 = driver.findElements(By.name("input_tracking"));
		//		WebElement input_tracking1 = checkboxes3.get(5);
		//		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		//		js3.executeScript("arguments[0].click();", input_tracking1);
		//
		//		List<WebElement> checkboxes4 = driver.findElements(By.name("input_tracking"));
		//		WebElement input_tracking2 = checkboxes4.get(9);
		//		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//		js4.executeScript("arguments[0].click();", input_tracking2);

		driver.findElement(By.id("button_submit_COA")).click();



	}

	@Then("^System showed alert in page coa (.*)")
	public void system_showed_alert_in_page_coa (String message) throws InterruptedException {
//		WebDriver driver = this.loginHelper.getDriver();
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

	///////UPDATE
	@When("user update coa")
	public void user_update_coa() throws InterruptedException {
//		WebDriver driver = this.loginHelper.getDriver();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[9]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[9]/div/ul/li[1]/a")).click();
	
		
		//
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/span/form/div[2]/div[2]/span/fieldset/div/textarea")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div/span/form/div[2]/div[2]/span/fieldset/div/textarea")).sendKeys("Desc Modify");
		
		driver.findElement(By.id("button_submit_COA")).click();
	}

////DELETE
	@When("user delete coa")
	public void user_delete_coa() throws InterruptedException {
//		WebDriver driver = this.loginHelper.getDriver();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[9]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[9]/div/ul/li[2]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}


}
