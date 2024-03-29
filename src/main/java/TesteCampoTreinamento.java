import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	/*
	Here I can find two ways to do same thing, but always using
	the best pattern.
	 */

	private WebDriver driver;
	private DSL dsl;

	@Before // Defines this method be executed before each test
	public void getStart(){
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	@After
	public void getFinish(){
		driver.quit();
	}


	@Test
	public void testeTextField() {
		dsl.write("elementosForm:nome", "Teste de escrita" );
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", dsl.getValueField("elementosForm:nome"));

	}
	
	@Test
	public void deveInteragirComTextArea() {
		dsl.write("elementosForm:sugestoes", "teste");
		//driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste", dsl.getValueField("elementosForm:sugestoes"));

	}
	
	@Test
	public void deveInteragirComRadioButton() {
		dsl.clickRadio("elementosForm:sexo:0");
		//driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(dsl.isRadioClicked("elementosForm:sexo:0"));
		//Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

	}
	
	@Test
	public void deveInteragirComCheckbox() {
		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

	}
	
	@Test
	public void deveInteragirComCombo() {

		dsl.selectCombo("elementosForm:escolaridade", "2o grau incompleto");
		Assert.assertEquals("2o grau incompleto", dsl.isComboSelected("elementosForm:escolaridade"));
		//WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		//Select combo = new Select(element);
		//combo.selectByIndex(4);
		//combo.selectByValue("superior");
		// this way can be more used because that is the user view.
		//combo.selectByVisibleText("2o grau incompleto");

	}
	
	@Test
	public void deveVerificarValoresCombo() {
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		//Verificar se a opção consta na minha coleção.
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);

	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		dsl.selectCombo("elementosForm:esportes", "Natacao");
		dsl.selectCombo("elementosForm:esportes", "Karate");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		//combo.selectByVisibleText("Natacao");
		//combo.selectByVisibleText("Corrida");
		//combo.selectByVisibleText("Karate");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
	}
	
	@Test
	public void deveInteragirComBotao() {

		dsl.clickButton("buttonSimple");

		WebElement botao = driver.findElement(By.id("buttonSimple"));
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
	}
	
	//Don't let tests passing even though it´s not doing anything
	
	@Test
	//@Ignore
	public void deveInteragirComLinks() {
		
		dsl.clickOnLinks("Voltou!");
		
		Assert.assertEquals("Voltou!", dsl.linkIsClicked(By.id("resultado")));
		//Assert.fail();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		//Assert.assertEquals("Campo de Treinamento", dsl.getTextName(By.tagName("h3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());

	}
}
