package com.example.dramkos.core.data.source.remote

import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.core.data.source.remote.network.ApiService
import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.core.data.source.remote.request.RegisterRequest
import com.example.dramkos.util.getAdminId
import okhttp3.MultipartBody

class RemoteDataSource(private val api: ApiService) {

    suspend fun userLogin(data: LoginRequest) = api.userLogin(data)
    suspend fun adminLogin(data: LoginRequest) = api.adminLogin(data)

    suspend fun userRegister(data: RegisterRequest) = api.userRegister(data)
    suspend fun adminRegister(data: RegisterRequest) = api.adminRegister(data)

    suspend fun getKos() = api.getKos()
    suspend fun createKos(data: Kos) = api.createKos(data)
    suspend fun updateKos(data: Kos) = api.updateKos(data.id, data)
    suspend fun deleteKos(data: Kos) = api.deleteKos(data.id)
}