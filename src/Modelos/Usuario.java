package Modelos;

import java.time.LocalDateTime;

public class Usuario {

    private MatrizAdyacente matrizAdyacente;
    private String usuario;
    private String contrasena;
    private LocalDateTime fecha;

    public MatrizAdyacente getMatrizAdyacente() {
        return matrizAdyacente;
    }

    public void setMatrizAdyacente(MatrizAdyacente matrizAdyacente) {
        this.matrizAdyacente = matrizAdyacente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



    public Usuario(String usuario, String contrasena) {
        this.fecha = LocalDateTime.now();
        this.matrizAdyacente = new MatrizAdyacente();
        this.matrizAdyacente.insertar_elementos(0, 1, new ArbolAVL("./",".","."));
        this.matrizAdyacente.insertar_elementos(0, 0, new ArbolAVL("."));
        this.matrizAdyacente.insertar_elementos(1, 0, new ArbolAVL("./",".","."));
       
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
   
    
}
