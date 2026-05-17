package com.example.aulaactivityfragment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    // Declaração das variáveis dos componentes visuais da tela de detalhes
    private lateinit var buttonFechar: Button
    private lateinit var textFilme: TextView
    private lateinit var textDadoRecebido: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)

        // Configuração de barras do sistema (Edge to Edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializando os componentes vinculando-os ao XML
        textDadoRecebido = findViewById(R.id.textDadoRecebido)
        buttonFechar = findViewById(R.id.buttonFechar)
        textFilme = findViewById(R.id.textFilme)

        // =========================================================================
        // ABORDAGEM A: Resgatando múltiplos dados usando o pacote 'Bundle'
        // =========================================================================
        val bundle = intent.extras

        // Programação Defensiva: Só tenta ler se o pacote de dados não for nulo
        if (bundle != null) {
            // Buscando os dados usando as chaves corrigidas e sem acentos
            val filme = bundle.getString("KEY_FILME_NOME")
            val classificacao = bundle.getInt("KEY_FILME_CLASSIFICACAO")
            val avaliacoes = bundle.getDouble("KEY_FILME_AVALIACAO")

            // Monta a string formatada usando String Templates do Kotlin
            val resultado = "Filme: $filme\nClassificação: $classificacao\nAvaliação: $avaliacoes"

            // Exibe o resultado estruturado no TextView correspondente
            textFilme.text = resultado
        }

        // =========================================================================
        // ABORDAGEM B: Resgatando o dado diretamente da Intent (Solução de Mercado)
        // =========================================================================
        val dadoEnviado = intent.getStringExtra("PRODUTO_SELECIONADO")

        // Validação defensiva: se o dado não vier nulo, atualiza o texto na tela
        if (dadoEnviado != null) {
            textDadoRecebido.text = "Item carregado:\n$dadoEnviado"
        }

        // Configura o botão para encerrar a tela atual
        buttonFechar.setOnClickListener {
            // Finaliza a Activity atual desempilhando-a da memória do aparelho e retornando à anterior
            finish()
        }
    }
}