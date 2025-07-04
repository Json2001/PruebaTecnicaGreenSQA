package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaPrincipal extends BasePage {

    private String latamLogo = "//img[@alt='logo']";
    private String closeButton = "//*[@id=\'button-close-login-incentive\']";
    private String idayVueltaButton = "//span[normalize-space()='Ida y vuelta']";
    private String originCityInput = "//input[@id='fsb-origin--text-field']";
    private String originCitySubMenu = "//p[@class='sc-eldPxv jDETuo latam-typography latam-typography--paragraph-base sc-fPXMVe iZqZog']//span[1]";
    private String destinationCityInput = "//input[@id='fsb-destination--text-field']";
    private String destinationCitySubMenu = "//p[@class='sc-eldPxv jDETuo latam-typography latam-typography--paragraph-base sc-fPXMVe iZqZog']//span[1] ";
    private String diaIdaInput = "//input[@id='fsb-departure--text-field']";
    private String diaRegresoInput = "//input[@id='fsb-return--text-field']";
    private String diaIdaCalendar = "//span[@id='date-2025-07-10']";
    private String diaRegresoCalendar = "//span[@id='date-2025-08-10']";
    private String buscarVueloButton = "//*[@id=\"fsb-search-flights\"]/span[2]/span/span";

    private String destinationNotFound = "//span[contains(text(),'No hay resultado')]";
    private String invalidDate = "//div[@id='fsb-departure--text-field__helper-text']";

    public PaginaPrincipal() {
        super(driver);

    }

    public void navigateToLatam() {
        navigateTo("https://www.latamairlines.com/co/es");
    }

    public void clickIdayVueltaButton() {
        clickElement(latamLogo);
        
        if (isElementPresent(closeButton)) {
            clickElement(closeButton);
        }
        clickElement(idayVueltaButton);
    }

    public void typeOriginCity(String origen) {
        write(originCityInput, origen);
        clickElement(originCitySubMenu);
    }

    public void typeDestinationCity(String destino) {
        write(destinationCityInput, destino);
        if (isElementPresent(destinationCitySubMenu)) {
            clickElement(destinationCitySubMenu);
        }
    }

    public void departureDaySelect() {
        clickElement(diaIdaInput);
        clickElement(diaIdaCalendar);
    }

    public void returnDaySelect() {
        clickElement(diaRegresoInput);
        clickElement(diaRegresoCalendar);
    }

    public void clickBuscarVuelosButton() {
        jsClick(buscarVueloButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToNewTab();
    }
    public void destinationError() {
        WebElement destinationNotFoundElement = driver.findElement(By.xpath(destinationNotFound));
        Assert.assertTrue("El elemento de destino no encontrado, no se muestra", destinationNotFoundElement.isDisplayed());
    }

    public void unselectedDatesWarning(){
        WebElement unselectedDateseElement = driver.findElement(By.xpath(invalidDate));
        Assert.assertTrue("El elemento de fechas no econtradas, no se muestra", unselectedDateseElement.isDisplayed());
    }
}