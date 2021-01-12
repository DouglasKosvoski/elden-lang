# Elden-lang

É uma linguagem desenvolvida em Java, para a disciplina de Programação 1 2020/1 (UFFS).

Elden-lang é uma linguagem um pouco fora do "convencional", nela nenhum número
é utilizado explicitamente. Para que contas, equações e programas sejam
desenvolvidos, apenas palavras-chaves e um pouquinho de criatividade são necessárias.

## Motivação
Todos sabemos que programar e/ou desenvolver exige tanto raciocínio lógico quanto
criatividade para solucionar os problemas do cotidiano e com isso em mente, tivemos
a ideia de elevar o nível instigando a criatividade, o raciocínio lógico, 
mas também a produção literária, onde através de palavras, frases ou texto, o desenvolvedor(a) além de criar programas complexos vai também se aventurar em sua própria imaginação para criar histórias fantásticas que também poderiam ser utilizadas
no meio literário.

**Vale frisar que por meio disso todas as linhas, salvo exceções, precisam terminar com um ponto final "." ;**

--------------------------------------------------------------------------------

## Variáveis
Elden-lang tem suporte completo a **todos** os tipos primitivos de variáveis: *int*, *double*, *string* e *boolean*... Porém essas variáveis, são consideradas "nomes próprios", ou seja, precisam ter sua primeira letra como sendo uma letra MAIÚSCULA.

### Declaração de Variáveis:

A declaração de variáveis se dá pelo uso da palavra-chave '**summon**'
exemplo: ```summon int Guerreiro.``` <br>

>Primeiramente, temos o uso da palavra-chave `summon` acrescido de outra palavra-chave, mas agora relacionada ao tipo primitivo da variável, `int` e por consequência o nome da variavel em si `Guerreiro`, note a letra Maiúscula no seu início.

Exemplos:
```
summon int Water.
summon double Wind.
summon string Fire.
summon boolean Earth.
```

>**Nota**: 
<br>Por padrão **Inteiros** são inicializados com valor **0** .
<br>Por padrão **Doubles** são inicializados com valor **0.0** .
<br>Por padrão **Strings** são inicializados com valor **""** .
<br>Por padrão **Booleans** são inicializados com valor **False** .


--------------------------------------------------------------------------------

### Inicialização de Variáveis:

A Inicialização de variáveis se dá pelo uso da palavra-chave '**cast**'. <br>
Exemplo: 
> ```cast Water as liquid.``` <br>

Você deve estar se perguntando: **"Se Water é um inteiro, cadê a atribuição de seu valor?"**. <br>
E é nessa parte que Elden-lang foge ao padrão, perceba a ultima palavra do exemplo anterior, ***liquid***, é ali que acontece sua atribuição, o valor da variável é a quantidade de caracteres utilizados. <br>
Então o valor de **Water** é 6 (por quê ***liquid*** possui 6 letras) ... <br>
>***Nota o ponto no final da frase não acrescenta ao valor da variável em questão***.

>Primeiramente temos o uso da palavra-chave `cast` acrescido da ***Variável*** a qual se deseja inicializar, palavra-chave ***as*** para dar sentido a frase e por final seu valor, por meio do *length* da última palavra.

Exemplos:
```
cast Water as liquid.
cast Wind as gas.
cast Fire as temperature.
cast Earth as true.
```

>Perceba que seus valores serão os seguintes: <br><br>
***Water***, tem valor **6** por ser um inteiro. <br>
***Wind***, tem valor **4.0** por ser um double. <br>
***Fire***, tem valor **"temperature"** por ser uma string, ela recebe o valor literal da String passada. <br>
***Earth***, tem seu valor lógico como sendo **true**, caso contrário, não fosse inicializada teria contida o valor lógico **false**.

--------------------------------------------------------------------------------

### Operacões Lógicas-Aritméticas
Em Elden-lang temos uma diversa gama de operações pré-definidas prontas para serem usadas.

|      Palavra-Chave          |  Significado  |  Tipos Suportados      |
| ----------------------------|:-------------:| ------------------:    |
| **ascend**                  | Adição        |   **Int & Double**     |
| **descend**                 | Subtração     |   **Int & Double**     |
| **strengthen**              | Multiplicação |   **Int & Double**     |
| **weaken**                  | Divisão       |   **Int & Double**     |
| **matches**                 | Comparação    |     **Todas**          |
| **stronger**                | >             |   **Int & Double**     |
| **stronger_or_equivalent**  | >=            |   **Int & Double**     |
| **weaker**                  | <             |   **Int & Double**     |
| **weaker_or_equivalent**    | <=            |   **Int & Double**     |
| **unlike**                  | !=            |     **Todas**          |
| **residual**                | Módulo (%)    |   **Int & Double**     |
| **powered**                 | Potênciação   |   **Int & Double**     |

<br>

#### Exemplos para Int e Double
|                 Exemplo                         |                 Explicação                         | Retorno  |
|:-----------------------------------------------:|:--------------------------------------------------:|:--------:|
| **Water ascend by fire.**                       |             Incrementa em 4                        |   None   |
| **Water descend by cold.**                      |             Decrementa em 4                        |   None   |
| **Water strengthen by water.**                  |             Multiplica em 5                        |   None   |
| **Water weaken by fire.**                       |             Divide por 4                           |   None   |
| **Water matches fire.**                         |**Water** é **IGUAL** a Qtd. de caracteres          |  Boolean |
| **Water is stronger than water.**               |**Water** é **MAIOR** do que a Qtd. de caracteres   |  Boolean |
| **Water is stronger_or_equivalent than water.** |**Water** é **MAIOR OU IGUAL** a Qtd. de caracteres |  Boolean |
| **Water is weaker than water.**                 |**Water** é **MENOR** do que a Qtd. de caracteres   |  Boolean |
| **Water is weaker_or_equivalent than water.**   |**Water** é **MENOR OU IGUAL** a Qtd. de caracteres |  Boolean |
| **Water is unlike water.**                      |**Water** é **DIFERENTE** da Qtd. de caracteres     |  Boolean |
| **Water residual vapor.**                       |             **Módulo** 5                           |   None   |
| **Water is powered by drops.**                  |             **Eleva** em 5                         |   None   |

<br>

#### Exemplos para String e Boolean
|            Exemplo           |            Explicação                     |   Retorno  |
|:----------------------------:|:-----------------------------------------:|:----------:|
| **Water matches fire.**      |**Water** é **IGUAL** a ***palavra***      |  Boolean   |
| **Water is unlike water.**   |**Water** é **DIFERENTE** da ***palavra*** |  Boolean   |

<br>

#### Alguns outros tipos de funcionalidades

|            Exemplo          |            Explicação                                    |
|:---------------------------:|:-----------------------------------------------------:   |
| **reveal Water.**           | **Printa** o valor de **Water**                          |
| **A obtain B.**             | Variavel **A** **recebe** o valor da Variavel **B**      |
| **input A.**                | Variavel **A** **recebe** algum valor a partir do teclado|


>**Nota**: <br>
**Int** só pode receber de **Int** e **Double** <br>
**Double** só pode receber de **Int** e **Double** <br>
**String** pode receber de todos os outros tipos... porem será convertido para string <br>
**Boolean** pode receber de **Boolean** e **Strings** (desde que o conteudo da string seja apto a ser convertido para **Boolean**) <br>
