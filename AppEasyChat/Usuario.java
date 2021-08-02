public class Usuario{
    
    String nomeCompleto;
    String numeroTelefone;
    String nomeExibicao;
    String dataNasc;
    String mensagemPerfil;

    public Usuario(String nomeCompleto, String numeroTel, String dataNasc, String nomeExibicao, String mensagem){
        this.nomeCompleto = nomeCompleto;
        this.numeroTelefone = numeroTel;
        this.dataNasc = dataNasc;
        this.nomeExibicao = nomeExibicao;
        this.mensagemPerfil = mensagem;
    }

    public void setNomeCompleto(String nome){
        this.nomeCompleto = nome;
    }

    public void setNumeroTelefone(String numero){
        this.numeroTelefone = numero;
    }

    public void setNomeExibicao(String nome){
        this.nomeExibicao = nome;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void getMensagemPerfil(String mensagem){
        this.mensagemPerfil = mensagem;
    }

    public String getNomeCompleto(){
        return this.nomeCompleto;
    }

    public String getNumeroTelefone(){
        return this.numeroTelefone;
    }

    public String getNomeExibicao(){
        return this.nomeExibicao;
    }

    public String getDataNasc(){
        return this.dataNasc;
    }

    public String getMensagemPerfil(){
        return this.mensagemPerfil;
    }
}