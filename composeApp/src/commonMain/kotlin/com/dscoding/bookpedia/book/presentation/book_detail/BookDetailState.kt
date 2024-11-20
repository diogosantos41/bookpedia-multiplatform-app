package com.dscoding.bookpedia.book.presentation.book_detail

import com.dscoding.bookpedia.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)