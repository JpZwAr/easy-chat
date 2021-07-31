import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.*;

public class TelaRegistro extends JFrame implements ActionListener {
    
    JPanel pn = new JPanel(new GridLayout(12, 1, 0, 10));
    JLabel l1 = new JLabel("NOME COMPLETO *", SwingConstants.LEFT);
    JLabel l2 = new JLabel("DATA NASC (DD/MM/AAAA) *", SwingConstants.LEFT);
    JLabel l3 = new JLabel("TELEFONE *", SwingConstants.LEFT);
    JLabel l4 = new JLabel("APELIDO", SwingConstants.LEFT);
    JLabel l5 = new JLabel("SENHA *", SwingConstants.LEFT);
    JLabel l6 = new JLabel("* Obrigatorio", SwingConstants.LEFT);
    JTextField t1 = new JTextField("", 20);
    JTextField t2 = new JTextField("", 20);
    JTextField t3 = new JTextField("", 20);
    JTextField t4 = new JTextField("", 20);
    JPasswordField t5 = new JPasswordField("", 20);
    JButton b1 = new JButton("Registrar");

    boolean verifData(String data) {
        try {
            String padrao = "dd/MM/yyyy";
            SimpleDateFormat format = new SimpleDateFormat(padrao);
            format.parse(data);
            return true;
        }catch(ParseException p) {
            return false;
        }

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b1)) {
            if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || 
                                                    (new String(t5.getPassword())).equals("")) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios(*)", "Aviso", 
                                                                            JOptionPane.WARNING_MESSAGE);
            } else {
                if(verifData(t2.getText())) {
                    System.out.println("Nome: " + t1.getText() + ", DataNasc: " + t2.getText() + 
                    ", Telefone: " + t3.getText() + ", Apelido: " + t4.getText());
                    
                    this.setVisible(false);
                    new TelaLogin();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Data Invalida! Formato (DD/MM/YYYY)", "Aviso", 
                                                                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    void confPanel() {
        pn.add(l1);
        pn.add(t1);
        pn.add(l2);
        pn.add(t2);
        pn.add(l3);
        pn.add(t3);
        pn.add(l4);
        pn.add(t4);
        pn.add(l5);
        pn.add(t5);
        pn.add(l6);
        pn.add(b1);
    }

    public TelaRegistro() {
        super("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocation(300, 200);
        confPanel();
        b1.addActionListener(this);
        add(pn);
        pack();
        setVisible(true);
    }
}
