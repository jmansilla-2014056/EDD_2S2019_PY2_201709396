package Modelos;

import java.time.LocalDateTime;

public class Usuario extends MatrizAdyacente {

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
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
