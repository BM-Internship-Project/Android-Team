package com.example.speedotransferapp.api
import com.example.speedotransferapp.constant.AppConstants.BALANCE_ENDPOINT
import com.example.speedotransferapp.constant.AppConstants.LOGIN_ENDPOINT
import com.example.speedotransferapp.constant.AppConstants.NAME_ENDPOINT
import com.example.speedotransferapp.constant.AppConstants.REGISTER_ENDPOINT
import com.example.speedotransferapp.data.LogoutData
import com.example.speedotransferapp.model.BalanceResponse
import com.example.speedotransferapp.model.LoginRequest
import com.example.speedotransferapp.model.LoginResponse
import com.example.speedotransferapp.model.LogoutResponse
import com.example.speedotransferapp.model.NameData
import com.example.speedotransferapp.model.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserAPICallable {

    @POST(REGISTER_ENDPOINT)
    suspend fun registerUser(
        @Body registerRequest: RegisterRequest
    ): Long

    @POST(LOGIN_ENDPOINT)
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @POST(LOGIN_ENDPOINT)
    suspend fun logoutUser(
        @Body logoutRequest: LogoutData.LogoutRequest
    ): LogoutResponse

    @GET(BALANCE_ENDPOINT)
     fun getBalance(
        @Header("Authorization") token: String
    ): BalanceResponse

    @GET(NAME_ENDPOINT)
    suspend fun getName(
        @Header("Authorization") token: String
    ): NameData
}