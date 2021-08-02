public class Mensagem{
    
    String conteudo, horaEnvio, numeroTelefone, codigoConversa;

    public Mensagem(String conteudo, String horaEnvio, String numeroTelefone, String codigoConversa){
        this.conteudo = conteudo;
        this.horaEnvio = horaEnvio;
        this.numeroTelefone = numeroTelefone;
        this.codigoConversa = codigoConversa;
    }

    public void setConteudo(String texto){
        this.conteudo = texto;
    }

    public void setHoraEnvio(String horario){
        this.horaEnvio = horario;
    }

    public void setNumeroTelefone(String numero){
        this.numeroTelefone = numero;
    }

    public void setCodigoConversa(String codigo){
        this.codigoConversa = codigo;
    }

    public String getConteudo(){
        return this.conteudo;
    }

    public String getHoraEnvio(){
        return this.horaEnvio;
    }

    public String getNumeroTelefone(){
        return this.numeroTelefone;
    }

    public String getCodigoConversa(){
        return this.codigoConversa;
    }
}