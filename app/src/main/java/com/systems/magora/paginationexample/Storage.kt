package com.systems.magora.paginationexample

import kotlin.random.Random

class Storage() {
    companion object {
        private val storage = generate()

        fun getSubList(from:Int,count:Int): List<Bascket> {
            return storage.subList(from,count)
        }

        fun listSize()= storage.count()

        private fun generate(): List<Bascket> {
            val list = mutableListOf<Bascket>()
            for (i in 0 until 100) {
                val numb=randomNumber()
                list.add(Bascket(id = i, text = "Text_$i"))
            }
            return list.sortedBy { it.id }
        }


        private fun randomNumber()=Random.nextInt(1000)
    }
}




