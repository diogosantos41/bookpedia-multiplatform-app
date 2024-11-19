package com.dscoding.bookpedia.book.domain

import com.dscoding.bookpedia.core.domain.DataError
import com.dscoding.bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}