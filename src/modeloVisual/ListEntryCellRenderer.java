/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ListCellRenderer;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author Mansilla
 */  
public class ListEntryCellRenderer
 extends JLabel implements ListCellRenderer
{
   private JLabel label;
  
   @Override
   public Component getListCellRendererComponent(JList list, Object value,
                                                 int index, boolean isSelected,
                                                 boolean cellHasFocus) {
      ListEntry entry = (ListEntry) value;
  
      setText(value.toString());
      setIcon(entry.getIcon());   
   
      if (isSelected) {
         setBackground(list.getSelectionBackground());
         setForeground(list.getSelectionForeground());
      }
      else {
         setBackground(list.getBackground());
         setForeground(list.getForeground());
      }
  
      setEnabled(list.isEnabled());
      setFont(list.getFont());
      setOpaque(true);
    
      
      return this;
   }

    

    
    
}
