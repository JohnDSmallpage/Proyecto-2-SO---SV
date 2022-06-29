/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.MainInterfaz;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

public class Funciones_dash {
    
    FileWriter escribir;
    PrintWriter linea;
        
    public String[] leerCSV() {
        String line;
        String text = "";
        File file = new File("test\\dash_telf.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        text += line + "\n";
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "ERROR AL LEER");
        }
        //String[] data = separarData(text.split("\n"));
        return text.split("\n");
    }
    
    public String[] separarData(String[] text) {
        if (text.length != 1) {
            String[] data = new String[text.length - 4];
            int j = 0;
            for (int i = 0; i < text.length; i++) {
                String[] line = text[i].split(",");
                if (line.length != 1) {
                    data[j] = line[1];
                    j++;
                }
            }
            return data;
        }
        return text;
    }
    
    public String[] generarData(String cant_telf_john,String cant_telf_ale) {
        
        String[] data = {cant_telf_john,cant_telf_ale};
        
        return data;
    }
    
    public void GuardarCSV(String cant_telf_john, String cant_telf_ale) {
        
        String[] data = generarData(cant_telf_john,cant_telf_ale);
        
        try {
            File file = new File("test\\dash_telf.csv");
            if (!file.exists()) {
                file.createNewFile();
                escribir = new FileWriter(file,true);
                linea = new PrintWriter(escribir);
                linea.println(Arrays.toString(data));
                linea.close();
                escribir.close();
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter("test\\dash_telf.csv"));
                bw.write("");
                bw.close();
                escribir = new FileWriter(file,true);
                linea = new PrintWriter(escribir);
                linea.print(Arrays.toString(data));
                linea.close();
                escribir.close();
                }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "ERROR AL LEER");
        }
    }
    
}
