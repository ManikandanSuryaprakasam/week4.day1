package week4.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertPrompt {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		
		WebElement Frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(Frame1);
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Manikandan");
		alert.accept();
		
		String VerifyText = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if (VerifyText.contains("Hello Manikandan! How are you today?") )
		{
			System.out.println("Test passed");
		}
		else
			System.out.println("Text not matching");
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./leafground.png");
		
		FileUtils.copyFile(source, destination);
		
		
		WebElement alertBox = driver.findElement(By.xpath(""));
		File sourceEle = driver.getScreenshotAs(OutputType.FILE);
		File destinationEle = new File("./leafground.png");
		FileUtils.copyFile(source, destination);
		
		
		
			

	}

}
