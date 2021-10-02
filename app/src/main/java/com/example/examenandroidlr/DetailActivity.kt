package com.example.examenandroidlr

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.examenandroidlr.databinding.ActivityHeroeDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding:ActivityHeroeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.statusError.observe(this, Observer {
            if (it == true) { showError() }
        })

        if(intent.extras!=null){
            if(intent.getStringExtra("idHeroe")!=null){
                viewModel.getHeroeAll(intent.getStringExtra("idHeroe")!!)
            }
        }
        viewModel.getRetrofit()
    }

    private fun showError() {
        Toast.makeText(this, "Error inesperado", Toast.LENGTH_SHORT).show()
    }
}