import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class VerConversa extends JFrame implements ActionListener{
    
    JLabel cv = new JLabel("Nome da Conversa");
    JTextField conv = new JTextField("", 20);
    JTextArea msgs = new JTextArea("Mensagens aparecem aqui...", 10, 40);
    JScrollPane txt = new JScrollPane(msgs, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JButton ok = new JButton("VER");
    JButton sair = new JButton("SAIR");
    JPanel pn = new JPanel(new GridLayout(4, 1, 0 ,10));
    Conexao con;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(sair)) {
            setVisible(false);
            dispose();
        } else if(e.getSource().equals(ok)) {
            String query = new String("SELECT * FROM conversa WHERE codigoConversa = '" + conv.getText() + "'");
            ResultSet res = con.consultaConversa(query);
            if(res != null) {
                msgs.setText("");
                try {
                    while(res.next()) {
                        String[] data = {res.getString("codigoConversa"), 
                        res.getString("quantidadeMensagens"), res.getString("quantidadeMembros")};

                        msgs.append(data[0] + "\n" + data[1] + "\n" + data[2] + "\n\n");
                    }
                }catch(SQLException s) {
                    System.out.println(s);
                }
            }
        }
    }

    void confPane() {
        pn.add(cv);
        pn.add(conv);
        pn.add(ok);
        pn.add(sair);
        sair.addActionListener(this);
        ok.addActionListener(this);
    }

    public VerConversa(Conexao con) {
        super("Ver Conversas");
        this.con = con;
        setLayout(new FlowLayout());
        setLocation(50, 150);
        confPane();
        add(pn);
        add(txt);
        msgs.setWrapStyleWord(true);
        msgs.setLineWrap(true);
        pack();
        setVisible(true);
    }
}
