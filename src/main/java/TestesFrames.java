import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesFrames {

    @Test
    public void deveInteragirComFrames(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Frame OK!", message);
        alert.accept();

        //It's necessary bring the focus back to Form.
        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(message);

    }

    @Test
    @Ignore
    public void deveInteragirComJanelas(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("buttonPopUpEasy")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        driver.close();
        driver.switchTo().window("");
        driver.findElement(By.tagName("textarea")).sendKeys("e agora deu certo?");
    }

    @Test
    public void deveInteragirComJanelasSemTitulo(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("buttonPopUpHard")).click();
        //System.out.println(driver.getWindowHandle());
        // A cada execução ele gera um número de id das janelas em execução.
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
        driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
        driver.quit();

    }

}
