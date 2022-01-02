package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowsirctc {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
			
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.partialLinkText("FLIGHTS")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String>handles = new ArrayList<String>(windowHandles);
		System.out.println(handles.size());


		
		driver.switchTo().window(handles.get(1));
			
		String SecondWindowTitle = driver.getTitle();
		System.out.println(SecondWindowTitle);


		driver.switchTo().window(handles.get(0));

		
		driver.close();
		
	}

}
