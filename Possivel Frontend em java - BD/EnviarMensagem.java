import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EnviarMensagem extends JFrame implements ActionListener {
    
    String[] convs = {"Selecione a conversa...", "Grupo BD", "Grupo Familia", "Conversa c/ Jose"};
    JComboBox conv = new JComboBox(convs);
    JTextArea msg = new JTextArea("Escreva a mensagem aqui...", 10, 40);
    JScrollPane txt = new JScrollPane(msg, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JButton ok = new JButton("ENVIAR");
    JButton sair = new JButton("SAIR");
    JPanel pn = new JPanel(new GridLayout(3, 1, 0, 10));

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(sair)) {
            setVisible(false);
            dispose();
        }
    }

    void confPane() {
        pn.add(conv);
        pn.add(ok);
        pn.add(sair);
        sair.addActionListener(this);
    }

    void confCombo() {
        conv.setSelectedIndex(0);
        conv.addActionListener(this);
    }

    public EnviarMensagem() {
        super("Enviar Mensagem");
        setLayout(new FlowLayout());
        setLocation(50, 150);
        confCombo();
        confPane();
        add(pn);
        add(txt);
        msg.setWrapStyleWord(true);
        msg.setLineWrap(true);
        pack();
        setVisible(true);
    }
}
