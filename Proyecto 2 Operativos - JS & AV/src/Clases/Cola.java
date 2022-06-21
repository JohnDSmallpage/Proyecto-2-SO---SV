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
    
    /**
     * getPfirst
     * obtiene el primer elemento de la cola
     * @return 
     * Nodo<T> pfirst: primer elemento de la cola
     */
    public Nodo getPfirst() {
        return pfirst;
    }
    /**
     * setPfirst
     * establece el primer elemento de la cola
     * @param pfirst
     * @return 
     */
    public void setPfirst(Nodo pfirst) {
        this.pfirst = pfirst;
    }
    /**
     * getPlast
     * obtiene el ultimo elemento de la cola
     * @return 
     * Nodo<T> plast: ultimo elemento de la cola
     */
    public Nodo getPlast() {
        return plast;
    }
    /**
     * setPlast
     * establece el ultimo elemento de la cola
     * @param plast
     * @return 
     */
    public void setPlast(Nodo plast) {
        this.plast = plast;
    }
    
    /**
     * getSize
     * obtiene el tamaño de la cola
     * @return 
     * int size: tamaño de la cola
     */
    public int getSize() {
        return size;
    }
    
    /**
     * setSize
     * establece el tamaño de la cola
     * @param size
     * @return 
     */
    public void setSize(int size) {
        this.size = size;
    }

    
   /**
     * esta_vacia
     * verifica si la cola esta vacia
     * @return 
     * boolean true: la cola esta vacia
     * boolean false: la cola no esta vacia
     */
   public boolean esta_vacia(){
       return size==0;
   }
   /**
     * Leer_cabeza
     * obtiene el valor de la cabeza de la cola
     * @return 
     * int: valor de la cabeza de la cola
     */
   public Telefono Leer_cabeza(){
       return pfirst.getInfo();
   }
   /**
     * Encolar
     * Encola elemento a la cola
     * @param vertice
     * @return 
     */
   public void Encolar(int vertice){
       Nodo nuevo_nodo= new Nodo();
       nuevo_nodo.setInfo(vertice);
       
       if (pfirst==null) {
           pfirst=nuevo_nodo;
       }
       else{
           plast.setSiguiente(nuevo_nodo);
       }
       plast= nuevo_nodo;
       size++;
   }
   /**
     * Desencolar
     * Desencola elemento de la cola 
     * @return 
     */
   public void Desencolar(){
       pfirst=pfirst.getSiguiente();
       size--;
       if (pfirst==null) {
           plast=null;
       }
       
       
   }
    
    
    
}
