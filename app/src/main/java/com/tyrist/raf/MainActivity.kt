package com.tyrist.raf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun diziMenuFun(view: View){
        val intent = Intent(applicationContext, diziKayit::class.java)
        startActivity(intent)
    }
    fun filmMenuFun(view: View){
        val intent = Intent(applicationContext, filmKayit::class.java)
        startActivity(intent)
    }
    fun kitapMenuFun(view: View){
        val intent = Intent(applicationContext, kitapKayit::class.java)
        startActivity(intent)
    }

}