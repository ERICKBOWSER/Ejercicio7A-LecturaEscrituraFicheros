/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej7aguerigeri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guerig
 */
public class lectura {
    // Localización del fichero
        private String fichero = "localizaciones.txt";
        
        // Variables para guardar los datos
        private String[] tokens;
        private String linea;
        
        
        
        
        public List<String> lectura(){
            
            List<String> listaLectura = new ArrayList();
            
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
            
            return listaLectura;
        }
        
        
}
