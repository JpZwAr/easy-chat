public class ConversaPrivada extends Conversa{
    public ConversaPrivada(String codigo){
        super(codigo);
    }

    public void addMembros(Usuario usuario){
        if(this.quantidadeMembros < 2){
            this.membros[this.quantidadeMembros] = usuario;
            this.quantidadeMembros += 1;
        }
        else
            System.out.println("\n[ERRO AO ADICIONAR MEMBRO A CONVERSA] Essa conversa e privada e ja esta cheia!");
    }
}