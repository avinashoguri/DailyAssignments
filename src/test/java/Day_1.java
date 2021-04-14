import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day_1 {

	public static void main(String[] args) throws InterruptedException {

		/*Keep getting the count of: 
			- Current World Population
			- Today:  Births, Deaths and population growth today
			- This Year:  Births, Deaths and population growth today
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		Thread.sleep(5000);



		//System.out.println(driver.findElement(By.xpath("//span[@rel='current_population']")).getText());

		long start = System.currentTimeMillis();
		long end = start+20*1000; 
		while (System.currentTimeMillis() < end)
		{
			String currentWorldPopulation=driver.findElement(By.xpath("//div[@class='maincounter-number']//span")).getText();
			
			String todayBirths=driver.findElement(By.xpath("//span[@rel='births_today']")).getText();
			String todayDeaths=driver.findElement(By.xpath("//span[@rel='dth1s_today']")).getText();
			String todayPopulationGrouth=driver.findElement(By.xpath("//span[@rel='absolute_growth']")).getText();

			String thisYearBirths=driver.findElement(By.xpath("//span[@rel='births_this_year']")).getText();
			String thisYearDeaths=driver.findElement(By.xpath("//span[@rel='dth1s_this_year']")).getText();
			String thisYearPopulationGrouth=driver.findElement(By.xpath("//span[@rel='absolute_growth_year']")).getText();

			System.out.println("Current World Population : "+currentWorldPopulation);
			System.out.println("Today Births : "+todayBirths);
			System.out.println("Today Births : "+todayDeaths);
			System.out.println("Today Population : "+todayPopulationGrouth);
			
			System.out.println("This year Births : "+thisYearBirths);
			System.out.println("This Year Deaths : "+thisYearDeaths);
			System.out.println("This year Population : "+thisYearPopulationGrouth);
			System.out.println();
			

		}

		driver.close();

	}

}
