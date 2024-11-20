package com.dscoding.bookpedia.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.dscoding.bookpedia.book.data.database.DatabaseFactory
import com.dscoding.bookpedia.book.data.database.FavoriteBookDatabase
import com.dscoding.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.dscoding.bookpedia.book.data.network.RemoteBookDataSource
import com.dscoding.bookpedia.book.data.repository.DefaultBookRepository
import com.dscoding.bookpedia.book.domain.BookRepository
import com.dscoding.bookpedia.book.presentation.book_list.BookListViewModel
import com.dscoding.bookpedia.book.presentation.book_detail.BookDetailViewModel
import com.dscoding.bookpedia.book.presentation.SelectedBookViewModel


import com.dscoding.bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}