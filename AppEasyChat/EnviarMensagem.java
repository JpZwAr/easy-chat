import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnviarMensagem extends JFrame implements ActionListener {
    
    JLabel cv = new JLabel("Nome da Conversa");
    JTextField conv = new JTextField("", 20);
    JLabel tl = new JLabel("Numero Telefone");
    JTextField tel = new JTextField("", 20);
    JTextArea msg = new JTextArea("Escreva a mensagem aqui...", 10, 40);
    JScrollPane txt = new JScrollPane(msg, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JButton ok = new JButton("ENVIAR");
    JButton sair = new JButton("SAIR");
    JPanel pn = new JPanel(new GridLayout(6, 1, 0, 10));
    Conexao con;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(sair)) {
            setVisible(false);
            dispose();
        } else if(e.getSource().equals(ok)) {
            if(msg.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Mensagem vazia!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String datahora = time.format(formatter);
                Mensagem msgm = new Mensagem(msg.getText(), datahora, tel.getText(), conv.getText());
                con.enviarMensagem(msgm);
                setVisible(false);
                dispose();
            }
        }
    }

    void confPane() {
        pn.add(cv);
        pn.add(conv);
        pn.add(tl);
        pn.add(tel);
        pn.add(ok);
        pn.add(sair);
        sair.addActionListener(this);
        ok.addActionListener(this);
    }

    public EnviarMensagem(Conexao con) {
        super("Enviar Mensagem");
        this.con = con;
        setLayout(new FlowLayout());
        setLocation(50, 150);
        confPane();
        add(pn);
        add(txt);
        msg.setWrapStyleWord(true);
        msg.setLineWrap(true);
        pack();
        setVisible(true);
    }
}
