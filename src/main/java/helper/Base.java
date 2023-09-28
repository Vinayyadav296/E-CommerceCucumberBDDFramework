package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	//We can define constants like waits and page load time which we can use in providing the value to the 
	//wait method or timeOut method instead of hard coding the value
	
	public static final long wait_Time=15;
	public static final long pageLoad_TimeOut=15;

	public static Properties initializeProperties() {
		Properties prop = null;
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/config.properties");
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

	@Before
	public static void setup() {
		prop = initializeProperties();
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("url"));

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoad_TimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_Time));

	}

//	@After
//	public  void tearDown() {

	@After
	public void tearDown(Scenario scenario) {

		String sceanrioName = scenario.getName().replace(" ", "_");

		if (scenario.isFailed()) {
			byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", sceanrioName);
		}

		driver.quit();
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElements(element, durationInSeconds);
		webElement.click();
	}

	public void typeTextIntoElement(WebElement element, String textToType, long durationInSeconds) {

		WebElement webElement = waitForElements(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToType);

	}

	public WebElement waitForElements(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {

		}
		return webElement;
	}

	public void selectElementInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {
		WebElement webElement = waitForElements(element, durationInSeconds);
		Select s = new Select(webElement);
		s.selectByVisibleText(dropDownOption);
	}

	public void acceptAlert(long durationInSeconds) {
		Alert a = waitForAlert(durationInSeconds);
		a.accept();
	}

	public void dismissAlert(long durationInSeconds) {
		Alert a = waitForAlert(durationInSeconds);
		a.dismiss();
	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return alert;
	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();

	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return webElement;
	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", webElement);
	}

	public void javaScriptTypeText(WebElement element, long durationInSeconds, String textToType) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value='" + textToType + "'", webElement);
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		WebElement webElement=waitForElements(element, durationInSeconds);
		return webElement.getText();
	}
}
