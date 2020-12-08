#language :pt
Funcionalidade: Busca no Banco de Questões

  Cenário: Busca por questão inexistente
    Dado que navego para a página de busca do banco de questões
    E digito 'Science: Computers' no campo de busca
    Quando clico no botão de buscar
    Então visualizo uma mensagem de erro com o texto 'No questions found.'

  Cenário: Busca por categoria
    Dado que navego para a página de busca do banco de questões
    E seleciono a busca por Categoria
    E digito 'Science: Computers' no campo de busca
    Quando clico no botão de buscar
    Então visualizo a quantidade de 25 itens exibidos
    E visualizo o controle de paginação
