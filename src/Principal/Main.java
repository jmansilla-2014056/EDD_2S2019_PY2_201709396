package Principal;

import Modelos.ArbolAVL;
import Modelos.Archivo;
import Modelos.MatrizAdyacente;
import Modelos.TablaHash;
import Modelos.Usuario;

public class Main {

    public static void main (String [ ] args) {

          
        ArbolAVL avl = new ArbolAVL("x");
        avl.insertar(new Archivo("a","a","a"));
        avl.insertar(new Archivo("b","b","b"));
        avl.insertar(new Archivo("c","c","c"));
        avl.preorden(avl.getRaiz());
        avl.graficar();
        
        TablaHash tablaHash = new TablaHash();
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
        tablaHash.reportar();

        MatrizAdyacente matrizAdyacente=new MatrizAdyacente();

        matrizAdyacente.insertar_elementos(2,3,new ArbolAVL("dos coma tres"));
        matrizAdyacente.insertar_elementos(3,4,new ArbolAVL("tres coma cuatro"));
        matrizAdyacente.insertar_elementos(2,2,new ArbolAVL("dos coma dos"));
        matrizAdyacente.insertar_elementos(3,5,new ArbolAVL("tre coma cinco"));

        matrizAdyacente.recorrer();
        matrizAdyacente.graficar();

        MatrizAdyacente matrizAdyacente2=new MatrizAdyacente();

        matrizAdyacente2.insertar_elementos(0,0,new ArbolAVL("x"));
        matrizAdyacente2.insertar_elementos(0,1,new ArbolAVL("y"));
        matrizAdyacente2.insertar_elementos(1,0,new ArbolAVL("z"));
        matrizAdyacente2.insertar_elementos(3,5,new ArbolAVL("w"));

        matrizAdyacente2.recorrer();
        matrizAdyacente2.graficar();
      


    }

}
