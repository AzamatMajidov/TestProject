package uz.najottalim.testproject.api

import retrofit2.http.GET
import uz.najottalim.testproject.model.User

interface ApiService {

    @GET("users/")
    suspend fun getUsers(): List<User>

}