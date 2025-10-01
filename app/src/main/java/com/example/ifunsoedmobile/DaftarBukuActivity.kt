package com.example.ifunsoedmobile.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifunsoedmobile.data.model.BookDoc
import com.example.ifunsoedmobile.databinding.ActivityDaftarBukuBinding
import com.example.ifunsoedmobile.ui.fragment.BookDetailFragment
import com.unsoed.informatikamobile.adapter.BookAdapter
import com.example.ifunsoedmobile.viewmodel.MainViewModel
import com.unsoed.informatikamobile.adapter.OnBookClickListener

class DaftarBukuActivity : AppCompatActivity(), OnBookClickListener {

    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter(
        emptyList(),
        onBookClickListener = this
    )

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

    override fun onBookClick(book: BookDoc) {
        book.let { b ->
            BookDetailFragment(
                b.title ?: "-",
                b.authorName?.joinToString(", ") ?: "Unknown Author",
                "${b.firstPublishYear ?: "-"}",
                b.coverId ?: 0
            ).show(supportFragmentManager, BookDetailFragment::class.java.simpleName)
        }
    }
}
