package br.com.fernandavedovello.roomwordsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.fernandavedovello.roomwordsample.model.Word
import br.com.fernandavedovello.roomwordsample.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application,
                    val repositoryModel: WordRepository) : AndroidViewModel(application) {

    val allWords: LiveData<List<Word>> = repositoryModel.allWords

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repositoryModel.insert(word)
    }
}