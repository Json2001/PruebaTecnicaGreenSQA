# ✈️ Prueba Técnica LATAM – Automatización con Selenium + Cucumber

nota: Extraer preferiblemente en el dico C, con el nombre de la carpeta como pruebaTecnica.

Este proyecto automatiza 3 escenarios de búsqueda de vuelos en la web de LATAM usando Java, Selenium, Cucumber y BDD.

---

## 📁 Estructura del proyecto

```
src/
├── test/java/
│   ├── pages/     # Page Objects
│   ├── utils/     # Lectura del CSV
│   ├── steps/     # Steps de Cucumber
│   └── runner/    # Test Runner
└── test/resources/
    ├── features/  # Archivos .feature
    └── data/      # CSV de entrada (si aplica)
```

---

## ✅ Requisitos

- Java 17
- Gradle o Maven
- Google Chrome
- Archivo CSV con datos de entrada ubicado en:  
  `C:\generar-datos\output\usuarios.csv`


---

## 🧪 Reportes

Al finalizar las pruebas, se genera un reporte en:

```
build/reports/tests/test/index.html
```

---

## 🚀 Cómo ejecutar

### Si usas Gradle:

```bash
gradle clean test
```

> También puedes ejecutar desde tu IDE con clic derecho sobre el runner.

---

## 📊 Escenarios automatizados

1. Buscar vuelo ida y vuelta con origen y destino válidos.
2. Buscar vuelo con destino inválido.
3. Buscar vuelo sin seleccionar fechas.

---

## ✍️ Autor

Yeison Castellanos



