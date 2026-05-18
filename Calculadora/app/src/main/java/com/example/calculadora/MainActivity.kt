package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tlPeso: TextInputLayout
    private lateinit var tlAltura: TextInputLayout
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tlPeso = findViewById(R.id.textInputLayout)
        tlAltura = findViewById(R.id.textInputLayout2)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            irParaTelaDeResultado()
        }
    }

    /**
     * Valida os dados de entrada e redireciona o usuário para a ResultadoActivity
     * passando os valores de peso e altura como extras da Intent.
     */
    private fun irParaTelaDeResultado() {
        val strPeso = tlPeso.editText?.text?.toString()?.trim()
        val strAltura = tlAltura.editText?.text?.toString()?.trim()

        tlPeso.error = null
        tlAltura.error = null

        if (strPeso.isNullOrEmpty()) {
            tlPeso.error = "Por favor, digite seu peso"
            tlPeso.requestFocus()
            return
        }

        if (strAltura.isNullOrEmpty()) {
            tlAltura.error = "Por favor, digite sua altura"
            tlAltura.requestFocus()
            return
        }

        // Criando a intenção correta para navegar para a ResultadoActivity
        val intentFinal = Intent(this, ResultadoActivity::class.java)

        // Passando os dados para a próxima tela
        intentFinal.putExtra("EXTRA_PESO", strPeso)
        intentFinal.putExtra("EXTRA_ALTURA", strAltura)

        // Inicializa a nova tela
        startActivity(intentFinal)
    }
}