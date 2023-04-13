/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ej7aguerigeri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author guerig
 */
public class Localizaciones {
    public static void main(String[] args) {
        
        // Localización del fichero
        String fichero = "localizaciones.txt";
        
        // Variables para guardar los datos
        String[] tokens;
        String linea;
        
        System.out.println("Lectura de fichero: " + fichero);
        
        try(Scanner datos = new Scanner(new File(fichero), "UTF-8")){
            
            // bucle para recorrer cada linea 
            while(datos.hasNextLine()){
                // Guardar la línea completa
                linea = datos.nextLine();
                
                tokens = linea.split(":");
                for (String token : tokens) {
                    System.out.println(token + "\t");
                }
                System.out.println();  
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
                       
            
            
            
        }
        
        
   
}
