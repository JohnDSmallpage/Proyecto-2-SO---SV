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
        double valor= Math.random();
        System.out.println(MainInterfaz.contador);
        System.out.println(valor);
        if (MainInterfaz.contador==4 && valor<0.7) {
            MainInterfaz.ID_global+=1;
            Telefono telf_john= new Telefono(0);
            Telefono telf_ale= new Telefono(1);
            MainInterfaz.contador=0;
            AdministrarColas(telf_john, telf_ale);
        }
    }
    
    public static void Agregartelf(){
        MainInterfaz.ID_global+=1;
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
    }
    
    public static void AdministrarRefuerzo(Telefono telf_john, Telefono telf_ale){
        MainInterfaz.cola_refuerzo_john.Encolar(telf_john);
        MainInterfaz.cola_refuerzo_ale.Encolar(telf_ale);
        
        String colarj= MainInterfaz.cola_refuerzo_john.recorrido();
        String colara= MainInterfaz.cola_refuerzo_ale.recorrido();
        
        MainInterfaz.colarefuerzojohn.setText(colarj);
        MainInterfaz.colarefuerzoale.setText(colara);
    }
    
    
    public static void SalirDeRefuerzo(){
        if (MainInterfaz.cola_refuerzo_john.esta_vacia() || MainInterfaz.cola_refuerzo_ale.esta_vacia() ) {
            return;
        }
        Telefono telf_john= MainInterfaz.cola_refuerzo_john.Leer_cabeza();
        Telefono telf_ale= MainInterfaz.cola_refuerzo_ale.Leer_cabeza();
        
        MainInterfaz.cola_refuerzo_john.Desencolar();
        MainInterfaz.cola_refuerzo_ale.Desencolar();
        
        String colarj= MainInterfaz.cola_refuerzo_john.recorrido();
        String colara= MainInterfaz.cola_refuerzo_ale.recorrido();
        
        MainInterfaz.colarefuerzojohn.setText(colarj);
        MainInterfaz.colarefuerzoale.setText(colara);
        
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
    
    public static void Adminescoger(){
        if (MainInterfaz.primera==false) {
            Telefono telf_john= new Telefono(0);
            Telefono telf_ale= new Telefono(1);
            Administrador.Agregartelf();
            IA.decision(telf_john, telf_ale);
            MainInterfaz.primera=true;
        }
        
        
        Telefono telf_john= null;
        Telefono telf_ale= null;
        if (!MainInterfaz.cola_1_john.esta_vacia()) {
            telf_john = MainInterfaz.cola_1_john.Leer_cabeza();
            MainInterfaz.cola_1_john.Desencolar();
        }
        else if(!MainInterfaz.cola_2_john.esta_vacia()){
            telf_john = MainInterfaz.cola_2_john.Leer_cabeza();
            MainInterfaz.cola_2_john.Desencolar();
        }
        else if(!MainInterfaz.cola_3_john.esta_vacia()){
            telf_john = MainInterfaz.cola_3_john.Leer_cabeza();
            MainInterfaz.cola_3_john.Desencolar();
        }
        
        
        if(!MainInterfaz.cola_1_ale.esta_vacia()){
            telf_ale = MainInterfaz.cola_1_ale.Leer_cabeza();
            MainInterfaz.cola_1_ale.Desencolar();
        }
        else if(!MainInterfaz.cola_2_ale.esta_vacia()){
           telf_ale = MainInterfaz.cola_2_ale.Leer_cabeza();
           MainInterfaz.cola_2_ale.Desencolar(); 
        }
        else if(!MainInterfaz.cola_3_ale.esta_vacia()){
           telf_ale = MainInterfaz.cola_3_ale.Leer_cabeza();
           MainInterfaz.cola_3_ale.Desencolar(); 
        }
        
        if (telf_john==null || telf_ale==null) {
            Agregartelf();
            return;
        }
        
        IA.decision(telf_john, telf_ale);
        Administrador.AdministrarIA();
        
        
        
        
//        if (MainInterfaz.cola_1_john.esta_vacia() && MainInterfaz.cola_1_ale.esta_vacia()){
//            if(MainInterfaz.cola_2_john.esta_vacia() && MainInterfaz.cola_2_ale.esta_vacia()){
//                if(MainInterfaz.cola_3_john.esta_vacia() && MainInterfaz.cola_3_ale.esta_vacia()){
//                    
//                }
//                else{
//                    Telefono telf_john = MainInterfaz.cola_3_john.Leer_cabeza();
//                    Telefono telf_ale = MainInterfaz.cola_3_ale.Leer_cabeza();
//                    MainInterfaz.cola_3_john.Desencolar();
//                    MainInterfaz.cola_3_ale.Desencolar();
//                    IA.decision(telf_john, telf_ale);
//                    //TimeUnit.SECONDS.sleep((long) Integer.parseInt(MainInterfaz.tiempo.getText()));
//                    Administrador.AdministrarIA();
//                }
//            }
//            
//            else{
//                Telefono telf_john = MainInterfaz.cola_2_john.Leer_cabeza();
//                Telefono telf_ale = MainInterfaz.cola_2_ale.Leer_cabeza();
//                MainInterfaz.cola_2_john.Desencolar();
//                MainInterfaz.cola_2_ale.Desencolar();
//                IA.decision(telf_john, telf_ale);
//                //TimeUnit.SECONDS.sleep((long) Integer.parseInt(MainInterfaz.tiempo.getText()));
//                Administrador.AdministrarIA();
//            }
//        }
//        
//        else{
//            Telefono telf_john = MainInterfaz.cola_1_john.Leer_cabeza();
//            Telefono telf_ale = MainInterfaz.cola_1_ale.Leer_cabeza();
//            MainInterfaz.cola_1_john.Desencolar();
//            MainInterfaz.cola_1_ale.Desencolar();
//            IA.decision(telf_john, telf_ale);
//            //TimeUnit.SECONDS.sleep((long) Integer.parseInt(MainInterfaz.tiempo.getText()));
//            Administrador.AdministrarIA();
//        }
        
        
        
    }
    
    public static void MoverTelefonos(){
        if (!MainInterfaz.cola_2_john.esta_vacia()) {
            Telefono telf_john= MainInterfaz.cola_2_john.Mover();
            if (telf_john!=null) {
                telf_john.contador_tel=0;
                MainInterfaz.cola_1_john.Encolar(telf_john);
            }
        }
        if (!MainInterfaz.cola_3_john.esta_vacia()) {
            Telefono telf_john= MainInterfaz.cola_3_john.Mover();
            if (telf_john!=null) {
                telf_john.contador_tel=0;
                MainInterfaz.cola_2_john.Encolar(telf_john);
            }
        }
        
        if (!MainInterfaz.cola_2_ale.esta_vacia()) {
            Telefono telf_ale= MainInterfaz.cola_2_ale.Mover();
            if (telf_ale!=null) {
                telf_ale.contador_tel=0;
                MainInterfaz.cola_1_ale.Encolar(telf_ale);
            }
        }
        
        if (!MainInterfaz.cola_3_ale.esta_vacia()) {
            Telefono telf_ale= MainInterfaz.cola_3_ale.Mover();
            if (telf_ale!=null) {
                telf_ale.contador_tel=0;
                MainInterfaz.cola_2_ale.Encolar(telf_ale);
            }
        }
        
        
    }
    
    
    
}
