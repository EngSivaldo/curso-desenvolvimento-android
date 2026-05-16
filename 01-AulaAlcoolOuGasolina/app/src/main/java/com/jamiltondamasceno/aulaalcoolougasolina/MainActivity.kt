package com.jamiltondamasceno.aulaalcoolougasolina

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var btnLimpar: MaterialButton

    private lateinit var cardResultado: MaterialCardView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarComponentesInterface()

        btnCalcular.setOnClickListener {
            ocultarTeclado()
            calcularMelhorPreco()
        }

        btnLimpar.setOnClickListener {
            limparFormulario()
        }
    }

    private fun calcularMelhorPreco() {
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        if (validarCampos(precoAlcool, precoGasolina)) {
            val alcoolNumero = precoAlcool.replace(",", ".").toDoubleOrNull()
            val gasolinaNumero = precoGasolina.replace(",", ".").toDoubleOrNull()

            if (alcoolNumero != null && gasolinaNumero != null && gasolinaNumero > 0.0) {
                val proporcao = alcoolNumero / gasolinaNumero
                val porcentagem = (proporcao * 100).toInt()

                cardResultado.visibility = View.VISIBLE

                if (proporcao >= 0.7) {
                    // Customização Dinâmica: Gasolina ganha destaque em tom azul escuro comercial
                    textResultado.text = "Abasteça com GASOLINA\nO álcool está valendo $porcentagem% da gasolina"
                    textResultado.setTextColor(Color.parseColor("#1565C0"))
                } else {
                    // Customização Dinâmica: Álcool ganha destaque em verde ecológico/posto
                    textResultado.text = "Abasteça com ÁLCOOL\nO álcool está valendo $porcentagem% da gasolina"
                    textResultado.setTextColor(Color.parseColor("#2E7D32"))
                }
            } else {
                exibirMensagemErroSimples("Valores digitados são inválidos.")
            }
        }
    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {
        textInputAlcool.error = null
        textInputGasolina.error = null

        if (pAlcool.trim().isEmpty()) {
            textInputAlcool.error = "Campo obrigatório"
            return false
        } else if (pGasolina.trim().isEmpty()) {
            textInputGasolina.error = "Campo obrigatório"
            return false
        }
        return true
    }

    private fun limparFormulario() {
        editAlcool.text?.clear()
        editGasolina.text?.clear()
        textInputAlcool.error = null
        textInputGasolina.error = null
        cardResultado.visibility = View.INVISIBLE
        editAlcool.requestFocus()
    }

    private fun exibirMensagemErroSimples(mensagem: String) {
        cardResultado.visibility = View.VISIBLE
        textResultado.text = mensagem
        textResultado.setTextColor(Color.RED)
    }

    private fun ocultarTeclado() {
        val view = this.currentFocus
        if (view != null) {
            val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imn.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById(R.id.textInputAlcool)
        editAlcool = findViewById(R.id.editAlcool)

        textInputGasolina = findViewById(R.id.textInputGasolina)
        editGasolina = findViewById(R.id.editGasolina)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpar = findViewById(R.id.btnLimpar)

        cardResultado = findViewById(R.id.cardResultado)
        textResultado = findViewById(R.id.textResultado)
    }
}