package com.example.aulaactivityfragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declaração do botão que será inicializado no onCreate
    private lateinit var buttonAbrir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Otimiza o layout para usar as bordas da tela (notch/barra de navegação)
        setContentView(R.layout.activity_main)

        // Configuração dos espaçamentos automáticos (Padding) para não cortar o layout nas barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Vincula a variável ao componente visual do XML
        buttonAbrir = findViewById(R.id.button_abrir)

        // Configura o ouvinte de clique do botão
        buttonAbrir.setOnClickListener {

            // Criando a Intent de navegação (Origem: this / Destino: DetalhesActivity)
            val intent = Intent(this, DetalhesActivity::class.java).apply {

                // SOLUÇÃO DE MERCADO 1: Proteção contra clique duplo (Single Top)
                // Se o usuário clicar rápido demais, o Android não abre a mesma tela duas vezes
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)

                // SOLUÇÃO DE MERCADO 2: Passagem de parâmetros usando o escopo do apply
                // Chaves padronizadas em Letras Maiúsculas e SEM ACENTO para evitar bugs de codificação (encoding)
                putExtra("PRODUTO_SELECIONADO", "Notebook Gamer Pro")
                putExtra("KEY_FILME_NOME", "The witcher")
                putExtra("KEY_FILME_CLASSIFICACAO", 5)
                putExtra("KEY_FILME_AVALIACAO", 9.2)
            }

            // Inicializa e joga a nova tela na pilha de execução do Android
            startActivity(intent)
        }
    }

    // =========================================================================
    // MÉTODOS DO CICLO DE VIDA (Para monitoramento no Logcat)
    // =========================================================================

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