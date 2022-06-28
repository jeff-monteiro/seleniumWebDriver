package challenges;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstChallenge {

    @Test
    public void inserirNome(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));

    }
}
