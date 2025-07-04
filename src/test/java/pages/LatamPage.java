package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LatamPage{
    
    private WebDriver driver;
    
    @BeforeMethod //ejecuta el codigo siempre de primeras 
    public void setUp() {
        //inicializar el webdriver para chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void navegamosALatamPage() {
        //navega a la pagina web
        driver.get("https://www.latamairlines.com/co/es");

    }
    
    @AfterMethod //se ejecuta despues de cada test 
    public void tearDown() {
        //cerrar el navegador despues de la prueba
        if (driver != null){
            driver.quit();
        }
    }
}