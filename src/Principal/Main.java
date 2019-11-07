package Principal;

import Modelos.ArbolAVL;
import Modelos.MatrizAdyacente;
import Modelos.TablaHash;
import Modelos.Usuario;

public class Main {

    public static void main (String [ ] args) {

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

        matrizAdyacente2.insertar_elementos(2,3,new ArbolAVL("x"));
        matrizAdyacente2.insertar_elementos(3,4,new ArbolAVL("y"));
        matrizAdyacente2.insertar_elementos(2,2,new ArbolAVL("z"));
        matrizAdyacente2.insertar_elementos(3,5,new ArbolAVL("w"));

        matrizAdyacente2.recorrer();
        matrizAdyacente2.graficar();


        MatrizAdyacente matrizAdyacente3=new MatrizAdyacente();

        matrizAdyacente3.insertar_elementos(2,3,new ArbolAVL("x"));
        matrizAdyacente3.insertar_elementos(3,4,new ArbolAVL("y"));
        matrizAdyacente3.insertar_elementos(2,2,new ArbolAVL("z"));
        matrizAdyacente3.insertar_elementos(3,5,new ArbolAVL("w"));
        matrizAdyacente3.insertar_elementos(2,5,new ArbolAVL("x"));
        matrizAdyacente3.insertar_elementos(5,4,new ArbolAVL("y"));
        matrizAdyacente3.insertar_elementos(6,2,new ArbolAVL("z"));
        matrizAdyacente3.insertar_elementos(7,5,new ArbolAVL("w"));
        matrizAdyacente3.insertar_elementos(3,6,new ArbolAVL("x"));
        matrizAdyacente3.insertar_elementos(6,7,new ArbolAVL("y"));
        matrizAdyacente3.insertar_elementos(3,2,new ArbolAVL("z"));
        matrizAdyacente3.insertar_elementos(6,6,new ArbolAVL("w"));



        matrizAdyacente3.recorrer();
        matrizAdyacente3.graficar();


    }

}
