package com.example.aulafragment.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aulafragment.R

class ConversasFragment : Fragment() {

    private lateinit var btnExecutar: Button
    private lateinit var textNome: TextView
    private lateinit var editNome: EditText


    // 1. O Fragment é associado à Activity hospedeira
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "onAttach: Fragment associado à Activity.")
    }

    // 2. Criação inicial do Fragment (Corrigido para apenas um 'super')
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: Fragment criado em memória.")
    }

    // 3. Criação da hierarquia de Views
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView: Inflando o layout XML e criando a View.")

        val view = inflater.inflate(
            R.layout.fragment_conversas,
            container,
            false
        )
        //recuperar os componentes da interface
        btnExecutar = view.findViewById(R.id.btnExecutar)
        editNome = view.findViewById(R.id.editNome)
        textNome = view.findViewById(R.id.textNome)


        btnExecutar.setOnClickListener {
            textNome.text = editNome.text.toString()
        }

        return view
    }

    // 4. Configuração de elementos de interface
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated: A View do Fragment foi totalmente construída.")
    }

    // 5. Tornando o Fragment visível
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: Fragment visível na tela.")
    }

    // 6. Fragment ativo
    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: Fragment ativo e interagível (em primeiro plano).")
    }

    // 7. Perdendo o foco
    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: Fragment perdendo o foco.")
    }

    // 8. Ocultando o Fragment
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: Fragment ocultado completamente.")
    }

    // 9. Destruição da View
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView: Limpando os recursos da View.")
    }

    // 10. Destruição do Fragment
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: Fragment destruído em memória.")
    }

    // 11. Desvinculação total
    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "onDetach: Fragment totalmente desvinculado.")
    }

    // Centraliza as constantes da classe de forma limpa e profissional
    companion object {
        private const val TAG = "CicloDeVidaFragment"
    }
}