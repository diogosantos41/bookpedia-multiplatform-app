package com.dscoding.bookpedia.book.data.repository

import com.dscoding.bookpedia.book.data.mappers.toBook
import com.dscoding.bookpedia.book.data.network.RemoteBookDataSource
import com.dscoding.bookpedia.book.domain.Book
import com.dscoding.bookpedia.book.domain.BookRepository
import com.dscoding.bookpedia.core.domain.DataError
import com.dscoding.bookpedia.core.domain.Result
import com.dscoding.bookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query).map { dto ->
            dto.results.map { it.toBook() }
        }
    }
}