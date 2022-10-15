package com.tyrist.raf

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_dizi_kayit.*
import kotlinx.android.synthetic.main.activity_dizi_kayit.diziName
import kotlinx.android.synthetic.main.activity_kitap_kayit.*
import java.lang.reflect.Type
import kotlin.properties.Delegates

class kitapKayit : AppCompatActivity() {
    var kitaplar = ArrayList<String>()
    lateinit var isimss : String
    var k by Delegates.notNull<Boolean>()
    lateinit var sharedPreferences5 : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitap_kayit)

        sharedPreferences5 = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        k = sharedPreferences5.getBoolean("acildiii",true)
        ilkmi(k)
        loadData()
        buildrcycler()
    }
    fun ilkmi(x : Boolean){
        var b = x
        sharedPreferences5 = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        if (b == true){
            kitaplar.add("")
            saveData()
            b = false
            sharedPreferences5.edit().putBoolean("acildiii", b).apply()
        }
    }

    fun buildrcycler(){
        val layoutManager = LinearLayoutManager(this)
        kitapRecycler.layoutManager = layoutManager

        val adapter = RecyclerAdapter(kitaplar)
        kitapRecycler.adapter = adapter
    }

    fun kitapKayitFun(view: View){
        isimss = kitapName.text.toString()
        if(isimss == ""){

        }else if (isimss == " "){

        }else if (isimss == "  "){

        }else if(isimss == "   "){


        }else if(isimss == "    "){


        }else if(isimss == "     "){


        }else if(isimss == "      "){


        }else if(isimss == "       "){


        }else if(isimss == "        "){


        }else if(isimss == "         "){


        }else{
            kitaplar.add(isimss)
            kitapName.text.clear()
            buildrcycler()
        }
        saveData()
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(kitaplar)
        editor.putString("task listtt", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("com.tyrist.arsiv", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("task listtt", null)
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        kitaplar = gson.fromJson<Any>(json, type) as ArrayList<String>
        if (kitaplar == null) {
            kitaplar = ArrayList()
        }
    }
}