package steps;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;
import pages.ResultsPage;

public class LatamPrincipalPageSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    ResultsPage resultsPage = new ResultsPage();

    @Given("el usuario navega a la pagina de LATAM")
    public void iNavegateToLatam() {
        landingPage.navigateToLatam();
    }

    @When("selecciona el tipo de viaje \"Ida y vuelta\"")
    public void selectIdayVueltaButton() {
        landingPage.clickIdayVueltaButton();
    }
     @And("ingresa el destino invalido {string}")
     public void enterInvalidDestinationCity(String destino){
     landingPage.typeDestinationCity(destino);
     }

    @And("ingresa el origen {string}")
    public void enterOriginCity(String origen) {
        if (origen.equalsIgnoreCase("csv")) {
            String[] par = utils.CsvDataProvider
                    .obtenerParOrigenDestinoAleatorio("C:\\generar-datos\\output\\usuarios.csv");
            origen = par[0];
            System.out.println("📌 Origen desde CSV: " + origen);
        }
        landingPage.typeOriginCity(origen);
    }

    @And("ingresa el destino {string}")
    public void enterDestinationCity(String destino) {
        if (destino.equalsIgnoreCase("csv")) {
            String[] par = utils.CsvDataProvider.obtenerParOrigenDestinoAleatorio("C:\\generar-datos\\output\\usuarios.csv");
            destino = par[1];
        System.out.println("📌 Destino desde CSV: " + destino);
    }
    landingPage.typeDestinationCity(destino);
    }

    @And("selecciona dia de ida")
    public void selectDepartureDay() {
        landingPage.departureDaySelect();
    }

    @And("selecciona dia de regreso")
    public void selectReturnDay() {
        landingPage.returnDaySelect();
    }

    @And("hace clic en Buscar vuelos")
    public void selectBuscarVuelos() {
        landingPage.clickBuscarVuelosButton();
    }

    @Then("se mostraran los resultados")
    public void showSearch() {
        resultsPage.validarResultados();
    }

    @Then("mostrara un mensaje de error por destino no disponible")
    public void showDestinationError() {
        landingPage.destinationError();
    }

    @Then("mostrara un mensaje de advertencia indicando que la fecha es obligatoria")
    public void showWarning() {
        landingPage.unselectedDatesWarning();
    }

}