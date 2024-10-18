package variousConcepts;

import java.awt.dnd.peer.DropTargetPeer;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnLogin {

	WebDriver driver;

	// Element list - By type
	By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By SIGNIN_BUTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
	By DASHBOARD_HEADER_FIELD = By.xpath("//strong[text()='Dashboard']");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testLogin() {

		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));

		/*
		 * By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]"); By PASSWORD_FIELD =
		 * By.xpath("//*[@id=\"password\"]"); By SIGNIN_BUTTON_FIELD =
		 * By.xpath("//*[@id=\"login_submit\"]");
		 */

		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc1234");
		SIGNIN_BUTTON_ELEMENT.click();

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * DASHBOARD_HEADER_FIELD));
		 */
		// --//strong[text()='Dashboard']
		// WebElement DASHBOARD_HEADER_ELEMENT = driver
		// .findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));

		boolean pageTitleDisplayStatus;
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//strong[text()='Dashboard']"));
			pageTitleDisplayStatus = true;
		} catch (Exception e) {
			pageTitleDisplayStatus = false;
			e.getStackTrace();
		}

		// Assert.assertTrue("Dashboard page not found!!", false);
		Assert.assertTrue("Dashboard page not found!!", pageTitleDisplayStatus);

	}
}
