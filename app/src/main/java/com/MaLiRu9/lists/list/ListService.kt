package com.MaLiRu9.lists.list

import android.content.Context
import com.MaLiRu9.lists.storage.JsonService
import com.MaLiRu9.lists.list.item.Item
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class ListService constructor(val context: Context) {

    lateinit var toDoList:ToDoList

    init {
        getListFromFile()
    }

    fun getListFromFile() {
        val file = JsonService(context).getSelectedFile()
        val json = file.inputStream().bufferedReader().use { it.readText() }

        val gson = GsonBuilder().create()
        val itemType = object : TypeToken<List<Item>>() {}.type
        val list = gson.fromJson<List<Item>>(json, itemType)
        toDoList = ToDoList(file.nameWithoutExtension, list)
    }
}