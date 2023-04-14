/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej7aguerigeri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author guerig
 */
public class ServiciosFicheros {
        
        // Variable para guardar los datos
        private String linea;
        
        // No creamos constructor ya que usamos el que hay por defecto
        
        // Lectura de fichero
        public List<String> lectura(String fichero){
            
            List<String> listaLectura = new ArrayList();
            
            try(Scanner datos = new Scanner(new File(fichero), "UTF-8")){
            
            // bucle para recorrer cada linea 
            while(datos.hasNextLine()){
                // Guardar la línea completa
                linea = datos.nextLine();
                
                // Guardar en la List
                listaLectura.add(linea); 
            }
            } catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            
            return listaLectura;
        }
        
        
        public List<String> listaCardinales(List<String> list){
            
            List<String> resultado = new ArrayList();
            
            String regex = "N|S|E|O";
            
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;
            
            
            for (int i = 0; i < list.size(); i++) {
                
                matcher = pattern.matcher(list.get(i));
                
                while(matcher.find()){
                    resultado.add(matcher.group());
                }
                
            }
            
            return resultado;
            
        }
        
        public Map<String, Integer> mapContador(List<String> list){
            
            Map<String, Integer> resultado = new TreeMap();
            
            Integer n = 0;
            Integer s = 0;
            Integer e = 0;
            Integer o = 0;
            
            for (int i = 0; i < list.size(); i++) {
                
                if(list.get(i).equalsIgnoreCase("n")){
                    n++;
                }else if(list.get(i).equalsIgnoreCase("s")){
                    s++;
                }else if(list.get(i).equalsIgnoreCase("e")){
                    e++;
                }else if(list.get(i).equalsIgnoreCase("o")){
                    o++;
                }
                
            }
            
            resultado.put("N", n);
            resultado.put("S", s);
            resultado.put("E", e);
            resultado.put("O", o);
            
            return resultado;  
            
        }
        
        // Escritura de fichero
        public void guardarContador(Map<String, Integer> map, String contadorFichero){           
            
            String tmp;
            
            try(BufferedWriter flujo = new BufferedWriter(new FileWriter(contadorFichero))){
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    Object key = entry.getKey();
                    Object val = entry.getValue();
                   
                    tmp = key + "-" + val;
                    // Escribimos
                    flujo.write(tmp);
                    
                    // Salto de linea
                    flujo.newLine();
                    
                }
                // Guardar cambios en el disco
                flujo.flush();
                
            } catch(IOException e){
                System.out.println(e.getMessage());
            }
            
            
        }
        
        
}
