package uz.najottalim.testproject.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()

}