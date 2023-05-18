package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.empregaeu4.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edNome = binding.edUsuario
        val btLogin = binding.btLogin

        btLogin.setOnClickListener {
            if(edNome.text.toString()=="Admin") {
                val inten = Intent(this, CadastroVagaActivity::class.java)
                //val texto = edNome.text.toString()
               // inten.putExtra("nome", texto)
                startActivity(inten)
                //testando escrita com banco de dados
                val database = Firebase.database
                val myRef = database.getReference("teste")

                myRef.setValue("Hello, World!")
            }
            else{
                val inten = Intent(this, ListaVagasActivity::class.java)
                startActivity(inten)
              //  Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
              //  btLogin.text = edNome.text.toString()

            }
        }
        //setContentView(R.layout.activity_main)
    }
}