package com.systems.magora.paginationexample

import android.util.Log
import androidx.paging.ItemKeyedDataSource

class MyDataSource : ItemKeyedDataSource<Int, Bascket>() {
    private var offset:Int=0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Bascket>
    ) {
           val list = Storage.getSubList(0, count =params.requestedLoadSize)
        offset+=params.requestedLoadSize
        Log.d("mylog","loadInitial,offset=$offset")
        callback.onResult(list.apply { this.forEach{it.text+="  Initial"} })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Bascket>) {
        offset += params.requestedLoadSize
        Log.d("mylog","loadAfter, offset=$offset,Storage.listSize()=${Storage.listSize()},params.requestedLoadSize=${params.requestedLoadSize}")
        if(offset>0 && offset<Storage.listSize()){
            val list = Storage.getSubList(offset, offset+params.requestedLoadSize)
            callback.onResult(list.apply { this.forEach{it.text+="  After"} })
        }else{
            callback.onResult(listOf())
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Bascket>) {
         offset -= params.requestedLoadSize
        Log.d("mylog","loadBefore, offset=$offset,Storage.listSize()=${Storage.listSize()},params.requestedLoadSize=${params.requestedLoadSize}")
        if(offset>0 && offset<Storage.listSize()){
            val list = Storage.getSubList(offset, offset+params.requestedLoadSize)
            callback.onResult(list.apply { this.forEach{it.text+="  Before"} })
        }else{
            callback.onResult(listOf())
        }
        }

    override fun getKey(item: Bascket) = item.id

    private fun isValid(start:Int,end:Int) = start>=0 && end< Storage.listSize()

}