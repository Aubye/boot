package com.app.item.domain.model

import org.springframework.data.repository.CrudRepository

interface Repositories : CrudRepository<Article, Long> {
    fun findAllByAddedAtDesc(): Iterable<Article>
}

interface UserRepository : CrudRepository<User, String>