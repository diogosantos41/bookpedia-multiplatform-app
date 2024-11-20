package com.dscoding.bookpedia.book.data.network

import com.dscoding.bookpedia.book.data.dto.BookWorkDto
import com.dscoding.bookpedia.book.data.dto.SearchedResponseDto
import com.dscoding.bookpedia.core.domain.DataError
import com.dscoding.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchedResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>

}