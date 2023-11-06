package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.Pahlawan
import com.example.recycler.databinding.ActivityMainBinding
import com.example.tugas_recycler_view.DisasterAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var napoleon: String
    private lateinit var abraham: String
    private lateinit var tesla: String
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        napoleon = getString(R.string.deskripsi_napoleon)
        abraham = getString(R.string.deskripsi_abraham)
        tesla = getString(R.string.deskripsi_tesla)

        fun generateDummy(): List<Pahlawan> {
            return listOf(
                Pahlawan(namaPahlawan = "Napoleon Bonaparte", gambarPahlawan = R.drawable.pahlawan1, deskripsiPahlawan = napoleon),
                Pahlawan(namaPahlawan = "Abraham Lincoln", gambarPahlawan = R.drawable.pahlwan2, deskripsiPahlawan = abraham),
                Pahlawan(namaPahlawan = "Nikola Tesla", gambarPahlawan = R.drawable.pahlawan3, deskripsiPahlawan = tesla),
            )
        }

        val adapterPahlawan = DisasterAdapter(generateDummy()){
                pahlawan ->  Toast.makeText(this, "${pahlawan.namaPahlawan}",
            Toast.LENGTH_SHORT).show()
        }
        with(binding){
            recycle.apply {
                adapter = adapterPahlawan
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}