package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TripozoHotels {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.tripozo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//li[@class='ant-menu-item ant-menu-item-only-child md-hide']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("CityData")).sendKeys("goa");
		driver.findElement(By.xpath("(//div[@class='ant-select-item ant-select-item-option'])[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='12']")).click();
		WebElement dt = driver.findElement(By.xpath("(//div[text()='13'])"));
		driver.executeScript("arguments[0].click();", dt);
		WebElement srch = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default search-inputs tg-primary-btn f-hvcenter']"));
        driver.executeScript("arguments[0].click();", srch);
        driver.findElement(By.xpath("//span[@class='ant-checkbox']")).click();
        driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[6]")).click();
        driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[8]")).click();
        driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[8]")).click();
        driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[19]")).click();
        driver.findElement(By.xpath("//span[text()='Choose']")).click();
        String ch = driver.findElement(By.xpath("//p[text()='12 Oct 2023']")).getText();
        if (ch.contains("12 Oct 2023")) {
        	System.out.println("Check In date Verified:  "+ch);
		} else {
			System.out.println("Check In date Not Equal");
		}
        driver.findElement(By.xpath("//button[text()='View Rooms']")).click();
        //clicking first resulting room
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default']")).click();
        //clicking 'Room Amenities & Details' 
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='blocklink blnk-small blnkB rnd5 pdlr5 pointer'])[2]")).click();
        Thread.sleep(500);
        WebElement snp1 = driver.findElement(By.xpath("//div[@class='ant-modal-body']"));
        File scrn = snp1.getScreenshotAs(OutputType.FILE);
		File des=new File("./snaps/img.png");
		FileUtils.copyFile(scrn, des);
        driver.findElement(By.xpath("//button[@class='ant-modal-close']")).click();
	}

}
