package com.systems.magora.paginationexample

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil: DiffUtil.ItemCallback<Bascket>() {
    override fun areItemsTheSame(oldItem: Bascket, newItem: Bascket): Boolean {
       return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Bascket, newItem: Bascket): Boolean {
        return newItem.equals(oldItem)
    }
}