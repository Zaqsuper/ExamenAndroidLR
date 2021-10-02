package com.example.examenandroidlr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroidlr.datares.HeroesResLite

class HeroeAdapter(
    private var heroes:MutableList<HeroesResLite>,
    private val itemClickListener:OnHeroeClickListener
    ):RecyclerView.Adapter<HeroeViewHolder>() {

    interface OnHeroeClickListener{
        fun onItemClick(id: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroeViewHolder(layoutInflater.inflate(R.layout.item_heroe, parent, false))
    }

    override fun onBindViewHolder(holder: HeroeViewHolder, position: Int) {
        val item = heroes[position]
        holder.bind(item, itemClickListener)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }
}