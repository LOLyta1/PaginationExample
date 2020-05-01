package com.systems.magora.paginationexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter(): PagedListAdapter<Bascket, MyAdapter.MyViewHolder>(MyDiffUtil()) {
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
       val idTextView=itemView.count_text_view
        val textTextView=itemView.text_text_view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.idTextView.text=getItem(position)?.id.toString()
        holder.textTextView.text=getItem(position)?.text
    }
}


