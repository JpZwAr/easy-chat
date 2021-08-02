--CRIA TABELA USUÁRIO
CREATE TABLE usuario(
    numeroTelefone VARCHAR(14) NOT NULL,
    nomeCompleto VARCHAR(80) NOT NULL,
    nomeExibicao VARCHAR(20) NOT NULL,
    foto VARCHAR(100),
    dataNascimento DATE,
    mensagemPerfil VARCHAR(150),
    PRIMARY KEY (numeroTelefone)
);

--CRIA TABELA CONVERSA
CREATE TABLE conversa(
    codigoConversa VARCHAR(15) NOT NULL,
    quantidadeMensagens INTEGER,
    quantidadeMembros INTEGER,
    PRIMARY KEY (codigoConversa)
);

--CRIA TABELA CONVERSA EM GRUPO (ESPECIALIZAÇÃO)
CREATE TABLE conversaGrupo(
    codigoConversa VARCHAR(15) NOT NULL,
    nome VARCHAR(30) NOT NULL,
    foto VARCHAR(100),
    dataCriacao DATE NOT NULL,
    PRIMARY KEY (codigoConversa),
    FOREIGN KEY (codigoConversa) REFERENCES conversa (codigoConversa)
);

--CRIA TABELA PARTICIPANTE (USUÁRIO + CONVERSA)
CREATE TABLE participante(
    usuarioId VARCHAR(14) NOT NULL,
    codigoConversa VARCHAR(15) NOT NULL,
    PRIMARY KEY (usuarioId, codigoConversa)
    FOREIGN KEY (usuarioId) REFERENCES usuario (numeroTelefone),
    FOREIGN KEY (codigoConversa) REFERENCES conversa (codigoConversa)
);

--CRIA TABELA DE ADMS
CREATE TABLE administrador(
    codigoConversa VARCHAR(15) NOT NULL,
    usuarioId VARCHAR(14) NOT NULL,
    PRIMARY KEY(codigoConversa, usuarioId),
    FOREIGN KEY (usuarioId) REFERENCES usuario (numeroTelefone),
    FOREIGN KEY (codigoConversa) REFERENCES conversaGrupo (codigoConversa)
);

--CRIA TABELA MENSAGEM
CREATE TABLE mensagem(
    usuarioId VARCHAR(14) NOT NULL,
    codigoConversa VARCHAR(15) NOT NULL,
    horaEnvio TIMESTAMP(2) NOT NULL,
    conteudo VARCHAR(1000) NOT NULL,
    PRIMARY KEY (usuarioId, codigoConversa, horaEnvio),
    FOREIGN KEY (usuarioId) REFERENCES usuario (numeroTelefone),
    FOREIGN KEY (codigoConversa) REFERENCES conversa (codigoConversa)
);



--CRIA TRIGGER PRA ATUALIZAR NÚMERO DE PARTIPANTES DA CONVERSA:
CREATE OR REPLACE TRIGGER AtualizaQtdeParticipantesConversa  
AFTER INSERT OR UPDATE ON participante   
FOR EACH ROW
DECLARE qtde number;
BEGIN
    --armazena em 'qtde' o novo número de participantes da conversa após a inserção que chamou o gatilho
    SELECT COUNT(*) INTO qtde FROM participante WHERE codigoConversa = :new.codigoConversa;
    
    --atualiza conversa com nova quantidade:
    UPDATE conversa   
    SET quantidadeMembros = qtde    
    WHERE codigoConversa = :new.codigoConversa;
END;

CREATE OR REPLACE TRIGGER AtualizaQtdeParticipantesConversa2
AFTER DELETE ON participante
FOR EACH ROW
DECLARE qtde number;
BEGIN

    SELECT COUNT(*) INTO qtde FROM participante WHERE codigoConversa = :old.codigoConversa;

    UPDATE conversa
    SET quantidadeMembros = qtde
    WHERE codigoConversa = :old.codigoConversa;

END;

--CRIA TRIGGER PRA ATUALIZAR NÚMERO DE MENSAGENS DA CONVERSA:
CREATE OR REPLACE TRIGGER AtualizaQtdeMensagensConversa  
AFTER INSERT OR UPDATE ON mensagem   
FOR EACH ROW
DECLARE qtde number;
BEGIN
    --armazena em 'qtde' o novo número de mensagens após a inserção que chamou o gatilho
    SELECT COUNT(*) INTO qtde FROM mensagem WHERE codigoConversa = :new.codigoConversa;
    
    --atualiza conversa com nova quantidade:
    UPDATE conversa   
    SET quantidadeMensagens = qtde    
    WHERE codigoConversa = :new.codigoConversa;
END;

CREATE OR REPLACE TRIGGER AtualizaQtdeMensagensConversa2  
AFTER DELETE ON mensagem   
FOR EACH ROW
DECLARE qtde number;
BEGIN
    --armazena em 'qtde' o novo número de mensagens após a inserção que chamou o gatilho
    SELECT COUNT(*) INTO qtde FROM mensagem WHERE codigoConversa = :old.codigoConversa;
    
    --atualiza conversa com nova quantidade:
    UPDATE conversa   
    SET quantidadeMensagens = qtde    
    WHERE codigoConversa = :old.codigoConversa;
END;