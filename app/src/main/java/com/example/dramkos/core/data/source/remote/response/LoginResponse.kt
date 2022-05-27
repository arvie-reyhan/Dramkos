package com.example.dramkos.core.data.source.remote.response

import com.example.dramkos.core.data.source.model.User

data class LoginResponse(
    val code: Int? = null,
    val message: String? = null,
    val data: User? = null
)