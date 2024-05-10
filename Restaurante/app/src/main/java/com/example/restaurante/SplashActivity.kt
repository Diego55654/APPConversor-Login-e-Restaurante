package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
	    //atrasa o script para que a tela dure mais
            Handler(Looper.getMainLooper()).postDelayed({
                //é criado um valor para receber as informações passadas pelo intent da login.activity
		val i = intent
                //cria outro valor para receber os dados do último intent e enviá-las à Pedido.Activity
		val j = Intent(this, PedidoActivity::class.java)
                j.putExtras(i)
                //Incia Pedido.Activity
		startActivity(j)
            }//define o delay em segundos para o cumprimento do script
	,2000)
        }
    }
