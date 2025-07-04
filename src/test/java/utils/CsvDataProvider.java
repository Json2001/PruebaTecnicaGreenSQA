package utils;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.*;

public class CsvDataProvider {

    public static List<String> obtenerCiudadesDesdeCSV(String path) {
        List<String> ciudades = new ArrayList<>();
    
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] fila;
            boolean esPrimera = true;
            while ((fila = reader.readNext()) != null) {
                if (esPrimera) { esPrimera = false; continue; }
                System.out.println("Fila leída: " + Arrays.toString(fila));
                if (fila.length > 4) {
                    String ciudad = fila[4];
                    System.out.println("Ciudad encontrada: " + ciudad);
                    if (ciudad != null && !ciudad.isBlank()) {
                        ciudades.add(ciudad.trim());
                    }
                } else {
                    System.out.println("Fila sin suficiente columnas: " + Arrays.toString(fila));
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo el CSV: " + e.getMessage());
        }
    
        System.out.println("Ciudades leídas: " + ciudades);
        return ciudades;
    }

    public static String[] obtenerParOrigenDestinoAleatorio(String path) {
        List<String> ciudades = obtenerCiudadesDesdeCSV(path);
        Random rand = new Random();
        if (ciudades.size() < 2) return new String[]{"Bogo", "Lima"};
        String origen = ciudades.get(rand.nextInt(ciudades.size()));
        String destino;
        do {
            destino = ciudades.get(rand.nextInt(ciudades.size()));
        } while (origen.equals(destino));
        return new String[]{origen, destino};
    }
}
