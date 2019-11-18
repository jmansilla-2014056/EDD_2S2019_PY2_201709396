package Principal;

import Modelos.ArbolAVL;
import Modelos.Archivo;
import Modelos.MatrizAdyacente;
import Modelos.Pila;
import Modelos.TablaHash;
import Modelos.Usuario;
import Vistas.Sesion;

public class Main {
    
public static TablaHash tablaHash;
public static Pila pila;
    public static void main (String [ ] args) {

        pila = new Pila();
        
        tablaHash = new TablaHash();
        tablaHash.insertarUsuario(new Usuario("admin","123456"));
        tablaHash.insertarUsuario(new Usuario("jesus","123456"));
        tablaHash.insertarUsuario(new Usuario("emili","123456"));
        tablaHash.Reccorer();
        //tablaHash.reportar();

        MatrizAdyacente matrizAdyacente=new MatrizAdyacente();

        matrizAdyacente.insertar_elementos(2,3,new ArbolAVL("dos coma tres"));
        matrizAdyacente.insertar_elementos(3,4,new ArbolAVL("tres coma cuatro"));
        matrizAdyacente.insertar_elementos(2,2,new ArbolAVL("dos coma dos"));
        matrizAdyacente.insertar_elementos(3,5,new ArbolAVL("tre coma cinco"));


        MatrizAdyacente matrizAdyacente2=new MatrizAdyacente();

        matrizAdyacente2.insertar_elementos(0,0,new ArbolAVL("x"));
        matrizAdyacente2.insertar_elementos(0,1,new ArbolAVL("y"));
        matrizAdyacente2.insertar_elementos(1,0,new ArbolAVL("z"));
        matrizAdyacente2.insertar_elementos(3,5,new ArbolAVL("w"));

        Sesion sesion = new Sesion();
        sesion.setVisible(true);
      

    }

}
