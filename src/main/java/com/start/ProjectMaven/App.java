package com.start.ProjectMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Hello world!
 *
 */
public class App 
{
	WebDriver driver;

	public static void main(String[] args) {

		System.out.println("Welcome Selenium");

		App ref = new App();
		ref.setup();
		ref.login();
		ref.teardown();

	}

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");

		driver = new ChromeDriver();// Opens Browser

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://demosite.center/wordpress/wp-login.php");
	}

	public void login() {
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("Saurab");

		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys("mypasswod");

		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
		loginBtn.click();
	}

	public void teardown() {
		driver.quit();
	}

}
