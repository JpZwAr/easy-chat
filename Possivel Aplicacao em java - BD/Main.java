class Main{
    public static void main(String []args){
        
        //ESTRUTURA DOS CONSTRUTORES

        //Usuario(String nomeCompleto, String numeroTelefone, Image foto, String diaNascimento, String mesNascimento, 
        //                                                                          String anoNascimento, String nomeExibicao)

        //Mensagem(String conteudo, String horaEnvio, String numeroTelefone)

        //Conversa(String codigo)

        //ConversaPrivada(String codigo)

        //ConversaEmGrupo(String nome, String codigo, Image foto, String diaDataCriacao, 
        //                                              String mesDataCriacao, String anoDataCriacao)


        Usuario user1 = new Usuario("Usuario 01", "997878978", null, "16", "04", "2000", null);
        Usuario user2 = new Usuario("Usuario 02", "992211212", null, "30", "07", "2002", null);
        Usuario user3 = new Usuario("Usuario 03", "992264612", null, "20", "03", "1997", "Us3");
        
        ConversaPrivada a = new ConversaPrivada("02452");

        user1.setNomeExibicao("U1");
        user2.setNomeExibicao("U2");
        
       
        //Adiciona membros na conversa
        a.addMembros(user1);
        a.addMembros(user2);
        //a.addMembros(user3);                    //ERRO AO ADICIONAR O USER 3, POIS A CONVERSA 'a' EH PRIVADA (MAX DOIS USERS POR CONVERSA)

        //Adiona mensagens
        a.addMensagens(new Mensagem("Ola!", "19:17", user1.getNumeroTelefone()));
        a.addMensagens(new Mensagem("Boa noite!", "19:23", user2.getNumeroTelefone()));

        Mensagem mensagens[] = a.getMensagens();
        Usuario usuarios[]= a.getMembros();

        System.out.println("\n\nConversa " + a.getCodigo() + ": ");

        int i;

        try{
            for(i=0; i<a.getQuantidadeMensagens(); i++){
                System.out.println("\n\t" + mensagens[i].getConteudo());
                System.out.println("\thorario enviado: " + mensagens[i].getHoraEnvio());
                System.out.println("\tenviada por: " + mensagens[i].getNumeroTelefone());
            }
    
            System.out.println("\n\tMembros: ");
            
            for(i=0; i<a.getQuantidadeMembros(); i++)
                System.out.println("\n\t\t" + usuarios[i].getNomeCompleto());
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}