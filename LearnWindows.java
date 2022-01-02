package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Windows.html");
		driver.manage().window().maximize();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
		System.out.println(handles.size());
		
		
		driver.findElement(By.id("home")).click();
		driver.switchTo().window(handles.get(0));
		driver.switchTo().window(handles.get(1));
		
		String SecondWindowTitle = driver.getTitle();
		System.out.println(SecondWindowTitle);
		
		//Close current window
		//driver.close();
		
		//Close all open windows
		//driver.quit();
		
	}

}
