package uz.najottalim.testproject.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import uz.najottalim.testproject.repository.MainRepository
import uz.najottalim.testproject.utils.Resource

class MainViewModel(private val mainRepository: MainRepository):
    ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Error"))
        }
    }

}