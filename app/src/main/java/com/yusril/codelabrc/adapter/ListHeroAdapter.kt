package com.yusril.codelabrc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yusril.codelabrc.R
import com.yusril.codelabrc.model.Hero
// Langkah 2
// Buat konstuktor  Array dari Model Hero -> private val listHero: ArrayList<Hero>
class ListHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    // Langkah 1
    // tambahkan  RecyclerView.ViewHolder-> alt+ enter pilih add constructor parameter from ViewHolder
    // class ini untuk menginisiasi view item
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    // Langkah 3
    // inisisasi item hero kemudian masukan ke listviewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero,parent,false)
        return ListViewHolder(view)
    }
    // Langkah 5 masukan data ke dalam item view
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        Glide.with(holder.itemView.context)
            .load(hero.photo)// ambil foto sesuai index
            .apply(RequestOptions().override(55,55))// ukuran
            .into(holder.imgPhoto)// masukan kedalam view

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail
    }

    // Langkah 4
    // ambil jumlah data pada listhero
    override fun getItemCount(): Int {
        return listHero.size
    }
}