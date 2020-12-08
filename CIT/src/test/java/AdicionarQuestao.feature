#language :pt
Funcionalidade: Adicionar questão

  Contexto: 
    Dado que navego para a página de Login
    E informo o login "gustavoalves"
    E informo a senha "teste123"
    Quando clicar em SIGN IN
    Entao validar nome do usuário logado

  Cenario: Validação de adicionar questão sem referencia
    Dado que navego para a página de ADD NEW QUESTIONS
    E informo o titulo da questão "Teste de adição de questões"
    Quando clicar em SUBMIT
    Entao sistema exibe mensagem de erro "ERROR! Trivia References is required!"

  Esquema do Cenário: Validação de adicionar questão com nome menor que 6 caracteres
    Dado que navego para a página de ADD NEW QUESTIONS
    E informo o titulo da questão <titulo>
    E informo uma referencia "Referencia teste"
    Quando clicar em SUBMIT
    Entao sistema exibe mensagem de erro "ERROR! Trivia Question must be a minimum of 6 characters!"

    Exemplos: 
      | titulo |
      | teste  |
      | test   |
      | tes    |
      | te     |
      | t      |

  Cenario: Validação de adicionar questão sem preencher Resposta Incorreta
    Dado que navego para a página de ADD NEW QUESTIONS
    E informo o titulo da questão "Teste de adição de questões"
    E informo uma referencia "Referencia teste"
    E informo uma resposta correta "Teste resposta correta"
    Quando clicar em SUBMIT
    Entao sistema exibe mensagem de erro "ERROR! Incorrect Answer 1 is required!"

  Esquema do Cenario: Validação de adicionar questão com erro
    Dado que navego para a página de ADD NEW QUESTIONS
    E informo o titulo da questão <titulo>
    E informo uma referencia <referencia>
    E informo uma resposta correta <respostaCorreta>
    E informo uma resposta incorreta <respostaIncorreta>
    Quando clicar em SUBMIT
    Entao sistema exibe mensagem de erro <mensagemErro>

    Exemplos: 
      | titulo                        | referencia         | respostaCorreta          | respostaIncorreta          | mensagemErro                             |
      | "Teste de adição de questões" | "Referencia teste" | "Teste resposta correta" | ""                         | "ERROR! Incorrect Answer 1 is required!" |
      | "Teste de adição de questões" | ""                 | "Teste resposta correta" | ""                         | "ERROR! Trivia References is required!"  |
      | "Teste de adição de questões" | "Referencia teste" | ""                       | "Teste resposta incorreta" | "ERROR! Correct Answer is required!"     |
