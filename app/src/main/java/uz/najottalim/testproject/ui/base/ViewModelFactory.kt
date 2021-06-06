package uz.najottalim.testproject.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.najottalim.testproject.api.ApiHelper
import uz.najottalim.testproject.repository.MainRepository
import uz.najottalim.testproject.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}