package com.tyrist.raf

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_dizi_kayit.*
import java.lang.reflect.Type
import kotlin.properties.Delegates

class diziKayit : AppCompatActivity() {
    var diziler = ArrayList<String>()
    lateinit var isim : String
    var t by Delegates.notNull<Boolean>()
    lateinit var sharedPreferences3 : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dizi_kayit)
        sharedPreferences3 = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        t = sharedPreferences3.getBoolean("acildi",true)
        ilkmi(t)
        loadData()
        buildrcycler()
    }
    fun ilkmi(x : Boolean){
        var b = x
        sharedPreferences3 = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        if (b == true){
            diziler.add("")
            saveData()
            b = false
            sharedPreferences3.edit().putBoolean("acildi", b).apply()
        }
    }

    fun buildrcycler(){
        val layoutManager = LinearLayoutManager(this)
        diziRecycler.layoutManager = layoutManager

        val adapter = RecyclerAdapter(diziler)
        diziRecycler.adapter = adapter
    }
    fun diziKayitFun(view: View){
       isim = diziName.text.toString()
        if(isim == ""){

        }else if (isim == " "){

        }else if (isim == "  "){

        }else if(isim == "   "){


        }else if(isim == "    "){


        }else if(isim == "     "){


        }else if(isim == "      "){


        }else if(isim == "       "){


        }else if(isim == "        "){


        }else if(isim == "         "){


        }else{
            diziler.add(isim)
            diziName.text.clear()
            buildrcycler()
        }
        saveData()
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(diziler)
        editor.putString("task list", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("task list", null)
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        diziler = gson.fromJson<Any>(json, type) as ArrayList<String>
        if (diziler == null) {
            diziler = ArrayList()
        }
    }
}