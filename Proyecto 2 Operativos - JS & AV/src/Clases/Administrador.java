/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.MainInterfaz;

/**
 *
 * @author johnd
 */
public class Administrador {
    
    public static void AdministrarIA(){
        double valor= Math.random();
        System.out.println(MainInterfaz.contador);
        System.out.println(valor);
        if (MainInterfaz.contador>=4 && valor<0.7) {
            MainInterfaz.ID_global+=1;
            Telefono telf_john= new Telefono(0);
            Telefono telf_ale= new Telefono(1);
            MainInterfaz.contador=0;
            if (MainInterfaz.cola_1_john.esta_vacia() && MainInterfaz.cola_2_john.esta_vacia() && MainInterfaz.cola_3_john.esta_vacia() && MainInterfaz.cola_1_ale.esta_vacia() && MainInterfaz.cola_2_ale.esta_vacia() && MainInterfaz.cola_3_ale.esta_vacia()) {
                MainInterfaz.colasvacias.setText("Colas vacías\n Se crea tlf y pasa a IA");
            }
            else{
                MainInterfaz.colasvacias.setText("Se agrega tlf");
            }
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
        ImprimirPantalla();
        
        if (Math.random()<=0.4) {
            SalirDeRefuerzo();
        }
        ImprimirPantalla();
    }
    
    public static void AdministrarRefuerzo(Telefono telf_john, Telefono telf_ale){
        MainInterfaz.cola_refuerzo_john.Encolar(telf_john);
        MainInterfaz.cola_refuerzo_ale.Encolar(telf_ale);
        ImprimirPantalla();
        
        
        
        
    }
    
    
    public static void SalirDeRefuerzo(){
        if (MainInterfaz.cola_refuerzo_john.esta_vacia() || MainInterfaz.cola_refuerzo_ale.esta_vacia() ) {
            return;
        }
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
            return;
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
            if (Math.random()<0.4) {
                SalirDeRefuerzo();
            }
            System.out.println("AGREGANDO TELF");
            MainInterfaz.inteligencia.setText("Agregando tlf...");
            MainInterfaz.colasvacias.setText("Colas vacías\n Se crea tlf y pasa a IA");
            return;
        }
        ImprimirPantalla();
        
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
        
     
            while (!MainInterfaz.cola_2_john.esta_vacia()) {                
                if (MainInterfaz.cola_2_john.Leer_cabeza().contador_tel==8) {
                    Telefono telf_john= MainInterfaz.cola_2_john.Leer_cabeza();
                    telf_john.contador_tel=0;
                    MainInterfaz.cola_2_john.Desencolar();
                    MainInterfaz.cola_1_john.Encolar(telf_john);
                    MainInterfaz.movejohn.setText("Se movió cola 2 " + telf_john.getID());
                    ImprimirPantalla();
                }
                else{
                    break;
                }
            }
        
        
            while (!MainInterfaz.cola_3_john.esta_vacia()) {                
                if (MainInterfaz.cola_3_john.Leer_cabeza().contador_tel==8) {
                    Telefono telf_john= MainInterfaz.cola_3_john.Leer_cabeza();
                    telf_john.contador_tel=0;
                    MainInterfaz.cola_3_john.Desencolar();
                    MainInterfaz.cola_2_john.Encolar(telf_john);
                    MainInterfaz.movejohn.setText("Se movió cola 3 " + telf_john.getID());
                    ImprimirPantalla();
                }
                else{
                    break;
                }
            }
        
        
            while (!MainInterfaz.cola_2_ale.esta_vacia()) {                
                if (MainInterfaz.cola_2_ale.Leer_cabeza().contador_tel==8) {
                    Telefono telf_ale= MainInterfaz.cola_2_ale.Leer_cabeza();
                    telf_ale.contador_tel=0;
                    MainInterfaz.cola_2_ale.Desencolar();
                    MainInterfaz.cola_1_ale.Encolar(telf_ale);
                    MainInterfaz.moveale.setText("Se movió cola 2 " + telf_ale.getID());
                    ImprimirPantalla();
                }
                else{
                    break;
                }
            }
        
        
        
            while (!MainInterfaz.cola_3_ale.esta_vacia()) {                
                if (MainInterfaz.cola_3_ale.Leer_cabeza().contador_tel==8) {
                    Telefono telf_ale= MainInterfaz.cola_3_ale.Leer_cabeza();
                    telf_ale.contador_tel=0;
                    MainInterfaz.cola_3_ale.Desencolar();
                    MainInterfaz.cola_2_ale.Encolar(telf_ale);
                    MainInterfaz.moveale.setText("Se movió cola 3 " + telf_ale.getID());
                    ImprimirPantalla();
                }
                else{
                    break;
                }
            }
        
        
//        if (!MainInterfaz.cola_2_john.esta_vacia()) {
//            Cola cola_2_j= MainInterfaz.cola_2_john.Mover();
//            if (!cola_2_j.esta_vacia()) {
//                for (int i = 0; i < cola_2_j.getSize(); i++) {
//                    Telefono telf_john= cola_2_j.Leer_cabeza();
//                    cola_2_j.Desencolar();
//                    MainInterfaz.cola_2_john.Desencolar();
//                    telf_john.contador_tel=0;
//                    MainInterfaz.cola_1_john.Encolar(telf_john);
//                    MainInterfaz.movejohn.setText("Se movió cola 2 " + telf_john.getID());
//                    ImprimirPantalla();
//                }
//                
//                 
//                
//            }
//        }
//        
//        if (!MainInterfaz.cola_3_john.esta_vacia()) {
//            Cola cola_3_j= MainInterfaz.cola_3_john.Mover();
//            if (!cola_3_j.esta_vacia()) {
//                for (int i = 0; i < cola_3_j.getSize(); i++) {
//                    Telefono telf_john= cola_3_j.Leer_cabeza();
//                    cola_3_j.Desencolar();
//                    MainInterfaz.cola_3_john.Desencolar();
//                    telf_john.contador_tel=0;
//                    MainInterfaz.cola_2_john.Encolar(telf_john);
//                    MainInterfaz.movejohn.setText("Se movió cola 3 " + telf_john.getID());
//                    ImprimirPantalla();
//                }
//                
//                 
//                
//            }
//        }
//        
//        if (!MainInterfaz.cola_2_ale.esta_vacia()) {
//            Cola cola_2_a= MainInterfaz.cola_2_ale.Mover();
//            if (!cola_2_a.esta_vacia()) {
//                for (int i = 0; i < cola_2_a.getSize(); i++) {
//                    Telefono telf_ale= cola_2_a.Leer_cabeza();
//                    cola_2_a.Desencolar();
//                    MainInterfaz.cola_2_ale.Desencolar();;
//                    telf_ale.contador_tel=0;
//                    MainInterfaz.cola_1_ale.Encolar(telf_ale);
//                    MainInterfaz.moveale.setText("Se movió cola 2 " + telf_ale.getID());
//                    ImprimirPantalla();
//                }
//                
//                 
//                
//            }
//        }
//        
//        if (!MainInterfaz.cola_3_ale.esta_vacia()) {
//            Cola cola_3_a= MainInterfaz.cola_3_ale.Mover();
//            if (!cola_3_a.esta_vacia()) {
//                for (int i = 0; i < cola_3_a.getSize(); i++) {
//                    Telefono telf_ale= cola_3_a.Leer_cabeza();
//                    cola_3_a.Desencolar();
//                    MainInterfaz.cola_3_ale.Desencolar();
//                    telf_ale.contador_tel=0;
//                    MainInterfaz.cola_2_ale.Encolar(telf_ale);
//                    MainInterfaz.moveale.setText("Se movió cola 3 " + telf_ale.getID());
//                    ImprimirPantalla(); 
//                    
//                }
//                
//                
//                
//            }
//        }
        
        
        
        
//        if (!MainInterfaz.cola_2_john.esta_vacia()) {
//             telf_john= MainInterfaz.cola_2_john.Mover();
//            if (telf_john!=null) {
//                telf_john.contador_tel=0;
//                MainInterfaz.cola_1_john.Encolar(telf_john);
//                MainInterfaz.movejohn.setText("Se movió cola 2 " + telf_john.getID());
//                ImprimirPantalla();
//                
//                
//            }
//        }
//        if (!MainInterfaz.cola_3_john.esta_vacia()) {
//            Telefono telf_john= MainInterfaz.cola_3_john.Mover();
//            if (telf_john!=null) {
//                telf_john.contador_tel=0;
//                MainInterfaz.cola_2_john.Encolar(telf_john);
//                MainInterfaz.movejohn.setText("Se movió cola 3 " + telf_john.getID());
//                ImprimirPantalla();
//            }
//        }
//        
//        if (!MainInterfaz.cola_2_ale.esta_vacia()) {
//            Telefono telf_ale= MainInterfaz.cola_2_ale.Mover();
//            if (telf_ale!=null) {
//                telf_ale.contador_tel=0;
//                MainInterfaz.cola_1_ale.Encolar(telf_ale);
//                MainInterfaz.moveale.setText("Se movió cola 2 " + telf_ale.getID());
//                ImprimirPantalla();
//            }
//        }
//        
//        if (!MainInterfaz.cola_3_ale.esta_vacia()) {
//            Telefono telf_ale= MainInterfaz.cola_3_ale.Mover();
//            if (telf_ale!=null) {
//                telf_ale.contador_tel=0;
//                MainInterfaz.cola_2_ale.Encolar(telf_ale);
//                MainInterfaz.moveale.setText("Se movió cola 3" + telf_ale.getID());
//                ImprimirPantalla();
//            }
//        }
        
        
    }
    
    public static void ImprimirPantalla(){
        String cola1j = MainInterfaz.cola_1_john.recorrido();
        String cola2j = MainInterfaz.cola_2_john.recorrido();
        String cola3j = MainInterfaz.cola_3_john.recorrido();
        String colarj = MainInterfaz.cola_refuerzo_john.recorrido();
        String cola1a = MainInterfaz.cola_1_ale.recorrido();
        String cola2a = MainInterfaz.cola_2_ale.recorrido();
        String cola3a = MainInterfaz.cola_3_ale.recorrido();
        String colara = MainInterfaz.cola_refuerzo_ale.recorrido();
        
        MainInterfaz.cola1john.setText(cola1j);
        MainInterfaz.cola2john.setText(cola2j);
        MainInterfaz.cola3john.setText(cola3j);
        MainInterfaz.colarefuerzojohn.setText(colarj);
        MainInterfaz.cola1ale.setText(cola1a);
        MainInterfaz.cola2ale.setText(cola2a);
        MainInterfaz.cola3ale.setText(cola3a);
        MainInterfaz.colarefuerzoale.setText(colara);
        
        System.out.print("cola 1 john: ");
        MainInterfaz.cola_1_john.recorridoprueba();
        System.out.println("\n");
        System.out.print("cola 2 john: ");
        MainInterfaz.cola_2_john.recorridoprueba();
        System.out.println("\n");
        System.out.print("cola 3 john: ");
        MainInterfaz.cola_3_john.recorridoprueba();
        System.out.println("\n");
        System.out.print("cola refuerzo john: ");
        MainInterfaz.cola_refuerzo_john.recorridoprueba();
        System.out.println("\n");
        System.out.print("cola 1 ale: ");
        MainInterfaz.cola_1_ale.recorridoprueba();
        System.out.println("\n");
        System.out.print("cola 2 ale: ");
        MainInterfaz.cola_2_ale.recorridoprueba();
        System.out.println("\n");
        System.out.print("cola 3 ale: ");
        MainInterfaz.cola_3_ale.recorridoprueba();
        System.out.println("\n");
        System.out.print("cola refuerzo ale: ");
        MainInterfaz.cola_refuerzo_ale.recorridoprueba();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        
        
    }
    
    
    
}
