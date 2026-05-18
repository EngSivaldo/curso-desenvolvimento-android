package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textPeso = findViewById(R.id.textPeso)
        textAltura = findViewById(R.id.textAltura)
        textResultado = findViewById(R.id.textResultado)
        btnVoltar = findViewById(R.id.btnVoltar)

        val pesoStr = intent.getStringExtra("EXTRA_PESO")
        val alturaStr = intent.getStringExtra("EXTRA_ALTURA")

        textPeso.text = "Peso informado: $pesoStr kg"
        textAltura.text = "Altura informada: $alturaStr m"

        if (pesoStr != null && alturaStr != null) {
            try {
                val peso = pesoStr.toDouble()
                val altura = alturaStr.toDouble()

                if (altura > 0) {
                    val imc = peso / (altura * altura)
                    val imcFormatado = String.format("%.2f", imc)
                    val diagnostico = obtenerClassificacao(imc)

                    textResultado.text = "$imcFormatado\n$diagnostico"
                }
            } catch (e: NumberFormatException) {
                textResultado.text = "Erro ao calcular"
            }
        }

        // Configura a ação de voltar ao clicar no botão
        btnVoltar.setOnClickListener {
            finish() // Fecha a tela atual e volta automaticamente para a anterior
        }
    }

    private fun obtenerClassificacao(imc: Double): String {
        return when {
            imc < 18.5 -> "Abaixo do peso"
            imc in 18.5..24.9 -> "Peso normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc in 30.0..34.9 -> "Obesidade Grau I"
            imc in 35.0..39.9 -> "Obesidade Grau II"
            else -> "Obesidade Grau III"
        }
    }
}