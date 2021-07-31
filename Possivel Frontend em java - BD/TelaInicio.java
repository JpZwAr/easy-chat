import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaInicio extends JFrame implements ActionListener{
    
    JPanel pn = new JPanel(new GridLayout(3, 1, 0, 10));
    JLabel t = new JLabel("OU", SwingConstants.CENTER);
    JButton login = new JButton("Login");
    JButton reg = new JButton("Registrar");

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(login)) {
            this.setVisible(false);
            new TelaLogin();
            this.dispose();
        } else if(e.getSource().equals(reg)) {
            this.setVisible(false);
            new TelaRegistro();
            this.dispose();
        }
    }

    void confPanel() {
        pn.add(login);
        pn.add(t);
        pn.add(reg);
    }

    public TelaInicio() {
        super("Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(250, 150));
        setLocation(300, 200); 
        confPanel();
        login.addActionListener(this);
        reg.addActionListener(this);
        add(pn);
        pack();
        setVisible(true);
    }
}
