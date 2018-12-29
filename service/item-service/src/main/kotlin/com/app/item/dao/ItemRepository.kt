package com.app.item.dao

import com.app.item.domain.po.Item
import org.springframework.data.repository.CrudRepository

internal interface ItemRepository : CrudRepository<Item, Long> {

    fun findByUuid(uuid: String): List<Item>
    fun findByUuidIn(itemUuids: List<Long>): List<Item>

}