import java.sql.*;
import java.time.LocalDate;
//
//usuario(numeroTelefone PK TEXT, nomeCompleto TEXT, nomeExibicao TEXT, dataNascimento TEXT, 
//        mensagemPerfil TEXT)
//
//conversa(codigoConversa TEXT, quantidadeMensagens INTEGER, quantidadeMembros INTEGER)
//
//participante(usuarioId TEXT FK REF usuario, codigoConversa TEXT FK REF conversa)
//
//mensagem(usuarioID TEXT FK REF usuario, codigoConversa TEXT FK REF conversa, horaEnvio TEXT,
//         conteudoMensagem TEXT)
//
public class Conexao {

    public Connection con;
    public Statement stm;

    public Conexao() {
        try{
            this.con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/easyChat.db");
            this.stm = con.createStatement();
        }catch(SQLException e) {
            System.out.println(e);
        }
    }

    public void criaUsuario(Usuario user) {

        try {
            this.stm.executeUpdate("INSERT INTO usuario VALUES ('" + user.numeroTelefone + "', '" + user.nomeCompleto + "', '" 
                                    + user.nomeExibicao + "', '" + user.dataNasc + "', '" + user.mensagemPerfil + "')");
            System.out.println("Query succesfull executed!");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    public void criaConversa(Conversa cvs) {

        try {
            this.stm.executeUpdate("INSERT INTO conversa VALUES ('" + cvs.codigo + "', 0, 0)");
            System.out.println("Query succesfull executed!");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    public void participarConversa(String nome, String tel) {

        try {
            this.stm.executeUpdate("INSERT INTO participante VALUES ('" + tel + "', '" + nome 
                                    +  "')");
            System.out.println("Query succesfull executed!");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    public void enviarMensagem(Mensagem msg) {

        try {
            this.stm.executeUpdate("INSERT INTO mensagem VALUES ('" + msg.numeroTelefone + "', '" + msg.codigoConversa + "', '" 
                                    + msg.horaEnvio + "', '" + msg.conteudo +  "')");
            System.out.println("Query succesfull executed!");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    public int consultaUsuario(String query) {
        try{
            int qtd;
            ResultSet rs;
            rs = stm.executeQuery(query);
            qtd = rs.getInt(1);
            return qtd;
        }catch(SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public ResultSet consultaConversa(String query) {
        try{
            ResultSet res = this.stm.executeQuery(query);
            return res;
        }catch(SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public int tornaGrupo(Conversa cvs) {
        LocalDate data = LocalDate.now();
        System.out.println(data);
        try {
            this.stm.executeUpdate("INSERT INTO conversaGrupo VALUES ('" + cvs.codigo + "', '" + cvs.codigo + "', '" + data + "')");
            System.out.println("Query succesfull executed!");
            return 1;
        }catch(SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
}

//java -classpath ".;C:/sqlite/java/connect/sqlite-jdbc-3.36.0.1.jar" Conexao