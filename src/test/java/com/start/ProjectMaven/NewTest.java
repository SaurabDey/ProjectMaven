package com.start.ProjectMaven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;

	@Test
	public void f() {
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("admin");
		;
		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys("demo123");
		;
		WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
		button.click();
	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://demosite.center/wordpress/wp-login.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

}
