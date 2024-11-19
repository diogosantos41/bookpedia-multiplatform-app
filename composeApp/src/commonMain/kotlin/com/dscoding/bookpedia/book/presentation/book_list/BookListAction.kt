package com.dscoding.bookpedia.book.presentation.book_list

import com.dscoding.bookpedia.book.domain.Book

sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTabSelected(val tabIndex: Int): BookListAction
}