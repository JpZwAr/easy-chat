public class Mensagem{
    
    String conteudo, horaEnvio, numeroTelefone;

    public Mensagem(String conteudo, String horaEnvio, String numeroTelefone){
        this.conteudo = conteudo;
        this.horaEnvio = horaEnvio;
        this.numeroTelefone = numeroTelefone;
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

    public String getConteudo(){
        return this.conteudo;
    }

    public String getHoraEnvio(){
        return this.horaEnvio;
    }

    public String getNumeroTelefone(){
        return this.numeroTelefone;
    }
}