import java.awt.Image;

public class Usuario{
    
    String nomeCompleto;
    String numeroTelefone;
    Image foto;
    String nomeExibicao;
    String diaNascimento, mesNascimento, anoNascimento;

    public Usuario(String nomeCompleto, String numeroTelefone, Image foto, String diaNascimento, String mesNascimento, String anoNascimento, String nomeExibicao){
        this.nomeCompleto = nomeCompleto;
        this.numeroTelefone = numeroTelefone;
        this.foto = foto;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
        this.nomeExibicao = nomeExibicao;
    }

    public void setNomeCompleto(String nome){
        this.nomeCompleto = nome;
    }

    public void setNumeroTelefone(String numero){
        this.numeroTelefone = numero;
    }

    public void setFoto(Image foto){
        this.foto = foto;
    }

    public void setNomeExibicao(String nome){
        this.nomeExibicao = nome;
    }

    public void setDiaNascimento(String dia){
        this.diaNascimento = dia;
    }

    public void setMesNascimento(String mes){
        this.mesNascimento = mes;
    }

    public void setAnoNascimento(String ano){
        this.anoNascimento = ano;
    }

    public String getNomeCompleto(){
        return this.nomeCompleto;
    }

    public String getNumeroTelefone(){
        return this.numeroTelefone;
    }

    public Image getFoto(){
        return this.foto;
    }

    public String getNomeExibicao(){
        return this.nomeExibicao;
    }

    public String getDiaNascimento(){
        return this.diaNascimento;
    }

    public String getMesNascimento(){
        return this.mesNascimento;
    }

    public String getAnoNascimento(){
        return this.anoNascimento;
    }
}