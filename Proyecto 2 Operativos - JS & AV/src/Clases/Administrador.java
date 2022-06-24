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
public class Administrador {
    
    public static void AdministrarIA(){
        if (MainInterfaz.contador==4 && Math.random()<0.7) {
            Telefono telf_john= new Telefono(0);
            Telefono telf_ale= new Telefono(1);
            MainInterfaz.contador=0;
            AdministrarColas(telf_john, telf_ale);
        }
    }
    
    public static void Agregartelf(){
        Telefono telf_john= new Telefono(0);
        Telefono telf_ale= new Telefono(1);
        AdministrarColas(telf_john, telf_ale);
    }
    
    public static void AdministrarColas(Telefono telf_john, Telefono telf_ale){
        if (telf_john.getCopas()<=1999) {
            MainInterfaz.cola_3_john.Encolar(telf_john);
        }
        else if (telf_john.getCopas()>=2000 && telf_john.getCopas()<=2999) {
            MainInterfaz.cola_2_john.Encolar(telf_john);
        }
        else{
            MainInterfaz.cola_1_john.Encolar(telf_john);
        }
        
        if (telf_ale.getCopas()<=1999) {
            MainInterfaz.cola_3_ale.Encolar(telf_ale);
        }
        else if (telf_ale.getCopas()>=2000 && telf_ale.getCopas()<=2999) {
            MainInterfaz.cola_2_ale.Encolar(telf_ale);
        }
        else{
            MainInterfaz.cola_1_ale.Encolar(telf_ale);
        }
        
        if (Math.random()<=0.4) {
            SalirDeRefuerzo();
        }
        
        Administrador.Actualizarpantalla();
    }
    
    public static void AdministrarRefuerzo(Telefono telf_john, Telefono telf_ale){
        MainInterfaz.cola_refuerzo_john.Encolar(telf_john);
        MainInterfaz.cola_refuerzo_ale.Encolar(telf_ale);
    }
    
    
    public static void SalirDeRefuerzo(){
        
        if(!MainInterfaz.cola_refuerzo_ale.esta_vacia() && !MainInterfaz.cola_refuerzo_john.esta_vacia()){
        Telefono telf_john= MainInterfaz.cola_refuerzo_john.Leer_cabeza();
        Telefono telf_ale= MainInterfaz.cola_refuerzo_ale.Leer_cabeza();
        
        MainInterfaz.cola_refuerzo_john.Desencolar();
        MainInterfaz.cola_refuerzo_ale.Desencolar();
        
        if (telf_john.getCopas()<=1999) {
            MainInterfaz.cola_3_john.Encolar(telf_john);
        }
        else if (telf_john.getCopas()>=2000 && telf_john.getCopas()<=2999) {
            MainInterfaz.cola_2_john.Encolar(telf_john);
        }
        else{
            MainInterfaz.cola_1_john.Encolar(telf_john);
        }
        
        if (telf_ale.getCopas()<=1999) {
            MainInterfaz.cola_3_ale.Encolar(telf_ale);
        }
        else if (telf_ale.getCopas()>=2000 && telf_ale.getCopas()<=2999) {
            MainInterfaz.cola_2_ale.Encolar(telf_ale);
        }
        else{
            MainInterfaz.cola_1_ale.Encolar(telf_ale);
        }
    }
    }
    
    public static void Admindesencola(Telefono telf_john, Telefono telf_ale){
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
    }
    
    public static void Adminescoger() throws InterruptedException{
        if (MainInterfaz.cola_1_john.esta_vacia() && MainInterfaz.cola_1_ale.esta_vacia()){
            if(MainInterfaz.cola_2_john.esta_vacia() && MainInterfaz.cola_2_ale.esta_vacia()){
                if(MainInterfaz.cola_3_john.esta_vacia() && MainInterfaz.cola_3_ale.esta_vacia()){
                    
                }
                else{
                    Telefono telf_john = MainInterfaz.cola_3_john.Leer_cabeza();
                    Telefono telf_ale = MainInterfaz.cola_3_ale.Leer_cabeza();
                    IA.decision(telf_john, telf_ale);
                    TimeUnit.SECONDS.sleep((long) Integer.parseInt(MainInterfaz.tiempo.getText()));
                    Administrador.AdministrarIA();
                }
            }
            
            else{
                Telefono telf_john = MainInterfaz.cola_2_john.Leer_cabeza();
                Telefono telf_ale = MainInterfaz.cola_2_ale.Leer_cabeza();
                IA.decision(telf_john, telf_ale);
                TimeUnit.SECONDS.sleep((long) Integer.parseInt(MainInterfaz.tiempo.getText()));
                Administrador.AdministrarIA();
            }
        }
        
        else{
            Telefono telf_john = MainInterfaz.cola_1_john.Leer_cabeza();
            Telefono telf_ale = MainInterfaz.cola_1_ale.Leer_cabeza();
            IA.decision(telf_john, telf_ale);
            TimeUnit.SECONDS.sleep((long) Integer.parseInt(MainInterfaz.tiempo.getText()));
            Administrador.AdministrarIA();
        }
        
        
        
    }
    
    public static void Actualizarpantalla(){
        String cola1j = MainInterfaz.cola_1_john.Recorrer();
        String cola2j = MainInterfaz.cola_2_john.Recorrer();
        String cola3j = MainInterfaz.cola_3_john.Recorrer();
        String colarj = MainInterfaz.cola_refuerzo_john.Recorrer();
        String cola1a = MainInterfaz.cola_1_ale.Recorrer();
        String cola2a = MainInterfaz.cola_2_ale.Recorrer();
        String cola3a = MainInterfaz.cola_3_ale.Recorrer();
        String colara = MainInterfaz.cola_refuerzo_ale.Recorrer();
        
        MainInterfaz.cola1john.setText(cola1j);
        MainInterfaz.cola2john.setText(cola2j);
        MainInterfaz.cola3john.setText(cola3j);
        MainInterfaz.colarefuerzojohn.setText(colarj);
        MainInterfaz.cola1ale.setText(cola1a);
        MainInterfaz.cola2ale.setText(cola2a);
        MainInterfaz.cola3ale.setText(cola3a);
        MainInterfaz.colarefuerzoale.setText(colara);
    }
    
    
    
    
    
}
