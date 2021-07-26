import java.awt.Image;

public class ConversaEmGrupo extends Conversa{
    
    String nome;
    Image foto;
    String diaDataCriacao, mesDataCriacao, anoDataCriacao;
    
    public ConversaEmGrupo(String nome, String codigo, Image foto, String diaDataCriacao, String mesDataCriacao, String anoDataCriacao){
        super(codigo);
        
        this.nome = nome;
        this.foto = foto;
        this.diaDataCriacao = diaDataCriacao;
        this.mesDataCriacao = mesDataCriacao;
        this.anoDataCriacao = anoDataCriacao;
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