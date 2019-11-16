package Principal;

import Modelos.ArbolAVL;
import Modelos.Archivo;
import Modelos.MatrizAdyacente;
import Modelos.TablaHash;
import Modelos.Usuario;
import Vistas.Sesion;

public class Main {
    
public static TablaHash tablaHash;
    public static void main (String [ ] args) {

          
        ArbolAVL avl = new ArbolAVL("x");
        avl.insertar(new Archivo("haahah.txt","a"));
        avl.insertar(new Archivo("amen.mp4","b"));
        avl.insertar(new Archivo("bebecita.mp3","c"));
     //   avl.preorden(avl.getRaiz());
        avl.inno();
        
        tablaHash = new TablaHash();
        tablaHash.insertarUsuario(new Usuario("jesus","jesus"));
        tablaHash.insertarUsuario(new Usuario("robert","jesus"));
        tablaHash.insertarUsuario(new Usuario("emili","jesus"));
        tablaHash.insertarUsuario(new Usuario("marco dias","jesus"));
        tablaHash.insertarUsuario(new Usuario("fatima","jesus"));
        tablaHash.insertarUsuario(new Usuario("yisus","jesus"));
        tablaHash.insertarUsuario(new Usuario("Eli","jesus"));
        tablaHash.insertarUsuario(new Usuario("Tu papa","jesus"));
        tablaHash.insertarUsuario(new Usuario("EL master","jesus"));
        tablaHash.insertarUsuario(new Usuario("el crack","jesus"));
        tablaHash.insertarUsuario(new Usuario("el puto amo","jesus"));
        tablaHash.insertarUsuario(new Usuario("la mera tos","jesus"));
        tablaHash.insertarUsuario(new Usuario("la mera tos con flema","jesus"));
        tablaHash.insertarUsuario(new Usuario("jesus bendito","jesus"));
        tablaHash.insertarUsuario(new Usuario("auron","jesus"));
        tablaHash.insertarUsuario(new Usuario("el pequeño auron","jesus"));
        tablaHash.Reccorer();
    

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
