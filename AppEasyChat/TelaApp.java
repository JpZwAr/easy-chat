//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaApp extends JFrame implements ActionListener {

    JMenuBar menu = new JMenuBar();
    JMenu conversa = new JMenu("Conversas");
    JMenu mensagem = new JMenu("Mensagens");
    JButton sair = new JButton("Sair");
    JMenuItem criar = new JMenuItem("Criar Conversa");
    JMenuItem entrar = new JMenuItem("Entrar numa Conversa");
    JMenuItem ver = new JMenuItem("Ver Conversas");
    JMenuItem enviar = new JMenuItem("Enviar Mensagem");
    Conexao con;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(criar)) {
            new CriaConversa(this.con);
        } else if(e.getSource().equals(ver)) {
            new VerConversa(this.con);
        } else if(e.getSource().equals(enviar)) {
            new EnviarMensagem(this.con);
        } else if(e.getSource().equals(entrar)) {
            new EntrarConversa(this.con);
        }else if(e.getSource().equals(sair)) {
            System.exit(1);
        }
    }

    void confMenu() {
        conversa.add(criar);
        criar.addActionListener(this);
        conversa.add(ver);
        ver.addActionListener(this);
        conversa.add(entrar);
        entrar.addActionListener(this);
        mensagem.add(enviar);
        enviar.addActionListener(this);
        menu.add(conversa);
        menu.add(mensagem);
        menu.add(sair);
        sair.addActionListener(this);
    }

    public TelaApp(Conexao con) {
        super("EasyChat");
        this.con = con;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        confMenu();
        setJMenuBar(menu);
        pack();
        setVisible(true);
    }
}
