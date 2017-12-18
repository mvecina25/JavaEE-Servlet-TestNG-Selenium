package com.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TestNGLoginLogout {
	
	public static WebDriver driver;
	
	static String baseUrl = "http://localhost:8080/Modirum/index.html";
	String bodyText;
	
	static WebElement loginLink;
	static WebElement logoutLink;
	static WebElement username;
	static WebElement password;
	static WebElement loginButton;	
	
	public static final String LOGIN = "Login";
	
  @Test(priority=1)
  public void goToLoginPage() {	  
	//Find the login element
	loginLink = driver.findElement(By.linkText("Login"));			
	assertTrue(loginLink.isDisplayed());	// Verify whether Login link is displayed	
	loginLink.click();	// Click on the element found	
  }
  
  @Test(priority=2)
  public void loginUser(){
	  
	//Enter a valid username
	username = driver.findElement(By.name("name"));
	assertTrue(username.isDisplayed()); // Verify whether username textfield is displayed
	username.clear();
	username.sendKeys("Medel Vecina");
	
	//Enter a valid password
	password = driver.findElement(By.name("password"));
	assertTrue(password.isDisplayed()); // Verify whether password textfield is displayed
	password.clear();
	password.sendKeys("admin");
	
	//Click login button	
	loginButton = driver.findElement(By.name("login"));
	assertTrue(loginButton.isDisplayed()); // Verify whether login button is displayed
	loginButton.click();
  }
  
  @Test(priority=3)
  public void verifyLogin(){	  
	//Verify whether the text is present
	bodyText = driver.findElement(By.tagName("body")).getText();
	assertTrue(bodyText.contains("You are successfully logged in!"), "Text not found!");
	assertTrue(bodyText.contains("Welcome, Medel Vecina"), "Text not found!");
  }
  
  @Test(priority=4)
  public void logoutUser(){
	//Find the logout element 
	logoutLink = driver.findElement(By.name("logout"));			
	assertTrue(logoutLink.isDisplayed());	// Verify whether Logout link is displayed	
	logoutLink.click();	// Click on the element found
  }
  
  @Test(priority=5)
  public void verifyLogout(){
	//Verify whether the text is present
	bodyText = driver.findElement(By.tagName("body")).getText();
	assertTrue(bodyText.contains("You are successfully logged out!"), "Text not found!");
  }
  
  @Test(priority=6)
  public void otherTC1(){
	  System.out.println("Verify that user is not able to login with invalid username and password");
  }
  
  @Test(priority=7)
  public void otherTC2(){
	  System.out.println("Verify that the password is in encrypted form when entered");
  }
  
  @Test(priority=8)
  public void otherTC3(){
	  System.out.println("Verify that there is limit on the total number of unsuccessful attempts");
  }
  
  @Test(priority=9)
  public void otherTC4(){
	  System.out.println("Verify the timeout of the login session");
  }
  
  @Test(priority=10)
  public void otherTC5(){
	  System.out.println("Verify if the password can be copy-pasted or not");
  }
  
  @Test(priority=11)
  public void otherTC6(){
	  System.out.println("Verify that once logged in, clicking back button doesn't logout user");
  }
  
  @Test(priority=12)
  public void otherTC7(){
	  System.out.println("Verify that the user can register new account");
  }
  
  @Test(priority=13)
  public void otherTC8(){
	  System.out.println("Verify if there is checkbox with label remember password in the login page");
  }
  
  @Test(priority=14)
  public void otherTC9(){
	  System.out.println("Verify the max lenght of the text boxes");
  }
  
  @Test(priority=15)
  public void otherTC10(){
	  System.out.println("Verify the database if successfully registered or vice versa");
  }
  
  @Test(priority=16)
  public void otherTC11(){
	  System.out.println("Verify that the username and password text boxes are mandatory");
  }
  
  @Test(priority=17)
  public void otherTC12(){
	  System.out.println("Verify that the user should be redirected to appropriate page for Forgot password option");
  }
  
  
  @BeforeSuite
  public void beforeMethod() {
	  
	// Create a new instance of the Firefox driver
	System.setProperty("webdriver.ie.driver", "C:/Selenium Driver/IEDriverServer32.exe");
	driver = new InternetExplorerDriver();
	
	// Launch IE browser
	driver.navigate().to(baseUrl);
	
	// Maximize the browser
	driver.manage().window().maximize();
  }

  @AfterSuite
  public void afterMethod() {
	  // Close the driver
	  driver.close();
  }

}
