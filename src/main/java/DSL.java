import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {

    private WebDriver driver;

    // This is a constructor method
    public DSL(WebDriver driver){
        this.driver = driver;
    }
    // This is a method using DSL{own language to defines methods more cleaner}
    public void write(String id_campo, String texto){
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }

    public String getValueField( String id_campo){
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }
}
