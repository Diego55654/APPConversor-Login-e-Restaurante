package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    //a variável binding é criada para ligar o código à tela (layout)
    private lateinit var binding:ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
	//a variável ligará PedidoActivity à activity_pedido
	binding = ActivityPedidoBinding.inflate(layoutInflater)
	//mostra o conteúdo da activity_pedido na tela
        setContentView(binding.root)

	//é criado um valor para receber as informações passadas pelo intent da Splash.Activity
        val i = intent
	//cria valores para receber as informações dadas, transfomrnado-as em inteiros
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

	//escreve o resumo do pedido e liga ao textResumo
        val TEXTO = "Resumo do Pedido\n" +
                //escreve a quantidade de pizza e o preço total de pizzas (quantidade vezes o preço unitário)
		"Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                //escreve a quantidade de salada e o preço total de saladas (quantidade vezes o preço unitário)
		"Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
		//escreve a quantidade de hamburguer e o preço total de hamburgueres (quantidade vezes o preço unitário)
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"
        binding.textResumo.text = TEXTO

    }
}