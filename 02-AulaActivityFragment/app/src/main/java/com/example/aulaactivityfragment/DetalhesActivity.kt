package com.example.aulaactivityfragment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    private lateinit var buttonFechar: Button
    private lateinit var textDadoRecebido: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializando os componentes de interface
        textDadoRecebido = findViewById(R.id.textDadoRecebido)
        buttonFechar = findViewById(R.id.buttonFechar)

        // 3. SOLUÇÃO DE MERCADO: Resgatando o dado enviado de forma segura
        val dadoEnviado = intent.getStringExtra("PRODUTO_SELECIONADO")

        // Validação defensiva: se o dado não vier nulo, atualiza o texto na tela
        if (dadoEnviado != null) {
            textDadoRecebido.text = "Item carregado:\n$dadoEnviado"
        }

        buttonFechar.setOnClickListener {
            // Finaliza a Activity atual desempilhando-a da memória do aparelho
            finish()
        }
    }
}