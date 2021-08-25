package webbasedgame;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class login {
	
 WebDriver driver;
	 
	 public login(WebDriver driver) {
	          this.driver = driver;
	 }
	 
	 By Fullname = By.name("username");
	 By Passwd = By.name("password");
	 By Loginbtn = By.xpath("/html/body/div/center/div/form/div[3]/input");
	 
	 public void setUsername(String user) 
	 {
		 driver.findElement(Fullname).sendKeys(user);
	 }
		 
	 public void setPassword(String pass) 
	 {
		 driver.findElement(Passwd).sendKeys(pass);
	 }
		 
	 public void clickLogin() 
	 {
		 driver.findElement(Loginbtn).click();
	 }

}
