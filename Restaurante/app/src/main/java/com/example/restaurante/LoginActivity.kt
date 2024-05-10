package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //a variável binding é criada para ligar o código à tela (layout)
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
	//a variável ligará LoginActivity à activity_login
        binding = ActivityLoginBinding.inflate(layoutInflater)
	//mostra o conteúdo da activity_login na tela
        setContentView(binding.root)

	//cria-se um evento que será acionado quando o usuário clicar no botão entrar
        binding.buttonEntrar.setOnClickListener {
            //põe os dados digitados pelo usuário no valor username
	    val username = binding.editUsername.text.toString().trim()
            //põe os dados digitados pelo usuário no valor password
	    val password = binding.editPassword.text.toString().trim()

	    //verficação para que o usuário faça login
            if (username.equals("Diego") && password.equals("6")) {
                //um valor é criado para ligar Login.Activity à Main.Activity
		val i = Intent(this, MainActivity::class.java)
                //manda as informações do username à atividade ligada ao intent
		i.putExtra("username", username)
                //inicia a Main.Activity
		startActivity(i)
                //fecha Login.Activity
		finish()
            } //caso as informações para autenticação de login não estejam corretas, aparecerá esta mensagem.
		else {
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}