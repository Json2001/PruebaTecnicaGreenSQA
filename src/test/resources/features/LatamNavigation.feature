Feature: Búsqueda de vuelos en LATAM

  Scenario Outline: Buscar vuelo ida y vuelta desde Bogotá a Lima
    Given el usuario navega a la pagina de LATAM
    When selecciona el tipo de viaje "Ida y vuelta"
    And ingresa el origen "csv"
    And ingresa el destino "csv"
    And selecciona dia de ida
    And selecciona dia de regreso
    And hace clic en Buscar vuelos
    Then se mostraran los resultados

    Scenario: Buscar vuelo con destino inválido
    Given el usuario navega a la pagina de LATAM
    When selecciona el tipo de viaje "Ida y vuelta"
    And ingresa el origen "csv"
    And ingresa el destino invalido "ZZZ"
    Then mostrara un mensaje de error por destino no disponible

    Scenario: Buscar vuelo sin seleccionar fechas
    Given el usuario navega a la pagina de LATAM
    When selecciona el tipo de viaje "Ida y vuelta"
    And ingresa el origen "csv"
    And ingresa el destino "csv"
    And hace clic en Buscar vuelos
    Then mostrara un mensaje de advertencia indicando que la fecha es obligatoria

