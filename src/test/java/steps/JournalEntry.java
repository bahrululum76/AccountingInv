package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class JournalEntry {
	private WebDriver driver;

	public JournalEntry(Menu menu) {
		this.driver = menu.getDriver();
	}
	

	@When("user create journal entry")
	public void user_create_journal_entry() {

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[2]/div/div/button")).click();

		driver.findElement(By.id("input_reference")).sendKeys("Ref A");

		LocalDate currentDate = LocalDate.now();
		// Format the date as per your requirement
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = currentDate.format(formatter);

		driver.findElement(By.id("input_date")).sendKeys(formattedDate);

		driver.findElement(By.id("input_desc")).sendKeys("Desc");

		driver.findElement(By.id("input_note")).sendKeys("Notes");


		//input in table row 1
		WebElement AccounttElement = driver.findElement(By.id("input_coa_0"));
		// Buat objek Select dari elemen select
		Select select = new Select(AccounttElement);
		// Pilih option pertama
		select.selectByIndex(0);
		//account
		driver.findElement(By.id("input_debit_0")).clear();
		driver.findElement(By.id("input_debit_0")).sendKeys("1000000");
		driver.findElement(By.id("input_source_0")).sendKeys("Source");
		driver.findElement(By.id("input_memo_0")).sendKeys("Note");

		//input in table row 2
		WebElement AccounttElement2 = driver.findElement(By.id("input_coa_1"));
		// Buat objek Select dari elemen select
		Select select1 = new Select(AccounttElement2);
		// Pilih option pertama
		select1.selectByIndex(1);

		driver.findElement(By.id("input_credit_1")).clear();
		driver.findElement(By.id("input_credit_1")).sendKeys("1000000");
		driver.findElement(By.id("input_source_1")).sendKeys("Source");
		driver.findElement(By.id("input_memo_1")).sendKeys("Note");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("^System showed alert on Journal of entry page (.*)")
	public void system_showed_alert_in_page_journal_entry (String message) throws InterruptedException {
	

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
	
///edit
	
	@When("user update journal entry")
	public void user_update_journal_entry() throws InterruptedException {
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/table[2]/tbody/tr[1]/td/div/div/a/span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div/div[2]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div/div[2]/div/ul/li/a")).click();
		Thread.sleep(500);
		driver.findElement(By.id("input_reference")).sendKeys("Ref Modify");


		driver.findElement(By.id("input_desc")).sendKeys("Desc modify");

		driver.findElement(By.id("input_note")).sendKeys("Notes modify");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	
	@When("user delete journal entry")
	public void user_delete_journal_entry() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/table[2]/tbody/tr[1]/td/div/button")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
	}
}
