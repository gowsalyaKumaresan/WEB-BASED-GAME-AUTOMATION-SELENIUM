package webbasedgame;
import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Program1{
	static final Logger logger = LogManager.getLogger(Program1.class.getName());
private WebDriver driver;
ExtentHtmlReporter htmlReporter;
ExtentReports extent;  
public static String baseUrl = "http://localhost/hclgamer/login.php";

@BeforeTest
public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
driver.get(baseUrl);
driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
driver.manage().window().maximize();

htmlReporter = new ExtentHtmlReporter("extent.html");           
extent = new ExtentReports();
  extent.attachReporter(htmlReporter);
}
@Test
(priority = 1)
public void webTest() throws Exception 
{
	 ExtentTest test = extent.createTest("MyFirstTest", "Sample description"); 
    driver.get(baseUrl);
   login log= new login(driver);
   DOMConfigurator.configure("log4j.xml"); 
   logger.info("************************");
   logger.info("Test has started");
	 log.setUsername("MT2021070");
	 logger.info("Username enter");
	 
	 log.setPassword("nagendran");
	 logger.info("Password enter");
	 
     driver.findElement(By.xpath("/html/body/div/center/div/form/div[3]/input")).click();
     String h1text = driver.findElement(By.xpath("/html/body/div/div[2]/h4")).getText();
     System.out.println(h1text);
     String h3text = driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText();
     System.out.println(h3text);
     test.pass("Pass");
    // test.info("pass");
     
     driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/a[1]/li")).click();//game page
     String urlssgame = driver.getCurrentUrl();
     System.out.println(urlssgame);
     String h2text = driver.findElement(By.xpath("/html/body/section/div/div[1]/h2")).getText();
     System.out.println(h2text);
     
     driver.findElement(By.xpath("/html/body/div/div[2]/ul/a[1]/li")).click(); //home page
     
     driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/a[2]/li")).click();//about page
     String urlssabout = driver.getCurrentUrl();
     System.out.println(urlssabout);
     String h1textabout = driver.findElement(By.xpath("/html/body/div[2]/h1")).getText();
     System.out.println(h1textabout);
     String h2textabout = driver.findElement(By.xpath("/html/body/div[2]/div/p")).getText();
     System.out.println(h2textabout);
     
     driver.findElement(By.xpath("/html/body/div/div[2]/ul/a[1]/li")).click();//home page
     
     driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/a[4]/li")).click();//contact page
     boolean divtag = driver.findElement(By.xpath("/html/body/section/div/div[2]")).isDisplayed();
    logger.info("Checking the contact page");
     if(divtag == true)
     {
    	 System.out.println(divtag);
     }
     
     driver.findElement(By.xpath("/html/body/div/div[2]/ul/a[1]/li")).click();//home page
     
     driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/a[5]/li")).click();//logout page
     String loginurl = driver.getCurrentUrl();
     logger.info("Getting the current url");
     System.out.println(loginurl);
}
@Test
(priority = 2)
public void validSignUp() throws Exception
{
	 DOMConfigurator.configure("log4j.xml"); 
	ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	driver.findElement(By.xpath("/html/body/div/center/div/form/p/a")).click();
	  signup sign = new signup(driver);
	   String signupurl = driver.getCurrentUrl();
	   System.out.println(signupurl);
      driver.findElement(By.name("username")).sendKeys("hemaathlet@gmail.com");
      logger.info("ENTER NEW USER NAME");
      driver.findElement(By.name("password")).sendKeys("Appa@_13");
      logger.info("ENTER NEW PASSWORD");
      driver.findElement(By.name("confirm_password")).sendKeys("Appa@_13");
      logger.info("REENTER NEW PASSWORD");
      driver.findElement(By.xpath("/html/body/center/div/form/div/div[2]/div[3]/input[1]")).click();//signup page submit button
      driver.findElement(By.xpath("/html/body/center/div/form/div/div[2]/p/a")).click();//login here
      
      driver.findElement(By.name("username")).sendKeys("hemaathlet@gmail.com");
      logger.info("ENTER NEW USER NAME");
      driver.findElement(By.name("password")).sendKeys("1234Appa");
      logger.info("ENTER NEW PASSWORD");
      driver.findElement(By.xpath("/html/body/div/center/div/form/div[3]/input")).click();//login page
      test.pass("LOGIN PAGE IS SUCCESSFULLY LOGIN");
      test.info("pass");
      
      boolean chagepasstag = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/a[6]/li")).isDisplayed();//change password
      if(chagepasstag == true)
      {
    	  System.out.println(chagepasstag);
      }
      
      driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/a[6]/li")).click();
     String resetpassh1text= driver.findElement(By.xpath("/html/body/center/div/div/h2")).getText();
     System.out.println(resetpassh1text);
     
     driver.findElement(By.name("new_password")).sendKeys("1234Appa");
     driver.findElement(By.name("confirm_password")).sendKeys("1234Appa");
     
     driver.findElement(By.xpath("/html/body/center/div/div/form/div[3]/input")).click();
   assertEquals("http://localhost/hclgamer/login.php",driver.getCurrentUrl());
   test.pass("Url is logout successfully");
}


@Test
(priority = 3)
public void invalidlogin() throws Exception
{
	ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	driver.get(baseUrl);
    FileInputStream file =  new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\loginpages.xlsx");
	XSSFWorkbook work = new XSSFWorkbook(file);
    XSSFSheet sheet = work.getSheetAt(0);
    
    
    int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
    WebElement username=driver.findElement(By.name("username"));
    WebElement password=driver.findElement(By.name("password"));
    
   
      username.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
      password.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
      System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
      System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
      
      username.clear();
      password.clear();
      driver.findElement(By.xpath("/html/body/div/center/div/form/div[3]/input")).click();//login page

      String Eror = driver.findElement(By.xpath("/html/body/div/center/div/form/div[1]/span")).getText();
		System.out.println(Eror);
      if(Eror.equals("Please enter username.")) {
			assertEquals("Please enter username.", Eror);

			test.fail("Test Case Pass");
			
      }
}

@AfterTest
public void tearDown() throws Exception {
   driver.quit();
   extent.flush();
}

}

