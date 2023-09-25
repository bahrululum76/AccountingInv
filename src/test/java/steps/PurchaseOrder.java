package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
//import java.util.NoSuchElementException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class PurchaseOrder {
	
    private WebDriver driver;

    public PurchaseOrder(Menu menu) {
        this.driver = menu.getDriver();
    }
	
	@When("I enter the Supplier")
	public void i_enter_the_supplier() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/button")).click();
		Thread.sleep(1000);
		WebElement suplier = driver.findElement(By.id("input_supplier"));
		Select select1 = new Select(suplier);
        select1.selectByIndex(1);
        

	}

	@And("I select {string} as the currency")
	public void i_select_as_the_currency(String string) {
        
		WebElement idr = driver.findElement(By.id("input_currency"));
		Select select = new Select(idr);
        select.selectByIndex(1);
	}

	@And("I select {string} as the Order Date")
	public void i_select_as_the_order_date(String string) {
		String randomNumber = RandomStringUtils.randomNumeric(7);
		driver.findElement(By.id("input_order_number")).sendKeys(randomNumber);
		
		LocalDate today = LocalDate.now();
        // Format tanggal sesuai dengan format yang dibutuhkan oleh elemen input
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter);
		driver.findElement(By.id("input_date")).sendKeys(formattedDate);
	}

	@And("I select {string} as the PartNumber")
	public void i_select_as_the_part_number(String string) {
		WebElement part = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/span/form/div[2]/div[2]/div/div[1]/table/tbody/tr/td[1]/span/fieldset/div/select"));
		Select select = new Select(part);
        select.selectByIndex(1);
		
		WebElement unit = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/span/form/div[2]/div[2]/div/div[1]/table/tbody/tr/td[3]/span/fieldset/div/select"));
		Select select1 = new Select(unit);
        select1.selectByIndex(1);
	}

	@And("I enter the description")
	public void i_enter_the_description() {
		driver.findElement(By.id("input_notes")).sendKeys("Notes");
	}

	@And("I enter the qty of {string}")
	public void i_enter_the_qty_of(String qty) {
        //input qty
        driver.findElement(By.id("input_quantity")).clear();
        driver.findElement(By.id("input_quantity")).sendKeys(qty);
	}

	@And("I enter the price of {string}")
	public void i_enter_the_price_of(String price) {
        driver.findElement(By.id("item_6")).clear();
        driver.findElement(By.id("item_6")).sendKeys(price);

	}
	@And("I expect the {string} to contain {string}")
	public void i_expect_the_to_contain(String Label, String nilai) {
		driver.findElement(By.xpath("//label[text()='"+Label+"']"));
		driver.findElement(By.xpath("//label[text()='"+nilai+"']"));
	}

	@And("I press save")
	public void i_press_save() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^system showed success alert in page purchase order (.*)")
	public void system_showed_success_alert_in_page_purchase_order(String message) throws InterruptedException {
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

/////update
	@When("user update purchase order")
	public void user_update_purchase_order() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li[1]/a")).click();
		Thread.sleep(1000);
		
		String randomNumber = RandomStringUtils.randomNumeric(7);
		driver.findElement(By.id("input_order_number")).clear();
		driver.findElement(By.id("input_order_number")).sendKeys(randomNumber);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

///deleted
	@When("user delete purchase order")
	public void user_delete_purchase_order()throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/div/ul/li[2]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}
///Approve
	@When("user approve purchase order")
	public void user_approve_purchase_order() throws InterruptedException {
		
	            WebElement label = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/table/tbody/tr[1]/td[7]/div/div"));

	            // Klik label untuk mengklik checkbox
	            label.click();

	            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div/button[2]")).click();
	            Thread.sleep(500);
	            driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}

	@When("user reject purchase order")
	public void user_reject_purchase_order() throws InterruptedException {
        WebElement label = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div[1]/table/tbody/tr[2]/td[7]/div/div"));

        // Klik label untuk mengklik checkbox
        label.click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div/button[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[4]/div/input[1]")).sendKeys("Test Reject");
        
        driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}
}
