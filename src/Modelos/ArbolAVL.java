package Modelos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import javax.swing.JOptionPane;
import static manejador.CrearDiagrama.creacionDibujo;


public class ArbolAVL {
    String fileName;
    private NodoArbol raiz;
    private String ruta;
    private ArrayList<Archivo> listaArchivos;
    private String nombreAuxiliar;
    private String nombreCarpeta;

    public String getNombreCarpeta() {
        return nombreCarpeta;
    }

    public void setNombreCarpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
    }
    
    
    
    public ArrayList<Archivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(ArrayList<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    public ArbolAVL(String nombre) {
        this.ruta = nombre;
    }

    
    public ArbolAVL(String nombre, String nombreAuxiliar) {
        this.ruta = nombre;
        this.nombreAuxiliar = nombreAuxiliar;
    }
    
     public ArbolAVL(String nombre, String nombreAuxiliar, String nombreCarpeta) {
        this.ruta = nombre;
        this.nombreAuxiliar = nombreAuxiliar;
        this.nombreCarpeta = nombreCarpeta;
    }
    
    public int altrura(NodoArbol na){
        int x = 0;
        int y = 0;
        NodoArbol derecha = na.getHojaDerecha();
        NodoArbol izquierda = na.getHojaIzquierda();
        while(derecha!=null){
            x++;
            derecha = derecha.getHojaDerecha();
        }
        while(izquierda!=null){
            y++;
            izquierda = izquierda.getHojaIzquierda();
        }
        
        if(x>=y){
            return x;
        }else{
            return y;
        }
        
    } 
     
    public String getNombreAuxiliar() {
        return nombreAuxiliar;
    }

    public void setNombreAuxiliar(String nombreAuxiliar) {
        this.nombreAuxiliar = nombreAuxiliar;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    
    NodoArbol buscar(NodoArbol r, String d) {
        if (r == null) {
            return null;
        } else if (r.getArchivo().getNombreArchivo().compareToIgnoreCase(d) == 0) {
            return r;
        } else if (r.getArchivo().getNombreArchivo().compareToIgnoreCase(d) < 0) {
            return buscar(r.getHojaDerecha(), d);
        } else {
            return buscar(r.getHojaIzquierda(), d);
        }
    }
    
    int getFe(NodoArbol x) {
        if (x == null) {
            return -1;
        }else{
            return x.getFactorDeEquilibrio();
        }

    }

    NodoArbol SimpleLeft(NodoArbol x) {
        NodoArbol aux = x.getHojaIzquierda();
        x.setHojaIzquierda(aux.getHojaDerecha());
        aux.setHojaDerecha(x);  
        x.factorDeEquilibrio =   Math.max(getFe(x.getHojaIzquierda()), getFe(x.getHojaDerecha())) + 1;
        aux.factorDeEquilibrio = Math.max(getFe(aux.getHojaIzquierda()), getFe(aux.getHojaDerecha())) + 1;
        return aux;
    }
    
    NodoArbol SimpleRight(NodoArbol x) {
        NodoArbol aux = x.getHojaDerecha();
        x.setHojaDerecha(aux.getHojaIzquierda());
        aux.setHojaIzquierda(x);
        x.factorDeEquilibrio = Math.max(getFe(x.getHojaIzquierda()), getFe(x.getHojaDerecha())) + 1;
        aux.factorDeEquilibrio = Math.max(getFe(aux.getHojaIzquierda()), getFe(aux.getHojaDerecha())) + 1;
        return aux;
    }
    
    NodoArbol DoubleLeft(NodoArbol x) {
        NodoArbol temp;
        x.setHojaIzquierda(SimpleRight(x.getHojaIzquierda()));
        temp = SimpleLeft(x);
        return temp;
    }

    NodoArbol DoubleRight(NodoArbol x) {
        NodoArbol temp;
        x.setHojaDerecha(SimpleLeft(x.getHojaDerecha()));
        temp = SimpleRight(x);
        return temp;
    }
    
    NodoArbol insertarAvl(NodoArbol nuevo, NodoArbol aux) {
        NodoArbol nuevoPadre = aux;
        if (nuevo.getArchivo().getNombreArchivo().compareToIgnoreCase(aux.getArchivo().getNombreArchivo()) < 0) {
            if (aux.getHojaIzquierda() == null) {
                aux.setHojaIzquierda(nuevo);
            } else {
                aux.setHojaIzquierda(insertarAvl(nuevo, aux.getHojaIzquierda()));
                if ((getFe(aux.getHojaIzquierda()) - getFe(aux.getHojaDerecha())) == 2) {
                    if (nuevo.getArchivo().getNombreArchivo().compareToIgnoreCase(aux.getHojaIzquierda().getArchivo().getNombreArchivo()) < 0) {
                        nuevoPadre = SimpleLeft(aux);
                    } else {
                        nuevoPadre = DoubleLeft(aux);
                    }

                }
            }
        } else if (nuevo.getArchivo().getNombreArchivo().compareToIgnoreCase(aux.getArchivo().getNombreArchivo()) > 0) {
            if (aux.getHojaDerecha() == null) {
                aux.setHojaDerecha(nuevo); 
            } else {
                aux.setHojaDerecha(insertarAvl(nuevo, aux.getHojaDerecha()));
                if ((getFe(aux.getHojaDerecha()) - getFe(aux.getHojaIzquierda())) == 2) {
                    if (nuevo.getArchivo().getNombreArchivo().compareToIgnoreCase(aux.getHojaDerecha().getArchivo().getNombreArchivo()) > 0) {
                        nuevoPadre = SimpleRight(aux);
                    } else {
                        nuevoPadre = DoubleRight(aux);
                    }
                }
            }
        } else {
            
        }

        // actualizando la altura
        if ((aux.getHojaIzquierda() == null) && (aux.getHojaDerecha() != null)) {
            aux.setFactorDeEquilibrio(aux.getHojaDerecha().getFactorDeEquilibrio()+ 1);
        } else if ((aux.getHojaDerecha() == null) && (aux.getHojaIzquierda() != null)) {
            aux.setFactorDeEquilibrio(aux.getHojaIzquierda().getFactorDeEquilibrio() + 1);
        } else {
            aux.setFactorDeEquilibrio(Math.max(getFe(aux.getHojaIzquierda()), getFe(aux.getHojaDerecha())) + 1);
        }
        return nuevoPadre;

    }    
    
    
    public void Eliminar(Archivo archivo){
        this.getListaArchivos().clear();
        this.preorden(raiz);
        for(Archivo a : this.getListaArchivos()){
            if(a.getNombreArchivo().equals(archivo.getNombreArchivo())){
                this.getListaArchivos().remove(a);
                break;
            }
        }
        this.raiz = null;
        for(Archivo a: this.getListaArchivos()){
            this.insertar(a);
        }
        
    }
   
    public ArbolAVL insertar(Archivo archivo) {
        NodoArbol nuevo = new NodoArbol(archivo);
        this.inno();
        
        boolean bandera = false;
        
        for(Archivo a: this.getListaArchivos()){
            if(a.getNombreArchivo().equals(archivo.getNombreArchivo())){
                int reply = JOptionPane.showConfirmDialog(null, "Se encontro duplicado, sobreescribir?", "Duplicado", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    this.Eliminar(archivo);
                    this.insertar(archivo);
                }
            }
        }
        
        
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAvl(nuevo, raiz);
        }
        return this;
    }    
    
    public void preorden(NodoArbol aux) {       
        //System.out.println("PreOrden");
        if (aux != null) {
            System.out.println(aux.getArchivo().getNombreArchivo());
            this.getListaArchivos().add(aux.getArchivo());
            preorden(aux.getHojaIzquierda());
            preorden(aux.getHojaDerecha());
        }
    }
     
    public void inno(){
        this.setListaArchivos(new ArrayList<>());
        InnOrder(this.raiz);
    } 
    
    public void InnOrder(NodoArbol nodo){
       
        if(nodo != null){
            InnOrder(nodo.getHojaIzquierda());
            System.out.println("**************************************************");
            System.out.println(nodo.getArchivo().getNombreArchivo());
            this.getListaArchivos().add(nodo.getArchivo());
            InnOrder(nodo.getHojaDerecha());
        }
    }
     
      
    public void graficar(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {

            File miDir = new File (".");
            fileName = new SimpleDateFormat("yyyyMMddHHmmss''").format(new Date());
            fichero = new FileWriter(miDir.getAbsolutePath() + "//" + fileName+".txt");
            pw = new PrintWriter(fichero);

            pw.println("digraph {");
            pw.println("node [shape = rectangle, height=0.5, width=1.2];");
            
            Stack stack  = new Stack();
            NodoArbol current = this.raiz;
            while(true){
                if(current != null){
                    stack.push(current);
                    current = current.getHojaIzquierda();
                }else if(!stack.empty()){
                    current = (NodoArbol) stack.pop();
                    int peso = current.getArchivo().getContenido().length();
                    int idea = 30;
                    if(idea>peso){
                        idea = peso;
                    }
                    int altura = this.altrura(current);
                    pw.println("\""+current.getArchivo().getNombreArchivo()+"\""+"[shape = record, label=\"{"+current.getArchivo().getNombreArchivo()+"| Fe y altura: "+current.getFactorDeEquilibrio()+ " y "+ altura+ "| Contenido:"+ current.getArchivo().getContenido().substring(0,idea)+ "| Fecha: " + current.getArchivo().getFechas().toString() + "}\"]");
                    if(current.getHojaDerecha()!=null){
                        pw.println("\""+current.getArchivo().getNombreArchivo()+"\""+"->"+"\""+current.getHojaDerecha().getArchivo().getNombreArchivo()+"\"");           
                    }
                    if(current.getHojaIzquierda()!=null){
                        pw.println("\""+current.getArchivo().getNombreArchivo()+"\""+"->"+"\""+current.getHojaIzquierda().getArchivo().getNombreArchivo()+"\"");           
                    }
                    current = current.getHojaDerecha();
                }else{
                    pw.println("}");
                    break;
                }
            }
            
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
