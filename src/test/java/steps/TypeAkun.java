package steps;


import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.*;


public class TypeAkun {
    private WebDriver driver;
	
    public TypeAkun(Menu menu) {
        this.driver = menu.getDriver();
	}
	

////////////////Create
//	@Given("user is already on the tipe akun page")
//	public void user_is_already_on_the_tipe_akun_page() throws InterruptedException {
//
//		String environment = "dev"; 
//	    String baseUrl = configReader.getBaseUrl(environment);
//		
//	    Thread.sleep(1000);
//		driver.get(baseUrl+"account-type");
//		Thread.sleep(1000);
//		
//		//		driver.findElement(By.id("sidebar_general")).click();
////		
////        WebElement element = driver.findElement(By.id("sidebar_account_type"));
////
////        
////        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
////
////        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
////		
////		driver.findElement(By.id("sidebar_account_type")).click();
//	}



	@When("^user create tipe akun (.*)")
	public void user_create_tipe_akun(String name) throws InterruptedException {
		
		Thread.sleep(1000);
		
		 String randomText = RandomStringUtils.randomAlphabetic(3);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[1]/button")).click();

		Thread.sleep(1000);
        driver.findElement(By.id("input_account_type")).sendKeys(name+randomText);

   
    		driver.findElement(By.xpath("//button[@type='submit']")).click();
        }
	
	
	@Then("^System showed alert in page tipe akun (.*)")
	public void system_showed_alert_in_page_tipe_akun (String message) throws InterruptedException {

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

//////EDIT TIPE AKUN	
	@When("^user Edit tipe akun (.*)")
	public void user_edit_tipe_akun(String name) {

		//kurang button edit
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/ul/li[1]/a")).click();
		 String randomText = RandomStringUtils.randomAlphabetic(3);

		driver.findElement(By.id("input_account_type")).clear();
		driver.findElement(By.id("input_account_type")).sendKeys(name+" "+randomText);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	
////delete tipe akun
	@When("user hapus data tipe akun")
	public void user_hapus_data_tipe_akun() {

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/ul/li[2]/a")).click();	
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();

	}


}
