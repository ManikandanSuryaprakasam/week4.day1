package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowsAssignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String mainwindow = driver.getWindowHandle();
		driver.findElement(By.id("home")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String>handles = new ArrayList<String>(windowHandles);
		//System.out.println(handles.size());



		driver.switchTo().window(handles.get(1));
		String SecondWindowTitle = driver.getTitle();
		System.out.println(SecondWindowTitle);



		driver.switchTo().window(mainwindow);
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();

		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String>handles2 = new ArrayList<String>(windowHandles2);
		System.out.println("Number of opened windows:"+handles2.size());
		System.out.println(driver.getTitle());
		driver.switchTo().window(mainwindow);


		driver.findElement(By.xpath("//button[contains(text(),'Do not close me')]")).click();	

		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String>handles3 = new ArrayList<String>(windowHandles3);
		for(String hnd : handles3)
		{

			driver.switchTo().window(hnd);
			if(!(driver.getTitle().contains("TestLeaf - Interact with Windows")))
				driver.close();

		}


		driver.switchTo().window(mainwindow);




		driver.findElement(By.xpath("//button[contains(text(),'Wait for 5 seconds')]")).click();

		System.out.println("All Done !!!");




	}}


