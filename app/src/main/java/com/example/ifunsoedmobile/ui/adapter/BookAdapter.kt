package com.unsoed.informatikamobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ifunsoedmobile.data.model.BookDoc
import com.example.ifunsoedmobile.databinding.ListBukuBinding

class BookAdapter(private var books: List<BookDoc>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    // ViewHolder menyimpan referensi ke elemen UI di layout list_buku.xml
    inner class BookViewHolder(val binding: ListBukuBinding) :
        RecyclerView.ViewHolder(binding.root)

    // Inflate layout item list_buku.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ListBukuBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return BookViewHolder(binding)
    }

    // Jumlah item yang akan ditampilkan
    override fun getItemCount(): Int = books.size

    // Menghubungkan data dengan tampilan
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.binding.tvTitle.text = book.title ?: "Tidak ada judul"
        holder.binding.tvAuthor.text = book.authorName?.joinToString(", ") ?: "Tidak ada penulis"
        holder.binding.tvYear.text = book.firstPublishYear?.toString() ?: "-"
    }

    // Update data adapter
    fun setData(newBooks: List<BookDoc>) {
        books = newBooks
        notifyDataSetChanged()
    }
}
