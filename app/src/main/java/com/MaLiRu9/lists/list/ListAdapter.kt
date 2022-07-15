package com.MaLiRu9.lists.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.MaLiRu9.lists.databinding.ItemListBinding
import com.MaLiRu9.lists.list.item.Item

class ListAdapter(
    var list: List<Item>,
    var moveHandler: ((item: Item, pos: Int) -> Unit),
    var editHandler: ((item: Item, pos: Int) -> Unit)
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.root.setOnClickListener { moveHandler(this, position) }
                binding.title.text = this.title
                binding.description.text = this.description
                binding.checkbox.isChecked = this.check
                binding.date.text = this.getFormattedDate()
                binding.editButton.setOnClickListener { editHandler(this, position) }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
