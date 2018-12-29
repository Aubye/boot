package com.app.item.service

import com.app.item.domain.dto.ItemDTO

interface ItemService {

    fun list(): List<ItemDTO>
    fun findById(id: Long): ItemDTO

}