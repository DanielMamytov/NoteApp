package com.example.noteapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.data.models.NoteModel
import com.example.noteapp.databinding.ItemNoteBinding
import com.example.noteapp.ui.interfaces.onItemClickers

class NoteAdapter(
    private val onLongClickers: onItemClickers,
    private val onClickItem: onItemClickers
): ListAdapter<NoteModel, NoteAdapter.ViewHolder>(Diffcallback()) {
    class ViewHolder(private val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoteModel){
            binding.txtTitle.text = item.title
            binding.txtDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteAdapter.ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnLongClickListener {
            onLongClickers.onLongClick(getItem(position))
            true
        }

        holder.itemView.setOnClickListener {
            onClickItem.onClick(getItem(position))
        }
    }

    class Diffcallback: DiffUtil.ItemCallback<NoteModel>(){
        override fun areItemsTheSame(
            oldItem: NoteModel,
            newItem: NoteModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NoteModel,
            newItem: NoteModel
        ): Boolean {
            return oldItem == newItem
        }

    }
}