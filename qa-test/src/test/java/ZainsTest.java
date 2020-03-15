import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class ZainsTest {
   @Test
   public void zainsTest1() throws MalformedURLException {
       System.out.println("URL_HUB "+System.getenv("URL_HUB"));
       System.out.println("URL_UI "+System.getenv("URL_UI"));
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setBrowserName("chrome");
       RemoteWebDriver chrome = new RemoteWebDriver(new URL(System.getenv("URL_HUB")+"/wd/hub"), capabilities);
       chrome.get(System.getenv("URL_UI"));
       String currentUrl=chrome.getCurrentUrl();
 //      chrome.quit();
       Assert.assertTrue(currentUrl.contains(System.getenv("URL_UI")));
   }


   public void zainsTest2() throws MalformedURLException {
       System.out.println("URL_HUB "+System.getenv("URL_HUB"));
       System.out.println("URL_UI "+System.getenv("URL_UI"));
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setBrowserName("firefox");
       RemoteWebDriver chrome = new RemoteWebDriver(new URL(System.getenv("URL_HUB")+"/wd/hub"), capabilities);
       chrome.get(System.getenv("URL_UI"));
       String currentUrl=chrome.getCurrentUrl();
// to dont close chrome
       //       chrome.quit();
       Assert.assertTrue(currentUrl.contains(System.getenv("URL_UI")));
   }






   @Test
   public void workingTest() throws MalformedURLException {
       Assert.assertEquals("Works", "Works");

   }
}
