# ⛽ Fuel Calculator (Álcool ou Gasolina)

[![Android Platfom](https://img.shields.io/badge/Platform-Android-brightgreen.svg)](https://developer.android.com)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0-blue.svg)](https://kotlinlang.org)
[![Material Design](https://img.shields.io/badge/UI-Material--Design-purple.svg)](https://material.io)

O **Fuel Calculator** é um aplicativo Android nativo desenvolvido para auxiliar motoristas na tomada de decisão rápida na hora de abastecer o veículo. O app calcula de forma inteligente a relação de custo-benefício entre o Álcool e a Gasolina baseando-se na regra matemática de proporção de rendimento (70%).

---

## 📱 Demonstração da Interface

O aplicativo conta com um design moderno focado em experiência do usuário (UX), trazendo componentes visuais limpos e respostas em tempo real.

<div align="center">
  <img src="https://github.com/EngSival/fuel-calculator-android/raw/main/images/app_demo.png" width="300" alt="Demonstração do Aplicativo Fuel Calculator"/>
</div>

---

## 🚀 Recursos Profissionais Implementados (Diferenciais de Mercado)

Para elevar o nível do projeto de um simples exercício acadêmico para um produto comercial de portfólio, foram aplicadas regras avançadas de arquitetura e usabilidade:

* **Prevenção de Travamentos (Crash Prevention):** Uso do método `.toDoubleOrNull()` combinado com o tratamento de caracteres especiais `.replace(",", ".")`. Isso impede que o aplicativo feche sozinho caso o usuário digite uma vírgula ou um valor incorreto.
* **Experiência de Teclado Fluida (UX):** Bloqueio nativo no arquivo XML (`android:inputType="numberDecimal"`) que força o smartphone a abrir apenas o teclado numérico, poupando tempo do usuário.
* **Ocultação Automática do Teclado:** Utilização do serviço de sistema `InputMethodManager` para recolher o teclado automaticamente assim que o botão "Calcular" é clicado, desobstruindo a visualização da resposta.
* **Identidade Visual Dinâmica:** O container de recomendação (`MaterialCardView`) altera as cores de destaque de forma dinâmica baseando-se na resposta ideal (Verde para Álcool, Azul Comercial para Gasolina e Vermelho para erros).
* **Botão de Reset Rápido:** Inclusão de um botão funcional para limpar todos os inputs e redefinir o foco do cursor com um único toque.

---
C
## 🛠️ Tecnologias e Componentes Utilizados

* **Linguagem de Programação:** Kotlin (Tipagem estática, segura e concisa).
* **Ambiente de Desenvolvimento:** Android Studio.
* **Componentes de Layout (UI):**
    * `ConstraintLayout` para garantir uma interface responsiva em qualquer tamanho de tela.
    * `TextInputLayout` e `TextInputEditText` (Material Design Components) para estilização premium e exibição elegante de mensagens de erro.
    * `MaterialCardView` para sombreamento e agrupamento do painel de respostas.

---

## 🗂️ Estrutura Lógica do Projeto

O core business e comportamento do aplicativo estão concentrados de forma modular nas camadas padrão do ecossistema Android:

* **Lógica de Controle:** `app/src/main/java/.../MainActivity.kt`
* **Design de Tela:** `app/src/main/res/layout/activity_main.xml`

---

## 📦 Como Clonar e Executar o Projeto

Caso queira rodar este projeto localmente em sua máquina usando o terminal integrado (ou o subsistema WSL):

1. Clone o repositório para o seu diretório local:
   ```bash
   git clone [https://github.com/EngSival/fuel-calculator-android.git](https://github.com/EngSival/fuel-calculator-android.git)
2. Abra o Android Studio e selecione a opção Open an Existing Project.

3. Navegue até a pasta clonada e clique em OK.

4. Aguarde a sincronização inicial do Gradle, selecione o seu emulador e clique no botão Run (Play).

EngSival - Engenheiro e Desenvolvedor Android Nativo Kotlin