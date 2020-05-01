package com.systems.magora.paginationexample

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class MyDataSourceFactory(private val dataSource: MyDataSource) :
    DataSource.Factory<Int, Bascket>() {

    val liveData = MutableLiveData<MyDataSource>()
    override fun create(): DataSource<Int, Bascket> {
        liveData.postValue(dataSource)
        return dataSource
    }
}