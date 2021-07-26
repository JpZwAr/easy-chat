import java.awt.Image;

public class Conversa{
    
    Mensagem[] mensagens = new Mensagem[10000];
    int quantidadeMensagens = 0;

    Usuario[] membros = new Usuario[200];
    int quantidadeMembros = 0;
    
    String codigo; 

    public Conversa(String codigo){
        this.codigo = codigo;
    }

    public void addMensagens(Mensagem mensagem){
        if(this.quantidadeMensagens < 1000){
            this.mensagens[this.quantidadeMensagens] = mensagem;
            this.quantidadeMensagens += 1;
        }
        else
            System.out.println("Erro ao adicionar mensagem a conversa. Essa conversa ja esta cheia!");
    }

    public void addMembros(Usuario usuario){
        if(this.quantidadeMembros < 200){
            this.membros[this.quantidadeMembros] = usuario;
            this.quantidadeMembros += 1;
        }

        else
            System.out.println("Erro ao adicionar usuario a conversa. Essa conversa ja esta cheia!");
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }


    public Mensagem[] getMensagens(){
        return this.mensagens;
    }

    public int getQuantidadeMensagens(){
        return this.quantidadeMensagens;
    }

    public Usuario[] getMembros(){
        return this.membros;
    }

    public int getQuantidadeMembros(){
        return this.quantidadeMembros;
    }

    public String getCodigo(){
        return this.codigo;
    }

    

    
}