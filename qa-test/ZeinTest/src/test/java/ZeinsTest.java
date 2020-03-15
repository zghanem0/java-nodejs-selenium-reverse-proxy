import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ZeinsTest {
    @Test
    public void urlTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setBrowserName("safari");
	System.out.println(System.getenv("HUB_URL"));
        RemoteWebDriver driver = new RemoteWebDriver(   new URL(System.getenv("HUB_URL")),
                desiredCapabilities);

	    driver.get(System.getenv("TEST_URL"));
        String currentURL=driver.getCurrentUrl();
        driver.quit();
        Assert.assertTrue(currentURL.equals(System.getenv("TEST_URL")));


    }

    @Test
    public void urlTestFails() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setBrowserName("firefox");
        RemoteWebDriver driver = new RemoteWebDriver(   new URL(System.getenv("HUB_URL")),
                desiredCapabilities);
        driver.get(System.getenv("TEST_URL"));
        String currentURL=driver.getCurrentUrl();
        driver.quit();
        Assert.assertTrue(currentURL.equals(System.getenv("TEST_URL").concat("_fail")));

    }

}
