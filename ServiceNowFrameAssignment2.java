package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrameAssignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev76429.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("gsft_main");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Chiranjeevi@1234");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("//ul[contains(@aria-label,'Modules for Application: Incident')]/li[6]")).click();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String text = driver.findElement(By.name("incident.number")).getAttribute("value");
		System.out.println(text);
		driver.findElement(By.name("lookup.incident.caller_id")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
//		System.out.println("Loop1");
//		for (String hnd : handles) {
//			System.out.println(hnd);
//			
//		}
		driver.switchTo().window(handles.get(1));
	
		driver.findElement(By.linkText("Abel Tuter")).click();
//		System.out.println("Loop2");
//		for (String hnd : handles) {
//			System.out.println(hnd);
//			
//		}
		//driver.switchTo().defaultContent();
		driver.switchTo().window(handles.get(0));
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("incident.short_description")).sendKeys("Hibernating often");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		boolean displayed = driver.findElement(By.xpath("//a[text()='"+text+"']")).isDisplayed();
		if(displayed)
		{
			System.out.println("Incident Created");}
		else
			{System.out.println("Incident not Created");}
		
			
		
		
	
		
		
		

	}

}



//Assignment 2: ServiceNow - Frames
//----------------------------------
//
//ServiceNow- 
//Refer the attached document below for clarity to create your own instance( sign In credentials) to work with servicenow
//Refer the attached document for the flow of the application to complete the testcase
//
//Step1: Load ServiceNow application URL 
//Step2: Enter username (Check for frame before entering the username)
//Step3: Enter password 
//Step4: Click Login
//Step5: Search “incident “ Filter Navigator
//Step6: Click “All”
//Step7: Click New button
//Step8: Select a value for Caller and Enter value for short_description
//Step9: Read the incident number and save it a variable
//Step10: Click on Submit button
//Step 11: Search the same incident number in the next search screen as below
//Step12: Verify the incident is created successful and take snapshot of the created incident.