# language: pt
Funcionalidade: API de Produto

  Cenário: Criar um novo produto
    Dado que eu tenho os dados do produto
    Quando eu envio uma solicitação POST para o endpoint de produto
    Então a resposta da api deve ter o código de status 200

  Cenário: Deletar um produto por ID
    Dado que eu tenho o ID do produto "674e4e5e2917de68d1b7f4fe"
    Quando eu envio uma solicitação DELETE para o endpoint de produto
    Então a resposta da api deve ter o código de status 200


