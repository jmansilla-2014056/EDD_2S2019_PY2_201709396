package Modelos;

import Principal.Main;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import static manejador.CrearDiagrama.creacionDibujo;

public class TablaHash {
    String fileName;
    Usuario[] usuarios;
    int size;
    int items;

   

    public TablaHash() {
        this.size = 7;
        this.usuarios = new Usuario[size];
        items = 0;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }
    
    
    public static String encript(String pass){
        try{
            MessageDigest procesoEncriptar = MessageDigest.getInstance("SHA-256");
            procesoEncriptar.reset();
            procesoEncriptar.update(pass.getBytes("utf8"));
            String encriptado = String.format("%064x", new BigInteger(1, procesoEncriptar.digest()));
            return encriptado;  
        }catch(Exception e){
            
        }
        return null;
    }
    
    
    public boolean insertarUsuario(Usuario usuario){
        boolean retornar = true;
        if((!existe(usuario.getUsuario())) && usuario.getContrasena().length() >= 6){
         //   usuario.setContrasena(encript(usuario.getContrasena()));
            int hash = (usuario.getUsuario().hashCode() & 0x7fffffff) % size;
            if (usuarios[hash]== null){
                usuarios[hash] = usuario;
            }else{
                if(hash*hash > size){
                    for(int i=hash; i< size; i++){
                        if (usuarios[i] == null){
                            if (i == usuarios.length){
                                i=0;
                            }
                            usuarios[i] = usuario;
                            break;
                        }
                    }
                }else{
                    hash = hash*hash;
                    if (usuarios[hash]== null) {
                        usuarios[hash] = usuario;
                    }else{
                        while (true){
                                hash=hash*hash;
                                hash++;
                                if(hash>this.size){
                                    int x = 0;
                                    for(Usuario u:usuarios){
                                        if(u==null){
                                            usuarios[x]=usuario;
                                            break;
                                        }
                                        x++;
                                    }
                                    break;
                                }else{
                                    if(usuarios[hash]==null){
                                        usuarios[hash] = usuario;
                                        break;
                                    }
                                }
                        }

                    }

                }

            }
            this.items++;
            reSize();
        }else{
            retornar = false;
            JOptionPane.showMessageDialog(null, "Problema con:"+ usuario.getUsuario() + ",No se pueden insertar usuario con username duplicados o contraseñas cortas");
        }
        return retornar;
    }

    public void reSize(){
        if(items > size*0.75){
            items = 0;
            Usuario[] temp= usuarios;
            nextPrimo();
            usuarios = new Usuario[size];
            for(Usuario u: temp){
                if(u != null){
                    insertarUsuario(u);
                }
            }
        }
    }

    public void nextPrimo(){
        int x = size;
        while (true){
            x++;
            if (x%2 != 0 && x%3 != 0 && x%5 != 0 && x%7 != 0 && x%11!=0 && x>size){
                size=x;
                break;
            }
        }
    }

    public boolean existe(String nombre){
        for(Usuario u : usuarios){
            try {
                if (u.getUsuario().equals(nombre) && u != null){
                    return true;
                }
            }catch (NullPointerException c){
                continue;
            }
        }
        return false;
    }


    public void Reccorer(){
        System.out.println("tamaño:" + size);
        int x = 0;
        for(Usuario u: usuarios){
            x++;
            if(u != null){

                System.out.println(String.valueOf(x) + ":" + u.getUsuario());
            }
        }
    }
    
     public void Compartir(String amigo, Archivo archivo){
        for(Usuario u: usuarios){
            if(u != null){
                if(u.getUsuario().equals(amigo)){
                    u.getMatrizAdyacente().buscar(0, 1).getArbolAVL().insertar(archivo);
                     JOptionPane.showMessageDialog(null, "Se compartio correctamente");
                     Main.pila.apilar("Compartir Archivos");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No se puedo compartir el archivo");
    }
    
    public void reportar(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {

        File miDir = new File (".");
        fileName = new SimpleDateFormat("yyyyMMddHHmmss''").format(new Date());
        fichero = new FileWriter(miDir.getAbsolutePath() + "//" + fileName + ".txt");
        pw = new PrintWriter(fichero);


            pw.println("digraph test {\n" +
                    "    graph [ratio=fill];\n" +
                    "    node [label=\"\\N\", fontsize=15, shape=plaintext];\n" +
                    "    arset [label=<\n" +
                    "        <TABLE ALIGN=\"LEFT\">\n" +
                    "            <TR>\n" +
                    "                <TD>INDEX</TD>\n" +
                    "                <TD>USER</TD>\n" +
                    "                <TD>FECHA</TD>\n" +
                    "\t      <TD>PASSWOR</TD>\n" +
                    "            </TR>");

            int count = 0;
            for(Usuario u: usuarios){
                count++;
                if(u != null){
                    pw.println("<TR>");
                    pw.println("<TD>");
                    pw.println(String.valueOf(count));
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println(u.getUsuario());
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println(u.getFecha().toString());
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println(encript(u.getContrasena()));
                    pw.println("</TD>");
                    pw.println("</TR>");
                }else{
                    pw.println("<TR>");
                    pw.println("<TD>");
                    pw.println(String.valueOf(count));
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println();
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println();
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println();
                    pw.println("</TD>");
                    pw.println("</TR>");
                }

            }

            pw.println(" </TABLE>\n" +
                    "    >, ];\n" +
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

