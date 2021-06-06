package uz.najottalim.testproject.repository

import uz.najottalim.testproject.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()


}