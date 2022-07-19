package com.MaLiRu9.lists.list

import android.content.Context
import android.util.Log
import com.MaLiRu9.lists.json.JsonService
import com.MaLiRu9.lists.list.item.Item
import com.google.gson.GsonBuilder
import org.json.JSONArray
import java.io.IOException

class ListService constructor(val context: Context) {

    var list = mutableListOf<Item>()

    init {
        getListFromFile()
    }

    fun getListFromFile() {
        val file = JsonService(context).getSelectedFile()
        val json = file.inputStream().bufferedReader().use { it.readText() }

        val gson = GsonBuilder().create()
        list = gson.fromJson(json, MutableList<Item>)
    }
}