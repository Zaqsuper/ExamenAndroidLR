package com.example.examenandroidlr

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroidlr.databinding.ItemHeroeBinding
import com.example.examenandroidlr.datares.HeroesResLite
import com.squareup.picasso.Picasso

class HeroeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHeroeBinding.bind(view)

    fun bind(heroe: HeroesResLite, itemClickListener: HeroeAdapter.OnHeroeClickListener) {
        itemView.setOnClickListener { itemClickListener.onItemClick(heroe.id)}
        Picasso.get().load(heroe.image).into(binding.ivHeroe)
        binding.tvHeroe.text = heroe.name
    }

}