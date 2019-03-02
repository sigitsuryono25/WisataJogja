package com.project.lauwba.wisatajogja

import android.content.Context
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class GaleriAdapter(url: Array<String>, context: Context) : RecyclerView.Adapter<GaleriAdapter.ViewHolder>() {

    var context: Context
    var url: Array<String>

    init {
        this.context = context
        this.url = url
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v: View

        v = LayoutInflater.from(parent.context).inflate(R.layout.activity_galeri_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return url.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
                .load(url.get(position))
                .into(holder.gambar)

        holder.gambar.setOnClickListener {
            loadgambar(url.get(position))
        }

    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var gambar: ImageView

        init {
            gambar = itemView!!.findViewById(R.id.gambar)

        }
    }


    fun loadgambar(url: String) {
        Log.i("GaleriAdapter.kt" +
                "", url);

        var layoutInflater: LayoutInflater
        var view: View
        var alb = AlertDialog.Builder(context)
        var gambarBesar: ImageView


        layoutInflater = LayoutInflater.from(context)
        view = layoutInflater.inflate(R.layout.lihat_gambar, null);
        gambarBesar = view.findViewById(R.id.gambarBesar)

        Glide
                .with(context)
                .load(url)
                .into(gambarBesar)

        alb.setView(view)

        var abls: AlertDialog
        abls = alb.create()
        abls.show()
    }
}
