package Modelos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static manejador.CrearDiagrama.creacionDibujo;

public class MatrizAdyacente {
    String fileName;
    NodoMatriz root = new NodoMatriz(-1,-1,new ArbolAVL("Root"));


    public NodoMatriz buscar_fila(int y){
        NodoMatriz temp = root;
        while (temp != null){
            if(temp.getY()==y){
                return temp;
            }
            temp = temp.getAbajo();
        }
        return null;
    }

    public NodoMatriz buscar_columna(int x){
        NodoMatriz temp = root;
        while (temp != null){
            if(temp.getX()==x){
                return temp;
            }
            temp = temp.getDerecha();
        }
        return null;
    }


    public void insertarEnLaInterseccion(String nodoPadre, String nodoHijo, String aux, String nombre){
        NodoMatriz nm = buscar(0,0);
        NodoMatriz nb = nm.getAbajo();
        NodoMatriz ng = nm.getDerecha();
        int y=0;
        int x=0;
        while(true){
            if(nb.getArbolAVL().getRuta().equals(nodoPadre)){
                y=nb.getY();
                break;
            }else{
                nb = nb.getAbajo();
            }
        }
        while(true){
            if(ng.getArbolAVL().getRuta().equals(nodoHijo)){
                x=ng.getX();
                break;
            }else{
                ng = ng.getDerecha();
            }
        }
        this.insertar_elementos(x, y, new ArbolAVL(nodoHijo,aux,nombre));
        
    }
            
    public void eliminar(String ruta){
        MatrizAdyacente temp = new MatrizAdyacente();   
        NodoMatriz aux = this.root;
        int c = 1;
        while (aux!=null) {
            NodoMatriz aux1 = aux;
            while (aux1!=null){              
                if(aux1.getY()==-1 || aux1.getX() == -1){
                    aux1 = aux1.getDerecha();
                    continue;
                }
                if(!(aux1.getArbolAVL().getRuta().startsWith(ruta))){
                    temp.insertar_elementos(aux1.getX(), aux1.getY(),aux1.getArbolAVL());
                }
                System.out.println(aux1.getX() +"," + aux1.getY() + " : " +  aux1.getArbolAVL().getRuta());
                aux1 = aux1.getDerecha();
                c++;
            }
            aux = aux.getAbajo();
        }
        
        this.root =  new NodoMatriz(-1,-1,new ArbolAVL("Root"));
        NodoMatriz auxx = temp.root;
        while (auxx!=null) {
            NodoMatriz auxx11 = auxx;
            while (auxx11!=null){
                
                if(auxx11.getY()==-1 || auxx11.getX() == -1){
                    auxx11 = auxx11.getDerecha();
                    continue;
                }               
                if(!(auxx11.getArbolAVL().getRuta().startsWith(ruta))){
                    this.insertar_elementos(auxx11.getX(), auxx11.getY(),auxx11.getArbolAVL());                  
                }
                System.out.println(auxx11.getX() +"," + auxx11.getY() + " : " +  auxx11.getArbolAVL().getRuta());
                auxx11 = auxx11.getDerecha();
                c++;
            }
            auxx = auxx.getAbajo();
        }
        
    }
    
    public NodoMatriz insertar_ordenado_columna(NodoMatriz nuevo, NodoMatriz cabeza){
        NodoMatriz temp = cabeza;
        boolean bandera = false;
        while (true){
            if(temp.getX() == nuevo.getX()){
                temp.setY(nuevo.getY());
                temp.setArbolAVL(nuevo.getArbolAVL());
                return temp;
            }
            else if(temp.getX() > nuevo.getX()){
                bandera = true;
                break;
            }
            if(temp.getDerecha() != null){
                temp = temp.getDerecha();
            }
            else{
                break;
            }
        }
        if(bandera){
            nuevo.setDerecha(temp);
            temp.getIzquierda().setDerecha(nuevo);
            nuevo.setIzquierda(temp.getIzquierda());
            temp.setIzquierda(nuevo);

        }else {
            temp.setDerecha(nuevo);
            nuevo.setIzquierda(temp);
        }
        return nuevo;
    }


    public NodoMatriz insertar_ordenado_fila(NodoMatriz nuevo, NodoMatriz cabeza){
        NodoMatriz temp = cabeza;
        boolean bandera = false;
        while (true){
            if(temp.getY() == nuevo.getY()){
                temp.setX(nuevo.getX());
                temp.setArbolAVL(nuevo.getArbolAVL());
                return temp;
            }
            else if(temp.getY() > nuevo.getY()){
                bandera = true;
                break;
            }
            if(temp.getAbajo() != null){
                temp = temp.getAbajo();
            }
            else{
                break;
            }
        }
        if(bandera){
            nuevo.setAbajo(temp);
            temp.getArriba().setAbajo(nuevo);
            nuevo.setArriba(temp.getArriba());
            temp.setArriba(nuevo);

        }else {
            temp.setAbajo(nuevo);
            nuevo.setArriba(temp);
        }
        return nuevo;
    }

    public NodoMatriz crearColumna(int x){
        NodoMatriz cabeza_columna = this.root;
        NodoMatriz columna = insertar_ordenado_columna(new NodoMatriz(x,-1, new ArbolAVL("Root")),cabeza_columna);
        return columna;
    }

    public NodoMatriz crearFila(int y){
        NodoMatriz cabeza_fila = this.root;
        NodoMatriz fila = insertar_ordenado_fila(new NodoMatriz(-1,y, new ArbolAVL("Root")),cabeza_fila);
        return fila;
    }

    public void insertar_elementos(int x, int y, ArbolAVL arbolAVL){
        NodoMatriz nuevo = new NodoMatriz(x,y,arbolAVL);
        NodoMatriz nodoColumna = buscar_columna(x);
        NodoMatriz nodoFila = buscar_fila(y);
        if(nodoColumna == null && nodoFila == null){
            nodoColumna = crearColumna(x);
            nodoFila = crearFila(y);
            nuevo = insertar_ordenado_columna(nuevo,nodoFila);
            nuevo = insertar_ordenado_fila(nuevo,nodoColumna);
            return;
        }
        else if(nodoColumna == null && nodoFila != null){
            nodoColumna = crearColumna(x);
            nuevo = insertar_ordenado_columna(nuevo,nodoFila);
            nuevo = insertar_ordenado_fila(nuevo,nodoColumna);
        }
        else if(nodoFila == null && nodoColumna != null){
            nodoFila = crearFila(y);
            nuevo = insertar_ordenado_columna(nuevo,nodoFila);
            nuevo = insertar_ordenado_fila(nuevo,nodoColumna);
        }
        else if(nodoFila!=null && nodoColumna != null){
            nuevo = insertar_ordenado_columna(nuevo, nodoFila);
            nuevo = insertar_ordenado_fila(nuevo, nodoColumna);
        }

    }

    public void editar(String rutaCompleta, String NombreCapetaViejo, String auxViejo ,String rutaNueva, String nombreCarpetaNuevo, String rutaAuxiliarNueva){
        
        MatrizAdyacente temp = new MatrizAdyacente();   
        NodoMatriz aux = this.root;
        int c = 1;
        while (aux!=null) {
            NodoMatriz aux1 = aux;
            while (aux1!=null){              
                if(aux1.getY()==-1 || aux1.getX() == -1){
                    aux1 = aux1.getDerecha();
                    continue;
                }
                if(aux1.getArbolAVL().getRuta().startsWith(rutaCompleta)){
                    
                    if(aux1.getX()==0 && aux1.getArbolAVL().getRuta().equals(rutaCompleta)){
                        aux1.getArbolAVL().setNombreAuxiliar(nombreCarpetaNuevo);
                    }
                    
                    if(aux1.getX()==0 && aux1.getArbolAVL().getRuta().equals(rutaCompleta)){
                        aux1.getArbolAVL().setNombreAuxiliar(nombreCarpetaNuevo);
                    }
                                      
                    if(aux1.getArbolAVL().getRuta().equals(rutaCompleta)){
                        aux1.getArbolAVL().setNombreCarpeta(nombreCarpetaNuevo);
                                                     
                           if(aux1.getArbolAVL().getNombreAuxiliar().equals(auxViejo)){
                               aux1.getArbolAVL().setNombreAuxiliar(rutaAuxiliarNueva);
                               
                               if(aux1.getArriba()!=null){
                                   NodoMatriz nm = aux1.getArriba();
                                   nm.getArbolAVL().setNombreAuxiliar(nombreCarpetaNuevo);
                                   this.insertar_elementos(aux1.getX(), aux1.getY(),aux1.getArbolAVL());
                               }
                               
                           }
                    }
                    
                    aux1.getArbolAVL().setRuta(aux1.getArbolAVL().getRuta().replace(rutaCompleta, rutaNueva));
                    
                    this.insertar_elementos(aux1.getX(), aux1.getY(),aux1.getArbolAVL());
                }
                System.out.println(aux1.getX() +"," + aux1.getY() + " : " +  aux1.getArbolAVL().getRuta());
                aux1 = aux1.getDerecha();
                c++;
            }
            aux = aux.getAbajo();
        }
        
    }
    
    public void recorrer(){
        NodoMatriz aux = this.root;
        int c = 1;
        while (aux!=null) {
            NodoMatriz aux1 = aux;
            while (aux1!=null){
                if(aux1.getY()==-1 || aux1.getX() == -1){
                    aux1 = aux1.getDerecha();
                    continue;
                }
                System.out.println(aux1.getX() +"," + aux1.getY() + " : " +  aux1.getArbolAVL().getRuta());
                aux1 = aux1.getDerecha();
                c++;
            }
            aux = aux.getAbajo();
        }
    }

    public NodoMatriz buscar(int x, int y){
        NodoMatriz aux = this.root;
        int c = 1;
        while (aux!=null) {
            NodoMatriz aux1 = aux;
            while (aux1!=null){
                if(aux1.getY()==-1 || aux1.getX() == -1){
                    aux1 = aux1.getDerecha();
                    continue;
                }
                if(aux1.getX()==x && aux1.getY()==y){
                    return aux1;
                }
                System.out.println(aux1.getX() +"," + aux1.getY() + " : " +  aux1.getArbolAVL().getRuta());
                aux1 = aux1.getDerecha();
                c++;
            }
            aux = aux.getAbajo();
        }
        return null;
    }
    
    public NodoMatriz buscarInterseccion(String ruta){
        NodoMatriz aux = this.root;
        int c = 1;
        while (aux!=null) {
            NodoMatriz aux1 = aux;
            while (aux1!=null){
                if(aux1.getY()==-1 || aux1.getX() == -1){
                    aux1 = aux1.getDerecha();
                    continue;
                }
                if(aux1.getX()>=1 && aux1.getY()>=1 && aux1.getArbolAVL().getRuta().equals(ruta)){
                    return aux1;
                }
                System.out.println(aux1.getX() +"," + aux1.getY() + " : " +  aux1.getArbolAVL().getRuta());
                aux1 = aux1.getDerecha();
                c++;
            }
            aux = aux.getAbajo();
        }
        return null;
    }
    
    public void grafo(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            
            File miDir = new File (".");
            fileName = new SimpleDateFormat("yyyyMMddHHmmss''").format(new Date());
            fichero = new FileWriter(miDir.getAbsolutePath() + "//" + fileName+".txt");
            pw = new PrintWriter(fichero);

            pw.println("digraph {");
            pw.println("node [shape = record];");
            pw.println("graph [nodesep = 0.5, ranksep = 0.5]");
            pw.println("rankdir=TB");
            
            
            NodoMatriz nodo0 = this.buscar(0, 1);
            
            while(nodo0 != null){       
                int x = this.contador(nodo0);                
                pw.println("\""+nodo0.getArbolAVL().getRuta()+"\""+"[label=\""+nodo0.getArbolAVL().getNombreCarpeta()+"\\n"+"cantidad="+x+"\"]");               
                nodo0 = nodo0.getAbajo();
            }
            
            
            NodoMatriz nodo = this.buscar(0, 1);
            NodoMatriz horizontal; 
            while(nodo != null){       
                horizontal = nodo.getDerecha(); 
                while(horizontal!=null){
                    pw.println("\""+nodo.getArbolAVL().getRuta()+"\""+"->\""+horizontal.getArbolAVL().getRuta()+"\"");
                    horizontal = horizontal.getDerecha();
                }
                nodo = nodo.getAbajo();
            }
            pw.println("}");
            
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        creacionDibujo(fileName);
    }
    
    
    public int contador(NodoMatriz nm){
        int x =0;
        while(nm!=null){
            if(nm.getDerecha()!=null){
                x++;
            }
            nm = nm.getDerecha();
        }
        return x;
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
            pw.println("node [shape = record, height=0.5, width=1, fontsize=9];");
            pw.println("graph [nodesep = 0.5, ranksep = 0.5]");
            pw.println("rankdir=TB");
            NodoMatriz tempA = this.root;
            NodoMatriz temp = this.root;

            boolean primera = true;

            while (tempA != null){
                if(tempA == this.root){
                    if(temp == this.root){
                        pw.println("\""+temp.getX()+"-"+temp.getY()+"\"[label=\""+temp.getArbolAVL().getNombreAuxiliar()+"\\n("+temp.getArbolAVL().getRuta()+
                                ")\"\n"+",pos=\""+(temp.getX()+1)+","+(temp.getY()+1)+"!\""+
                                "];");
                        temp = temp.getAbajo();
                    }
                    else if(temp != null){
                        pw.println("\""+temp.getX()+"-"+temp.getY()+"\"[label=\""+temp.getY()+
                                "\"\n"+",pos=\""+(temp.getX()+1)+","+(temp.getY()+1)+"!\""+
                                "];");
                        temp = temp.getAbajo();
                    }
                    else{
                        tempA = tempA.getDerecha();
                        temp = tempA;
                    }
                }
                else{
                    if(primera){
                        pw.println("\"" + temp.getX() +"-"+temp.getY()+"\"[label=\""+temp.getX()+
                                "\"\n"+",pos=\""+(temp.getX()+1)+","+(temp.getY()+1)+"!\""+
                                "];");
                        temp= temp.getAbajo();
                        primera = false;
                    }
                    else if(temp != null){
                        pw.println("\"" +temp.getX()+"-"+temp.getY()+"\"[label=\""+temp.getArbolAVL().getNombreAuxiliar()+"\\n("+temp.getArbolAVL().getRuta()+
                                ")\"];");
                        temp = temp.getAbajo();
                    }
                    else {
                        tempA = tempA.getDerecha();
                        temp = tempA;
                        primera = true;
                    }

                }
            }
            tempA = this.root;
            temp = tempA;


            while (tempA != null)
            {
                if(tempA==this.root){
                    if(temp==this.root){
                        pw.println("\""+temp.getX()+"-"+temp.getY()+ "\"->\"" + temp.getDerecha().getX() + "-" + temp.getDerecha().getY() +"\"[dir=both];");
                        pw.println("\""+temp.getX()+"-"+temp.getY()+  "\"->\""+temp.getAbajo().getX() + "-"+ temp.getAbajo().getY() + "\"[dir=both];");
                        temp = temp.getAbajo();
                    }
                    else{
                        if(temp.getDerecha() != null)
                        {
                            pw.println("\""+temp.getX()+"-"+temp.getY()+"\"->\""+temp.getDerecha().getX()+"-"+temp.getDerecha().getY()+"\"[dir=both];");
                        }
                        if(temp.getAbajo() != null)
                        {
                            System.out.println("xxxx");
                            pw.println("\""+temp.getX()+"-"+temp.getY()+ "\"->\""+temp.getAbajo().getX()+"-"+temp.getAbajo().getY()+ "\"[dir=both];");
                            temp = temp.getAbajo();
                        }
                        else{
                            System.out.println("yyyy");
                            tempA=tempA.getDerecha();
                            temp=tempA;
                        }
                    }
                }
                else
                    ///
                {
                    if(tempA==temp){
                        if(temp.getDerecha()!=null){
                            pw.println( "\""+temp.getX()+"-"+temp.getY()+"\"->\""+temp.getDerecha().getX()+"-"+temp.getDerecha().getY()+"\"[dir=both];");
                        }
                        if(temp.getAbajo() != null){
                            System.out.println("ooooo");
                            pw.println("\""+temp.getX()+"-"+temp.getY()+"\"->\""+temp.getAbajo().getX()+"-"+temp.getAbajo().getY()+"\"[dir=both];");
                            temp = temp.getAbajo();
                        }
                        else
                        {
                            tempA = tempA.getDerecha();
                            temp = tempA;
                        }
                    }
                    else
                    {
                        if(temp.getDerecha() != null){
                            pw.println( "\""+temp.getX()+"-"+temp.getY()+"\"->\""+temp.getDerecha().getX() +"-"+temp.getDerecha().getY()+"\"[dir=both];");
                        }
                        if(temp.getAbajo() != null) {
                            System.out.println("jjjj");
                            pw.println("\"" + temp.getX() + "-" + temp.getY() + "\"->\"" + temp.getAbajo().getX() + "-" + temp.getAbajo().getY() + "\"[dir=both];");
                            temp = temp.getAbajo();
                        }
                        else{
                            tempA=tempA.getDerecha();
                            temp=tempA;
                        }
                    }

                }
            }

            tempA = this.root;
            temp = tempA;

            while (tempA!=null)
            {
                if(tempA==this.root) {

                    pw.println("{ rank=same; ");
                    pw.println("\"" + temp.getX() + "-" + temp.getY() + "\"");
                    temp = temp.getDerecha();

                    while (temp != null) {
                        pw.println("\"" + temp.getX() + "-" + temp.getY() + "\"");
                        temp = temp.getDerecha();
                    }

                    pw.println("};");
                    tempA = tempA.getAbajo();
                    temp = tempA;

                }else{
                    pw.println("{ rank=same; ");
                    pw.println("\""+temp.getX()+"-"+temp.getY()+"\"");
                    temp=temp.getDerecha();

                    while (temp!=null){
                        pw.println( "\""+temp.getX()+"-"+temp.getY()+ "\"");
                        temp=temp.getDerecha();
                    }
                    pw.println("};");
                    tempA = tempA.getAbajo();
                    temp = tempA;

                }

            }

            pw.println("};");

        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
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
