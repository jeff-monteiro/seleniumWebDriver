package challenges;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstChallenge {

    @Test
    public void preencherForms(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("myname");
        Assert.assertEquals("myname", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Monteiro");
        Assert.assertEquals("Monteiro", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));

        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());

        WebElement lista = driver.findElement(By.id("elementosForm:esportes"));
        Select list = new Select(lista);
        list.selectByVisibleText("Natacao");
        list.selectByVisibleText("Corrida");
        List <WebElement> allSelectedOptions = list.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        driver.findElement(By.id("resultado"));

        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("myname"));
        Assert.assertEquals("Sobrenome: Monteiro", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Natacao Corrida", driver.findElement(By.id("descEsportes")).getText());
        driver.quit();


    }
}
