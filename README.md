<img src="imgs/UNIFOR_logo1b.png" width="400">

# 🗺️ Trabalho Prático 5 - Coloração de Grafos com DSatur

**Disciplina:** Resolução de Problemas com Grafos
**Orientador:** Prof. Me Ricardo Carubbi
**Instituição:** Universidade de Fortaleza (UNIFOR)
**Autores:** Pedro Kauã Vasconcelos e Eduardo Suaki

---
## 📌 Sobre o Projeto
Este repositório contém a implementação em **Java** do Trabalho Prático 5 da disciplina de **Resolução de Problemas com Grafos**.

O objetivo central do projeto é modelar o mapa político do Brasil como um grafo não direcionado — onde os vértices representam os estados e as arestas representam as fronteiras terrestres — e aplicar a heurística **DSatur (Degree of Saturation)**. O algoritmo busca atribuir cores a cada estado garantindo que nenhum vizinho de fronteira compartilhe a mesma cor, utilizando o menor número de cores possível.


## 📁 Estrutura do Projeto

O projeto utiliza a base de grafos padrão `algs4` (de Sedgewick & Wayne) adaptada para os requisitos do trabalho.

```text
T5/
├── README.md
├── T5.md
├── dados/
│   ├── brasil.txt              # Grafo oficial mapeando as fronteiras do Brasil
│   ├── teste-caminho4.txt
│   ├── teste-ciclo4.txt
│   ├── teste-ciclo5.txt
│   └── teste-triangulo.txt
└── src/
    ├── Bag.java
    ├── Graph.java              # Estrutura base do grafo (Lista de Adjacência)
    ├── GraphColoringDSatur.java # Lógica do algoritmo DSatur e Validação
    ├── In.java
    ├── Main.java               # Ponto de entrada do programa
    ├── Stack.java
    ├── StdIn.java
    └── StdOut.java
```

## 💻 Compilação
Certifique-se de ter o Java Development Kit (JDK) instalado. No seu terminal, navegue até o diretório `src` e execute o comando abaixo para compilar todas as classes necessárias:

```bash
cd src
javac Main.java GraphColoringDSatur.java Graph.java Bag.java Stack.java In.java StdIn.java StdOut.java
```
## 🚀 Execução
O programa principal recebe o caminho do arquivo do grafo via linha de comando. Após a compilação (ainda dentro da pasta `src`), você pode rodar os testes.
# Entrada oficial do mapa do Brasil:

```bash
java Main ../dados/brasil.txt
```
## Testes adicionais:

```bash
java Main ../dados/teste-caminho4.txt
java Main ../dados/teste-ciclo4.txt
java Main ../dados/teste-ciclo5.txt
java Main ../dados/teste-triangulo.txt
```

## Saída Esperada
O console exibirá:
1. A lista de adjacência do grafo carregado.

2. A ordem de coloração e a cor atribuída a cada vértice (com o nome/sigla correspondente).

3. O número total de cores utilizadas na resolução.

4. A validação final atestando se a coloração é válida (Nenhum vizinho com a mesma cor).

## Conclusão
Este projeto demonstra a aplicação prática de algoritmos de coloração de grafos, especificamente a heurística DSatur, em um contexto realista e complexo como o mapa político do Brasil. A implementação é modular e pode ser facilmente adaptada para outros grafos ou heurísticas de coloração, oferecendo uma base sólida para estudos futuros em teoria dos grafos e algoritmos de otimização.

## 🎥 Video de Apresentação
Uma explicação detalhada do código desenvolvido e a demonstração da execução deste projeto podem ser vistas no vídeo abaixo:

▶️ [Link para o vídeo de apresentação do projeto](https://www.youtube.com/watch?v=EXAMPLE)