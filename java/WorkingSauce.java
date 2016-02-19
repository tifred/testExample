import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.junit.Assert.assertEquals;
import java.net.URL;

public class WorkingSauce {

  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

  public static void main(String[] args) throws Exception {

	/**
	* Task I: Update the test code so when it runs, the test clicks the “I am a link” link and sends us the job ID
	*
	* Task II - Update the test code so when it runs, the test is able to write text in the “I has no forms” page and sends us the job ID
	*
	* Task III - Update the test code so when it runs, it can add an email to the email field, type in comments, and send them with a click of the “Send” button.
	*
	* Please post the link to the Sauce Labs job after completion of each task
	*/


    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows 7");
    caps.setCapability("browserName", "chrome");
    caps.setCapability("version", "48");
    caps.setCapability("name", "Guinea-Pig Sauce");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

  /**
  * Gets the job ID, goes to Sauce Lab's guinea-pig page and verifies the title
  */

    String sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
    driver.get("https://saucelabs.com/test/guinea-pig");
	  assertEquals("I am a page title - Sauce Labs", driver.getTitle());
    driver.quit();
  }
}
