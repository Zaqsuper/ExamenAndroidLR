package com.example.examenandroidlr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroidlr.databinding.ActivityMainBinding
import com.example.examenandroidlr.datares.HeroesResLite

class MainActivity : AppCompatActivity(), HeroeAdapter.OnHeroeClickListener{

    private lateinit var viewModel: MainViewModel
    private lateinit var binding:ActivityMainBinding
    private val heroeList: MutableList<HeroesResLite> = mutableListOf<HeroesResLite>()
    private lateinit var  adapter: HeroeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.statusError.observe(this, Observer {
            if (it == true) { showError() }
        })

        viewModel.heroeLiveList.observe(this, Observer {
            for(data in it){ heroeList.add(data) }
            adapter.notifyDataSetChanged()
        })

        with(binding){
            rvHeroes.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    val visibleItemCount = rvHeroes.layoutManager?.childCount
                    val pastVisibleItem = (rvHeroes.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    val total = adapter.itemCount
                    viewModel?.checkScroll(visibleItemCount, pastVisibleItem, total)
                    super.onScrolled(recyclerView, dx, dy)
                }
            })
        }

        viewModel.getRetrofit()
        initRecycleView()
        viewModel.getHeroeLite()
    }

    private fun initRecycleView() {
        adapter = HeroeAdapter(heroeList, this)
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        binding.rvHeroes.adapter = adapter
    }

    private fun showError() {
        Toast.makeText(this, "Error inesperado", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(id: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("idHeroe", id)
        startActivity(intent)
    }
}