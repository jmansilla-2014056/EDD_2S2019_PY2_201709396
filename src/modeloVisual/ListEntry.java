/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Mansilla
 */
        public class ListEntry
{
   private String value;
   private ImageIcon icon;
   private JButton boton;
  
   
   
   public ListEntry(String value, ImageIcon icon) {
      this.value = value;
      this.icon = icon;
   }
  
   public String getValue() {
      return value;
   }
  
   public ImageIcon getIcon() {
      return icon;
   }
  
   public String toString() {
      return value;
   }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public ListEntry(String value, ImageIcon icon, JButton boton) {
        this.value = value;
        this.icon = icon;
        this.boton = boton;
    }
   
   
   
}
