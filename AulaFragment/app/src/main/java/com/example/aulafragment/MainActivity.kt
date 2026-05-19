package com.example.aulafragment

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aulafragment.fragments.ChamadasFragment
import com.example.aulafragment.fragments.ConversasFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnConversas: Button
    private lateinit var btnChamadas: Button

    // Usando a boa prática do companion object para a TAG de log
    companion object {
        private const val TAG = "CicloDeVidaActivity"
    }

    // 1. A Activity é criada em memória (configurações iniciais ocorrem aqui)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Activity sendo criada.")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnConversas = findViewById(R.id.btnConversas)
        btnChamadas = findViewById(R.id.btnChamadas)

        btnConversas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentConteudo, ConversasFragment())
                .commit()
        }

        btnChamadas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentConteudo, ChamadasFragment())
                .commit()
        }
    }

    // 2. A Activity está prestes a se tornar visível na tela
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity visível.")
    }

    // 3. A Activity ganha o foco (pronta para o usuário clicar e interagir)
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity ativa (em primeiro plano).")
    }

    // 4. A Activity perde o foco parcialmente (ex: uma janela de permissão ou pop-up abriu por cima)
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity pausando.")
    }

    // 5. A Activity não está mais visível para o usuário (ficou em segundo plano)
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity parou de ser exibida.")
    }

    // 6. A Activity está sendo reiniciada após ter sido parada, antes de exibir a tela de novo
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Activity reiniciando.")
    }

    // 7. A Activity está sendo totalmente destruída (liberando memória do sistema)
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity destruída.")
    }
}