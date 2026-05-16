package com.example.aulaactivityfragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAbrir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonAbrir = findViewById(R.id.button_abrir)
        buttonAbrir.setOnClickListener {

            // Criando a Intent de navegação
            val intent = Intent(this, DetalhesActivity::class.java).apply {

                // 1. SOLUÇÃO DE MERCADO: Proteção contra clique duplo (Single Top)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)

                // 2. SOLUÇÃO DE MERCADO: Passagem de parâmetros chave-valor
                putExtra("PRODUTO_SELECIONADO", "Notebook Gamer Pro")
            }

            // Inicializa a nova tela com os dados acoplados
            startActivity(intent)
        }
    }
}