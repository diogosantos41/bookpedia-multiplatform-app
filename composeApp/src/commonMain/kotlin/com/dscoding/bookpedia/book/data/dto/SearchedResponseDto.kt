package com.dscoding.bookpedia.book.data.dto

import kotlinx.serialization.SerialName

data class SearchedResponseDto(
    @SerialName("docs")
    val results: List<SearchedBookDto>
)
