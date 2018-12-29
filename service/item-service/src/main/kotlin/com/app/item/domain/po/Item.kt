package com.app.item.domain.po

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
internal data class Item (

    @Id
    @GeneratedValue
    var id: Long? = null,
    var uuid: String? = null,
    var type: String? = null,
    var name: String? = null,
    var price: BigDecimal? = null,
    var description: String? = null

)
