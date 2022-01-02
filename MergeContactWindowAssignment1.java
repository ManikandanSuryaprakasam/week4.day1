package week4.day1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactWindowAssignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));



		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		String Mainwindow = driver.getWindowHandle();

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handlelist = new ArrayList<String>(windowHandles);
		for(String hnd:handlelist)
		{
			driver.switchTo().window(hnd);
			System.out.println(driver.getTitle());
			if(driver.getTitle().contains("Find Contacts"))
			{
				//System.out.println("Test2");
				driver.switchTo().window(hnd);
				break;

			}

		}	


		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(Mainwindow);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> handlelist1 = new ArrayList<String>(windowHandles1);
		for(String hnd:handlelist1)
		{
			
			driver.switchTo().window(hnd);
			if(driver.getTitle().contains("Find Contacts"))	
			{System.out.println("Test");
				driver.switchTo().window(hnd);
				break;
			}

		}	

		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
		driver.switchTo().window(Mainwindow);

		driver.findElement(By.linkText("Merge")).click();

	Alert ContactAlert = driver.switchTo().alert();
	ContactAlert.accept();

	if(driver.getTitle().contains("View Contact | opentaps CRM"))
		System.out.println("Title matches Test passed!!!!");
		else
			System.out.println("Title not matching.");



	}

	}
