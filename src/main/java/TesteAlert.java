import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteAlert {
	
	@Test
	public void deveInteragirComAlertSimples() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}

	@Test
	public void deveInteragirComConfirm(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert confirm = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", confirm.getText());
		confirm.accept();
		Assert.assertEquals("Confirmado", confirm.getText());
		confirm.accept();

		driver.findElement(By.id("confirm")).click();
		confirm = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", confirm.getText());
		confirm.dismiss();
		String text = confirm.getText();
		Assert.assertEquals("Negado", text);
		confirm.accept();

		driver.quit();
	}
}
