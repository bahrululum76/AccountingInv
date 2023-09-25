package steps;

import java.io.File;
import java.io.InputStream;
import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.cucumber.java.en.*;

public class LoginAccount {
	ChromeOptions opt=new ChromeOptions();
//	WebDriver driver=null;	
	 private ConfigReader configReader = new ConfigReader();
	
	public void login(WebDriver driver) {
        // Membuka browser
    	String environment = "dev"; // Ganti dengan lingkungan yang diinginkan, misalnya "staging" atau "prod"
        String baseUrl = configReader.getBaseUrl(environment);
		@SuppressWarnings("unused")
		InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("chromedriver");

        // Mengkonversi InputStream ke File
        File driverFile = new File("src/test/resources/driver/chromedriver");
		
	    opt.addArguments("--remote-allow-origins=*");
	    
	    System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
        
	    driver = new ChromeDriver(opt);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        // Mengarahkan ke URL login
        driver.get(baseUrl);
        
		driver.findElement(By.id("input_email_login")).sendKeys("holding@kokarmina.com");
		driver.findElement(By.id("input_password_login")).sendKeys("Kokarmina123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
	
//	ChromeOptions opt=new ChromeOptions();
//	WebDriver driver=null;	
//	
//	
//	@Given("User is already on the login page")
//	public void user_is_already_on_the_login_page() {
//		@SuppressWarnings("unused")
//		InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("chromedriver.exe");
//
//        // Mengkonversi InputStream ke File
//        File driverFile = new File("src/test/resources/driver/chromedriver.exe");
//		
//	    opt.addArguments("--remote-allow-origins=*");
//	    
//	    System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
//	    driver = new ChromeDriver(opt);
//	    driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
//
//		driver.navigate().to("http://localhost:4000/login");	
//
//	}
//
//	@Given("^email and password input has filled (.*) and (.*)")
//	public void email_and_password_input_has_filled(String username, String Password) throws InterruptedException {
//		Thread.sleep(500);
//		driver.findElement(By.name("email")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(Password);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//	}
//
//	@When("User click the button Login")
//	public void user_click_the_button_login() {
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//	}
//
//	@Then("^System showed success alert (.*)")
//	public void system_showed_success_alert(String message) throws InterruptedException {
//
//		
//		Thread.sleep(500);
//		driver.findElements(By.id("swal2-title"));
//		List<WebElement> swalElements = driver.findElements(By.id("swal2-title"));
//		boolean textExists = false;
//
//		for (WebElement element : swalElements) {
//		    if (element.getText().contains(message)) {
//		        textExists = true;
//		        break;
//		    }
//		}
//
//		if (textExists) {
//		    System.out.println("Teks ditemukan dalam elemen swal2-title.");
//		} else {
//		    throw new AssertionError("Teks tidak ditemukan dalam elemen swal2-title.");
//		}
//		
//	}
//	
//	@Then("^System showed an error message below the email field that said (.*)")
//	public void system_showed_an_error_message_below_the_email_field_that_said(String message1) throws InterruptedException {
//		Thread.sleep(500);
//		driver.findElements(By.id(""));
//		List<WebElement> swalElements = driver.findElements(By.id(""));
//		boolean textExists = false;
//
//		for (WebElement element : swalElements) {
//		    if (element.getText().contains(message1)) {
//		        textExists = true;
//		        break;
//		    }
//		}
//
//		if (textExists) {
//		    System.out.println("Teks ditemukan ");
//		} else {
//		    throw new AssertionError("Teks tidak ditemukan ");
//		}
//
//	}
//
//	@Then("System showed an error message below the password field that said (.*)")
//	public void system_showed_an_error_message_below_the_password_field_that_said(String message2) throws InterruptedException {
//		
//		Thread.sleep(500);
//		driver.findElements(By.id(""));
//		List<WebElement> swalElements = driver.findElements(By.id(""));
//		boolean textExists = false;
//
//		for (WebElement element : swalElements) {
//		    if (element.getText().contains(message2)) {
//		        textExists = true;
//		        break;
//		    }
//		}
//
//		if (textExists) {
//		    System.out.println("Teks ditemukan.");
//		} else {
//		    throw new AssertionError("Teks tidak ditemukan");
//		
//		}
//
//	}
//	
//}
