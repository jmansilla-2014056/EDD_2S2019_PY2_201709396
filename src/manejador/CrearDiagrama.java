/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import Vistas.ScrollPaneReport;

import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class CrearDiagrama {

    public static void creacionDibujo(String titulo){
        try{

            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            File miDir = new File (".");
            System.out.println(miDir.getCanonicalPath());
            System.out.println(miDir.getAbsoluteFile());
            System.out.println(miDir.getPath());
            String fileInputPath = miDir.getAbsolutePath()+"\\"+ titulo +".txt";
            String fileOutputPath = miDir.getAbsolutePath()  +"\\"+titulo+".png";

            String tParam = "-Tpng";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec( cmd );

            int x=0;
            File comprobar = new File(miDir.getAbsolutePath()  +"\\"+titulo+".png");
            while (true){
                x++;
                if(comprobar.exists()){
                    if(comprobar.length() > 100){
                        break;
                    }
                }
                System.out.println(x);
            }

            System.out.println("--------------------------------------");
            Thread.sleep(x+1000);

            ScrollPaneReport scrollPaneReport = new ScrollPaneReport(fileOutputPath);

            File file = new File(miDir.getAbsolutePath()  +"\\"+titulo+".png");
            Path path = Paths.get(miDir.getAbsolutePath()  +"\\"+titulo+".png");
            if(file.exists()){
                Files.delete(path);
            }

            File file2 = new File(miDir.getAbsolutePath()  +"\\"+titulo+".txt");
            Path path2 = Paths.get(miDir.getAbsolutePath()  +"\\"+titulo+".txt");
            if(file2.exists()){
                Files.delete(path2);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }

    }

}
