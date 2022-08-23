package challenges;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v95.css.CSS;

public class challengeTest {

        @Test
        public void testarApplication() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1200, 765));
            driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
            //driver.quit();
        }

        @Test
        public void testLogin(){
            WebDriver driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1200, 765));
            driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");

            driver.findElement(By.xpath("//div[@class='meshim_widget_widgets_IconFont icon_font close']"));
            WebElement clickButton = driver.findElement(By.xpath("//html//body//div[3]//div//div[2]//div//div[1]//div[1]//button"));
            clickButton.click();


        }

}
