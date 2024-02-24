package Task22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropDownAndSynchronization {

	private static FluentWait<WebDriver> wait;

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.get("https://phptravels.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement firstName = driver.findElement(By.name("first_name"));
		firstName.sendKeys("Sandhiya");

		driver.findElement(By.name("last_name")).sendKeys("RamKumar");
		driver.findElement(By.name("business_name")).sendKeys("RSandCo");
		driver.findElement(By.name("email")).sendKeys("rsandco@gmail.com");

		// Adding Logic

		// Locating the number 1
		WebElement number1 = driver.findElement(By.id("numb1"));
		String num1 = number1.getText();
		int n1 = Integer.parseInt(num1);

		// Locating the number 2
		WebElement number2 = driver.findElement(By.id("numb2"));
		String num2 = number2.getText();
		int n2 = Integer.parseInt(num2);

		// Calculating sum of two numbers:
		int sum = (n1 + n2);
		String sum1 = Integer.toString(sum);

		// Entering the sum value:
		driver.findElement(By.id("number")).sendKeys(sum1);
		driver.findElement(By.xpath("//button[@id='demo']")).click();

		// Verify the form submition
		WebElement f = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Request Form')]")));
		String formPageMsg = f.getText();

		WebElement fm = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='text-center cw']")));
		String formMsg = fm.getText();

		if (formPageMsg.equals("Instant Demo Request Form") && (formMsg.equals("Thank you!"))) {
			System.out.println("User registered");
		} else {
			System.out.println("User not registered");

		}

		// To take screenshot
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destiny = new File("C:\\Users\\Sandhiya\\eclipse-workspace\\Task22\\SnapshotOfphpT\\Screenshot1.png");
		FileUtils.copyFile(source, destiny);

		driver.quit();

	}

}
