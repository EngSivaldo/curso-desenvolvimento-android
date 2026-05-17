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

    override fun onStart() {
        super.onStart()
        android.util.Log.i("CICLO_VIDA", "MainActivity - onStart: A tela está ficando visível.")
    }

    override fun onResume() {
        super.onResume()
        android.util.Log.i("CICLO_VIDA", "MainActivity - onResume: A tela está pronta para interação (foco).")
    }

    override fun onPause() {
        super.onPause()
        android.util.Log.i("CICLO_VIDA", "MainActivity - onPause: A tela perdeu o foco parcial (ex: abrindo outra tela).")
    }

    override fun onStop() {
        super.onStop()
        android.util.Log.i("CICLO_VIDA", "MainActivity - onStop: A tela não está mais visível.")
    }

    override fun onDestroy() {
        super.onDestroy()
        android.util.Log.i("CICLO_VIDA", "MainActivity - onDestroy: A Activity está sendo destruída da memória.")
    }
}