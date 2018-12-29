package com.app.item.service.impl

import com.app.item.dao.ItemRepository
import com.app.item.domain.dto.ItemDTO
import com.app.item.service.ItemService
import org.modelmapper.ModelMapper
import org.modelmapper.TypeToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class ItemServiceImpl : ItemService {

    @Autowired
    lateinit var itemRepository: ItemRepository

    @Autowired
    lateinit var modelMapper: ModelMapper

    private var itemListType = object : TypeToken<List<ItemDTO>>(){}.type

    override fun list(): List<ItemDTO> {
        return modelMapper.map<List<ItemDTO>>(itemRepository.findAll(), itemListType)
    }

    override fun findById(id: Long): ItemDTO {
        return modelMapper.map<ItemDTO>(itemRepository.findById(id), ItemDTO::class.java)
    }

}