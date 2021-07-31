import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VerConversa extends JFrame implements ActionListener{
    
    String[] convs = {"Selecione a conversa...", "Grupo BD", "Grupo Familia", "Conversa c/ Jose"};
    JComboBox conv = new JComboBox(convs);
    JTextArea msgs = new JTextArea("Mensagens aparecem aqui...", 10, 40);
    JScrollPane txt = new JScrollPane(msgs);
    JButton ok = new JButton("OK");
    JPanel pn = new JPanel(new GridLayout(2, 1, 0 ,10));

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ok)) {
            setVisible(false);
            dispose();
        }
    }

    void confPane() {
        pn.add(conv);
        pn.add(ok);
        ok.addActionListener(this);
    }

    void confCombo() {
        conv.setSelectedIndex(0);
        conv.addActionListener(this);
    }

    public VerConversa() {
        super("Ver Conversas");
        setLayout(new FlowLayout());
        setLocation(50, 150);
        confCombo();
        confPane();
        add(pn);
        add(txt);
        pack();
        setVisible(true);
    }
}
