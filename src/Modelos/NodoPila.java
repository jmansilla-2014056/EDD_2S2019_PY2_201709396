/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author User
 */
public class NodoPila {
    // Variable en la cual se va a guardar el valor.
    private String valor;
    // Variable para enlazar los nodos.
    private NodoPila siguiente;
    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public void NodoPila(){
        this.valor = "";
        this.siguiente = null;
    }
    
    // Métodos get y set para los atributos.
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }   
}
