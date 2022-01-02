package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotAssignment {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver  driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement frdefault = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frdefault);
		
		WebElement clickme = driver.findElement(By.id("Click"));
		
		
		File sourceEle = clickme.getScreenshotAs(OutputType.FILE);
		File destinationEle = new File("E:/TestLeaf Java Course/ScreenShots/ClickMe.png");
		FileUtils.copyFile(sourceEle, destinationEle);
		
		driver.switchTo().defaultContent();
//		driver.findElements(By.xpath("//section[@class='innerblock']")).getTagName("iframe");
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		System.out.println("Total number of Frames:"+findElements.size());	
		
		
		

	}

}
