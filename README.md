# Jogo-Trilha-com-RMI
#Trabalho 2 - Programação Paralela e Distribuída
**Projeto RMI/RPC**


![image](https://user-images.githubusercontent.com/39846852/193384149-0126af9e-0f0c-43bf-af05-b6ed6aab1cb2.png)


**Objetivo: Implementar o Jogo Trilha com RMI/RPC**

    Trilha ou Moinho é um tradicional e antigo jogo de tabuleiro, que frequentemente é
    incluído por fabricantes brasileiros de jogos de tabuleiro como parte de coletâneas.
    Tipicamente acompanha jogos como Damas, Gamão, Ludo e Xadrez. É conhecido por
    muitos outros nomes (por exemplo Marel), tanto em português quanto em outras línguas.
    O tabuleiro consiste em três quadrados concêntricos conectados entre si, com seus cantos e
    pontos médios sendo as casas.
    Sendo 18 no total (9 de cada cor), as peças tem formatos, cores e tamanhos diferentes,
    dependendo do fabricante. O formato mais comum é a de discos pretos e brancos,
    semelhante às peças de Damas.
    
* Objetivo do jogo

    O objetivo do jogo é remover as peças inimigas até que restem no máximo duas.
    Em qualquer fase do jogo, quando um jogador forma uma linha horizontal ou vertical com
    três de suas peças (chamada de «moinho») sobre o tabuleiro, tem o direito de escolher uma
    peça inimiga em qualquer posição do tabuleiro para remover, desde que essa peça não faça
    parte de um «moinho» inimigo

**Regras:**
* Início do jogo:

    Cada jogador escolhe uma cor e recebe nove peças com a respectiva cor. Os jogadores vão
    colocando as peças alternadamente nas posições de suas preferências (de forma semelhante
    à montagem inicial do Jogo da Velha). Tanto os cantos dos quadrados quanto os pontos
    Médios de seus lados são posições iniciais (e de jogo) válidas.
  
* Movimentação das peças:

    Após um jogador ficar com todas as suas peças no tabuleiro, começa a fase de
    movimentação das peças. As peças desse jogador podem se movimentar vertical ou
    horizontalmente uma casa, desde de que não haja nenhuma peça no local. As peças não
    pulam casas vazias ou com peças, como o cavalo do Xadrez, sendo possível o movimento
    em apenas uma casa vazia por rodada.
  
* Movimentação livre das peças:

    Após um jogador ficar com apenas três peças no tabuleiro, começa a fase de movimentação
    livre das peças. As peças desse jogador passam a se movimentar livremente pelo tabuleiro,
    ignorando demais peças ou espaços vazios, podendo ser posicionadas em qualquer casa
    vazia do tabuleiro.
  
* Final de jogo:

  O jogo termina com uma dessas três possibilidades:
  
  - Se um dos jogadores ficar com apenas duas peças, ocasionando uma derrota;
  - Se não houver mais nenhuma jogada válida, ocasionando em empate e
  - Se ambos os jogadores estiverem com apenas três peças e, em 10 jogadas, não
    houver vencedor, onde é declarado empate.
