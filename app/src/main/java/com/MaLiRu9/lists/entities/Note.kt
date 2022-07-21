package com.MaLiRu9.lists.entities

import com.MaLiRu9.lists.list.item.ItemTypes
import com.MaLiRu9.lists.list.item.SubItem
import java.time.Instant

class Note (
    val title: String,

    val type: ItemTypes = ItemTypes.basic,
    val check: Boolean = false,
    val creationDate: Long = Instant.now().toEpochMilli(),
    val modificationDate: Long = Instant.now().toEpochMilli(),

    val description: String? = null,
    val location: String? = null,
    val scheduledDate: Long? = null,
    val labels: List<String> = emptyList(),

    val media: String? = null,
    val list: List<SubItem>? = emptyList()
)