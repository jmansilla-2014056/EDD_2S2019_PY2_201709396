/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Vistas.Sesion;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import static manejador.CrearDiagrama.creacionDibujo;

/**
 *
 * @author User
 */
public class Pila {
    String fileName;
    // Puntero que indica el inicio de la pila o tambein conocida como el
    // tope de la pila.
    private NodoPila inicio;
    // Variable para registrar el tamaño de la pila.
    private int tamanio;
    /**
     * Constructor por defecto.
     */
    public void Pila(){
        inicio = null;
        tamanio = 0;
    }
    /**
     * Consulta si la pila esta vacia.
     * @return true si el primer nodo (inicio), no apunta a otro nodo.
     */
    public boolean esVacia(){
        return inicio == null;
    }
    /**
     * Consulta cuantos elementos (nodos) tiene la pila.
     * @return numero entero entre [0,n] donde n es el numero de elementos
     * que contenga la lista.
     */
    public int getTamanio(){
        return tamanio;
    }
    /**
     * Agrega un nuevo nodo a la pila.
     * @param valor a agregar.
     */
    public void apilar(String valor){
        valor = "Usuario:"+ Sesion.Usuarioglobal.getUsuario() + " " +valor +" ," + LocalDateTime.now().toString();
        // Define un nuevo nodo.
        NodoPila nuevo = new NodoPila();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la pila esta vacia.
        if (esVacia()) {
            // Inicializa la pila con el nuevo valor.
            inicio = nuevo;
        }
        // Caso contrario agrega el nuevo nodo al inicio de la pila.
        else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        // Incrementa el contador del tamaño.
        tamanio++;
    } 
    /**
     * Elimina el elemento que se encuentra en el tope de la piala.
     */
    public void retirar(){
        if (!esVacia()) {
            // Asigna como primer nodo al siguiente de la pila.
            inicio = inicio.getSiguiente();
            // Decrementa el contador del tamaño de la pila
            tamanio--;
        }
    }
    
    public void reportar(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {

        File miDir = new File (".");
        fileName = new SimpleDateFormat("yyyyMMddHHmmss''").format(new Date());
        fichero = new FileWriter(miDir.getAbsolutePath() + "//" + fileName + ".txt");
        pw = new PrintWriter(fichero);
        // Crea una copia de la pila.
        NodoPila aux = inicio;
        // Recorre la pila hasta el ultimo nodo.
        pw.println("digraph D {");
        pw.println("node [shape=plaintext]\n" +
            "\n" +
            "  some_node [\n" +
            "   label=<\n" +
            "     <table border=\"0\" cellborder=\"1\" cellspacing=\"0\">");
        
        while(aux != null){
            System.out.println("|\t" + aux.getValor() + "\t|");
            System.out.println("-----------------");
            pw.println("<tr><td bgcolor=\"yellow\">");
            pw.println(aux.getValor());
            pw.println("</td></tr>");
            
            aux = aux.getSiguiente();
        }
    
        pw.println("  </table>>\n" +
                    "  ];\n" +
                    " \n" +
                    "\n" +
                    "\n" +
                    "}");
    
        } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero)
                        fichero.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            //Llamar a la funcion que sacara la grafica del codigo ejecutado
            creacionDibujo(fileName);
        }
}