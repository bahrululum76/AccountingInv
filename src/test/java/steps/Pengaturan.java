package steps;

//import java.io.File;
//import java.io.InputStream;
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.Select;


//import io.cucumber.java.en.*;

public class Pengaturan {
//	ChromeOptions opt=new ChromeOptions();
//	WebDriver driver=null;	
//	 private ConfigReader configReader = new ConfigReader();
	
	

//	@Given("user login accounting tipe akun")
//	public void user_login_accounting_tipe_akun() {
//		String environment = "dev"; // Ganti dengan lingkungan yang diinginkan, misalnya "staging" atau "prod"
//        String baseUrl = configReader.getBaseUrl(environment);
//		
//		@SuppressWarnings("unused")
//		InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("chromedriver.exe");
//
//        // Mengkonversi InputStream ke File
//        File driverFile = new File("src/test/resources/driver/chromedriver.exe");
//		
//	    opt.addArguments("--remote-allow-origins=*");
//	    
//	    System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
//		
//	    driver = new ChromeDriver(opt);
//	    driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
//
//		driver.navigate().to(baseUrl);	
//		
//		driver.findElement(By.id("input_email_login")).sendKeys("holding@kokarmina.com");
//		driver.findElement(By.id("input_password_login")).sendKeys("Kokarmina123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//	}
//
//////////////////Create
//	@Given("user is already on the tipe akun page")
//	public void user_is_already_on_the_tipe_akun_page() {
//		driver.findElement(By.id("sidebar_pengaturan")).click();
//		driver.findElement(By.id("sidebar_tipe_akun")).click();
//	}
//	@Given("user is already on the detail akun page")
//	public void user_is_already_on_the_detail_akun_page() {
//		driver.findElement(By.id("sidebar_pengaturan")).click();
//		driver.findElement(By.id("sidebar_detail_akun")).click();
//	}
//
//
//
//	@When("^user create tipe akun (.*) and (.*)")
//	public void user_create_tipe_akun(String kode , String Nama_Tipe_Akun) throws InterruptedException {
//		Thread.sleep(500);
//		WebElement Text = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[1]"));
//		
//		String Textid =Text.getText();
//
//		int id = Integer.parseInt(Textid);
//		int newId = id + 1;
//	    
//		driver.findElement(By.id("button_add_settings")).click();
//
//		
//        driver.findElement(By.id("input_kode_setting")).sendKeys(kode+newId);
//
//   
//
//        
//
//    		driver.findElement(By.id("input_name_kode_setting")).sendKeys(Nama_Tipe_Akun);
//    		
//    		driver.findElement(By.xpath("//button[@type='submit']")).click();
//        }
//	
//	
//	@Then("^System showed alert in page tipe akun (.*)")
//	public void system_showed_alert_in_page_tipe_akun (String message) throws InterruptedException {
//		Thread.sleep(500);
//		driver.findElements(By.id("swal2-title"));
//		
//		List<WebElement> swalElements = driver.findElements(By.id("swal2-title"));
//		
//		boolean textExists = false;
//		for (WebElement element : swalElements) {
//		    if (element.getText().contains(message)) {
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
//	driver.quit();
//	
//	}
//	
///////////////////user has not filled Kode and Nama Akun Tipe	
//	@When("user click on the Simpan button")
//	public void user_click_on_the_simpan_button() {
//		driver.findElement(By.id("button_add_settings")).click();
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//	}
//
//	@Then("^field Kode should be with error message (.*)")
//	public void field_kode_should_be_with_error_message(String message1) {
//		
//
//	}
//
//	@Then("^field Nama Akun tipe should be with error (.*)")
//	public void field_nama_akun_tipe_should_be_with_error(String message1) {
//
//	}
//	
////////EDIT TIPE AKUN	
//	@When("^user Edit tipe akun (.*) and (.*)")
//	public void user_edit_tipe_akun(String kode, String Nama_Tipe_Akun) {
//		//kurang button edit
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/button")).click();
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/ul/li[1]")).click();
//		
//
//		driver.findElement(By.id("input_name_kode_setting")).clear();
//		driver.findElement(By.id("input_name_kode_setting")).sendKeys(Nama_Tipe_Akun);
//		
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//	}
//	
//////delete tipe akun
//	@When("user hapus data tipe akun")
//	public void user_hapus_data_tipe_akun() {
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/button")).click();
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/ul/li[2]")).click();
//		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
//
//	}
//
//	@When("user hapus data tipe akun has detail tipe")
//	public void user_hapus_data_tipe_akun_has_detail_tipe() {
//
//	}
//	
//////////////////////////DETAIL TIPE AKUN
////////////////CREATE
//	@When("^user create detail tipe akun (.*) and (.*)")
//	public void user_create_detail_tipe_akun(String Tipe_Akun ,String Nama_Detail_Akun ) throws InterruptedException {
//		Thread.sleep(500);
//
//		
//        WebElement Text = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[2]"));	
//		String Textid =Text.getText();
//
//		int id = Integer.parseInt(Textid);
//		int newId = id + 1;
//		
//		driver.findElement(By.id("button_add_settings")).click();
//		
//        WebElement dropdown1 =driver.findElement(By.id("input_kode_detail_setting"));
//        Select select1 = new Select(dropdown1);
//        // Pilih urutan pertama dalam elemen <select> : debit
//        select1.selectByIndex(0);
//	    
//        
//		driver.findElement(By.id("input_kode_setting")).sendKeys("00"+newId);
//		driver.findElement(By.id("input_detail_name_setting")).sendKeys("name dummy");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//	}
//	
//
//	
///////////////EDIT
//	@When("user Edit detail tipe akun")
//	public void user_edit_detail_tipe_akun() {
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/div/button")).click();
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/div/ul/li[1]")).click();
//		
//
//        WebElement dropdown1 =driver.findElement(By.id("input_kode_detail_setting"));
//        Select select1 = new Select(dropdown1);
//        // Pilih urutan pertama dalam elemen <select> : debit
//        select1.selectByIndex(3);
//		
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[3]/span/form/div[1]/div/span[2]/fieldset/div/input")).sendKeys("020827");
//		driver.findElement(By.id("input_detail_name_setting")).sendKeys("name dummy12");
//		
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//	}
//	
//////// DELETE
//	@When("user hapus data detail tipe akun")
//	public void user_hapus_data_detail_tipe_akun() {
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/div/button")).click();
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/section/div/div/section/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/div/ul/li[2]")).click();
//		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
//	}
//	
	
}


