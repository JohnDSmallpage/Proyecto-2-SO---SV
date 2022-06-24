/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.MainInterfaz;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnd
 */
public class IA extends Thread {

    public IA(){
        
    }
    
    @Override
    public void run(){
        while (MainInterfaz.encendido!=false) {            
            Administrador.Adminescoger();
            
        }
        
    }
    
    public static void decision(Telefono telf_john, Telefono telf_ale)  {
        MainInterfaz.contador+=2;
        telf_john.contador_tel=0;
        telf_ale.contador_tel=0;
        double valor = Math.random();
        
        String cola1j = MainInterfaz.cola_1_john.Recorrer();
        String cola2j = MainInterfaz.cola_2_john.Recorrer();
        String cola3j = MainInterfaz.cola_3_john.Recorrer();
        String colarj = MainInterfaz.cola_refuerzo_john.Recorrer();
        String cola1a = MainInterfaz.cola_1_ale.Recorrer();
        String cola2a = MainInterfaz.cola_2_ale.Recorrer();
        String cola3a = MainInterfaz.cola_3_ale.Recorrer();
        String colara = MainInterfaz.cola_refuerzo_ale.Recorrer();
        
        MainInterfaz.cola1john.setText(cola1j);
        System.out.println(cola1j);
        MainInterfaz.cola2john.setText(cola2j);
        System.out.println(cola2j);
        MainInterfaz.cola3john.setText(cola3j);
        System.out.println(cola3j);
        MainInterfaz.colarefuerzojohn.setText(colarj);
        System.out.println(colarj);
        MainInterfaz.cola1ale.setText(cola1a);
        System.out.println(cola1a);
        MainInterfaz.cola2ale.setText(cola2a);
        System.out.println(cola2a);
        MainInterfaz.cola3ale.setText(cola3a);
        System.out.println(cola3a);
        MainInterfaz.colarefuerzoale.setText(colara);
        System.out.println(colara);
        
        Administrador.MoverTelefonos();
        
        cola1j = MainInterfaz.cola_1_john.Recorrer();
        cola2j = MainInterfaz.cola_2_john.Recorrer();
        cola3j = MainInterfaz.cola_3_john.Recorrer();
        colarj = MainInterfaz.cola_refuerzo_john.Recorrer();
        cola1a = MainInterfaz.cola_1_ale.Recorrer();
        cola2a = MainInterfaz.cola_2_ale.Recorrer();
        cola3a = MainInterfaz.cola_3_ale.Recorrer();
        colara = MainInterfaz.cola_refuerzo_ale.Recorrer();
        
        
        
        //Administrador.Admindesencola(telf_john, telf_ale);
        
        MainInterfaz.cola1john.setText(cola1j);
        System.out.println(cola1j);
        MainInterfaz.cola2john.setText(cola2j);
        System.out.println(cola2j);
        MainInterfaz.cola3john.setText(cola3j);
        System.out.println(cola3j);
        MainInterfaz.colarefuerzojohn.setText(colarj);
        System.out.println(colarj);
        MainInterfaz.cola1ale.setText(cola1a);
        System.out.println(cola1a);
        MainInterfaz.cola2ale.setText(cola2a);
        System.out.println(cola2a);
        MainInterfaz.cola3ale.setText(cola3a);
        System.out.println(cola3a);
        MainInterfaz.colarefuerzoale.setText(colara);
        System.out.println(colara);
        
        
        
        if (valor <= 0.4) {
            try {
                batalla(telf_john, telf_ale);
            } catch (InterruptedException ex) {
                Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (valor <= 0.73 && valor > 0.4) {
            refuerzo(telf_john, telf_ale);
        } else if (valor <= 1 && valor > 0.73) {
            empate(telf_john, telf_ale);
        }
    }

    public static void batalla(Telefono telf_john, Telefono telf_ale) throws InterruptedException{
        MainInterfaz.ganador.setText("");
        int[] mazo_john = new int[4];
        int[] mazo_ale = new int[4];
        for (int i = 0; i < 4; i++) {
            mazo_john[i] = MainInterfaz.cartas[(int) Math.floor(Math.random() * (7 - 0 + 1) + 0)];
            mazo_ale[i] = MainInterfaz.cartas[(int) Math.floor(Math.random() * (7 - 0 + 1) + 0)];

        }

        int score_john = 0;
        int score_ale = 0;
        
        

        for (int j = 0; j < 4; j++) {
            MainInterfaz.inteligencia.setText("COMPITIENDO");
            score_john += mazo_john[j];
            score_ale += mazo_ale[j];
            MainInterfaz.score1.setText(String.valueOf(score_john));
            MainInterfaz.score2.setText(String.valueOf(score_ale));
            
            MainInterfaz.fondo1.setVisible(true);
            MainInterfaz.carta11.setVisible(false);
            MainInterfaz.carta21.setVisible(false);
            MainInterfaz.carta31.setVisible(false);
            MainInterfaz.carta41.setVisible(false);
            MainInterfaz.carta51.setVisible(false);
            MainInterfaz.carta61.setVisible(false);
            MainInterfaz.carta71.setVisible(false);
            MainInterfaz.carta81.setVisible(false);
            
            MainInterfaz.fondo2.setVisible(true);
            MainInterfaz.carta12.setVisible(false);
            MainInterfaz.carta22.setVisible(false);
            MainInterfaz.carta32.setVisible(false);
            MainInterfaz.carta42.setVisible(false);
            MainInterfaz.carta52.setVisible(false);
            MainInterfaz.carta62.setVisible(false);
            MainInterfaz.carta72.setVisible(false);
            MainInterfaz.carta82.setVisible(false);
            
            if (mazo_john[j] == 1){
                MainInterfaz.fondo1.setVisible(false);
                MainInterfaz.carta11.setVisible(true);
            }
            
            if (mazo_john[j] == 2){
                MainInterfaz.fondo1.setVisible(false);
                MainInterfaz.carta21.setVisible(true);
            }
            
            if (mazo_john[j] == 3){
                MainInterfaz.fondo1.setVisible(false);
                MainInterfaz.carta31.setVisible(true);
            }
            
            if (mazo_john[j] == 4){
                MainInterfaz.fondo1.setVisible(false);
                MainInterfaz.carta41.setVisible(true);
            }
            
            if (mazo_john[j] == 5){
                MainInterfaz.fondo1.setVisible(false);
                MainInterfaz.carta51.setVisible(true);
            }
            
            if (mazo_john[j] == 6){
                MainInterfaz.fondo1.setVisible(false);
                MainInterfaz.carta61.setVisible(true);
            }
            
            if (mazo_john[j] == 7){
                MainInterfaz.fondo1.setVisible(false);
                MainInterfaz.carta71.setVisible(true);
            }
            
            if (mazo_john[j] == 8){
                MainInterfaz.fondo1.setVisible(false);
                MainInterfaz.carta81.setVisible(true);
            }
            
            if (mazo_ale[j] == 1){
                MainInterfaz.fondo2.setVisible(false);
                MainInterfaz.carta12.setVisible(true);
            }
            
            if (mazo_ale[j] == 2){
                MainInterfaz.fondo2.setVisible(false);
                MainInterfaz.carta22.setVisible(true);
            }
            
            if (mazo_ale[j] == 3){
                MainInterfaz.fondo2.setVisible(false);
                MainInterfaz.carta32.setVisible(true);
            }
            
            if (mazo_ale[j] == 4){
                MainInterfaz.fondo2.setVisible(false);
                MainInterfaz.carta42.setVisible(true);
            }
            
            if (mazo_ale[j] == 5){
                MainInterfaz.fondo2.setVisible(false);
                MainInterfaz.carta52.setVisible(true);
            }
            
            if (mazo_ale[j] == 6){
                MainInterfaz.fondo2.setVisible(false);
                MainInterfaz.carta62.setVisible(true);
            }
            
            if (mazo_ale[j] == 7){
                MainInterfaz.fondo2.setVisible(false);
                MainInterfaz.carta72.setVisible(true);
            }
            
            if (mazo_ale[j] == 8){
                MainInterfaz.fondo2.setVisible(false);
                MainInterfaz.carta82.setVisible(true);
            }
            long lnum= Integer.parseInt(MainInterfaz.tiempo.getText())/4;
            Thread.sleep(lnum*1000);
        }
        
        MainInterfaz.fondo1.setVisible(true);
        MainInterfaz.fondo2.setVisible(true);
        
        if (score_john>score_ale) {
            MainInterfaz.vendidos_john+=1;
            MainInterfaz.ganador.setText("Teléfono de la Planta 1");
        }
        else if(score_john==score_ale){
            if (telf_john.copas>telf_ale.copas) {
                MainInterfaz.vendidos_ale+=1;
                MainInterfaz.ganador.setText("Teléfono de la Planta 2");
            }
            else if(telf_john.copas==telf_ale.copas){
                int desempate= (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
                if (desempate==0) {
                    MainInterfaz.vendidos_john+=1;
                    MainInterfaz.ganador.setText("Teléfono de la Planta 1");
                }
                else{
                    MainInterfaz.vendidos_ale+=1;
                    MainInterfaz.ganador.setText("Teléfono de la Planta 2");
                }
            }
            else{
                MainInterfaz.vendidos_john+=1;
                MainInterfaz.ganador.setText("Teléfono de la Planta 1");
            }
        }
        else{
            MainInterfaz.vendidos_ale+=1;
            MainInterfaz.ganador.setText("Teléfono de la Planta 2");
        }
        
        MainInterfaz.score1.setText("0");
        MainInterfaz.score2.setText("0");
        

    }

    public static void empate(Telefono telf_john, Telefono telf_ale){
        long lnum= Integer.parseInt(MainInterfaz.tiempo.getText());
        MainInterfaz.inteligencia.setText("Analizando...");
        try {
            Thread.sleep(lnum*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
        Administrador.AdministrarColas(telf_john, telf_ale);
    }

    public static void refuerzo(Telefono telf_john, Telefono telf_ale){
        long lnum= Integer.parseInt(MainInterfaz.tiempo.getText());
        MainInterfaz.inteligencia.setText("Analizando...");
        try {
            Thread.sleep(lnum*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
        Administrador.AdministrarRefuerzo(telf_john, telf_ale);
    }

}
