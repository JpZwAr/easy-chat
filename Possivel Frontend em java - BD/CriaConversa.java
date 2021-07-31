import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CriaConversa extends JFrame implements ActionListener {
    
    JLabel nm = new JLabel("Nome da Conversa");
    JLabel tp = new JLabel("Tipo da Conversa");
    JTextField nome = new JTextField("", 20);
    String[] tipos = {"Selecione...", "Privada", "Em Grupo"};
    JComboBox tipo = new JComboBox(tipos);
    JButton criar = new JButton("Criar");
    JPanel pn = new JPanel(new GridLayout(5, 1, 0, 10));

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(criar)) {
            System.out.println("Nome da Conversa: " + nome.getText() + ", Tipo: " 
                                                + tipos[tipo.getSelectedIndex()]);
            setVisible(false);
            dispose();
        }
    }

    void confCombo() {
        tipo.setSelectedIndex(0);
        tipo.addActionListener(this);
    }

    void confPane() {
        pn.add(nm);
        pn.add(nome);
        pn.add(tp);
        pn.add(tipo);
        pn.add(criar);
        criar.addActionListener(this);
    }

    public CriaConversa() {
        super("Criar Conversa");
        setLayout(new FlowLayout());
        setLocation(50, 150);
        confCombo();
        confPane();
        add(pn);
        pack();
        setVisible(true);
    }
}
