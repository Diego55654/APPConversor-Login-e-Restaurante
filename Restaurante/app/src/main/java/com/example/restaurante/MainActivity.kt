package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //a variável binding é criada para ligar o código à tela (layout)
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
	super.onCreate(savedInstanceState)
	//a variável ligará LoginActivity à activity_login
        binding = ActivityMainBinding.inflate(layoutInflater)
        //mostra o conteúdo da activity_main na tela
	setContentView(binding.root)
	
	//é criado um valor para receber as informações passadas pelo intent da login.activity
        val username = intent.extras?.getString("username")
                //altera texto no textview do layout mesmo que o username esteja vazio
		if(!username.isNullOrEmpty()){
                binding.textOla.setText("Olá $username")
            }
	    //fecha o programa caso o buttonFechar for apertado
            binding.buttonFechar.setOnClickListener {
                finishAffinity()
            }
	    //introduz um novo evento para caso o botão button.Pedir for apertado.
            binding.buttonPedir.setOnClickListener {
                //um valor é criado para ligar Main.Activity à SplashActivity
		val i = Intent(this, SplashActivity::class.java)
                //manda as informações da quantia dos itens à atividade ligada ao intent para o Splash.Activity
		i.putExtra("quantidadePizza",binding.editQuantidadePizza.text.toString())
                i.putExtra("quantidadeSalada",binding.editQuantidadeSalada.text.toString())
                i.putExtra("quantidadeHamburguer",binding.editQuantidadeHamburguer.text.toString())
                startActivity(i)
                finish()
            }
	    //se o usuário selecionar checkPizza, o texto da variável tornará-se 1 e ficará visível
            binding.checkPizza.setOnClickListener {
		if(binding.checkPizza.isChecked()){
                    binding.editQuantidadePizza.setText("1")
                    binding.textPrecoPizza.visibility = View.VISIBLE
                }//senão, o texto será 0 e estará invisível
		else{
                    binding.editQuantidadePizza.setText("0")
                    binding.textPrecoPizza.visibility = View.GONE
                }
            }
	    //se o usuário selecionar checkSalada, o texto da variável tornará-se 1 e ficará visível
            binding.checkSalada.setOnClickListener {
		if(binding.checkSalada.isChecked()){
                    binding.editQuantidadeSalada.setText("1")
                    binding.textPrecoSalada.visibility = View.VISIBLE
                }//senão, o texto será 0 e estará invisível
		else{
                    binding.editQuantidadeSalada.setText("0")
                    binding.textPrecoSalada.visibility = View.GONE
                }
            }
	    //se o usuário selecionar checkHamburguer, o texto da variável tornará-se 1 e ficará visível
            binding.checkHamburger.setOnClickListener {
		if(binding.checkHamburger.isChecked()){
                    binding.editQuantidadeHamburguer.setText("1")
                    binding.textPrecoHamburguer.visibility = View.VISIBLE
                }//senão, o texto será 0 e estará invisível
		else{
                    binding.editQuantidadeHamburguer.setText("0")
                    binding.textPrecoHamburguer.visibility = View.GONE
                }
            }

    }
}