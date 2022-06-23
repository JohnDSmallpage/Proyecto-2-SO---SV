/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.MainInterfaz;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author johnd
 */
public class IA {

    public void decision(Telefono telf_john, Telefono telf_ale) throws InterruptedException {
        MainInterfaz.contador+=2;
        double valor = Math.random();
        if (valor <= 0.4) {
            batalla(telf_john, telf_ale);
        } else if (valor <= 0.73 && valor > 0.4) {
            refuerzo(telf_john, telf_ale);
        } else if (valor <= 1 && valor > 0.73) {
            empate(telf_john, telf_ale);
        }
        
        
        
    }

    public void batalla(Telefono telf_john, Telefono telf_ale) throws InterruptedException {
        
        if (telf_john.getCopas()<=1999) {
            MainInterfaz.cola_3_john.Desencolar();
        }
        else if (telf_john.getCopas()>=2000 && telf_john.getCopas()<=2999) {
            MainInterfaz.cola_2_john.Desencolar();
        }
        else{
            MainInterfaz.cola_1_john.Desencolar();
        }
        
        if (telf_ale.getCopas()<=1999) {
            MainInterfaz.cola_3_ale.Desencolar();
        }
        else if (telf_ale.getCopas()>=2000 && telf_ale.getCopas()<=2999) {
            MainInterfaz.cola_2_ale.Desencolar();
        }
        else{
            MainInterfaz.cola_1_ale.Desencolar();
        }
        
        if (Math.random()<=0.4) {
            Administrador.SalirDeRefuerzo();
        }
        
        int[] mazo_john = new int[4];
        int[] mazo_ale = new int[4];
        for (int i = 0; i < 4; i++) {
            mazo_john[i] = MainInterfaz.cartas[(int) Math.floor(Math.random() * (7 - 0 + 1) + 0)];
            mazo_ale[i] = MainInterfaz.cartas[(int) Math.floor(Math.random() * (7 - 0 + 1) + 0)];

        }

        int score_john = 0;
        int score_ale = 0;
        
        

        for (int j = 0; j < 4; j++) {
            score_john += mazo_john[j];
            score_ale += mazo_ale[j];
            
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
            TimeUnit.SECONDS.sleep((long) Integer.parseInt(MainInterfaz.tiempo.getText())/4);
        }
        
        MainInterfaz.fondo1.setVisible(true);
        MainInterfaz.fondo2.setVisible(true);
        
        if (score_john>score_ale) {
            MainInterfaz.vendidos_john+=1;
        }
        else if(score_john==score_ale){
            if (telf_john.copas>telf_ale.copas) {
                MainInterfaz.vendidos_ale+=1;
            }
            else if(telf_john.copas==telf_ale.copas){
                int desempate= (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
                if (desempate==0) {
                    MainInterfaz.vendidos_john+=1;
                }
                else{
                    MainInterfaz.vendidos_ale+=1;
                }
            }
            else{
                MainInterfaz.vendidos_john+=1;
            }
        }
        else{
            MainInterfaz.vendidos_ale+=1;
        }

    }

    public void empate(Telefono telf_john, Telefono telf_ale) {
        Administrador.AdministrarColas(telf_john, telf_ale);
    }

    public void refuerzo(Telefono telf_john, Telefono telf_ale) {
        Administrador.AdministrarRefuerzo(telf_john, telf_ale);
    }

}
