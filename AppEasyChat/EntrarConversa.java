import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EntrarConversa extends JFrame implements ActionListener {
    
    JLabel nm = new JLabel("Nome da Conversa");
    JTextField nome = new JTextField("", 20);
    JLabel tl = new JLabel("Telefone");
    JTextField tel = new JTextField("", 20);
    JButton entrar = new JButton("Entrar");
    JPanel pn = new JPanel(new GridLayout(5, 1, 0, 10));
    Conexao con;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(entrar)) {
            System.out.println("Nome da Conversa: " + nome.getText() + ", Tel: " 
                                            + tel.getText());
            
            con.participarConversa(nome.getText(), tel.getText());

            setVisible(false);
            dispose();
        } 
    }

    void confPane() {
        pn.add(nm);
        pn.add(nome);
        pn.add(tl);
        pn.add(tel);
        pn.add(entrar);
        entrar.addActionListener(this);
    }

    public EntrarConversa(Conexao con) {
        super("Entrar numa Conversa");
        this.con = con;
        setLayout(new FlowLayout());
        setLocation(50, 150);
        confPane();
        add(pn);
        pack();
        setVisible(true);
    }
}

