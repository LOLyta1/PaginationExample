package com.systems.magora.paginationexample

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class MyRepository(private val myDataSourceFactory: MyDataSourceFactory) {
    fun getTweets(): LiveData<PagedList<Bascket>> {
        val result = myDataSourceFactory
        return LivePagedListBuilder(result, pagedListConfig()).build()
    }

    private fun pagedListConfig() = PagedList.Config.Builder()
        .setInitialLoadSizeHint(10)
        //.setEnablePlaceholders(true)
        .setPageSize(10)
        .build()
}
