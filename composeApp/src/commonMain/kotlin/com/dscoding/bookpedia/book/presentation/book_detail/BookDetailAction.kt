package com.dscoding.bookpedia.book.presentation.book_detail

import com.dscoding.bookpedia.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}