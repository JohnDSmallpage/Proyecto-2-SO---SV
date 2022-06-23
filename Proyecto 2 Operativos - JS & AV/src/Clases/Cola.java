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
public class Cola {
   private Nodo pfirst;
   private Nodo plast;
   private int size;
   
    public Cola() {
        this.pfirst = null;
        this.plast = null;
        this.size = 0;
    }
    
    
    public Nodo getPfirst() {
        return pfirst;
    }
    
    public void setPfirst(Nodo pfirst) {
        this.pfirst = pfirst;
    }
    
    public Nodo getPlast() {
        return plast;
    }
    
    public void setPlast(Nodo plast) {
        this.plast = plast;
    }
    
   
    public int getSize() {
        return size;
    }
    
   
    public void setSize(int size) {
        this.size = size;
    }

    
   
   public boolean esta_vacia(){
       return size==0;
   }
   
   public Telefono Leer_cabeza(){
       return pfirst.getInfo();
   }
   
   public void Encolar(Telefono telf){
       Nodo nuevo_nodo= new Nodo();
       nuevo_nodo.setInfo(telf);
       
       if (pfirst==null) {
           pfirst=nuevo_nodo;
       }
       else{
           plast.setSiguiente(nuevo_nodo);
       }
       plast= nuevo_nodo;
       size++;
   }
   
   public void Desencolar(){
       pfirst=pfirst.getSiguiente();
       size--;
       if (pfirst==null) {
           plast=null;
       }
       
       
   }
    
    
    
}
