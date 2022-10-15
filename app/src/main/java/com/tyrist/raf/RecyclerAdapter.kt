package com.tyrist.raf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.recycler_row.view.*
import java.security.AccessController.getContext
import kotlin.coroutines.coroutineContext

class RecyclerAdapter(val diziadlariLis : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.dizikayit>() {
    class dizikayit(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dizikayit {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return dizikayit(itemView)
    }

    override fun onBindViewHolder(holder: dizikayit, position: Int) {
        holder.itemView.diziIsmi.text = diziadlariLis.get(position)

        holder.itemView.remove.setOnClickListener {
            diziadlariLis.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,diziadlariLis.size)
           Toast.makeText(holder.itemView.context, "Please Click the save button", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
      return diziadlariLis.size
    }


}