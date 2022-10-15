package com.tyrist.raf

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_dizi_kayit.*
import kotlinx.android.synthetic.main.activity_film_kayit.*
import java.lang.reflect.Type
import kotlin.properties.Delegates

class filmKayit : AppCompatActivity() {
     var filmler = ArrayList<String>()
    lateinit var isims : String
     var f by Delegates.notNull<Boolean>()
    lateinit var sharedPreferences4 : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_kayit)

        sharedPreferences4 = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        f = sharedPreferences4.getBoolean("acildii",true)
        ilkmi(f)
        loadData()
        buildrcycler()
    }

    fun ilkmi(x : Boolean){
        var b = x
        sharedPreferences4 = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        if (b == true){
            filmler.add("")
            saveData()
            b = false
            sharedPreferences4.edit().putBoolean("acildii", b).apply()
        }
    }

    fun buildrcycler(){
        val layoutManager = LinearLayoutManager(this)
        filmRecycler.layoutManager = layoutManager

        val adapter = RecyclerAdapter(filmler)
        filmRecycler.adapter = adapter
    }
    fun filmKayitFun(view: View){
        isims = filmName.text.toString()
        if(isims == ""){

        }else if (isims == " "){

        }else if (isims == "  "){

        }else if(isims == "   "){


        }else if(isims == "    "){


        }else if(isims == "     "){


        }else if(isims == "      "){


        }else if(isims == "       "){


        }else if(isims == "        "){


        }else if(isims == "         "){


        }else{
            filmler.add(isims)
            filmName.text.clear()
            buildrcycler()
        }
        saveData()
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(filmler)
        editor.putString("task listt", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("task listt", null)
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        filmler = gson.fromJson<Any>(json, type) as ArrayList<String>
        if (filmler == null) {
            filmler = ArrayList()
        }
    }
}