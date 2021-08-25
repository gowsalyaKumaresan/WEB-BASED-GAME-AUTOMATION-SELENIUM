package webbasedgame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signup {

	WebDriver driver;
	 
	 public signup(WebDriver driver) {
	          this.driver = driver;
	 }
	

	By Fullname = By.name("username");
	 By Passwd = By.name("password");
	 By confrimpass = By.name("confirm_password");
	 By submit = By.xpath("/html/body/center/div/form/div/div[2]/div[3]/input[1]");
	 By Loginbtn = By.xpath("/html/body/center/div/form/div/div[2]/p/a");
	 
	 public void setUsername(String user) 
	 {
		 driver.findElement(Fullname).sendKeys(user);
	 }
		 
	 public void setPassword(String pass) 
	 {
		 driver.findElement(Passwd).sendKeys(pass);
	 }
		 
	 public void setConfrimPassword(String confrimpas) 
	 {
		 driver.findElement(Passwd).sendKeys(confrimpas);
	 }
	 public void clickSubmit(String submits) 
	 {
		 driver.findElement(submit).click();
	 }
	 public void clickLogin() 
	 {
		 driver.findElement(Loginbtn).click();
	 }
}
