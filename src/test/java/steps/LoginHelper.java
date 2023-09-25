package steps;

import java.io.File;
import java.io.InputStream;
import java.time.Duration;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;

public class LoginHelper {
	ChromeOptions opt=new ChromeOptions();
	private ConfigReader configReader = new ConfigReader();
	WebDriver driver=null;

	public LoginHelper() {

		
	}
	
	@Given("user login sebagai {int}")
	public void user_login_sebagai(Integer Int1) {
		
		String environment = "dev"; 
		String baseUrl = configReader.getBaseUrl(environment);

		String filePath = "src/test/resources/file/Akun.xlsx";
        try {
            // Buat objek FileInputStream
            FileInputStream fis = new FileInputStream(filePath);

            // Buat objek XSSFWorkbook untuk mewakili file Excel
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            // Akses sheet yang sesuai
            XSSFSheet sheet = workbook.getSheetAt(0);
            // Ambil data dari sel tertentu (misalnya sel di baris 1, kolom 0)
            XSSFCell cell = sheet.getRow(Int1).getCell(0);
            XSSFCell cell2 = sheet.getRow(Int1).getCell(1);
            // Cetak data yang ada di sel tersebut
//            System.out.println("Data: " + cell.getStringCellValue());
    		String Username = cell.getStringCellValue();
    		String Password = cell2.getStringCellValue();
    		
            fis.close();
            workbook.close();
            
            
    		@SuppressWarnings("unused")
    		InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("chromedriver.exe");

    		// Mengkonversi InputStream ke File
    		File driverFile = new File("src/test/resources/driver/chromedriver.exe");
    		opt.addArguments("--remote-allow-origins=*");
    		opt.addArguments("--headless");
    		opt.addArguments("--no-sandbox");

    		System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());

    		driver=new ChromeDriver(opt);
    		driver.manage().window().maximize();

    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));


    		//---------------------------------------login---------------------------------------------------//
    		driver.navigate().to(baseUrl);	

    		driver.findElement(By.id("input_email_login")).sendKeys(Username);
    		driver.findElement(By.id("input_password_login")).sendKeys(Password);
    		
    		driver.findElement(By.xpath("//button[@type='submit']")).click();            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }


	}
	




	public WebDriver getDriver() {

		return driver;
	}
}