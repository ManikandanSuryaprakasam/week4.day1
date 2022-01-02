package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println("Alert dismissed");
		alert2.dismiss();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println("Alert accepted");
		alert3.accept();
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert alert4 = driver.switchTo().alert();
		alert4.sendKeys("XYZ");
		alert4.accept();
		String text = driver.findElement(By.id("result1")).getText();
		if(text.contains("You should not have enjoyed learning at XYZ as compared to TestLeaf! Right?"));
		System.out.println(text);
		
		driver.close();
				
		
		
	}

}
