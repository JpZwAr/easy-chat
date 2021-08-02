import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CriaConversa extends JFrame implements ActionListener {
    
    JLabel nm = new JLabel("Nome da Conversa");
    JLabel tp = new JLabel("Tipo da Conversa");
    JTextField nome = new JTextField("", 20);
    String[] tipos = {"Selecione...", "Privada", "Em Grupo"};
    JComboBox<String> tipo = new JComboBox<String>(tipos);
    JButton criar = new JButton("Criar");
    JPanel pn = new JPanel(new GridLayout(5, 1, 0, 10));
    Conexao con;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(criar)) {
            System.out.println("Nome da Conversa: " + nome.getText() + ", Tipo: " 
                                            + tipos[tipo.getSelectedIndex()]);
            
            Conversa cvs = new Conversa(nome.getText());
            con.criaConversa(cvs);

            if(tipo.getSelectedIndex() == 2) {
                con.tornaGrupo(cvs);
            }

            setVisible(false);
            dispose();
        } 
    }

    void confCombo() {
        tipo.setSelectedIndex(0);
    }

    void confPane() {
        pn.add(nm);
        pn.add(nome);
        pn.add(tp);
        pn.add(tipo);
        pn.add(criar);
        criar.addActionListener(this);
    }

    public CriaConversa(Conexao con) {
        super("Criar Conversa");
        this.con = con;
        setLayout(new FlowLayout());
        setLocation(50, 150);
        confCombo();
        confPane();
        add(pn);
        pack();
        setVisible(true);
    }
}
