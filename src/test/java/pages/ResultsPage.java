package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


public class ResultsPage  extends BasePage  {
    
    private String resultadosVuelosTitle = "//h1[@id='titleSelectFlightDesktop']//span[@aria-hidden='true']";

    public ResultsPage() {
        super(driver);
    }
    public void validarResultados() {
        WebElement resultadosTitle = driver.findElement(By.xpath(resultadosVuelosTitle));
        Assert.assertTrue("El título de resultados no se muestra", resultadosTitle.isDisplayed());
    }
    
}



