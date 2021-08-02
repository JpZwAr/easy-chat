import java.awt.Image;

public class ConversaEmGrupo extends Conversa{
    
    String nome;
    Image foto;
    String diaDataCriacao, mesDataCriacao, anoDataCriacao;
    
    Usuario[] administradores = new Usuario[200];
    int quantidadeAdms = 0;

    public ConversaEmGrupo(String nome, String codigo, Image foto, String diaDataCriacao, String mesDataCriacao, String anoDataCriacao){
        super(codigo);
        
        this.nome = nome;
        this.foto = foto;
        this.diaDataCriacao = diaDataCriacao;
        this.mesDataCriacao = mesDataCriacao;
        this.anoDataCriacao = anoDataCriacao;
    }

    public void addAdms(Usuario usuario){
        if(this.quantidadeAdms < 200){
            this.administradores[this.quantidadeAdms] = usuario;
            this.quantidadeAdms += 1;
        }

        else
            System.out.println("Erro ao adicionar usuario a conversa. Essa conversa ja esta cheia!");
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setFoto(Image foto){
        this.foto = foto;
    }

    public void setDiaDataCriacao(String diaDataCriacao){
        this.diaDataCriacao = diaDataCriacao;
    }

    public void setMesDataCriacao(String mesDataCriacao){
        this.mesDataCriacao = mesDataCriacao;
    }

    public void setAnoDataCriacao(String anoDataCriacao){
        this.anoDataCriacao = anoDataCriacao;
    }

    public Usuario[] getAdms(){
        return this.administradores;
    }

    public String getNome(){
        return this.nome;
    }

    public Image getFoto(){
        return this.foto;
    }

    public String getDiaDataCriacao(){
        return this.diaDataCriacao;
    }

    public String setMesDataCriacao(){
        return this.mesDataCriacao;
    }

    public String setAnoDataCriacao(){
        return this.anoDataCriacao;
    }

}