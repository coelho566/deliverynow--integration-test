# language: pt
Funcionalidade: API - Clientes

  Cenário: Registrar um novo cliente
    Dado que queira registrar um cliente
    Quando submeter um novo cliente
    Então o usuario é registrado

  Cenário: Obter detalhes do cliente
    Dado que eu tenho o documento do cliente "08197588471"
    Quando eu envio uma solicitação GET para o endpoint do cliente
    Então a resposta deve conter os detalhes do cliente
    E a resposta deve ter o código de status 200


  Cenário: Obter sessão do cliente
    Quando eu envio uma solicitação GET para o endpoint de sessão do cliente
    Então a resposta deve ter o código de status 200
    E a resposta deve conter o ID da sessão do cliente


