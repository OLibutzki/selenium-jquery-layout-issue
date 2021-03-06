

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestClass {

	public final static String HTML_PAGE_PATH = "https://olibutzki.github.io/selenium-jquery-layout-issue/sample.html";

	@Parameters(name = "height: {0}px")
	public static Iterable<Integer> heights() {
		String minHeightString = System.getProperty("minheight", "650");
		String maxHeightString = System.getProperty("maxheight", "800");
		Integer minHeight = Integer.valueOf(minHeightString);
		Integer maxHeight = Integer.valueOf(maxHeightString);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = minHeight; i <= maxHeight; i++) {
			list.add(i);
		}

		return list;
	}

	@Parameter
	public Integer height;

	private static FirefoxDriver driver;

	@BeforeClass
	public static void initDriver() {
		File firefoxBinaryFile = null;
		String firefoxBinaryPath = System.getProperty("firefox.binary");
		if (firefoxBinaryPath != null) {
			firefoxBinaryFile = new File(firefoxBinaryPath);
		}
		FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxBinaryFile);
		driver = new FirefoxDriver(firefoxBinary, null);
	}

	@Test
	public void test() {
		Dimension dimension = new Dimension(800, height);
		driver.manage().window().setSize(dimension);
		driver.get(HTML_PAGE_PATH);
		WebElement webElement = driver.findElement(By.id("MyButton"));
		webElement.click();
		Boolean buttonClicked = (Boolean) driver.executeScript("return buttonClicked");
		Assert.assertTrue("The button has not been clicked!", buttonClicked);
	}
	
	@AfterClass
	public static void closeDriver() {
		driver.close();
	}
}
