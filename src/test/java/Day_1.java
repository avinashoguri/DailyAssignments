import java.awt.List;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day_1 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		/*Keep getting the count of: 
			- Current World Population
			- Today:  Births, Deaths and population growth today
			- This Year:  Births, Deaths and population growth today
		 */

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		Thread.sleep(5000);
		
		String current_pop="//div[@class='maincounter-number']//span[@class='rts-counter']";
		String TodayAndThisYear="//div[text()='Today' or text()='This year']//parent::div//span[@class='rts-counter']";

		long start = System.currentTimeMillis();
		long end = start+20*1000; 
		while (System.currentTimeMillis() < end)
		{
			System.out.println("-----------Current World Population---------------");			
			poplation(current_pop);
			System.out.println("----------Today and This Poplation ---------------");
			poplation(TodayAndThisYear);
			System.out.println("===================================================");			

			Thread.sleep(1000);
		}
		
				driver.close();

	}
	
	public static void poplation(String element) {
		//driver.findElements(By.xpath(element)).stream().forEach(e -> System.out.println(e.getText()));
		
		java.util.List<WebElement> l=driver.findElements(By.xpath(element));
		for(WebElement e:l) {
			System.out.println(e.getText());
		}
	}

}
