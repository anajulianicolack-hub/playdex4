# 🎮 PlayDex

> **Sua coleção. Seus jogos. Sua história.**

O **PlayDex** é uma plataforma desenvolvida para centralizar a biblioteca de jogos de usuários multiplataforma (Steam, PlayStation, Xbox, Nintendo). Inspirado em redes de catalogação cultural como o *Letterboxd*, o aplicativo tem como proposta permitir que jogadores registrem suas experiências, atribuam notas, escrevam resenhas e descubram novos títulos.

---

## 📌 Sobre o Projeto

Este projeto foi desenvolvido como parte da disciplina de **Desenvolvimento de Aplicativos Móveis (Android)**.

O objetivo principal é criar uma solução intuitiva que ajude a organizar o histórico de jogos e incentive a comunidade gamer a compartilhar experiências.

### 🎯 Público-Alvo

- **Gamers Multiplataforma:** jogadores que utilizam mais de um console ou PC.
- **Entusiastas de organização:** pessoas que gostam de manter um acervo pessoal atualizado.
- **Jogadores ativos:** usuários interessados em avaliações, recomendações e descobertas de novos jogos.

---

## 🛠️ Tecnologias e Arquitetura

O projeto foi construído utilizando as melhores práticas e ferramentas do ecossistema de desenvolvimento Android moderno:

- **Linguagem & UI:** Kotlin e Jetpack Compose.
- **Arquitetura:** Padrão MVVM (Model-View-ViewModel) com encapsulamento de estado (`UiState`) e uso de `ViewModelFactory`.
- **Persistência Local:** Room Database (SQLite) operando por meio do padrão Repository (Single Source of Truth).
- **Reatividade & Assincronismo:** Kotlin Coroutines e fluxos reativos com `Flow` / `StateFlow` para atualização automática da interface UI a partir de mudanças no banco.

---

## ✨ Principais Funcionalidades

- 📚 **Gerenciamento de Favoritos:** adicione e remova jogos da sua lista, registrando status, data, nota e review (dados persistidos localmente).
- ⭐ **Avaliações e Reviews:** atribua notas em estrelas, selecione datas e escreva resenhas sobre os jogos.
- 🔎 **Pesquisa de Jogos:** pesquise títulos, consulte o histórico salvo em banco e remova pesquisas anteriores.
- 🎮 **Detalhes dos Jogos:** visualize informações como nome, desenvolvedor, gênero e resumo.
- ❤️ **Detalhes dos Favoritos:** consulte individualmente os jogos adicionados, com suas informações e avaliações.
- 👤 **Perfil do Usuário:** acesse o perfil, as configurações e a lista de favoritos.
- 🧭 **Navegação Funcional:** transições fluídas entre as telas (`@Composable`) utilizando a barra inferior e componentes de navegação integrados.

---

## 💻 Como Executar o Projeto

### Pré-requisitos

- Android Studio instalado.
- Git configurado no computador.
- Emulador Android ou dispositivo físico disponível.
- Conexão com a internet para sincronização das dependências do Gradle.

### Passo a Passo

**1. Abra o Android Studio**

Com o Android Studio aberto, acesse:
`File → New → Project from Version Control...`

**2. Clone o repositório**

Na janela **Clone Repository**, selecione **Git** em *Version control*.
No campo **URL**, cole o endereço do repositório:
```text
https://github.com/anajulianicolack-hub/playdex4.git
```
No campo **Directory**, selecione a pasta onde o projeto será salvo.
Em seguida, clique em **Clone**.

**3. Abra e sincronize o projeto**

Aguarde o Android Studio baixar os arquivos e indexar o projeto.
Espere a sincronização do **Gradle** terminar. Caso seja necessário forçar, utilize `File → Sync Project with Gradle Files`.

**4. Execute o aplicativo**

Selecione um emulador Android ou conecte um dispositivo físico com a depuração USB ativada.
Clique no botão **Run ▶** (Shift + F10) para compilar e iniciar o PlayDex.

---

## 📄 Documentação do Projeto

A documentação visual e técnica do projeto PlayDex encontra-se no arquivo PDF localizado na pasta de documentação do repositório: 

📎 **[Documentação - PLAYDEX (PDF)](https://github.com/anajulianicolack-hub/playdex4/blob/master/docs/PLAYDEX%20-%20Documenta%C3%A7%C3%A3o%20.docx.pdf)**

> **⚠️ Aviso Importante sobre os Vídeos:** Como a documentação utiliza vídeos demonstrativos integrados (com links do Google Drive), recomendamos que você faça o download do PDF ou abra-o diretamente pelo Google Drive. Se aberto direto no visualizador padrão do GitHub, alguns navegadores podem bloquear o redirecionamento para os vídeos de demonstração.

---

## 👥 Equipe de Desenvolvimento

- **[Ana Julia Nicolack](https://github.com/anajulianicolack-hub)**
- **[Yasmin da Rocha Lopes](https://github.com/yaslopes07)**

---
🎮 **PlayDex — Sua coleção. Seus jogos. Sua história.**
