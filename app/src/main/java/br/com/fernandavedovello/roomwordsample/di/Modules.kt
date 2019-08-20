package br.com.fernandavedovello.roomwordsample.di

import androidx.room.Room
import br.com.fernandavedovello.roomwordsample.WordListAdapter
import br.com.fernandavedovello.roomwordsample.WordViewModel
import br.com.fernandavedovello.roomwordsample.dao.WordRoomDatabase
import br.com.fernandavedovello.roomwordsample.repository.WordRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModel = module{
    single { WordRepository(get()) }
}

val dbModule = module{
    single {  Room.databaseBuilder(
        get(),
        WordRoomDatabase::class.java,
        "Word_database"
    ).build() }

    single{get<WordRoomDatabase>().wordDao()}
}

val uiModule = module{
    factory { WordListAdapter(get()) }
}

val viewModelModule = module{
    viewModel{WordViewModel(get(), get())}
}