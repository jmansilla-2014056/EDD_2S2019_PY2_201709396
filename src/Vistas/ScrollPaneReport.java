package Vistas;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;


public class ScrollPaneReport extends JFrame implements KeyListener {
    String rut;
    JScrollPane jsp;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        ScrollPaneReport spn = new ScrollPaneReport(rut);
        spn.setSize(this.getSize());
        this.setVisible(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public ScrollPaneReport(String rut) {
        super("JScrollPane Demo");
        this.rut = rut;
        addKeyListener(this);
        ImageIcon ii = new ImageIcon(rut);
        jsp = new JScrollPane(new JLabel(ii));
        this.getContentPane().add(jsp);
        this.setSize(300, 250);
        this.setVisible(true);

    }


}
