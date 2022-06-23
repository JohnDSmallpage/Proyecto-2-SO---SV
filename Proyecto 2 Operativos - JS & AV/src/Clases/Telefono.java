/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaz.*;

/**
 *
 * @author johnd
 */
public class Telefono {
    public int ID;
    public int copas;
    public int nro_pantallas;
    public int nro_pin;
    public int camara;
    public int botones;
    public String tipo_material;
    public int contador_tel;

    public Telefono(int identificador) {
        if (identificador==0) {
            this.ID = MainInterfaz.ID_global+1;
            this.copas = 0;
            this.nro_pantallas = 2;
            this.nro_pin = 1;
            this.camara = 4;
            this.botones = 3;
            this.tipo_material= MainInterfaz.tipo_material[(int) Math.floor(Math.random()*(4-0+1)+0)];
            this.contador_tel=0;
            SistemaCopas();
        }
        else{
            this.ID = 0;
            this.copas = 0;
            this.nro_pantallas = 1;
            this.nro_pin = 1;
            this.camara = 4;
            this.botones = 3;
            this.tipo_material= MainInterfaz.tipo_material[(int) Math.floor(Math.random()*(4-0+1)+0)];
        }
    }
    
    public void SistemaCopas(){
        for (int i = 0; i < getNro_pantallas(); i++) {
            if (Math.random()<0.75) {
                copas+=350;
            }
        }
        for (int i = 0; i < getCamara(); i++) {
            if (Math.random()<0.80) {
                copas+=250;
            }
        }
        for (int i = 0; i < getBotones(); i++) {
            if (Math.random()<0.85) {
                copas+=200;
            }
        }
        if (Math.random()<0.84) {
            copas+=150;
            //Para el pin
        }
        if (tipo_material.equals("Madera")) {
            copas+=200;
        }
        else if(tipo_material.equals("Aluminio")){
            copas+=400;
        }
        else if(tipo_material.equals("Oro")){
            copas+=600;
        }
        else if(tipo_material.equals("Diamante")){
            copas+=1000;
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCopas() {
        return copas;
    }

    public void setCopas(int copas) {
        this.copas = copas;
    }

    public int getNro_pantallas() {
        return nro_pantallas;
    }

    public void setNro_pantallas(int nro_pantallas) {
        this.nro_pantallas = nro_pantallas;
    }

    public int getNro_pin() {
        return nro_pin;
    }

    public void setNro_pin(int nro_pin) {
        this.nro_pin = nro_pin;
    }

    public int getCamara() {
        return camara;
    }

    public void setCamara(int camara) {
        this.camara = camara;
    }

    public int getBotones() {
        return botones;
    }

    public void setBotones(int botones) {
        this.botones = botones;
    }
    
    
    
    
    
}
