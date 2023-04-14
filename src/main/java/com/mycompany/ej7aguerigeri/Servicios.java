/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej7aguerigeri;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ERICK
 */
public class Servicios {
    
    public static void main(String[] args) {
        // Inicializamos 
        ServiciosFicheros lecturaFichero = new ServiciosFicheros();
        
        // Guardamos los datos del fichero en una lista
        List<String> lecturaList = lecturaFichero.lectura("localizaciones.txt");
        
        System.out.println("------------------ Lectura fichero ---------------");
        // Bucle para comprobar el contenido
        for (String linea : lecturaList) {
            System.out.println(linea);
        }
        
        
        List<String> lecturaCardinales = lecturaFichero.listaCardinales(lecturaList);
        
        System.out.println("----------------- Lectura cardinales --------------");
        for (String cardinal : lecturaCardinales) {
            System.out.println(cardinal);
        }
        
        Map<String, Integer> mapContador = lecturaFichero.mapContador(lecturaCardinales);
        
        System.out.println("---------------- Contador MAP ---------------------");
        for (Map.Entry<String, Integer> entry : mapContador.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            System.out.println("Key: " + key + " - Value: " + val);            
        }
        
        lecturaFichero.guardarContador(mapContador, "contadorLocalizaciones.txt");
        
        List<String> lecturaMap = lecturaFichero.lectura("contadorLocalizaciones.txt");
        
        System.out.println("----------- MAP guardado ---------------");
        for (String string : lecturaMap) {
            System.out.println(string);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
