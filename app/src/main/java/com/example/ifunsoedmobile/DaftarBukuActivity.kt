package com.example.ifunsoedmobile.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifunsoedmobile.databinding.ActivityDaftarBukuBinding
import com.unsoed.informatikamobile.adapter.BookAdapter
import com.example.ifunsoedmobile.viewmodel.MainViewModel

class DaftarBukuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aktifkan view binding
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // siapkan RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // observe LiveData dari ViewModel
        viewModel.books.observe(this) { daftarBuku ->
            adapter.setData(daftarBuku)
        }

        // panggil API dengan keyword pencarian
        viewModel.fetchBooks("kotlin programming")
    }
}
