# gestaoestoque
Software de Gestão de Estoque de jogos para o piloto do Challenge DevTools

## Funcionalidade: Gestão de Estoque (Jogos)

Como Vendedor de Jogos

Eu quero efetuar a gestão de estoque dos jogos

Para que eu possa controlar as minhas vendas online

### Cenário 1: Cadastro de Jogos
Dado que o novo jogo não exista no sistema
Quando preencher o body da requisição no Postman
E acionar o método POST
Então o usuário visualiza o status "201 Created"

### Cenário 2: Consulta de Jogos Disponíveis
Dado que o jogo consultado ainda tenha estoque disponível
Quando preencher os parâmetros da requisição
E acionar o método GET
Então o usuário visualiza o jogo solicitado
E o usuário visualiza o status "200 OK"

### Cenário 3: Remoção de Jogos
Dado que o jogo consultado ainda tenha estoque disponível
Quando preencher os parâmetros da requisição
E acionar o método DELETE
Então o usuário visualiza o status "200 OK"

### Cenário 4: Atualização de Jogos
Dado que o jogo esteja cadastrado no sistemas
Quando preencher o body da requisição no Postman
E acionar o método PATCH
Então o usuário visualiza o jogo com os novos dados
E o usuário visualiza o status "200 OK"

### Cenário 5: Estoque esgotado
Dado que o jogo consultado não tenha estoque disponível
Quando preencher os parâmetros da requisição
E acionar o método GET
Então o usuário visualiza o status "418 I'm a teapot"
