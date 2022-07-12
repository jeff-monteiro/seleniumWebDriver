import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

    public void clickRadio(String id){
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioClicked(String id){
        return driver.findElement(By.id(id)).isSelected();
    }

    public void selectCombo(String id, String valor){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public String isComboSelected(String id){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void clickButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickOnLinks(String link){
        driver.findElement(By.linkText(link)).click();
    }

    public String linkIsClicked(String id){
        return driver.findElement(By.id("resultado"));
    }
}
