package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TripozoFlights {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.tripozo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//li[@class='ant-menu-item ant-menu-item-only-child first-mwnu-item md-hide']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("search-form_origin")).sendKeys("maa");
		driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("search-form_destination")).sendKeys("gox");
		driver.findElement(By.xpath("(//div[@class='rc-virtual-list'])[2]")).click();
		Thread.sleep(500);
		WebElement date = driver.findElement(By.xpath("//input[@value='12']"));
		driver.executeScript("arguments[0].click();", date);
		driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default search-inputs tg-primary-btn f-hvcenter']")).click();
		driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//label[@class='ant-radio-button-wrapper']/parent::div)[3]")).click();
		driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[4]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='flight-name']"));
		List<String> list1=new ArrayList<String>();
	     for (WebElement data : list) {
	    	 String text1=data.getText();
	    	 System.out.println(text1);
	    	 list1.add(text1);
	}
		driver.findElement(By.xpath("//button[@class='choose-button tpz-btn nowrap']")).click();
		String text = driver.findElement(By.xpath("//span[text()='Refundable']")).getText();
		if (text.contains("Refundable")) {
			System.out.println("Refundable");
		} else {
			System.out.println("Not Refundable");
		}
		Thread.sleep(500);
		WebElement sn1 = driver.findElement(By.xpath("//div[@class='infobtnwrapper']"));
		sn1.click();
		Thread.sleep(500);
		WebElement s1 = driver.findElement(By.xpath("//div[@class='ant-modal-body']"));
		File scrn = s1.getScreenshotAs(OutputType.FILE);
		File des=new File("./snaps/img.png");
		FileUtils.copyFile(scrn, des);
		driver.findElement(By.xpath("//button[@class='ant-modal-close']")).click();
		Thread.sleep(500);
		WebElement sn2 = driver.findElement(By.xpath("//span[text()='Fare Info']"));
		sn2.click();
		Thread.sleep(500);
		WebElement s2 = driver.findElement(By.xpath("//div[@class='ant-modal-body']"));
		File scrn1 = s2.getScreenshotAs(OutputType.FILE);
		File des1=new File("./snaps/img1.png");
		FileUtils.copyFile(scrn1, des1);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@class='ant-modal-close']")).click();
	}

}
