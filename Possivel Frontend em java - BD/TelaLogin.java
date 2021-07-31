import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaLogin extends JFrame implements ActionListener{

    JPanel pn = new JPanel(new GridLayout(5, 1, 0, 10));
    JLabel u = new JLabel("TELEFONE", SwingConstants.LEFT);
    JLabel p = new JLabel("SENHA", SwingConstants.LEFT);
    JTextField user = new JTextField("", 20);
    JPasswordField pass = new JPasswordField("", 20);
    JButton sub = new JButton("Login");

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(sub)) {
            String password = new String(pass.getPassword());
            if((user.getText()).equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(this, "Insira usuario e senha", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                System.out.println("Usuario: " + user.getText() + ", Senha: " + new String(pass.getPassword()));
                this.setVisible(false);
                new TelaApp();
                this.dispose();
            }
        }
    }

    void ConfPainel() {
        pn.add(u);
        pn.add(user);
        pn.add(p);
        pn.add(pass);
        pn.add(sub);
    }

    public TelaLogin() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocation(300, 200);
        ConfPainel();
        sub.addActionListener(this);
        add(pn);
        pack();
        setVisible(true); 
    }
}