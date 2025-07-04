package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
         // Maximiza la ventana
        driver.manage().window().maximize();
        // Ajusta el zoom a 90%
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='90%'");
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // Método estático para cerrar la instancia del driver.
    public static void closeBrowser() {
        driver.quit();
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
    // esperando a que esté presentente en el DOM
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Hace scroll al elemento.
    public void scrollTo(String locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // click forzado con javascript por preloaders que no muestran el elemento.
    public void jsClick(String locator) {
        WebElement element = Find(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Función que permite hacer click sobre el elemento
    public void clickElement(String locator) {
        Find(locator).click();
    }

    // Función que escribe en un campo de texto, limpia primero el campo.
    public void write(String locator, String keysToSend) {
        Find(locator).clear(); // Limpia el campo antes de escribir
        Find(locator).sendKeys(keysToSend);
    }

    // seleccionar el valor de un dropdown por valor
    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(value);

    }

    // elegir valor por index en la lista desplegable.
    public void selectFromDropdownByIndex(String locator, String index) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(index);

    }

    // obetener el tamaño de la lista de un dropdown.
    public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }
    //Devuelve todos los valores de un dropdown
    public List<String> getDropdownValues(String locator){
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for(WebElement option : dropdownOptions){
            values.add(option.getText());
        }
        return values;
    }

    public void switchToNewTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        } else {
            throw new RuntimeException("No se encontró una segunda pestaña para cambiar el foco.");
        }
    }
    public boolean isElementPresent(String locator) {
        try {
            driver.findElement(By.xpath(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}