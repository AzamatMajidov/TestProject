package uz.najottalim.testproject.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar")
    val image: String,
    val email: String,
    val id: String,
    val name: String
)