package challenges;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v95.css.CSS;

public class challengeTest {

        @Test
        public void testApplication() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1200, 765));
            driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
            Alert alert = driver.switchTo().alert();
            driver.quit();
        }

}
