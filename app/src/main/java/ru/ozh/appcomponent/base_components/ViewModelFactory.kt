package ru.ozh.appcomponent.base_components


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ozh.appcomponent.repository.Repository
import ru.ozh.appcomponent.main.MainActivityViewModel

/**
 * Init appropriate [ViewModel] for Activity
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {

    private val myRepository by lazy { Repository() }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(myRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}