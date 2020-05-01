package com.systems.magora.paginationexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter=MyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.adapter = adapter

        val pagedList = MyRepository(MyDataSourceFactory(MyDataSource())).getTweets()
        pagedList.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
