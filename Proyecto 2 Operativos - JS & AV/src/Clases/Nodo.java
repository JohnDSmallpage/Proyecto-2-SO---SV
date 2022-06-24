/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author johnd
 */
public class Nodo {
    
    private Telefono telefono;
    private Nodo siguiente;

    public Nodo() {
        this.telefono = telefono;
        this.siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Telefono getInfo() {
        return telefono;
    }

    public void setInfo(Telefono telefono) {
        this.telefono = telefono;
    }
    
    
    
    
}
