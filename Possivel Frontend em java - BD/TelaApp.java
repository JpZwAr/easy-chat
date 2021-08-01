import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaApp extends JFrame implements ActionListener {

    JMenuBar menu = new JMenuBar();
    JMenu conversa = new JMenu("Conversas");
    JMenu mensagem = new JMenu("Mensagens");
    JButton sair = new JButton("Sair");
    JMenuItem criar = new JMenuItem("Criar Conversa");
    JMenuItem ver = new JMenuItem("Ver Conversas");
    JMenuItem enviar = new JMenuItem("Enviar Mensagem");

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(criar)) {
            new CriaConversa();
        } else if(e.getSource().equals(ver)) {
            new VerConversa();
        } else if(e.getSource().equals(enviar)) {
            new EnviarMensagem();
        } else if(e.getSource().equals(sair)) {
            System.exit(1);
        }
    }

    void confMenu() {
        conversa.add(criar);
        criar.addActionListener(this);
        conversa.add(ver);
        ver.addActionListener(this);
        mensagem.add(enviar);
        enviar.addActionListener(this);
        menu.add(conversa);
        menu.add(mensagem);
        menu.add(sair);
        sair.addActionListener(this);
    }

    public TelaApp() {
        super("EasyChat");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        confMenu();
        setJMenuBar(menu);
        pack();
        setVisible(true);
    }
}
